/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loudgames.spaceshooter.controllers;

import com.loudgames.spaceshooter.model.Laser;
import com.loudgames.spaceshooter.model.Torpedo;
import com.loudgames.spaceshooter.view.Board;
import com.loudgames.spaceshooter.view.GameDrawingPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.net.*;
import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;

/**
 *
 * @author Michael
 */
public class BoardController implements KeyListener{
    
    
    @Override
    public void keyTyped(KeyEvent e) {
  
    }

    @Override
    public void keyPressed(KeyEvent e) {
          if(e.getKeyCode()==87){
       System.out.println("you pressed up w");
       Board.keyHeld=true;
       Board.keyHeldCode=e.getKeyCode();
       }
       else if(e.getKeyCode()==65){
       System.out.println("you pressed left a");
       Board.keyHeld=true;
       Board.keyHeldCode=e.getKeyCode();
       }
       else if(e.getKeyCode()==83){
       System.out.println("you pressed down s");
       Board.keyHeld=true;
       Board.keyHeldCode=e.getKeyCode();
       }
       else if(e.getKeyCode()==68){
       System.out.println("you pressed right d");
       Board.keyHeld=true;
       Board.keyHeldCode=e.getKeyCode();
       }
       else if(e.getKeyCode()==KeyEvent.VK_ENTER)
       {
           System.out.println("you pressed enter");
       Board.torpedos.add(new Torpedo(GameDrawingPanel.theShip.getShipNoseX(),GameDrawingPanel.theShip.getShipNoseY(),
       GameDrawingPanel.theShip.getRotationAngle()));
       }
        else if(e.getKeyCode()==KeyEvent.VK_SPACE)
       {
           System.out.println("you pressed spacebar");
           GameDrawingPanel.l.setOnScreen(true);
       }   
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //w=87,a=65,s=83,d=68
//       if(e.getKeyCode()==87){
//       System.out.println("you pressed up w");
//       }
//       else if(e.getKeyCode()==65){
//       System.out.println("you pressed left a");
//       }
//       else if(e.getKeyCode()==83){
//       System.out.println("you pressed down s");
//       }
//       else if(e.getKeyCode()==68){
//       System.out.println("you pressed right d");
//       }
        Board.keyHeld=false;
    }
    
//    public void playSoundEffects(String name){
//    URL soundLocation;
//            try{
//            Clip clip=null;
//            clip=AudioSystem.getClip();
//            AudioInputStream audioStream;
//            audioStream=AudioSystem.getAudioInputStream(soundLocation);
//            clip.open(audioStream);
//            clip.loop(0);
//            clip.start();
//            }
//            catch(Exception ex)
//            {
//            
//            }
//          
//    }
}
