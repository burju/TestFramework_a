package com.hrmsutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {
    static Properties propertiesfile;

    /**]
     * reads any property file
     * @param filePath
     * @return  type Properties
     */
    public static Properties readProperties(String filePath){

        //Set the Path first as a parameter to the function

        try {
            FileInputStream fis = new FileInputStream(filePath);
            propertiesfile = new Properties();
            propertiesfile.load(fis);
            fis.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return propertiesfile;

    }

// a method that retrieve the value of a specified key

    /**
     *
     * @param key
     * @return
     */
    public static String getPropertyValue(String key){

        return propertiesfile.getProperty(key);
    }


    //create a seperate class and store any functins& common methods to use our webdriver.still inUtils folder..

}
