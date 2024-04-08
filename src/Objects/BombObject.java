/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import java.awt.image.BufferedImage;

/**
 *
 * @author Youssef
 */
public class BombObject extends ImageObject{
    public BombObject(int posX, int posY, String path) {
        super(posX, posY, path, 0);
        resizeImage(80, 80);
    }

    public BombObject(int posX, int posY, String path, int type) {
        super(posX, posY, path, type);
        resizeImage(80, 80);
    }
    private void resizeImage(int newWidth, int newHeight) {
        BufferedImage[] resizedImages = new BufferedImage[getSpriteImages().length];
        for (int i = 0; i < getSpriteImages().length; i++) {
            resizedImages[i] = ImageUtils.resize(getSpriteImages()[i], newWidth, newHeight);
        }
        setSpriteImages(resizedImages);
    }
}
