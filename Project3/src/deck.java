import javafx.scene.image.Image;
import java.util.ArrayList;

/**
 * Created by alexa on 4/16/2017.
 */
public class deck {
    private ArrayList<Image> deck = new ArrayList<Image>();

    public deck(ArrayList<Image> deck) {
        this.deck = deck;
    }

    public ArrayList<Image> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Image> deck) {
        this.deck = deck;
    }

    //Adds the card that was laid on the top of the deck
    public void addToDeck(Image img){
        deck.add(img);
    }
}
