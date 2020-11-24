package elevators.elevator_services;

public interface IElevatorsService {
    String requestElevator();
    String requestElevator(int numberFloor);
    void move(String idElevator, String direction);
    void stopAt(String idElevator, int numberFloor);
}
