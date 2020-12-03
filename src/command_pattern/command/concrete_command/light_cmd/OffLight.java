package command_pattern.command.concrete_command.light_cmd;

import command_pattern.command.Command;
import command_pattern.command.concrete_command.Device;
import command_pattern.command.concrete_command.devices.Light;

public class OffLight implements Command {
    Device device;
    public OffLight(){
        this.device=new Light();
    }
    @Override
    public void execute() {
        this.device.off();
    }

    @Override
    public void undo() {
        this.device.on();
    }
}
