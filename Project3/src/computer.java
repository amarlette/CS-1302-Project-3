import java.util.ArrayList;

/**
 * Created by Alex, Sarah and Tessa on 4/16/2017.
 */
public class computer {
    //Create arrays for cards in computer's hand and won pile
    private ArrayList<cards> ccards = new ArrayList<>();
    public ArrayList<cards> cwon = new ArrayList<>();

    //Constructor for cards in computer's hand
    public computer(ArrayList<cards> ccards) {
        this.ccards = ccards;
    }

    //Gets the cards in the computer's hand
    public ArrayList<cards> getCcards() {  return ccards;  }

    //Gets the cards in the computer's won pile
    public ArrayList<cards> getCwon() {  return cwon;  }
}