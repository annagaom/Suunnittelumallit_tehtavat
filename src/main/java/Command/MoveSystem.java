package Command;

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

    private void moveCursor(int rowOffset, int colOffset) {
        int newRow = cursorRow + rowOffset;
        int newCol = cursorCol + colOffset;

        if (newRow >= 0 && newRow < GRID_SIZE && newCol >= 0 && newCol < GRID_SIZE) {
            cursorRow = newRow;
            cursorCol = newCol;
            updateCursor();
        }
    }

    private void updateCursor() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                grid[row][col].setStroke(Color.BLACK);
            }
        }
        grid[cursorRow][cursorCol].setStroke(Color.PINK);
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

    public int getCursorRow() {
        return cursorRow;
    }

    public int getCursorCol() {
        return cursorCol;
    }

    public void togglePixelChange() {
        int row = getCursorRow();
        int col = getCursorCol();
        int currentState = grid[row][col].getFill() == Color.PINK ? 1 : 0;
        int newState = (currentState == 1) ? 0 : 1;
        grid[row][col].setFill(newState == 1 ? Color.PINK : Color.LIGHTGRAY);
    }
}
