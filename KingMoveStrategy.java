import javafx.scene.image.Image;

public class KingMoveStrategy implements MoveStrategy {
    private ChessPiece chessPiece;

    public KingMoveStrategy(ChessPiece chessPiece){
        this.chessPiece=chessPiece;
        if (chessPiece.getType().equals(ChessType.WhiteKing)){
            chessPiece.setImage(new Image("/icon/whiteking.png"));
        }else{
            chessPiece.setImage(new Image("/icon/blackking.png"));
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
        if ((Math.abs(chessPiece.getX()-x)==1)&&(Math.abs(chessPiece.getY()-y)==1)){
            return true;
        }else
            return false;
    }
}
