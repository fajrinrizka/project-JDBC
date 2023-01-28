/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author User
 */
public class Countries {
    private String id;
    private String name;
    private int regId;

    public Countries() {
    }

    public Countries(String id, String name, int regId) {
        this.id = id;
        this.name = name;
        this.regId = regId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRegId() {
        return regId;
    }

    public void setRegId(int regId) {
        this.regId = regId;
    }
    
    public void print(){
        System.out.format("%8s %22s %15", id, name, regId);
        System.out.println();
        System.out.println("--------------------------------------------");
    }
}
