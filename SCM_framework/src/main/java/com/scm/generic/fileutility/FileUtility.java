package com.scm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	public String getDataFromProp(String key) throws IOException
	{
	
	FileInputStream fis = new FileInputStream("./src/main/resources/datadriven.properties");
	Properties pobj = new Properties();
	pobj.load(fis);
	String value = pobj.getProperty(key);
	return value;

	}

}
