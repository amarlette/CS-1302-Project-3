import javafx.scene.image.Image;

/**
 * Created by Alex, Sarah and Tessa on 4/21/2017.
 */
public class cards {
    private int rank;
    private Image img;

    public cards(int rank, Image img) {
        this.rank = rank;
        this.img = img;
    }

    public int getRank() {
        return rank;
    }

    public Image getImg() {
        return img;
    }
}