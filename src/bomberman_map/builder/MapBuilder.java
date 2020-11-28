package bomberman_map.builder;

import bomberman_map.map_factory.Map;

public class MapBuilder {
    private Map map;
    public MapBuilder(int mapSize) {
        this.map=new Map(mapSize);
    }

    public MapBuilder addRock(int line, int column) {
        this.map.addRock(line,column);
        return this;
    }

    public Map build() {
        return this.map;
    }
}
