package pl.hikaricode.lflower.commands;

import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import pl.hikaricode.lflower.annotations.CommandInfo;
import pl.hikaricode.lflower.command.Command;
import pl.hikaricode.lflower.objects.FlowerFunction;
import pl.hikaricode.lflower.variable.Variable;
import pl.hikaricode.lflower.variabletypes.IntVariable;
import pl.hikaricode.lflower.variabletypes.StringVariable;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

@CommandInfo(name="calc")
public class CalcCommand extends Command {


    @Override
    public void execute(FlowerFunction function, String... settings) {
        if(settings.length < 2){
            System.out.println("Error code");
            return;
        }
        String text = StringUtils.join(settings,"",1, settings.length);

        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        IntVariable v = (IntVariable) function.getVariables()
                                              .stream()
                                              .filter(var -> var.getName().equalsIgnoreCase(settings[0]))
                                              .filter(var -> var.getType().equalsIgnoreCase("int"))
                                              .findFirst()
                                              .orElse(null);

        if(v == null) System.out.println("Code error");
        else {
            for(Variable p: function.getVariables()){
                if(p instanceof IntVariable){
                    IntVariable var = (IntVariable)p;
                    text = text.replaceAll("%"+var.getName()+"%", ""+var.getValue());
                }
            }
            try {
                v.setValue(Integer.parseInt(engine.eval(text).toString()));
            }catch (Exception e){ }
            //v.setValue();

        }


    }
}
