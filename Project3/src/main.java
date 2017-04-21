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
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        VBox vbox = new VBox(8);
        HBox hBox1 = new HBox(8);
        HBox hBox2 = new HBox(8);
        HBox hBox3 = new HBox(8);
        HBox hBox4 = new HBox(8);
        Button btP1 = new Button();
        Button btP2 = new Button();
        Button btP3 = new Button();
        Button btP4 = new Button();

        //New deck of cards, plus calls on the computer and player class
        card card = new card();
        Image back = new Image("img/back.png");
        computer comp = new computer(card.getcards());
        ArrayList<cards> comphand = comp.getCcards();
        System.out.print(comphand);
        player player = new player(card.getcards());
        ArrayList<cards> playerhand = player.getPcards();
        deck deck = new deck(card.getcards());
        ArrayList<cards> pile = deck.getDeck();
        hBox1.getChildren().addAll((new ImageView(back)), (new ImageView(back)), (new ImageView(back)), (new ImageView(back)));
        hBox2.getChildren().add(new ImageView(pile.get(3).getImg()));
        hBox4.getChildren().addAll(btP1, btP2, btP3, btP4);
        hBox2.setAlignment(Pos.CENTER);
        hBox1.setAlignment(Pos.CENTER);
        hBox3.setAlignment(Pos.CENTER);
        hBox4.setAlignment(Pos.CENTER);
        hBox3.getChildren().addAll((new ImageView(playerhand.get(0).getImg())), (new ImageView(playerhand.get(1).getImg())), (new ImageView(playerhand.get(2).getImg())), (new ImageView(playerhand.get(3).getImg())));
        vbox.getChildren().addAll(hBox1, hBox2, hBox3, hBox4);
        pane.getChildren().add(vbox);
        btP1.setMinWidth(74);
        btP2.setMinWidth(74);
        btP3.setMinWidth(74);
        btP4.setMinWidth(74);

//        btP1.setOnAction(e -> play());
  //      btP2.setOnAction(e -> play());
    //    btP3.setOnAction(e -> play());
      //  btP4.setOnAction(e -> play());




        //Game Play


        Scene scene = new Scene(pane);
        primaryStage.setTitle("Card Game"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}


