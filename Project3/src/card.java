import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 * Created by alexa on 4/16/2017.
 */
public class card {
    private ArrayList<Image> cards = new ArrayList<>();

    public card() {
        getcards();
    }

    //Get the full deck array
    public ArrayList<Image> getcards() {
        for(int i = 1; i < 52; i++){
            cards.add(new Image("img/cards/" + i + ".png"));
        }
        return cards;
    }

    public void setCards(ArrayList<Image> cards) {
        this.cards = cards;
    }

    //Takes in the player's or computer's hand and deals 4 new cards to each.
    public ArrayList<Image> deal(){
        ArrayList<Image> deal = new ArrayList<Image>();
        for(int i = 0; i < 4; i++){
            int rnum = rnum();
            cards.remove(rnum);
            deal.add(new Image("img/cards/" + rnum + ".png"));
        }
        return deal;
    }

    //Generates a Random Number
    public int rnum(){
        int rnum = (int)(Math.random()*52);
        return rnum;
    }
}
