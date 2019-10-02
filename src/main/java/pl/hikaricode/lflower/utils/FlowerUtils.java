package pl.hikaricode.lflower.utils;

import pl.hikaricode.lflower.objects.FlowerFunction;
import pl.hikaricode.lflower.variable.Variable;
import pl.hikaricode.lflower.variabletypes.IntVariable;
import pl.hikaricode.lflower.variabletypes.StringVariable;

public class FlowerUtils {

    public static int getCharLength(String str, char a){
        int b = 0;
        for(char t: str.toCharArray())
            if(t == a) b++;
        return b;
    }

    public static int getCharPosition(String str, char a, int i){
        int b = 0;
        int c = 0;
        for(char t: str.toCharArray()) {
            if (t == a) {
                b++;
                if(i == b){
                    return c;
                }
            }
            c++;
        }
        return b;
    }

    public static String stringtext(String tmp_str, FlowerFunction function){
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
            return text;

        }else {
            return null;
        }
    }



}
