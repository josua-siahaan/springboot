package juara.coding.day19.core;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

import org.springframework.data.domain.Pageable;

public interface IService<T>{
    public ResponseEntity<Object> save(T t, HttpServletRequest request);//001-010
    public ResponseEntity<Object> update(Long id,T t, HttpServletRequest request);//011-020
    public ResponseEntity<Object> delete(Long id, HttpServletRequest request);//021-030
    public ResponseEntity<Object> findAll(Pageable pageable, HttpServletRequest request);//031-040
    public ResponseEntity<Object> findById(Long id, HttpServletRequest request);//041-050
    public ResponseEntity<Object> findByParam(Pageable pageable, String columnName, String value, HttpServletRequest request);//051-060
}
