package Flyweight;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.List;

public class RPGGameApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        int width = 30;
        int height = 20;

        Canvas canvas = new Canvas(width * 30, height * 30);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        TileGraphicFactory factory = new TileGraphicFactory();

//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter map type: c(city)/w(wilderness): ");
//        String mapType = scanner.nextLine().trim().toLowerCase();
//      System.out.print("Enter map width: ");
        // Create a list of possible map types for the ChoiceDialog


        List<String> mapTypes = List.of("CityMap", "WildernessMap");

        // Create and show a ChoiceDialog for selecting the map type
        ChoiceDialog<String> dialog = new ChoiceDialog<>("CityMap", mapTypes);
        dialog.setTitle("Map Type Selection");
        dialog.setHeaderText("Choose a map type");
        dialog.setContentText("Please select the map type (City or Wilderness):");

        // Show the dialog and wait for user selection
        String mapType = dialog.showAndWait().orElse("CityMap");  // Default to "CityMap" if canceled











        Map map = new Map(width, height, factory, mapType);

        map.render(gc);

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root);

        primaryStage.setTitle("RPG Map Renderer with Flyweight");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
