package bomberman_map.map_services.item_map_factory.items.rocks;

import bomberman_map.map_services.item_map_factory.Item;

public class EnhancerRock implements Item {
    private String rock;
    public EnhancerRock(){
        this.rock="X";
    }
    @Override
    public String draw() {
        return this.rock;
    }
}
