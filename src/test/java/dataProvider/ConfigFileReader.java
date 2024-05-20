package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath= "configs//Configuration.properties";

	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getDriverPath(){
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
	public String runInAlreadyOpenBrowser(){
        String runOption = properties.getProperty("RunInAlreadyOpenBrowser");
        if(runOption!= null) return runOption;
        else throw new RuntimeException("Can't Run in Already Open Browser");  
    }
	
	public String getHeadlessValue() {
		String driverPath = properties.getProperty("headless");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");	
	}
	
	
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
	}
	
	public String getApplicationUrl() {
		String URL = properties.getProperty("URL");
		if(URL != null) return URL;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public String getloginValue(){
        String login = properties.getProperty("login");
        if(login!= null) return login;
        else throw new RuntimeException("login not specified in the Configuration.properties file.");   
    }

}