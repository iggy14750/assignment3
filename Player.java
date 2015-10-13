public class Player {
    
    private String _fname="Herb";
    private String _lname="Doe";
    private double _cash;
    private int _wins=0;
    private int _totalRounds=0;
    
    public Player(String fname, String lname, double cash, int totalRounds, int wins){
        
        _fname = fname;
        _lname = lname;
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







