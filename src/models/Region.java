package models;
public class Region {
    private int id;
    private String name;
    
    public Region(){
    }
    
    public Region(int id, String name){
        this.id = id;
        this.name = name;
    }
    
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
//    public void print(){
//        System.out.format("%8s %22s", id, name);
//        System.out.println();
//        System.out.println("------------------------------------");
//    }
    
}
