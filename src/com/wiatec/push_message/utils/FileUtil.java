package com.wiatec.push_message.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.wiatec.push_message.Constant;

public class FileUtil {
	
	public static boolean upload(File file ,String fileFileName){
		boolean flag = false;
		if(file == null || fileFileName == null){
			return flag;
		}
		File file1 = new File(Constant.IMAGE_PATH);
		if(!file1.exists()){
			file1.mkdir();
		}
		String dir = Constant.IMAGE_PATH + fileFileName;
		FileOutputStream fileOutputStream = null;
		FileInputStream fileInputStream = null;
		try {
			fileOutputStream = new FileOutputStream(dir);
			fileInputStream = new FileInputStream(file);
			byte [] buffer = new byte[1024];
			int length = 0 ;
			while((length = fileInputStream.read(buffer)) != -1){
				fileOutputStream.write(buffer , 0 , length);
			}
			flag = true;
			Runtime.getRuntime().exec("chmod 755 " + dir);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			flag = false;
		} catch (IOException e) {
			e.printStackTrace();
			flag = false;
		}finally{
			try {
				if(fileOutputStream != null){
					fileOutputStream.close();
				}
				if(fileInputStream != null){
					fileInputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}


}
