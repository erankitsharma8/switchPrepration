package battleshipgame;

import java.util.List;

public class BattleField {
     List<Team>  teamList;
     int [][] battleBoard;

    public void initGame(int n){
        this.battleBoard=new int[n][n];
        Team teamA=new Team("A",new int[n/2][n]);
        teamList.add(teamA);
        Team teamB=new Team("B",new int[n/2][n]);
        teamList.add(teamB);

    }

    public void addShip(int id,int xA,int yA,int xB,int yB){
              Team teamA=teamList.get(0);
              teamA.addTank(new Tank(id,xA,yA));
              teamList.add(0,teamA);
              Team teamB=new Team();
              teamB.addTank(new Tank(id,xB,yB));
              this.teamList.add(teamB);
    }


}
