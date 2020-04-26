import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.*;
import Game.*;
import User.*;
import System.*;
import Jobs.*;
import Events.*;
import Association.*;

public class GameDelayedEventTest {

    @Test
    public void testToString() {
        LocalDateTime originalDate = LocalDateTime.of(2019,10,5,22,0,0);
        LocalDateTime delayedDate = LocalDateTime.of(2019,10,6,22,0,0);
        Team homeTeam = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team("MH",new TeamOwner(new Member("","","","roi")),null);
        GameDelayedEvent gameDelayedEvent =  new GameDelayedEvent(originalDate,delayedDate,homeTeam,awayTeam);
        String eventString  =  "The match between " +
                homeTeam.getTeamName() +
                " and " + awayTeam.getTeamName() +
                " had delayed from " +
                originalDate + " to " +
                delayedDate + ".";
        assertEquals(eventString,gameDelayedEvent.toString());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void testToString1() {
        LocalDateTime originalDate = LocalDateTime.of(2019,10,5,22,0,0);
        LocalDateTime delayedDate = LocalDateTime.of(2019,10,6,22,0,0);
        Team homeTeam = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team("MH",new TeamOwner(new Member("","","","roi")),null);
        GameDelayedEvent gameDelayedEvent =  new GameDelayedEvent(originalDate,delayedDate,homeTeam,awayTeam);
        String eventString  =  "The match between " +
                homeTeam.getTeamName() +
                " and " + awayTeam.getTeamName() +
                " had delayed from " +
                originalDate + " to " +
                delayedDate + ".";
        gameDelayedEvent.setGameDelayedTime(LocalDateTime.of(2019,10,6,22,3,0));
        assertNotEquals(eventString,gameDelayedEvent.toString());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void testToString2() {
        LocalDateTime originalDate = LocalDateTime.of(2019,10,5,22,0,0);
        LocalDateTime delayedDate = LocalDateTime.of(2019,10,6,22,0,0);
        Team homeTeam = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team("MH",new TeamOwner(new Member("","","","roi")),null);
        GameDelayedEvent gameDelayedEvent =  new GameDelayedEvent(originalDate,delayedDate,homeTeam,awayTeam);
        String eventString  =  "The match between " +
                homeTeam.getTeamName() +
                " and " + awayTeam.getTeamName() +
                " had delayed from " +
                originalDate + " to " +
                delayedDate + ".";
        gameDelayedEvent.setAwayTeam(new Team("MTA",new TeamOwner(new Member("","","","roi")),null));
        assertNotEquals(eventString,gameDelayedEvent.toString());
        AlphaSystem.getSystem().ResetDB();
    }


    @Test
    public void getGameOriginalTime() {
        LocalDateTime originalDate = LocalDateTime.of(2019,10,5,22,0,0);
        LocalDateTime delayedDate = LocalDateTime.of(2019,10,6,22,0,0);
        Team homeTeam = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team("MH",new TeamOwner(new Member("","","","roi")),null);
        GameDelayedEvent gameDelayedEvent =  new GameDelayedEvent(originalDate,delayedDate,homeTeam,awayTeam);
        assertEquals(originalDate,gameDelayedEvent.getGameOriginalTime());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void setGameOriginalTime() {
        LocalDateTime originalDate = LocalDateTime.of(2019,10,5,22,0,0);
        LocalDateTime delayedDate = LocalDateTime.of(2019,10,6,22,0,0);
        Team homeTeam = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team("MH",new TeamOwner(new Member("","","","roi")),null);
        GameDelayedEvent gameDelayedEvent =  new GameDelayedEvent(originalDate,delayedDate,homeTeam,awayTeam);
        gameDelayedEvent.setGameOriginalTime(delayedDate);
        assertEquals(delayedDate,gameDelayedEvent.getGameOriginalTime());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void getGameDelayedTime() {
        LocalDateTime originalDate = LocalDateTime.of(2019,10,5,22,0,0);
        LocalDateTime delayedDate = LocalDateTime.of(2019,10,6,22,0,0);
        Team homeTeam = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team("MH",new TeamOwner(new Member("","","","roi")),null);
        GameDelayedEvent gameDelayedEvent =  new GameDelayedEvent(originalDate,delayedDate,homeTeam,awayTeam);
        assertEquals(delayedDate,gameDelayedEvent.getGameDelayedTime());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void setGameDelayedTime() {
        LocalDateTime originalDate = LocalDateTime.of(2019,10,5,22,0,0);
        LocalDateTime delayedDate = LocalDateTime.of(2019,10,6,22,0,0);
        Team homeTeam = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team("MH",new TeamOwner(new Member("","","","roi")),null);
        GameDelayedEvent gameDelayedEvent =  new GameDelayedEvent(originalDate,delayedDate,homeTeam,awayTeam);
        gameDelayedEvent.setGameDelayedTime(originalDate);
        assertEquals(originalDate,gameDelayedEvent.getGameDelayedTime());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void getHomeTeam() {
        LocalDateTime originalDate = LocalDateTime.of(2019,10,5,22,0,0);
        LocalDateTime delayedDate = LocalDateTime.of(2019,10,6,22,0,0);
        Team homeTeam = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team("MH",new TeamOwner(new Member("","","","roi")),null);
        GameDelayedEvent gameDelayedEvent =  new GameDelayedEvent(originalDate,delayedDate,homeTeam,awayTeam);
        assertEquals(homeTeam,gameDelayedEvent.getHomeTeam());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void setHomeTeam() {
        LocalDateTime originalDate = LocalDateTime.of(2019,10,5,22,0,0);
        LocalDateTime delayedDate = LocalDateTime.of(2019,10,6,22,0,0);
        Team homeTeam = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team("MH",new TeamOwner(new Member("","","","roi")),null);
        GameDelayedEvent gameDelayedEvent =  new GameDelayedEvent(originalDate,delayedDate,homeTeam,awayTeam);
        gameDelayedEvent.setHomeTeam(awayTeam);
        assertEquals(awayTeam,gameDelayedEvent.getHomeTeam());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void getAwayTeam() {
        LocalDateTime originalDate = LocalDateTime.of(2019,10,5,22,0,0);
        LocalDateTime delayedDate = LocalDateTime.of(2019,10,6,22,0,0);
        Team homeTeam = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team("MH",new TeamOwner(new Member("","","","roi")),null);
        GameDelayedEvent gameDelayedEvent =  new GameDelayedEvent(originalDate,delayedDate,homeTeam,awayTeam);
        assertEquals(awayTeam,gameDelayedEvent.getAwayTeam());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void setAwayTeam() {
        LocalDateTime originalDate = LocalDateTime.of(2019,10,5,22,0,0);
        LocalDateTime delayedDate = LocalDateTime.of(2019,10,6,22,0,0);
        Team homeTeam = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team("MH",new TeamOwner(new Member("","","","roi")),null);
        GameDelayedEvent gameDelayedEvent =  new GameDelayedEvent(originalDate,delayedDate,homeTeam,awayTeam);
        gameDelayedEvent.setAwayTeam(homeTeam);
        assertEquals(homeTeam,gameDelayedEvent.getAwayTeam());
        AlphaSystem.getSystem().ResetDB();
    }
}