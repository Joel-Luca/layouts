package eventhandling;

import javafx.scene.control.*;

public class ClickCountLabel extends Label {
    private int numberOfClicks = 0;

    public ClickCountLabel() {
        setLabelText();
    }

    public void incrementNumberOfClicks() {
        numberOfClicks++;
        setLabelText();
    }

    private void setLabelText(){
        super.setText("Number of clicks: " + numberOfClicks);
    }

}


