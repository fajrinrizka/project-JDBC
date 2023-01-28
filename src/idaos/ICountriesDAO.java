/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Countries;

/**
 *
 * @author User
 */
public interface ICountriesDAO {
    public List<Countries> getAll();
    public Countries getById(String id);
    public List<Countries> search(String key);
    public Countries insert(Countries c);
    public Countries update(Countries c);
    public void delete(String id);
}
