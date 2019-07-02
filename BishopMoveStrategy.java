import javafx.scene.image.Image;

public class BishopMoveStrategy implements MoveStrategy {
    private ChessPiece chessPiece;

    public BishopMoveStrategy(ChessPiece chessPiece){
        this.chessPiece=chessPiece;
        if (chessPiece.getType().equals(ChessType.WhiteBishop)){
            chessPiece.setImage(new Image("/icon/whitebishop.png"));
        }else if (chessPiece.getType().equals(ChessType.BlackBishop)){
            chessPiece.setImage(new Image("/icon/blackbishop.png"));
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
        }else
            return false;
    }
}
