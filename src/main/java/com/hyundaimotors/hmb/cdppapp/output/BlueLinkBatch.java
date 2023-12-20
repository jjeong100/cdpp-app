package com.hyundaimotors.hmb.cdppapp.output;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.PlatformTransactionManager;

import com.hyundaimotors.hmb.cdppapp.dto.bluelinkMileageDto;
import com.hyundaimotors.hmb.cdppapp.mapper.BluelinkMapper;

import lombok.RequiredArgsConstructor;

@EnableScheduling
@Configuration
@RequiredArgsConstructor
@EnableBatchProcessing
public class BlueLinkBatch {
    
    @Autowired
	private JobLauncher jobLauncher;

    @Autowired 
    public SqlSessionFactory sqlSessionFactory;

    @Autowired
    private BluelinkMapper mapper; 
    
    @Bean
    public Job testSimpleJob(JobRepository jobRepository, Step testStep, Step testStep01){
        return new JobBuilder("testSimpleJob14", jobRepository)
                .start(testStep)
                .next(testStep01)
                .build();

    }

    @Bean
    public Step testStep(JobRepository jobRepository, Tasklet testTasklet, PlatformTransactionManager platformTransactionManager){
        return new StepBuilder("testStep14", jobRepository)
                .tasklet(testTasklet, platformTransactionManager).build();
    }

    @Bean
    public Step testStep01(JobRepository jobRepository, Tasklet testTasklet01, PlatformTransactionManager platformTransactionManager){
        return new StepBuilder("testStep014", jobRepository)
                .tasklet(testTasklet01, platformTransactionManager).build();
    }

    @Bean
    public Tasklet testTasklet(){
        return ((contribution, chunkContext) -> {
            bluelinkMileageDto dto = new bluelinkMileageDto();

            mapper.updateProcessBlueLink(dto);

            return RepeatStatus.FINISHED ;
        });
    }

    @Bean
    public Tasklet testTasklet01(){
        return ((contribution, chunkContext) -> {

            bluelinkMileageDto dto = new bluelinkMileageDto();

            mapper.updateReplicaBlueLink(dto);

            return RepeatStatus.FINISHED ;
        });
    }


    //@Scheduled(cron = "0 */5 * * * *") // 매 시간 실행 (크론 표현식)
    public void runRestApiJob() {
        JobExecution jobExecution;
        try {
            jobExecution = jobLauncher.run(testSimpleJob(null,null,null), new JobParameters());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
