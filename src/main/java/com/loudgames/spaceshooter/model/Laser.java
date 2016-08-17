/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loudgames.spaceshooter.model;

import java.awt.Rectangle;

/**
 *
 * @author Michael
 */
public class Laser extends Rectangle{
   
//    private static int[] polyXArray={-3,3,3,-3,-3};
//    private static int[] polyYArray={-3,-3,3,3,-3};
    
    private boolean onScreen=false;

    public Laser(){
    super(11,-3,500,6);
    }

    public boolean isOnScreen() {
        return onScreen;
    }

    public void setOnScreen(boolean aOnScreen) {
        onScreen = aOnScreen;
    }
   
    

}
