import org.junit.Test;

import java.sql.Time;

import static org.junit.Assert.*;
import Game.*;
import User.*;
import System.*;
import Jobs.*;
import Events.*;
import Association.*;

public class SubstitutionEventTest {

    @Deprecated
    @Test
    public void testToString() {
        Time gameTime = new Time(0,26,35);
        Team team = new Team("Maccabi Ha",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"Rokaviza ch"),null,null);
        Player ingoingPlayer = new Player(new Member(null,null,null,"john"),null,null);
        SubstitutionEvent substitutionEvent = new SubstitutionEvent(gameTime,"",team,player,ingoingPlayer);
        String eventString = "Substitution in team " +
                team.getTeamName() +
                "The Player " +
                ingoingPlayer.getMember().getFull_name() +
                " Subtituted " +
                player.getMember().getFull_name() +
                " at " + gameTime + ".";
        assertEquals(substitutionEvent.toString(),eventString);
        AlphaSystem.getSystem().ResetDB();
    }

    @Deprecated
    @Test
    public void testToString1() {
        Time gameTime = new Time(0,26,35);
        Team team = new Team("Maccabi Ha",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"Rokaviza ch"),null,null);
        Player ingoingPlayer = new Player(new Member(null,null,null,"john"),null,null);
        SubstitutionEvent substitutionEvent = new SubstitutionEvent(gameTime,"",team,player,ingoingPlayer);
        String eventString = "Substitution in team " +
                team.getTeamName() +
                "The Player " +
                ingoingPlayer.getMember().getFull_name() +
                " Subtituted " +
                player.getMember().getFull_name() +
                " at " + gameTime + ".";
        substitutionEvent.setIngoingPlayer(new Player(new Member(null,null,null,"pola"),null,null));
        assertNotEquals(substitutionEvent.toString(),eventString);
        AlphaSystem.getSystem().ResetDB();
    }

    @Deprecated
    @Test
    public void testToString2() {
        Time gameTime = new Time(0,26,35);
        Team team = new Team("Maccabi Ha",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"Rokaviza ch"),null,null);
        Player ingoingPlayer = new Player(new Member(null,null,null,"john"),null,null);
        SubstitutionEvent substitutionEvent = new SubstitutionEvent(gameTime,"",team,player,ingoingPlayer);
        String eventString = "Substitution in team " +
                team.getTeamName() +
                "The Player " +
                ingoingPlayer.getMember().getFull_name() +
                " Subtituted " +
                player.getMember().getFull_name() +
                " at " + gameTime + ".";
        substitutionEvent.setEventPlayer(new Player(new Member(null,null,null,"reuven"),null,null));
        assertNotEquals(substitutionEvent.toString(),eventString);
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void getIngoingPlayer() {

        Time gameTime = new Time(0,26,35);
        Team team = new Team("Maccabi Ha",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"Rokaviza ch"),null,null);
        Player ingoingPlayer = new Player(new Member(null,null,null,"john"),null,null);
        SubstitutionEvent substitutionEvent = new SubstitutionEvent(gameTime,"",team,player,ingoingPlayer);
        assertEquals(ingoingPlayer,substitutionEvent.getIngoingPlayer());
    }

    @Test
    public void setIngoingPlayer() {
        Time gameTime = new Time(0,26,35);
        Team team = new Team("Maccabi Ha",new TeamOwner(new Member("","","","roi")),null);
        Player player = new Player(new Member(null,null,null,"Rokaviza ch"),null,null);
        Player ingoingPlayer = new Player(new Member(null,null,null,"john"),null,null);
        SubstitutionEvent substitutionEvent = new SubstitutionEvent(gameTime,"",team,player,ingoingPlayer);
        substitutionEvent.setIngoingPlayer(player);
        assertEquals(player,substitutionEvent.getIngoingPlayer());
    }

}