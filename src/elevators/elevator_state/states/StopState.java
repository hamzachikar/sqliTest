package elevators.elevator_state.states;

import elevators.elevator_state.IElevatorState;

public class StopState implements IElevatorState {
    @Override
    public int getDistanceElevatorAndRequest(int currentFloor, int requestFloorNumber, int numberOfFloor) {
        return -1;
    }
}
