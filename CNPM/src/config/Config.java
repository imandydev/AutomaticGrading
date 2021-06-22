package config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {
//	Ä‘á»�c file config
public static int readFileConfigInt(String key) {
	FileReader reader = null;
	String result = "0";
	try {
		reader = new FileReader("config/config.properties");
		
	} catch (FileNotFoundException e1) {
		e1.printStackTrace();
	}
	 Properties properties = new Properties();
     try {
		properties.load(reader);
		result = properties.getProperty(key);
		if (result == null) {
			result = "0";
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
     return Integer.parseInt(result);
}
public static String readFileConfigStr(String key)  {
	 FileReader reader = null;
	try {
		reader = new FileReader("config/config.properties");
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	 Properties properties = new Properties();
     try {
		properties.load(reader);
	} catch (IOException e) {
		e.printStackTrace();
	}
     return properties.getProperty(key);
}
}
