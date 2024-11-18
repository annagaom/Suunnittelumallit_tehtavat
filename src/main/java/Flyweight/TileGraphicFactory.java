package Flyweight;

import java.util.HashMap;
import java.util.Map;

public class TileGraphicFactory {
    private final Map<String, MapImages> graphicsMap = new HashMap<>();

    public MapImages getMapImages(String type) {
        MapImages graphic = graphicsMap.get(type);
        if (graphic == null) {
            // Assuming each tile type corresponds to an image, such as "tree.png"
            graphic = new MapImages(type + ".png");
            graphicsMap.put(type, graphic);
        }
        return graphic;
    }
}
