import Events.Event;
import org.junit.Test;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDate;

import static org.junit.Assert.*;
import Game.*;
import User.*;
import System.*;
import Jobs.*;
import Events.*;
import Association.*;

public class PlayerTest{

    @Test
    public void playerGettersTest(){
        Player player=new Player(null,Player.Position.ST, LocalDate.of(1992,7,23));
        assertEquals("ST",player.getPositionName());
        assertEquals("1992-07-23",player.getStringBirthDate());
        assertEquals(null, player.getTeam());
        AlphaSystem alphaSystem=AlphaSystem.getSystem();
        alphaSystem.ResetDB();
    }

   @Test
    public void settersTest(){
        MemberStub memberStub=new MemberStub("test","12345","12345","test");
        Player player=new Player(memberStub,Player.Position.ST, LocalDate.of(1992,7,23));
        player.editBirthDay(2000,01,01);
        assertEquals("2000-01-01",player.getStringBirthDate());
        player.editFullName("barda");
        assertEquals("barda",player.getMemberFullName());
        player.editPosition("GK");
        assertEquals("GK",player.getPositionName());
       AlphaSystem alphaSystem=AlphaSystem.getSystem();
       alphaSystem.ResetDB();
    }

    @Test
    public void  tweetsTest(){
        Player player=new Player(null,Player.Position.ST, LocalDate.of(1992,7,23));
        player.addTweet("test");
        assertTrue(player.getTweets().contains("test"));
        player.deleteTweet(0);
        assertFalse(player.getTweets().contains("test"));
        AlphaSystem alphaSystem=AlphaSystem.getSystem();
        alphaSystem.ResetDB();
    }

    @Test
    public void observerTest(){
        Observer observer=new Observer() {
            @Override
            public void update(Event newEvent) {
                assertTrue(true);
            }
        };
        Player player=new Player(null,Player.Position.ST, LocalDate.of(1992,7,23));
        player.register(observer);
        assertTrue(player.getObservers().contains(observer));
        player.notifyObserver(new TewwtEvent("test"));
        player.unregister(observer);
        assertFalse(player.getObservers().contains(observer));
        AlphaSystem alphaSystem=AlphaSystem.getSystem();
        alphaSystem.ResetDB();
    }

    @Test
    public void TeamTest(){
        TeamOwner teamOwner=new TeamOwner(null);
        Team team=new Team("hapoel",teamOwner,null);
        Player player=new Player(null,Player.Position.ST, LocalDate.of(1992,7,23));
        assertTrue(player.addToTeam(team));
        assertEquals(team,player.getTeam());
        assertFalse(player.addToTeam(team));
        assertTrue(player.removeFromTeam());
        assertEquals(null,player.getTeam());
        assertFalse(player.removeFromTeam());
        AlphaSystem alphaSystem=AlphaSystem.getSystem();
        alphaSystem.ResetDB();
    }

    public class MemberStub extends Member{
        public MemberStub(String user_name,String user_password,String user_id,String full_name){
            super(user_name,user_password, user_id, full_name);
            AlphaSystem alphaSystem=AlphaSystem.getSystem();
            alphaSystem.AddtoDB(2,this);
        }

    }

}
