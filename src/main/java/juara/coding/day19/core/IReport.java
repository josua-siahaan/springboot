package juara.coding.day19.core;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface IReport<G>{

    public ResponseEntity<Object> uploadDataExcel(MultipartFile multipartFile, HttpServletRequest request);//061-070
    public List<G> convertListWorkBookToListEntity(List<Map<String, String>> workBookData, Long userId);//071-080
    public void downloadReportExcel(String column, String value, HttpServletRequest request, HttpServletResponse response);//081-090
    public void generateToPDF(String column, String value, HttpServletRequest request, HttpServletResponse response);//091-100
}
