package systemdesign.tictactoegame.model;

public class Board {

    int size;
    PlayingPiece[][] playingPieces;

    Board(int size){
        this.size=size;
        this.playingPieces=new PlayingPiece[size][size];
    }
}
