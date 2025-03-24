package juara.coding.day19.dto.validation;

import jakarta.persistence.Column;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Pattern;
import juara.coding.day19.dto.relasi.RelGroupMenuDTO;
import juara.coding.day19.model.GroupMenu;

public class ValMenuDTO {

    @Pattern(regexp = "^[\\w\\s]{4,20}$",message = "Alfanumerik dengan spasi min 5 maks 50 karakter")
    private String nama;

    @Pattern(regexp = "^[\\w\\s]{4,20}$",message = "Alfanumerik dengan spasi min 5 maks 50 karakter")
    private String path;

    private RelGroupMenuDTO groupMenu;

}
