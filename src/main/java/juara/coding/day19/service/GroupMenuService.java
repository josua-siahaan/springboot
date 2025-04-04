package juara.coding.day19.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import juara.coding.day19.config.OtherConfig;
import juara.coding.day19.core.IReport;
import juara.coding.day19.core.IService;
import juara.coding.day19.dto.response.RespGroupMenuDTO;
import juara.coding.day19.handler.GlobalResponse;
import juara.coding.day19.model.GroupMenu;
import juara.coding.day19.repos.GroupMenuRepo;
import juara.coding.day19.dto.validation.ValGroupMenuDTO;
import juara.coding.day19.security.RequestCapture;
import juara.coding.day19.util.LoggingFile;
import juara.coding.day19.util.TransformPagination;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class GroupMenuService implements IService<GroupMenu>, IReport<GroupMenu> {

    @Autowired
    private GroupMenuRepo groupMenuRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TransformPagination transformPagination;

//    @Override
//    public ResponseEntity<Object> save(GroupMenu groupMenu, HttpServletRequest request) {
//
//        if (groupMenu==null){
//            return ResponseEntity.badRequest().body("USM01FV001");
//        }
//        try {
//            int intCobaError=1/0;
////            groupMenuRepo.save(groupMenu);
//        }catch (Exception e) {
//            LoggingFile.logException("GroupMenuService","save(GroupMenu groupMenu, HttpServletRequest request) -- Line 59 "+RequestCapture.allRequest(request),e,OtherConfig.getEnableLog());
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("USM01FV001");
//        }
//        groupMenuRepo.save(groupMenu);
//        return ResponseEntity.status(HttpStatus.CREATED).body("USM01FV001");
//    }
    @Override
    public ResponseEntity<Object> save(GroupMenu groupMenu, HttpServletRequest request) {

        if (groupMenu==null){
            return ResponseEntity.badRequest().body("USM01FV001");
        }

        try {
//            int intCobaError=1/0;
            groupMenuRepo.save(groupMenu);
        } catch (Exception e) {
            LoggingFile.print(groupMenu.getNama(), OtherConfig.getEnablePrint());
            LoggingFile.logException("GroupMenuService",
                    "save(GroupMenu groupMenu) -- Line 68"+ RequestCapture.allRequest(request), e, OtherConfig.getEnableLog());
            return GlobalResponse.dataGagalDisimpan("USM01FE001", request);
        }
        return GlobalResponse.dataBerhasilDisimpan(request);
    }

    @Override
    public ResponseEntity<Object> update(Long id, GroupMenu groupMenu, HttpServletRequest request) {
        if (groupMenu == null){
            return GlobalResponse.dataTidakValid("USM01FV011", request);
        }
        try {
            Optional<GroupMenu> optionalGroupMenu = groupMenuRepo.findById(id);

            if (!optionalGroupMenu.isPresent()){
                return GlobalResponse.dataTidakDitemukan("USM01FV012", request);
            }
            GroupMenu nextGroupMenu = optionalGroupMenu.get();
            groupMenu.setNama(nextGroupMenu.getNama());
            groupMenu.setDeskripsi(nextGroupMenu.getDeskripsi());
        }
        catch (Exception e) {
            return GlobalResponse.dataGagalDiubah("USM01FE011", request);
        }
        return GlobalResponse.dataBerhasilDiubah(request);
    }

    @Override
    public ResponseEntity<Object> delete(Long id, HttpServletRequest request) {
        try {
            Optional<GroupMenu> optionalGroupMenu = groupMenuRepo.findById(id);

            if (!optionalGroupMenu.isPresent()){
                return GlobalResponse.dataTidakDitemukan("USM01FV021", request);
            }
        }
        catch (Exception e) {
            return GlobalResponse.dataGagalDihapus("USM01FE021", request);
        }
        return GlobalResponse.dataBerhasilDihapus(request);
    }

    @Override
    public ResponseEntity<Object> findAll(Pageable pageable, HttpServletRequest request) {
        Page<GroupMenu> page = null;
        List<GroupMenu> list = null;
        page = groupMenuRepo.findAll(pageable);
        list = page.getContent();
        List<RespGroupMenuDTO> lt = convertToRespGroupMenuDTO(list);
        return GlobalResponse.dataDitemukan(transformPagination.transformPagination(lt, page, null, null),
                request);
    }

    @Override
    public ResponseEntity<Object> findById(Long id, HttpServletRequest request) {
        Optional<GroupMenu> optionalGroupMenu = null;
        try {
            optionalGroupMenu = groupMenuRepo.findById(id);

            if (!optionalGroupMenu.isPresent()){
                return GlobalResponse.dataTidakDitemukan("USM01FV041", request);
            }
        }
        catch (Exception e) {
            return GlobalResponse.terjadiKesalahan("USM01FE041", request);
        }
        return GlobalResponse.dataDitemukan(optionalGroupMenu,request);
    }

    @Override
    public ResponseEntity<Object> findByParam(Pageable pageable, String columnName, String value, HttpServletRequest request) {
        Page<GroupMenu> page = null;
        List<GroupMenu> list = null;

        switch (columnName){
            case "nama": page = groupMenuRepo.findByNamaContainsIgnoreCase(value, pageable); break;
            case "deskripsi": page = groupMenuRepo.findByDeskripsiContainsIgnoreCase(value, pageable); break;
            default: page = groupMenuRepo.findAll(pageable); break;
        }
        list = page.getContent();
        List<RespGroupMenuDTO> lt = convertToRespGroupMenuDTO(list);
        return GlobalResponse.dataDitemukan(transformPagination.transformPagination(lt, page, columnName, value),request);
//        return ResponseEntity.status(HttpStatus.OK).body(page);
//        return ResponseEntity.status(HttpStatus.OK).body(page.getContent());
    }


    @Override
    public ResponseEntity<Object> uploadDataExcel(MultipartFile multipartFile, HttpServletRequest request) {
        return null;
    }

    @Override
    public List<GroupMenu> convertListWorkBookToListEntity(List<Map<String, String>> workBookData, Long userId) {
        return List.of();
    }

    @Override
    public void downloadReportExcel(String column, String value, HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void generateToPDF(String column, String value, HttpServletRequest request, HttpServletResponse response) {

    }


    public List<RespGroupMenuDTO> convertToRespGroupMenuDTO(List<GroupMenu> groupMenus){
//        List<RespGroupMenuDTO> respGroupMenuDTOList = new ArrayList<>();
//        for (GroupMenu groupMenu : groupMenus){
//            RespGroupMenuDTO respGroupMenuDTO = new RespGroupMenuDTO();
//            respGroupMenuDTO.setId(groupMenu.getId());
//            respGroupMenuDTO.setNama(groupMenu.getNama());
//            respGroupMenuDTO.setDeskripsi(groupMenu.getDeskripsi());
//            respGroupMenuDTOList.add(respGroupMenuDTO);
//        }
        List<RespGroupMenuDTO> respGroupMenuDTOList = modelMapper.map(groupMenus, new TypeToken<List<RespGroupMenuDTO>>() {}.getType());
        return respGroupMenuDTOList;
    }

    public GroupMenu convertToEntity(ValGroupMenuDTO valGroupMenuDTO){
        GroupMenu groupMenu = new GroupMenu();
        groupMenu.setNama(valGroupMenuDTO.getNama());
        groupMenu.setDeskripsi(valGroupMenuDTO.getDeskripsi());
        return groupMenu;
    }

}
