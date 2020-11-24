package elevators.elevator_state;

public interface IElevatorState {
    int getDistanceElevatorAndRequest(int currentFloor, int requestFloorNumber, int numberOfFloor);
}
