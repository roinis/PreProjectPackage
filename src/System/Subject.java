package System;
import Events.*;
import User.*;
import Jobs.*;
import Game.*;
import Association.*;

import Events.Event;

public interface Subject {
    public void register(Observer observer);
    public void unregister(Observer observer);
    public void notifyObserver(Event newEvent);
}
