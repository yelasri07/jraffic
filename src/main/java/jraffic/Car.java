package jraffic;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Car {
    public Point point;
    public static List<Car> cars = new ArrayList<>();
    private Rectangle box;

    public Car(Point point, Pane pane) {
        this.point = point;
        box = new Rectangle(App.GAP, App.GAP, Color.BLUE);
        pane.getChildren().add(box);
        cars.add(this);
    }

    public void draw() {
        box.setTranslateX(this.point.x);
        box.setTranslateY(this.point.y);
    }

    public static void update() {
        for (Car car:cars) {
            car.point.y--;
            car.draw();
        }
    }
}
