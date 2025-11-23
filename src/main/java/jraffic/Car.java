package jraffic;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Car {
    public Point point;
    private int id;
    private Rectangle box;
    private Direction direction;
    private Route route;
    private Color color;

    private static final int GAP_BETWEEN_CARS = 70;
    public static List<Car> cars = new ArrayList<>();

    public Car(Point point, Direction direction, Pane pane) {
        this.point = point;
        this.direction = direction;
        this.id = cars.size();

        int randomRout = (int) Math.round(Math.random() * 2);
        if (randomRout == 0) {
            this.route = Route.LEFT;
            this.color = Color.AQUA;
        } else if (randomRout == 1) {
            this.route = Route.RIGHT;
            this.color = Color.YELLOW;
        } else {
            this.route = Route.STRAIGHT;
            this.color = Color.PURPLE;
        }

        box = new Rectangle(App.GAP, App.GAP, this.color);
        pane.getChildren().add(box);
        cars.add(this);
    }

    public void draw() {
        this.box.setTranslateX(this.point.x);
        this.box.setTranslateY(this.point.y);
    }

    public static void update() {
        // List<Light> lights = Light.lights;

        for (Car car : cars) {
            switch (car.direction) {
                case South:
                    if (!isSafePosition(car, car.direction) || (car.point.y <= (App.HEIGHT / 2) + App.GAP)) {
                        break;
                    }

                    car.point.y--;
                    if (car.route == Route.LEFT && car.point.y + App.GAP <= App.HEIGHT / 2) {
                        car.direction = Direction.West;
                        car.route = Route.STRAIGHT;
                    } else if (car.route == Route.RIGHT && car.point.y <= App.HEIGHT / 2) {
                        car.direction = Direction.East;
                        car.route = Route.STRAIGHT;
                    }
                    break;
                case North:
                    car.point.y++;
                    if (car.route == Route.LEFT && car.point.y >= App.HEIGHT / 2) {
                        car.direction = Direction.East;
                        car.route = Route.STRAIGHT;
                    } else if (car.route == Route.RIGHT && car.point.y + App.GAP >= App.HEIGHT / 2) {
                        car.direction = Direction.West;
                        car.route = Route.STRAIGHT;
                    }
                    break;
                case West:
                    car.point.x--;
                    if (car.route == Route.LEFT && car.point.x + App.GAP <= App.WIDTH / 2) {
                        car.direction = Direction.North;
                        car.route = Route.STRAIGHT;
                    } else if (car.route == Route.RIGHT && car.point.x <= App.WIDTH / 2) {
                        car.direction = Direction.South;
                        car.route = Route.STRAIGHT;
                    }
                    break;
                case East:
                    car.point.x++;
                    if (car.route == Route.LEFT && car.point.x >= App.WIDTH / 2) {
                        car.direction = Direction.South;
                        car.route = Route.STRAIGHT;
                    } else if (car.route == Route.RIGHT && car.point.x + App.GAP >= App.WIDTH / 2) {
                        car.direction = Direction.North;
                        car.route = Route.STRAIGHT;
                    }
                    break;
            }
            car.draw();
        }
    }

    public static boolean isSafePosition(Point point, Direction direction) {
        for (Car car : cars) {
            if (direction == Direction.South && car.direction == Direction.South
                    && point.y < car.point.y + GAP_BETWEEN_CARS) {
                return false;
            } else if (direction == Direction.North && car.direction == Direction.North
                    && point.y + GAP_BETWEEN_CARS > car.point.y) {
                return false;
            } else if (direction == Direction.East && car.direction == Direction.East
                    && point.x + GAP_BETWEEN_CARS > car.point.x) {
                return false;
            } else if (direction == Direction.West && car.direction == Direction.West
                    && point.x < car.point.x + GAP_BETWEEN_CARS) {
                return false;
            }
        }

        return true;
    }

    public static boolean isSafePosition(Car currentCar, Direction direction) {
        for (Car car : cars) {
            if (direction == Direction.South && car.direction == Direction.South && currentCar.id > car.id
                    && currentCar.point.y < car.point.y + GAP_BETWEEN_CARS) {
                        
                return false;
            } else if (direction == Direction.North && car.direction == Direction.North
                    && currentCar.point.y + GAP_BETWEEN_CARS > car.point.y) {
                return false;
            } else if (direction == Direction.East && car.direction == Direction.East
                    && currentCar.point.x + GAP_BETWEEN_CARS > car.point.x) {
                return false;
            } else if (direction == Direction.West && car.direction == Direction.West
                    && currentCar.point.x < car.point.x + GAP_BETWEEN_CARS) {
                return false;
            }
        }

        return true;
    }

    public static void random(Pane pane) {
        int randomPoint = (int) Math.round(Math.random() * 3);

        if (randomPoint == 0) {
            create(Direction.South, pane);
        } else if (randomPoint == 1) {
            create(Direction.North, pane);
        } else if (randomPoint == 2) {
            create(Direction.West, pane);
        } else {
            create(Direction.East, pane);
        }
    }

    public static void create(Direction direction, Pane pane) {
        int width = App.WIDTH;
        int height = App.HEIGHT;
        int gap = App.GAP;

        if (direction == Direction.South) {
            Point p1 = new Point(width / 2, height - gap);
            if (!Car.isSafePosition(p1, Direction.South))
                return;
            new Car(p1, Direction.South, pane);
        } else if (direction == Direction.North) {
            Point p2 = new Point((width / 2) - gap, 0);
            if (!Car.isSafePosition(p2, Direction.North))
                return;
            new Car(p2, Direction.North, pane);
        } else if (direction == Direction.West) {
            Point p3 = new Point(width - gap, (height / 2) - gap);
            if (!Car.isSafePosition(p3, Direction.West))
                return;
            new Car(p3, Direction.West, pane);
        } else {
            Point p4 = new Point(0, height / 2);
            if (!Car.isSafePosition(p4, Direction.East))
                return;
            new Car(p4, Direction.East, pane);
        }
    }
}
