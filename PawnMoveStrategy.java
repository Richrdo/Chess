import javafx.scene.image.Image;

public class PawnMoveStrategy implements MoveStrategy {
    private ChessPiece chessPiece;

    public PawnMoveStrategy(ChessPiece chessPiece){
        this.chessPiece=chessPiece;
        if (chessPiece.getType().equals(ChessType.WhitePawn)){
            chessPiece.setImage(new Image("/icon/whitepawn.png"));
        }else{
            chessPiece.setImage(new Image("/icon/blackpawn.png"));
        }
    }
    @Override
    public void move(int x, int y) {
        if(canmove(x,y)){
            chessPiece.setX(x);
            chessPiece.setY(y);
        }
    }

    public boolean canmove(int x,int y) {
        if (chessPiece.getType().equals(ChessType.BlackPawn)) {
            if ((chessPiece.getX() == x) && ((y - chessPiece.getY()) == 1)) {
                return true;
            } else if (chessPiece.getY() < 3 && y == 3)
                return true;
        } else if (chessPiece.getType().equals(ChessType.WhitePawn)) {
            if ((chessPiece.getX() == x) && ((chessPiece.getY() - y) == 1)) {
                return true;
            } else if (chessPiece.getY() == 6 && y == 4)
                return true;
        } else
            return false;
        return false;
    }
}