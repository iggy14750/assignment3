import java.util.*;
import java.io.*;
public class Assig3 {

    public static void main(String[] main) throws IOException{
        
        Scanner sc = new Scanner(System.in);
        Dice die1 = new Dice();
        Dice die2 = new Dice();
        
        
        System.out.println("Hello, and welcome to FOUR Rivers' Casino!\nPlease Enter your name:");
        
        //create Player with the information we have or asked for
        String given_name = sc.next();
        Player pl = new Player(given_name);
        
        try {
            pl.readEntry();
        } catch (Exception e) {
            pl.makeNewEntry();
        }
        
        
        /*Commence play of over/under
            ask to play another round
            ask for wager
            ask for over/under/seven
        */
        
        
        do {//Thus begins Over/Under
            
            System.out.println("Would you like to play a round of Over/Under? (y/n)>");
            String YN = sc.next().toLowerCase();
            if (YN.equals("n")) {
                System.out.println("Are you sure you don't want to play anymore? (y/n)");
                if (sc.next().equals("y")) {
                    break;
                } else {
                    continue;
                }
            } else if (YN.equals("y")) {
                //new round
                do {
                    System.out.println("How much would you like to wager for this round?");
                    double wager = sc.nextDouble();
                    if (wager>pl.cashLeft()) {
                        System.out.println(randomReply(die1) + "  You can't wager that much!");
                        System.out.printf("You can only wager $%.2f\n", pl.cashLeft());
                        
                    } else {
                        System.out.println("So, what'll it be, over, under, or seven?");
                        String guess = sc.next().toLowerCase();
                        int roll1 = die1.roll();
                        int roll2 = die2.roll();
                        int theroll=roll1+roll2;
                        System.out.printf("Dice 1: %d, Dice 2: %d, Total: %d.\n", roll1, roll2, theroll);
                        winLose(theroll, guess, wager, pl);
                    }
                
                } while (true);
            } else {
                System.out.println(randomReply(die1) + " You gotta type \'y\' or \'n\'.");
                continue;
            }
        } while (true); 
    }
    
    private static void winLose(int theroll, String guess, double wager, Player pl) {
        //Somewhat wordy, but this is a one-line way to cover all win conditions.
        boolean playerWon = ((wager>7&&guess.equals("over"))||(wager<7&&guess.equals("under"))||(wager==7&&guess.equals("seven")));
        
        if (playerWon) {
            double winnings = wager;
            if (theroll==7) {
                winnings*=3;//was that the factor it got multiplied by?
            }
            System.out.printf("Congrats! You won $%.2f!\n", winnings);
            pl.wonAGame(winnings);
        } else {
            System.out.printf("Ooh, that's too bad! You lost $%.2f.\n", wager);
            pl.lostAGame(wager);
        }
        System.out.println("You have $%.2f left.", pl.cashLeft());
        if (pl.cashLeft()==0.) {
            //game over
        }
        pl.save();
    }
    
    private static String randomReply(Dice dc){
        String[] replies = {"Don't worry; everyone gets a little shy at these things.", "Don't have a seizure on me!", "You kiss your mother with that mouth?", "MY LEG!", "lorem ipsum", "et tu brute?"};
        int which = dc.roll()-1;
        return replies[which];
    }
}







