package util;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Utility {

	//Read data from configurable property file
	public static String fetchPropertyValue( String key) throws IOException
	{
		FileInputStream File = new FileInputStream(System.getProperty("user.dir") + "/Config/config.properties");

		Properties property = new Properties() ;
		property.load(File);
		return property.get(key).toString();

	}

	public static String fetchlocatorValue( String key) throws IOException
	{
		FileInputStream File = new FileInputStream(System.getProperty("user.dir") + "/Config/Elements.properties");
		Properties property = new Properties() ;
		property.load(File);
		return property.get(key).toString();

	}

}
