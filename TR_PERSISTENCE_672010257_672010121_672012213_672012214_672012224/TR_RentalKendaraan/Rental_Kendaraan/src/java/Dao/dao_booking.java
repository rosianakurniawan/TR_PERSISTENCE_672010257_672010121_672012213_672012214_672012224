/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Entity.e_Kendaraan;
import Entity.e_booking;
import Entity.e_rental;
import java.util.List;

/**
 *
 * @author RUBY
 */
public interface dao_booking {
    public void insert(e_booking bok);
    public void delete(long id);
    public void update(e_booking bok);
    public e_booking getById(long id);
    public List<e_booking> getAll();
    public List<e_booking> getIdByJenis(String jenis, e_rental ren);
    public List<e_booking> getAllByIdRent(e_rental ren);
}
