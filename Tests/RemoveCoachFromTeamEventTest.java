import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import Game.*;
import User.*;
import System.*;
import Jobs.*;
import Events.*;
import Association.*;

public class RemoveCoachFromTeamEventTest {

    @Test
    public void testToString() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Coach coach = new Coach(new Member(null,null,null,"toni wak"), Coach.Certification.MainCoach);
        RemoveCoachFromTeamEvent removeCoachFromTeamEvent = new RemoveCoachFromTeamEvent(coach,team);
        String eventString = "The Coach: " +
                coach.getMemberFullName() +
                " has leaved the Team: " + team.getTeamName() +
                " At: " + removeCoachFromTeamEvent.getDateTime();

        assertEquals(eventString,removeCoachFromTeamEvent.toString());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void testToString1() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Coach coach = new Coach(new Member(null,null,null,"toni wak"), Coach.Certification.MainCoach);
        RemoveCoachFromTeamEvent removeCoachFromTeamEvent = new RemoveCoachFromTeamEvent(coach,team);
        String eventString = "The Coach: " +
                coach.getMemberFullName() +
                " has leaved the Team: " + team.getTeamName() +
                " At: " + removeCoachFromTeamEvent.getDateTime();

        removeCoachFromTeamEvent.setCoach(new Coach(new Member(null,null,null,"yossi"), Coach.Certification.MainCoach));
        assertNotEquals(eventString,removeCoachFromTeamEvent.toString());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void testToString2() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Coach coach = new Coach(new Member(null,null,null,"toni wak"), Coach.Certification.MainCoach);
        RemoveCoachFromTeamEvent removeCoachFromTeamEvent = new RemoveCoachFromTeamEvent(coach,team);
        String eventString = "The Coach: " +
                coach.getMemberFullName() +
                " has leaved the Team: " + team.getTeamName() +
                " At: " + removeCoachFromTeamEvent.getDateTime();

        removeCoachFromTeamEvent.setTeam(new Team("TelAviv",new TeamOwner(new Member("","","","roi")),null));
        assertNotEquals(eventString,removeCoachFromTeamEvent.toString());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void getCoach() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Coach coach = new Coach(new Member(null,null,null,"toni wak"), Coach.Certification.MainCoach);
        RemoveCoachFromTeamEvent removeCoachFromTeamEvent = new RemoveCoachFromTeamEvent(coach,team);
        assertEquals(coach,removeCoachFromTeamEvent.getCoach());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void setCoach() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Coach coach = new Coach(new Member(null,null,null,"toni wak"), Coach.Certification.MainCoach);
        Coach coach1 = new Coach(new Member(null,null,null,"toni wak1"), Coach.Certification.MainCoach);

        RemoveCoachFromTeamEvent removeCoachFromTeamEvent = new RemoveCoachFromTeamEvent(coach,team);
        removeCoachFromTeamEvent.setCoach(coach1);
        assertEquals(coach1,removeCoachFromTeamEvent.getCoach());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void getTeam() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Coach coach = new Coach(new Member(null,null,null,"toni wak"), Coach.Certification.MainCoach);
        RemoveCoachFromTeamEvent removeCoachFromTeamEvent = new RemoveCoachFromTeamEvent(coach,team);
        assertEquals(team,removeCoachFromTeamEvent.getTeam());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void setTeam() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team team1 = new Team("HBS1",new TeamOwner(new Member("","","","roi")),null);
        Coach coach = new Coach(new Member(null,null,null,"toni wak"), Coach.Certification.MainCoach);
        RemoveCoachFromTeamEvent removeCoachFromTeamEvent = new RemoveCoachFromTeamEvent(coach,team);
        removeCoachFromTeamEvent.setTeam(team1);
        assertEquals(team1,removeCoachFromTeamEvent.getTeam());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void getDateTime() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Coach coach = new Coach(new Member(null,null,null,"toni wak"), Coach.Certification.MainCoach);
        RemoveCoachFromTeamEvent removeCoachFromTeamEvent = new RemoveCoachFromTeamEvent(coach,team);
        removeCoachFromTeamEvent.getDateTime();
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void setDateTime() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Coach coach = new Coach(new Member(null,null,null,"toni wak"), Coach.Certification.MainCoach);
        RemoveCoachFromTeamEvent removeCoachFromTeamEvent = new RemoveCoachFromTeamEvent(coach,team);
        LocalDateTime localDateTime = LocalDateTime.now();
        removeCoachFromTeamEvent.setDateTime(localDateTime);
        assertEquals(localDateTime,removeCoachFromTeamEvent.getDateTime());
        AlphaSystem.getSystem().ResetDB();
    }
}