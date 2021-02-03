package racer2d;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.CacheHint;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.util.Random;

public class Game extends Application {

    private GraphicsContext gc;
    private Image carImage;

    private Image treeImage;
    private Image yellow;

    private double x = 350;
    private double y = 450;
    Canvas canvas;

    private boolean inputRight = false;
    private boolean inputLeft = false;
    private long lastTime;
    private double carSpeed = 300;

    private double tree1y =  200;
    private double tree2y =  100;
    private final double streetstartx1 = 510;
    private final double streetstartx2 = 270;
    private final double carWidth = 30;

    private final double canvaswidth = 800;
    private final double canvasheight = 600;

    Random random = new Random();

    @Override
    public void start(Stage primaryStage) throws Exception {
        canvas = new Canvas(canvaswidth, canvasheight);
        canvas.setCache(true);
        canvas.setCacheHint(CacheHint.SPEED);

        Group rootGroup = new Group();
        rootGroup.getChildren().add(canvas);
        Scene scene = new Scene(rootGroup);

        gc = canvas.getGraphicsContext2D();

        load();

        scene.setOnKeyPressed(this::onKeyPressed);
        scene.setOnKeyReleased(this::onKeyReleased);
        lastTime = System.nanoTime();

        new AnimationTimer() {
            @Override
            public void handle(long l) {
                update(l);
            }
        }.start();

        primaryStage.setTitle("Racer2D");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void load() {
        carImage = new Image(getClass().getResourceAsStream("/game/car_blue.png"));
        treeImage = new Image(getClass().getResourceAsStream("/game/tree_small.png"));
        yellow = new Image(getClass().getResourceAsStream("/game/arrow_yellow.png"));
    }

    public void paint() {
        gc.setFill(Paint.valueOf("#43CD7D"));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        gc.setFill(Paint.valueOf("#bbbbaa"));
        gc.fillRect(250, 0, 300, 600);

        gc.setFill(Paint.valueOf("#ffffff"));
        gc.fillRect(streetstartx1, 0, 20, 600);

        gc.setFill(Paint.valueOf("#ffffff"));
        gc.fillRect(streetstartx2, 0, 20, 600);

        gc.drawImage(carImage, x, y);

        gc.drawImage(treeImage, 150, tree1y);
        gc.drawImage(treeImage, 500, tree2y);
    }

    public void update(long currentTime) {
        double deltaTime = (currentTime - lastTime) / 1e9d;
        lastTime = currentTime;

        if(inputRight && x <= streetstartx1 - 10 - carWidth) {
            x += carSpeed * deltaTime;
        }

        if(inputLeft && x >= streetstartx2 - 10) {
            x -= carSpeed * deltaTime;
        }

        tree1y += carSpeed * deltaTime;
        tree2y += carSpeed * deltaTime;

        if(tree1y > canvasheight) {
            tree1y = (random.nextInt(600) + 100) * -1;
        }

        if(tree2y > canvasheight) {
            tree2y = (random.nextInt(600) + 100) * -1;
        }



        paint();
    }

    public void onKeyPressed(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.A || keyEvent.getCode() == KeyCode.LEFT) {
            inputLeft = true;
        }
        if(keyEvent.getCode() == KeyCode.D || keyEvent.getCode() == KeyCode.RIGHT) {
            inputRight = true;
        }
    }

    public void onKeyReleased(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.A || keyEvent.getCode() == KeyCode.LEFT) {
            inputLeft = false;
        }
        if(keyEvent.getCode() == KeyCode.D || keyEvent.getCode() == KeyCode.RIGHT) {
            inputRight = false;
        }
    }
}
