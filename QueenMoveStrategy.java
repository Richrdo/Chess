import javafx.scene.image.Image;

public class QueenMoveStrategy implements MoveStrategy {
    private ChessPiece chessPiece;

    public QueenMoveStrategy(ChessPiece chessPiece){
        this.chessPiece=chessPiece;
        if (chessPiece.getType().equals(ChessType.WhiteQueen)){
            chessPiece.setImage(new Image("/icon/whitequeen.png"));
        }else if(chessPiece.getType().equals(ChessType.BlackQueen)){
            chessPiece.setImage(new Image("/icon/blackqueen.png"));
        }
    }
    @Override
    public void move(int x, int y) {
        if(canmove(x,y)){
            chessPiece.setX(x);
            chessPiece.setY(y);
        }
    }

    public boolean canmove(int x,int y){
        if ((Math.abs(chessPiece.getX()-x)==Math.abs(chessPiece.getY()-y))){
            return true;
        }else if(chessPiece.getX()==x||chessPiece.getY()==y){
            return true;
        }else
            return false;
    }
}