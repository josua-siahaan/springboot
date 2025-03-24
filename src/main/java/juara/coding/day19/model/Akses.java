package juara.coding.day19.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "MstAkses")
public class Akses {
    @Id
    @Column(name = "IDAkses")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NamaAkses", nullable = false, length = 50, unique = true)
    private String nama;

    @Column(name = "Deskripsi", nullable = false, length = 50, unique = true)
    private String deskripsi;

    @Column(name = "CreatedBy",nullable = false,updatable = false)
    private Long createdBy=1L;

    @Column(name = "CreatedDate",nullable = false,updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "ModifiedBy",insertable = false)
    private Long modifiedBy=1L;

    @Column(name = "ModifiedDate",insertable = false)
    @UpdateTimestamp
    private LocalDateTime modifiedDate;

    @ManyToMany
    @JoinTable(name = "MapAksesMenu", uniqueConstraints = @UniqueConstraint(name = "unq-akses-to-menu", columnNames = {"IDAkses", "IDMenu"}),
            joinColumns = @JoinColumn(name = "IDAkses", foreignKey = @ForeignKey(name = "fk-toAkses")),
            inverseJoinColumns = @JoinColumn(name = "IDMenu", foreignKey = @ForeignKey(name = "fk-toMenu"))
    )
    private List<Menu> ltmenu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public List<Menu> getLtmenu() {
        return ltmenu;
    }

    public void setLtmenu(List<Menu> ltmenu) {
        this.ltmenu = ltmenu;
    }
}
