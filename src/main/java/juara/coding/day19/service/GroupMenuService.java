package juara.coding.day19.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import juara.coding.day19.config.OtherConfig;
import juara.coding.day19.core.IService;
import juara.coding.day19.dto.response.RespGroupMenuDTO;
import juara.coding.day19.model.GroupMenu;
import juara.coding.day19.repos.GroupMenuRepo;
import juara.coding.day19.dto.validation.ValGroupMenuDTO;
import juara.coding.day19.security.RequestCapture;
import juara.coding.day19.util.LoggingFile;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
@Transactional
public class GroupMenuService implements IService<GroupMenu> {

    @Autowired
    private GroupMenuRepo groupMenuRepo;

    @Autowired
    private ModelMapper modelMapper;

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
            int intCobaError=1/0;
        } catch (Exception e) {
            LoggingFile.print(groupMenu.getNama(), OtherConfig.getEnablePrint());
            LoggingFile.logException("GroupMenuService",
                    "save(GroupMenu groupMenu) -- Line 38"+ RequestCapture.allRequest(request),e, OtherConfig.getEnableLog());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("USM01FV001");
        }

        groupMenuRepo.save(groupMenu);
        return ResponseEntity.status(HttpStatus.CREATED).body("USM01FV001");
    }

    @Override
    public ResponseEntity<Object> update(Long id, GroupMenu groupMenu, HttpServletRequest request) {
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
    public ResponseEntity<Object> delete(Long id, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> findAll() {
        List<RespGroupMenuDTO> list = convertToRespGroupMenuDTO(groupMenuRepo.findAll());
        return ResponseEntity.ok(list);
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
