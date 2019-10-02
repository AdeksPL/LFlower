package pl.hikaricode.lflower.objects;

import lombok.Getter;
import pl.hikaricode.lflower.command.Command;
import pl.hikaricode.lflower.command.FlowerCommandManager;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
@Getter
public class LFlower {

    private File f;
    private List<FlowerFunction> func = new ArrayList<FlowerFunction>();
    private FlowerCommandManager flowerCommandManager;

    @Getter
    private static LFlower lFlower;



    public LFlower(String[] args) throws FileNotFoundException {
        lFlower = this;
        this.flowerCommandManager = new FlowerCommandManager();

        this.f = new File("name.lf");
        if(!f.exists()){
            System.out.println("This file doesn't exists!");
            f = null;
            return;
        }
    }

    public void start() throws FileNotFoundException {
        if(f == null) return;

        BufferedReader reader = new BufferedReader(new FileReader(f));
        StructureCode code = new StructureCode();
        reader.lines().forEachOrdered(lin -> {
            String line = code.correct(lin);
            //System.out.println(line + ";"+lin);

            int backet = code.getBracket();
            code.analyze(line);

            if(code.getFunc() != null) {
                if(!line.contains("}"))
                    code.getFunc().getLines().add(line);
            }

            switch(code.getBracket()){
                case 1:
                    if(backet < code.getBracket()) {

                        String a = line.replaceAll(" ","").replaceAll("\t", "");
                        if(a.charAt(a.length()-1) == '{'){
                            String[] cmd = line.split(" ");
                            if(cmd.length >= 2 && cmd[0].equalsIgnoreCase("function")){
                                String name = cmd[1];
                                if(!name.replaceAll("\t", "").equalsIgnoreCase("")){
                                    code.setFunc(new FlowerFunction(name.replaceAll("\\{", "")));
                                }else {
                                    System.out.println("Code error");
                                }
                            }
                        }else {
                            System.out.println("Code error");
                            return;
                        }
                    }
                    break;
                case 0:
                    if(backet > code.getBracket()) {
                        if(code.getFunc() != null)
                            func.add(code.getFunc());
                        code.setFunc(null);
                    }
                    break;
            }

        });
        if(code.getBracket() != 0){
            System.out.println("Error in brackets");
        }

        func.stream().filter(func -> func.getName().equalsIgnoreCase("main")).findFirst().ifPresent(func -> func.run());


    }
}
