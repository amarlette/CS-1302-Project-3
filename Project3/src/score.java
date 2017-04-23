import java.util.ArrayList;

/**
 * Created by Alex, Sarah and Tessa on 4/22/2017.
 */
public class score {
    //Creates variables for player and computer's scores
    private int pscore = 0;
    private int cscore = 0;

    public int getPscore() { return pscore; }

    public int getCscore() {
        return cscore;
    }

    //Method for adding up the scores for each player
    public score(ArrayList<cards> pwon, ArrayList<cards> cwon, int ppisti, int cpisti) {
        //who has the majority of cards
        if(pwon.size() > cwon.size()){
            pscore+=3;
        }
        else if(pwon.size() < cwon.size()){
            cscore+=3;
        }
        //adding number of normal pistis to score
        pscore += ppisti;
        cscore += cpisti;

        pwontotal(pwon);
        cwontotal(cwon);
    }

    //Method for adding special cards, 10s and face cards to the player's score
    public void pwontotal(ArrayList<cards> pwon){
        for (int i= 0; i < pwon.size(); i++){
            int rank = pwon.get(i).getRank();
            if(rank%13 == 1){
                pscore++;
            }
            if(rank%13 >= 10 && rank%13 <=13){
                pscore++;
            }
            if(rank == 2){
                pscore +=2;
            }
            if(rank == 49){
                pscore +=3;
            }
        }
    }

    //Method for adding special cards, 10s and face cards to the computer's score
    public void cwontotal(ArrayList<cards> cwon){
        for (int i= 0; i < cwon.size(); i++){
            int rank = cwon.get(i).getRank();
            if(rank%13 == 1){
                cscore++;
            }
            if(rank%13 >= 10 && rank%13 <=13){
                cscore++;
            }
            if(rank == 2){
                cscore +=2;
            }
            if(rank == 49){
                cscore +=3;
            }
        }
    }
}
