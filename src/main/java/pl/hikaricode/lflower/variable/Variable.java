package pl.hikaricode.lflower.variable;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Variable {

    private String type;
    private String name;

    public Variable(String name){
        this.name = name;
    }


}
