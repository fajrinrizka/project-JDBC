/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.ICountriesDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Countries;

/**
 *
 * @author User
 */
public class CountriesDAO implements ICountriesDAO {
    private Connection connection;
    public CountriesDAO(Connection conection){
        this.connection = connection;
    }

    @Override
    public List<Countries> getAll() {
        List<Countries> country = new ArrayList<Countries>();
        String query = "SELECT * FROM HR.COUNTRIES ORDER BY country_id";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Countries c = new Countries(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
                country.add(c);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return country;
    }

    @Override
    public Countries getById(String id) {
        Countries country = new Countries();
        String query = "SELECT * FROM HR.COUNTRIES WHERE country_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                country.setId(resultSet.getString(1));
                country.setName(resultSet.getString(2));
                country.setRegId(resultSet.getInt(3));
            }            
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
        return country;
    }

    @Override
    public List<Countries> search(String key) {
        List<Countries> country = new ArrayList<Countries>();
        String query = "SELECT * FROM HR.COUNTRIES WHERE country_name LIKE ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%"+key+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Countries c = new Countries(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
                country.add(c);
            }
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
        return country;
    }

    @Override
    public Countries insert(Countries c) {
        Countries result = null;
        String query = "INSERT INTO HR.COUNTRIES(country_id, country_name, region_id) VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, c.getId());
            preparedStatement.setString(2, c.getName());
            preparedStatement.setInt(3, c.getRegId());
            preparedStatement.executeQuery();
            System.out.println("Data successfully inserted");
        } catch (Exception e) {
            System.out.println("An error has occured.");
            System.out.println("See full details below.");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Countries update(Countries c) {
        Countries country = new Countries();
        String query = "UPDATE HR.COUNTRIES SET country_name = ?, region_id = ? WHERE country_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(2, c.getId());
            preparedStatement.setString(3, c.getName());
            preparedStatement.setInt(1, c.getRegId());
            preparedStatement.executeQuery();
            System.out.println("Data successfully updated");
        } catch (Exception e) {
            System.out.println("An error has occured.");
            System.out.println("See full details below.");
            e.printStackTrace();
            return null;
        }
        return country;
    }

    @Override
    public void delete(String id) {
        String query = "DELETE FROM HR.COUNTRIES WHERE country_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.execute();
            System.out.println("Data successfully deleted");
        } catch (Exception e) {
            System.out.println("An error has occured.");
            System.out.println("See full details below.");
            e.printStackTrace();
        }
    }
    
    
}
