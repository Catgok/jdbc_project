package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private static final Properties conf = new Properties();

    static {//静态语句块，类在被使用时同时加载
        InputStream in = ConfigManager.class.getClassLoader().getResourceAsStream("config.properties");
        try {
            conf.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProp(String key) {
        return conf.getProperty(key);
    }
}
