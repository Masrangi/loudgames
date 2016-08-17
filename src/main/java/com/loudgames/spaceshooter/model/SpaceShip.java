/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loudgames.spaceshooter.model;

import com.loudgames.spaceshooter.view.Board;
import java.awt.Polygon;
import java.awt.Rectangle;

/**
 *
 * @author Michael
 */
public class SpaceShip extends Polygon {

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

    public int getRotationAngle() {
        return rotationAngle;
    }

    public void setRotationAngle(int aRotationAngle) {
        rotationAngle = aRotationAngle;
    }

    public int getMovingAngle() {
        return movingAngle;
    }

    public void setMovingAngle(int aMovingAngle) {
        movingAngle = aMovingAngle;
    }
    
   
    
   private int xDirection=0;
   private int yDirection=0;
    
   private double xVelocity=0,yVelocity=0;
   
    private int boardWidth=Board.boardWidth;
    private int boardHeight=Board.boardHeight;
    
    private double centerX=boardWidth/2, centerY=boardHeight/2;
   
    private static int[] polyXArray={-13,14,-13,-5,-13};
    private static int[] polyYArray={-15,0,18,0,-15};
    
    private int shipWidth=27,shipHeight=30;
    private double uLeftXPos=getCenterX()+this.polyXArray[0];
   private double uLeftYPos=getCenterY()+this.polyYArray[0];; 
    
//    public static int[] polyXArray={500,527,500,508,500};
//    public static int[] polyYArray={400,415,430,415,400};
    
    
    
    private static int rotationAngle=0,movingAngle=0;
    
    public SpaceShip(){
    super(polyXArray,polyYArray,5);
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

    public int getxDirection() {
        return xDirection;
    }

    public void setxDirection(int xDirection) {
        this.xDirection = xDirection;
    }

    public int getyDirection() {
        return yDirection;
    }

    public void setyDirection(int yDirection) {
        this.yDirection = yDirection;
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

    public int getShipWidth() {
        return shipWidth;
    }

    public void setShipWidth(int shipWidth) {
        this.shipWidth = shipWidth;
    }

    public int getShipHeight() {
        return shipHeight;
    }

    public void setShipHeight(int shipHeight) {
        this.shipHeight = shipHeight;
    }

    public double getuLeftXPos() {
        return uLeftXPos;
    }

    public void setuLeftXPos(double uLeftXPos) {
        this.uLeftXPos = uLeftXPos;
    }

    public double getuLeftYPos() {
        return uLeftYPos;
    }

    public void setuLeftYPos(double uLeftYPos) {
        this.uLeftYPos = uLeftYPos;
    }
    
    public void increaseXPos(double incAmt){this.centerX+=incAmt;}
    public void increaseYPos(double incAmt){this.centerY+=incAmt;}
    
    public void increaseXVelocity(double incVelocity){
            this.xVelocity+=incVelocity;}
    public void increaseYVelocity(double incVelocity){
            this.yVelocity+=incVelocity;}
    
//    public void decreaseXVelocity(double incVelocity){
//        if(xVelocity>0)
//        this.xVelocity-=incVelocity;
//        else
//            this.xVelocity=0;
//    }
//    public void decreaseYVelocity(double incVelocity){
//        if(yVelocity>0)
//        this.yVelocity-=incVelocity;
//        else
//            this.yVelocity=0;
//    }
    
    public double shipXMoveAngle(double xMoveAngle){
        return (double)Math.cos(xMoveAngle+Math.PI/180);
    }
    
    public double shipYMoveAngle(double yMoveAngle){
        return (double)Math.sin(yMoveAngle+Math.PI/180);
    }
    
    public void increaseRotationAngle(){
    if(getRotationAngle()>=355){rotationAngle=0;}
    else{rotationAngle+=5;}
    }
    public void decreaseRotationAngle(){
    if(getRotationAngle()<0){rotationAngle=355;}
    else{rotationAngle-=5;}
    }
    
    public Rectangle getBounds(){
        return new Rectangle((int)getCenterX()-14,(int)getCenterY()-15,getShipWidth(),getShipHeight());
    }
    
    public double getShipNoseX(){
        return this.getCenterX()+Math.cos(this.getRotationAngle()*14);
    }
    
    public double getShipNoseY(){
        return this.getCenterY()+Math.sin(this.getRotationAngle()*14);
    }
    
         public void move(){
             this.increaseXPos(this.getxVelocity());
             
             if(getCenterX()<0){setCenterX(this.boardWidth);}
             else if(getCenterX()>this.boardWidth){setCenterX(0);}
             
             this.increaseYPos(this.getyVelocity());
             
             if(getCenterY()<0){setCenterY(this.boardHeight);}
             else if(getCenterY()>this.boardHeight){setCenterY(0);}
             
//        //assigning the positions
//        int uLeftXPos=super.xpoints[0];
//        int uLeftYPos=super.ypoints[0];
//        
//        //changing the direction when the asteroids hit the wall
//        if(uLeftXPos<0||(uLeftXPos+25)>boardWidth)
//            xDirection=-xDirection;
//        if(uLeftYPos<0||(uLeftYPos+50)>boardHeight)
//            yDirection=-yDirection;
//        
//       //incrementing the x and y positions
//       for(int i=0;i<super.xpoints.length;i++){
//        super.xpoints[i]+=xDirection;
//        super.ypoints[i]+=yDirection;
//        }
    
        super.xpoints=SpaceShip.polyXArray;
        super.ypoints=SpaceShip.polyYArray;
    }
}
