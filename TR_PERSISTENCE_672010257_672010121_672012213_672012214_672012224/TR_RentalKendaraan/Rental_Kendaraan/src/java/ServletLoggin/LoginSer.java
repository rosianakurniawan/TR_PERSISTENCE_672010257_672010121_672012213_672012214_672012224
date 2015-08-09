/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletLoggin;

import Dao.dao_loggin;
import Dao.dao_rental;
import DaoImpl.logginDaoImpl;
import DaoImpl.rentalDaoImpl;
import Entity.e_loggin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author RUBY
 */
public class LoginSer extends HttpServlet {

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
        dao_rental rdao = new rentalDaoImpl(em);
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String username = request.getParameter("user");
        String pass = request.getParameter("pass");
        String idR = request.getParameter("id");

        e_loggin le = dao.getById(idR);
        if (session.equals("")) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Anda Telah Log Out '); window.location.href = 'logginRental.jsp';");
            out.println("</script>");
        } else if (username.equals("") || pass.equals("") || idR.equals("")) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('User Name atau User ID dan Password anda SALAH '); window.location.href = 'logginRental.jsp';");
            out.println("</script>");
        } else if (le != null) {
            try {
                HttpSession sess = request.getSession();
                sess.setAttribute("userID", idR);
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Anda Berhasil Login '); window.location.href = 'kendaraanSer';");
                out.println("</script>");
            } catch (Exception e) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('ID User atau Password atau User Name anda ada yang salah');");
                out.println("location='logginRental.jsp'; ");
                out.println("</script>");
            }
        }
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
