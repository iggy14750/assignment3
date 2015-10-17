import java.util.Random;

public class Dice {

    Random rd = new Random();
    public Dice() {
    }
    
    public int roll(){
        return 1+rd.nextInt(6);
    }

}