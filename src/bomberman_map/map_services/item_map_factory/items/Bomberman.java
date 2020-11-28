package bomberman_map.map_services.item_map_factory.items;

import bomberman_map.map_factory.Map;
import bomberman_map.map_services.item_map_factory.Item;

public class Bomberman implements Item {
    private String firstLetterName;
    public Bomberman(String name){
        this.firstLetterName=String.valueOf(name.charAt(0)).toLowerCase();
    }

    @Override
    public String draw() {
        return firstLetterName;
    }

    public void startIn(Map map) {
        map.addBomberman(this);
    }
}
