//package juara.coding.day19.security;
//
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import juara.coding.day19.core.MyHttpServletRequestWrapper;
//import org.springframework.stereotype.Component;
//import java.io.IOException;
//
//@Component
//public class FirstLayer extends HttpFilter {
//
//
//
//    @Override
//    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//        String strContentType = request.getContentType()==null?"":request.getContentType();
//        if(!strContentType.startsWith("multipart/form-data") || "".equals(strContentType)){
//            request = new juara.coding.day19.core.MyHttpServletRequestWrapper(request);
//        }
//        chain.doFilter(request,response);
//    }
//}