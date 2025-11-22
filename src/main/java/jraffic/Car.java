package jraffic;

import java.util.ArrayList;
import java.util.List;

public class Car {
    public Point point;
    public static List<Car> cars = new ArrayList<>();

    public Car(Point point) {
        this.point = point;

        cars.add(this);
    }
}
