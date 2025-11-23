package Components;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Map {

    private Pane root;

    // We'll store all routes/lanes in an array
    private Route[] routes;

    public Map(Pane root) {
        this.root = root;
        initRoads();
        initLights();
    }

    private void initRoads() {
        // Intersection dimensions
        double sceneWidth = 900;
        double sceneHeight = 900;
        double laneWidth = 40; // pixels
        double roadLength = 400; // length from spawn to intersection

        routes = new Route[4]; // 2 lanes per direction (incoming + outgoing)

        // === Vertical road (North-South) ===
        // Northbound (from bottom to top)
        routes[0] = new Route("NORTH", sceneWidth / 2 - laneWidth / 2, 0, laneWidth, roadLength);
        // Southbound (from top to bottom)
        routes[1] = new Route("SOUTH", sceneWidth / 2 + laneWidth / 2, sceneHeight - roadLength, laneWidth, roadLength);

        // === Horizontal road (East-West) ===
        // Eastbound (from left to right)
        routes[2] = new Route("EAST", 0, sceneHeight / 2 - laneWidth / 2, roadLength, laneWidth);
        // Westbound (from right to left)
        routes[3] = new Route("WEST", sceneWidth - roadLength, sceneHeight / 2 + laneWidth / 2, roadLength, laneWidth);

        // Add roads as rectangles to root for visualization
        for (Route r : routes) {
            Rectangle roadVisual = new Rectangle(r.getX(), r.getY(), r.getWidth(), r.getHeight());
            roadVisual.setFill(Color.DARKGRAY);      // road color
            roadVisual.setStroke(Color.BLACK);       // road border
            roadVisual.setStrokeWidth(2);

            r.setVisual(roadVisual); // link rectangle to Route
            root.getChildren().add(roadVisual);
        }
    }

    private void initLights() {
        // TODO: implement traffic lights at entry points of each route
    }

    public void spawnCarFrom(String direction) {
        // TODO: create a Car object and add it to the root Pane
        // ensure safe distance
    }

    public void spawnCarRandom() {
        String[] dirs = {"NORTH", "SOUTH", "EAST", "WEST"};
        spawnCarFrom(dirs[(int) (Math.random() * 4)]);
    }

    public void update(long now) {
        // TODO:
        // move all cars
        // check collisions
        // apply traffic light logic
        // dynamic congestion logic
    }
}
