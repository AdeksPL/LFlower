package pl.hikaricode.lflower.objects;


import lombok.Getter;
import lombok.Setter;

@Getter
public class StructureCode {

    private int bracket;
    @Setter
    private FlowerFunction func;

    public StructureCode(){
        this.bracket = 0;
    }

    public void analyze(String line){
        if(line.contains("{")){
            this.addBracket();
        }
        if(line.contains("}")){
            this.removeBracket();
        }
    }


    public void addBracket() {
        this.bracket = this.bracket + 1;
    }

    public void removeBracket() {
        this.bracket = this.bracket - 1;
    }
    public String correct(String lin) {
        int tmp = 0;
        if(lin.length() >= 1)
        while(tmp < lin.length() && (lin.charAt(tmp) == '\t' || lin.charAt(tmp) == ' ')){
            tmp++;
        }

    return lin.substring(tmp);
    }
}
