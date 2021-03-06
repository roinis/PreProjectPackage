import org.junit.Test;


import java.util.HashMap;

import static org.junit.Assert.*;
import Game.*;
import User.*;
import System.*;
import Jobs.*;
import Events.*;
import Association.*;
public class UserInformationTest {


    @Test
    public void getSpecificMemberTest1(){
        UsersInformation usersInformation = new UsersInformation();
        assertEquals("roei cohen",usersInformation.getSpecificMember("roei").getFull_name());
        AlphaSystem.getSystem().ResetDB();
    }


    @Test
    public void getSpecificMemberTest2(){
        UsersInformation usersInformation = new UsersInformation();
        assertEquals("12345",usersInformation.getSpecificMember("roei").getUser_id());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void getSpecificMemberTest3(){
        UsersInformation usersInformation = new UsersInformation();
        assertEquals("1234",usersInformation.getSpecificMember("roei").getUser_password());
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void readMembersInformationTest1(){
        UsersInformation usersInformation = new UsersInformation();
        usersInformation.editInformation(1,"roei","itay");
        HashMap<String,Member> users = usersInformation.getMembers();
        assertTrue(users.containsKey("itay"));
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void readMembersInformationTest2(){
        UsersInformation usersInformation = new UsersInformation();
        usersInformation.editInformation(2,"itay","0000");
        HashMap<String,Member> users = usersInformation.getMembers();
        assertTrue(users.get("itay").getUser_password().equals("0000"));
        AlphaSystem.getSystem().ResetDB();
    }
    @Test
    public void readMembersInformationTest3(){
        UsersInformation usersInformation = new UsersInformation();
        usersInformation.editInformation(3,"itay","204702");
        HashMap<String,Member> users = usersInformation.getMembers();
        assertTrue(users.get("itay").getUser_id().equals("204702"));
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void readMembersInformationTest4(){
        UsersInformation usersInformation = new UsersInformation();
        usersInformation.editInformation(4,"itay","itay levi");
        HashMap<String,Member> users = usersInformation.getMembers();
        assertTrue(users.get("itay").getFull_name().equals("itay levi"));
        AlphaSystem.getSystem().ResetDB();
    }

    @Test
    public void readMembersInformationTest5(){
        UsersInformation usersInformation = new UsersInformation();
        assertTrue(usersInformation.editInformation(1,"itay","roei"));
        HashMap<String,Member> users = usersInformation.getMembers();
        assertTrue(users.get("roei").getFull_name().equals("itay levi"));
        AlphaSystem.getSystem().ResetDB();
    }



}
