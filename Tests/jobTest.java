import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;
import Game.*;
import User.*;
import System.*;
import Jobs.*;
import Events.*;
import Association.*;

public class jobTest {

    @Test
    public void gettersTest() {
        Member member = new Member("test", "12345", "12345", "gettersTest");
        Job job = new Player(member, Player.Position.ST, LocalDate.of(1992, 7, 23));
        assertEquals("player",job.getJobName());
        assertEquals("test",job.getMemberUserName());
        assertEquals("gettersTest",job.getMemberFullName());
        assertEquals(member,job.getMember());
    }

}
