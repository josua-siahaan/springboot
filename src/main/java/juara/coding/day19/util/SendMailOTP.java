package juara.coding.day19.util;

import juara.coding.day19.config.OtherConfig;
import juara.coding.day19.config.SMTPConfig;
import juara.coding.day19.core.SMTPCore;

public class SendMailOTP {

    public static void verifyRegisOTP(String subject, String nama ,String email,String token) {
        if (OtherConfig.getSmtpEnable().equals("y")){
            try{
                String[] strVerify = new String[3];
                strVerify[0] = subject;
                strVerify[1] = nama;
                strVerify[2] = token;
                String  strContent = new ReadTextFileSB("ver_regis.html").getContentFile();
                strContent = strContent.replace("#JKVM3NH",strVerify[0]);//Kepentingan
                strContent = strContent.replace("XF#31NN",strVerify[1]);//Nama Lengkap
                strContent = strContent.replace("8U0_1GH$",strVerify[2]);//TOKEN
                final String content = strContent;
                System.out.println(SMTPConfig.getEmailHost());
                String [] strEmail = {email};
                String [] strImage = null;//isi kalau mau menggunakan attachment, parameter nya jg diubah
//            System.getProperty("user.dir");
                SMTPCore sc = new SMTPCore();
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        sc.sendMailWithAttachment(strEmail,
                                subject,
                                content,
                                "TLS",strImage);
                    }
                });
                t.start();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }
}