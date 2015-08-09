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
@Table(name = "tbl_rental")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "e_rental.findAll", query = "SELECT e FROM e_rental e"),
    @NamedQuery(name = "e_rental.findByIdRental", query = "SELECT e FROM e_rental e WHERE e.idRental = :idRental"),
    @NamedQuery(name = "e_rental.findByNamaRental", query = "SELECT e FROM e_rental e WHERE e.namaRental = :namaRental"),
    @NamedQuery(name = "e_rental.findByPemilikRental", query = "SELECT e FROM e_rental e WHERE e.pemilikRental = :pemilikRental"),
    @NamedQuery(name = "e_rental.findByAlamat", query = "SELECT e FROM e_rental e WHERE e.alamat = :alamat"),
    @NamedQuery(name = "e_rental.findByNoTelp", query = "SELECT e FROM e_rental e WHERE e.noTelp = :noTelp"),
    @NamedQuery(name = "e_rental.findByStatus", query = "SELECT e FROM e_rental e WHERE e.status = :status")})
public class e_rental implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRental")
    private Collection<e_booking> ebookingCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_rental")
    private String idRental;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nama_rental")
    private String namaRental;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pemilik_rental")
    private String pemilikRental;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "alamat")
    private String alamat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "no_telp")
    private String noTelp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRental")
    private Collection<e_loggin> elogginCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRental")
    private Collection<e_Kendaraan> eKendaraanCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRental")
    private Collection<e_transaksi> etransaksiCollection;

    public e_rental() {
    }

    public e_rental(String idRental) {
        this.idRental = idRental;
    }

    public e_rental(String idRental, String namaRental, String pemilikRental, String alamat, String noTelp, String status) {
        this.idRental = idRental;
        this.namaRental = namaRental;
        this.pemilikRental = pemilikRental;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.status = status;
    }

    public String getIdRental() {
        return idRental;
    }

    public void setIdRental(String idRental) {
        this.idRental = idRental;
    }

    public String getNamaRental() {
        return namaRental;
    }

    public void setNamaRental(String namaRental) {
        this.namaRental = namaRental;
    }

    public String getPemilikRental() {
        return pemilikRental;
    }

    public void setPemilikRental(String pemilikRental) {
        this.pemilikRental = pemilikRental;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<e_loggin> getElogginCollection() {
        return elogginCollection;
    }

    public void setElogginCollection(Collection<e_loggin> elogginCollection) {
        this.elogginCollection = elogginCollection;
    }

    @XmlTransient
    public Collection<e_Kendaraan> getEKendaraanCollection() {
        return eKendaraanCollection;
    }

    public void setEKendaraanCollection(Collection<e_Kendaraan> eKendaraanCollection) {
        this.eKendaraanCollection = eKendaraanCollection;
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
        hash += (idRental != null ? idRental.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof e_rental)) {
            return false;
        }
        e_rental other = (e_rental) object;
        if ((this.idRental == null && other.idRental != null) || (this.idRental != null && !this.idRental.equals(other.idRental))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.e_rental[ idRental=" + idRental + " ]";
    }

    @XmlTransient
    public Collection<e_booking> getEbookingCollection() {
        return ebookingCollection;
    }

    public void setEbookingCollection(Collection<e_booking> ebookingCollection) {
        this.ebookingCollection = ebookingCollection;
    }
    
}
