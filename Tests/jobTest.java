import org.junit.Test;

import java.time.LocalDate;
import Events.*;
import Jobs.*;
import Game.*;
import Association.*;
import System.*;
import User.*;

import static org.junit.Assert.assertEquals;

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
