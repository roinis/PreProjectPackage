import org.junit.Test;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import Game.*;
import User.*;
import System.*;
import Jobs.*;
import Events.*;
import Association.*;

public class EventLogTest {

    @Deprecated
    @Test
    public void addEvent() {
        AlphaSystem.getSystem().ResetDB();
        AlphaSystem.getSystem().getLog().ResetLog();
        Time gameTime  = new Time(1,20,10);
        Team homeTeam = new Team ("Hapoel BS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team ("Maccabi TA",new TeamOwner(new Member("","","","roi")),null);
        EndGameEvent endGameEvent = new EndGameEvent(gameTime,homeTeam,awayTeam);

        gameTime = new Time(0,26,35);
        Team team = new Team("Maccabi Ha",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"Rokaviza ch"),null,null);
        GoalEvent goalEvent = new GoalEvent(gameTime,team,player);

        EventLog eventLog = AlphaSystem.getSystem().getLog();
        assertEquals(endGameEvent,eventLog.getEvents().get(0));
        assertEquals(goalEvent,eventLog.getEvents().get(1));
        AlphaSystem.getSystem().ResetDB();
    }

    @Deprecated
    @Test
    public void removeEvent() {
        AlphaSystem.getSystem().getLog().ResetLog();
        Time gameTime  = new Time(1,20,10);
        Team homeTeam = new Team ("Hapoel BS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team ("Maccabi TA",new TeamOwner(new Member("","","","roi")),null);
        EndGameEvent endGameEvent = new EndGameEvent(gameTime,homeTeam,awayTeam);

        gameTime = new Time(0,26,35);
        Team team = new Team("Maccabi Ha",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"Rokaviza ch"),null,null);
        GoalEvent goalEvent = new GoalEvent(gameTime,team,player);

        EventLog eventLog = AlphaSystem.getSystem().getLog();
        eventLog.removeEvent(goalEvent);
        assertEquals(endGameEvent.toString(),eventLog.getEvents().get(0).toString());
        AlphaSystem.getSystem().ResetDB();
    }



    @Test
    public void getEventLog() {
        AlphaSystem.getSystem().getLog();
    }


    @Test
    public void getEvents() {
        AlphaSystem.getSystem().getLog().ResetLog();
        Time gameTime  = new Time(1,20,10);
        Team homeTeam = new Team ("Hapoel BS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team ("Maccabi TA",new TeamOwner(new Member("","","","roi")),null);
        EndGameEvent endGameEvent = new EndGameEvent(gameTime,homeTeam,awayTeam);

        EventLog eventLog = AlphaSystem.getSystem().getLog();

        assertEquals(endGameEvent.toString(),eventLog.getEvents().get(0).toString());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void setEvents() {
        AlphaSystem.getSystem().getLog().ResetLog();
        Time gameTime  = new Time(1,20,10);
        Team homeTeam = new Team ("Hapoel BS",new TeamOwner(new Member("","","","roi")),null);
        Team awayTeam = new Team ("Maccabi TA",new TeamOwner(new Member("","","","roi")),null);
        EndGameEvent endGameEvent = new EndGameEvent(gameTime,homeTeam,awayTeam);

        gameTime = new Time(0,26,35);
        Team team = new Team("Maccabi Ha",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"Rokaviza ch"),null,null);
        List<Event> events = new ArrayList();
        events.add(endGameEvent);
        events.add(endGameEvent);
        GoalEvent goalEvent = new GoalEvent(gameTime,team,player);
        EventLog eventLog = AlphaSystem.getSystem().getLog();
        eventLog.setEvents(events);
        int counter = 0;
        for (Event event: events){
            assertEquals(event.toString(),eventLog.getEvents().get(counter).toString());
            counter++;
        }
        AlphaSystem.getSystem().ResetDB();
    }
}