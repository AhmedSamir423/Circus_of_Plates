/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import Strategy.MovementStrategy;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Youssef
 */
public class ImageObject implements GameObject {
   private static final int MAX_MSTATE = 1;

    private MovementStrategy movementStrategy;

	public void setMovementStrategy(MovementStrategy strategy) {
        this.movementStrategy = strategy;
    }
	public void move() {
        if (movementStrategy != null) {
            movementStrategy.move(this);
        }
	}
	// an array of sprite images that are drawn sequentially
	private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
	private int x;
	private int y;
	private boolean visible;
	private int type;
        public ImageObject(int posX, int posY, String path){
		this(posX, posY, path, 0);
	}
	
	public ImageObject(int posX, int posY, String path, int type){
		this.x = posX;
		this.y = posY;
		this.type = type;
		this.visible = true;
		// create a bunch of buffered images and place into an array, to be displayed sequentially
		try {
			spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
this.x=x;
    }

    @Override
    public int getY() {
return y;
    }

    @Override
    public void setY(int y) {
this.y=y;
    }

    @Override
    public int getWidth() {
return spriteImages[0].getWidth();
    }

    @Override
    public int getHeight() {
return spriteImages[0].getHeight();
    }

    

    @Override
    public BufferedImage[] getSpriteImages() {
   return spriteImages;
    }
   @Override
    public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(boolean visible){
		this.visible = visible;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	public void setSpriteImages(BufferedImage[] spriteImages) {
		this.spriteImages = spriteImages;
	}
	
}