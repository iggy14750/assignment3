import java.util.Random;

public class Assig3 {

    public static void main(String[] main){
        
        Random rd = new Random();
        Dice dice1 = new Dice(rd);
        int theroll = dice1.roll();
    
        System.out.println("The roll is " + theroll);
        
    }
}