import java.util.ArrayList;

/**
 * Created by alexa on 4/22/2017.
 */
public class score {
    private int pscore = 0;
    private int cscore = 0;

    public score(ArrayList<cards> pwon, ArrayList<cards> cwon, int ppishti, int cpishti) {
        if(pwon.size() > cwon.size()){
            pscore+=3;
        }
        else if(pwon.size() < cwon.size()){
            cscore+=3;
        }
        pscore += ppishti;
        cscore += cpishti;
        pwontotal(pwon);
        cwontotal(cwon);
        System.out.println("pscore = " + pscore);
        System.out.println("cscore = " + cscore);

    }

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
