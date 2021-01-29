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

        Text title = new Text("Team Chat");
        title.setFont(Font.font("Berlin Sans FB", 20));

        Text text1 = new Text("Tschou zäme");
        Text text2 = new Text("Ciao");
        Text text3 = new Text("Sit er aui zwäg?");
        Text text4 = new Text("Ja, eh du?");

        HBox[] hBoxes = new HBox[4];

        for(int i = 0; i < hBoxes.length; i++) {
            hBoxes[i] = new HBox();
            hBoxes[i].setBackground(new Background(new BackgroundFill(Color.web("#d1e8ff"), new CornerRadii(10), Insets.EMPTY)));
            hBoxes[i].setPadding(new Insets(7));
        }

        hBoxes[0].getChildren().add(text1);
        hBoxes[1].getChildren().add(text2);
        hBoxes[2].getChildren().add(text3);
        hBoxes[3].getChildren().add(text4);

        hBoxes[0].setAlignment(Pos.CENTER_LEFT);
        hBoxes[1].setAlignment(Pos.CENTER_RIGHT);
        hBoxes[2].setAlignment(Pos.CENTER_LEFT);
        hBoxes[3].setAlignment(Pos.CENTER_RIGHT);

        TextField textField = new TextField();

        Button button = new Button("Save");

        VBox vBox1 = new VBox(7);
        vBox1.getChildren().addAll(hBoxes[0], hBoxes[1], hBoxes[2], hBoxes[3], textField, button);
        vBox1.setPadding(new Insets(7));

        HBox hBox = new HBox();
        hBox.getChildren().add(button);
        hBox.setAlignment(Pos.CENTER_RIGHT);
        hBox.setPadding(new Insets(7));

        VBox vBox2 = new VBox(7);
        vBox2.getChildren().addAll(textField, hBox);
        VBox.setMargin(textField, new Insets(7));

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(title);
        borderPane.setBottom(vBox2);
        borderPane.setCenter(vBox1);
        BorderPane.setMargin(title, new Insets(20));

        Scene scene1 = new Scene(borderPane);
        primaryStage.setTitle("Messenger");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

}
