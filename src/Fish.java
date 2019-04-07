/**
 * Fish Tank Makeup Exam
 * CS 3331 Advanced Object Oriented Programming
 * @author Kevin Apodaca
 * @since 4/3/2019
 */

import java.awt.Dimension;
import java.awt.Graphics;

/* Motion for the fish, swimming animations. */
public abstract class Fish {
    
    protected final double SCREEN_WIDTH, SCREEN_HEIGHT;

    public Fish(Dimension dimension){
        SCREEN_HEIGHT = dimension.getHeight();
        SCREEN_WIDTH = dimension.getWidth();
    }
    public abstract void draw(Graphics graphics);

    public abstract void update();  // calls update for animations.
}
