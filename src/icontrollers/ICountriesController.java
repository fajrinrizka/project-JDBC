/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Countries;

/**
 *
 * @author User
 */
public interface ICountriesController {
    public List<Countries> getAll();
    public Countries getById(String id);
    public List<Countries> search(String key);
    public Countries insert(String id, String name, String rId);
    public Countries update(String id, String name, String rId);
    public void delete(String id);
}
