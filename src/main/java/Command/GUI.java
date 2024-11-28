package Command;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GUI extends Application {

    @Override
    public void start(Stage stage) {
        GenerateCodeCommand generateCodeCommand = new GenerateCodeCommand(); // Creates the status window logic
        generateCodeCommand.start(stage); // Initialize the grid in GenerateCodeCommand

        // Now get the grid from GenerateCodeCommand after it has been created
        Rectangle[][] grid = generateCodeCommand.getGrid();

        VBox layout = new VBox(10); // Layout for the main window
        layout.setPadding(new Insets(20));

        Button statusButton = new Button("Show Status Window");

        // Add button to the layout
        layout.getChildren().addAll(statusButton);

        // When button is clicked, create a new Stage for the status window
        statusButton.setOnAction(e -> {
            Stage statusStage = new Stage(); // Create new Stage
            generateCodeCommand.start(statusStage); // Start the status window (use statusStage)
        });

        // Set the main window scene and show it
        Scene scene = new Scene(layout, 200, 200);
        stage.setScene(scene);
        stage.setTitle("Pixel Art Editor");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
