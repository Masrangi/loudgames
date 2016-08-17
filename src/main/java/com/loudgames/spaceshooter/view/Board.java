/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loudgames.spaceshooter.view;

import com.loudgames.spaceshooter.controllers.BoardController;
import com.loudgames.spaceshooter.model.Asteroids;
import com.loudgames.spaceshooter.model.SpaceShip;
import com.loudgames.spaceshooter.model.Torpedo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 *
 * @author Michael
 */
public class Board extends JFrame{
    public static int boardWidth=1000;
    public static int boardHeight=720;
    
    public static boolean keyHeld=false;
    public static int keyHeldCode;
    public static ArrayList<Torpedo> torpedos=new ArrayList();

    public ArrayList<Torpedo> getTorpedos() {
        return torpedos;
    }

    public void setTorpedos(ArrayList<Torpedo> aTorpedos) {
        torpedos = aTorpedos;
    }
    
   
    
    public Board(){
    this.setSize(boardWidth,boardHeight);
    this.setTitle("SpaceShooter");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    addKeyListener(new BoardController());
    
    GameDrawingPanel gamePanel=new GameDrawingPanel();
    this.add(gamePanel,BorderLayout.CENTER);
    
    ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);
    executor.scheduleAtFixedRate(new RepaintTheBoard(this), 0L, 10L, TimeUnit.MILLISECONDS); 
    this.setVisible(true); 

    }
}
// Class implements the runnable interface 

// By creating this thread we can continually redraw the screen 

// while other code continues to execute  
class RepaintTheBoard implements Runnable{ 
    Board theBoard;
    public RepaintTheBoard(Board theBoard){ 
        this.theBoard = theBoard; 
    } 
    @Override 
    public void run() { 
        // Redraws the game board  
        theBoard.repaint(); 
    }
} 