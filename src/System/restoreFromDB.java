package System;
import Association.Budget;
import Game.*;
import Jobs.*;
import User.Member;
import dbAccess.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class restoreFromDB {
    database database;
    AlphaSystem system=AlphaSystem.getSystem();

    public restoreFromDB() {
        this.database = new database();
    }

    public void restore(){
        restoreMembers();
        restoreOwners();
        restoreManagers();
        restoreCoaches();
        restorePlayers();
        restoreReferees();
        restoreTeams();
        restoreLeagues();
        restoreStadiums();
        restoreTickets();
    }

    private void restorePlayers(){
        String[][] players=database.getAllPlayers();
        for (String[] playerValues:players){
            createPlayer(playerValues);
        }
    }

    private void restoreCoaches(){
        String[][] coaches=database.getAllCoaches();
        for(String[] coachValues:coaches)
            createCoach(coachValues);
    }

    private void restoreManagers(){
        String[][] managers=database.getAllManagers();
        for (String[] managerValues:managers){
            String[][] permissions=database.getManagersPermissions(managerValues[0]);
            ArrayList<TeamManager.Permissions> perList=new ArrayList<>();
            for (String[] permission:permissions){
                perList.add(TeamManager.Permissions.values()[Integer.parseInt(permission[1])]);
            }
            createTeamManager(managerValues,perList);
        }
    }

    private void restoreOwners(){
        String[][] owners=database.getAllOwners();
        for (String[] ownerValues:owners)
            createTeamOwner(ownerValues);
    }

    private void restoreReferees(){
        String[][] referees=database.getAllMainReferees();
        for (String[] refereeValue:referees) {
            createMainReferee(refereeValue);
        }
        referees=database.getAllLinesReferees();
        for (String[] refereeValue:referees) {
            createLineReferee(refereeValue);
        }
        referees=database.getAllVarReferees();
        for (String[] refereeValue:referees) {
            createVarReferee(refereeValue);
        }
    }

    private void restoreMembers(){
        String[][] members=database.getAllMembers();
        for (String[] memberValue:members){
            createMember(memberValue);
        }
    }

    private void restoreTickets(){
        String[][] tickets=database.getAllTickets();
        for (String[] ticketValue:tickets)
            createTicket(ticketValue);
    }

    private void restoreTeams(){
        String[][] teams=database.getAllTeams();
        for (String[] teamValues:teams){
            Team currTeam= createTeam(teamValues);
            restoreTeamBudget(currTeam,database.getTeamBudget(currTeam.getTeamName()));
            restoreTeamOwners(currTeam);
            // need to add managers
            restoreTeamPlayers(currTeam);
            restoreTeamCoaches(currTeam);
            restoreTeamsFans(currTeam);
            restoreTeamsJobObservers(currTeam);//need to fix
        }
    }

    private void restoreTeamOwners(Team team){
        String[][] owners=database.getTeamOwners(team.getTeamName());
        for (String[] ownerValues:owners) {
            Member member=(Member) system.GetSpecificFromDB(2,ownerValues[0]);
            TeamOwner owner=new TeamOwner(member);
            owner.setTeam(team);
            team.addOwner(owner);
        }
        List<TeamOwner> OwnersList = team.getOwners();
        for (TeamOwner owner:OwnersList) {
            String[][] appointments=database.getOwnersAppointments(owner.getMember().getUser_id());
            for (String[] appointment:appointments){
                TeamOwner nomination=(TeamOwner) system.GetSpecificFromDB(6,appointment[1]);
                if (nomination!=null)
                    owner.addOwner(appointment[1]);
                else{
                    ///add manager??????
                }
            }
        }
    }

    private void restoreTeamPlayers(Team team){
        String[][] players=database.getTeamPlayers(team.getTeamName());
        for (String[] playerValues:players) {
            Player player=(Player)system.GetSpecificFromDB(7,playerValues[1]);
            player.addToTeam(team);
            team.addNewPlayer(player.getMember().getUser_id());
        }
    }

    private void restoreTeamCoaches(Team team){
        String[][] coaches=database.getTeamCoaches(team.getTeamName());
        for (String[] coachValues:coaches) {
            Coach coach=(Coach) system.GetSpecificFromDB(3,coachValues[1]);
            coach.addToTeam(team,coach.getJobInTheTeam());
            team.addNewCoach(coach.getMember().getUser_id(),coach.getJobInTheTeam());
        }
    }

    private void restoreTeamsFans(Team team){
        String[][] fans=database.getTeamsFans(team.getTeamName());
        for (String[] fanValue:fans){
            Member member=(Member)system.GetSpecificFromDB(2,fanValue[1]);
            team.register(member);
            member.followTeam(team);
        }
    }

    private void restoreTeamsJobObservers(Team team){
        String[][] wanted=database.getTeamJobObservers(team.getTeamName());
        for (String[] observerValues:wanted){
            Member member=(Member)system.GetSpecificFromDB(2,observerValues[1]);
            member.followTeam(team);//need fix
        }
    }

    private void restoreLeagues(){
        String[][] leagues=database.getAllLeagues();
        for (String[] leagueValues :leagues){
            League currLeage= createLeague(leagueValues);
            String[][] seasons=database.getAllLeagueSeasons(currLeage.getName());
            for (String[] seasonValues:seasons){
                Season currSeason= createSeason(seasonValues);
                currLeage.addSeason(currSeason);
                String[][] positions=database.getSeasonPositions(currLeage.getName(),currSeason.getYear()+"");
                LinkedList<LeaguePosition> table=new LinkedList<>();
                for (String[] position:positions) {
                    LeaguePosition currLeaguePosition= createLeaguePosition(position);
                    table.add(currLeaguePosition);
                }
                currSeason.setTable(table);
                String[][] games=database.getFootballGames(currLeage.getName(),currSeason.getYear()+"");
                for (String[] game:games){
                    FootballGame currGame= createFootballGame(game);
                    currSeason.addGame(currGame);
                }
            }
        }
    }

    private void restoreStadiums(){
        String[][] stadiums=database.getAllStadiums();
        for (String[] stadiumValues:stadiums){
            createStadium(stadiumValues);
        }
    }

    private void restoreTeamBudget(Team team,String[][] transactions){
        Budget budget=new Budget(team);
        for(String[] transaction:transactions){
            double cash=Double.parseDouble(transaction[2]);
            if (cash>0)
                budget.addDeposit(cash,transaction[3],createLocalDateTime(transaction[1]));
        }
        team.setBudget(budget);
    }


    //need fix!!!!!!!!!!!!!!!!!!!!!!!!
    private Ticket createTicket(String[] values) {
        //String[] values={ticket.getTicketID(),ticket.getWrittenByID(),ticket.getAnswer(),ticket.getComplaint(),ticket.getIfAnswered()+""};
        Member writtenBy=(Member)system.GetSpecificFromDB(2,values[1]);
        Ticket ticket=new Ticket(writtenBy,values[3]);
        //ticket.
        return null;
    }

    private League createLeague(String[] values){
        SchedulingPolicy schedulingPolicy=new SchedulingPolicy(Integer.parseInt(values[1]));
        ScoringPolicy scoringPolicy=new ScoringPolicy(Integer.parseInt(values[2]),Integer.parseInt(values[4]),Integer.parseInt(values[3]));
        League league=new League(values[0],schedulingPolicy,scoringPolicy);
        return league;
    }


    private Season createSeason(String[] values){
        SchedulingPolicy schedulingPolicy=new SchedulingPolicy(Integer.parseInt(values[2]));
        ScoringPolicy scoringPolicy=new ScoringPolicy(Integer.parseInt(values[3]),Integer.parseInt(values[5]),Integer.parseInt(values[4]));
        Season season=new Season(Integer.parseInt(values[0]),schedulingPolicy,scoringPolicy);
        return season;
    }

    private Stadium createStadium(String[] values){
        Stadium stadium=new Stadium(values[0],values[1]);
        return stadium;
    }

    private Team createTeam(String[] values){
        Stadium stadium =(Stadium) system.GetSpecificFromDB(11,values[2]);
        Team team=new Team(values[0],null,stadium);
        team.setStatus(Team.Status.values()[Integer.parseInt(values[1])]);
        return team;
    }

    private Member createMember(String[] values){
        //String[] values={member.getUser_id(),member.getFull_name(),member.getUser_name(),member.getUser_password(),member.isBlocked()+""};
        Member member=new Member(values[2],values[3],values[0],values[1]);
        member.setBlocked(Boolean.parseBoolean(values[4]));
        return member;
    }

    private Coach createCoach(String[] values){
        Member member=(Member) system.GetSpecificFromDB(2,values[0]);
        Coach coach=new Coach(member,Coach.Certification.values()[Integer.parseInt(values[2])]);
        coach.setJobInTheTeam(values[3]);
        return coach;
    }

    private Player createPlayer(String[] values){
        Member member=(Member) system.GetSpecificFromDB(2,values[0]);
        Player player=new Player(member,Player.Position.values()[Integer.parseInt(values[1])],createLocalDate(values[2]));
        Team team=(Team)system.GetSpecificFromDB(4,values[3]);
        player.addToTeam(team);
        return player;
    }

    private MainReferee createMainReferee(String values[]){
        Member member=(Member) system.GetSpecificFromDB(2,values[0]);
        MainReferee mainReferee=new MainReferee(member);
        boolean active=Boolean.parseBoolean(values[1]);
        if(!active)
            mainReferee.DelistAsRef();
        return mainReferee;
    }

    private LinesManReferee createLineReferee(String values[]){
        Member member=(Member) system.GetSpecificFromDB(2,values[0]);
        LinesManReferee linesManReferee=new LinesManReferee(member);
        boolean active=Boolean.parseBoolean(values[1]);
        if(!active)
            linesManReferee.DelistAsRef();
        return linesManReferee;
    }

    private VarReferee createVarReferee(String values[]){
        Member member=(Member) system.GetSpecificFromDB(2,values[0]);
        VarReferee varReferee=new VarReferee(member);
        boolean active=Boolean.parseBoolean(values[1]);
        if(!active)
            varReferee.DelistAsRef();
        return varReferee;
    }

    private TeamManager createTeamManager(String values[], ArrayList<TeamManager.Permissions> permissions){
        Member member=(Member) system.GetSpecificFromDB(2,values[0]);
        Team team=(Team) system.GetSpecificFromDB(4,values[2]);
        TeamManager manager=new TeamManager(member,team,permissions);
        return manager;
    }

    private TeamOwner createTeamOwner(String[] values){
        Member member=(Member) system.GetSpecificFromDB(2,values[0]);
        TeamOwner owner=new TeamOwner(member);
        return owner;
    }

    private LeaguePosition createLeaguePosition(String[] values){
        Team team=(Team)system.GetSpecificFromDB(4 ,values[2]);
        LeaguePosition leaguePosition=new LeaguePosition(team,Integer.parseInt(values[3]),Integer.parseInt(values[4]),Integer.parseInt(values[5]),Integer.parseInt(values[6]),Integer.parseInt(values[7]));
        return leaguePosition;
    }

    private FootballGame createFootballGame(String[] values){
        League league=(League)system.GetSpecificFromDB(1,values[0]);
        Season season=league.getSpecSeason(Integer.parseInt(values[1]));
        Team home=(Team) system.GetSpecificFromDB(4,values[2]);
        Team away=(Team) system.GetSpecificFromDB(4,values[3]);
        FootballGame game=new FootballGame(season,home,away,createLocalDateTime(values[4]));
        MainReferee mainReferee=(MainReferee)system.GetSpecificFromDB(9,values[8]);
        VarReferee varReferee=(VarReferee)system.GetSpecificFromDB(9,values[9]);
        LinesManReferee linesManReferee1=(LinesManReferee)system.GetSpecificFromDB(9,values[10]);
        LinesManReferee linesManReferee2=(LinesManReferee)system.GetSpecificFromDB(9,values[11]);
        game.setMainReferee(mainReferee);
        game.setLinesManLeft(linesManReferee1);
        game.setLinesManRight(linesManReferee2);
        game.setVarReferee(varReferee);
        int goals=Integer.parseInt(values[5]);
        for (int i = 0; i < goals; i++) {
            game.homeScoreGoal();
        }
        goals=Integer.parseInt(values[6]);
        for (int i = 0; i < goals; i++) {
            game.awayScoreGoal();
        }
        Stadium stadium=(Stadium)system.GetSpecificFromDB(11,values[7]);
        game.setStadium(stadium);
        return game;
    }

    private LocalDateTime createLocalDateTime(String value) {
        String delimiters = "[-T:]";
        String[] c=value.split(delimiters);
        return LocalDateTime.of(Integer.parseInt(c[0]),Integer.parseInt(c[1]),Integer.parseInt(c[2]),Integer.parseInt(c[3]),Integer.parseInt(c[4]));
    }

    private LocalDate createLocalDate(String value) {
        String[] c=value.split("-");
        LocalDate date=LocalDate.of(Integer.parseInt(c[0]),Integer.parseInt(c[1]),Integer.parseInt(c[2]));
        return date;
    }
}
