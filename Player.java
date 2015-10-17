import java.io.*;
import java.util.*;
public class Player {
    
    private String _lname;
    private String _fname;
    private double _cash;
    private int _rounds;
    private int _wins;
    //String[] playerCred = new String[5];
    
    public Player(String name){
        
        _fname = name;
        /*
        _fname = fname;
        _lname = lname;
        _cash = cash;
        _totalRounds = totalRounds;
        _wins = wins;
        */
    }
    
    public void readEntry() throws IOException {
        File f = new File(_fname);
        Scanner in = new Scanner(f);
        /*
        for (int i=0;i<5;i++){
            playerCred[i] = in.next();
        }
        //*/
        _lname = in.next();
        System.out.printf("Welcome back to FOUR Rivers Casino, %s %s!\n", _fname, _lname);
        String throwaway = in.next();//I already know the players first name.
        _cash = Double.parseDouble(in.next());
        _rounds = in.nextInt();
        _wins = in.nextInt();
        in.close();
        
    }
    
    public void makeNewEntry() throws IOException {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("We're happy to greet you at FOUR Rivers' Casino.\nWhat is your last name?");
        _lname = sc.next();
        System.out.println("And how much will you be wagering with us today?");
        
        //Check that the player is wagering a non-negative amount. I know, it's a little wordy...
        boolean invalidInput = false;
        do {
            double given_value = sc.nextDouble();
            if (given_value>=0.0){
                _cash = given_value;
            } else {
                System.out.println("You have to wager a positive amount of money; try again.");
                invalidInput = true;
            }
        } while (invalidInput);
        
        _rounds = 0;
        _wins = 0;
    }
    
    public void save() throws IOException {
        
        PrintWriter out = new PrintWriter(_fname);
        out.println(_lname);
        out.println(_fname);
        out.println(Double.toString(_cash));
        out.println(Integer.toString(_rounds));
        out.println(Integer.toString(_wins));
        out.close();
    }
    
    public double cashLeft(){
        return _cash;
    }
    
    public void wonAGame(double winnings){
        _rounds++;
        _wins++;
        _cash+=winnings;
    }
    
    public void lostAGame(double bet){
        _rounds++;
        _cash-=bet;
    }
    
    public void printInfo(){
        //System.out.println("Here is your current information:");
        System.out.printf("\tName: %s %s\n\tMoney Left: $%.2f\n\tTotal Rounds Played: %d\n\tTotal Rounds Won: %d\n\n", _fname, _lname, _cash, _rounds, _wins);
    }
}







