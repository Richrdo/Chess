import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChessPiece {
    private int x;
    private int y;
    private boolean selected=false;
    private ChessType type;
    private Image image;
    private ImageView imageView=new ImageView();

    public Image getImage() {
        return image;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImage(Image image) {
        this.image = image;
        imageView.setImage(image);
    }

    public ChessPiece(int x,int y,ChessType chessType){
        setX(x);
        setY(y);
        setType(chessType);
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    private MoveStrategy moveStrategy;

    public ChessType getType() {
        return type;
    }

    public void setType(ChessType type) {
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public MoveStrategy getMoveStrategy() {
        return moveStrategy;
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public boolean isSelected() {
        return selected;
    }

    public void movePiece(int x,int y){
        if (isSelected()){
            setX(x);
            setY(y);
            System.out.println("移动到:"+x+" "+y);
        }
    }
}
