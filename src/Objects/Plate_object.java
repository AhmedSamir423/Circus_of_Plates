/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

/**
 *
 * @author Youssef
 */
public class Plate_object extends ImageObject {
    
    private String color;
    public Plate_object(int posX, int posY, String path,String color) {
        super(posX, posY, path,0);
        this.color=color;
        
    }
    
    
    public Plate_object(int posX, int posY, String path, int type,String color) {
        super(posX, posY, path, type);
        this.color=color;
    }
    public String getColor(){
        return color;
    }
    public void setY()
    {
        
    }
    
    
}
