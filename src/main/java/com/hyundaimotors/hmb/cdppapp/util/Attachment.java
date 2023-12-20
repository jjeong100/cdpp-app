package com.hyundaimotors.hmb.cdppapp.util;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.client.RestTemplate;

public class Attachment {
    
    public static byte[] uploadFile(String fileUrl) {
        byte[] result = null;
        
        try {
//            String srcFileName = URLDecoder.decode(fileUrl, StandardCharsets.UTF_8);
            
            File file = new File(fileUrl);
            if(!file.isFile()) {
//                 System.out.println("파일 아닙니다.!.");
                 return null;
            }else {
                result = FileCopyUtils.copyToByteArray(file);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return result;
         
    }
    
    /**
     * 
     */
    public void fileUploadWithThumbnail(String attach_file_seq, String file_path, String user_id, String thumbnail)  {
    	
    	// 타임아웃 설정
    	HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
    	factory.setConnectTimeout(5000); // 타임아웃 설정 5초
    	factory.setReadTimeout(5000); // 타임아웃 설정 5초
    	 
    	// RestTemplate 객체 생성
    	RestTemplate restTemplate = new RestTemplate(factory);
    	
    	File uploadFile = new File(file_path);
        MultipartEntityBuilder builder = MultipartEntityBuilder.create() //객체 생성
                .setCharset(Charset.forName("UTF-8")) //인코딩을 UTF-8로
                .setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        builder.addPart("file", new FileBody(uploadFile)); //빌더에 FileBody 객체에 인자로 File 객체를 넣어준다.
        builder.addTextBody("attach_file_seq", attach_file_seq, ContentType.create("Multipart/related", "UTF-8"));
        builder.addTextBody("user_id", user_id, ContentType.create("Multipart/related", "UTF-8"));
//
//
        builder.addTextBody("thumbnail", thumbnail, ContentType.create("Multipart/related", "UTF-8"));
        
        HttpEntity multipart = builder.build();
        
//        multipart
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
//        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//        HttpEntity<String> entity = new HttpEntity<String>(headers);
//        ResponseEntity<byte[]> restTemplateResponse =   restTemplate.exchange(uri, HttpMethod.GET, entity, byte[].class);
//        URI uri = new URI();
        
//        ResponseEntity<byte[]> restTemplateResponse = restTemplate.exchange(uri, HttpMethod.GET, multipart, byte[].class);
//        restTemplateResponse.getBody()
       

//        try {
//            InputStream inputStream = null;
//            HttpClient httpClient = new DefaultHttpClient();
//            HttpPost post = new HttpPost(server_domain + "/file/fileUploadDisk.json"); //전송할 URL
//            HttpEntity multipart = builder.build();
//            post.setEntity(multipart);
//            HttpResponse httpResponse = httpClient.execute(post);
//            HttpEntity httpEntity = httpResponse.getEntity();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    
    
    public static void downloadFile(String filename, byte[] bFile) {
    	
    	// File Operation
//      InputStream input = null;
//      OutputStream output = null;
//      try {
//          File targetDir = new File(bFile);
//          
//          File file  = new File(targetDir, realFileName);
////          log.info("file info ===>"+ file.toString());
//          
//          input = new FileInputStream(file);
//          output = response.getOutputStream();
//          
//          String contentDisposition = getDisposition(saveFileName, getBrowser(request));
//          response.addHeader("Content-disposition", contentDisposition);
//          response.setHeader("Content-Length", String.valueOf(file.length()));
//          response.setContentType(new MimetypesFileTypeMap().getContentType(file));
//          FileCopyUtils.copy(input, output);
//          
//          output.flush();
//      } catch (IOException e) {
//          e.printStackTrace();
//      } finally {
//          if (input != null) { try { input.close(); } catch (IOException ioe) { /* */ } }
//          if (output != null) { try { output.close(); } catch (IOException ioe) { /* */ } }
//      }
      
//      log.info("saveFileName ===>"+saveFileName);
  }
    
    /**
     * 
     * @param filename
     * @param pData
     */
    public static void writeToFile(String filename, byte[] pData) {
        if(pData == null) return;

        int lByteArraySize = pData.length;
        System.out.println(filename);

        try{
        	File folder = new File("D:/Downloads/test/");
        	if(!folder.isDirectory()) {
        		folder.mkdirs();
        	}
        	
            File lOutFile = new File(folder.getPath()+File.separator+filename);
            FileOutputStream lFileOutputStream = new FileOutputStream(lOutFile);
            lFileOutputStream.write(pData);
            lFileOutputStream.close();
        }catch(Throwable e){
            e.printStackTrace(System.out);
        }
    }
    
    public static void SaveFile(String folder,String filename,byte[] data){
    	
    	try {
    		int bytesRead;
    		File filePath = new File(folder,filename); // 복사하고 싶은 경로, 저장하고싶은 파일명
    		FileOutputStream fos = new FileOutputStream(filePath); 
    		fos.write(data); //바이너리 데이터 data를 파일에 쓴다
			fos.flush();
    		fos.close();
    	}catch (Exception e) {
			// TODO: handle exception
		}
    }
}
