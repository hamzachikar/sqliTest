package command_pattern.command.concrete_command.tv_cmd;

import command_pattern.command.Command;
import command_pattern.command.concrete_command.Device;
import command_pattern.command.concrete_command.devices.Light;
import command_pattern.command.concrete_command.devices.Tv;

public class OffTv implements Command {
    Device device;
    public OffTv(){
        this.device=new Tv();
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
