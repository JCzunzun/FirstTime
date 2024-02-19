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
    private static final String OPEN_COUNT = "open_count";
    private Properties properties;
    private File configFile;
    private AppStateDataRepository(){
        properties = new Properties();
        configFile= new File(CONFIG_FILE);
    }
    public boolean isFirstTime(){
        try(FileInputStream fileInputStream= new FileInputStream(configFile)){
            properties.load(fileInputStream);
            return !properties.containsKey(FIRST_TIME);
        } catch (IOException e) {
            return true;
        }
    }
    public void markAsNotFirstTime(){
        properties.setProperty(FIRST_TIME, "false");
        try (FileOutputStream fileOutputStream = new FileOutputStream(configFile)) {
            properties.store(fileOutputStream, "Application configuration");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static AppStateDataRepository newInstance(){
        if(instance==null){
            instance = new AppStateDataRepository();
        }
        return instance;
    }
    public int getOpenCount() {
        try (FileInputStream fileInputStream = new FileInputStream(configFile)) {
            properties.load(fileInputStream);
            String openCountStr = properties.getProperty(OPEN_COUNT, "0");
            return Integer.parseInt(openCountStr);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
    public void incrementCounter() {
        int counter = getOpenCount();
        properties.setProperty(OPEN_COUNT, String.valueOf(counter + 1));
        try (FileOutputStream fileOutputStream = new FileOutputStream(configFile)) {
            properties.store(fileOutputStream, "Application configuration");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void incrementOpenCount() {
        int currentCount = getOpenCount();
        properties.setProperty(OPEN_COUNT, String.valueOf(currentCount + 1));
        try (FileOutputStream fileOutputStream = new FileOutputStream(configFile)) {
            properties.store(fileOutputStream, "Application configuration");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deleteConfigFile() {
        try {
            if (configFile.exists()) {
                if (configFile.delete()) {
                    System.out.println("El archivo config.properties ha sido eliminado correctamente.");
                } else {
                    System.out.println("No se pudo eliminar el archivo config.properties.");
                }
            } else {
                System.out.println("El archivo config.properties no existe.");
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

}
