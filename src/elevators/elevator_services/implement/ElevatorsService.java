package elevators.elevator_services.implement;

import elevators.elevator_services.IElevatorsService;
import elevators.main_class.Elevator;

import java.util.ArrayList;
import java.util.List;

public class ElevatorsService implements IElevatorsService {
    private int requestFloor;
    private int numberOfFloor;
    List<Elevator> elevators;
    public ElevatorsService(String[] elevatorsProps,int numberOfFloor){
        this.requestFloor=numberOfFloor;
        this.numberOfFloor=numberOfFloor;
        this.elevators=new ArrayList<>();
        for(String elevator:elevatorsProps){
            String[] elevatorP=elevator.split(":");
            this.elevators.add(new Elevator(elevatorP[0],Integer.valueOf(elevatorP[1])));
        }
    }

    @Override
    public String requestElevator() {
        Elevator elevatorRequested=new Elevator();
        int minFloorDistance=-1;
        for(Elevator elevator:elevators){
            int floorDistance=elevator.getDistanceElevatorAndRequest(this.requestFloor,this.numberOfFloor);
            if(floorDistance>0){
                if(minFloorDistance<0){
                    elevatorRequested=elevator;
                    minFloorDistance=floorDistance;
                }
                else {
                    if(minFloorDistance>floorDistance) {
                        elevatorRequested = elevator;
                        minFloorDistance = floorDistance;
                    }
                }
            }

        }
        return elevatorRequested.getId();
    }

    @Override
    public String requestElevator(int numberFloor) {
        this.requestFloor=numberFloor;
        return this.requestElevator();
    }

    @Override
    public void move(String idElevator, String direction) {
        for(Elevator elevator:this.elevators){
            if(elevator.getId().equalsIgnoreCase(idElevator)){
                elevator.move(direction);
                break;
            }
        }
    }

    @Override
    public void stopAt(String idElevator, int numberFloor) {
        for(Elevator elevator:this.elevators){
            if(elevator.getId().equalsIgnoreCase(idElevator)){
                elevator.stopAt(numberFloor);
                break;
            }
        }
    }
}
