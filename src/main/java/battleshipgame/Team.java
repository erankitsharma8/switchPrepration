package battleshipgame;

import java.util.List;

public class Team {
      Tank tank;
      String name;
      int [][] area;

    public Team() {

    }
    public Team(String name,int [][] area){
        this.name=name;
        this.area=area;
    }



    public void addTank(Tank tank) {
        this.tank=tank;
    }
}
