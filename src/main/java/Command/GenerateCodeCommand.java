package Command;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GenerateCodeCommand extends Application {
    private static final int GRID_SIZE = 8;
    private static final int CELL_SIZE = 40;
    private Rectangle[][] grid;
    private int[][] pixelArt = {
            {0, 0, 1, 1, 1, 1, 0, 0},
            {0, 0, 1, 1, 1, 1, 0, 0},
            {0, 0, 0, 1, 1, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 1, 1, 0, 0, 0},
            {0, 0, 1, 0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0, 0, 1, 0},
            {1, 0, 0, 0, 0, 1, 0, 1}
    };

    @Override
    public void start(Stage stage) {
        GridPane pixelGrid = createPixelGrid(); // Create the pixel grid
        MoveSystem moveSystem = new MoveSystem(grid);// Pass the grid to MoveSystem

        Command moveCursorUpCommand = new MoveCursorUpCommand(moveSystem);
        Command moveCursorDownCommand = new MoveCursorDownCommand(moveSystem);
        Command moveCursorLeftCommand = new MoveCursorLeftCommand(moveSystem);
        Command moveCursorRightCommand = new MoveCursorRightCommand(moveSystem);
        Command togglePixelCommand = new TogglePixelCommand(moveSystem);

        // Create a layout for the GUI
        VBox layout = new VBox(10); // Vertical layout with spacing
        layout.setPadding(new Insets(20));
        Label moveLabel = new Label(" - Move the cursor using arrow keys.");
        Label toggleLabel = new Label(" - Toggle the pixel color using the space bar.");

        layout.getChildren().addAll(pixelGrid, moveLabel, toggleLabel);

        // Create a scene with the layout
        Scene scene = new Scene(layout, GRID_SIZE * CELL_SIZE + 50, GRID_SIZE * CELL_SIZE + 100); // Adjust height for labels

        scene.setOnKeyPressed(event -> {
            KeyCode keyCode = event.getCode();
            if (keyCode == KeyCode.LEFT) {
                moveCursorLeftCommand.execute();
            } else if (keyCode == KeyCode.RIGHT) {
                moveCursorRightCommand.execute();
            } else if (keyCode == KeyCode.UP) {
                moveCursorUpCommand.execute();
            } else if (keyCode == KeyCode.DOWN) {
                moveCursorDownCommand.execute();
            } else if (keyCode == KeyCode.SPACE) {
                togglePixelCommand.execute();
            }
        });

        // Set the stage
        stage.setScene(scene);
        stage.setTitle("Pixel Art Editor");
        stage.show();
    }

    private GridPane createPixelGrid() {
        GridPane gridPane = new GridPane();
        grid = new Rectangle[GRID_SIZE][GRID_SIZE];

        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                Rectangle rect = new Rectangle(CELL_SIZE, CELL_SIZE);
                rect.setFill(pixelArt[row][col] == 1 ? Color.PINK : Color.LIGHTGRAY);
                rect.setStroke(Color.BLACK);
                gridPane.add(rect, col, row);
                grid[row][col] = rect;
            }
        }
        return gridPane;
    }

    public Rectangle[][] getGrid() {
        return grid;
    }
}
