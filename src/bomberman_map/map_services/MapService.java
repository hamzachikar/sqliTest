package bomberman_map.map_services;

import bomberman_map.map_services.item_map_factory.items.Bomberman;

public interface MapService {
    void addRock(int line, int column);
    String draw();

    void addBomberman(Bomberman bomberman);
}
