import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import Game.*;
import User.*;
import System.*;
import Jobs.*;
import Events.*;
import Association.*;
public class StadiumTest {

    @Test
    public void stadiumDetailsTest(){
        String name,city;
        name="Turner Stadium";
        city="Beer-Sheva";
        Stadium stadium=new Stadium(name,city);
        assertEquals("Turner Stadium",stadium.getStadiumName());
        assertEquals("Beer-Sheva",stadium.getCity());
        stadium.setStadiumName("test");
        assertEquals("test",stadium.getStadiumName());
        AlphaSystem alphaSystem=AlphaSystem.getSystem();
        alphaSystem.ResetDB();
    }



}
