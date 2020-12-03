package command_pattern;

import command_pattern.command.Command;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
    List<Command>commands;
    public Invoker(){
        this.commands=new ArrayList<>();
    }
    public void addCommand(Command command){
        this.commands.add(command);
    }
    public void executeAllCommand(){
        for(Command command:commands){
            command.execute();
        }
    }
    public void undoAllCommand(){
        for(Command command:commands){
            command.undo();
        }
    }

    public void addCommands(Command ... cmds) {
        for (Command cmd:cmds){
            this.commands.add(cmd);
        }
    }
}
