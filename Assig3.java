
public class Assig3 {

    public static void main(String[] main){
        
        Dice dice1 = new Dice();
        int theroll = dice1.roll();
    
        System.out.println("The roll is " + theroll);
        
    }
    
    private static String[] randomReply(Dice dc){
        Srtring[] replies = new String[6];
        replies = {"Don't worry; everyone gets a little shy at these things.", "Don't have a seizure on me!", "You kiss your mother with that mouth?", "MY LEG!"};
        which = dc.roll()-1;
        return replies[which];
    }
}