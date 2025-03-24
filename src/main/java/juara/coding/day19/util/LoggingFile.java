package juara.coding.day19.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingFile {
    private static StringBuilder sBuild = new StringBuilder();

    private static Logger logger = LogManager.getLogger(LoggingFile.class);

    public static void logException(String strClass, String strMethod,
                                    Exception e, String strFlag) {
        if(strFlag.equals("y")){
            sBuild.setLength(0);
            logger.error(sBuild.append(System.getProperty("line.separator")).
                    append("ERROR IN CLASS ==> ").append(strClass).append(System.getProperty("line.separator")).
                    append("METHOD ==> ").append(strMethod).append(System.getProperty("line.separator")).
                    append("ERROR IS ==> ").append(e.getMessage()).append(System.getProperty("line.separator")));
        }
    }

    public static void print(Object obj, String strFlag) {
        if(strFlag.equals("y")){
            System.out.println(obj);
        }
    }
}