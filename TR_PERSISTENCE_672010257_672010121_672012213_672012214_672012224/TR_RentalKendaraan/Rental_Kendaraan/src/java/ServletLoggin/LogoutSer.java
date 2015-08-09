/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletLoggin;

import Dao.dao_loggin;
import DaoImpl.logginDaoImpl;
import Entity.e_loggin;
import Entity.e_rental;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author RUBY
 */
public class LogoutSer extends HttpServlet {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Rental_KendaraanPU");

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        EntityManager em = emf.createEntityManager();
        dao_loggin dao = new logginDaoImpl(em);
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        e_rental ren = new e_rental();
        String id_session = (String) session.getAttribute("userID");
        e_loggin log = new e_loggin();

        if (id_session != null) {
//            log.setId(id);
//            log.setId_rental(a);
//            log.setId_user(b);
//            log.setPassword(c);
//            log.setUser_name(d);
//            log.setStatus(status);
//            dao.update(log);
            session.invalidate();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Anda Berhasil LogOut');window.location.href='logginRental.jsp'");
            out.println("</script>");
        } else {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Anda gagal LogOut'); window.location.href='kendaraanSer'");
            out.println("</script>");
        }

//            log.setId(id);
//            log.setId_rental(a);
//            log.setId_user(b);
//            log.setPassword(c);
//            log.setUser_name(d);
//            log.setStatus(status);
//            dao.update(log);
//        }
//        out.println("<script type=\"text/javascript\">");
//        out.println("alert('Anda Berhasil LogOut');");
//        out.println("</script>");
//        request.getRequestDispatcher("logginRental.jsp").include(request, response);
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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

}
