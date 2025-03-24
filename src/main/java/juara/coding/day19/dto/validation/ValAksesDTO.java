package juara.coding.day19.dto.validation;

import jakarta.validation.constraints.Pattern;
import juara.coding.day19.dto.relasi.RelMenuDTO;

import java.util.List;

public class ValAksesDTO {
    @Pattern(regexp = "^[\\w\\s]{5,50}$",message = "Alfanumerik dengan spasi min 5 maks 50 karakter")
    private String nama;

    @Pattern(regexp = "^[\\w\\s]{5,100}$",message = "Alfanumerik dengan spasi min 5 maks 100 karakter")
    private String deskripsi;

    private List<RelMenuDTO> ltMenu;

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

    public List<RelMenuDTO> getLtMenu() {
        return ltMenu;
    }

    public void setLtMenu(List<RelMenuDTO> ltMenu) {
        this.ltMenu = ltMenu;
    }
}
