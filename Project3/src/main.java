import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by Alex, Sarah and Tessa on 4/16/2017.
 */
public class main extends Application{
    //Creates GridPane, VBox, HBoxes and Buttons
    GridPane pane = new GridPane();
    VBox vbox = new VBox(8);
    HBox hBox1 = new HBox(8);
    HBox hBox2 = new HBox(8);
    HBox hBox3 = new HBox(8);
    HBox hBox4 = new HBox(8);
    Button btP1 = new Button("Card 1");
    Button btP2 = new Button("Card 2");
    Button btP3 = new Button("Card 3");
    Button btP4 = new Button("Card 4");
    Button btEnd = new Button("End Turn");

    //Creates a new deck of 52 cards
    private card card = new card();

    //Creates a blank image used to replace played cards
    private cards blank =  new cards(53, new Image("img/blank.png"));
    ImageView ivB1 = new ImageView(new Image("img/blank.png"));
    ImageView ivB2 = new ImageView(new Image("img/blank.png"));
    ImageView ivB3 = new ImageView(new Image("img/blank.png"));
    ImageView ivB4 = new ImageView(new Image("img/blank.png"));
    ImageView ivB5 = new ImageView(new Image("img/blank.png"));
    ImageView ivB6 = new ImageView(new Image("img/blank.png"));
    ImageView ivB7 = new ImageView(new Image("img/blank.png"));
    ImageView ivB8 = new ImageView(new Image("img/blank.png"));
    ImageView ivB9 = new ImageView(new Image("img/blank.png"));

    //Creates and image for the back of the cards
    private Image back = new Image("img/back.png");


    //Deals cards to computer, player and deck (where cards will be played)
    private computer comp = new computer(card.deal());
    private player player = new player(card.deal());
    deck deck = new deck(card.deal());

    //Creates variables for referencing the cards in the deck, player and computer's hands
    private ArrayList<cards> playerhand = player.getPcards();
    private ArrayList<cards> comphand = comp.getCcards();
    private ArrayList<cards> pile = deck.getDeck();

    private int cpisti = 0;
    private int ppisti = 0;

    @Override
    public void start(Stage primaryStage) {
        //Checks to see if first card on the pile is Jack
        if (pile.get(3).getRank()%13 == 11){
            for(int i=0; i < 4; i++){
                card.getCards().add(pile.get(i));
                card.getCards().add(comphand.get(i));
                card.getCards().add(playerhand.get(i));
            }
            pile.removeAll(pile);
            playerhand.removeAll(playerhand);
            comphand.removeAll(comphand);
            pile = card.deal();
            comphand = card.deal();
            playerhand = card.deal();


        }
        //Prints out the cards in the computer's hand
        System.out.print(comphand);

        //Places all cards (player and computer's hands and deck) and buttons in HBoxes
        hBox1.getChildren().addAll((new ImageView(back)), (new ImageView(back)), (new ImageView(back)), (new ImageView(back)));
        hBox2.getChildren().addAll(new ImageView(pile.get(3).getImg()), btEnd);
        hBox4.getChildren().addAll(btP1, btP2, btP3, btP4);
        hBox3.getChildren().addAll((new ImageView(playerhand.get(0).getImg())), (new ImageView(playerhand.get(1).getImg())), (new ImageView(playerhand.get(2).getImg())), (new ImageView(playerhand.get(3).getImg())));
        //Sets alignment for HBoxes
        hBox2.setAlignment(Pos.CENTER);
        hBox1.setAlignment(Pos.CENTER);
        hBox3.setAlignment(Pos.CENTER);
        hBox4.setAlignment(Pos.CENTER);
        //Adds HBoxes to VBox and then places VBox's contents on the screen
        vbox.getChildren().addAll(hBox1, hBox2, hBox3, hBox4);
        pane.getChildren().add(vbox);
        //Set widths of the buttons
        btP1.setMinWidth(74);
        btP2.setMinWidth(74);
        btP3.setMinWidth(74);
        btP4.setMinWidth(74);

        //Event handlers for buttons
        btP1.setOnAction(e -> {play1();});
        btP2.setOnAction(e -> {play2();});
        btP3.setOnAction(e -> {play3();});
        btP4.setOnAction(e -> {play4();});
        btEnd.setOnAction(e -> {compplay();});

        //Creates a scene for the pane
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Card Game"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show();
    }

    //Creates a variable to keep track of turns
    int turn = 0;
    //Method for if the player chooses the first card to be played
    public void play1() {
        pile.add(playerhand.get(0));
        hBox2.getChildren().set(0, new ImageView(playerhand.get(0).getImg()));
        hBox4.getChildren().remove(btP1);
        hBox3.getChildren().set(0, ivB1);
        pisti(pile);
        turn++;
        if (turn%8 == 0 && turn < 48) {
            playerhand = card.deal();
            comphand = card.deal();
        }
        else if(turn == 48){
            score score = new score(player.pwon, comp.cwon, ppisti, cpisti);
            hBox2.getChildren().remove(1);
            hBox2.getChildren().remove(0);        }
    }

