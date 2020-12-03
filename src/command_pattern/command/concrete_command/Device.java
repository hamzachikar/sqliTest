package command_pattern.command.concrete_command;

public abstract class Device {
    public void on(){
        System.out.println("is on");
    }
    public void off(){
        System.out.println("is off");
    }
}
