package elevators.main_class;

import elevators.elevator_services.IElevatorsService;
import elevators.elevator_services.implement.ElevatorsService;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private IElevatorsService elevatorsService;
     public Building(int numberOfFloor, String... elevators){
         this.elevatorsService=new ElevatorsService(elevators,numberOfFloor);
     }
     public String requestElevator(){
        return elevatorsService.requestElevator();
     }
     public String requestElevator(int numberFloorRequest){
         return elevatorsService.requestElevator(numberFloorRequest);
     }
     public void move(String idElevator,String direction){
        this.elevatorsService.move(idElevator,direction);
     }
     public void stopAt(String idElevator,int numberFloor){
        this.elevatorsService.stopAt(idElevator,numberFloor);
     }
}
