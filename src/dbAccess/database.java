package dbAccess;

import java.sql.*;

public class database {


    /*public boolean insertObjectToDB(int choice,String[] values){
        String sql="INSERT INTO ";
        switch (choice){
            case 1:
                if(values.length!=5)
                sql+= "dbo.League "
        }
    }*/

    public boolean insertSqlToDB(String sql){
        try{
            String connectionUrl = "jdbc:sqlserver://DESKTOP-5FLNA96;"
                    + "database=Football;"
                    + "user=sa;"
                    + "password=123;"
                    + "encrypt=false;"
                    + "trustServerCertificate=false;"
                    + "loginTimeout=30;";
            Connection connection = DriverManager.getConnection(connectionUrl);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertToDB(int choice, String[] values) {
        return false;
    }
}

/*
* 1 -league
* 2 -season
* 3 -game
* 4 -
* 5 -main ref to season
* 6 -lineRef to season
* 7 -varRef to season
* 8 -
* 9 -GoalEvent
* 10-InjuryEvent
* 11-OffsideEvent
* 12 - redCard
* 13 -yellowCard
* 14 -team
* 15 -budget
* 16 -budget info
* 17 -team owners
* 18 -owners Appoigntments
* 19 - player to team
* 20 - coach to team
* 21 - manager to team
* 22 - fan(observers) to team
* 23 - jobs (observers) to tean
* 24 - mainReferee
* 25 - var REF
* 26 - line Ref
* 27 - player
* 28 - member tweets
* 29 - player observers
* 30 - manager
* 31 - manager permissions
* 32 - team Owner
* 33 - ticket
* 34 - stadium
* 35 - coach
* 36 - member to ticket
* 37 -member searches
* 38 -member searches
* 39 -members team followed
* 40 -members players followed
* 41 -members coaches followed
 */
