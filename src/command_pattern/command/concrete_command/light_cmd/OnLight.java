package command_pattern.command.concrete_command.light_cmd;

import command_pattern.command.Command;
import command_pattern.command.concrete_command.Device;
import command_pattern.command.concrete_command.devices.Light;

public class OnLight implements Command {
    Device device;
    public OnLight(){
        this.device=new Light();
    }
    @Override
    public void execute() {
        this.device.on();
    }

    @Override
    public void undo() {
        this.device.off();
    }
}
