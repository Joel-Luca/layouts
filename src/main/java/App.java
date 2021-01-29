import eventhandling.ClickCounter;
import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;
import layouts.teil1.*;

public class App extends Application {

    @Override
    public void start(Stage primaryStage){

        TeamCommentar teamCommentar = new TeamCommentar();
        TeamChat teamChat = new TeamChat();
        ClickCounter clickCounter = new ClickCounter();

        primaryStage.setTitle("Messenger");
        primaryStage.setScene(clickCounter.createScene());
        primaryStage.show();
    }

}
