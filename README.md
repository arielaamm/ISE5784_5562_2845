# Image Rendering Project

## Overview

Welcome to the Image Rendering Project! This Java project allows you to create and render images using various geometric shapes and light structures. Designed with a modular and extensible architecture, it leverages a variety of design patterns to ensure flexibility and maintainability.

## Features

### Geometric Shapes
- **Creation**: Squares, rectangles, circles, triangles, and more.
- **Configuration**: Customize color, size, and other properties.

### Light Structures
- **Types**: Ambient, directional, and point lights.
- **Configuration**: Adjust intensity, direction, and color.
- **Effects**: Render shadows and reflections on the canvas.

### Advanced Rendering
- **Support**: Add polygons or even 3D shapes for more complex scenes.
- **Quality**: High-quality rendering with realistic lighting and shadow effects.

## Architectural Patterns

This project employs several design patterns to enhance its modularity and extensibility:

- **Composite Pattern**: Used for composing complex shapes from simpler ones through the `Intersectable` interface.
- **Strategy Pattern**: Different lighting strategies are implemented via the `Light` interface.
- **Iterator Pattern**: The `Intersectable` class uses this pattern to iterate over geometries.
- **Builder Pattern**: The `Scene` and `Material` classes utilize this pattern for configurable properties.
- **Wrapper Pattern**: The `Color` interface and its implementations allow for various color properties.
- **Template Method Pattern**: Used by the `GeoIntersections` class to define a structure for creating points on shapes.
- **Delegation Pattern**: Applied in `Point` and `Vector` classes to avoid unnecessary repetitions.

## Getting Started

### Prerequisites

- **Java Development Kit (JDK) 8 or higher**
- **JUnit 5**: For running unit tests
- **An IDE**: IntelliJ IDEA, Eclipse, or any preferred Java IDE

### Installation

1. Clone the repository:

    ```sh
    git clone https://github.com/arielaamm/image-rendering.git
    ```

2. Navigate to the project directory:

    ```sh
    cd image-rendering
    ```

3. Open the project in your preferred IDE.

### Building and Running

To build and run the project, follow these steps:

1. **Build the Project**: Compile the source files.
   
    ```sh
    javac -d out src/**/*.java
    ```

2. **Run Tests**: Execute the unit tests to see the project in action.

    ```sh
    ./gradlew test
    ```

    or if you use Maven:

    ```sh
    mvn test
    ```

3. **View Results**: Check the `images` folder for the rendered images.

## Extending the Project

Interested in adding more features? Here are some ideas:

- **New Materials**: Add reflective or transparent materials.
- **Complex Scenes**: Support animations or simulations.
- **Additional Shapes**: Implement new geometric or 3D shapes.

## Dependencies

- **JUnit 5**: Used for unit testing

## Contribution

Contributions are welcome! If you have suggestions or find bugs, please open an issue. Feel free to fork the repository and submit pull requests.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For questions or suggestions, please open an issue on GitHub.
