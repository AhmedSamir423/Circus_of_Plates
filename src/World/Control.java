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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Control implements Iterator,Iterable {

    private final List<GameObject> control ;
    private int index;

    public Control() {
         this.control=new LinkedList<>();
         this.index=0;
    }

    public void addObjectToMovingList(GameObject gameObject) {
        control.add(gameObject);
    }
    
    public int size() {
        return control.size();
    }

    @Override
    public boolean hasNext() {
       return index<size();
        
    }

    @Override
    public GameObject next() {
        
        return control.get(index++);
    }


    public void remove(GameObject m) {
        control.remove(m);
    }
    
    public List<GameObject> getlist(){
        return control;
    }
    
    @Override
    public Iterator iterator() {
        return control.iterator();
    }
}

