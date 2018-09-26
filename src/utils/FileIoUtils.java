package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public  class FileIoUtils {
	/*private static  String MessageFile = "D:/java/web/Message/";
	private  static String portraitgeFile = "D:/java/web/WebContent/portrait/";
	private static String DynamicText = "D:/java/web/Dynamic/";*/
	
	private static  String MessageFile = "/usr/local/apache-tomcat-7.0.57/Message/";
	private  static String portraitgeFile = "/usr/local/apache-tomcat-7.0.57/webapps/web/portrait/";
	private static String DynamicText = "/usr/local/apache-tomcat-7.0.57/Dynamic/";

	public static String saveTest(String str,String uuid,String filepath){
		String filePath = filepath+uuid+".txt";
		File file = new File(filePath);
		if(!file.exists()){
			file.getParentFile().mkdir();
		}
		OutputStream os = null;
		try {
			byte[] date = str.getBytes();
			os = new FileOutputStream(file,false);
			os.write(date,0,date.length);
			file.createNewFile();
			os.flush();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			try {
				os.close();
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}
		try {
			os.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return filePath;
	}
	
	
	public static String ReadFileTest(String filepath){
		  String fileContent = ""; 
		   try {  
		    File f = new File(filepath); 
		    if(f.isFile()&&f.exists()){ 
		     InputStreamReader read = new InputStreamReader(new FileInputStream(f),"UTF-8"); 
		     BufferedReader reader=new BufferedReader(read); 
		     String line; 
		     while ((line = reader.readLine()) != null) { 
		      fileContent += line; 
		     }   
		     read.close(); 
		    } 
		   } catch (Exception e) { 
		    System.out.println("读取文件内容操作出错"); 
		    e.printStackTrace(); 
		   } 
		   return fileContent;
	}

	
	
	
	public static List<String> ReadFileTestLine(String filepath){
		List<String> mytest = new ArrayList<String>(); 
		   try {  
		    File f = new File(filepath); 
		    if(f.isFile()&&f.exists()){ 
		     InputStreamReader read = new InputStreamReader(new FileInputStream(f),"UTF-8"); 
		     BufferedReader reader=new BufferedReader(read); 
		     String line; 
		     while ((line = reader.readLine()) != null) { 
		    	 mytest.add(line);
		     }   
		     read.close(); 
		    } 
		   } catch (Exception e) { 
		    System.out.println("读取文件内容操作出错"); 
		    e.printStackTrace(); 
		   } 
		   
		   
		   return mytest;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



	public static String getMessageFile() {
		return MessageFile;
	}


	public static void setMessageFile(String messageFile) {
		MessageFile = messageFile;
	}


	public static String getPortraitgeFile() {
		return portraitgeFile;
	}


	public static void setPortraitgeFile(String portraitgeFile) {
		FileIoUtils.portraitgeFile = portraitgeFile;
	}




	public static String getDynamicText() {
		return DynamicText;
	}


	public static void setDynamicText(String dynamicText) {
		DynamicText = dynamicText;
	}


	
	
	

	
}
