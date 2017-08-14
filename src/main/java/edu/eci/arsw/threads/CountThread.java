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
public class CountThread {
    
    public int ini;
    public int fin;
    
    public CountThread(int ini, int fin){
        this.ini = ini;
        this.fin = fin;
    }
    
    @Override
    public void run(){
        for(int i = ini; i < fin; i++){
            System.out.println(i);
        }
    }

}
