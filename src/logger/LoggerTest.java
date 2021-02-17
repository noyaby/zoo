package logger;

import java.io.IOException;
import java.util.logging.*;

public class LoggerTest
{
    private final static Logger LOGGER = Logger.getLogger(LoggerTest.class.getName());
    private static FileHandler fileHandler = null;

    public static void init(){
        try{
            fileHandler = new FileHandler("Desktop/logger.log", false);
        } catch(IOException exception)
        {
            exception.printStackTrace();
        }

        Logger logger = Logger.getLogger("");
        fileHandler.setFormatter(new SimpleFormatter());
        
        logger.addHandler(fileHandler);
        logger.setLevel(Level.CONFIG);
    }
}
