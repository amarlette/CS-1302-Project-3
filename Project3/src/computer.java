import javafx.scene.image.Image;

import java.util.ArrayList;

/**
 * Created by alexa on 4/16/2017.
 */
public class computer {
    private ArrayList<Image> ccards = new ArrayList<>();
    public ArrayList<Image> cwon = new ArrayList<>();

    public computer(ArrayList<Image> ccards) {
        this.ccards = ccards;
    }


    //Gives the computer a new hand of cards
    public ArrayList<Image> getCcards() {
        card card = new card();
        ccards = card.deal();
        return ccards;
    }

    public void setCcards(ArrayList<Image> ccards) {
        this.ccards = ccards;
    }

}
