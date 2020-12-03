package command_pattern;

import command_pattern.command.Command;
import command_pattern.command.concrete_command.light_cmd.OnLight;
import command_pattern.command.concrete_command.radio_cmd.OnRadio;
import command_pattern.command.concrete_command.tv_cmd.OnTv;

public class main {
    public static void main(String[] args){
        Command tvCmd=new OnTv();
        Command radioCmd=new OnRadio();
        Command lightCmd=new OnLight();
        Invoker invoker=new Invoker();
        invoker.addCommands(tvCmd,radioCmd,lightCmd);
        invoker.executeAllCommand();
        invoker.undoAllCommand();
    }
}
