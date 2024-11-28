package Command;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MoveSystem {
    private static final int GRID_SIZE = 8;
    private final Rectangle[][] grid;
    private int cursorRow = 0;
    private int cursorCol = 0;

    public MoveSystem(Rectangle[][] grid) {
        this.grid = grid;
        updateCursor();
    }

    public void setupControls(Scene scene) {
        scene.setOnKeyPressed(event -> {
            KeyCode key = event.getCode();
            switch (key) {
                case UP -> moveCursor(-1, 0);
                case DOWN -> moveCursor(1, 0);
                case LEFT -> moveCursor(0, -1);
                case RIGHT -> moveCursor(0, 1);
                case SPACE -> togglePixel();
            }
        });
    }

    private void moveCursor(int rowOffset, int colOffset) {
        int newRow = cursorRow + rowOffset;
        int newCol = cursorCol + colOffset;

        if (newRow >= 0 && newRow < GRID_SIZE && newCol >= 0 && newCol < GRID_SIZE) {
            cursorRow = newRow;
            cursorCol = newCol;
            updateCursor();
        }
    }

    private void togglePixel() {
        Rectangle rect = grid[cursorRow][cursorCol];
        if (rect.getFill() == Color.PINK) {
            rect.setFill(Color.LIGHTGRAY);
        } else {
            rect.setFill(Color.PINK);
        }
    }

    private void updateCursor() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                grid[row][col].setStroke(Color.BLACK);
            }
        }
        grid[cursorRow][cursorCol].setStroke(Color.RED);
    }

    public void moveCursorUp() {
        moveCursor(-1, 0);
    }

    public void moveCursorDown() {
        moveCursor(1, 0);
    }

    public void moveCursorLeft() {
        moveCursor(0, -1);
    }

    public void moveCursorRight() {
        moveCursor(0, 1);
    }

}
