import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * The world where ants live.
 * 
 * @author Michael Kölling
 * @version 0.1
 */
public class AntWorld extends World
{
    public static final int SIZE = 640;

    /**
     * Create a new world. It will be initialised with a few ant hills
     * and food sources
     */
    public AntWorld()
    {
        super(SIZE, SIZE, 1);
        setPaintOrder(Ant.class, AntHill.class);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        AntHill antHill = new AntHill();
        addObject(antHill,298,178);
        AntHill antHill2 = new AntHill();
        addObject(antHill2,470,357);
        AntHill antHill3 = new AntHill();
        addObject(antHill3,7,466);
        antHill3.setLocation(94,465);
        AntHill antHill4 = new AntHill();
        addObject(antHill4,556,112);
        AntHill antHill5 = new AntHill();
        addObject(antHill5,293,564);
        antHill.setLocation(157,73);
        antHill5.setLocation(267,232);
        antHill2.setLocation(522,481);
        antHill3.setLocation(148,554);
        antHill5.setLocation(178,311);
        antHill5.setLocation(327,286);
        antHill.setLocation(159,176);
        antHill4.setLocation(488,87);
        Food food = new Food();
        addObject(food,524,263);
        Food food2 = new Food();
        addObject(food2,335,411);
        Food food3 = new Food();
        addObject(food3,364,550);
        removeObject(antHill2);
        removeObject(antHill3);
        removeObject(antHill5);
        food2.setLocation(189,411);
        food3.setLocation(477,471);
        Food food4 = new Food();
        addObject(food4,370,364);
        antHill.setLocation(326,520);
        food4.setLocation(141,144);
        food2.setLocation(181,416);
        food2.setLocation(298,262);
        food.setLocation(109,384);
        food3.setLocation(472,357);
    }
}
