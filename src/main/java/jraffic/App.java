package jraffic;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {
    public static final int WIDTH = 900;
    public static final int HEIGHT = 700;
    public static final int GAP = 50;

    @Override
    public void start(Stage stage) throws IOException {
        Pane pane = new Pane();

        Roads roads = new Roads();
        roads.draw(pane);

        Light light = new Light();
        light.draw(pane);

        Scene scene = new Scene(pane, WIDTH, HEIGHT, Color.BLACK);

        scene.setOnKeyPressed(e -> {
            String key = e.getCode().toString();
            switch (key) {
                case "UP":
                    Car.create(Direction.South, pane);
                    break;
                case "DOWN":
                    Car.create(Direction.North, pane);
                    break;
                case "LEFT":
                    Car.create(Direction.West, pane);
                    break;
                case "RIGHT":
                    Car.create(Direction.East, pane);
                    break;
                case "R":
                    Car.random(pane);
                    break;
                case "ESCAPE":
                    System.exit(0);
            }
        });

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                Car.update();
            }
        };

        timer.start();

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}