import javafx.scene.image.Image;

public class KnightMoveStrategy  implements MoveStrategy {
    private ChessPiece chessPiece;

    public KnightMoveStrategy(ChessPiece chessPiece){
        this.chessPiece=chessPiece;
        if (chessPiece.getType().equals(ChessType.WhiteKnight)){
            chessPiece.setImage(new Image("/icon/whiteknight.png"));
        }else{
            chessPiece.setImage(new Image("/icon/blackknight.png"));
        }
    }
    @Override
    public void move(int x,int y){
        if (canmove(x,y)){
            chessPiece.setY(y);
            chessPiece.setX(x);
        }
    }

    public boolean canmove(int x, int y){
        if (Math.abs(chessPiece.getX()-x)==1&&Math.abs(chessPiece.getY()-y)==2){
            return true;
        }else if ((Math.abs(chessPiece.getX()-x)==2)&&Math.abs(chessPiece.getY()-y)==1){
            return true;
        }else
            return false;
    }
}
