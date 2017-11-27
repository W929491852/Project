package com.qf.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fileutils {
	
	
public static File getFile(String path){
	File file=new File(path);
	return file.getParentFile();
	}

public static File getpath(File file ,String filename){
	SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
	File f=new File(file,File.separator+"files"+File.separator+sd.format(new Date()));
	if(!f.exists()){
		f.mkdirs();
	}
	f=new File(f,System.currentTimeMillis()+"-"+Math.round((Math.ceil(Math.random()*900+100)))+filename);
	return f;
	
	
}


}
