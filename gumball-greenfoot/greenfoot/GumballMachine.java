import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class GumballMachine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GumballMachine extends Actor
{
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
 
    State state = soldOutState;
    int count = 0;
    
    Message m = new Message();
    Actor haveCoin;
    private ArrayList<Picker> pickers = new ArrayList<Picker>();
        
    public GumballMachine(int numberGumballs)
    {
        GreenfootImage image = getImage() ;
        image.scale( 350, 400 ) ; 
            soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);

        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        } 
    }

    private void setMessage (String msg)
    {
        int mouseX, mouseY;
        MouseInfo mouse = Greenfoot.getMouseInfo();
        mouseX=mouse.getX();
        mouseY=mouse.getY();
        World world = getWorld();
        if (m.getWorld()!=null){
            world.removeObject(m);
        }
        world.addObject(m,mouseX,mouseY);
        m.setText(msg);
    }
    public void act() 
    {
                   
            if (Greenfoot.mousePressed(this)){
                turnCrank();
            }
            Actor coin = getOneObjectAtOffset (+10,+10, Coin.class);
            List<Inspector> instruct = null;
            instruct = (List<Inspector>)getWorld().getObjects(Inspector.class);
            Inspector inspector = instruct.get(0);
            
            if (coin != null)
            {
                if (inspector.inspect((Coin)coin)) 
                {
                    insertQuarter();
                    World world = getWorld();
                    world.removeObject(coin);
                    setMessage ("Have coin!");

                }
            }
           
        
    }  
        public void insertQuarter() {
        state.insertQuarter();
    }
 
    public void ejectQuarter() {
        state.ejectQuarter();
    }
 
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    void setState(State state) {
        this.state = state;
    }
 
    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        setMessage ("Gumball released"); 
        
        if (count != 0) {
            count = count - 1;
        }
	       GreenPicker greenPicker = null;
	       RandomPicker randomPicker = null;
	       List<GreenPicker> greenPick = null;
	       List<RandomPicker> randomPick = null;
	            
	       greenPick= (List<GreenPicker>)getWorld().getObjects(GreenPicker.class);
	       greenPicker = (GreenPicker)greenPick.get(0); 
	            
	       randomPick= (List<RandomPicker>)getWorld().getObjects(RandomPicker.class);
	       randomPicker = (RandomPicker)randomPick.get(0);
	       
	       addPicker (greenPicker);
	       addPicker (randomPicker);
	
	       int whichPicker = Greenfoot.getRandomNumber (pickers.size());
	       Picker pickerChosen = pickers.get(whichPicker);
	       System.out.println ("Picker: " + pickerChosen.getClass());
	       pickerChosen.pick();
	       
    
    }
 
    int getCount() {
        return count;
    }
 
    void refill(int count) {
        this.count = count;
        state = noQuarterState;
    }

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }
    
    
    public void addPicker(Picker obj)
    {
        pickers.add(obj);
    }
    
    public void removePicker(Picker obj)
    {
        pickers.remove(obj);
    }
 
}
