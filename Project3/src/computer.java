import javafx.scene.image.Image;

import java.util.ArrayList;

/**
 * Created by alexa on 4/16/2017.
 */
public class computer {
    private ArrayList<cards> ccards = new ArrayList<>();
    public ArrayList<cards> cwon = new ArrayList<>();

    public computer(ArrayList<cards> ccards) {
        this.ccards = ccards;
    }

    //Gives the computer a new hand of cards
    public ArrayList<cards> getCcards() {
        return ccards;
    }

    public void setCcards(ArrayList<cards> ccards) {
        this.ccards = ccards;
    }

}