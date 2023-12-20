package com.hyundaimotors.hmb.cdppapp.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyundaimotors.hmb.cdppapp.dto.IFHMBINNOCEANCDPP0019Dto;
import com.hyundaimotors.hmb.cdppapp.mapper.IFHMBINNOCEANCDPP0019Mapper;
import com.hyundaimotors.hmb.cdppapp.service.IFHMBINNOCEANCDPP0019Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IFHMBINNOCEANCDPP0019ServiceImpl implements IFHMBINNOCEANCDPP0019Service{

    private final IFHMBINNOCEANCDPP0019Mapper mapper;

    public List<IFHMBINNOCEANCDPP0019Dto> getList(IFHMBINNOCEANCDPP0019Dto dto)throws Exception{
        List<IFHMBINNOCEANCDPP0019Dto> resultList = new ArrayList<>();

        resultList = mapper.getList(dto);
        
        List<String> daysList           = new ArrayList<String>();
        List<String> holyDayList        = new ArrayList<>();
        List<String> MaintenanceDayList = new ArrayList<>();
        List<String> weekDayList        = new ArrayList<>();

        holyDayList        = mapper.getHolyDayList(dto);
        MaintenanceDayList = mapper.getMaintenanceDayList(dto);
        weekDayList        = mapper.getWeekDayList(dto);
        
        daysList.addAll(holyDayList);
        daysList.addAll(MaintenanceDayList);
        
        Calendar cal = Calendar.getInstance();

        int year  = Integer.parseInt(dto.getYear());
        int month = Integer.parseInt(dto.getMonth());

        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);

        cal.set(year,month-1,1);

        int end = cal.getActualMaximum(Calendar.DATE); //해당 월 마지막 날짜
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //해당 날짜의 요일(1:일요일 … 7:토요일)
        
        String getYear  = dto.getYear();
        String getMonth = month>9?""+month:"0"+month;
        
        List<Integer> days = new ArrayList<Integer>();//일자
        Map<Integer,String> schedule = new HashMap<Integer,String>();//스케줄

        /**
         * 처리
         * 1. 주말 일정 N , 평일 Y
         * 2. holyDayList 입력된 날짜는 N
         * 3. MaintenanceDayList 입력된 날짜는 N
         * 4. weekDayList 입력된 날짜는 이외 N <= 주의.(2,3처리 무시?)
         * 5. 오늘 이전일 처리 N
         * 6. 결과 처리
         */
        
        /**
         * 1.주말 일정 N , 평일 Y
         * 입력 일자 N 처리
         */
        for(int index=1; index<=end; index++) {
            if(dayOfWeek%7==0 || dayOfWeek%7==1) {
                schedule.put(index, "N");
            }else {
                schedule.put(index, "Y");
            }
            days.add(index);
            dayOfWeek++;
        }
        
        /**
         * 2.holyDayList 처리
         * 입력 일자 N 처리
         */
        for(int index=0;index<holyDayList.size();index++) {
            int day = Integer.parseInt(holyDayList.get(index));
            schedule.put(day, "N");
        }
        
        
        /**
         * 3.MaintenanceDayList 처리
         * 입력 일자 N 처리
         */
        for(int index=0;index<MaintenanceDayList.size();index++) {
            int day = Integer.parseInt(MaintenanceDayList.get(index));
            schedule.put(day, "N");
        }
        
        /**
         * 4.weekDayList 입력된 날짜는 이외 N
         * 입력 일자 Y 이외 처리 전체 일자 N
         * weekDay가 존재하면 위의 처리 무시?
         */
        if(weekDayList.size() > 0) {
        	schedule.clear();
            Map<Integer,String> weekDayMap = new HashMap<Integer,String>();
            for(int index=1; index<=end; index++) weekDayMap.put(index, "N");
            for(int index=0;index<weekDayList.size();index++) {
                int day = Integer.parseInt(weekDayList.get(index));
                weekDayMap.put(day, "Y");
            }
            schedule = weekDayMap;
        }
        
        /**
         * 5.오늘 이전일 처리 N
         * 결과 처리
         */
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String toDay = dateFormat.format(new Date(System.currentTimeMillis()));
        
        for(int index=0;index<days.size();index++) {
            IFHMBINNOCEANCDPP0019Dto resultDto = new IFHMBINNOCEANCDPP0019Dto();
            int key = days.get(index);
            String inDate = getYear + getMonth + (key>9?""+key:"0"+key);
            Date srcDate = new Date(dateFormat.parse(toDay).getTime());
            Date tarDate = new Date(dateFormat.parse(inDate).getTime());
            
            resultDto.setDescription(String.valueOf(key));
            //현재일 보다 작은 일자 처리.
            if(tarDate.compareTo(srcDate) == -1) resultDto.setAvailable("N");
            else resultDto.setAvailable(schedule.get(key));
            
            resultList.add(resultDto);
        }
        
        return resultList;
    }
}