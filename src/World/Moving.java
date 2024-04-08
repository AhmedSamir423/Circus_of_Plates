/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package World;

/**
 *
 * @author Youssef
 */

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author HP
 */
public class Moving implements Iterator,Iterable {

    private final List<GameObject> moving ;
    private int index;

    public Moving() {
         this.moving=new LinkedList<>();
         this.index=0;
    }

    public void addObjectToMovingList(GameObject gameObject) {
        moving.add(gameObject);
    }
    
    public int size() {
        return moving.size();
    }

    @Override
    public boolean hasNext() {
       return index<size();
        
    }

    @Override
    public GameObject next() {
        
        return moving.get(index++);
    }


    public void remove(GameObject m) {
        moving.remove(m);
    }
    
    public List<GameObject> getlist(){
        return moving;
    }
    
    @Override
    public Iterator iterator() {
        return moving.iterator();
    }
}