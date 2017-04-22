import javafx.scene.image.Image;

import java.util.ArrayList;

/**
 * Created by alexa on 4/16/2017.
 */
public class player {
    public ArrayList<cards> pcards = new ArrayList<>();
    public ArrayList<cards> pwon = new ArrayList<>(); //Storage for card won by the player

    public player(ArrayList<cards> pcards) {
        this.pcards = pcards;
    }

    //Gives the player a new hand of cards
    public ArrayList<cards> getPcards() {
        return pcards;
    }

    public void setPcards(ArrayList<cards> pcards) {
        this.pcards = pcards;
    }
}