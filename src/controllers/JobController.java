/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.JobDAO;
import icontrollers.IJobController;
import idaos.IJobDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import models.Job;

/**
 *
 * @author User
 */
public class JobController implements IJobController {

    private IJobDAO ijdao;

    public JobController(Connection connection) {
        ijdao = new JobDAO(connection);
    }

    @Override
    public List<Job> getAll() {
        return ijdao.getAll();
    }

    @Override
    public Job getById(String id) {
        Job j = new Job("0", "0", 0, 0);
        try {
            //data kosong
            if (id.isEmpty()) {
                System.out.println("Error!!");
                System.out.println("Infailed entry");
            } //id length > 20
            else if (id.length() > 20) {
                System.out.println("Error!!");
                System.out.println("ID length is more than 20, please enter the appropriate ID");
            } else {
                j = ijdao.getById(id);
                System.out.format("%-15s %-32s %-15s %-15s", j.getId(), j.getTitle(), j.getMin(), j.getMax());
                System.out.println();
                System.out.println("----------------------------------------------------------------------------");
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Error!!");
            System.out.println("Enter ID correctly");
        }
        return j;
    }

    @Override
    public List<Job> search(String key) {
        List<Job> job = new ArrayList<Job>();
        try {
            //name kosong
            if (key.isEmpty()) {
                System.out.println("Error!!");
                System.out.println("Infailed entry");
            } //length name > 30
            else if (key.length() > 30) {
                System.out.println("Error!!");
                System.out.println("Name length is more than 30, please enter the appropriate name");
            } else {
                job = ijdao.search(key);
            }
        } catch (NullPointerException npe) {
            System.out.println("Error!!");
            System.out.println("Enter data correctly");
            npe.printStackTrace();
        }
        return job;
    }

    @Override
    public Job insert(String id, String title, String min, String max) {
        Job job = new Job(id, title, Integer.parseInt(min), Integer.parseInt(max));
        try {
            //name kosong
            if (title.isEmpty()) {
                System.out.println("Error!!");
                System.out.println("Infailed entry");
            } //length name > 30
            else if (title.length() > 30) {
                System.out.println("Error!!");
                System.out.println("Name length is more than 30, please enter the appropriate name");
            } //length name < 5 
            else if (title.length() < 5) {
                System.out.println("Error!!");
                System.out.println("Name length is less than 5, please enter the appropriate name");
            } //min salary < 2000
            else if (Integer.parseInt(min) < 2000) {
                System.out.println("Error!!");
                System.out.println("Min salary is less than 2000, please enter the appropriate min salary");
            } //max salary > 50000
            else if (Integer.parseInt(max) > 50000) {
                System.out.println("Error!!");
                System.out.println("Max salary is more than 50000, please enter the appropriate max salary");
            } else {
                job = ijdao.insert(job);
                System.out.println("Data Successfully inserted");
            }
        } catch (NullPointerException npe) {
            System.out.println("Error!!");
            System.out.println("Enter data correctly");
            npe.printStackTrace();
        }
        return job;
    }

    @Override
    public Job update(String id, String title, String min, String max) {
        Job job = new Job(id, title, Integer.parseInt(min), Integer.parseInt(max));
        try {
            //name kosong
            if (title.isEmpty()) {
                System.out.println("Error!!");
                System.out.println("Infailed entry");
            } //length name > 30
            else if (title.length() > 30) {
                System.out.println("Error!!");
                System.out.println("Name length is more than 30, please enter the appropriate name");
            } //length name < 5 
            else if (title.length() < 5) {
                System.out.println("Error!!");
                System.out.println("Name length is less than 5, please enter the appropriate name");
            } //min salary < 2000
            else if (Integer.parseInt(min) < 2000) {
                System.out.println("Error!!");
                System.out.println("Min salary is less than 2000, please enter the appropriate min salary");
            } //max salary > 50000
            else if (Integer.parseInt(max) > 50000) {
                System.out.println("Error!!");
                System.out.println("Max salary is more than 50000, please enter the appropriate max salary");
            } else {
                job = ijdao.update(job);
                System.out.println("Data Successfully updated");
            }
        } catch (NullPointerException npe) {
            System.out.println("Error!!");
            System.out.println("Enter data correctly");
            npe.printStackTrace();
        }
        return job;
    }

    @Override
    public void delete(String id) {
        String result = "";
        try {
            //id kosong
            if (id.isEmpty()) {
                System.out.println("Error!!");
                System.out.println("Infailed entry");
            } //data tidak ada di tabel
            else if (!id.equals(ijdao.getById(id).getId())) {
                System.out.println("Error!!");
                System.out.println("ID doesn't exist");
            } //id length < 2 
            else if (id.length() < 2) {
                System.out.println("Error!!");
                System.out.println("ID length is less than 2 , please enter the appropriate ID");
            } else {
                ijdao.delete(id);
                System.out.println("Data successfully deleted");
            }
        } catch (Exception e) {
            e.getStackTrace();
            result = "Failed!!";
        }
    }

}
