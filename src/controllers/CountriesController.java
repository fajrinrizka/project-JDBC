/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.CountriesDAO;
import icontrollers.ICountriesController;
import idaos.ICountriesDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import models.Countries;

/**
 *
 * @author User
 */
public class CountriesController implements ICountriesController{
    private ICountriesDAO icdao;
    public CountriesController(Connection connection){
        icdao = new CountriesDAO(connection);
    }

    @Override
    public List<Countries> getAll() {
        return icdao.getAll();
    }

    @Override
    public Countries getById(String id) {
        Countries c = new Countries("0", "0", 0);
        try {
            //data kosong
            if (id.isEmpty()) {
                System.out.println("Error!!");
                System.out.println("Infailed entry");
            } //id length < 2
            else if (id.length() < 2) {
                System.out.println("Error!!");
                System.out.println("ID length is less than 2 , please enter the appropriate ID");
            } //data tidak ada
            else if (id != icdao.getById(id).getId()) {
                System.out.println("Error!!");
                System.out.println("ID doesn't exist");
            } else {
                c = icdao.getById(id);
                c.print();
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Error!!");
            System.out.println("Enter ID correctly");
        }
        return c;
    }

    @Override
    public List<Countries> search(String key) {
        List<Countries> country = new ArrayList<Countries>();
        try {
            //name kosong
            if (key.isEmpty()) {
                System.out.println("Error!!");
                System.out.println("Infailed entry");
            } //length name > 15
            else if (key.length() > 15) {
                System.out.println("Error!!");
                System.out.println("Name length is more than 15, please enter the appropriate name");
            } else {
                country = icdao.search(key);
            }
        } catch (NullPointerException npe) {
            System.out.println("Error!!");
            System.out.println("Enter data correctly");
            npe.printStackTrace();
        }
        return country;
    }

    @Override
    public Countries insert(String id, String name, String rId) {
        Countries country = new Countries(id, name, Integer.parseInt(rId));
        try {
            //name kosong
            if (name.isEmpty()) {
                System.out.println("Error!!");
                System.out.println("Infailed entry");
            } //length name > 15
            else if (name.length() > 15) {
                System.out.println("Error!!");
                System.out.println("Name length is more than 15, please enter the appropriate name");
            } //length id < 2 
            else if (id.length() < 2) {
                System.out.println("Error!!");
                System.out.println("id length is less than 2, please enter the appropriate name");
            } else {
                country = icdao.insert(country);
                System.out.println("Data Successfully inserted");
            }
        } catch (NullPointerException npe) {
            System.out.println("Error!!");
            System.out.println("Enter data correctly");
            npe.printStackTrace();
        }
        return country;
    }

    @Override
    public Countries update(String id, String name, String rId) {
        Countries country = new Countries(id, name, Integer.parseInt(rId));
        try {
            //name kosong
            if (name.isEmpty()) {
                System.out.println("Error!!");
                System.out.println("Infailed entry");
            } //length name > 15
            else if (name.length() > 15) {
                System.out.println("Error!!");
                System.out.println("Name length is more than 15, please enter the appropriate name");
            } //length id < 2 
            else if (id.length() < 2) {
                System.out.println("Error!!");
                System.out.println("id length is less than 2, please enter the appropriate name");
            } else {
                country = icdao.insert(country);
                System.out.println("Data Successfully inserted");
            }
        } catch (NullPointerException npe) {
            System.out.println("Error!!");
            System.out.println("Enter data correctly");
            npe.printStackTrace();
        }
        return country;
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
            else if (!id.equals(icdao.getById(id).getId())) {
                System.out.println("Error!!");
                System.out.println("ID doesn't exist");
            } //id length < 2 
            else if (id.length() < 2) {
                System.out.println("Error!!");
                System.out.println("ID length is less than 2 , please enter the appropriate ID");
            } else {
                icdao.delete(id);
                System.out.println("Data successfully deleted");
            }
        } catch (Exception e) {
            e.getStackTrace();
            result = "Failed!!";
        }
    }
    
    
}
