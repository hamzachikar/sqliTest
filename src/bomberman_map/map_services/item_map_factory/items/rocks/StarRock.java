package bomberman_map.map_services.item_map_factory.items.rocks;

import bomberman_map.map_services.item_map_factory.Item;

public class StarRock implements Item {
    private String rock;
    public StarRock(){
        this.rock="X";
    }
    @Override
    public String draw() {
        return this.rock;
    }
}
