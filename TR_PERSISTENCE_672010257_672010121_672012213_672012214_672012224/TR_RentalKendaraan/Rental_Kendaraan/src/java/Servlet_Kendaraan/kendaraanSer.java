/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet_Kendaraan;

import Dao.dao_kendaraan;
import Dao.dao_loggin;
import DaoImpl.kendaraanDaoImpl;
import DaoImpl.logginDaoImpl;
import Entity.e_loggin;
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
public class kendaraanSer extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        String id_session = (String) session.getAttribute("userID");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        EntityManager em = emf.createEntityManager();
        dao_kendaraan dao = new kendaraanDaoImpl(em);
        dao_loggin ldao = new logginDaoImpl(em);
        e_loggin log = ldao.getById(id_session);
        
        if (id_session != null) {
            request.setAttribute("kendaraan", dao.getKendByLog(ldao.getById(log.getIdUser())));
            RequestDispatcher rd = request.getRequestDispatcher("Menu_Utama.jsp");
            rd.forward(request, response);
        } else {
            session.invalidate();
            out.println("<script type=\"text/javascript\">");
            out.println("window.location.href = 'logginRental.jsp';");
            out.println("</script>");
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
