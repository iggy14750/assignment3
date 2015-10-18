import java.util.*;
import java.io.*;
public class Assig3 {

    static boolean gameOver = false;

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
        pl.printInfo();
        System.out.println("Would you like to add any more money to your account?");
        if (getYN(sc)) {
            pl.addMoney(sc);
        }
        
        /*Commence play of over/under
            ask to play another round
            ask for wager
            ask for over/under/seven
        */
        
        
        do {//Thus begins Over/Under
            
            System.out.println("Would you like to play a round of Over/Under?");
            if (getYN(sc)) {
                //new round
                double wager = legitWager(sc, pl);
                System.out.println("So, what'll it be, over, under, or seven?");
                String guess = legitGuess(sc);
                int roll1 = die1.roll();
                int roll2 = die2.roll();
                int theroll=roll1+roll2;
                System.out.printf("Dice 1: %d, Dice 2: %d, Total: %d.\n", roll1, roll2, theroll);
                winLose(theroll, guess, wager, pl);
                broke(pl,sc);
            } else {
                System.out.println("Are you sure you don't want to play anymore?");
                if (getYN(sc)) {
                    gameOver=true;
                }
            }
        } while (!gameOver); 
    }
    
    private static double legitWager(Scanner sc, Player pl) {
        do { //This is where I check that the player isn't trying to bet more than she has.
            System.out.println("How much would you like to wager for this round?");
            double wager = sc.nextDouble();
            if (wager>pl.cashLeft()) {
                System.out.println("You can't wager that much!");
                System.out.printf("You can only wager $%.2f\n", pl.cashLeft());
            } else {
                return wager;
            }
            
        } while (true);
    }
    
    private static void winLose(int theroll, String guess, double wager, Player pl) throws IOException {
        //Somewhat wordy, but this is a one-line way to cover all win conditions.
        boolean playerWon = ((theroll>7&&guess.equals("over"))||(theroll<7&&guess.equals("under"))||(theroll==7&&guess.equals("seven")));
        
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
        System.out.printf("You have $%.2f left.\n", pl.cashLeft());
        pl.save();
    }
    
    public static void broke(Player pl, Scanner sc) {
        if (pl.cashLeft()==0.) {
            System.out.println("Oh, no! You're out of money!\n Would you like to fork ov- I mean - add any more money to your account?");
            if (getYN(sc)) {
                pl.addMoney(sc);
            } else {
                gameOver = true;
            }
        } else {
            String easterEgg = "I am an Easter Egg. Love me.";
        }
    }
    
    public static String legitGuess(Scanner sc) {
        do {
            String guess = sc.next().toLowerCase();
            if (guess.equals("over")||guess.equals("under")||guess.equals("seven")) {
                return guess;
            } else {
                System.out.println("Oops! You have to pick between over, under, or seven.");
            }
        } while (true);
    }
    
    public static boolean getYN(Scanner sc) {
        do {
            System.out.print("(y/n) >");
            String YN = sc.next().toLowerCase();
            if (YN.equals("y")){
                return true;
            } else if (YN.equals("n")){
                return false;
            } else {
                System.out.println("Well, which is it?");
            }
        } while (true);
    } 
    
    private static String randomReply(Dice dc){
        String[] replies = {"Don't worry; everyone gets a little shy at these things.", "Don't have a seizure on me!", "You kiss your mother with that mouth?", "MY LEG!", "lorem ipsum", "et tu brute?"};
        int which = dc.roll()-1;
        return replies[which];
    }
}







