/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Entity.e_Kendaraan;
import Entity.e_loggin;
import Entity.e_rental;
import java.util.List;

/**
 *
 * @author RUBY
 */
public interface dao_kendaraan {
    public void insert(e_Kendaraan ken);
    public void delete(String id);
    public void update(e_Kendaraan ken);
    public e_Kendaraan getById(String id);
    public List<e_Kendaraan> getAll();
    public List<e_Kendaraan> getIdByJenis(String jenis);
    public List<e_Kendaraan> getKendByIdRen(e_rental ren);
    public List<e_Kendaraan> getKendByLog(e_loggin log);
    public List<e_Kendaraan> getIdKen(String st, String jen, e_rental ren);
}
