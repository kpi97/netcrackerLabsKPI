package ru.vsu.netcracker.configs;

import java.io.FileInputStream;
import java.util.Properties;

public class Configurator {
    private static String PATH_TO_PROPERTIES = "src/main/resources/config.properties";
    private static Class sorter = null;
    public Class getSorter(){
        if(sorter == null){
            loadConfiguration();
        }
        return sorter;

    }
    private void loadConfiguration ()
    {
        Properties properties = new Properties();
        String sort = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            properties.load(fileInputStream);
            sort = properties.getProperty("sorter");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            sorter = Class.forName("ru.vsu.netcracker.sorts.sortsImpl." + sort + "Sort");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
