package Flyweight;

import javafx.scene.canvas.GraphicsContext;

public class Tile {
    private final String type; // Tile type (e.g., "Grass", "Mountain")
    private final MapImages graphic; // Shared intrinsic state

    private final int x, y; // Extrinsic state

    public Tile(String type, MapImages graphic, int x, int y) {
        this.type = type;
        this.graphic = graphic;
        this.x = x;
        this.y = y;
    }

    public void render(GraphicsContext gc) {
        graphic.render(gc, x, y); // Delegate rendering to the shared graphic
    }
}