    //Method for if the player chooses the second card to be played
    public void play2() {
        pile.add(playerhand.get(1));
        hBox2.getChildren().set(0, new ImageView(playerhand.get(1).getImg()));
        hBox4.getChildren().remove(btP2);
        hBox3.getChildren().set(1, ivB2);
        pisti(pile);
        turn++;
        if (turn%8 == 0 && turn < 48) {
            playerhand = card.deal();
            comphand = card.deal();
        }
        else if(turn == 48){
            score score = new score(player.pwon, comp.cwon, ppisti, cpisti);
            hBox2.getChildren().remove(1);
            hBox2.getChildren().remove(0);        }
    }

    //Method for if the player chooses the third card to be played
    public void play3() {
        pile.add(playerhand.get(2));
        hBox2.getChildren().set(0, new ImageView(playerhand.get(2).getImg()));
        hBox4.getChildren().remove(btP3);
        hBox3.getChildren().set(2, ivB3);
        pisti(pile);
        turn++;
        if (turn%8 == 0 && turn < 48) {
            playerhand = card.deal();
            comphand = card.deal();
        }
        else if(turn == 48){
            score score = new score(player.pwon, comp.cwon, ppisti, cpisti);
            hBox2.getChildren().remove(1);
            hBox2.getChildren().remove(0);
        }
    }

    //Method for if the player chooses the fourth card to be played
    public void play4() {
        pile.add(playerhand.get(3));
        hBox2.getChildren().set(0, new ImageView(playerhand.get(3).getImg()));
        hBox4.getChildren().remove(btP4);
        hBox3.getChildren().set(3, ivB4);
        pisti(pile);
        turn++;
        if (turn%8 == 0 && turn < 48) {
            playerhand = card.deal();
            comphand = card.deal();
        }
        else if(turn == 48){
            score score = new score(player.pwon, comp.cwon, ppisti, cpisti);
            hBox2.getChildren().remove(1);
            hBox2.getChildren().remove(0);
        }
    }

    private int rnum;
    //Method for computer to play a random card
    public void compplay() {
        pile.add(comphand.get(rnum));
        hBox2.getChildren().set(0, new ImageView(comphand.get(rnum).getImg()));
        switch (rnum){
            case 0: {
                hBox1.getChildren().set(rnum, ivB5);
                break;
            }
            case 1: {
                hBox1.getChildren().set(rnum, ivB6);
                break;
            }
            case 2: {
                hBox1.getChildren().set(rnum, ivB7);
                break;
            }
            case 3: {
                hBox1.getChildren().set(rnum, ivB8);
                break;
            }
        }
        pisti(pile);
        rnum++;
        turn++;

        //Deals four more cards to each player if that round is finished
        if (turn%8 == 0 && turn < 48) {
            playerhand = card.deal();
            comphand = card.deal();
            visdeal();
            rnum = 0;
        }
        else if(turn == 48){
            score score = new score(player.pwon, comp.cwon, ppisti, cpisti);
            hBox2.getChildren().remove(1);
            hBox2.getChildren().remove(0);        }
    }

    //Visually places the newly dealt cards on the screen
    public void visdeal(){
        for(int i = 0; i < 4; i++) {
            hBox1.getChildren().set(i, new ImageView(back));
            hBox3.getChildren().set(i, new ImageView(playerhand.get(i).getImg()));
        }
        hBox4.getChildren().addAll(btP1, btP2, btP3, btP4);
        System.out.print(card.getCards().size());
    }

    int lastCapture = 0;
    public void pisti(ArrayList<cards> pile){
        if(pile.size() > 1 && turn >= 2) {
            if(pile.get(pile.size() - 1).getRank() % 13 == 11){
                if(pile.get(pile.size() - 2).getRank() % 13 == 11){
                    if (turn % 2 != 0) {
                        cpisti += 20;
                        lastCapture = 0;
                    }
                    else if(turn % 2 == 0) {
                        ppisti += 20;
                        lastCapture = 1;
                    }
                }
                if (turn % 2 != 0) {
                    for (int i = 0; i < pile.size(); i++) {
                        comp.getCwon().add(pile.get(i));
                    }
                    pile.removeAll(pile);
                    lastCapture = 0;
                    System.out.println("Cards added to C Pile" + comp.getCwon().size());
                } else if (turn % 2 == 0) {
                    for (int i = 0; i < pile.size(); i++) {
                        player.getPwon().add(pile.get(i));
                    }
                    pile.removeAll(pile);
                    lastCapture = 1;
                    System.out.println("Cards added to P Pile" + player.getPwon().size());
                }
                hBox2.getChildren().set(0, ivB9);
            }
            else if (pile.get(pile.size() - 1).getRank() % 13 == pile.get(pile.size() - 2).getRank() % 13) {
                if (turn % 2 != 0) {
                    for (int i = 0; i < pile.size(); i++) {
                        comp.getCwon().add(pile.get(i));
                    }
                    pile.removeAll(pile);
                    cpisti += 10;
                    lastCapture = 0;
                    System.out.println("Cards added to C Pile" + comp.getCwon().size());

                } else if (turn % 2 == 0) {
                    for (int i = 0; i < pile.size(); i++) {
                        player.getPwon().add(pile.get(i));
                    }
                    pile.removeAll(pile);
                    ppisti += 10;
                    lastCapture = 1;
                    System.out.println("Cards added to P Pile" + player.getPwon().size());

                }
                hBox2.getChildren().set(0, ivB9);

            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}