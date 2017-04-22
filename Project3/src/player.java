import java.util.ArrayList;

/**
 * Created by Alex, Sarah and Tessa on 4/16/2017.
 */
public class player {
    //Create arrays for cards in player's hand and won pile
    public ArrayList<cards> pcards = new ArrayList<>();
    public ArrayList<cards> pwon = new ArrayList<>();

    //Constructor for cards in player's hand
    public player(ArrayList<cards> pcards) {
        this.pcards = pcards;
    }

    //Gets the cards in the player's hand
    public ArrayList<cards> getPcards() { return pcards;  }

    //Sets new cards in the player's hand
    public void setPcards(ArrayList<cards> pcards) {
        this.pcards = pcards;
    }

    //Gets the cards in the player's won pile
    public ArrayList<cards> getPwon() {  return pwon;  }
}