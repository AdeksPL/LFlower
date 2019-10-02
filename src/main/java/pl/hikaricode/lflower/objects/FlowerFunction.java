package pl.hikaricode.lflower.objects;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import pl.hikaricode.lflower.command.Command;
import pl.hikaricode.lflower.command.FlowerCommandManager;
import pl.hikaricode.lflower.variable.Variable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Getter
public class FlowerFunction {

    private String name;
    private List<String> lines = new ArrayList<String>();
    private List<Variable> variables = new ArrayList<Variable>();

    public FlowerFunction(){
        name = "NULL";

    }
    public FlowerFunction(String name){
        this.name = name;
    }
    public FlowerFunction(String type, String name){

    }

    public void run() {
        lines.stream().forEachOrdered(line -> {
            if(!line.replaceAll("\t", "").replaceAll(" ", "").equalsIgnoreCase("")) {
                String[] cmdlab = line.split(" ");
                Command c = LFlower.getLFlower().getFlowerCommandManager().getCommand(cmdlab[0]);
                if (c == null) {
                    System.out.println("ERROR: Command " + cmdlab[0]);
                    return;
                }

                c.execute(this, StringUtils.join(cmdlab, " ", 1, cmdlab.length).split(" "));
            }
        });
    }
}
