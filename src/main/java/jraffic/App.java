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
                    Point p1 = new Point(WIDTH / 2, HEIGHT - GAP);
                    if  (!Car.isSafePosition(p1, Direction.South)) break;;
                    new Car(p1, Direction.South, pane);
                    break;
                case "DOWN":
                    Point p2 = new Point((WIDTH / 2) - GAP, 0);
                    if  (!Car.isSafePosition(p2, Direction.North)) break;;
                    new Car(p2, Direction.North, pane);
                    break;
                case "LEFT":
                    Point p3 = new Point(WIDTH - GAP, (HEIGHT / 2) - GAP);
                    if  (!Car.isSafePosition(p3, Direction.West)) break;;
                    new Car(p3, Direction.West, pane);
                    break;
                case "RIGHT":
                    Point p4 = new Point(0, HEIGHT / 2);
                    if  (!Car.isSafePosition(p4, Direction.East)) break;;
                    new Car(p4, Direction.East, pane);
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