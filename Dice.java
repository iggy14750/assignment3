import java.util.Random;

public class Dice {

    public Dice() {
        Random _rd = new Random();
    }
    
    public int roll(){
        return 1+_rd.nextInt(6);
    }

}