import java.util.Random;

public class Dice {

    private Random _rd;

    public Dice(Random rd) {
        _rd = rd;
    }
    
    public int roll(){
        return _rd.nextInt(6);
    }

}