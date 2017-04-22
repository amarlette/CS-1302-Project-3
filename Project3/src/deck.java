import java.util.ArrayList;

/**
 * Created by Alex, Sarah and Tessa on 4/16/2017.
 */
public class deck {
    //Create array for deck (middle pile where cards are placed to be played)
    private ArrayList<cards> deck = new ArrayList<>();

    //Constructor for deck
    public deck(ArrayList<cards> deck) {
        this.deck = deck;
    }

    //Gets the cards in the deck
    public ArrayList<cards> getDeck() { return deck;  }

    //Sets the deck with new cards
    public void setDeck(ArrayList<cards> deck) {
        this.deck = deck;
    }
}