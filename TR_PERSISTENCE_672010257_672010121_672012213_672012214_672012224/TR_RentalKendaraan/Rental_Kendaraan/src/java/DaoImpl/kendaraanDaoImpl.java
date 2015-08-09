/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DaoImpl;

import Dao.dao_kendaraan;
import Entity.e_Kendaraan;
import Entity.e_loggin;
import Entity.e_rental;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author RUBY
 */
public class kendaraanDaoImpl implements dao_kendaraan{

    private EntityManager em;

    public kendaraanDaoImpl(EntityManager em) {
        this.em = em;
    }
    
    @Override
    public void insert(e_Kendaraan ken) {
        this.em.getTransaction().begin();
        try {
            this.em.persist(ken);
            this.em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            this.em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(String id) {
        this.em.getTransaction().begin();
        try {
            this.em.remove(this.em.find(e_Kendaraan.class, id));
            this.em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            this.em.getTransaction().rollback();
        }
    }

    @Override
    public void update(e_Kendaraan ken) {
        this.em.getTransaction().begin();
        try {
            this.em.merge(ken);
            this.em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            this.em.getTransaction().rollback();
        }
    }

    @Override
    public e_Kendaraan getById(String id) {
        return this.em.find(e_Kendaraan.class, id);
    }

    @Override
    public List<e_Kendaraan> getAll() {
        return this.em.createQuery("SELECT ken FROM e_Kendaraan ken").getResultList();
    }

    @Override
    public List<e_Kendaraan> getKendByIdRen(e_rental ren) {
        return this.em.createQuery("SELECT ken FROM e_Kendaraan ken WHERE ken.idRental =:param ")
        .setParameter("param", ren).getResultList();
    }

    @Override
    public List<e_Kendaraan> getKendByLog(e_loggin log) {
        return this.em.createQuery("SELECT ken FROM e_Kendaraan ken WHERE ken.idUser =:param ")
        .setParameter("param", log).getResultList();
    }

    @Override
    public List<e_Kendaraan> getIdByJenis(String jenis) {
        return this.em.createQuery("SELECT ken FROM e_Kendaraan ken WHERE ken.jenisKendaraan = '"+jenis+"'").getResultList();
    }

    @Override
    public List<e_Kendaraan> getIdKen(String st, String jen, e_rental ren) {
        return this.em.createQuery("SELECT ken FROM e_Kendaraan ken WHERE ken.idRental=:param and ken.jenisKendaraan='"+jen+"' and ken.status='"+st+"'")
                .setParameter("param", ren).getResultList();
    }
}
