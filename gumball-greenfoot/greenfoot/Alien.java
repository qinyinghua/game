import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alien extends Actor
{
    Message m = new Message();
    
    public Alien()
    {
        GreenfootImage image = getImage() ;
        image.scale( 150, 180 ) ; 
    }
    
    protected void setMessage( String msg ) 
    {
         
        int X, Y ;
        m.setText( msg );
        X=getX(); // i am getting error in this line
        Y=getY();
        World world = getWorld();
         
        if ( m.getWorld() != null )
        {
            world.removeObject( m ) ;
            return;
        }
        world.addObject(m, X,Y ) ;
             
    }

    public void act() 
    {
        // Add your action code here.
    }    
}
