package jraffic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Light {
    public boolean state;
    public Point point;
    public Color color;

    private Rectangle box;

    public static List<Light> lights = new ArrayList<>();

    public Light(Pane pane) {
        int width = App.WIDTH;
        int height = App.HEIGHT;

        new Light(new Point((width / 2) - 110, (height / 2) - 110), pane);
        new Light(new Point((width / 2) + 60, (height / 2) - 110), pane);
        new Light(new Point((width / 2) - 110, (height / 2) + 60), pane);
        new Light(new Point((width / 2) + 60, (height / 2) + 60), pane);
    }

    public Light(Point point, Pane pane) {
        this.point = point;
        this.state = false;
        this.color = Color.RED;
        this.box = new Rectangle(App.GAP, App.GAP);
        pane.getChildren().add(box);
        lights.add(this);
    }

    public void draw() {
        this.box.setTranslateX(this.point.x);
        this.box.setTranslateY(this.point.y);
        this.box.setStroke(this.color);
    }

    public static void update() {
        if (Roads.isEmptyCenter()) {
            for (Light light : lights) {
                light.state = false;
            }

            int maxCars = 0;
            Direction greenLightRoute = Direction.North;
            for (Map.Entry<Direction, Integer> nc : Roads.numberCars.entrySet()) {
                Direction key = nc.getKey();
                int value = nc.getValue();
                if (value > maxCars) {
                    maxCars = value;
                    greenLightRoute = key;
                }
            }

            int index = -1;
            if (greenLightRoute == Direction.West) {
                index = 1;
            } else if (greenLightRoute == Direction.East) {
                index = 2;
            } else if (greenLightRoute == Direction.South) {
                index = 3;
            } else if (greenLightRoute == Direction.North) {
                index = 0;
            }

            lights.get(index).state = true;
        }

        for (Light light : lights) {
            if (light.state == true) {
                light.color = Color.GREEN;
            } else {
                light.color = Color.RED;
            }
            light.draw();
        }
    }
}
