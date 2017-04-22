import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 * Created by alexa on 4/16/2017.
 */
public class card {
    private ArrayList<cards> cards = new ArrayList<>();

    public card() {
        for(int i = 1; i <= 52; i++){
            cards.add(new cards(i, new Image("img/cards/" + i + ".png")));
        }
    }


    //Get the full deck array
    public ArrayList<cards> getCards() {
        return cards;
    }

    //Takes in the player's or computer's hand and deals 4 new cards to each.
    public ArrayList<cards> deal(){
        ArrayList<cards> deal = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            int rnum = rnum();
            deal.add(cards.get(rnum));
            cards.remove(rnum);
        }
        return deal;
    }

    //Generates a Random Number
    public int rnum(){
        int rnum = (int)(Math.random()*(cards.size()-1));
        return rnum;
    }
}