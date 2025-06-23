package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.input.KeyCode;

public class MainFx extends Application
{
    private Stage primaryStage;
    private boolean[] levelsUnlocked = {true, false, false};
    private boolean isFireJumping = false, isWaterJumping = false;
    private double fireVelocityY = 0, waterVelocityY = 0;
    private final double GRAVITY = 0.5;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        this.primaryStage = stage;
        showMainMenu();
    }

    private void showMainMenu()
    {
        Pane menuPane = new Pane();

        Text logo = new Text("Fire and Water");
        logo.setFont(Font.font("Arial", 40));
        logo.setFill(Color.BLUEVIOLET);
        logo.setX(100);
        logo.setY(100);

        Button levelSelect = new Button("Select Level");
        Button tutorial = new Button("Tutorial");
        Button exit = new Button("Exit");

        levelSelect.setLayoutX(150);
        levelSelect.setLayoutY(200);
        tutorial.setLayoutX(150);
        tutorial.setLayoutY(250);
        exit.setLayoutX(150);
        exit.setLayoutY(300);

        menuPane.getChildren().addAll(logo, levelSelect, tutorial, exit);

        levelSelect.setOnAction(e -> showLevelSelect());
        tutorial.setOnAction(e -> showTutorial());
        exit.setOnAction(e -> primaryStage.close());

        Scene menuScene = new Scene(menuPane, 400, 400);
        primaryStage.setScene(menuScene);
        primaryStage.setTitle("Main Menu");
        primaryStage.show();
    }

    private void showLevelSelect()
    {
        Pane levelPane = new Pane();

        Text title = new Text("Select Level");
        title.setFont(Font.font("Arial", 30));
        title.setX(100);
        title.setY(50);

        Button level1 = new Button("Level 1");
        Button level2 = new Button("Level 2");
        Button level3 = new Button("Level 3");

        level1.setLayoutX(150);
        level1.setLayoutY(100);
        level2.setLayoutX(150);
        level2.setLayoutY(150);
        level3.setLayoutX(150);
        level3.setLayoutY(200);

        level1.setDisable(!levelsUnlocked[0]);
        level2.setDisable(!levelsUnlocked[1]);
        level3.setDisable(!levelsUnlocked[2]);

        level1.setOnAction(e -> startLevel(1));
        level2.setOnAction(e -> startLevel(2));
        level3.setOnAction(e -> startLevel(3));

        levelPane.getChildren().addAll(title, level1, level2, level3);

        Scene levelScene = new Scene(levelPane, 400, 400);
        primaryStage.setScene(levelScene);
    }

    private void showTutorial()
    {
        Pane tutorialPane = new Pane();

        Text tutorialText = new Text("How to Play:\n- Fireboy: Use WASD\n- Watergirl: Use Arrow Keys\n" +
                "- Avoid wrong pools and hazards. Reach the door!");
        tutorialText.setFont(Font.font("Arial", 20));
        tutorialText.setX(50);
        tutorialText.setY(100);

        Button back = new Button("Back");
        back.setLayoutX(150);
        back.setLayoutY(300);
        back.setOnAction(e -> showMainMenu());

        tutorialPane.getChildren().addAll(tutorialText, back);

        Scene tutorialScene = new Scene(tutorialPane, 400, 400);
        primaryStage.setScene(tutorialScene);
    }
}
