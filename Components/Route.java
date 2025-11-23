package Components;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;

public class Route {

    private String direction;      // "NORTH", "SOUTH", "EAST", "WEST"
    private double x, y;           // top-left position
    private double width, height;  // lane size
    private Rectangle visual;      // JavaFX rectangle for rendering
    private List<Car> cars;        // cars currently on this lane

    public Route(String direction, double x, double y, double width, double height) {
        this.direction = direction;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.cars = new ArrayList<>();
    }

    // === Getters ===
    public String getDirection() { return direction; }
    public double getX() { return x; }
    public double getY() { return y; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    public Rectangle getVisual() { return visual; }
    public List<Car> getCars() { return cars; }

    // === Setters ===
    public void setVisual(Rectangle visual) { this.visual = visual; }

    // Add a car to this lane if safe distance is maintained
    public boolean addCar(Car car) {
        if (cars.isEmpty()) {
            cars.add(car);
            return true;
        }

        // Check distance from last car
        Car lastCar = cars.get(cars.size() - 1);
        double distance = 0;
        switch (direction) {
            case "NORTH": distance = lastCar.getY() - car.getY(); break;
            case "SOUTH": distance = car.getY() - lastCar.getY(); break;
            case "EAST":  distance = car.getX() - lastCar.getX(); break;
            case "WEST":  distance = lastCar.getX() - car.getX(); break;
        }

        if (distance >= car.getLength() + 10) { // 10 = safety gap in pixels
            cars.add(car);
            return true;
        }

        return false; // too close to last car
    }

    // Move all cars along the lane
    public void updateCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    // Optional: remove cars that have exited the lane
    public void removeExitedCars() {
        cars.removeIf(Car::hasExited);
    }
}
