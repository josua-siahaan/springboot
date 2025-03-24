package juara.coding.day19.dto.validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class ValVerifyOTPRegisDTO {

    @Pattern(regexp = "^([0-9]{6})$",
            message = "Format OTP Wajib 6 Angka")
    private String otp;

    @NotNull
    @NotBlank
    @NotEmpty
    private String email;

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}