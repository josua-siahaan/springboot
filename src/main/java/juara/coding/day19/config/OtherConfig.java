package juara.coding.day19.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:other.properties")
public class OtherConfig {

    private static String enableLog;
    private static String enablePrint;
    private static Integer pageDefault;
    private static String smtpEnable;

    public static String getSmtpEnable() {
        return smtpEnable;
    }

    @Value("${smtp.enable}")
    private void setSmtpEnable(String smtpEnable) {
        OtherConfig.smtpEnable = smtpEnable;
    }

    public static Integer getPageDefault() {
        return pageDefault;
    }

    @Value("${page.default}")
    private void setPageDefault(Integer pageDefault) {
        OtherConfig.pageDefault = pageDefault;
    }

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