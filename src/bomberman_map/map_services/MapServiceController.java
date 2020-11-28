package bomberman_map.map_services;

import bomberman_map.map_services.item_map_factory.Item;
import bomberman_map.map_services.item_map_factory.items.Bomberman;
import bomberman_map.map_services.item_map_factory.items.rocks.SimpleRock;

public class MapServiceController implements MapService {
    private int sizeMap;
    private Item[][]mapItems;
    private MapServiceController(int sizeMap){
        this.sizeMap=sizeMap;
        this.mapItems=new Item[sizeMap][sizeMap];
    }

    @Override
    public void addRock(int line, int column) {
        this.mapItems[line][column]=new SimpleRock();
    }

    @Override
    public String draw() {
        String map="";
        for(int line=0;line<this.sizeMap;line++){
            for(Item itemColumn:this.mapItems[line]){
                if(itemColumn!=null){
                    map=map+itemColumn.draw();
                }
                else{
                    map=map+" ";
                }
            }
            if(line<this.sizeMap-1){
                map=map+"\n";
            }
        }
        return map;
    }

    @Override
    public void addBomberman(Bomberman bomberman) {
        this.mapItems[0][0]=bomberman;
    }
}
