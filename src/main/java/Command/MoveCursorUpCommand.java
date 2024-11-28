package Command;


import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class MoveCursorUpCommand {
    private MoveSystem moveSystem;

    public MoveCursorUpCommand(MoveSystem moveSystem) {
        this.moveSystem = moveSystem;
    }

    public void execute() {
        moveSystem.moveCursorUp();
        System.out.println("Cursor moved up");
    }

}
