package com.utils;

import java.io.File;
import java.util.Random;

public class FileUtil {

	public static File getFile(String path) {
		// TODO Auto-generated method stub
		File file=new File(path,"upload");
		if(!file.exists()) {
			file.mkdirs();
		}
		return file;
	}

	public static File getPath(File file, String name1) {
		// TODO Auto-generated method stub
		String str=System.currentTimeMillis()+"_"+new Random().nextInt(1000)+"_"+name1;
		File file1=new File(file,str);
		return file1;
	}

	public static void deleteFile(String fileName) {
		// TODO Auto-generated method stub
		File file=new File(fileName);
		file.delete();
	}

}
