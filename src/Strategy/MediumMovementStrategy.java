/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Strategy;

import Objects.BombObject;
import Objects.Plate_object;
import eg.edu.alexu.csd.oop.game.GameObject;

/**
 *
 * @author Youssef
 */
public class MediumMovementStrategy implements MovementStrategy {

    @Override
    public void move(GameObject gameObject) {
        if (gameObject instanceof BombObject) {
            
            int speed = 10;
            gameObject.setY(gameObject.getY() + speed);
        } else if (gameObject instanceof Plate_object) {
            
            int speed = 7;
            gameObject.setY(gameObject.getY() + speed);
        }
       
    }
    
}

