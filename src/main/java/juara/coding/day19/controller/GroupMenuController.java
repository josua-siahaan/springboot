package juara.coding.day19.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import juara.coding.day19.config.OtherConfig;
import juara.coding.day19.service.GroupMenuService;
import juara.coding.day19.dto.validation.ValGroupMenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("group-menu")
public class GroupMenuController {
    @Autowired
    private GroupMenuService groupMenuService;

    private Map<String, String> mapFilter = new HashMap<>();


    @GetMapping
    @PreAuthorize("hasAuthority('Group-Menu')")
    public ResponseEntity<Object> findAll(HttpServletRequest request){
        Pageable pageable = PageRequest.of(0, OtherConfig.getPageDefault(), Sort.by("id"));
        return groupMenuService.findAll(pageable, request);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('Group-Menu')")
    public ResponseEntity<Object> save(@Valid @RequestBody ValGroupMenuDTO valGroupMenuDTO, HttpServletRequest request){
        return groupMenuService.save(groupMenuService.convertToEntity(valGroupMenuDTO), request);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('Group-Menu')")
    public ResponseEntity<Object> update(
            @PathVariable(value = "id") Long id,
            @Valid @RequestBody ValGroupMenuDTO valGroupMenuDTO, HttpServletRequest request){
        return groupMenuService.update(id, groupMenuService.convertToEntity(valGroupMenuDTO), request);
    }

    @DeleteMapping("?{id}")
    @PreAuthorize("hasAuthority('Group-Menu')")
    public ResponseEntity<Object> delate(@PathVariable(value = "id") Long id, HttpServletRequest request){
        return groupMenuService.delete(id, request);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('Group-Menu')")
    public ResponseEntity<Object> findById(
            @PathVariable(value = "id") Long id, HttpServletRequest request){
        return groupMenuService.findById(id, request);
    }

    @GetMapping("/{sort}/{sortBy}/{page}")
    @PreAuthorize("hasAuthority('Group-Menu')")
    public ResponseEntity<Object> findByParam(
            @PathVariable(value = "sort") String sort,
            @PathVariable(value = "sortBy") String sortBy,
            @PathVariable(value = "page") Integer page,
            @RequestParam(value = "size") Integer size,
            @RequestParam(value = "column") String column,
            @RequestParam(value = "value") String value,
            HttpServletRequest request){
        Pageable pageable = null;
        sortBy = sortColumnByMap(sortBy);
        switch (sort) {
            case "asc":pageable = PageRequest.of(page, size, Sort.by(sortBy));break;
            default: pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());
        }
        return groupMenuService.findByParam(pageable,column,value,request);
    }


    private String sortColumnByMap(String sortBy){
        switch (sortBy){
            case "nama":sortBy = "nama";break;
            case "deskripsi":sortBy = "deskripsi";break;
            default:sortBy = "id";break;
        }
        return sortBy;
    }
}
