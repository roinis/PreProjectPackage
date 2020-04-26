import org.junit.Test;

import java.util.Random;
import Events.*;
import Jobs.*;
import Game.*;
import Association.*;
import System.*;
import User.*;

public class VisitorTest {

    @Test
    public void generateVisitorIDTest(){
        Visitor v = new Visitor();
        v.generateVisitorId();
        assertNotEquals("user1234",v.getUser_id_visitor());
        Random rand = new Random();
        int id_num = rand.nextInt(1000000);
        assertNotEquals(("user"+id_num),v.getUser_id_visitor());
    }

    private void assertNotEquals(String user1234, String user_id_visitor) {
    }
}
