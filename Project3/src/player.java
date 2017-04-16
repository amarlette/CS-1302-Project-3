import javafx.scene.image.Image;

import java.util.ArrayList;

/**
 * Created by alexa on 4/16/2017.
 */
public class player {
    private ArrayList<Image> pcards = new ArrayList<Image>();

    public player(ArrayList<Image> pcards) {
        this.pcards = pcards;
    }

    //Gives the player a new hand of cards
    public ArrayList<Image> getPcards() {
        card card = new card();
        pcards = card.deal();
        return pcards;
    }

    public void setPcards(ArrayList<Image> pcards) {
        this.pcards = pcards;
    }
}
