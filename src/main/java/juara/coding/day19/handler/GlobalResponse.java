package juara.coding.day19.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GlobalResponse {

    public static ResponseEntity<Object> dataGagalDisimpan(String errorCode, HttpServletRequest request){
        return new ResponseHandler().handleResponse("Data Gagal Disimpan",
                HttpStatus.INTERNAL_SERVER_ERROR,
                null, errorCode, request);
    }

    public static ResponseEntity<Object> dataBerhasilDisimpan(HttpServletRequest request){
        return new ResponseHandler().handleResponse("Data Berhasil Disimpan",
                HttpStatus.CREATED,
                null, null, request);
    }

    public static ResponseEntity<Object> dataTidakValid(String errorCode, HttpServletRequest request){
        return new ResponseHandler().handleResponse("Data Tidak Valid",
                HttpStatus.BAD_REQUEST,
                null, errorCode, request);
    }

    public static ResponseEntity<Object> dataTidakDitemukan(String errorCode, HttpServletRequest request){
        return new ResponseHandler().handleResponse("Data Tidak Ditemukan",
                HttpStatus.BAD_REQUEST,
                null, errorCode, request);
    }

    public static ResponseEntity<Object> dataGagalDiubah(String errorCode, HttpServletRequest request){
        return new ResponseHandler().handleResponse("Data Gagal Diubah",
                HttpStatus.INTERNAL_SERVER_ERROR,
                null, errorCode, request);
    }

    public static ResponseEntity<Object> dataBerhasilDiubah(HttpServletRequest request){
        return new ResponseHandler().handleResponse("Data Berhasil Diubah",
                HttpStatus.OK,
                null, null, request);
    }

    public static ResponseEntity<Object> dataGagalDihapus(String errorCode, HttpServletRequest request){
        return new ResponseHandler().handleResponse("Data Gagal Dihapus",
                HttpStatus.INTERNAL_SERVER_ERROR,
                null, errorCode, request);
    }

    public static ResponseEntity<Object> dataBerhasilDihapus(HttpServletRequest request){
        return new ResponseHandler().handleResponse("Data Berhasil Dihapus",
                HttpStatus.OK,
                null, null, request);
    }

    public static ResponseEntity<Object> terjadiKesalahan(String errorCode, HttpServletRequest request){
        return new ResponseHandler().handleResponse("Terjadi Kesalahan Pada Server",
                HttpStatus.INTERNAL_SERVER_ERROR,
                null, errorCode, request);
    }

    public static ResponseEntity<Object> dataDitemukan(Object object,HttpServletRequest request){
        return new ResponseHandler().handleResponse("Data Ditemukan",
                HttpStatus.OK,
                object,null,request);
    }
}
