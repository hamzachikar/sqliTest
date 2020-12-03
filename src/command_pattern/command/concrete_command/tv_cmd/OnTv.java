package command_pattern.command.concrete_command.tv_cmd;

import command_pattern.command.Command;
import command_pattern.command.concrete_command.Device;
import command_pattern.command.concrete_command.devices.Light;
import command_pattern.command.concrete_command.devices.Tv;

public class OnTv implements Command {
    Device device;
    public OnTv(){
        this.device=new Tv();
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
