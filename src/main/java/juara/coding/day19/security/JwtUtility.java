package juara.coding.day19.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import juara.coding.day19.config.JwtConfig;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtility {

    /**Proses Ekstrak encode JWT yang menghasilkan informasi seperti payload dan ditampung(simpan) ke Map
     * Proses ekstrak hanya 1 kali di lakukan, agar memperbaiki performance
     * Dilakukan 1 kali karna prosesnya berat
     */
    public Map<String, Object> mappingBodyToken(String token) {
        Claims claims = getAllClaimsFromToken(token);
        Map<String, Object> map = new HashMap<>();
        map.put("userId", claims.get("id"));
        map.put("username", claims.getSubject());
        map.put("noHp", claims.get("phn"));
        map.put("namaLengkap", claims.get("nl"));
        map.put("email", claims.get("ml"));

        return map;
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(JwtConfig.getSecretKey()).parseClaimsJws(token).getBody();
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    /** fungsi ini dipanggil saat login */
    public String doGenerateToken(Map<String, Object> claims, String subject) {
        Long timeMilis = System.currentTimeMillis();
        Long timeExpiration = JwtConfig.getTimeExpiration();

        /**ada kebingungan disini*/
        if (timeExpiration == null) {
            timeExpiration = 3600000L; // Default to 1 hour
        }

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(timeMilis))
                .setExpiration(new Date(timeMilis + JwtConfig.getTimeExpiration()))
                .signWith(SignatureAlgorithm.HS512, JwtConfig.getSecretKey()).compact();
    }

    public Boolean validateToken(String token) {
        /** Sudah otomatis tervalidaasi jika expired date masih aktif */
        String username = getUsernameFromToken(token);
        return (username!=null && !isTokenExpired(token));
    }

    /**
     * kenapa getUsername masuh menggunakan getClaimFromToken?
     * kenapa tidak langsung mengambil nilai username dari mappingBodyToken yang sudah di map hasilnya?
     */
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }
}