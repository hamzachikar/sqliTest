package command_pattern.command.concrete_command.radio_cmd;

import command_pattern.command.Command;
import command_pattern.command.concrete_command.Device;
import command_pattern.command.concrete_command.devices.Light;
import command_pattern.command.concrete_command.devices.Radio;

public class OnRadio implements Command {
    Device device;
    public OnRadio(){
        this.device=new Radio();
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
