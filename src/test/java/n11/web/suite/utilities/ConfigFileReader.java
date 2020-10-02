package n11.web.suite.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    private final String propertyFilePath = "src\\test\\resources\\configfile.properties";

    public ConfigFileReader() throws FileNotFoundException {
        BufferedReader fileReader;
        try {
            fileReader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(fileReader);
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("configfile.properties is not found at " + propertyFilePath);
            throw e;

        }
    }
    public String getApplicationURL(){
        String siteURL = properties.getProperty("applicationURL");
        if(siteURL != null)
            return siteURL;
        else return null;
    }
    public String getLoginEmail(){
        String loginEmail = properties.getProperty("loginEmail");
        if(loginEmail != null)
            return loginEmail;
        else return null;
    }
    public String getLoginPassword(){
        String loginPassword = properties.getProperty("loginPassword");
        if(loginPassword != null)
            return loginPassword;
        else return null;
    }
    public String getSearchData(){
        String searchData = properties.getProperty("searchData");
        if(searchData != null)
            return searchData;
        else return null;
    }
    public String secondPageURL(){
        String secondPageUrl = properties.getProperty("secondPageUrl");
        if(secondPageUrl != null)
            return secondPageUrl;
        else return null;
    }
}
