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
@Table(name = "tbl_booking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "e_booking.findAll", query = "SELECT e FROM e_booking e"),
    @NamedQuery(name = "e_booking.findByIdBooking", query = "SELECT e FROM e_booking e WHERE e.idBooking = :idBooking"),
    @NamedQuery(name = "e_booking.findByNamaSewa", query = "SELECT e FROM e_booking e WHERE e.namaSewa = :namaSewa"),
    @NamedQuery(name = "e_booking.findByNoHp", query = "SELECT e FROM e_booking e WHERE e.noHp = :noHp"),
    @NamedQuery(name = "e_booking.findByAlamat", query = "SELECT e FROM e_booking e WHERE e.alamat = :alamat"),
    @NamedQuery(name = "e_booking.findByLamaSewa", query = "SELECT e FROM e_booking e WHERE e.lamaSewa = :lamaSewa"),
    @NamedQuery(name = "e_booking.findByTglBooking", query = "SELECT e FROM e_booking e WHERE e.tglBooking = :tglBooking"),
    @NamedQuery(name = "e_booking.findByTglAmbil", query = "SELECT e FROM e_booking e WHERE e.tglAmbil = :tglAmbil"),
    @NamedQuery(name = "e_booking.findByJenisKendaraan", query = "SELECT e FROM e_booking e WHERE e.jenisKendaraan = :jenisKendaraan")})
public class e_booking implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_booking")
    private Long idBooking;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nama_sewa")
    private String namaSewa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "no_hp")
    private String noHp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "alamat")
    private String alamat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lama_sewa")
    private int lamaSewa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "tgl_booking")
    private String tglBooking;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "tgl_ambil")
    private String tglAmbil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "jenis_kendaraan")
    private String jenisKendaraan;
    @JoinColumn(name = "id_rental", referencedColumnName = "id_rental")
    @ManyToOne(optional = false)
    private e_rental idRental;
    @JoinColumn(name = "plat_no", referencedColumnName = "plat_no")
    @ManyToOne(optional = false)
    private e_Kendaraan platNo;

    public e_booking() {
    }

    public e_booking(Long idBooking) {
        this.idBooking = idBooking;
    }

    public e_booking(Long idBooking, String namaSewa, String noHp, String alamat, int lamaSewa, String tglBooking, String tglAmbil, String jenisKendaraan) {
        this.idBooking = idBooking;
        this.namaSewa = namaSewa;
        this.noHp = noHp;
        this.alamat = alamat;
        this.lamaSewa = lamaSewa;
        this.tglBooking = tglBooking;
        this.tglAmbil = tglAmbil;
        this.jenisKendaraan = jenisKendaraan;
    }

    public Long getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(Long idBooking) {
        this.idBooking = idBooking;
    }

    public String getNamaSewa() {
        return namaSewa;
    }

    public void setNamaSewa(String namaSewa) {
        this.namaSewa = namaSewa;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getLamaSewa() {
        return lamaSewa;
    }

    public void setLamaSewa(int lamaSewa) {
        this.lamaSewa = lamaSewa;
    }

    public String getTglBooking() {
        return tglBooking;
    }

    public void setTglBooking(String tglBooking) {
        this.tglBooking = tglBooking;
    }

    public String getTglAmbil() {
        return tglAmbil;
    }

    public void setTglAmbil(String tglAmbil) {
        this.tglAmbil = tglAmbil;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    public e_rental getIdRental() {
        return idRental;
    }

    public void setIdRental(e_rental idRental) {
        this.idRental = idRental;
    }

    public e_Kendaraan getPlatNo() {
        return platNo;
    }

    public void setPlatNo(e_Kendaraan platNo) {
        this.platNo = platNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBooking != null ? idBooking.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof e_booking)) {
            return false;
        }
        e_booking other = (e_booking) object;
        if ((this.idBooking == null && other.idBooking != null) || (this.idBooking != null && !this.idBooking.equals(other.idBooking))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.e_booking[ idBooking=" + idBooking + " ]";
    }
    
}
