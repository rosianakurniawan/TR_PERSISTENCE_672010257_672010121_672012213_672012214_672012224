/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet_Transaksi;

import Dao.dao_kendaraan;
import Dao.dao_loggin;
import Dao.dao_transaksi;
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
public class updateTransSerMotor extends HttpServlet {
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
        
        SimpleDateFormat in = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        String alamat = request.getParameter("alamat");
        String a = request.getParameter("ambil");
        String bayar = request.getParameter("bayar");
        long id = Long.valueOf(request.getParameter("idtrans"));
        String b = request.getParameter("kembali");
//        Date ambil = in.parse(a);
//        Date kembali = in.parse(b);
        int lama = Integer.valueOf(request.getParameter("lama"));
        String namaS = request.getParameter("namasewa");
        String telp = request.getParameter("telp");
        double over = Double.valueOf(request.getParameter("over"));
        String tarif = request.getParameter("tarif");
        String bOver = request.getParameter("bOver");
        String statusTr = "Lunas";
        String statusKn = "Ada";
        
        e_transaksi tr = new e_transaksi();
        e_Kendaraan ken = kdao.getById(request.getParameter("plat"));
        e_transaksi tra = tdao.getById(id);
        e_loggin log = ldao.getById(id_session);
        e_rental ren = log.getIdRental();

        

//        out.println(alamat);
//        out.println(a);
//        out.println(bayar);
//        out.println(id);
//        out.println(lama);
//        out.println(namaS);
//        out.println(telp);
//        out.println(over);
//        out.println(tarif);
//        out.println(alamat);
//        out.println(a);
//        out.println(b);
        if (alamat.equals("") || a.equals("") || bayar.equals("") || b.equals("") ||
                lama < 0 || namaS.equals("") || telp.equals("") || over < 0 || tarif.equals("") || bOver.equals("")) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Data Ada yang Kosong, Silakan di isi'); window.location.href='motorEditTrans'");
            out.println("</script>");
        } else if(id_session != null && !alamat.equals("") && !a.equals("") && !bayar.equals("") && !b.equals("") &&
                lama > 0 && !namaS.equals("") && !telp.equals("") && over > 0 && !tarif.equals("") && !bOver.equals("")){
            tr.setAlamat(alamat);
            tr.setAmbil(a);
            tr.setBayar(bayar);
            tr.setIdTrans(id);
            tr.setKembali(b);
            tr.setLamaSewa(lama);
            tr.setNamaSewa(namaS);
            tr.setNoTelp(telp);
            tr.setOverTime(over);
            tr.setTarif(tarif);
            tr.setPlatNo(ken);
            tr.setIdRental(ren);
            tr.setBiayaOver(bOver);
            tr.setStatusTransaksi(statusTr);
            
            try {
                if (ken.getStatus().equals("Ada") || tra.getStatusTransaksi().equals("Lunas")) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('GAGAL update Status Kendaraan');");
                    out.println("</script>");
                }else if(ken.getStatus().equals("Dipakai") || tra.getStatusTransaksi().equals("Belum Dibayar")){
                    tdao.update(tr);
                    e_Kendaraan kn = new e_Kendaraan();
                    kn.setPlatNo(ken.getPlatNo());
                    kn.setStatus(statusKn);
                    kn.setGambar(ken.getGambar());
                    kn.setJenisKendaraan(ken.getJenisKendaraan());
                    kn.setIdRental(ren);
                    kn.setIdUser(log);
                    kdao.update(kn);
                }out.println("<script type=\"text/javascript\">");
                out.println("alert('Data Telah Lunas...'); window.location.href='transaksiSerMotor'");
                out.println("</script>");
            } catch (Exception e) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Data GAGAL Ditambah...'); window.location.href='motorEditTrans'");
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
        Logger.getLogger(updateTransSerMotor.class.getName()).log(Level.SEVERE, null, ex);
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
        Logger.getLogger(updateTransSerMotor.class.getName()).log(Level.SEVERE, null, ex);
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
