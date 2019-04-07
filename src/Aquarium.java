/**
 * Fish Tank Makeup Exam
 * CS 3331 Advanced Object Oriented Programming
 * @author Kevin Apodaca
 * @since 4/3/2019
 */

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/** Making the fish swim. */
class Aquarium extends JPanel {

    /* Creating relevant variables and objects. */
        private Fish fish;
        private Timer timer;
        private BufferedImage backgroundImage;
        private Image image;
        private ImageReader imageReader;
       
    
    /**
     * Method that will animate the movement of the fish.
     * @param backgroundPath
     * @param fish
     */
        Aquarium(String backgroundPath, Fish fish){
            try {
                ImageInputStream stream = ImageIO.createImageInputStream(new File(backgroundPath).getAbsoluteFile());
                this.imageReader = ImageIO.getImageReaders(stream).next();
                imageReader.setInput(stream);
                this.backgroundImage = imageReader.read(0,imageReader.getDefaultReadParam());
                this.fish = fish;
                this.timer = new Timer(100, new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        repaint();
                    }
                }
                );
    this.timer.start();
    
            }
            catch(IOException exception){
                exception.printStackTrace();
            }
        }
    
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage.getScaledInstance(600, 300, Image.SCALE_SMOOTH), 0, 0, this);
        }
    
    /**
     * Overriding paint method. Will constantly redraw the fish and update its position on the screen.
     */
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            fish.update();
            fish.draw(g);
        }
    }