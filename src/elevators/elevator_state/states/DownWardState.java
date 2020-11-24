package elevators.elevator_state.states;

import elevators.elevator_state.IElevatorState;

public class DownWardState implements IElevatorState {
    @Override
    public int getDistanceElevatorAndRequest(int currentFloor, int requestFloorNumber, int numberOfFloor) {
        if(currentFloor>requestFloorNumber){
            return currentFloor-requestFloorNumber;
        }
        else{
            return 2*currentFloor+requestFloorNumber;
        }
    }
}
