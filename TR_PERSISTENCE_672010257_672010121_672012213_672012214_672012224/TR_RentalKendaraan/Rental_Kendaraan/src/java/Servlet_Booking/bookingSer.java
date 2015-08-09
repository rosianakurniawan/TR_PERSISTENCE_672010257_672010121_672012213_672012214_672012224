/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet_Booking;

import Dao.dao_booking;
import Dao.dao_kendaraan;
import Dao.dao_loggin;
import Dao.dao_rental;
import Dao.dao_transaksi;
import DaoImpl.bookingDaoImpl;
import DaoImpl.kendaraanDaoImpl;
import DaoImpl.logginDaoImpl;
import DaoImpl.rentalDaoImpl;
import DaoImpl.transaksiDaoImpl;
import Entity.e_Kendaraan;
import Entity.e_loggin;
import Entity.e_rental;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class bookingSer extends HttpServlet {

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
        dao_booking bdao = new bookingDaoImpl(em);
        dao_loggin ldao = new logginDaoImpl(em);
        dao_kendaraan kdao = new kendaraanDaoImpl(em);
        dao_rental rdao = new rentalDaoImpl(em);
        e_loggin log = ldao.getById(id_session);
        String idrent = log.getIdRental().toString();
        e_rental rent = rdao.getById(log.getIdRental().getIdRental());
        String statusKen = "Booking";
        String stat = "Ada";
        String kelompok = request.getParameter("kelompok");
        List<e_Kendaraan> knMot = kdao.getIdKen(stat, "Motor", rent);
        List<e_Kendaraan> knMob = kdao.getIdKen(stat, "Mobil", rent);

        if (id_session != null) {
            RequestDispatcher rd;
                request.setAttribute("booking", bdao.getAllByIdRent(rent));
                request.setAttribute("kend", knMob);
                request.setAttribute("knd", knMot);
                rd = request.getRequestDispatcher("bookingList.jsp");
                rd.forward(request, response);
//            } else if (kelompok.equals("Mobil")) {
//                request.setAttribute("booking", bdao.getIdByJenis(kelompok, rent));
//                rd = request.getRequestDispatcher("bookingList.jsp");
//                rd.forward(request, response);
        } else if (id_session == null) {
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
