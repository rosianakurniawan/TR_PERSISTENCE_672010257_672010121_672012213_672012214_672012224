/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RUBY
 */
@Entity
@Table(name = "tbl_kendaraan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "e_Kendaraan.findAll", query = "SELECT e FROM e_Kendaraan e"),
    @NamedQuery(name = "e_Kendaraan.findByPlatNo", query = "SELECT e FROM e_Kendaraan e WHERE e.platNo = :platNo"),
    @NamedQuery(name = "e_Kendaraan.findByJenisKendaraan", query = "SELECT e FROM e_Kendaraan e WHERE e.jenisKendaraan = :jenisKendaraan"),
    @NamedQuery(name = "e_Kendaraan.findByGambar", query = "SELECT e FROM e_Kendaraan e WHERE e.gambar = :gambar"),
    @NamedQuery(name = "e_Kendaraan.findByStatus", query = "SELECT e FROM e_Kendaraan e WHERE e.status = :status")})
public class e_Kendaraan implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "platNo")
    private Collection<e_booking> ebookingCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "plat_no")
    private String platNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "jenis_kendaraan")
    private String jenisKendaraan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "gambar")
    private String gambar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private e_loggin idUser;
    @JoinColumn(name = "id_rental", referencedColumnName = "id_rental")
    @ManyToOne(optional = false)
    private e_rental idRental;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "platNo")
    private Collection<e_transaksi> etransaksiCollection;

    public e_Kendaraan() {
    }

    public e_Kendaraan(String platNo) {
        this.platNo = platNo;
    }

    public e_Kendaraan(String platNo, String jenisKendaraan, String gambar, String status) {
        this.platNo = platNo;
        this.jenisKendaraan = jenisKendaraan;
        this.gambar = gambar;
        this.status = status;
    }

    public String getPlatNo() {
        return platNo;
    }

    public void setPlatNo(String platNo) {
        this.platNo = platNo;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public e_loggin getIdUser() {
        return idUser;
    }

    public void setIdUser(e_loggin idUser) {
        this.idUser = idUser;
    }

    public e_rental getIdRental() {
        return idRental;
    }

    public void setIdRental(e_rental idRental) {
        this.idRental = idRental;
    }

    @XmlTransient
    public Collection<e_transaksi> getEtransaksiCollection() {
        return etransaksiCollection;
    }

    public void setEtransaksiCollection(Collection<e_transaksi> etransaksiCollection) {
        this.etransaksiCollection = etransaksiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (platNo != null ? platNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof e_Kendaraan)) {
            return false;
        }
        e_Kendaraan other = (e_Kendaraan) object;
        if ((this.platNo == null && other.platNo != null) || (this.platNo != null && !this.platNo.equals(other.platNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.e_Kendaraan[ platNo=" + platNo + " ]";
    }

    @XmlTransient
    public Collection<e_booking> getEbookingCollection() {
        return ebookingCollection;
    }

    public void setEbookingCollection(Collection<e_booking> ebookingCollection) {
        this.ebookingCollection = ebookingCollection;
    }
    
}
