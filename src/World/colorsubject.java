/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package World;

/**
 *
 * @author Youssef
 */
public class colorsubject {
    ScoreObserver score;

    public colorsubject(ScoreObserver score) {
        this.score = score;
    }
    public void notifyobserver()
    {
       score.updatescore();
    }
    public int getstate(){
        return score.getScore();
    }
    
}
