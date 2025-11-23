import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;

import Components.Map;

public class Main extends Application {

    private Map world;        // Your simulation world
    private Pane root;        // Main UI layer

    @Override
    public void start(Stage stage) {
        root = new Pane();
        root.setPrefSize(900, 900);  // You can adjust the map size

        // Initialize your simulation map (roads, lights, etc.)
        world = new Map(root);

        Scene scene = new Scene(root);

        // Handle keyboard input (spawn vehicles)
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP: world.spawnCarFrom("SOUTH"); break;
                case DOWN: world.spawnCarFrom("NORTH"); break;
                case LEFT: world.spawnCarFrom("EAST"); break;
                case RIGHT: world.spawnCarFrom("WEST"); break;
                case R: world.spawnCarRandom(); break;
                case ESCAPE: stage.close(); break;
                default: break;
            }
        });

        stage.setTitle("Traffic Simulation");
        stage.setScene(scene);
        stage.show();

        // Animation loop (game loop)
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                world.update(now);
            }
        };

        timer.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
