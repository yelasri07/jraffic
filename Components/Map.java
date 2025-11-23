package Components;

import javafx.scene.layout.Pane;

public class Map {

    private Pane root;

    public Map(Pane root) {
        this.root = root;

        initRoads();
        initLights();
    }

    private void initRoads() {
        // TODO: draw roads
    }

    private void initLights() {
        // TODO: place and draw traffic lights
    }

    public void spawnCarFrom(String direction) {
        // TODO: create a Car object and add it to the root Pane
        // ensure safe distance
    }

    public void spawnCarRandom() {
        String[] dirs = {"NORTH", "SOUTH", "EAST", "WEST"};
        spawnCarFrom(dirs[(int)(Math.random() * 4)]);
    }

    public void update(long now) {
        // TODO:
        // move all cars
        // check collisions
        // apply traffic light logic
        // dynamic congestion logic
    }
}
