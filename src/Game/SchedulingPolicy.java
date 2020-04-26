package Game;
import Events.*;
import User.*;
import System.*;
import Jobs.*;
import Association.*;

public class SchedulingPolicy {
    private int numOf2TeamsGames;

    public SchedulingPolicy(int numOf2TeamsGames) {
        this.numOf2TeamsGames = numOf2TeamsGames;
    }
    public SchedulingPolicy(){
        this.numOf2TeamsGames=2;
    }

    public int getNumOf2TeamsGames() {
        return numOf2TeamsGames;
    }
}
