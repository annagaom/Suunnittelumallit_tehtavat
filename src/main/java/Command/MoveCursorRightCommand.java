package Command;

public class MoveCursorRightCommand {
    private MoveSystem moveSystem;

    public MoveCursorRightCommand(MoveSystem moveSystem) {
        this.moveSystem = moveSystem;
    }

    public void execute() {
        moveSystem.moveCursorRight();
        System.out.println("Cursor moved right");
    }
}
