/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Entity.e_Kendaraan;
import Entity.e_rental;
import Entity.e_transaksi;
import java.util.List;

/**
 *
 * @author RUBY
 */
public interface dao_transaksi {
    public void insert(e_transaksi tr);
    public void update(e_transaksi tr);
    public void delete(long id);
    public e_transaksi getById(long id);
    public List<e_transaksi> getAll();
    public List<e_transaksi> getAllByJenis(String jenis, String sat, e_rental ren);
    public List<e_transaksi> getTransByIdRent(e_rental ren);
    public List<e_transaksi> getTransByken(e_Kendaraan ken);
    public List<e_transaksi> getAllTransLunas(String Stat, e_rental ren);
}
