package juara.coding.day19.dto.validation;

import jakarta.validation.constraints.Pattern;

public class ValGroupMenuDTO {

    @Pattern(regexp = "^[\\w\\s]{5,50}$")
    private String nama;

    @Pattern(regexp = "^[\\w\\s]{5,100}$")
    private String deskripsi;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
