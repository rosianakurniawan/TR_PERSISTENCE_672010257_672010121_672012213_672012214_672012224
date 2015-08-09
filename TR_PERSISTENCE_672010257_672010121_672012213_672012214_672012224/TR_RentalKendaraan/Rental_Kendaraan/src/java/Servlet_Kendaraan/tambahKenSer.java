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
import Entity.e_Kendaraan;
import Entity.e_loggin;
import Entity.e_rental;
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
public class tambahKenSer extends HttpServlet {

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

        String plat = request.getParameter("plat");
        String jeKen = request.getParameter("jenis");
        String status = request.getParameter("status");
        String foto = request.getParameter("gambar");
        e_rental id_rental = log.getIdRental();

        if (id_session == null) {
            session.invalidate();
            out.println("<script type=\"text/javascript\">");
            out.println("window.location.href = 'logginRental.jsp';");
            out.println("</script>");
        } else if (plat.equals("") || jeKen.equals("") || status.equals("") || foto.equals("")) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Masih ada data yang kosong, Silakan di isi');");
            out.println("</script>");
        } else if (id_session != null) {
            e_Kendaraan ken = new e_Kendaraan();
            ken.setGambar(foto);
            ken.setJenisKendaraan(jeKen);
            ken.setPlatNo(plat);
            ken.setStatus(status);
            ken.setIdRental(id_rental);
            ken.setIdUser(log);

//            out.println(ken.getGambar());
//            out.println(ken.getIdRental());
//            out.println(ken.getIdUser());
//            out.println(ken.getJenisKendaraan());
//            out.println(ken.getPlatNo());
//            out.println(ken.getStatus());
            try {
                dao.insert(ken);
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Data Berhasil Ditambah...'); window.location.href='kendaraanSer'");
                out.println("</script>");
            } catch (Exception e) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Gagal Tambah Data');");
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
