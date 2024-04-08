/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package World;

import Objects.BombObject;
import Objects.ImageObject;
import Objects.ObjectFactory;
import Objects.Plate_object;
import Objects.SoundManager;
import Objects.clown_object;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import Strategy.*;
import java.util.Iterator;
import java.util.ListIterator;
import javax.swing.JOptionPane;

/**
 *
 * @author Youssef
 */
public class Clown_world implements World {

    private static int MAX_TIME = 1 * 60 * 1000; // 1 minute

   private boolean gameoverSoundPlayed = false;
    private int score = 0;
    private int numofstack1 = 0;
    private int numofstack2 = 0;
    private int choice;
    private Level currentLevel;
    private long startTime = System.currentTimeMillis();
    private final int width;
    private final int height;
    private Moving moving = new Moving();
    private Control control = new Control();
    private constant Constant=new constant();
    private final Stack<GameObject> stack1 = new Stack<GameObject>();
    private final Stack<GameObject> stack2 = new Stack<GameObject>();
    //private final List<GameObject> constant = new LinkedList<GameObject>();
    
    //private final List<GameObject> moving = new LinkedList<GameObject>();
    //private final List<GameObject> control = new LinkedList<GameObject>();
    ObjectFactory of = new ObjectFactory();
    static Clown_world instance = null;
    colorsubject color = new colorsubject(new ScoreObserver());
    int j1 = 10;
    int j2 = 10;

    public static Clown_world get_instance(int screenWidth, int screenHeight) {
        if (instance == null) {
            instance = new Clown_world(screenWidth, screenHeight);
        }
        return instance;
    }

    public final void leveldecide() {
        if (currentLevel == Level.EASY) {
            ((ImageObject) moving.getlist().get(moving.size() - 1)).setMovementStrategy(new EasyMovementStrategy());
        } else if (currentLevel == Level.MEDIUM) {
            ((ImageObject) moving.getlist().get(moving.size() - 1)).setMovementStrategy(new MediumMovementStrategy());
        } else {
            ((ImageObject) moving.getlist().get(moving.size() - 1)).setMovementStrategy(new HardMovementStrategy());
        }
    }

