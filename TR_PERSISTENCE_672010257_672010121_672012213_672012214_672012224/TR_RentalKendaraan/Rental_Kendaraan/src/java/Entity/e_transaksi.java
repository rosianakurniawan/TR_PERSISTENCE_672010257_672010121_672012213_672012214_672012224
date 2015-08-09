/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RUBY
 */
@Entity
@Table(name = "tbl_transaksi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "e_transaksi.findAll", query = "SELECT e FROM e_transaksi e"),
    @NamedQuery(name = "e_transaksi.findByIdTrans", query = "SELECT e FROM e_transaksi e WHERE e.idTrans = :idTrans"),
    @NamedQuery(name = "e_transaksi.findByNamaSewa", query = "SELECT e FROM e_transaksi e WHERE e.namaSewa = :namaSewa"),
    @NamedQuery(name = "e_transaksi.findByAlamat", query = "SELECT e FROM e_transaksi e WHERE e.alamat = :alamat"),
    @NamedQuery(name = "e_transaksi.findByNoTelp", query = "SELECT e FROM e_transaksi e WHERE e.noTelp = :noTelp"),
    @NamedQuery(name = "e_transaksi.findByLamaSewa", query = "SELECT e FROM e_transaksi e WHERE e.lamaSewa = :lamaSewa"),
    @NamedQuery(name = "e_transaksi.findByTarif", query = "SELECT e FROM e_transaksi e WHERE e.tarif = :tarif"),
    @NamedQuery(name = "e_transaksi.findByAmbil", query = "SELECT e FROM e_transaksi e WHERE e.ambil = :ambil"),
    @NamedQuery(name = "e_transaksi.findByKembali", query = "SELECT e FROM e_transaksi e WHERE e.kembali = :kembali"),
    @NamedQuery(name = "e_transaksi.findByOverTime", query = "SELECT e FROM e_transaksi e WHERE e.overTime = :overTime"),
    @NamedQuery(name = "e_transaksi.findByBiayaOver", query = "SELECT e FROM e_transaksi e WHERE e.biayaOver = :biayaOver"),
    @NamedQuery(name = "e_transaksi.findByBayar", query = "SELECT e FROM e_transaksi e WHERE e.bayar = :bayar"),
    @NamedQuery(name = "e_transaksi.findByStatusTransaksi", query = "SELECT e FROM e_transaksi e WHERE e.statusTransaksi = :statusTransaksi")})
public class e_transaksi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_trans")
    private Long idTrans;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nama_sewa")
    private String namaSewa;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "alamat")
    private String alamat;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "no_telp")
    private String noTelp;
    @Basic(optional = false)
//    @NotNull
    @Column(name = "lama_sewa")
    private int lamaSewa;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tarif")
    private String tarif;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ambil")
    private String ambil;
    @Size(max = 20)
    @Column(name = "kembali")
    private String kembali;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "over_time")
    private double overTime;
    @Size(max = 50)
    @Column(name = "biaya_over")
    private String biayaOver;
    @Size(max = 50)
    @Column(name = "bayar")
    private String bayar;
    @Size(max = 20)
    @Column(name = "status_transaksi")
    private String statusTransaksi;
    @JoinColumn(name = "plat_no", referencedColumnName = "plat_no")
    @ManyToOne(optional = false)
    private e_Kendaraan platNo;
    @JoinColumn(name = "id_rental", referencedColumnName = "id_rental")
    @ManyToOne(optional = false)
    private e_rental idRental;

    public e_transaksi() {
    }

    public e_transaksi(Long idTrans) {
        this.idTrans = idTrans;
    }

    public e_transaksi(Long idTrans, String namaSewa, String alamat, String noTelp, int lamaSewa, String tarif, String ambil) {
        this.idTrans = idTrans;
        this.namaSewa = namaSewa;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.lamaSewa = lamaSewa;
        this.tarif = tarif;
        this.ambil = ambil;
    }

    public Long getIdTrans() {
        return idTrans;
    }

    public void setIdTrans(Long idTrans) {
        this.idTrans = idTrans;
    }

    public String getNamaSewa() {
        return namaSewa;
    }

    public void setNamaSewa(String namaSewa) {
        this.namaSewa = namaSewa;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public int getLamaSewa() {
        return lamaSewa;
    }

    public void setLamaSewa(int lamaSewa) {
        this.lamaSewa = lamaSewa;
    }

    public String getTarif() {
        return tarif;
    }

    public void setTarif(String tarif) {
        this.tarif = tarif;
    }

    public String getAmbil() {
        return ambil;
    }

    public void setAmbil(String ambil) {
        this.ambil = ambil;
    }

    public String getKembali() {
        return kembali;
    }

    public void setKembali(String kembali) {
        this.kembali = kembali;
    }

    public double getOverTime() {
        return overTime;
    }

    public void setOverTime(double overTime) {
        this.overTime = overTime;
    }

    public String getBiayaOver() {
        return biayaOver;
    }

    public void setBiayaOver(String biayaOver) {
        this.biayaOver = biayaOver;
    }

    public String getBayar() {
        return bayar;
    }

    public void setBayar(String bayar) {
        this.bayar = bayar;
    }

    public String getStatusTransaksi() {
        return statusTransaksi;
    }

    public void setStatusTransaksi(String statusTransaksi) {
        this.statusTransaksi = statusTransaksi;
    }

    public e_Kendaraan getPlatNo() {
        return platNo;
    }

    public void setPlatNo(e_Kendaraan platNo) {
        this.platNo = platNo;
    }

    public e_rental getIdRental() {
        return idRental;
    }

    public void setIdRental(e_rental idRental) {
        this.idRental = idRental;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrans != null ? idTrans.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof e_transaksi)) {
            return false;
        }
        e_transaksi other = (e_transaksi) object;
        if ((this.idTrans == null && other.idTrans != null) || (this.idTrans != null && !this.idTrans.equals(other.idTrans))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.e_transaksi[ idTrans=" + idTrans + " ]";
    }
    
}
