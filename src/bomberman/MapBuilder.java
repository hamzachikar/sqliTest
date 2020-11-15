package bomberman;

class MapBuilder {
    Map map;
    public MapBuilder(int size) {
        this.map = new Map(size) ;
    }
    MapBuilder addRock(int i, int j) {
        this.map.map[i][j] = "X";
        return this;
    }
    MapBuilder addStarRock(int i,int j){
        this.map.map[i][j] = "X";
        this.map.startRocks.add(new int[]{i, j});
        return this;
    }
    MapBuilder addEnhancerRock(int i,int j,int range){
        this.map.map[i][j] = "X";
        this.map.enhancerRock.add(new int[]{i, j, range});
        return this;
    }
    Map build() {
        return this.map;
    }
}