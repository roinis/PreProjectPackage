//roei cohen

import java.util.HashSet;
import java.util.Random;
import Events.*;
import Jobs.*;
import Game.*;
import Association.*;
import System.*;
import User.*;
import Game.*;
import User.*;
import System.*;
import Jobs.*;
import Events.*;
import Association.*;

public class VisitorStub extends User {

    private String user_id_visitor;
    private static HashSet<Integer> id_numbers_visitor = new HashSet<>();

    public VisitorStub(){
        generateVisitorId();
    }

    public void generateVisitorId(){
        String name = "visitor";
        Random rand = new Random();
        int id_num = rand.nextInt(1000000);
        while(this.id_numbers_visitor.contains(id_num)){
            id_num=rand.nextInt(1000000);
        }
        this.id_numbers_visitor.add(id_num);
        String id = Integer.toString(id_num);
        id = name+id;
        this.user_id_visitor=id;
    }





}
