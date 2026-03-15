package com.nandini.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    Properties prop;
    
    public ConfigReader()
    {
        prop= new Properties();
        try
        {
            FileInputStream fileS = new FileInputStream("src/test/resources/config.properties");
            prop.load(fileS);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
    
    }
    public String getProperty(String key) {
        return prop.getProperty(key);
    }

}
