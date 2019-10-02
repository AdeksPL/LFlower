package pl.hikaricode.lflower.commands;


import org.apache.commons.lang3.StringUtils;
import pl.hikaricode.lflower.annotations.CommandInfo;
import pl.hikaricode.lflower.command.Command;
import pl.hikaricode.lflower.objects.FlowerFunction;
import pl.hikaricode.lflower.utils.FlowerUtils;
import pl.hikaricode.lflower.variable.Variable;
import pl.hikaricode.lflower.variabletypes.IntVariable;
import pl.hikaricode.lflower.variabletypes.StringVariable;

import java.util.stream.IntStream;

@CommandInfo(name = "print")
public class PrintCommand extends Command {


    @Override
    public void execute(FlowerFunction function, String... settings) {

        String tmp_str = StringUtils.join(settings, " ",0, settings.length);
        if(FlowerUtils.getCharLength(tmp_str, '"') == 2){
            int start = FlowerUtils.getCharPosition(tmp_str, '"', 1);
            int end = FlowerUtils.getCharPosition(tmp_str, '"', 2);

            String text = tmp_str.substring(start+1, end);
            for(Variable v: function.getVariables()){
                if(v instanceof IntVariable){
                    IntVariable var = (IntVariable)v;
                    text = text.replaceAll("%"+var.getName()+"%", ""+var.getValue());
                }
                if(v instanceof StringVariable){
                    StringVariable var = (StringVariable)v;
                    text = text.replaceAll("%"+var.getName()+"%", ""+var.getValue());
                }
            }
//tmp_str.substring(start+1, end)
            System.out.println(text);

        }else {
            System.out.println("error");
        }



    }
}
