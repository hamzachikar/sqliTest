package elevators.elevator_state;

import elevators.elevator_state.states.DownWardState;
import elevators.elevator_state.states.RestState;
import elevators.elevator_state.states.StopState;
import elevators.elevator_state.states.UpWardState;

public class ElevatorStateController {
    private  IElevatorState elevatorState;
    public ElevatorStateController(){
        elevatorState=new RestState();
    }

    public int getDistanceElevatorAndRequest(int currentFloor, int requestFloorNumber,int numberOfFloor) {
        return this.elevatorState.getDistanceElevatorAndRequest(currentFloor,requestFloorNumber,numberOfFloor);
    }

    public void move(String direction) {
        switch (direction){
            case "DOWN":
                elevatorState=new DownWardState();
                break;
            case "UP":
                elevatorState=new UpWardState();
                break;
            case "REST":
                elevatorState=new RestState();
                break;
            case "STOP":
                elevatorState=new StopState();
                break;
        }
    }
}
