package Events;
import Game.*;
import User.*;
import System.*;
import Jobs.*;
import Association.*;

public class TewwtEvent implements Event {
    String tewwt;

    public TewwtEvent(String tewwt) {
        this.tewwt = tewwt;
        addEventToLog();
    }

    @Override
    public String toString() {
        return tewwt;
    }

    @Override
    public void addEventToLog() {
        AlphaSystem.getSystem().getLog().addEvent(this);
    }

    public String getTewwt() {
        return tewwt;
    }

    public void setTewwt(String tewwt) {
        this.tewwt = tewwt;
    }
}
