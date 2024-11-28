package Command;

public class TogglePixelCommand {
    private GenerateCodeCommand generateCodeCommand;

    public TogglePixelCommand(GenerateCodeCommand generateCodeCommand) {
        this.generateCodeCommand = generateCodeCommand;
    }

    public void execute() {
        generateCodeCommand.togglePixelChange();
    }
}
