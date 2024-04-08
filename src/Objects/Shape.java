/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.Color;
import java.awt.image.BufferedImage;


/**
 *
 * @author Youssef
 */
public class Shape implements GameObject {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private boolean isvisible;
    private BufferedImage[] Image;

    public Shape(int x,int y ,int width,int height,Color c,BufferedImage[] Image) {
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.color=c;
        this.Image=Image;
        this.isvisible=true;
                
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
return y;    }

    @Override
    public void setY(int y) {
this.y=y;    }

    @Override
    public int getWidth() {
return width;    }

    @Override
    public int getHeight() {
return height;    }

    @Override
    public boolean isVisible() {
return isvisible;    }

    @Override
    public BufferedImage[] getSpriteImages() {
return Image;    }
    
    public void setVisible(Boolean visible)
    {
        this.isvisible=visible;
    }
    public Color getColor()
    {
        return this.color;
    }
    
}
