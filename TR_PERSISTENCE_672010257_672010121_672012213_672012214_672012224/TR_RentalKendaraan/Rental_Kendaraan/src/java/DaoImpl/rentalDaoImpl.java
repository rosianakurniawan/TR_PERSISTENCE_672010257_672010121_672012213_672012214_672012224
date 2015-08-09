/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImpl;

import Dao.dao_rental;
import Entity.e_rental;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author RUBY
 */
public class rentalDaoImpl implements dao_rental {

    private EntityManager em;

    public rentalDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void insert(e_rental rent) {
        this.em.getTransaction().begin();
        try {
            this.em.persist(rent);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.em.getTransaction().rollback();
        }
    }

    @Override
    public void update(e_rental rent) {
        this.em.getTransaction().begin();
        try {
            this.em.merge(rent);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(String id) {
        this.em.getTransaction().begin();
        try {
            this.em.remove(this.em.find(e_rental.class, id));
            this.em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.em.getTransaction().rollback();
        }
    }

    @Override
    public e_rental getById(String id) {
        return this.em.find(e_rental.class, id);
    }

    @Override
    public List<e_rental> getAll() {
        return this.em.createQuery("SELECT r FROM e_rental r").getResultList();
    }

    @Override
    public List<String> getIdRent() {
        return this.em.createQuery("SELECT r.id_rental FROM e_rental r WHERE r.status = 'Ada' ").getResultList();
    }

}
