/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package anhkhoapham.albumswebapp.servlets.download;

import anhkhoapham.albumswebapp.business.user.User;
import anhkhoapham.albumswebapp.business.user.UserInfo;
import anhkhoapham.albumswebapp.songs.Albums;
import anhkhoapham.albumswebapp.util.CookieUtil;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;
import java.time.Duration;

/**
 *
 * @author Khoapa
 */
@WebServlet("/download")
public final class DownloadServlet extends HttpServlet {

    private final static String EMAIL_TAG = "email";
    private final static String FIRST_NAME_TAG = "firstName";
    private final static String LAST_NAME_TAG = "lastName";
    private final static String USER_TAG = "user";
    
    private final static String ACTION_TAG = "action";
    private final static String VIEW_ALBUMS_ACTION_TAG = "viewAlbums";
    private final static String CHECK_USER_ACTION_TAG = "checkUser";
    private final static String REGISTER_USER_ACTION_TAG = "registerUser";
    
    private final static String EMAIL_COOKIE_TAG = "userEmail";
    private final static String PRODUCT_CODE_TAG = "productCode";
    
    private final static String INDEX_JSP_PATH = "/index.jsp";
    private final static String REGISTER_JSP_PATH = "/pages/registration/register.jsp";
    private final static String EMAIL_LIST_PATH = "/WEB-INF/EmailList.txt";
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter(ACTION_TAG);
        if (action == null) action = VIEW_ALBUMS_ACTION_TAG;
        
        String url = action.equals(CHECK_USER_ACTION_TAG) ? checkUser(request, response) : INDEX_JSP_PATH;
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter(ACTION_TAG);
        
        String url = action.equals(REGISTER_USER_ACTION_TAG) ? registerUser(request, response) : INDEX_JSP_PATH;
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String getDownloadURL(String productCode)
    {                
        //return "/pages/registration/" + productCode + "_download.jsp";
        return "/pages/registration/download/download.jsp";
    }
    
    private String checkUser(HttpServletRequest request, HttpServletResponse response) {
        
        String productCode = request.getParameter(PRODUCT_CODE_TAG);
        HttpSession session = request.getSession();
        session.setAttribute(PRODUCT_CODE_TAG, productCode);
        
        User user = (User) session.getAttribute(USER_TAG);
        
        String url = getDownloadURL(productCode);
        
        if (user == null)
        {
            Cookie[] cookies = request.getCookies();
            String emailAddress = CookieUtil.getCookieValue(cookies, EMAIL_COOKIE_TAG);
            
            if (emailAddress == null || emailAddress.isBlank()) url = REGISTER_JSP_PATH;
            else
            {
                ServletContext context = getServletContext();
                var path = context.getRealPath(EMAIL_LIST_PATH);                
            }
        }
        
        request.setAttribute("albumInfo", Albums.get().getAlbumMap().get(productCode));
        
        return url;
    }

    private String registerUser(HttpServletRequest request, HttpServletResponse response) {
        
        String email = request.getParameter(EMAIL_TAG);
        String firstName = request.getParameter(FIRST_NAME_TAG);
        String lastName = request.getParameter(LAST_NAME_TAG);
        
        UserInfo info = new UserInfo(email, firstName, lastName);
        User user = new User(info);
        
        HttpSession session = request.getSession();
        session.setAttribute(USER_TAG, user);
        
        Cookie cookie = new Cookie(EMAIL_COOKIE_TAG, email);
        cookie.setMaxAge((int) Duration.ofDays(365 * 3).toSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
        
        String productCode = (String) session.getAttribute(PRODUCT_CODE_TAG);
               
        request.setAttribute("albumInfo", Albums.get().getAlbumMap().get(productCode));
        
        return getDownloadURL(productCode);
    }
}
