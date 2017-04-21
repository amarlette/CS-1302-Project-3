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
        getcards();
    }


    //Get the full deck array1
    public ArrayList<cards> getcards() {
        for(int i = 1; i <= 52; i++){
            cards.add(new cards(i, new Image("img/cards/" + i + ".png")));
        }
        return cards;
    }


    //Takes in the player's or computer's hand and deals 4 new cards to each.
    public ArrayList<cards> deal(){
        ArrayList<cards> deal = new ArrayList<cards>();
        for(int i = 0; i < 4; i++){
            int rnum = rnum();
            cards.remove(rnum);
            deal.add(new cards(i, new Image("img/cards/" + rnum + ".png")));
        }
        return deal;
    }

    //Generates a Random Number
    public int rnum(){
        int rnum = (int)(Math.random()*(cards.size()-1));
        return rnum;
    }
}
