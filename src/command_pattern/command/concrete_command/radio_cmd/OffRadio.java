package command_pattern.command.concrete_command.radio_cmd;

import command_pattern.command.Command;
import command_pattern.command.concrete_command.Device;
import command_pattern.command.concrete_command.devices.Light;
import command_pattern.command.concrete_command.devices.Radio;

public class OffRadio implements Command {
    Device device;
    public OffRadio(){
        this.device=new Radio();
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
