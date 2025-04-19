package battleshipgame;

//driver class
public class BattleShipGame {
    public static void main(String[] args) {
        int n=4; // User's input for number of grids
        BattleField battleField=new BattleField();
        battleField.initGame(n);
        battleField.addShip(1, 0, 1, 2, 1);
        battleField.addShip(2, 1, 3, 3, 3);



    }
}
