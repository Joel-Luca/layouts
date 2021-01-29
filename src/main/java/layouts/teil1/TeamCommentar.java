package layouts.teil1;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.List;

public class TeamCommentar {
    public Scene createScene() {

        List<Team> teams = TeamDao.getTeams();

        TreeItem<String> treeRoot = new TreeItem<>("Teams");
        TreeView<String> treeView = new TreeView<>(treeRoot);
        treeView.setShowRoot(false);

        for(Team team : teams) {
            TreeItem<String> teamItem = new TreeItem<>(team.getName());
            treeRoot.getChildren().add(teamItem);

            List<Person> people = team.getMembers();
            for(Person person : people) {
                TreeItem<String> personItem = new TreeItem<>(person.getFullName());
                teamItem.getChildren().add(personItem);
            }
        }

        Button button = new Button("Save");

        HBox hBoxbutton = new HBox();
        hBoxbutton.getChildren().add(button);
        hBoxbutton.setAlignment(Pos.CENTER_RIGHT);

        Text title = new Text("Vorname Nachname");
        title.setFont(Font.font("Berlin Sans FB", 20));

        TextArea textArea = new TextArea();

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(title, textArea, hBoxbutton);

        VBox.setVgrow(textArea, Priority.ALWAYS);

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(treeView, vBox);
        hBox.setPadding(new Insets( 20, 10, 10, 0));

        Scene scene = new Scene(hBox);

        return scene;
    }
}
