package framework.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
    public static final Logger logger = LoggerFactory.getLogger(Log.class);


    public static void logTrace(String message){
        logger.trace(message);
    }

    public static void logDebug(String message){
        logger.debug(message);
    }

    public static void logInfo(String message){
        logger.info(message);
    }

    public static void logWarning(String message){
        logger.warn(message);
    }
    public static void logError(String message){
        logger.error(message);
    }
}


