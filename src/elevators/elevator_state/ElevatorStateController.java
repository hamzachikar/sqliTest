package elevators.elevator_state;

import elevators.elevator_state.states.DownWardState;
import elevators.elevator_state.states.RestState;
import elevators.elevator_state.states.StopState;
import elevators.elevator_state.states.UpWardState;

public class ElevatorStateController {
    private  IElevatorState elevatorState;
    private  UpWardState upWardState;
    private  DownWardState downWardState;
    private StopState stopState;
    private  RestState restState;
    public ElevatorStateController(){
        upWardState=new UpWardState();
        downWardState=new DownWardState();
        restState=new RestState();
        stopState=new StopState();
        elevatorState=restState;
    }

    public int getDistanceElevatorAndRequest(int currentFloor, int requestFloorNumber,int numberOfFloor) {
        if(elevatorState instanceof RestState){
            if(currentFloor<requestFloorNumber){
                return requestFloorNumber-currentFloor;
            }
            else{
                return currentFloor-requestFloorNumber;
            }
        }
        if(elevatorState instanceof DownWardState){
            if(currentFloor>requestFloorNumber){
                return currentFloor-requestFloorNumber;
            }
            else{
                return 2*currentFloor+requestFloorNumber;
            }
        }
        if(elevatorState instanceof UpWardState){
            if(currentFloor<requestFloorNumber){
                return requestFloorNumber-currentFloor;
            }
            else{
                return 2*(numberOfFloor-currentFloor)+(currentFloor-requestFloorNumber);
            }
        }
        return -1;
    }

    public void move(String direction) {
        switch (direction){
            case "DOWN":
                elevatorState=downWardState;
                break;
            case "up":
                elevatorState=upWardState;
                break;
            case "REST":
                elevatorState=restState;
                break;
        }
    }

    public void stop() {
        elevatorState=stopState;
    }
}
