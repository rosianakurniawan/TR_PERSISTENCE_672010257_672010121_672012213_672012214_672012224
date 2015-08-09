/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DaoImpl;

import Dao.dao_transaksi;
import Entity.e_Kendaraan;
import Entity.e_rental;
import Entity.e_transaksi;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author RUBY
 */
public class transaksiDaoImpl implements dao_transaksi{

    private EntityManager em;
    
    public transaksiDaoImpl(EntityManager em){
        this.em = em;
    }

    @Override
    public void insert(e_transaksi tr) {
        this.em.getTransaction().begin();
        try {
            this.em.persist(tr);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.em.getTransaction().rollback();
        }
    }

    @Override
    public void update(e_transaksi tr) {
        this.em.getTransaction().begin();
        try {
            this.em.merge(tr);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(long id) {
        this.em.getTransaction().begin();
        try {
            this.em.remove(this.em.find(e_transaksi.class, id));
            this.em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.em.getTransaction().rollback();
        }
    }

    @Override
    public e_transaksi getById(long id) {
        return this.em.find(e_transaksi.class, id);
    }

    @Override
    public List<e_transaksi> getAll() {
        return this.em.createQuery("SELECT tr FROM e_transaksi tr").getResultList();
    }

    @Override
    public List<e_transaksi> getTransByken(e_Kendaraan ken) {
        return this.em.createQuery("SELECT tr FROM e_transaksi tr WHERE tr.platNo =:param ")
        .setParameter("param", ken).getResultList();
    }

    @Override
    public List<e_transaksi> getTransByIdRent(e_rental ren) {
        return this.em.createQuery("SELECT tr FROM e_transaksi tr WHERE tr.idRental =:param ")
        .setParameter("param", ren).getResultList();
    }

    @Override
    public List<e_transaksi> getAllByJenis(String jenis,String sat, e_rental ren) {
        return this.em.createQuery("SELECT tr FROM e_transaksi tr WHERE tr.platNo.jenisKendaraan='"+jenis+"' and tr.idRental =:param and tr.statusTransaksi = '"+sat+"'").
                setParameter("param", ren).getResultList();
    }

    @Override
    public List<e_transaksi> getAllTransLunas(String Stat, e_rental ren) {
        return this.em.createQuery("SELECT tr FROM e_transaksi tr WHERE tr.idRental =:param and tr.statusTransaksi = '"+Stat+"'").
                setParameter("param", ren).getResultList();
    }
}
