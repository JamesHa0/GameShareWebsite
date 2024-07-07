package crf.util;

import java.util.Properties;

public class PropertiesUtil {
	public static Properties prop = new Properties();
	public static Properties dbProp = new Properties();
	
	public static String getValue(String key) {
		return prop.getProperty(key);
	}

	public static void setValue(String key, String value) {
		prop.setProperty(key, value);
	}
}
