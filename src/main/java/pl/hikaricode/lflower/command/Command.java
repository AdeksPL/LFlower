package pl.hikaricode.lflower.command;


import lombok.Getter;
import pl.hikaricode.lflower.annotations.CommandInfo;
import pl.hikaricode.lflower.objects.FlowerFunction;

@Getter
public abstract class Command {

    private String name;

    public Command(){
        CommandInfo info = getClass().getDeclaredAnnotation(CommandInfo.class);
        if(info == null) throw new NullPointerException();
        this.name = info.name();
    }

    public abstract void execute(FlowerFunction function, String... settings);

}
