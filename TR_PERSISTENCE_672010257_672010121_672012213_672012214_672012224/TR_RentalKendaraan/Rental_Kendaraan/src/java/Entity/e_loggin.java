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
@Table(name = "tbl_login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "e_loggin.findAll", query = "SELECT e FROM e_loggin e"),
    @NamedQuery(name = "e_loggin.findByIdUser", query = "SELECT e FROM e_loggin e WHERE e.idUser = :idUser"),
    @NamedQuery(name = "e_loggin.findByUserName", query = "SELECT e FROM e_loggin e WHERE e.userName = :userName"),
    @NamedQuery(name = "e_loggin.findByPassword", query = "SELECT e FROM e_loggin e WHERE e.password = :password"),
    @NamedQuery(name = "e_loggin.findByStatus", query = "SELECT e FROM e_loggin e WHERE e.status = :status")})
public class e_loggin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_user")
    private String idUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "id_rental", referencedColumnName = "id_rental")
    @ManyToOne(optional = false)
    private e_rental idRental;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private Collection<e_Kendaraan> eKendaraanCollection;

    public e_loggin() {
    }

    public e_loggin(String idUser) {
        this.idUser = idUser;
    }

    public e_loggin(String idUser, String userName, String password, String status) {
        this.idUser = idUser;
        this.userName = userName;
        this.password = password;
        this.status = status;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public e_rental getIdRental() {
        return idRental;
    }

    public void setIdRental(e_rental idRental) {
        this.idRental = idRental;
    }

    @XmlTransient
    public Collection<e_Kendaraan> getEKendaraanCollection() {
        return eKendaraanCollection;
    }

    public void setEKendaraanCollection(Collection<e_Kendaraan> eKendaraanCollection) {
        this.eKendaraanCollection = eKendaraanCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof e_loggin)) {
            return false;
        }
        e_loggin other = (e_loggin) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.e_loggin[ idUser=" + idUser + " ]";
    }
    
}
