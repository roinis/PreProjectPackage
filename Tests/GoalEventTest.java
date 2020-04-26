import org.junit.Test;

import java.sql.Time;

import static org.junit.Assert.*;
import Game.*;
import User.*;
import System.*;
import Jobs.*;
import Events.*;
import Association.*;

public class GoalEventTest {

    @Deprecated
    @Test
    public void testToString() {
        Time gameTime = new Time(0,26,35);
        Team team = new Team("Maccabi Ha",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"Rokaviza ch"),null,null);
        GoalEvent goalEvent = new GoalEvent(gameTime,team,player);
        String eventString = "The Player " + player.getMember().getFull_name() + " of team " + team.getTeamName()
                        + " scored a goal" + " at " + gameTime + ".";
        assertEquals(goalEvent.toString(),eventString);
        AlphaSystem.getSystem().ResetDB();
    }

    @Deprecated
    @Test
    public void testToString1() {
        Time gameTime = new Time(0,26,35);
        Team team = new Team("Maccabi Ha",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"Rokaviza ch"),null,null);
        GoalEvent goalEvent = new GoalEvent(gameTime,team,player);
        goalEvent.setEventTeam(new Team("HBK",new TeamOwner(new Member("","","","roi")),null));
        String eventString = "The Player " + player.getMember().getFull_name() + " of team " + team.getTeamName()
                + " scored a goal" + " at " + gameTime + ".";

        assertNotEquals(eventString,goalEvent.toString());
        AlphaSystem.getSystem().ResetDB();
    }

    @Deprecated
    @Test
    public void testToString2() {
        Time gameTime = new Time(0,26,35);
        Team team = new Team("Maccabi Ha",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"Rokaviza ch"),null,null);
        GoalEvent goalEvent = new GoalEvent(gameTime,team,player);
        goalEvent.setEventPlayer(new Player(new Member(null,null,null,"john hugo"),null,null));
        String eventString = "The Player " + player.getMember().getFull_name() + " of team " + team.getTeamName()
                + " scored a goal" + " at " + gameTime + ".";

        assertNotEquals(eventString,goalEvent.toString());
        AlphaSystem.getSystem().ResetDB();
    }
}