/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IEmployeesDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Employees;

/**
 *
 * @author User
 */
public class EmployeesDAO implements IEmployeesDAO{
    private Connection connection;
    
    public EmployeesDAO(Connection connection){
        this.connection = connection;
    }
    

    @Override
    public List<Employees> getAll() {
        List<Employees> emp = new ArrayList<Employees>();
        String query = "SELECT * FROM HR.EMPLOYEES ORDER BY employee_id";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Employees e = new Employees(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8), resultSet.getDouble(9), resultSet.getInt(10), resultSet.getInt(11));
                emp.add(e);
            }
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
        return emp;
    }

    @Override
    public Employees getById(int id) {
        Employees emp = new Employees();
        String query = "SELECT * FROM HR.EMPLOYEES WHERE employee_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                emp.setId(resultSet.getInt(1));
                emp.setFirstName(resultSet.getString(2));
                emp.setLastName(resultSet.getString(3));
                emp.setEmail(resultSet.getString(4));
                emp.setPhone(resultSet.getString(5));
                emp.setHireDate(resultSet.getString(6));
                emp.setjId(resultSet.getString(7));
                emp.setSalary(resultSet.getInt(8));
                emp.setPct(resultSet.getDouble(9));
                emp.setmId(resultSet.getInt(10));
                emp.setdId(resultSet.getInt(11));
            }
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
        return emp;
    }

    @Override
    public List<Employees> search(String key) {
        List<Employees> emp = new ArrayList<Employees>();
        String query = "SELECT * FROM HR.EMPLOYEES WHERE last_name LIKE ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%"+key+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Employees e = new Employees(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8), resultSet.getDouble(9), resultSet.getInt(10), resultSet.getInt(11));
                emp.add(e);
            }
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
        return emp;
    }

    @Override
    public Employees insert(Employees m) {
        Employees result = null;
        String query = "INSERT INTO HR.EMPLOYEES (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, m.getId());
            preparedStatement.setString(2, m.getFirstName());
            preparedStatement.setString(3, m.getLastName());
            preparedStatement.setString(4, m.getEmail());
            preparedStatement.setString(5, m.getPhone());
            preparedStatement.setString(6, m.getHireDate());
            preparedStatement.setString(7, m.getjId());
            preparedStatement.setInt(8, m.getSalary());
            preparedStatement.setDouble(9, m.getPct());
            preparedStatement.setInt(10, m.getmId());
            preparedStatement.setInt(11, m.getdId());
            preparedStatement.executeQuery();
            System.out.println("Data successfully inserted");
        } catch (Exception e){
            System.out.println("An error has occured.");
            System.out.println("See full details below.");
            e.getStackTrace();
        }
        return result;
    }

    @Override
    public Employees update(Employees m) {
        Employees em = new Employees();
        String query = "UPDATE HR.EMPLOYEES SET first_name = ?, last_name = ?, email = ?, phone_number = ?, hire_date = ?, job_id = ?, salary = ?, commission_pct = ?, manager_id = ?, department_id = ? WHERE employee_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(11, m.getId());
            preparedStatement.setString(1, m.getFirstName());
            preparedStatement.setString(2, m.getLastName());
            preparedStatement.setString(3, m.getEmail());
            preparedStatement.setString(4, m.getPhone());
            preparedStatement.setString(5, m.getHireDate());
            preparedStatement.setString(6, m.getjId());
            preparedStatement.setInt(7, m.getSalary());
            preparedStatement.setDouble(8, m.getPct());
            preparedStatement.setInt(9, m.getmId());
            preparedStatement.setInt(10, m.getdId());
            preparedStatement.executeQuery();
            System.out.println("Data successfully updated");
        } catch (Exception e){
            System.out.println("An error has occured.");
            System.out.println("See full details below.");
            e.getStackTrace();
        }
        return em;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM HR.EMPLOYEES WHERE employee_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            System.out.println("Data successfully deleted");
        } catch (Exception e) {
            System.out.println("An error has occured.");
            System.out.println("See full details below.");
            e.getStackTrace();
        }
    }
    
    
}
