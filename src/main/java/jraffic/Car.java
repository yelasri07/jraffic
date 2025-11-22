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
    private Direction direction;

    public Car(Point point, Direction direction, Pane pane) {
        this.point = point;
        this.direction = direction;
        box = new Rectangle(App.GAP, App.GAP, Color.BLUE);
        pane.getChildren().add(box);
        cars.add(this);
    }

    public void draw() {
        this.box.setTranslateX(this.point.x);
        this.box.setTranslateY(this.point.y);
    }

    public static void update() {
        for (Car car:cars) {
            switch (car.direction) {
                case South:
                    car.point.y--;
                    break;
                case North:
                    car.point.y++;
                    break;  
                case West: 
                    car.point.x--;
                    break;
                case East:
                    car.point.x++;
                    break;
            }
            car.draw();
        }
    }
}
