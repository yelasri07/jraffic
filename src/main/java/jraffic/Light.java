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

    public static List<Light> lights = new ArrayList<>();

    public Light() {
        int width = App.WIDTH;
        int height = App.HEIGHT;

        new Light(new Point((width / 2) - 110, (height / 2) - 110));
        new Light(new Point((width / 2) + 60, (height / 2) - 110));
        new Light(new Point((width / 2) - 110, (height / 2) + 60));
        new Light(new Point((width / 2) + 60, (height / 2) + 60));
    }

    public Light(Point point) {
        this.point = point;
        this.state = false;
        this.color = Color.RED;
        lights.add(this);
    }

    public void draw(Pane pane) {
        for (Light light : lights) {
            Rectangle box = new Rectangle(App.GAP, App.GAP, light.color);
            box.setTranslateX(light.point.x);
            box.setTranslateY(light.point.y);
            pane.getChildren().add(box);
        }
    }
}
