package framework.config;

import framework.utilities.JSONUtil;

import java.util.HashMap;



public class Config {

    public static Config instance;
    private String url;
    private String browserName;

    private HashMap<String, String[]> browserArguments;

    private Long millisToWait;

    private Long millisToPoll;

    private Config(String url, String browserName, HashMap<String, String[]> args, Long millisToWait, Long millisToPoll) {
        this.url = url;
        this.browserName = browserName;
        this.browserArguments = args;
        this.millisToWait = millisToWait;
        this.millisToPoll = millisToPoll;
    }

    private Config(String browserName){
        this.browserName = browserName;
    }

    private Config() {
    }

    public static Config getInstance(){
        if(instance==null){
            instance = JSONUtil.parseJsonToCLass("src/test/resources/config/framework_config.json", Config.class);
        }

        return instance;
    }

    public String getUrl() {
        return url;
    }

    public String getBrowserName() {
        return browserName;
    }

    public String[] getBrowserArguments() {
        return browserArguments.get(browserName);
    }

    public Long getMillisToWait() {
        return millisToWait;
    }

    public Long getMillisToPoll() {
        return millisToPoll;
    }
}
