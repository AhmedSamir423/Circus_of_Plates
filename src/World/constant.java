/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package World;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Youssef
 */
public class constant implements Iterator,Iterable {

    private final List<GameObject> constant ;
    private int index;

    public constant() {
         this.constant=new LinkedList<>();
         this.index=0;
    }

    public void addObjectToConstantList(GameObject gameObject) {
        constant.add(gameObject);
    }
    
    public int size() {
        return constant.size();
    }

    @Override
    public boolean hasNext() {
       return index<size();
        
    }

    @Override
    public GameObject next() {
        
        return constant.get(index++);
    }


    public void remove(GameObject m) {
        constant.remove(m);
    }
    
    public List<GameObject> getlist(){
        return constant;
    }
    
    @Override
    public Iterator iterator() {
        return constant.iterator();
    }
}

