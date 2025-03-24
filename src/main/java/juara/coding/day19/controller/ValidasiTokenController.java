package juara.coding.day19.controller;

import jakarta.servlet.http.HttpServletRequest;
import juara.coding.day19.security.Crypto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("valtoken")
public class ValidasiTokenController {

    @GetMapping
    public String checkToken(HttpServletRequest request){
//        String token = request.getHeader("Authorization");
//        token = token.replace("Bearer", "");
//        token = Crypto.performDecrypt(token);
//
//        String strTokenArr [] = token.split("#");
//
//        for (int i = 0; i < strTokenArr.length; i++) {
//            System.out.println(strTokenArr[i]);
//        }
//
//        if (!strTokenArr[0].equals("C1")){
//            return "Validasi 1 Gagal";
//        }
//        Long longNow = System.currentTimeMillis();
//        longNow = (longNow - Long.parseLong(strTokenArr[2]))/1000;
//        System.out.println("Waktu Sekarang "+longNow+" Detik");
//        if (longNow>60){
//            return "Validasi 2 Gagal";
//        }
        return "OK";
    }
}
