import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import Game.*;
import User.*;
import System.*;
import Jobs.*;
import Events.*;
import Association.*;

public class AddPlayerToTeamEventTest {


    @Test
    public void testToString() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"toni wak"),null,null);
        AddPlayerToTeamEvent addPlayerToTeamEvent = new AddPlayerToTeamEvent(player,team);
        String eventString = "The Player: " +
                player.getMemberFullName() +
                " has joined the Team: " + team.getTeamName() +
                " At: " + addPlayerToTeamEvent.getDateTime();
        assertEquals(eventString,addPlayerToTeamEvent.toString());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void testToString1() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"toni wak"),null,null);
        AddPlayerToTeamEvent addPlayerToTeamEvent = new AddPlayerToTeamEvent(player,team);
        String eventString = "The Player: " +
                player.getMemberFullName() +
                " has joined the Team: " + team.getTeamName() +
                " At: " + addPlayerToTeamEvent.getDateTime();

        addPlayerToTeamEvent.setPlayer(new Player(new Member(null,null,null,"yossi"),null,null));
        assertNotEquals(eventString,addPlayerToTeamEvent.toString());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void testToString2() {
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"toni wak"),null,null);
        AddPlayerToTeamEvent addPlayerToTeamEvent = new AddPlayerToTeamEvent(player,team);
        String eventString = "The Player: " +
                player.getMemberFullName() +
                " has joined the Team: " + team.getTeamName() +
                " At: " + addPlayerToTeamEvent.getDateTime();
        addPlayerToTeamEvent.setTeam(new Team("TelAviv",new TeamOwner(new Member("","","","roi")),null));
        assertNotEquals(eventString,addPlayerToTeamEvent.toString());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void getPlayer() {
        Player player = new Player(new Member(null,null,null,"toni wak"),null,null);
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        AddPlayerToTeamEvent addPlayerToTeamEvent = new AddPlayerToTeamEvent(player,team);
        assertEquals(player,addPlayerToTeamEvent.getPlayer());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void setPlayer() {
        Player player = new Player(new Member(null,null,null,"toni wak"),null,null);
        Player player1 = new Player(new Member(null,null,null,"toni wak1"),null,null);
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        AddPlayerToTeamEvent addPlayerToTeamEvent = new AddPlayerToTeamEvent(player,team);
        addPlayerToTeamEvent.setPlayer(player1);
        assertEquals(player1,addPlayerToTeamEvent.getPlayer());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void getTeam() {
        Player player = new Player(new Member(null,null,null,"toni wak"),null,null);
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        AddPlayerToTeamEvent addPlayerToTeamEvent = new AddPlayerToTeamEvent(player,team);
        assertEquals(team,addPlayerToTeamEvent.getTeam());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void setTeam() {
        Player player = new Player(new Member(null,null,null,"toni wak"),null,null);
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        Team team1 = new Team("HBS1",new TeamOwner(new Member("","","","roi")),null);
        AddPlayerToTeamEvent addPlayerToTeamEvent = new AddPlayerToTeamEvent(player,team);
        addPlayerToTeamEvent.setTeam(team1);
        assertEquals(team1,addPlayerToTeamEvent.getTeam());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void getDateTime() {
        Player player = new Player(new Member(null,null,null,"toni wak"),null,null);
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        AddPlayerToTeamEvent addPlayerToTeamEvent = new AddPlayerToTeamEvent(player,team);
        addPlayerToTeamEvent.getDateTime();
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void setDateTime() {
        Player player = new Player(new Member(null,null,null,"toni wak"),null,null);
        Team team = new Team("HBS",new TeamOwner(new Member("","","","roi")),null);
        LocalDateTime localDateTime = LocalDateTime.now();
        AddPlayerToTeamEvent addPlayerToTeamEvent = new AddPlayerToTeamEvent(player,team);
        addPlayerToTeamEvent.setDateTime(localDateTime);
        assertEquals(localDateTime,addPlayerToTeamEvent.getDateTime());
        AlphaSystem.getSystem().ResetDB();
    }
}