/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bw;

import java.util.*;

/**
 *
 * @author fulviofanelli
 */
public class Bw {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner ler = new Scanner(System.in);
        
        
        Matriz mStart = new Matriz();
        mStart.push(new Bloco(1, 0));
        mStart.push(new Bloco(2, 0));

        mStart.exibir();
        
        Matriz mGoal = new Matriz();
        mGoal.push(new Bloco(2, 4));
        mGoal.push(new Bloco(1, 4));
        
        mGoal.exibir();
        
        System.out.println(mStart.getTopo(0));
        
        mStart.solucionar(mGoal);
    }
    
    
    public static void mover(Bloco start[][], Bloco goal[][])
    {
        
    }
    
}
