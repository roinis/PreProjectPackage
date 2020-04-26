package System;
import Events.*;
import User.*;
import Jobs.*;
import Game.*;
import Association.*;

import Events.Event;

public interface Observer {
    public void update(Event newEvent);
}
