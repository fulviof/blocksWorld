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
public class List {
    
    ArrayList<MatrizAux> fila;

    public List() {
        fila = new ArrayList();
    }

    public ArrayList<MatrizAux> getFila() {
        return fila;
    }

    public void setFila(ArrayList<MatrizAux> fila) {
        this.fila = fila;
    }
      
    public void enqueue(MatrizAux item)
    {       
        if(fila.isEmpty())
            fila.add(item);
        else
        {
            for (int i = 0; i < fila.size(); i++)
            {
                if(item.getHeurist() <= fila.get(i).getHeurist())
                {
                    fila.add(i, item);
                    i = fila.size();
                }
            }
        }
    }
    
    public MatrizAux dequeue()
    {
        return fila.remove(0);
    }

}
