package Components;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Car {

    private double x, y;          // current position
    private double width = 20;    // car width
    private double height = 40;   // car length
    private double speed = 2;     // pixels per frame
    private String direction;     // "NORTH", "SOUTH", "EAST", "WEST"
    private Rectangle visual;     // JavaFX rectangle for visualization

    public Car(String direction, double startX, double startY, Color color) {
        this.direction = direction;
        this.x = startX;
        this.y = startY;

        // create rectangle for visual representation
        visual = new Rectangle(x, y, width, height);
        visual.setFill(color);
    }

    public Rectangle getVisual() { return visual; }
    public double getX() { return x; }
    public double getY() { return y; }
    public double getLength() { return height; } // used for safe distance

    // Move the car along its lane
    public void move() {
        switch (direction) {
            case "NORTH": y -= speed; break;
            case "SOUTH": y += speed; break;
            case "EAST":  x += speed; break;
            case "WEST":  x -= speed; break;
        }
        visual.setX(x);
        visual.setY(y);
    }

    // Check if the car has left the scene (cleanup)
    public boolean hasExited() {
        return x < -50 || x > 950 || y < -50 || y > 950;
    }
}
