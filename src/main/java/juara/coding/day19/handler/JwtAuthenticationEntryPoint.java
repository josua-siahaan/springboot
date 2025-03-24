package juara.coding.day19.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Component("customAuthenticationEntryPoint")
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Autowired
    private ObjectMapper mapper ;

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        /** Response Header */
        response.setHeader("Content-Type", "application/json");
        int intStatus = response.getStatus();
        /** Response Code */
        response.setStatus(intStatus==200?HttpServletResponse.SC_UNAUTHORIZED:HttpServletResponse.SC_FORBIDDEN);
        /** Response Body */
        Map<String,Object> data = new HashMap<>();
        data.put("status", false);
        data.put("apagitu","Ini Tambahan Aja");
//        data.put("timestamp", LocalDateTime.now());
        data.put("timestamp", Calendar.getInstance().getTime());
        data.put("error",authException.getMessage());
        response.getOutputStream().println(mapper.writeValueAsString(data));
    }
}
