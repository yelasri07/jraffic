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
                    new Car(new Point(WIDTH / 2, HEIGHT - GAP), Direction.South, pane);
                    break;
                case "DOWN":
                    new Car(new Point((WIDTH / 2) - GAP, 0), Direction.North, pane);
                    break;
                case "LEFT":
                    new Car(new Point(WIDTH - GAP, (HEIGHT / 2) - GAP), Direction.West, pane);
                    break;
                case "RIGHT":
                    new Car(new Point(0, HEIGHT / 2), Direction.East, pane);
                    break;
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