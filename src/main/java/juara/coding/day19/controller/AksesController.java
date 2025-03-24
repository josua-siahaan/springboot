package juara.coding.day19.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import juara.coding.day19.dto.validation.ValAksesDTO;
import juara.coding.day19.service.AksesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("akses")
public class AksesController {

    @Autowired
    private AksesService aksesService;

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody ValAksesDTO valAksesDTO, HttpServletRequest request){
        return aksesService.save(aksesService.convertToEntity(valAksesDTO), request);
    }
}
