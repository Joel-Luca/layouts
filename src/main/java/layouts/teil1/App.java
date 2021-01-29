package layouts.teil1;

import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class App extends Application {

    @Override
    public void start(Stage primaryStage){

        TeamCommentar teamCommentar = new TeamCommentar();
        TeamChat teamChat = new TeamChat();

        primaryStage.setTitle("Messenger");
        primaryStage.setScene(teamCommentar.createScene());
        primaryStage.show();
    }

}
