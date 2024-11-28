package Command;

public class MoveCursorUpCommand implements Command {
    private MoveSystem moveSystem;

    public MoveCursorUpCommand(MoveSystem moveSystem) {
        this.moveSystem = moveSystem;
    }

    public void execute() {
        moveSystem.moveCursorUp();
        System.out.println("Cursor moved up");
    }

}
