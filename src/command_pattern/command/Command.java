package command_pattern.command;

public interface Command {
    public void execute();
    public void undo();
}
