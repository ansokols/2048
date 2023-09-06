package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DefeatController {
    @FXML
    private Label scoreLabel;

    @FXML
    void initialize() {
        scoreLabel.setText("YOUR SCORE - " + FieldController.getLogic().getScore());
    }
}
