import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import Game.*;
import User.*;
import System.*;
import Jobs.*;
import Events.*;
import Association.*;

public class AlphaSystemTest {

    @Test
    public void GetSpecificFromDB(){
        AlphaSystem system = AlphaSystem.getSystem();
        system.ResetDB();
        Member TestMember = new Member("","","","");
        TeamOwner Owner = new TeamOwner(TestMember);
        TestMember.addJob(Owner);
        Stadium TestStadium = new Stadium("TestName", "TestCity");
        Team NewTeam = new Team("TestTeam", Owner, TestStadium);
        assertEquals(system.GetSpecificFromDB(4,"TestTeam"),NewTeam);
    }

    @Test
    public void AddtoDBTest(){
        AlphaSystem system = AlphaSystem.getSystem();
        system.ResetDB();
        assertEquals(0,((List<League>)system.GetAllFromDB(1)).size());
        League TestLeague = new League("",null,null);
        assertEquals(1,((List<League>)system.GetAllFromDB(1)).size());
    }

    @Test
    public void RemoveMemberTest(){
        AlphaSystem system = AlphaSystem.getSystem();
        system.ResetDB();
        Member TestMember = new Member("","","","");
        system.AddtoDB(2,TestMember);
        assertEquals(1,((List<League>)system.GetAllFromDB(2)).size());
        system.RemoveMember(TestMember);
        assertEquals(0,((List<League>)system.GetAllFromDB(2)).size());
    }


    @Test
    public void GetTicket(){
        AlphaSystem system = AlphaSystem.getSystem();
        system.ResetDB();
        Member TestMember = new Member("","","","");
        Ticket TestTicket = new Ticket(TestMember,"");
        assertEquals(TestTicket,system.GetNextUnansweredTicket());
    }







    /*
      Leagues;  //1
   Members; //2
    Coaches; //3
    Teams;  //4
   TeamManagers; //5
    TeamOwners; //6

     */
//
//
//    private void Register(){
//        RegisterSys.registerToSystem();
//    }
//
//    private void Logout(Member member){
//        LoggedInMembers.remove(member);
//        //member.logout();
//    }
//
//
//    public  Object GetSpecificFromDB(int Type, String Name)
//    {
//        return DB.Getspecific(Type,Name);
//    }
//
//    public  Object GetAllFromDB(int Type)
//    {
//        return DB.GetAll(Type);
//    }
//
//    public void AddtoDB(int Type, Object ToAdd)
//    {
//        DB.AddtoDB(Type,ToAdd);
//    }
//
//    public  void RemoveMember(Member member)
//    {
//        DB.RemoveMember(member);
//    }
//
//    public Ticket GetNextUnansweredTicket() {
//        return DB.GetNextUnansweredTicket();
//    }
//
//    public EventLog getLog() {
//        return DB.GetLog();
//    }


}