package elevators.elevator_state.states;

import elevators.elevator_state.IElevatorState;

public class UpWardState implements IElevatorState {
    @Override
    public int getDistanceElevatorAndRequest(int currentFloor, int requestFloorNumber, int numberOfFloor) {
        if(currentFloor<requestFloorNumber){
            return requestFloorNumber-currentFloor;
        }
        else{
            return 2*(numberOfFloor-currentFloor)+(currentFloor-requestFloorNumber);
        }
    }
}
