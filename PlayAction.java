
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.util.*;
import java.util.List;

public class PlayAction extends  Pane {
    ChessBoard chessBoard;
    List<ChessPiece> chessPieces;
    ChessPiece []chessPiece;
    Map<Integer,ChessPiece> chessPieceMap=new HashMap<>();
    ImageView imageView=new ImageView();
    Scene scene;
    Alert alert;

    private ChessPiece curchessPiece;
    private  int cellLength=90;

    public PlayAction(ChessBoard chessBoard){
        this.chessBoard=chessBoard;
        scene=new Scene(chessBoard.pane);
        chessBoard.startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                chessPiece=new ChessPiece[32];
                chessPieces=new ArrayList<ChessPiece>();
                initChess(chessPiece);
                chessPieces.addAll(Arrays.asList(chessPiece));
                initChessPieceMap();
                addToBoard();
//                startMove();
            }

        });
        chessBoard.pane.setOnMouseClicked(e->{
            double xx=e.getX();
            double yy=e.getY();
            e.getPickResult();
            int x=(int)(e.getX()-50)/cellLength;
            int y=(int)(e.getY()-50)/cellLength;
            if (curchessPiece==null){
                curchessPiece=findChess(x,y);
            }else if (findChess(x,y)==null&&!isHaveChess(x,y,curchessPiece.getX(),curchessPiece.getY())){
                curchessPiece.setSelected(true);
                curchessPiece.getMoveStrategy().move(x,y);
                reDrawPane(curchessPiece);
                curchessPiece=null;
            }else{
                alert=new Alert(Alert.AlertType.WARNING,"该位置已有棋子");
                alert.showAndWait();
            }
        });
    }

    public void initChessPieceMap(){
        for (int i=0;i<32;i++){
            chessPieceMap.put(i,chessPiece[i]);
        }
    }

    public boolean isHaveChess(int x,int y,int m,int n){
        if (x==m){
            if (n>y)
            for (int i=y+1;i<n;i++){
                if (findChess(x,i)!=null)
                    return true;
            }else
                for (int i=n+1;i<y;i++){
                    if (findChess(x,i)!=null)
                        return true;
                }
        }else if (y==n){
            if (x>m)
                for (int i=m+1;i<x;i++){
                    if (findChess(i,y)!=null)
                        return true;
                }else
                for (int i=n+1;i<y;i++){
                    if (findChess(i,y)!=null)
                        return true;
                }
        }
        return false;
    }


    public ChessPiece findChess(int x,int y){
        ChessPiece chess;
        for (int i=0;i<32;i++){
            chess=chessPieceMap.get(i);
            if (chess.getX()==x&&chess.getY()==y)
                return chess;
        }
        return null;
    }

    public void initChess(ChessPiece []chessPiece){
        chessPiece[0]=new ChessPiece(0,0,ChessType.BlackRook);
        chessPiece[0].setMoveStrategy(new RookMoveStrategy(chessPiece[0]));
        chessPiece[1]=new ChessPiece(1,0,ChessType.BlackKnight);
        chessPiece[1].setMoveStrategy(new KnightMoveStrategy(chessPiece[1]));
        chessPiece[2]=new ChessPiece(2,0,ChessType.BlackBishop);
        chessPiece[2].setMoveStrategy(new BishopMoveStrategy(chessPiece[2]));
        chessPiece[3]=new ChessPiece(3,0,ChessType.BlackKing);
        chessPiece[3].setMoveStrategy(new KingMoveStrategy(chessPiece[3]));
        chessPiece[4]=new ChessPiece(4,0,ChessType.BlackQueen);
        chessPiece[4].setMoveStrategy(new QueenMoveStrategy(chessPiece[4]));
        chessPiece[5]=new ChessPiece(5,0,ChessType.BlackBishop);
        chessPiece[5].setMoveStrategy(new BishopMoveStrategy(chessPiece[5]));
        chessPiece[6]=new ChessPiece(6,0,ChessType.BlackKnight);
        chessPiece[6].setMoveStrategy(new KnightMoveStrategy(chessPiece[6]));
        chessPiece[7]=new ChessPiece(7,0,ChessType.BlackRook);
        chessPiece[7].setMoveStrategy(new RookMoveStrategy(chessPiece[7]));
        int i=8;
        for (int j=0;j<8;j++,i++){
            chessPiece[i]=new ChessPiece(j,1,ChessType.BlackPawn);
            chessPiece[i].setMoveStrategy(new PawnMoveStrategy(chessPiece[i]));
        }
        chessPiece[16]=new ChessPiece(0,7,ChessType.WhiteRook);
        chessPiece[16].setMoveStrategy(new RookMoveStrategy(chessPiece[16]));
        chessPiece[17]=new ChessPiece(1,7,ChessType.WhiteKnight);
        chessPiece[17].setMoveStrategy(new KnightMoveStrategy(chessPiece[17]));
        chessPiece[18]=new ChessPiece(2,7,ChessType.WhiteBishop);
        chessPiece[18].setMoveStrategy(new BishopMoveStrategy(chessPiece[18]));
        chessPiece[19]=new ChessPiece(3,7,ChessType.WhiteKing);
        chessPiece[19].setMoveStrategy(new KingMoveStrategy(chessPiece[19]));
        chessPiece[20]=new ChessPiece(4,7,ChessType.WhiteQueen);
        chessPiece[20].setMoveStrategy(new QueenMoveStrategy(chessPiece[20]));
        chessPiece[21]=new ChessPiece(5,7,ChessType.WhiteBishop);
        chessPiece[21].setMoveStrategy(new BishopMoveStrategy(chessPiece[21]));
        chessPiece[22]=new ChessPiece(6,7,ChessType.WhiteKnight);
        chessPiece[22].setMoveStrategy(new KnightMoveStrategy(chessPiece[22]));
        chessPiece[23]=new ChessPiece(7,7,ChessType.WhiteRook);
        chessPiece[23].setMoveStrategy(new RookMoveStrategy(chessPiece[23]));
        i=24;
        for (int j=0;j<8;j++,i++){
            chessPiece[i]=new ChessPiece(j,6,ChessType.WhitePawn);
            chessPiece[i].setMoveStrategy(new PawnMoveStrategy(chessPiece[i]));
        }
    }

    public void addToBoard(){
        chessPieces.forEach(e->{
            e.getImageView().setLayoutX(chessBoard.getPaneX(e));
            e.getImageView().setLayoutY(chessBoard.getPanY(e));
            e.getImageView().setFitWidth(90);
            e.getImageView().setFitHeight(90);
            chessBoard.pane.getChildren().add(e.getImageView());
        });
    }
    public  void reDrawPane(ChessPiece chess){
        chess.getImageView().setLayoutX(chessBoard.getPaneX(chess));
        chess.getImageView().setLayoutX(chessBoard.getPaneX(chess));
        chess.getImageView().setLayoutY(chessBoard.getPanY(chess));
        chess.setSelected(false);
    }

}
