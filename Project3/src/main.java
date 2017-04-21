import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by alexa on 4/16/2017.
 */
public class main extends Application{
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        HBox hBox1 = new HBox(8);
        HBox hBox2 = new HBox(8);
        HBox hBox3 = new HBox(8);
        //New deck of cards, plus calls on the computer and player class
        card card = new card();
        computer comp = new computer(card.getcards());
        ArrayList<Image> comphand = comp.getCcards();
        player player = new player(card.getcards());
        ArrayList<Image> playerhand = player.getPcards();
        hBox1.getChildren().addAll((new ImageView(comphand.get(0))), (new ImageView(comphand.get(1))), (new ImageView(comphand.get(2))), (new ImageView(comphand.get(3))));
        hBox3.getChildren().addAll((new ImageView(playerhand.get(0))), (new ImageView(playerhand.get(1))), (new ImageView(playerhand.get(2))), (new ImageView(playerhand.get(3))));
        pane.getChildren().addAll(hBox1, hBox2, hBox3);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Card Game"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}


