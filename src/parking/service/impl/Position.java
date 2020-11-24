package parking.service.impl;

import parking.service.PositionService;

import java.util.HashMap;

public class Position implements PositionService {
    private int parkingSize=0;
    public Position(){ }
    public Position(int size){
        this.parkingSize=size;

    }
    @Override
    public HashMap<Character, Integer> getPostion(int index) {
        HashMap<Character, Integer> position=new HashMap<>();
        int indexLane=(int)index/this.parkingSize;

        int indexBay=0;
        if(indexLane%this.parkingSize==0){

            indexBay=index-(int)(index*indexLane);
        }
        else{
            System.out.println("indexLane " +indexLane);
            indexBay=this.parkingSize-(index-(int)(index*indexLane));
        }
        position.put('x',indexLane);
        position.put('y',indexBay);
        return position;
    }
}
