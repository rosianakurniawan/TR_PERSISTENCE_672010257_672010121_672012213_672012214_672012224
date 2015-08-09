/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.e_rental;
import java.util.List;

/**
 *
 * @author RUBY
 */
public interface dao_rental {

    public void insert(e_rental rent);

    public void update(e_rental rent);

    public void delete(String id);

    public e_rental getById(String id);

    public List<e_rental> getAll();

    public List<String> getIdRent();
}
