/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet_Booking;

import Dao.dao_booking;
import Dao.dao_kendaraan;
import Dao.dao_loggin;
import Dao.dao_transaksi;
import DaoImpl.bookingDaoImpl;
import DaoImpl.kendaraanDaoImpl;
import DaoImpl.logginDaoImpl;
import DaoImpl.transaksiDaoImpl;
import Entity.e_Kendaraan;
import Entity.e_loggin;
import Entity.e_rental;
import Entity.e_transaksi;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class updateBooktoTrans extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        HttpSession session = request.getSession(true);
        String id_session = (String) session.getAttribute("userID");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        EntityManager em = emf.createEntityManager();
        
        dao_kendaraan kdao = new kendaraanDaoImpl(em);
        dao_transaksi tdao = new transaksiDaoImpl(em);
        dao_loggin ldao = new logginDaoImpl(em);
        dao_booking bdao = new bookingDaoImpl(em);

        SimpleDateFormat in = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        String alamat = request.getParameter("alamat");
        String ambil = request.getParameter("ambil");
        long id = Integer.valueOf(request.getParameter("idBook"));
        int lama = Integer.valueOf(request.getParameter("lama"));
        String booking = request.getParameter("booking");
        String namaS = request.getParameter("namasewa");
        String telp = request.getParameter("telp");
        String jenis = request.getParameter("jenis");
        String plat = request.getParameter("plat");
        String statusTr = "Belum Dibayar";
        String statusKn = "Dipakai";
        String tarif = null;
        e_transaksi tr = new e_transaksi();
        e_Kendaraan kn = new e_Kendaraan();
        e_Kendaraan ken = kdao.getById(plat);
        e_transaksi tra = tdao.getById(id);
        e_loggin log = ldao.getById(id_session);
        e_rental ren = log.getIdRental();
        if (alamat.equals("") || ambil.equals("") || jenis.equals("") || lama < 0 || namaS.equals("")
                || telp.equals("") || booking.equals("") || id < 0 || plat.equals("")) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Data Ada yang Kosong, Silakan di isi'); window.location.href='editBooking'");
            out.println("</script>");
        } else if (id_session != null && !alamat.equals("") && !ambil.equals("") && !jenis.equals("") && lama > 0
                && !namaS.equals("") && !telp.equals("") && !booking.equals("") && id > 0 && !plat.equals("")) {
            if (lama == 6) {
                tarif = "Rp 125.000,00";
            } else if (lama == 12) {
                tarif = "Rp 175.000,00";
            } else if (lama == 24) {
                tarif = "Rp 275.000,00";
            }
            tr.setAlamat(alamat);
            tr.setAmbil(ambil);
            tr.setBayar("0");
            tr.setKembali("00/00/0000 00:00:00");
            tr.setLamaSewa(lama);
            tr.setNamaSewa(namaS);
            tr.setNoTelp(telp);
            tr.setOverTime(0);
            tr.setTarif(tarif);
            tr.setPlatNo(ken);
            tr.setIdRental(ren);
            tr.setBiayaOver("0");
            tr.setStatusTransaksi(statusTr);
            em.getTransaction().begin();
            try {
                if (ken.getStatus().equals("Dipakai") || ken.getStatus().equals("Ada")) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('GAGAL update Status Kendaraan');");
                    out.println("</script>");
                } else if (ken.getStatus().equals("Booking")) {
                    tdao.insert(tr);
                    kn.setPlatNo(plat);
                    kn.setStatus(statusKn);
                    kn.setGambar("belum");
                    kn.setJenisKendaraan(jenis);
                    kn.setIdRental(ren);
                    kn.setIdUser(log);
                    kdao.update(kn);
                }
                bdao.delete(id);
                em.getTransaction().commit();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Data Booking Dipindah'); window.location.href='bookingSer'");
                out.println("</script>");
            } catch (Exception e) {
                em.getTransaction().rollback();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Data GAGAL Dipindah...'); window.location.href='bookingSer'");
                out.println("</script>");
            }
        } else if (id_session == null) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Anda Harus Login'); window.location.href='logginRental.jsp'");
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(updateBooktoTrans.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(updateBooktoTrans.class.getName()).log(Level.SEVERE, null, ex);
        }
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
