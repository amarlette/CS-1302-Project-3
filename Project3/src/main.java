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
 * Created by alexa on 4/16/2017.
 */
public class main extends Application{
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

    private card card = new card();
    private cards blank =  new cards(53, new Image("img/blank.png"));
    ImageView ivB1 = new ImageView(new Image("img/blank.png"));
    ImageView ivB2 = new ImageView(new Image("img/blank.png"));
    ImageView ivB3 = new ImageView(new Image("img/blank.png"));
    ImageView ivB4 = new ImageView(new Image("img/blank.png"));
    ImageView ivB5 = new ImageView(new Image("img/blank.png"));
    ImageView ivB6 = new ImageView(new Image("img/blank.png"));
    ImageView ivB7 = new ImageView(new Image("img/blank.png"));
    ImageView ivB8 = new ImageView(new Image("img/blank.png"));

    private computer comp = new computer(card.deal());
    private player player = new player(card.deal());
    ArrayList<cards> playerhand = player.getPcards();
    ArrayList<cards> comphand = comp.getCcards();
    deck deck = new deck(card.deal());
    ArrayList<cards> pile = deck.getDeck();
    @Override
    public void start(Stage primaryStage) {
        //New deck of cards, plus calls on the computer and player class
        Image back = new Image("img/back.png");
        System.out.print(comphand);
        hBox1.getChildren().addAll((new ImageView(back)), (new ImageView(back)), (new ImageView(back)), (new ImageView(back)));
        hBox2.getChildren().addAll(new ImageView(pile.get(3).getImg()), btEnd);
        hBox4.getChildren().addAll(btP1, btP2, btP3, btP4);
        hBox3.getChildren().addAll((new ImageView(playerhand.get(0).getImg())), (new ImageView(playerhand.get(1).getImg())), (new ImageView(playerhand.get(2).getImg())), (new ImageView(playerhand.get(3).getImg())));
        hBox2.setAlignment(Pos.CENTER);
        hBox1.setAlignment(Pos.CENTER);
        hBox3.setAlignment(Pos.CENTER);
        hBox4.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(hBox1, hBox2, hBox3, hBox4);
        pane.getChildren().add(vbox);
        btP1.setMinWidth(74);
        btP2.setMinWidth(74);
        btP3.setMinWidth(74);
        btP4.setMinWidth(74);

        btP1.setOnAction(e -> {play1();});
        btP2.setOnAction(e -> {play2();});
        btP3.setOnAction(e -> {play3();});
        btP4.setOnAction(e -> {play4();});
        btEnd.setOnAction(e -> {compplay();});

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Card Game"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show();
    }
    private int turn = 0;
    public void play1() {
        pile.add(playerhand.get(0));
        hBox2.getChildren().set(0, new ImageView(playerhand.get(0).getImg()));
        hBox4.getChildren().remove(btP1);
        hBox3.getChildren().set(0, ivB1);
        System.out.print(playerhand.size());
        turn++;
        if (turn == 8) {
            playerhand = card.deal();
            comphand = card.deal();
            turn = 0;
        }
    }

    public void play2() {
        pile.add(playerhand.get(1));
        hBox2.getChildren().set(0, new ImageView(playerhand.get(1).getImg()));
        hBox4.getChildren().remove(btP2);
        hBox3.getChildren().set(1, ivB2);
        System.out.print(playerhand.size());
        turn++;
        if (turn == 8) {
            playerhand = card.deal();
            comphand = card.deal();
            turn = 0;
        }
    }

    public void play3() {
        pile.add(playerhand.get(2));
        hBox2.getChildren().set(0, new ImageView(playerhand.get(2).getImg()));
        hBox4.getChildren().remove(btP3);
        hBox3.getChildren().set(2, ivB3);
        System.out.print(playerhand.size());
        turn++;
        if (turn == 8) {
            playerhand = card.deal();
            comphand = card.deal();
            turn = 0;
        }
    }

    public void play4() {
        pile.add(playerhand.get(3));
        hBox2.getChildren().set(0, new ImageView(playerhand.get(3).getImg()));
        hBox4.getChildren().remove(btP4);
        hBox3.getChildren().set(3, ivB4);
        System.out.print(playerhand.size());
        turn++;
        if (turn == 8) {
            playerhand = card.deal();
            comphand = card.deal();
            turn = 0;
        }
    }
    private int rnum;
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
        rnum++;
        turn++;
        if (turn == 8) {
            playerhand = card.deal();
            comphand = card.deal();
            visdeal();
            turn = 0;
            rnum = 0;
        }


    }
    public void visdeal(){
        for(int i = 0; i < 4; i++) {
            hBox1.getChildren().set(i, new ImageView(comphand.get(i).getImg()));
            hBox3.getChildren().set(i, new ImageView(playerhand.get(i).getImg()));
        }
        hBox4.getChildren().addAll(btP1, btP2, btP3, btP4);
        System.out.print(card.getCards().size());
    }

    public static void main(String[] args) {
        launch(args);
    }

}