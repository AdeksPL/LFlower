package pl.hikaricode.lflower.variabletypes;

import lombok.Getter;
import lombok.Setter;
import pl.hikaricode.lflower.variable.Variable;


@Getter
@Setter
public class StringVariable extends Variable {


    private String value;

    public StringVariable(String name , String value) {
        super(name);
        this.value = value;
    }

    @Override
    public String getType() {
        return "string";
    }


}
