package tools;

import controllers.CountriesController;
import controllers.JobController;
import controllers.RegionController;
import daos.CountriesDAO;
import daos.EmployeesDAO;
import daos.JobDAO;
import icontrollers.IRegionController;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Countries;
import models.Employees;
import models.Job;
import models.Region;

public class OJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DBConnection connection = new DBConnection();
        RegionController rc = new RegionController(connection.getConnection());
        JobDAO job = new JobDAO(connection.getConnection());
        JobController jc = new JobController(connection.getConnection());
        EmployeesDAO emp = new EmployeesDAO(connection.getConnection());
        

//------------------------------------------------------------------------------------------------------------------------        
//        Region region = new Region();
//        region.setId(0);
//        region.setName("region");
//        System.out.println(region.getId()+ " " + region.getName());
//        Region r = new Region(1, "Region New");
//        System.out.println(r.getId()+ " " + r.getName());
        //getAll
//        RegionDAO rdao = new RegionDAO(connection.getConnection());
//        for (Region reg : rdao.getAll()){
//            System.out.println("Region ID: " + reg.getId() + ", Region Name: " + reg.getName());
//        }
        //Insert
//        IRegionDAO irdao = new RegionDAO(connection.getConnection());
//        Region region = new Region(13, "Dubai");
//        System.out.println(irdao.insert(region));
        //Delete
//        RegionDAO redo = new RegionDAO(connection.getConnection());
//        redo.delete(10);
        //getById
//        RegionDAO rd = new RegionDAO(connection.getConnection());
//        Region regi = rd.getById(4);
//        System.out.println("Region ID: " + regi.getId() + ", Region Name: " + regi.getName()); 
        //Update
//        IRegionDAO irda = new RegionDAO(connection.getConnection());
//        Region data = new Region(11, "Turkey");
//        irda.update(data);
//        System.out.println("Region ID: " + data.getId() + ", Region Name: " + data.getName());
        //Search
//        RegionDAO regi = new RegionDAO(connection.getConnection());
//        for (Region rda : regi.search("in")){
//            System.out.println("Region ID  : " + rda.getId());
//            System.out.println("Region Name: " + rda.getName());
//        }
//----------------------------------------------------------------------------------------------------------------------
//        System.out.println("------------------------------------");
//        System.out.printf("%12s %20s","REGION ID", "REGION NAME");
//        System.out.println();
//        System.out.println("====================================");
        //getAll
//        for (Region reg : rc.getAll()){
//            System.out.format("%8s %22s", reg.getId(), reg.getName());
//            System.out.println();
//            System.out.println("------------------------------------");
//        }
        //getById
//        rc.getById("14");
        //search
//        for (Region reg : rc.search("In")){
//            System.out.format("%8s %22s", reg.getId(), reg.getName());
//            System.out.println();
//            System.out.println("------------------------------------");
//        }
        //insert
//        rc.insert("15", "Jepang");
        //update
//        rc.update("14", "Turkey");
        //delete
//        rc.delete("15");
//-----------------------------------------------------------------------------------------------------------------------
        //getAll()
//        for (Job jb : job.getAll()){
//            System.out.format("%10s %32s %10s %15s", jb.getId(), jb.getTitle(), jb.getMin(), jb.getMax());
//            System.out.println();
//            System.out.println("----------------------------------------------------------------------------");
//        }  
        //getById
//        Job jo = job.getById("AC_ACCOUNT");
//        System.out.format("%10s %32s %10s %15s", jo.getId(), jo.getTitle(), jo.getMin(), jo.getMax());
//        System.out.println();
//        System.out.println("----------------------------------------------------------------------------");
        //search
//        for (Job j : job.search("A")){
//            System.out.format("%10s %32s %10s %15s", j.getId(), j.getTitle(), j.getMin(), j.getMax());
//            System.out.println();
//            System.out.println("----------------------------------------------------------------------------");
//        }
        //Insert
//        Job jobs = new Job("MCC_74", "Application Developer", 10000, 36000);
//        job.insert(jobs);
//        System.out.println("----------------------------------------------------------------------------");
//        System.out.format("%10s %32s %10s %15s", jobs.getId(), jobs.getTitle(), jobs.getMin(), jobs.getMax());
//        System.out.println();
//        System.out.println("----------------------------------------------------------------------------");
        //update
