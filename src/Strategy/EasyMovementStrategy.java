/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Strategy;

/**
 *
 * @author Youssef
 */
import eg.edu.alexu.csd.oop.game.GameObject;


import Objects.BombObject;
import Objects.Plate_object;
public class EasyMovementStrategy implements MovementStrategy {

    @Override
    public void move(GameObject gameObject) {
        if (gameObject instanceof BombObject) {
            
            int speed = 5;
            gameObject.setY(gameObject.getY() + speed);
        } else if (gameObject instanceof Plate_object) {
            int speed = 3;
            gameObject.setY(gameObject.getY() + speed);
        } else {
        }
       
    }
}

