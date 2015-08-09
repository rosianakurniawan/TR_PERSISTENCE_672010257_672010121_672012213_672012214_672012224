/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Entity.e_loggin;
import Entity.e_rental;
import java.util.List;

/**
 *
 * @author RUBY
 */
public interface dao_loggin {
    public void insert(e_loggin log);
    public void update(e_loggin log);
    public void delete(String id);
    public e_loggin getById(String id);
    public List<e_loggin> getAll();
    public List<e_loggin> getByIdRent(e_rental ren);
}
