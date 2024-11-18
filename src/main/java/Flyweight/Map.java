package Flyweight;

import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

public class Map {
    private final int width, height;
    private final Tile[][] tiles;

    // Constructor with mapType parameter
    public Map(int width, int height, TileGraphicFactory factory, String mapType) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width][height];

        Random random = new Random();

        String[] Citytypes = {"tree", "building", "road"};
        String[] WildernessMap = {"forest", "swamp", "water"};

        // Use mapType to decide which map to generate
        if ("CityMap".equals(mapType)) {  // Corrected string comparison
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    String type = Citytypes[random.nextInt(Citytypes.length)];
                    MapImages graphic = factory.getMapImages(type);
                    tiles[x][y] = new Tile(type, graphic, x, y);
                }
            }
        } else if ("WildernessMap".equals(mapType)) {
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    String type = WildernessMap[random.nextInt(WildernessMap.length)];
                    MapImages graphic = factory.getMapImages(type);
                    tiles[x][y] = new Tile(type, graphic, x, y);
                }
            }
        } else {
            throw new IllegalArgumentException("Unknown map type: " + mapType);
        }
    }

    // Render method to draw the map
    public void render(GraphicsContext gc) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y].render(gc);
            }
        }
    }
}
