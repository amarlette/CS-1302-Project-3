import javafx.scene.image.Image;
import java.util.ArrayList;

/**
 * Created by alexa on 4/16/2017.
 */
public class deck {
    private ArrayList<cards> deck = new ArrayList<>();

    public deck(ArrayList<cards> deck) {
        this.deck = deck;
    }

    public ArrayList<cards> getDeck() {
        card card = new card();
        deck = card.deal();
        return deck;
    }

    public void setDeck(ArrayList<cards> deck) {
        this.deck = deck;
    }

    //Adds the card that was laid on the top of the deck
    public void addToDeck(int i, Image img){
        deck.add(img);
    }
}
