import org.junit.Test;

import static org.junit.Assert.*;
import Game.*;
import User.*;
import System.*;
import Jobs.*;
import Events.*;
import Association.*;

public class RemoveNominationEventTest {

    @Test
    public void testToString() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Member member = new Member(null,null,null,"toni wak");
        RemoveNominationEvent removeNominationEvent = new RemoveNominationEvent(team,member,"coach");
        String eventString = member.getFull_name() + " of team " + team.getTeamName()
                +" has fired from " + "coach"
                + " position.";
        assertEquals(eventString,removeNominationEvent.toString());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void testToString1() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Member member = new Member(null,null,null,"toni wak");
        RemoveNominationEvent removeNominationEvent = new RemoveNominationEvent(team,member,"coach");
        String eventString = member.getFull_name() + " of team " + team.getTeamName()
                +" has fired from " + "coach"
                + " position.";
        removeNominationEvent.setNomination("player");
        assertNotEquals(eventString,removeNominationEvent.toString());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void testToString2() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Member member = new Member(null,null,null,"toni wak");
        RemoveNominationEvent removeNominationEvent = new RemoveNominationEvent(team,member,"coach");
        String eventString = member.getFull_name() + " of team " + team.getTeamName()
                +" has fired from " + "coach"
                + " position.";
        removeNominationEvent.setTeam(new Team("MTA",new TeamOwner(new Member("","","","roi")),null));
        assertNotEquals(eventString,removeNominationEvent.toString());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void getMember() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Member member = new Member(null,null,null,"toni wak");
        RemoveNominationEvent removeNominationEvent = new RemoveNominationEvent(team,member,"coach");
        assertEquals(member,removeNominationEvent.getMember());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void getTeam() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Member member = new Member(null,null,null,"toni wak");
        RemoveNominationEvent removeNominationEvent = new RemoveNominationEvent(team,member,"coach");
        assertEquals(team,removeNominationEvent.getTeam());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void setTeam() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team team1 = new Team("HBS1",new TeamOwner(new Member("","","","roi")),null);
        Member member = new Member(null,null,null,"toni wak");
        RemoveNominationEvent removeNominationEvent = new RemoveNominationEvent(team,member,"coach");
        removeNominationEvent.setTeam(team1);
        assertEquals(team1,removeNominationEvent.getTeam());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void setMember() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Member member = new Member(null,null,null,"toni wak");
        Member member1 = new Member(null,null,null,"toni wak1");

        RemoveNominationEvent removeNominationEvent = new RemoveNominationEvent(team,member,"coach");
        removeNominationEvent.setMember(member1);
        assertEquals(member1,removeNominationEvent.getMember());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void getNomination() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Member member = new Member(null,null,null,"toni wak");
        RemoveNominationEvent removeNominationEvent = new RemoveNominationEvent(team,member,"coach");
        assertEquals("coach",removeNominationEvent.getNomination());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void setNomination() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Member member = new Member(null,null,null,"toni wak");
        RemoveNominationEvent removeNominationEvent = new RemoveNominationEvent(team,member,"coach");
        removeNominationEvent.setNomination("check");
        assertEquals("check",removeNominationEvent.getNomination());
        AlphaSystem.getSystem().ResetDB();
    }


}