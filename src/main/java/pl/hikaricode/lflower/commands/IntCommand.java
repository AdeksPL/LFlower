package pl.hikaricode.lflower.commands;

import pl.hikaricode.lflower.annotations.CommandInfo;
import pl.hikaricode.lflower.command.Command;
import pl.hikaricode.lflower.objects.FlowerFunction;
import pl.hikaricode.lflower.variabletypes.IntVariable;


@CommandInfo(name = "int")
public class IntCommand extends Command {


    @Override
    public void execute(FlowerFunction function,String... settings) {
        if(settings.length < 3){
            System.out.println("error in code");
            return;
        }
        if(settings[1].equalsIgnoreCase("->")){
            function.getVariables().add(new IntVariable(settings[0], Integer.parseInt(settings[2])));

        }
    }
}
