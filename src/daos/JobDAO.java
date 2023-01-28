/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IJobDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Job;
import models.Region;

/**
 *
 * @author User
 */
public class JobDAO implements IJobDAO{
    private Connection connection;

    public JobDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Job> getAll() {
        List<Job> listJob = new ArrayList<Job>();
        String query = "SELECT * FROM HR.JOBS ORDER BY job_id";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Job r = new Job(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                listJob.add(r);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listJob;
    }

    @Override
    public Job getById(String id) {
        Job job = new Job();
        String query = "SELECT * FROM HR.JOBS WHERE job_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                job.setId(resultSet.getString(1));
                job.setTitle(resultSet.getString(2));
                job.setMin(resultSet.getInt(3));
                job.setMax(resultSet.getInt(4));
            }            
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
        return job;
    }

    @Override
    public List<Job> search(String key) {
        List<Job> listJob = new ArrayList<Job>();
        String query = "SELECT * FROM HR.JOBS WHERE job_title LIKE ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + key + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Job r = new Job(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                listJob.add(r);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listJob;
    }

    @Override
    public Job insert(Job j) {
        Job result = null;
        String query = "INSERT INTO HR.JOBS (job_id, job_title, min_salary, max_salary) VALUES(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, j.getId());
            preparedStatement.setString(2, j.getTitle());
            preparedStatement.setInt(3, j.getMin());
            preparedStatement.setInt(4, j.getMax());
            preparedStatement.executeQuery();
        } catch (Exception e) {
            System.out.println("An error has occured.");
            System.out.println("See full details below.");
            e.getStackTrace();
        }
        return result;
    }

    @Override
    public Job update(Job j) {
        Job job = new Job();
        String query = "UPDATE HR.JOBS SET job_title = ?, min_salary = ?, max_salary = ? WHERE job_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(4, j.getId());
            preparedStatement.setString(1, j.getTitle());
            preparedStatement.setInt(2, j.getMin());
            preparedStatement.setInt(3, j.getMax());
            preparedStatement.executeQuery();
        } catch (Exception e) {
            System.out.println("An error has occured.");
            System.out.println("See full details below.");
            e.getStackTrace();
            return null;
        }   
        return job;
    }

    @Override
    public void delete(String id) {
        String query = "DELETE FROM HR.JOBS WHERE job_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "id");
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("An error has occured.");
            System.out.println("See full details below.");
            e.getStackTrace();
        }
    }
    
    
}
