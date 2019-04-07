/**
 * Fish Tank Makeup Exam
 * CS 3331 Advanced Object Oriented Programming
 * @author Kevin Apodaca
 * @since 4/3/2019
 */

import java.awt.Graphics;
import javax.swing.JFrame;

/**
 * Main method will create the window of size 600,300 and add the relevant images. Method will call other methods that 
 *  will take care of animating the fish and repainting.
 */

class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame(); // creating the new JFrame window.
        frame.setSize(600, 300);
        frame.add(new Aquarium("../images/background.png",
         new FishMotion(50,200,frame.getSize(),"../images/squid.png")));    // calls the background and the squid images from the images directory.
        frame.setVisible(true); // to be able to see the GUI.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ensures window can be closed.
    
    }
}