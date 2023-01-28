package daos;

import idaos.IRegionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Region;


public class RegionDAO implements IRegionDAO{
    
    private Connection connection;
    
    public RegionDAO(Connection connection){
        this.connection = connection;
    }
    
    @Override
    public List<Region> getAll(){
        List<Region> listRegion = new ArrayList<Region>();
        String query = "SELECT * FROM HR.REGIONS ORDER BY region_id";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Region r = new Region(resultSet.getInt(1), resultSet.getString(2));
                listRegion.add(r);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listRegion;
    }
    
    @Override
    public Region getById(int id) {
        Region region = new Region();
        String query = "SELECT region_id, region_name FROM HR.REGIONS WHERE region_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                region.setId(resultSet.getInt(1));
                region.setName(resultSet.getString(2));
            }            
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
        return region;
    }
    
    
    @Override
    public List<Region> search(String key) {
        List<Region> sRegion = new ArrayList<Region>();
        String query = "SELECT * FROM HR.REGIONS WHERE (region_name) LIKE ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%"+key+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Region r = new Region(resultSet.getInt(1), resultSet.getString(2));
                sRegion.add(r);
            }            
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
        return sRegion;
    }
    
    @Override
    public Region insert(Region r) {
        Region result = null;
        String query = "INSERT INTO HR.REGIONS(region_id, region_name) VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, r.getId());
            preparedStatement.setString(2, r.getName());
            preparedStatement.executeQuery();
        } catch (Exception e) {
            System.out.println("An error has occured.");
            System.out.println("See full details below.");
            e.printStackTrace();
        }
        return result;
    }
    
    @Override
    public void delete(int id){
        String query = "DELETE FROM HR.REGIONS WHERE region_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("An error has occured.");
            System.out.println("See full details below.");
            e.printStackTrace();
        }
    }
    
    
    @Override
    public Region update(Region r){
        Region region = new Region();
        String query = "UPDATE HR.REGIONS SET region_name = ? WHERE region_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, r.getName());
            preparedStatement.setInt(2, r.getId());
            preparedStatement.executeQuery();
        } catch (Exception e) {
            System.out.println("An error has occured.");
            System.out.println("See full details below.");
            e.printStackTrace();
            return null;
        }
        return region;
    }
}

//    public List<Region> getById(int id) {
//        List<Region> region = new ArrayList<Region>();
//        String query = "SELECT region_id, region_name FROM HR.REGIONS WHERE region_id = ?";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                Region r = new Region(resultSet.getInt(1), resultSet.getString(2));
//                region.add(r);
//            }            
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
//        
//        return region;
//    }


//public boolean insert(Region r) {
//        boolean result = false;
//        String query = "INSERT INTO HR.REGIONS(region_id, region_name) VALUES (?,?)";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1, r.getId());
//            preparedStatement.setString(2, r.getName());
//            preparedStatement.executeQuery();
//            result = true;
//            System.out.println("Data successfully inserted");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }


//    public boolean delete(int id){
//        boolean result = false;
//        String query = "DELETE FROM HR.REGIONS WHERE region_id = ?";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1, id);
//            preparedStatement.executeQuery();
//            result = true;
//            System.out.println("Data successfully deleted");
//        } catch (Exception e) {
//            System.out.println("An error has occured.");
//            System.out.println("See full details below.");
//            e.printStackTrace();
//        }
//        return result;
//    }


//    public boolean update(Region r){
//        boolean result = false;
//        String query = "UPDATE HR.REGIONS SET region_name = ? WHERE region_id = ?";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, r.getName());
//            preparedStatement.setInt(2, r.getId());
//            preparedStatement.executeQuery();
//            result = true;
//            System.out.println("Data successfully updated");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }

