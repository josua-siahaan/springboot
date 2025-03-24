package juara.coding.day19.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import juara.coding.day19.service.GroupMenuService;
import juara.coding.day19.dto.validation.ValGroupMenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("group-menu")
public class GroupMenuController {
    @Autowired
    private GroupMenuService groupMenuService;

    @GetMapping
    @PreAuthorize("hasAuthority('Group-Menu')")
    public ResponseEntity<Object> findAll(){
        return groupMenuService.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody ValGroupMenuDTO valGroupMenuDTO, HttpServletRequest request){
        return groupMenuService.save(groupMenuService.convertToEntity(valGroupMenuDTO), request);
    }
}
