package juara.coding.day19.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import juara.coding.day19.dto.validation.ValLoginDTO;
import juara.coding.day19.dto.validation.ValRegisDTO;
import juara.coding.day19.dto.validation.ValVerifyOTPRegisDTO;
import juara.coding.day19.service.AppUserDetailService;
import juara.coding.day19.util.SendMailOTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AppUserDetailService appUserDetailService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody ValLoginDTO valLoginDTO,
                                        HttpServletRequest request){
        return appUserDetailService.Login(appUserDetailService.convertToEntity(valLoginDTO), request);
    }

    @PostMapping("/regis")
    public ResponseEntity<Object> regis(@Valid @RequestBody ValRegisDTO valRegisDTO, HttpServletRequest request){
        return appUserDetailService.regis(appUserDetailService.convertToEntity(valRegisDTO), request);
    }

    @PostMapping("/verify-regis")
    public ResponseEntity<Object> verifyRegis(@Valid @RequestBody ValVerifyOTPRegisDTO valVerifyOTPRegisDTO, HttpServletRequest request){
        return appUserDetailService.verifyRegis(appUserDetailService.convertToEntity(valVerifyOTPRegisDTO), request);
    }

    @GetMapping("/contoh-email")
    public String contohSendEmail(){
        SendMailOTP.verifyRegisOTP("Verifikasi OTP Registrasi", "Josua", "siahaan654josua@gmail.com", "121314");
        return "OK";
    }
}
