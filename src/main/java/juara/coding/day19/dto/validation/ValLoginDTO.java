package juara.coding.day19.dto.validation;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class ValLoginDTO implements Serializable {

    private final static long serialVersionUID = 1L;

    @NotEmpty
    @NotNull
    @NotBlank
    private String username;

    @NotEmpty
    @NotNull
    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}