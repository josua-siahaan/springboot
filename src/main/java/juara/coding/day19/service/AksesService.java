package juara.coding.day19.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import juara.coding.day19.core.IReport;
import juara.coding.day19.core.IService;
import juara.coding.day19.dto.relasi.RelMenuDTO;
import juara.coding.day19.dto.validation.ValAksesDTO;
import juara.coding.day19.model.Akses;
import juara.coding.day19.model.Menu;
import juara.coding.day19.repos.AksesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AksesService implements IService<Akses>, IReport<Akses> {

    @Autowired
    private AksesRepo aksesRepo;

    @Override
    public ResponseEntity<Object> save(Akses akses, HttpServletRequest request) {
        aksesRepo.save(akses);
        return ResponseEntity.status(HttpStatus.CREATED).body("Berhasil Disimpan");
    }

    @Override
    public ResponseEntity<Object> update(Long id, Akses akses, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> delete(Long id, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> findAll(Pageable pageable, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> findById(Long id, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> findByParam(Pageable pageable, String columnName, String value, HttpServletRequest request) {
        return null;
    }
    @Override
    public ResponseEntity<Object> uploadDataExcel(MultipartFile multipartFile, HttpServletRequest request) {
        return null;
    }

    @Override
    public List<Akses> convertListWorkBookToListEntity(List<Map<String, String>> workBookData, Long userId) {
        return List.of();
    }

    @Override
    public void downloadReportExcel(String column, String value, HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void generateToPDF(String column, String value, HttpServletRequest request, HttpServletResponse response) {

    }

    public Akses convertToEntity(ValAksesDTO valAksesDTO){
        Akses akses = new Akses();
        akses.setNama(valAksesDTO.getNama());
        akses.setDeskripsi(valAksesDTO.getDeskripsi());
        List<Menu> ltmenu = new ArrayList<>();
        for (RelMenuDTO relMenuDTO : valAksesDTO.getLtMenu()){
            Menu menu = new Menu();
            menu.setId(relMenuDTO.getId());
            menu.setNama(relMenuDTO.getName());
            ltmenu.add(menu);
        }
        akses.setLtmenu(ltmenu);
        return akses;
    }


}
