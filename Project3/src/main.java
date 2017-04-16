import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
        player player = new player(card.getcards());
        hBox1.getChildren().addAll((new ImageView(comp.getCcards().get(0))), (new ImageView(comp.getCcards().get(1))), (new ImageView(comp.getCcards().get(2))), (new ImageView(comp.getCcards().get(3))));
        hBox3.getChildren().addAll((new ImageView(player.getPcards().get(0))), (new ImageView(player.getPcards().get(1))), (new ImageView(player.getPcards().get(2))), (new ImageView(player.getPcards().get(3))));
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


