
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class ChessBoard extends Pane {
    private double x=0;
    private double y=0;
    private double height=90;
    private double weight=90;

    Button startButton=new Button("开始");
    Canvas canvas=new Canvas(weight*8+200,height*8+150);
    Pane pane=new Pane();
    GraphicsContext gc=canvas.getGraphicsContext2D();

    public ChessBoard(){
        this.setHeight(canvas.getHeight());
        this.setWidth(canvas.getWidth());
        init();
        pane.getChildren().addAll(canvas,startButton);
    }

    private void init() {
        for(int i=0;i<8;i++){
            x=i*weight;
            for (int j=0;j<8;j++){
                y=j*height;
                gc.strokeRect(x+50,y+50,weight,height);
                if (((i+j)%2)==1){
                    gc.setFill(Color.GRAY);
                    gc.fillRect(x+50,y+50,weight,height);
                }
            }
        }
        startButton.setLayoutX(8*weight+100);
        startButton.setLayoutY(100);
//        startButton.setStyle("-fx-background-color: #b0e0e6;");
    }

    public int getPaneX(ChessPiece chessPiece){
        return (int)(chessPiece.getX()*weight+50);
    }

    public int getPanY(ChessPiece chessPiece){
        return (int)(chessPiece.getY()*height+50);
    }

}
