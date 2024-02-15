package com.iesam.firstTime.features.prject.data;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
public class AppStateDataRepository {
    private static AppStateDataRepository instance= null;
    private static final String CONFIG_FILE="config.properties";
    private static final String FIRST_TIME="first_time";
    private Properties properties;
    private File configFile;
    private AppStateDataRepository(){

    }
    public boolean isFirstTime(){

        return false;
    }
    public static AppStateDataRepository newInstance(){
        if(instance==null){
            instance = new AppStateDataRepository();
        }
        return instance;
    }
}
