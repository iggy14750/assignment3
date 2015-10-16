import java.util.*;
import java.io.*;
public class Assig3 {

    public static void main(String[] main) throws IOException{
        //create Scanner(sysin), and 2 Dice
        Scanner sc = new Scanner(System.in);
        Dice die1 = new Dice();
        Dice die2 = new Dice();
        
        //Welcome, and ask who it is
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
        
    }
    /*
    public static boolean haveEntry(String given_name) throw IOException {
        File f = new File(give_name);
        Scanner io = new Scanner(f);
        boolean exists = io.hasNext();
        io.close();
        return exists;
    }
    //*/
    
    /*
    public static void readEntry(String playerName, String playerCred[]) throws IOException {
        File f = new File(playerName);
        Scanner io = new Scanner(f);
        
        for (int i=0;i<5;i++){
            playerCred[i] = io.next();
        }
        io.close();
    }
    //*/
    
    /*
    public static void makeNewEntry(String give_name, String playerCred[]) throws IOException {
        PrintWriter out = new PrintWriter(playerName);
        Scanner sc = new Scanner(System.in);
        
        System.out.println("We're happy to greet you at FOUR Rivers' Casino.\nWhat is your last name?");
        playerCred[0] = sc.next();
        playerCred[1] = playerName;
        System.out.println("And how much will you be wagering with us today?");
        
        //Check that the player is wagering a non-negative amount
        do {
            boolean invalidInput = false;
            double given_value = sc.nextDouble();//IDK if this is a real method...
            if (given_value>=0){
                playerCred[2] = given_input.toString();
            } else {
                System.out.println("You have to wager a positive amount of money; try again.");
                invalidInput = true;
            }
        } while (invalidInput);
        
        playerCred[3] = "0";
        playerCred[4] = "0";
        
        for (String atom: playerCred) {
            out.println(atom);
        }
        out.close();
    }
    //*/
    
    private static String randomReply(Dice dc){
        String[] replies = {"Don't worry; everyone gets a little shy at these things.", "Don't have a seizure on me!", "You kiss your mother with that mouth?", "MY LEG!", "lorem ipsum", "et tu brute?"};
        int which = dc.roll()-1;
        return replies[which];
    }
}