/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Employees;

/**
 *
 * @author User
 */
public interface IEmployeesDAO {
    public List<Employees> getAll();
    public Employees getById(int id);
    public List<Employees> search(String key);
    public Employees insert(Employees m);
    public Employees update(Employees m);
    public void delete(int id);
}
