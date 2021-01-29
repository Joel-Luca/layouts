package eventhandling;

import javafx.event.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.*;

public class MouseClickHandler implements EventHandler<MouseEvent> {
    private Text text;
    private ClickCountLabel clickCountLabel;

    public MouseClickHandler(ClickCountLabel clickCountLabel) {
        this.clickCountLabel = clickCountLabel;
    }

    @Override
    public void handle(MouseEvent event) {
        clickCountLabel.incrementNumberOfClicks();
    }
}
