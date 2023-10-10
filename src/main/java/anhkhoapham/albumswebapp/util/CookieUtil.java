/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anhkhoapham.albumswebapp.util;

import jakarta.servlet.http.*;

/**
 *
 * @author Khoapa
 */
public final class CookieUtil {
    private CookieUtil() {throw new UnsupportedOperationException("Cannot create instance of static class CookieUtil.");}
    
    public static String getCookieValue(Cookie[] cookies, String cookieName) {
        String cookieValue = "";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }           
        }
        return cookieValue;
    }
    
    public static boolean contains(Cookie[] cookies, String cookieName){
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    return true;
                }
            }           
        }
        return false;
    }
}
