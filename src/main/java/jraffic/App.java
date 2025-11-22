package jraffic;

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
                    Car car = new Car(new Point(WIDTH / 2, HEIGHT - GAP));
                    car.draw(pane);
                    break;
                case "DOWN": 
                    Car car2 = new Car(new Point((WIDTH / 2) - GAP, 0));
                    car2.draw(pane);
                    break;
                case "LEFT":
                    Car car3 = new Car(new Point(WIDTH - GAP, (HEIGHT / 2) - GAP));
                    car3.draw(pane);
                    break;
                case "RIGHT": 
                    Car car4 = new Car(new Point(0, HEIGHT / 2));
                    car4.draw(pane);
                    break;
            }
            
        });
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}