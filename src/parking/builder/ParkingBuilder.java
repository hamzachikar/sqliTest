package parking.builder;

import parking.Parking;
import parking.builder.bay.Bay;
import parking.builder.bay.impl.DisableBay;
import parking.builder.bay.impl.NonDisabledBay;
import parking.builder.bay.impl.Pedestrian;
import parking.service.PositionService;
import parking.service.impl.Position;

import java.util.Arrays;
import java.util.HashMap;

public class ParkingBuilder {
    private Parking parking=new Parking();
    private PositionService positionService=new Position();
    public ParkingBuilder withSquareSize(int size){
        Bay[][] park=new Bay[size][size];
        for(int x=0;x<size;x++){
            for(int y=0;y<size;y++){
                park[x][y]=new NonDisabledBay();
            }
        }
        System.out.println(park.length);
        this.parking.setParkSquare(park);
        this.positionService=new Position(size);
        return this;
    }
    public ParkingBuilder withPedestrianExit(int index){
        HashMap<Character, Integer> position=this.positionService.getPostion(index);
        System.out.println(position.get('x')+"++++"+position.get('y'));
        this.parking.setBaySlot(position.get('x'),position.get('y'),new Pedestrian());
        return this;
    }
    public ParkingBuilder withDisabledBay(int index){
        HashMap<Character, Integer> position=this.positionService.getPostion(index);
        this.parking.setBaySlot(position.get('x'),position.get('y'),new DisableBay());
        return this;
    }
    public Parking build(){
        return this.parking;
    }

}
