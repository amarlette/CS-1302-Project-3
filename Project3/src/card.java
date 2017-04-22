import javafx.scene.image.Image;
import java.util.ArrayList;

/**
 * Created by Alex, Sarah and Tessa on 4/16/2017.
 */
public class card {
    //Create and fill array to hold all 52 cards
    private ArrayList<cards> cards = new ArrayList<>();
    public card() {
        for(int i = 1; i <= 52; i++){
            cards.add(new cards(i, new Image("img/cards/" + i + ".png")));
        }
    }

    //Get the full deck of cards
    public ArrayList<cards> getCards() {
        return cards;
    }

    //Deals 4 new cards to player and computer's hands
    public ArrayList<cards> deal(){
        ArrayList<cards> deal = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            int rnum = rnum();
            deal.add(cards.get(rnum));
            cards.remove(rnum);
        }
        return deal;
    }

    //Generates a random number to deal random cards
    public int rnum(){
        int rnum = (int)(Math.random()*(cards.size()-1));
        return rnum;
    }
}