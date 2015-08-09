/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DaoImpl;

import Dao.dao_booking;
import Entity.e_Kendaraan;
import Entity.e_booking;
import Entity.e_rental;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author RUBY
 */
public class bookingDaoImpl implements dao_booking{

    private EntityManager em;
    
    public bookingDaoImpl(EntityManager em){
        this.em = em;
    }
    
    @Override
    public void insert(e_booking bok) {
        this.em.getTransaction().begin();
        try {
            this.em.persist(bok);
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
            this.em.remove(this.em.find(e_booking.class, id));
            this.em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.em.getTransaction().rollback();
        }
    }

    @Override
    public void update(e_booking bok) {
        this.em.getTransaction().begin();
        try {
            this.em.merge(bok);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.em.getTransaction().rollback();
        }
    }

    @Override
    public e_booking getById(long id) {
        return this.em.find(e_booking.class, id);
    }

    @Override
    public List<e_booking> getAll() {
        return this.em.createQuery("SELECT tr FROM e_booking tr").getResultList();
    }

    @Override
    public List<e_booking> getIdByJenis(String jenis, e_rental ren) {
        return this.em.createQuery("SELECT tr FROM e_booking tr WHERE tr.jenisKendaraan='"+jenis+"' and tr.idRental=:param").
                setParameter("param", ren).getResultList();
    }

    @Override
    public List<e_booking> getAllByIdRent(e_rental ren) {
        return this.em.createQuery("SELECT tr FROM e_booking tr WHERE tr.idRental=:param").
                setParameter("param", ren).getResultList();
    }
    
}
