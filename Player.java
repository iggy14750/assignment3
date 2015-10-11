public class Player {
    
    private String _fname="Herb";
    private String _lname="Doe";
    private double _cash;
    /*How can I present a double as a string 
    with two decimal points?, like %.2f in printf.
    */
    private int _rounds=0;
    private int _wins=0;
    private int _totalRounds;
    
    public Player(String lname, String fname, double cash, int totalRounds){
        
        _lname = lname;
        _fname = fname;
        _cash = cash;
        _totalRounds = totalRounds;
    }
    
    public double cashLeft(){
        return _cash;
    }
    
    public void wonAGame(double winnings){
        _rounds++;
        _wins++;
        _cash+=winnings;
    }
    
    public void lostAGame(){
        _rounds++;
        _cash-=bet;//this needs to be determined later
    }
    
    public void addMoney(double clams){//this may not be necssary...
        if (clams>0){
            _cash+=clams;
        }
    }
    
    public String[] niceString(){ //looking at this further in testing
        String[] info = new String(_fname + " " + _lname + " has $" + _cash + ", and is " + _wins + "/" + _rounds);
        return info;
    }
}







