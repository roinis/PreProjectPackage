import Events.GameReLocationEvent;
import Game.Stadium;
import Game.Team;
import org.junit.Test;

import static org.junit.Assert.*;
import Events.*;
import Jobs.*;
import Game.*;
import Association.*;
import System.*;
import User.*;

public class GameReLocationEventTest {

    @Test
    public void testToString() {
        Stadium originalStadium = new Stadium("terner","BS");
        Stadium relocatedStadium = new Stadium("bernabeo","madrid");
        Team homeTeam = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team("MH",new TeamOwner(new Member("","","","roi")),null);
        GameReLocationEvent gameReLocationEvent = new GameReLocationEvent(originalStadium,relocatedStadium,homeTeam,awayTeam);
        String eventString = "The match between " +
                homeTeam.getTeamName() +
                " and " + awayTeam.getTeamName() +
                " had relocated from " +
                originalStadium.getStadiumName() + " to " +
                relocatedStadium.getStadiumName() + ".";
        assertEquals(eventString,gameReLocationEvent.toString());
    }

    @Test
    public void testToString1() {
        Stadium originalStadium = new Stadium("terner","BS");
        Stadium relocatedStadium = new Stadium("bernabeo","madrid");
        Team homeTeam = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team("MH",new TeamOwner(new Member("","","","roi")),null);
        GameReLocationEvent gameReLocationEvent = new GameReLocationEvent(originalStadium,relocatedStadium,homeTeam,awayTeam);
        String eventString = "The match between " +
                homeTeam.getTeamName() +
                " and " + awayTeam.getTeamName() +
                " had relocated from " +
                originalStadium.getStadiumName() + " to " +
                relocatedStadium.getStadiumName() + ".";
        gameReLocationEvent.setGameNewLocation(new Stadium("kamp noe","barcelona"));
        assertNotEquals(eventString,gameReLocationEvent.toString());
    }
    @Test
    public void testToString2() {
        Stadium originalStadium = new Stadium("terner","BS");
        Stadium relocatedStadium = new Stadium("bernabeo","madrid");
        Team homeTeam = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team("MH",new TeamOwner(new Member("","","","roi")),null);
        GameReLocationEvent gameReLocationEvent = new GameReLocationEvent(originalStadium,relocatedStadium,homeTeam,awayTeam);
        String eventString = "The match between " +
                homeTeam.getTeamName() +
                " and " + awayTeam.getTeamName() +
                " had relocated from " +
                originalStadium.getStadiumName() + " to " +
                relocatedStadium.getStadiumName() + ".";
            gameReLocationEvent.setAwayTeam(new Team("Barcelona",new TeamOwner(new Member("","","","roi")),null));
        assertNotEquals(eventString,gameReLocationEvent.toString());
    }


}