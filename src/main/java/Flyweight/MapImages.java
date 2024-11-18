package Flyweight;

import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;

import java.io.InputStream;

public class MapImages {
    private final Image image;

   public MapImages(String imagePath) {

        InputStream inputStream = getClass().getResourceAsStream("/images/" + imagePath);
        if (inputStream == null) {
            throw new IllegalArgumentException("Image not found: " + imagePath);
        }
        this.image = new Image(inputStream);
    }

    public void render(GraphicsContext gc, int x, int y) {
        gc.drawImage(image, x * 150, y * 150);
    }
}


