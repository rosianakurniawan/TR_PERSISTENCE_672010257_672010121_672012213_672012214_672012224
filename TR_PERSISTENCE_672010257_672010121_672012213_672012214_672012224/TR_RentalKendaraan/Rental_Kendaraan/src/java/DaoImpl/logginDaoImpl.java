/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImpl;

import Dao.dao_loggin;
import Entity.e_loggin;
import Entity.e_rental;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author RUBY
 */
public class logginDaoImpl implements dao_loggin {

    private EntityManager em;

    public logginDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void insert(e_loggin log) {
        this.em.getTransaction().begin();
        try {
            this.em.persist(log);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.em.getTransaction().rollback();
        }
    }

    @Override
    public void update(e_loggin log) {
        this.em.getTransaction().begin();
        try {
            this.em.merge(log);
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
            this.em.remove(this.em.find(e_loggin.class, id));
            this.em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.em.getTransaction().rollback();
        }
    }

    @Override
    public e_loggin getById(String id) {
        return this.em.find(e_loggin.class, id);
    }

    @Override
    public List<e_loggin> getAll() {
        return this.em.createQuery("SELECT b FROM e_loggin b").getResultList();
    }

    @Override
    public List<e_loggin> getByIdRent(e_rental ren) {
        return this.em.createQuery("SELECT b FROM e_loggin b WHERE b.id_rental =:param ")
        .setParameter("param", ren).getResultList();
    }

}
