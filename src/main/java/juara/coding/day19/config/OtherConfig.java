package juara.coding.day19.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:other.properties")
public class OtherConfig {

    private static String enableLog;
    private static String enablePrint;


    public static String getEnableLog() {
        return enableLog;
    }

    @Value("${enable.log}")
    private void setEnableLog(String enableLog) {
        this.enableLog = enableLog;
    }

    public static String getEnablePrint() {
        return enablePrint;
    }

    @Value("${enable.print}")
    private void setEnablePrint(String enablePrint) {
        this.enablePrint = enablePrint;
    }
}