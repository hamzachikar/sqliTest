package parking;

import parking.builder.bay.Bay;
import parking.builder.bay.impl.DisableBay;
import parking.builder.bay.impl.NonDisabledBay;
import parking.service.ParkingService;
import parking.service.impl.ParkServiceImpl;

import java.util.List;

public class Parking {
    private Bay[][] parkSquare={};
    private int freeBayCells=0;
    private ParkingService parkingService=new ParkServiceImpl();
    public void setParkSquare(Bay[][] parkSquare) {
        this.parkSquare = parkSquare;
    }
    public void setBaySlot(int x,int y,Bay bay){
        this.parkSquare[x][y]=bay;
    }

    public int parkCar(char c) {
        switch (c){
            case 'D':
                return this.parkingService.park(new DisableBay().setNotEmptyState(),this.parkSquare);
            default:
                return this.parkingService.park(new NonDisabledBay().setNotEmptyState(c),this.parkSquare) ;
        }
    }

    public int countAvailableCells() {
        return this.freeBayCells;
    }
    @Override
    public String toString(){
        String parking="";
        for(int x=0;x<this.parkSquare.length;x++){
            for(int y=0;y<this.parkSquare.length;y++){
                parking=parking+this.parkSquare[x][y].print();
                if(y==this.parkSquare.length&&x!=this.parkSquare.length){
                    parking=parking+"\n";
                }
            }
        }
        return parking;
    }
}
