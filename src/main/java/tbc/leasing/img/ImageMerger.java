package tbc.leasing.img;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageMerger {


    public static void mergeUsingDefaultDimensions(BufferedImage background, BufferedImage frontImage, int posX, int posY, File output) throws IOException {
        merge(background, frontImage, posX, posY, frontImage.getWidth(), frontImage.getHeight(), output);
    }

    public static void merge(BufferedImage background, BufferedImage frontImage, int posX, int posY, int width, int height, File output) throws IOException {
        Graphics2D g = (Graphics2D) background.getGraphics();
        g.drawImage(frontImage, posX, posY, width, height, null);
        ImageIO.write(background, "png", output);
    }

}
