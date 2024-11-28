package Command;

public class TogglePixelCommand implements Command {
    private MoveSystem moveSystem;


    public TogglePixelCommand(MoveSystem moveSystem) {
        this.moveSystem = moveSystem;
    }

    public void execute() {
        moveSystem.togglePixelChange();
        System.out.println("Pixel's color toggled");
    }

}
