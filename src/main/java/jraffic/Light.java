package jraffic;

import java.util.ArrayList;
import java.util.List;

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
