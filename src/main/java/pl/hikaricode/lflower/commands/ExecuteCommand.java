package pl.hikaricode.lflower.commands;

import pl.hikaricode.lflower.annotations.CommandInfo;
import pl.hikaricode.lflower.command.Command;
import pl.hikaricode.lflower.objects.FlowerFunction;
import pl.hikaricode.lflower.objects.LFlower;


@CommandInfo(name = "execute")
public class ExecuteCommand extends Command {
    @Override
    public void execute(FlowerFunction function, String... settings) {
        if(settings.length < 1){
            System.out.println("error code");
            return;
        }
        FlowerFunction f = LFlower.getLFlower().getFunc().stream().filter(func -> func.getName().equalsIgnoreCase(settings[0])).findFirst().orElse(null);
        if(f == null){
            System.out.println("error code");
            return;
        }
        f.run();
    }
}
