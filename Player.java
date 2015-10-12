public class Player {
    
    private String _fname="Herb";
    private String _lname="Doe";
    private double _cash;
    /*How can I present a double as a string 
    with two decimal points?, like %.2f in printf.
    */
    private int _wins=0;
    private int _totalRounds=0;
    
    public Player(String lname, String fname, double cash, int totalRounds, int wins){
        
        _lname = lname;
        _fname = fname;
        _cash = cash;
        _totalRounds = totalRounds;
        _wins = wins;
    }
    
    public double cashLeft(){
        return _cash;
    }
    
    public void wonAGame(double winnings){
        _totalRounds++;
        _wins++;
        _cash+=winnings;
    }
    
    public void lostAGame(double bet){
        _rounds++;
        _cash-=bet;
    }
    
    public void addMoney(double clams){//this may not be necssary...
        if (clams>0){
            _cash+=clams;
        }
    }
    
    public void printInfo(){
        System.out.println("Here is your current information:");
        System.out.printf("\tName: %s %s\n\tMoney Left: $%.2f\n\tTotal Rounds Played: %d\n\tTotal Rounds Won: %d\n\n", _fname, _lname, _cash, _totalRounds, _wins);
    }
}







