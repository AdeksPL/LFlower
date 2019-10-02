package pl.hikaricode.lflower.command;

import lombok.Getter;
import pl.hikaricode.lflower.objects.FlowerFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Getter
public class FlowerCommandManager {
    private List<Command> commands = new ArrayList<Command>();

    public FlowerCommandManager(){ }

    public void registerCommand(Command cmd){
        this.commands.add(cmd);
    }

    public Command getCommand(String name){
        return this.commands.stream().filter(cmd -> cmd.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public void registerCommands(Command... cmds){
        Arrays.asList(cmds).stream().forEachOrdered(cmd -> registerCommand(cmd));
    }


}
