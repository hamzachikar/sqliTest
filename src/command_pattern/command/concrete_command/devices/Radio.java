package command_pattern.command.concrete_command.devices;

import command_pattern.command.concrete_command.Device;

public class Radio extends Device {
    @Override
    public void on(){
        System.out.print("radio ");
        super.on();
    }
    @Override
    public void off(){
        System.out.print("radio ");
        super.off();
    }
}
