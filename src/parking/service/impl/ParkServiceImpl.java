package parking.service.impl;

import parking.builder.bay.Bay;
import parking.builder.bay.impl.Pedestrian;
import parking.service.ParkingService;

import java.util.HashMap;

public class ParkServiceImpl implements ParkingService {
    @Override
    public int park(Bay bay, Bay[][] parking) {
        int index=0;
        boolean flag=true;
        HashMap<Character,Integer> positionFirstBestPes=this.findBestSpot(parking);
        if(!(positionFirstBestPes.get('x')<0||positionFirstBestPes.get('y')<0)){

            if((int)positionFirstBestPes.get('x')/parking.length==0){
                index=(positionFirstBestPes.get('x')*parking.length)+positionFirstBestPes.get('y');
            }
            else{
                index=(positionFirstBestPes.get('x')*parking.length)-positionFirstBestPes.get('y');
            }
            if(parking[positionFirstBestPes.get('x')][positionFirstBestPes.get('y')-1].print()=='U'){
                parking[positionFirstBestPes.get('x')][positionFirstBestPes.get('y')-1]=bay;
                index=index-1;
            }
            else if(parking[positionFirstBestPes.get('x')][positionFirstBestPes.get('y')+1].print()=='U'){
                parking[positionFirstBestPes.get('x')][positionFirstBestPes.get('y')+1]=bay;
                index=index+1;
            }
        }

        return index;
    }

    private HashMap<Character, Integer> findBestSpot(Bay[][] parking) {
        HashMap<Character,Integer> position=new HashMap<>();
        int xSpot=-1;
        int ySpot=-1;
        for(int x=0;x<parking.length;x++){
            for(int y=0;y<parking.length;y++){
                if(parking[x][y] instanceof Pedestrian){
                    if(y-1>=0&&parking[x][y-1].print()=='U' || y+1<parking.length&&parking[x][y+1].print()=='U') {
                        xSpot = x;
                        ySpot = y;
                        break;
                    }
                }
            }
        }
        position.put('x',xSpot);
        position.put('y',ySpot);
        return position;
    }

}
