# JTraffic

A JavaFX-based traffic simulation application that models vehicle movement at an intersection with traffic lights and routing logic.

## Description

JTraffic simulates a busy intersection where cars approach from four directions (North, South, East, West). The simulation includes traffic lights that control the flow, cars that follow different routes (left turn, right turn, straight), and collision avoidance mechanisms. Cars are automatically removed when they exit the simulation area.

## Features

- **Real-time Simulation**: Animated cars moving through the intersection
- **Traffic Lights**: Four traffic lights that cycle to manage traffic flow
- **Multiple Routes**: Cars can turn left, right, or go straight based on random assignment
- **Collision Avoidance**: Cars maintain safe distances to prevent collisions
- **Interactive Controls**: Add cars manually or randomly
- **Automatic Cleanup**: Cars are removed from memory when they leave the screen

## Prerequisites

- Java 17 or later
- Maven 3.6 or later
- JavaFX 17 (automatically managed by Maven)

### Installing Maven

If Maven is not installed, you can install it manually:

```bash
wget https://dlcdn.apache.org/maven/maven-3/3.8.9/binaries/apache-maven-3.8.9-bin.tar.gz
```

```bash
tar -xvzf apache-maven-3.8.9-bin.tar.gz
mv apache-maven-3.8.9 ~/maven
```

```bash
echo 'export PATH=~/maven/bin:$PATH' >> ~/.zshrc
source ~/.zshrc
```

```bash
mvn -v
```

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yelasri07/jraffic.git
   cd jraffic
   ```

2. Ensure Java 17+ and Maven are installed:
   ```bash
   java -version
   mvn -version
   ```

## Building the Project

To compile the project:

```bash
mvn clean compile
```

This will compile all Java source files and prepare the application for execution.

## Running the Application

To run the simulation:

```bash
mvn javafx:run
```

This command will:
- Compile the project (if needed)
- Download required dependencies
- Launch the JavaFX application window

## Usage

### Controls

- **Arrow Keys**: Create cars approaching from specific directions
  - ↑ (UP): Car from South
  - ↓ (DOWN): Car from North
  - ← (LEFT): Car from West
  - → (RIGHT): Car from East
- **R**: Create a random car from any direction
- **ESC**: Exit the application

### Simulation Mechanics

- **Traffic Lights**: Automatically cycle every few seconds
- **Car Routes**: Each car is randomly assigned a route (left, right, or straight)
- **Intersection Behavior**: Cars turn at the center of the intersection based on their route
- **Speed Control**: Cars move at a constant speed but stop at red lights
- **Safe Distancing**: Cars won't spawn or move if it would cause a collision

## Project Structure

```
src/
├── App.java          # Main application class, handles UI and animation loop
├── Car.java          # Car model with movement logic and collision detection
├── Config.java       # Configuration constants (window size, etc.)
├── Direction.java    # Enum for cardinal directions
├── Light.java        # Traffic light model and cycling logic
├── Point.java        # Simple 2D point class
├── Roads.java        # Road layout and car counting logic
└── Route.java        # Enum for car routes (left, right, straight)
```

### Key Classes

- **App**: Entry point, sets up the JavaFX scene and animation timer
- **Car**: Represents individual vehicles with position, direction, and route
- **Light**: Manages traffic light states and timing
- **Roads**: Handles road drawing and car counting per direction

## Dependencies

- **JavaFX 17**: For GUI and graphics
- **JUnit**: For unit testing (if tests are added)

All dependencies are managed through Maven and specified in `pom.xml`.

## Configuration

Window size and simulation parameters can be adjusted in `Config.java`:

- `WIDTH`: Window width (default: 800)
- `HEIGHT`: Window height (default: 600)
- `GAP`: Car size and spacing (default: 50)

## Testing

Currently, the project does not include automated tests, but you can manually test by:

1. Running the application
2. Adding cars with different controls
3. Observing traffic light behavior
4. Verifying cars are removed when leaving the screen

## Troubleshooting

### Common Issues

- **Application doesn't start**: Ensure Java 17+ and Maven are installed
- **GUI doesn't appear**: Check if JavaFX is properly configured
- **Cars don't move**: Traffic lights might be red; wait for green
- **Performance issues**: Reduce window size in Config.java
