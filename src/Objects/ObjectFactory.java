/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Youssef
 */

    public class ObjectFactory {

   public  Plate_object createObject( int width, int height,String path,int type,String color) {
        
            return new Plate_object(width, height, path, color);
        
    }
   
   public ImageObject createObject(String objectType,int width,int height,String path,int type)
   {
       if(objectType.equals("clown")||objectType.equals("stick"))
            return new clown_object(width, height, path, type);
       
       else return new BombObject(width,height,path,type);
           
   }
}
