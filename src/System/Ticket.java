package System;
import Events.*;
import User.*;
import Jobs.*;
import Game.*;
import Association.*;

public class Ticket {
    static int ID;
    Member WrittenBy;
    boolean Answered;
    public String Complaint;
    String Answer;
    String TicketID;

    public String getWrittenByID() {
        return WrittenBy.getUser_id();
    }

    public Ticket(Member writtenBy, String complaint){
        Answered = false;
        Complaint = complaint;
        WrittenBy = writtenBy;
        TicketID = Integer.toString(ID);
        ID++;
        AlphaSystem system = AlphaSystem.getSystem();
        system.AddtoDB(10, this);
    }

    public String getTicketID(){
        return TicketID;
    }

    public boolean getIfAnswered(){
        return Answered;
    }

    public void AnswerTicket(String answer){
        Answered = true;
        Answer = answer;
        //WrittenBy.update(); ??
    }

    public String getComplaint(){
       return Complaint;
    }

    public String getAnswer(){
        return Answer;
    }

}
