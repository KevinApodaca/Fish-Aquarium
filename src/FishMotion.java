/**
 * Fish Tank Makeup Exam
 * CS 3331 Advanced Object Oriented Programming
 * @author Kevin Apodaca
 * @since 4/3/2019
 */

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 * Creating a new class that extends the Fish applet.
 */
public class FishMotion extends Fish {

    private int x, y, xVelocity, yVelocity; // Will be used to determine change in position of the fish.
    private ImageReader imageReader;
    private BufferedImage image;
    private boolean goingRight = true;
    private boolean goingUp = true;

    /**
     * Method will just set the position of the fish.
     * @param dimension
     * @param path
     */
    public FishMotion(Dimension dimension, String path) {
        this(50, 50, dimension, path);
    }

    /**
     * Method similar to the moving ball example from class.
     * @param x
     * @param y
     * @param dimension
     * @param path
     */
    public FishMotion(int x, int y, Dimension dimension, String path) {
        super(dimension);
        this.x = x;
        this.y = y;
        this.xVelocity = 15;
        this.yVelocity = 10;
        try {
            ImageInputStream stream = ImageIO.createImageInputStream(new File(path).getAbsoluteFile());
            this.imageReader = ImageIO.getImageReaders(stream).next();
            imageReader.setInput(stream);
            this.image = imageReader.read(0,imageReader.getDefaultReadParam());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/** Method needs to be overwritten. This method will constantly redraw the images on the JFrame window. */
    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(
            image.getScaledInstance(50, 50, Image.SCALE_SMOOTH), x, y, null);
    }

/** Method will constantly call the update methods of the X and Y positions of the fish on the screen. */
    @Override
    public void update() {
         updateX();
         updateY();
    }

/**
 * Method will update the fish's position along the X axis, constantly checking for collision with the boundaries of the JFrame window.
 */
    private void updateX() {
        if (x < 0)this.goingRight = true;

        if (x > SCREEN_WIDTH)this.goingRight = false;

        if (goingRight)
            x += xVelocity;
        
        else
            x-=xVelocity;
        
    }

/**
 * Method will update the fish's position along the Y axis, constantly checking for collision with the boundaries of the JFrame window.
 */
    private void updateY() {
        if (goingUp) {
            y -= yVelocity;
            goingUp = false;
        }
        else {
            y += yVelocity;
            goingUp = true;
        }
    }

}