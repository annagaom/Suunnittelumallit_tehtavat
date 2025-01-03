package Command;

public class MoveCursorLeftCommand implements Command {
    private MoveSystem moveSystem;

    public MoveCursorLeftCommand(MoveSystem moveSystem) {
        this.moveSystem = moveSystem;
    }

    public void execute() {
        moveSystem.moveCursorLeft();
        System.out.println("Cursor moved left");
    }
}
