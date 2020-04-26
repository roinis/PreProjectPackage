import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;
import Game.*;
import User.*;
import System.*;
import Jobs.*;
import Events.*;
import Association.*;

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
}
