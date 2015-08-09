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
import java.text.SimpleDateFormat;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jboss.weld.bean.builtin.AbstractFacade;

/**
 *
 * @author RUBY
 */
public class tambahTransSer extends HttpServlet {

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

        dao_kendaraan kdao = new kendaraanDaoImpl(em);
        dao_loggin ldao = new logginDaoImpl(em);

        e_loggin log = ldao.getById(id_session);
        e_rental ren = log.getIdRental();
        e_Kendaraan ken = kdao.getById(request.getParameter("plat"));

        SimpleDateFormat in = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
//        int id = Integer.valueOf(request.getParameter("idtrans"));
        String nSewa = request.getParameter("namasewa");
        String alamat = request.getParameter("alamat");
        String telp = request.getParameter("telp");
        int lSewa = Integer.valueOf(request.getParameter("lama"));
        String tarif = request.getParameter("tarif");
        String a = request.getParameter("ambil");
        String b = "00/00/0000 00:00:00";
        String jk = "Belum Dibayar";
        String kenStatus = "Dipakai";
        double over = 0;
        String bayar = "0";
        String bOver = "0";

        if (nSewa.equals("") || alamat.equals("") || telp.equals("")
                || lSewa == 0 || tarif.equals("default") || a.equals("")) {
//            out.println(nSewa);
//            out.println(alamat);
//            out.println(telp);
//            out.println(lSewa);
//            out.println(tarif);
//            out.println(a);
//            out.println(ken);
//            out.println(ren);
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Data Ada yang Kosong, Silakan di isi'); window.location.href='transaksiSer'");
            out.println("</script>");
        } else if (id_session != null && !ken.equals("") && !nSewa.equals("") && !alamat.equals("") && !telp.equals("")
                && lSewa > 0 && !tarif.equals("default") && !a.equals("")) {
            e_transaksi tr = new e_transaksi();
            tr.setAlamat(alamat);
            tr.setNamaSewa(nSewa);
            tr.setNoTelp(telp);
            tr.setLamaSewa(lSewa);
            tr.setTarif(tarif);
            tr.setAmbil(a);
            tr.setIdRental(ren);
            tr.setOverTime(over);
            tr.setBayar(bayar);
            tr.setPlatNo(ken);
            tr.setKembali(b);
            tr.setBiayaOver(bOver);
            tr.setStatusTransaksi(jk);
            try {
//              //jquery TImer & datetimepicker  
                if (ken.getStatus().equals("Dipakai")) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('GAGAL update Status Kendaraan');");
                    out.println("</script>");
                } else if (ken.getStatus().equals("Ada")) {
                    dao_transaksi dao = new transaksiDaoImpl(em);
                    dao.insert(tr);
                    e_Kendaraan kn = new e_Kendaraan();
                    kn.setPlatNo(ken.getPlatNo());
                    kn.setStatus(kenStatus);
                    kn.setGambar(ken.getGambar());
                    kn.setJenisKendaraan(ken.getJenisKendaraan());
                    kn.setIdRental(ren);
                    kn.setIdUser(log);
                    kdao.update(kn);
                }
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Data Berhasil Ditambah...'); window.location.href='transaksiSer'");
                out.println("</script>");
            } catch (Exception e) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Data GAGAL Ditambah...'); window.location.href='transaksiSer'");
                out.println("</script>");
            }
        } else if (id_session == null) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Anda Harus Login'); window.location.href='logginRental.jsp'");
            out.println("</script>");
        }
    }

    public static double parseDoubleSafely(String str) {
        double result = 0;
        try {
            result = Double.parseDouble(str);
        } catch (NullPointerException npe) {
            //sysout found null
            return 0;
        } catch (NumberFormatException nfe) {
            //sysout NFE 
            return 0;
        }
        return result;
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
