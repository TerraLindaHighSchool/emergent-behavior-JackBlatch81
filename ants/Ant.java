import greenfoot.*;

/**
 * An ant that collects food.
 * 
 * @author Michael Kölling
 * @version 0.1
 */
public class Ant extends Creature
{
    private boolean carryingFood;
    private int MAX_PH_AVAILABLE = 16;
    private int TIME_FOLLOWING_TRIAL = 30;
    private GreenfootImage image1;
    private GreenfootImage image2;
    private int phAvailable, followTrialTimeRemaining;
    
    /**
     * Create an ant with a given home hill. The initial speed is zero (not moving).
     */
    public Ant(AntHill home)
    {
        setHomeHill(home);
        
        phAvailable = MAX_PH_AVAILABLE;
        followTrialTimeRemaining = 0;
        
        image1 = getImage();
        image2 = new GreenfootImage("ant-with-food.gif");
    }

    /**
     * Do what an ant's gotta do.
     */
    public void act()
    {
        checkForFood(); 
        status();
        walkTowardsPheromoneCenter();
        searchForFood();
        handlePheromoneDrop();
        smellsPhero```1awsqzE2S``````1`mone();
    }
    
    private void checkForFood()
    {
        Food food = (Food) getOneIntersectingObject(Food.class);
        if (food != null) 
        {
            food.removeCrumb();
            carryingFood = true;
            setImage(image2);
        }
    }
    
    private boolean atHome()
    {
        if(getHomeHill() != null)
        {
            return (Math.abs(getX() - getHomeHill().getX()) < 4) &&
                   (Math.abs(getY() - getHomeHill().getY()) < 4);
        }
        else{
            return false;
        }
    }
    
    private void searchForFood()
    {
        if(followTrialTimeRemaining == 0)
        {
            walkTowardsPheromoneCenter();
            randomWalk();
        }
        else
        {
            followTrialTimeRemaining--;
            walkAwayFromHome();
        }
        checkForFood();
    }
    
    private void status()
    {
       if(carryingFood == true)
        {
           walkTowardsHome();
           handlePheromoneDrop();
           
           if(atHome())
           {   
               setImage(image1);
               carryingFood = false;
               getHomeHill().countFood();
               }
        } 
        else{
            searchForFood();
        }
    }
    
    private void handlePheromoneDrop()
    {
        if (MAX_PH_AVAILABLE == 16)
        {
            Pheremone ph = new Pheremone();
            getWorld().addObject(ph, getX(), getY());
            phAvailable = 0;
        }
        else
        {
            phAvailable++;
        }
        status();
    }
    
    private boolean smellsPheromone()
    {
       if(isTouching(Pheremone.class))
       {
           return true;
       }
       else
       {
           return false;
       }
    }
    
    private void walkTowardsPheromoneCenter()
    {
        Pheremone pheremone = (Pheremone) getOneIntersectingObject(Pheremone.class);
        if (pheremone != null)
        {
            headTowards(pheremone);
            if (getX() == pheremone.getX() && getY() == pheremone.getY())
            {
                followTrialTimeRemaining = TIME_FOLLOWING_TRIAL;
            }
        }
    }
}