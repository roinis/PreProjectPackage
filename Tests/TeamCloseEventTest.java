import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import Game.*;
import User.*;
import System.*;
import Jobs.*;
import Events.*;
import Association.*;

public class TeamCloseEventTest {

    @Test
    public void testToString() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        LocalDateTime closeTeamDate  = LocalDateTime.of(2020,3,1,15,13,0);
        TeamCloseEvent teamCloseEvent = new TeamCloseEvent(closeTeamDate,team);
        String eventString = "The Team: " +
                team.getTeamName() +
                " has closed" +
                " at " + closeTeamDate;
        assertEquals(eventString,teamCloseEvent.toString());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void testToString1() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        LocalDateTime closeTeamDate  = LocalDateTime.of(2020,3,1,15,13,0);
        TeamCloseEvent teamCloseEvent = new TeamCloseEvent(closeTeamDate,team);
        String eventString = "The Team: " +
                team.getTeamName() +
                " has closed" +
                " at " + closeTeamDate;
        teamCloseEvent.setClosedTeam(new Team("MTA",new TeamOwner(new Member("","","","roi")),null));
        assertNotEquals(eventString,teamCloseEvent.toString());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void testToString2() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        LocalDateTime closeTeamDate  = LocalDateTime.of(2020,3,1,15,13,0);
        TeamCloseEvent teamCloseEvent = new TeamCloseEvent(closeTeamDate,team);
        String eventString = "The Team: " +
                team.getTeamName() +
                " has closed" +
                " at " + closeTeamDate;
        teamCloseEvent.setClosedTime(LocalDateTime.of(2020,2,10,18,3,0));
        assertNotEquals(eventString,teamCloseEvent.toString());
        AlphaSystem.getSystem().ResetDB();
    }


    @Test
    public void getClosedTime() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        LocalDateTime closeTeamDate  = LocalDateTime.of(2020,3,1,15,13,0);
        TeamCloseEvent teamCloseEvent = new TeamCloseEvent(closeTeamDate,team);
        assertEquals(closeTeamDate,teamCloseEvent.getClosedTime());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void setClosedTime() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        LocalDateTime closeTeamDate  = LocalDateTime.of(2020,3,1,15,13,0);
        LocalDateTime closeTeamDate1 = LocalDateTime.of(2020,2,1,15,13,0);
        TeamCloseEvent teamCloseEvent = new TeamCloseEvent(closeTeamDate,team);
        teamCloseEvent.setClosedTime(closeTeamDate1);
        assertEquals(closeTeamDate1,teamCloseEvent.getClosedTime());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void getClosedTeam() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        LocalDateTime closeTeamDate  = LocalDateTime.of(2020,3,1,15,13,0);
        TeamCloseEvent teamCloseEvent = new TeamCloseEvent(closeTeamDate,team);
        assertEquals(team,teamCloseEvent.getClosedTeam());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void setClosedTeam() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team team1 = new Team("HBS1",new TeamOwner(new Member("","","","roi")),null);

        LocalDateTime closeTeamDate  = LocalDateTime.of(2020,3,1,15,13,0);
        TeamCloseEvent teamCloseEvent = new TeamCloseEvent(closeTeamDate,team);
        teamCloseEvent.setClosedTeam(team1);
        assertEquals(team1,teamCloseEvent.getClosedTeam());
        AlphaSystem.getSystem().ResetDB();
    }
}