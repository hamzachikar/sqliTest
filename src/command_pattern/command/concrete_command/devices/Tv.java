package command_pattern.command.concrete_command.devices;

import command_pattern.command.concrete_command.Device;

public class Tv extends Device {
    @Override
    public void on(){
        System.out.print("Tv ");
        super.on();
    }
    @Override
    public void off(){
        System.out.print("Tv ");
        super.off();
    }
}
