import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Inspector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inspector extends Alien
{
    public void update(Coin coin){
        
       inspect(coin);
     }
     
    public boolean inspect( Coin coin )
    {
       //setMessage(coin.getClass().getName()) ;// Calling method of base class
       if (coin.getClass() == Quarter.class)
       {
       	 setMessage ("Have coin!");
         return true;
       }
       else if (coin.getClass() == Penny.class) 
       {
         setMessage ("Penny!");
       }
       else if (coin.getClass() == FakeQuarter.class)
       {
       	 setMessage ("Fake Coin! "); 
       } 
       return false;
    }
        
    /**
     * Act - do whatever the Inspector wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
