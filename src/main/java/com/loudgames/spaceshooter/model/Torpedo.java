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
public class Torpedo extends Polygon{

    public static int[] getPolyXArray() {
        return polyXArray;
    }

    public static void setPolyXArray(int[] aPolyXArray) {
        polyXArray = aPolyXArray;
    }

    public static int[] getPolyYArray() {
        return polyYArray;
    }

    public static void setPolyYArray(int[] aPolyYArray) {
        polyYArray = aPolyYArray;
    }

    public boolean isOnScreen() {
        return onScreen;
    }

    public void setOnScreen(boolean aOnScreen) {
        onScreen = aOnScreen;
    }

    public double getMovingAngle() {
        return movingAngle;
    }

    public void setMovingAngle(double aMovingAngle) {
        movingAngle = aMovingAngle;
    }
   private double xVelocity=5,yVelocity=5;
   
    private int boardWidth=Board.boardWidth;
    private int boardHeight=Board.boardHeight;
    
    private double centerX=0, centerY=0;
   
    private static int[] polyXArray={-3,3,3,-3,-3};
    private static int[] polyYArray={-3,-3,3,3,-3};
    
    private int torpedoWidth=6,torpedoHeight=6;
    
    private boolean onScreen=false;
    private static double movingAngle=0;
    
    public Torpedo(double centerX,double centerY,double movingAngle){
    super(polyXArray,polyYArray,5);
    
    this.centerX=centerX;
    this.centerY=centerY;
    this.movingAngle=movingAngle;
    
    this.onScreen=true;
    
    this.setxVelocity(this.torpedoXMoveAngle(movingAngle)*5);
    this.setyVelocity(this.torpedoYMoveAngle(movingAngle)*5);
    
     }
    
    public void increaseXPos(double incAmt){this.centerX+=incAmt;}
    public void increaseYPos(double incAmt){this.centerY+=incAmt;}
    
    public Rectangle getBounds(){
        return new Rectangle((int)getCenterX()-3,(int)getCenterY()-3,getTorpedoWidth(),getTorpedoHeight());
    }
    
    public void move(){
    if(isOnScreen())
    {
    this.increaseXPos(this.getxVelocity());
    
    if(this.getCenterX()<0)
        this.setOnScreen(false);
    else if(this.getCenterX()>this.getBoardWidth())
        this.setOnScreen(false);
    
    this.increaseYPos(this.getyVelocity());
    
    if(this.getCenterY()<0)
        this.setOnScreen(false);
    else if(this.getCenterY()>this.getBoardHeight())
        this.setOnScreen(false);
    }
    }
    
    public double getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }

    public double getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public void setBoardWidth(int boardWidth) {
        this.boardWidth = boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public void setBoardHeight(int boardHeight) {
        this.boardHeight = boardHeight;
    }

    public double getCenterX() {
        return centerX;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    public int getTorpedoWidth() {
        return torpedoWidth;
    }

    public void setTorpedoWidth(int torpedoWidth) {
        this.torpedoWidth = torpedoWidth;
    }

    public int getTorpedoHeight() {
        return torpedoHeight;
    }

    public void setTorpedoHeight(int torpedoHeight) {
        this.torpedoHeight = torpedoHeight;
    }
    
    public double torpedoXMoveAngle(double xMoveAngle){
        return (double)Math.cos(xMoveAngle+Math.PI/180);
    }
    
    public double torpedoYMoveAngle(double yMoveAngle){
        return (double)Math.sin(yMoveAngle+Math.PI/180);
    }
}
