package elevators.main_class;

import elevators.elevator_state.ElevatorStateController;

public class Elevator {
    private String id;
    private int currentFloor;
    private ElevatorStateController elevatorStateController;
    public Elevator(){}
    public Elevator(String id,int currentFloor){
        this.id=id;
        this.currentFloor=currentFloor;
        this.elevatorStateController=new ElevatorStateController();
    }
    public int getDistanceElevatorAndRequest(int requestFloorNumber,int numberOfFloor){
        return this.elevatorStateController.getDistanceElevatorAndRequest( currentFloor,requestFloorNumber,numberOfFloor);
    }
    public String getId(){
        return this.id;
    }

    public void move(String direction) {
        this.elevatorStateController.move(direction);
    }

    public void stopAt(int numberFloor) {
        this.currentFloor=numberFloor;
        this.elevatorStateController.move("STOP");
    }
}