    private Clown_world(int screenWidth, int screenHeight) {
        width = screenWidth;
        height = screenHeight;

        do {
            String[] options = {"Easy", "Medium", "Hard"};
            choice = JOptionPane.showOptionDialog(null, "Choose the game level", "Game Level",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        } while (choice != 0 && choice != 1 && choice != 2);

        switch (choice) {
            case 0:
                currentLevel = Level.EASY;
                break;
            case 1:
                currentLevel = Level.MEDIUM;
                break;
            case 2:
                currentLevel = Level.HARD;
                break;
            default:
                // Default to easy if the user closes the dialog
                currentLevel = Level.EASY;
                break;
        }
        ImageObject background = new ImageObject(0, 0, "\\background2.jpg");
        background.setVisible(true);
        Constant.addObjectToConstantList(background);
        ImageObject explosion = new ImageObject(0, 0, "\\explosion.png");
        explosion.setVisible(false);
        Constant.addObjectToConstantList(explosion);

        clown_object clown = (clown_object) of.createObject("clown", screenWidth / 3, (int) (screenHeight * 0.75), "\\clown2.png", 0);
        control.addObjectToMovingList(clown); // Add the clown to the control list
        clown_object leftstick = (clown_object) of.createObject("stick", clown.getX() + 15, clown.getY() - 35, "\\stick.png", 1);
        control.addObjectToMovingList(leftstick); // Add the left stick to the control list
        clown_object rightstick = (clown_object) of.createObject("stick", clown.getX() + 80, clown.getY() - 25, "\\stick.png", 2);
        control.addObjectToMovingList(rightstick); // Add the right stick to the control list

        for (int i = 0; i < 3; i++) {
            moving.addObjectToMovingList((BombObject) of.createObject("bomb", (int) (width * 0.9 * Math.random()), (int) (0 - 4000 * Math.random()), "\\bomb2.png", 0));
            leveldecide();
        }
        for (int i = 0; i < 10; i++) {
            moving.addObjectToMovingList(of.createObject((int) (Math.random() * 0.9 * width), (int) (0 - 4000 * Math.random()), "\\plate1.png", 0, "red"));
            leveldecide();
            moving.addObjectToMovingList(of.createObject((int) (Math.random() * 0.9 * width), (int) (0 - 4000 * Math.random()), "\\plate2.png", 0, "blue"));
            leveldecide();
            moving.addObjectToMovingList(of.createObject((int) (Math.random() * 0.9 * width), (int) (0 - 4000 * Math.random()), "\\plate3.png", 0, "green"));
            leveldecide();
        }
    }

    @Override
    public int getSpeed() {
        return 20;
    }

    @Override
    public int getControlSpeed() {
        return 10;
    }

    @Override
    public List<GameObject> getConstantObjects() {
        return Constant.getlist();
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return moving.getlist();
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return  control.getlist();
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public String getStatus() {
        return "Score=" + color.getstate() + "   |   Time="
                + Math.max(0, (MAX_TIME - (System.currentTimeMillis() - startTime)) / 1000); // update status
    }

    private boolean intersect(GameObject o1, GameObject o2) {
        Boolean m = (Math.abs((o1.getX() + o1.getWidth() / 2) - (o2.getX() + o2.getWidth() / 2)) <= o1.getWidth() / 2)
                && (((o1.getY() + o1.getHeight() / 2) - (o2.getY() + o2.getHeight() / 2)) <= o1.getHeight() / 2);
        if (o2 instanceof Plate_object && o2.getY() > o1.getY()) {
            m = false;
        }
        return m;
    }

    @Override
    public boolean refresh() {
        boolean timeout = System.currentTimeMillis() - startTime > MAX_TIME;
        ImageObject clown = (ImageObject) control.getlist().get(0);

        ListIterator it = (ListIterator) moving.iterator();
        ListIterator it1=(ListIterator) control.iterator();
       
        while (it1.hasNext()) {
            GameObject o= (GameObject) it1.next();
            int type = ((ImageObject) o).getType();
            if (type == 1) {
                o.setX(clown.getX() + 15);
            }
            if (type == 2) {
                o.setX(clown.getX() + 80);
            }
        }

        while (it.hasNext()) {
            ImageObject o = (ImageObject) it.next();
           ListIterator it2=(ListIterator) control.iterator();
            while (it2.hasNext()) {
                 
                GameObject o1 =  (GameObject) it2.next();
                
                if (o instanceof BombObject && intersect(clown, o)) {
                     if (!gameoverSoundPlayed) {
                        SoundManager.playGameOverSound();
                        gameoverSoundPlayed = true;
                    }
                    
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                   
                    return false;
                }
                
              
                if (intersect(o1, o) && ((ImageObject) o1).getType() != 0 && o instanceof Plate_object) {
                   
                    it2.add(o);
                    it.remove();

                    if (((ImageObject) o1).getType() == 1) {
                        o.setY(o1.getY() - j1);
                        o.setX(o1.getX());
                        j1 += 10;

                        stack1.add(o);
                        if (checkStack(stack1)) {
                            SoundManager.playScoreSound();
                            color.notifyobserver();
                            for (int i = 0; i < 3; i++) {
                                GameObject s = stack1.pop();
                                it.add(s);
                                int flag1=0;
                                while(it2.hasPrevious())
                                {
                                    it2.previous();
                                }
                                while(flag1==0)
                                {    
                                    if(it2.next().equals(s))
                                    {
                                        it2.remove();
                                        flag1=1;
                                    }
                                        
                                    
                                }
                               
                                 

                                s.setY((int) (0 - 2000 * Math.random()));
                                s.setX((int) (width * 0.9 * Math.random()));
                                j1 += -10;
                            }
                        }
                        numofstack1++;
                    } else {
                        o.setY(o1.getY() - j2);
                        o.setX(o1.getX());
                        j2 += 10;

                        stack2.add(o);

                        if (checkStack(stack2)) {
                            color.notifyobserver();
                            SoundManager.playScoreSound();
                            for (int i = 0; i < 3; i++) {
                                GameObject s = stack2.pop();
                               
                                it.add(s);
                                int flag2=0;
                                 while(it2.hasPrevious())
                                {
                                    it2.previous();
                                }
                                while(flag2==0)
                                {
                                    
                                    if(it2.next().equals(s))
                                    {
                                        it2.remove();
                                        flag2=1;
                                    }
                                        
                                    
                                }

                                s.setY((int) (0 - 1000 * Math.random()));
                                s.setX((int) (width * 0.9 * Math.random()));
                                j2 += -10;
                            }
                        }
                        numofstack2++;
                    }
                }

                if (getHeight() - 3 <= o.getY()) {
                    o.setY((int) (0 - 1000 * Math.random()));
                    o.setX((int) (Math.random() * 0.9 * getWidth()));
                }
            }
            ((ImageObject) o).move();
        }
        return !timeout;
    }

    public boolean checkStack(Stack<GameObject> stack) {
        if (stack.size() < 3) {
            return false;
        }
        GameObject o1 = stack.get(stack.size() - 1);
        GameObject o2 = stack.get(stack.size() - 2);
        GameObject o3 = stack.get(stack.size() - 3);
        return (((Plate_object) o1).getColor().equals(((Plate_object) o2).getColor())
                && ((Plate_object) o1).getColor().equals(((Plate_object) o3).getColor()));
    }
}
