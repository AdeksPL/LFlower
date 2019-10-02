package pl.hikaricode.lflower.main;

import pl.hikaricode.lflower.commands.*;
import pl.hikaricode.lflower.objects.LFlower;

import java.io.FileNotFoundException;

public class main {

    public static void main(String[] args) throws FileNotFoundException {

        LFlower l = new LFlower(args);

        l.getFlowerCommandManager().registerCommands(new PrintCommand(),
                                                     new IntCommand(),
                                                     new StringCommand(),
                                                     new CalcCommand(),
                                                     new ExecuteCommand());

        l.start();



    }

}
