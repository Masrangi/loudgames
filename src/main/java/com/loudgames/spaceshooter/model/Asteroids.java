/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loudgames.spaceshooter.model;

import com.loudgames.spaceshooter.view.Board;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;


/**
 *
 * @author Michael
 */
public class Asteroids extends Polygon {
    //making the variables instances;
    int uLeftXPos,uLeftYPos;
    
    public boolean onScreen=true;
    int xDirection=1;
    int yDirection=1;
    
    int asteroidsWidth=26;
    int asteroidsHeight=31;
   
    public static ArrayList<Asteroids> asteroids = new ArrayList<>(); 
    
    int boardWidth=Board.boardWidth;
    int boardHeight=Board.boardHeight;
    
    int[] polyXArray,plyYArray;
    
    public static int[] sPolyXArray={10,17,26,34,27,36,26,14,8,1,5,1,10};
    public static int[] sPolyYArray={0,5,1,8,13,20,31,28,31,22,16,7,0};
    
    //constructor
    public Asteroids(int[] polyXArray,int[] polyYArray,int pointsInPoly,int randStartXPos,int randStartYPos ){
        //created polygon from super class
        super(polyXArray,polyYArray,pointsInPoly);
        
        //making the random direction
        this.xDirection=(int) (Math.random()*4+1);
        this.yDirection=(int) (Math.random()*4+1);
        
        //assigning the random starting positions
        this.uLeftXPos=randStartXPos;
        this.uLeftYPos=randStartYPos;
    }
    
     public Rectangle getBounds(){
        return new Rectangle(super.xpoints[0],super.ypoints[0],asteroidsWidth,asteroidsHeight);
    }
     
    public void move(SpaceShip theShip,ArrayList<Torpedo> torpedos){
        
        Rectangle checkAsteroid=this.getBounds();
        
        for(Asteroids asteroid:asteroids)
        {
            if(asteroid.onScreen)
        {
            Rectangle otherAsteroid=asteroid.getBounds();
            if(this!=asteroid&& otherAsteroid.intersects(checkAsteroid));{
                int tempXDirection=this.xDirection;
                int tempYDirection=this.yDirection;
                
                this.xDirection=asteroid.xDirection;
                this.yDirection=asteroid.yDirection;
                
                asteroid.xDirection=tempXDirection;
                asteroid.yDirection=tempYDirection;
            }
            
            Rectangle shipBox=theShip.getBounds();
        if(otherAsteroid.intersects(shipBox))
        {
            theShip.setCenterX(this.boardWidth/2);
            theShip.setCenterY(this.boardHeight/2);
            
            theShip.setxVelocity(0);
            theShip.setyVelocity(0);
        }
        
        for(Torpedo torpedo:torpedos)
        {
        if(torpedo.isOnScreen()){
            Rectangle t=torpedo.getBounds();
        if(otherAsteroid.intersects(t)){
        torpedo.setOnScreen(false);
        asteroid.onScreen=false;
        }
        }
        }
        
        }
        }
        
        
        //assigning the positions
        int uLeftXPos=super.xpoints[0];
        int uLeftYPos=super.ypoints[0];
        
        //changing the direction when the asteroids hit the wall
        if(uLeftXPos<0||(uLeftXPos+25)>boardWidth)
            xDirection=-xDirection;
        if(uLeftYPos<0||(uLeftYPos+50)>boardHeight)
            yDirection=-yDirection;
        
       //incrementing the x and y positions
       for(int i=0;i<super.xpoints.length;i++){
        super.xpoints[i]+=xDirection;
        super.ypoints[i]+=yDirection;
        }
        
    }
    
    public static int[] getPolyXArray(int randStartXPos){
        //cloning the sPolyXArray
        int[] temPolyXArray=(int[])sPolyXArray.clone();
        
        for(int i=0;i<temPolyXArray.length;i++){
            temPolyXArray[i]+=randStartXPos;
        }
        return temPolyXArray;
    }
    
    public static int[] getPolyYArray(int randStartYPos){
        //cloning the sPolyXArray
        int[] temPolyYArray=(int[])sPolyYArray.clone();
        
        for(int i=0;i<temPolyYArray.length;i++){
            temPolyYArray[i]+=randStartYPos;
        }
        return temPolyYArray;
    }
}
