package com.scm.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	/**
	 * read the file path of the excel and properties from the properties file
	 * @return 
	 * @throws IOException 
	 */
public String getFilepathFromPropertyFile(String key) throws IOException {
	FileInputStream fis=new FileInputStream("./Configeration/FilePath.properties");
	Properties p=new Properties();
	p.load(fis);
	String filePath=p.getProperty(key);
	return filePath;
	
}

public String getValueOfEnvirmentalData(String path,String key) throws IOException {
	FileInputStream fis=new FileInputStream(path);
	Properties p=new Properties();
	p.load(fis);
	String url=p.getProperty(key);
	return url;
	
}
}
