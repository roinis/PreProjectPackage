import Events.TewwtEvent;
import org.junit.Test;

import static org.junit.Assert.*;
import Events.*;
import Jobs.*;
import Game.*;
import Association.*;
import System.*;
import User.*;

public class TewwtEventTest {

    @Test
    public void testToString() {

        TewwtEvent tewwtEvent = new TewwtEvent("wattsup");
        assertEquals(tewwtEvent.toString(),"wattsup");
    }

}