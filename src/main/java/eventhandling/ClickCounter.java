package eventhandling;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class ClickCounter implements EventHandler<MouseEvent> {

    ClickCountLabel clickCountLabel = new ClickCountLabel();

    public Scene createScene() {
        VBox vbox = new VBox(10);

        Button buttonWithOtherClass = new Button("click me with other class");
        Button buttonWithThis = new Button("click me with this");
        Button buttonWithAnonymInnerClass = new Button("click me with anonymous inner class");
        Button buttonWithLambda = new Button("click me with lambda");

        vbox.getChildren().add(buttonWithOtherClass);
        vbox.getChildren().add(buttonWithThis);
        vbox.getChildren().add(buttonWithAnonymInnerClass);
        vbox.getChildren().add(buttonWithLambda);
        vbox.getChildren().add(clickCountLabel);

        buttonWithOtherClass.setOnMouseClicked(new MouseClickHandler(clickCountLabel));
        buttonWithThis.setOnMouseClicked(this);

        buttonWithAnonymInnerClass.setOnMouseClicked(new EventHandler<MouseEvent>() {
           @Override
           public void handle(MouseEvent event) {
               clickCountLabel.incrementNumberOfClicks();
           }
        });
        buttonWithLambda.setOnMouseClicked(actionEvent -> clickCountLabel.incrementNumberOfClicks());


        Scene scene = new Scene(vbox);
        return scene;
    }

    @Override
    public void handle(MouseEvent event) {
        clickCountLabel.incrementNumberOfClicks();
    }

}
