/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

/**
 *
 * @author hcadavid
 */
public class CountThreadsMain {
    
    public static void main(String a[]){
        Thread uno = new CountThread(0,9999);
        Thread dos = new CountThread(100000,19999);
        Thread tres = new CountThread(20000,29999);
        
        uno.start();
        dos.start();
        tres.start();
    }
    
}
