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
        
        String given_name = sc.next();
        
        
        //create Player with the information we have or asked for
        
        
        /*Commence play of over/under
            ask to play another round
            ask for wager
            ask for over/under/seven
        */
        
    }
    
    public String[] playerDB(string playerName) throws IOException {
        File f = new File(playerName);
        Scanner io = new Scanner(f);
        String[] playerCred = new String[5];
        
        if (io.hasNext()) {//If the file is non-empty
            for (int i=0;i<5;i++){
                playerCred[i] = io.next();
            }
        } else { //If the file is empty, we're going to create a new entry
            PrintWriter out = new PrintWriter(playerName);
            System.out.println("We're happy to greet you at FOUR Rivers' Casino.\nWhat is your last name?");
            playerCred[0] = sc.next();
            playerCred[1] = playerName;
            System.out.println("And how much will you be wagering with us today?");
            playerCred[2] = sc.next();
            playerCred[3] = 0;
            //....... I want to get rid of that array.
        }
        
        io.close();
    }
    
    private static String randomReply(Dice dc){
        String[] replies = {"Don't worry; everyone gets a little shy at these things.", "Don't have a seizure on me!", "You kiss your mother with that mouth?", "MY LEG!", "lorem ipsum", "et tu brute?"};
        int which = dc.roll()-1;
        return replies[which];
    }
}