//        Job jbs = new Job("MCC_75", "Application Developer Jr.", 10000, 36000);
//        job.update(jbs);
//        System.out.println("----------------------------------------------------------------------------");
//        System.out.format("%10s %32s %10s %15s", jbs.getId(), jbs.getTitle(), jbs.getMin(), jbs.getMax());
//        System.out.println();
//        System.out.println("----------------------------------------------------------------------------");
        //Delete
//        job.delete("MCC_74");
//------------------------------------------------------------------------------------------------------------------------------
//        System.out.println("----------------------------------------------------------------------------");
//        System.out.printf("%8s %25s %22s %15s","JOB ID", "JOB TITLE", "MIN SALARY", "MAX SALARY");
//        System.out.println();
//        System.out.println("============================================================================");
//        //getAll
//        for (Job j : jc.getAll()){
//            System.out.format("%10s %32s %10s %15s", j.getId(), j.getTitle(), j.getMin(), j.getMax());
//            System.out.println();
//            System.out.println("----------------------------------------------------------------------------");
//        }
        //getById
//        jc.getById("MCC_75");
        //search
//        for (Job jo : jc.search("ant")){
//            System.out.format("%10s %32s %10s %15s", j.getId(), j.getTitle(), j.getMin(), j.getMax());
//            System.out.println();
//            System.out.println("----------------------------------------------------------------------------");
//        }
        //insert
//        jc.insert("MCC_75", "Application Developer", "3000", "36000");
        //update
//        jc.update("MCC_75", "Application Developer Jr.", "3600", "36000");
        //delete
//        jc.delete("MCC_75");
//-----------------------------------------------------------------------------------------------------------------------
        //getAll()
//        for (Employees em : emp.getAll()){
//            em.enter();
//            }  
        //getById
//        Employees jo = emp.getById(210);
//        jo.enter();
        //search
//        for (Employees j : emp.search("K")){
//            j.enter();
//        }
        //Insert
//        Employees employ;
//        employ = new Employees(210, "Rizka", "Fajrin", "KAA", "999.888.7777", "01-01-2023", "MCC_74", 3600, 0, 100, 30);
//        emp.insert(employ);
        //update
//        Employees jbs = new Employees(210, "Rizka", "Fajrin", "KAA", "666.555.444", "01-01-2023", "MCC_74", 3600, 0, 100, 30);
//        emp.update(jbs);
        //Delete
