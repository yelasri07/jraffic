package jraffic;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Car {
    public Point point;
    public static List<Car> cars = new ArrayList<>();

    public Car(Point point) {
        this.point = point;
        
        cars.add(this);
    }

    public void draw(Pane pane) {
        for (Car car:cars) {
            System.out.println(String.format("x = %f | y = %f", car.point.x, car.point.y));
            Rectangle box = new Rectangle(App.GAP, App.GAP, Color.BLUE);
            box.setTranslateX(car.point.x);
            box.setTranslateY(car.point.y);
            pane.getChildren().add(box);
        }

        System.out.println("-----------------------------------------");
    }
}
