/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loudgames.spaceshooter.view;

import com.loudgames.spaceshooter.model.Asteroids;
import com.loudgames.spaceshooter.model.Laser;
import com.loudgames.spaceshooter.model.SpaceShip;
import com.loudgames.spaceshooter.model.Torpedo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 *
 * @author Michael
 */
public class GameDrawingPanel extends JComponent { 
    // Holds every Asteroids I create 
    public static ArrayList<Asteroids> asteroids = new ArrayList<>(); 

    public static Laser getL() {
        return l;
    }

    public  static void setL(Laser aL) {
        l = aL;
    }
    // Get the original x & y points for the polygon 
    int[] polyXArray = Asteroids.sPolyXArray; 
    int[] polyYArray = Asteroids.sPolyYArray; 
    
    
    
    // Create a SpaceShip 
    public static SpaceShip theShip = new SpaceShip(); 
    // Gets the game board height and weight 
    int width = Board.boardWidth; 
    int height =Board.boardHeight; 
    public static Laser l=new Laser();

    // Creates 50 Asteroids objects and stores them in the ArrayList 
    public GameDrawingPanel() {  

        for(int i = 0; i < 15; i++){ 

            // Find a random x & y starting point 
            // The -40 part is on there to keep the Asteroids on the screen 
            int randomStartXPos = (int) (Math.random() * (Board.boardWidth - 40) + 1); 
            int randomStartYPos = (int) (Math.random() * (Board.boardHeight - 40) + 1); 
            // Add the Asteroids object to the ArrayList based on the attributes sent 
            asteroids.add(new Asteroids(Asteroids.getPolyXArray(randomStartXPos), 
                    Asteroids.getPolyYArray(randomStartYPos), 13, randomStartXPos, randomStartYPos)); 
            Asteroids.asteroids=asteroids;
        } 
    }  

    public void paint(Graphics g) {  
        Graphics2D graphicSettings = (Graphics2D)g;  

        AffineTransform identity=new AffineTransform();
        // Draw a black background that is as big as the game board 

        graphicSettings.setColor(Color.BLACK); 

        graphicSettings.fillRect(0, 0, getWidth(), getHeight()); 

        // Set rendering rules 

        graphicSettings.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  
        // Set the drawing color to white 
        graphicSettings.setPaint( Color.WHITE);  
        // Cycle through all of the Asteroids objects 
        for(Asteroids asteroid : asteroids){ 
            if(asteroid.onScreen){
            // Move the Asteroids polygon  
            asteroid.move(theShip,Board.torpedos);  
            // Stroke the polygon Asteroids on the screen 
            graphicSettings.draw(asteroid);  
        }  
        }
        
        if(Board.keyHeldCode==68&&Board.keyHeld==true){
            theShip.increaseRotationAngle();
        }
        else if(Board.keyHeld==true && Board.keyHeldCode==65){
            theShip.decreaseRotationAngle();
        }
        else if(Board.keyHeld==true && Board.keyHeldCode==87){
            theShip.setMovingAngle(theShip.getRotationAngle());
            theShip.increaseXVelocity(theShip.shipXMoveAngle(theShip.getMovingAngle())*0.1);
            theShip.increaseYVelocity(theShip.shipYMoveAngle(theShip.getMovingAngle())*0.1);
        }



//        else if(Board.keyHeld==true && Board.keyHeldCode==83){
//            theShip.setMovingAngle(theShip.getRotationAngle());
//            theShip.decreaseXVelocity(theShip.shipXMoveAngle(theShip.getMovingAngle())*0.1);
//            theShip.decreaseYVelocity(theShip.shipYMoveAngle(theShip.getMovingAngle())*0.1);
//        }
       
        
        theShip.move(); 
        //to rotate the spaceship
        graphicSettings.transform(identity);
        graphicSettings.translate(theShip.getCenterX(),theShip.getCenterY());
        graphicSettings.rotate(Math.toRadians(theShip.getRotationAngle()));
        graphicSettings.draw(theShip); 
        
        
       for(Torpedo torpedo:Board.torpedos)
       {
           torpedo.move();
           if(torpedo.isOnScreen())
           {
           graphicSettings.setTransform(identity);
           graphicSettings.translate(torpedo.getCenterX(), torpedo.getCenterY());
           graphicSettings.draw(torpedo);
//           
           }
       }
       
       if(l.isOnScreen())
       {
       graphicSettings.draw(l);
       }
       
    }  
  
    

} 
