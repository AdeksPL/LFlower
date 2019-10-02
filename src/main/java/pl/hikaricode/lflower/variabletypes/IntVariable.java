package pl.hikaricode.lflower.variabletypes;

import lombok.Getter;
import lombok.Setter;
import pl.hikaricode.lflower.variable.Variable;


@Getter
@Setter
public class IntVariable extends Variable {


    private int value;

    public IntVariable(String name , int value) {
        super(name);
        this.value = value;
    }

    @Override
    public String getType() {
        return "int";
    }


}
