public class Player {
    
    public Player(String[] playerCred){
        
        private String _lname = playerCred[0];
        private String _fname = playerCred[1];
        private double _cash = Double.parseDouble(playerCred[2]);
        private int _rounds = playerCred[3].toInt();
        private int _wins = playerCred[4].toInt();
        /*
        _fname = fname;
        _lname = lname;
        _cash = cash;
        _totalRounds = totalRounds;
        _wins = wins;
        */
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







