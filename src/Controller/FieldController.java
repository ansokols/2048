package Controller;

import Model.Logic;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class FieldController {

    @FXML
    private GridPane imagesPane;
    @FXML
    private GridPane labelsPane;

    @FXML
    private Button displayButton1;
    @FXML
    private Button displayButton2;
    @FXML
    private Button controlButton1;
    @FXML
    private Button controlButton2;

    @FXML
    private Button restartButton;
    @FXML
    private Button upButton;
    @FXML
    private Button downButton;
    @FXML
    private Button leftButton;
    @FXML
    private Button rightButton;

    @FXML
    private Label label00;
    @FXML
    private Label label01;
    @FXML
    private Label label02;
    @FXML
    private Label label03;
    @FXML
    private Label label10;
    @FXML
    private Label label11;
    @FXML
    private Label label12;
    @FXML
    private Label label13;
    @FXML
    private Label label20;
    @FXML
    private Label label21;
    @FXML
    private Label label22;
    @FXML
    private Label label23;
    @FXML
    private Label label30;
    @FXML
    private Label label31;
    @FXML
    private Label label32;
    @FXML
    private Label label33;

    @FXML
    private ImageView imageView00;
    @FXML
    private ImageView imageView01;
    @FXML
    private ImageView imageView02;
    @FXML
    private ImageView imageView03;
    @FXML
    private ImageView imageView10;
    @FXML
    private ImageView imageView11;
    @FXML
    private ImageView imageView12;
    @FXML
    private ImageView imageView13;
    @FXML
    private ImageView imageView20;
    @FXML
    private ImageView imageView21;
    @FXML
    private ImageView imageView22;
    @FXML
    private ImageView imageView23;
    @FXML
    private ImageView imageView30;
    @FXML
    private ImageView imageView31;
    @FXML
    private ImageView imageView32;
    @FXML
    private ImageView imageView33;

    @FXML
    private Label scoreLabel;
    @FXML
    private Label highScoreLabel;

    private static Logic logic;
    private int displayMode = 1;

    public static Logic getLogic() {
        return logic;
    }

    private void setScore() {
        scoreLabel.setText("SCORE - " + logic.getScore());
    }

    private void setHighScore() {
        highScoreLabel.setText("HIGHSCORE - " + logic.getHighScore());
    }

    private void setField() {
        switch (displayMode) {
            case 1: setImages();
            case 2: setLabels();
        }
    }

    private void setLabels() {
        label00.setText(logic.getMatrixNString(0, 0));
        label01.setText(logic.getMatrixNString(0, 1));
        label02.setText(logic.getMatrixNString(0, 2));
        label03.setText(logic.getMatrixNString(0, 3));
        label10.setText(logic.getMatrixNString(1, 0));
        label11.setText(logic.getMatrixNString(1, 1));
        label12.setText(logic.getMatrixNString(1, 2));
        label13.setText(logic.getMatrixNString(1, 3));
        label20.setText(logic.getMatrixNString(2, 0));
        label21.setText(logic.getMatrixNString(2, 1));
        label22.setText(logic.getMatrixNString(2, 2));
        label23.setText(logic.getMatrixNString(2, 3));
        label30.setText(logic.getMatrixNString(3, 0));
        label31.setText(logic.getMatrixNString(3, 1));
        label32.setText(logic.getMatrixNString(3, 2));
        label33.setText(logic.getMatrixNString(3, 3));
    }

    private void setImages() {
        imageView00.setImage(getImage(logic.getMatrixN(0, 0)));
        imageView01.setImage(getImage(logic.getMatrixN(0, 1)));
        imageView02.setImage(getImage(logic.getMatrixN(0, 2)));
        imageView03.setImage(getImage(logic.getMatrixN(0, 3)));
        imageView10.setImage(getImage(logic.getMatrixN(1, 0)));
        imageView11.setImage(getImage(logic.getMatrixN(1, 1)));
        imageView12.setImage(getImage(logic.getMatrixN(1, 2)));
        imageView13.setImage(getImage(logic.getMatrixN(1, 3)));
        imageView20.setImage(getImage(logic.getMatrixN(2, 0)));
        imageView21.setImage(getImage(logic.getMatrixN(2, 1)));
        imageView22.setImage(getImage(logic.getMatrixN(2, 2)));
        imageView23.setImage(getImage(logic.getMatrixN(2, 3)));
        imageView30.setImage(getImage(logic.getMatrixN(3, 0)));
        imageView31.setImage(getImage(logic.getMatrixN(3, 1)));
        imageView32.setImage(getImage(logic.getMatrixN(3, 2)));
        imageView33.setImage(getImage(logic.getMatrixN(3, 3)));
    }

    private Image getImage(int number) {
        String link = "";
        switch (number) {
            case 0 -> link = "Images" + File.separator + "0.png";
            case 2 -> link = "Images" + File.separator + "2.png";
            case 4 -> link = "Images" + File.separator + "4.png";
            case 8 -> link = "Images" + File.separator + "8.png";
            case 16 -> link = "Images" + File.separator + "16.png";
            case 32 -> link = "Images" + File.separator + "32.png";
            case 64 -> link = "Images" + File.separator + "64.png";
            case 128 -> link = "Images" + File.separator + "128.png";
            case 256 -> link = "Images" + File.separator + "256.png";
            case 512 -> link = "Images" + File.separator + "512.png";
            case 1024 -> link = "Images" + File.separator + "1024.png";
            case 2048 -> link = "Images" + File.separator + "2048.png";
            case 4096 -> link = "Images" + File.separator + "4096.png";
            case 8192 -> link = "Images" + File.separator + "8192.png";
            case 16384 -> link = "Images" + File.separator + "16384.png";
        }
        File file = new File(link);
        return new Image(file.toURI().toString());
    }

    private void gameOver() {
        upButton.setDisable(true);
        downButton.setDisable(true);
        leftButton.setDisable(true);
        rightButton.setDisable(true);

        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(MainApp.class.getResource("/View/Defeat.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("2048");
        stage.getIcons().add(new Image("file:Images" + File.separator + "2048.png"));
        stage.setScene(new Scene(root, 300, 264));
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    void initialize() {
        logic = new Logic();
        labelsPane.setVisible(false);
        imagesPane.setVisible(true);
        setImages();
        setHighScore();

        displayButton1.setOnAction(event -> {
            displayMode = 1;
            MainApp.resize(displayMode);

            displayButton2.setDisable(false);
            displayButton2.setDefaultButton(false);
            displayButton1.setDisable(true);
            displayButton1.setDefaultButton(true);

            labelsPane.setVisible(false);
            imagesPane.setVisible(true);

            setImages();
        });
        displayButton2.setOnAction(event -> {
            displayMode = 2;
            MainApp.resize(displayMode);

            displayButton1.setDisable(false);
            displayButton1.setDefaultButton(false);
            displayButton2.setDisable(true);
            displayButton2.setDefaultButton(true);

            imagesPane.setVisible(false);
            labelsPane.setVisible(true);

            setLabels();
        });
        controlButton1.setOnAction(event -> {
            controlButton2.setDisable(false);
            controlButton2.setDefaultButton(false);
            controlButton1.setDisable(true);
            controlButton1.setDefaultButton(true);
        });
        controlButton2.setOnAction(event -> {
            controlButton1.setDisable(false);
            controlButton1.setDefaultButton(false);
            controlButton2.setDisable(true);
            controlButton2.setDefaultButton(true);
        });

        restartButton.setOnAction(event -> {
            logic = new Logic();
            setField();
        });
        upButton.setOnAction(event -> {
            if (logic.up()) {
                setScore();
                setHighScore();
                setField();
            } else if (logic.checkFullness()) {
                gameOver();
            }
        });
        downButton.setOnAction(event -> {
            if (logic.down()) {
                setScore();
                setHighScore();
                setField();
            } else if (logic.checkFullness()) {
                gameOver();
            }
        });
        leftButton.setOnAction(event -> {
            if (logic.left()) {
                setScore();
                setHighScore();
                setField();
            } else if (logic.checkFullness()) {
                gameOver();
            }
        });
        rightButton.setOnAction(event -> {
            if (logic.right()) {
                setScore();
                setHighScore();
                setField();
            } else if (logic.checkFullness()) {
                gameOver();
            }
        });
    }
}