//        emp.delete(210);
//---------------------------------------------------------------------------------------------------------------------------------
        while (true) {
            System.out.println();
            System.out.println("==== MENU HR SCHEMA ====");
            System.out.println("==== REGIONS ====");
            System.out.println("1. Get all data Region");
            System.out.println("2. Get data Region by region id");
            System.out.println("3. Search data Region");
            System.out.println("4. Insert data Region");
            System.out.println("5. Update data Region");
            System.out.println("6. Delete data Region");
            System.out.println("==== JOBS ====");
            System.out.println("7. Get all data Job");
            System.out.println("8. Get data Job by job id");
            System.out.println("9. Search data Job");
            System.out.println("10. Insert data Job");
            System.out.println("11. Update data Job");
            System.out.println("12. Delete data Job");
            System.out.println("13. Exit");
            System.out.println();
            System.out.println("Choose menu: ");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.println("------------------------------------");
                    System.out.printf("%12s %20s", "REGION ID", "REGION NAME");
                    System.out.println();
                    System.out.println("====================================");
                    for (Region reg : rc.getAll()) {
                        System.out.format("%8s %22s", reg.getId(), reg.getName());
                        System.out.println();
                        System.out.println("------------------------------------");
                    }
                    break;
                case 2:
                    System.out.println();
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter region id: ");
                    String id = sc.nextLine();
                    System.out.println();
                    System.out.println("------------------------------------");
                    System.out.printf("%12s %20s", "REGION ID", "REGION NAME");
                    System.out.println();
                    System.out.println("====================================");
                    rc.getById(id);
                    break;
                case 3:
                    System.out.println();
                    Scanner sca = new Scanner(System.in);
                    System.out.println("Enter the keyword: ");
                    String key = sca.nextLine();
                    System.out.println();
                    System.out.println("------------------------------------");
                    System.out.printf("%12s %20s", "REGION ID", "REGION NAME");
                    System.out.println();
                    System.out.println("====================================");
                    for (Region reg : rc.search(key)) {
                        System.out.format("%8s %22s", reg.getId(), reg.getName());
                        System.out.println();
                        System.out.println("------------------------------------");
                    }
                    break;
                case 4:
                    System.out.println();
                    Scanner sa = new Scanner(System.in);
                    System.out.println("Enter region id: ");
                    String rid = sa.nextLine();
                    System.out.println("Enter region name: ");
                    String rname = sa.nextLine();
                    System.out.println();
                    rc.insert(rid, rname);
                    break;
                case 5:
                    System.out.println();
                    Scanner sn = new Scanner(System.in);
                    System.out.println("Enter region id: ");
                    String reid = sn.nextLine();
                    System.out.println("Enter region name: ");
                    String rename = sn.nextLine();
                    System.out.println();
                    rc.update(reid, rename);
                    break;
                case 6:
                    System.out.println();
                    Scanner sr = new Scanner(System.in);
                    System.out.println("Enter region id: ");
                    String raid = sr.nextLine();
                    System.out.println();
                    rc.delete(raid);
                    break;
                case 7:
                    System.out.println();
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.printf("%8s %25s %22s %15s", "JOB ID", "JOB TITLE", "MIN SALARY", "MAX SALARY");
                    System.out.println();
                    System.out.println("============================================================================");
                    for (Job j : jc.getAll()) {
                        System.out.format("%-15s %-32s %-15s %-15s", j.getId(), j.getTitle(), j.getMin(), j.getMax());
                        System.out.println();
                        System.out.println("----------------------------------------------------------------------------");
                    }
                    break;
                case 8:
                    System.out.println();
                    Scanner scj = new Scanner(System.in);
                    System.out.println("Enter job id: ");
                    String Jid = scj.nextLine();
                    System.out.println();
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.printf("%8s %25s %22s %15s", "JOB ID", "JOB TITLE", "MIN SALARY", "MAX SALARY");
                    System.out.println();
                    System.out.println("============================================================================");
                    jc.getById(Jid);
                    break;
                case 9:
                    System.out.println();
                    Scanner scaj = new Scanner(System.in);
                    System.out.println("Enter the keyword: ");
                    String Jkey = scaj.nextLine();
                    System.out.println();
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.printf("%8s %25s %22s %15s", "JOB ID", "JOB TITLE", "MIN SALARY", "MAX SALARY");
                    System.out.println();
                    System.out.println("============================================================================");
                    for (Job jo : jc.search(Jkey)) {
                        System.out.format("%-15s %-32s %-15s %-15s", jo.getId(), jo.getTitle(), jo.getMin(), jo.getMax());
                        System.out.println();
                        System.out.println("----------------------------------------------------------------------------");
                    }
                    break;
                case 10:
                    System.out.println();
                    Scanner saj = new Scanner(System.in);
                    System.out.println("Enter job id: ");
                    String jid = saj.nextLine();
                    System.out.println("Enter job title: ");
                    String jname = saj.nextLine();
                    System.out.println("Enter min salary: ");
                    String jmin = saj.nextLine();
                    System.out.println("Enter max salary: ");
                    String jmax = saj.nextLine();
                    System.out.println();
                    jc.insert(jid, jname, jmin, jmax);
                    break;
                case 11:
                    System.out.println();
                    Scanner snj = new Scanner(System.in);
                    System.out.println("Enter job id: ");
                    String joid = snj.nextLine();
                    System.out.println("Enter job title: ");
                    String joname = snj.nextLine();
                    System.out.println("Enter min salary: ");
                    String jomin = snj.nextLine();
                    System.out.println("Enter max salary: ");
                    String jomax = snj.nextLine();
                    System.out.println();
                    jc.insert(joid, joname, jomin, jomax);
                    break;
                case 12:
                    System.out.println();
                    Scanner sj = new Scanner(System.in);
                    System.out.println("Enter job id: ");
                    String jbid = sj.nextLine();
                    System.out.println();
                    jc.delete(jbid);
                    break;
                case 13:
                    System.out.println();
                    System.out.println("Thank you for using this program ^_^ ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Menu is not available");
                    break;
            }
        }
    }
}
