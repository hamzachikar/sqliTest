package diches;

import java.util.HashMap;

public class Satelites {
    private static Satelites satelitesInstance=null;
    HashMap<String, String>  satelites = new HashMap<String, String>();
    public Satelites(){
            this.satelites.put("A","19.2°E");
            this.satelites.put("H","13.0°E");
            this.satelites.put("N","7.0°W");
    }
    public static Satelites getSatelites(){
        if(satelitesInstance==null){
            satelitesInstance=new Satelites();
        }
        return satelitesInstance;
    }
}
