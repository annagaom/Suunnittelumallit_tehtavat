package Command;

public class MoveCursorDownCommand implements Command {
    private MoveSystem moveSystem;

    public MoveCursorDownCommand(MoveSystem moveSystem) {
        this.moveSystem = moveSystem;
    }

    public void execute() {
        moveSystem.moveCursorDown();
        System.out.println("Cursor moved down");
    }

}
