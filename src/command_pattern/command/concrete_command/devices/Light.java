package command_pattern.command.concrete_command.devices;

import command_pattern.command.concrete_command.Device;

public class Light extends Device {
    @Override
    public void on(){
        System.out.print("light ");
        super.on();
    }
    @Override
    public void off(){
        System.out.print("light ");
        super.off();
    }
}
