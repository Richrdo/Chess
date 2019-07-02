import javafx.scene.image.Image;
public class RookMoveStrategy implements MoveStrategy {
    private ChessPiece chessPiece;

    public RookMoveStrategy(ChessPiece chessPiece){
        this.chessPiece=chessPiece;
        if (chessPiece.getType().equals(ChessType.WhiteRook)){
            chessPiece.setImage(new Image("/icon/whiterook.png"));
        }else if (chessPiece.getType().equals(ChessType.BlackRook)){
            chessPiece.setImage(new Image("/icon/blackrook.png"));
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
        if ((chessPiece.getX()==x)||(chessPiece.getY()==y)){
            return true;
        }else
            return false;
    }
}