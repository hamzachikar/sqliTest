package bomberman_map.map_factory;

import bomberman_map.map_services.MapService;
import bomberman_map.map_services.MapServiceController;
import bomberman_map.map_services.item_map_factory.items.Bomberman;

public class Map{
    private MapService mapService;
    public Map(int sizeMap){
      //  this.mapService=new MapServiceController(sizeMap);
    }

    public void addRock(int line, int column) {
        this.mapService.addRock(line, column);
    }

    public String draw() {
        return this.mapService.draw();
    }

    public void addBomberman(Bomberman bomberman) {
        this.mapService.addBomberman(bomberman);
    }
}
