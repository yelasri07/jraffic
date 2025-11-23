package jraffic;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Roads {
    private Line leftVerticalLine;
    private Line centerVerticalLine;
    private Line rightVerticalLine;
    private Line leftHorizontalLine;
    private Line centerHorizontalLine;
    private Line rightHorizontalLine;

    public static Map<Direction, Integer> numberCars = new HashMap<>();

    public Roads() {
        int width = App.WIDTH;
        int height = App.HEIGHT;
        int gap = App.GAP;

        numberCars.put(Direction.East, 0);
        numberCars.put(Direction.West, 0);
        numberCars.put(Direction.South, 0);
        numberCars.put(Direction.North, 0);

        Point p1 = new Point((width / 2) - gap, 0);
        Point p2 = new Point((width / 2) - gap, height);
        this.leftVerticalLine = new Line(p1.x, p1.y, p2.x, p2.y);
        this.leftVerticalLine.setStroke(Color.WHITE);

        p1.x = width / 2;
        p2.x = width / 2;

        this.centerVerticalLine = new Line(p1.x, p1.y, p2.x, p2.y);
        this.centerVerticalLine.setStroke(Color.WHITE);

        p1.x = (width / 2) + gap;
        p2.x = (width / 2) + gap;

        this.rightVerticalLine = new Line(p1.x, p1.y, p2.x, p2.y);
        this.rightVerticalLine.setStroke(Color.WHITE);

        p1.x = 0;
        p1.y = (height / 2) - gap;
        p2.x = width;
        p2.y = (height / 2) - gap;

        this.leftHorizontalLine = new Line(p1.x, p1.y, p2.x, p2.y);
        this.leftHorizontalLine.setStroke(Color.WHITE);

        p1.y = height / 2;
        p2.y = height / 2;

        this.centerHorizontalLine = new Line(p1.x, p1.y, p2.x, p2.y);
        this.centerHorizontalLine.setStroke(Color.WHITE);

        p1.y = (height / 2) + gap;
        p2.y = (height / 2) + gap;

        this.rightHorizontalLine = new Line(p1.x, p1.y, p2.x, p2.y);
        this.rightHorizontalLine.setStroke(Color.WHITE);
    }

    public void draw(Pane pane) {
        pane.getChildren().addAll(this.leftVerticalLine,
                this.centerVerticalLine,
                this.rightVerticalLine,
                this.leftHorizontalLine,
                this.centerHorizontalLine,
                this.rightHorizontalLine);
    }

    public static boolean isEmptyCenter() {
        int top = (App.HEIGHT / 2) - App.GAP;
        int bottom = (App.HEIGHT / 2) + App.GAP;
        int left = (App.WIDTH / 2) - App.GAP;
        int right = (App.WIDTH / 2) + App.GAP;

        for (Car car : Car.cars) {
            if (car.point.x + App.GAP > left && car.point.x < right && car.point.y + App.GAP > top
                    && car.point.y < bottom)
                return false;
        }

        return true;
    }
}
