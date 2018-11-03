/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bw;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fulviofanelli
 */
public class MatrizAux {
    
    ArrayList<Matriz> caminho;
    Matriz matriz;
    int heurist;
    int distancia;
    

    public MatrizAux(ArrayList<Matriz> caminho, int heurist, int distancia, Matriz m) {
        this.caminho = caminho;
        this.heurist = heurist;
        this.distancia = distancia;
        this.matriz = m;
    }

    public MatrizAux() {
        caminho = new ArrayList();
        heurist = 0;
        distancia = 0;
        this.matriz = new Matriz();
    }

    public Matriz getMatriz() {
        return matriz;
    }

    public void setMatriz(Matriz matriz) {
        this.matriz = matriz;
    }
    
    public ArrayList<Matriz> getCaminho() {
        return caminho;
    }

    public void setCaminho(ArrayList<Matriz> caminho) {
        this.caminho = caminho;
    }

    public void addCaminho(Matriz caminho) {
        this.caminho.add(caminho);
    }

    public int getHeurist() {
        return heurist;
    }

    public void setHeurist(int heurist) {
        this.heurist = heurist;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
    
    
    
}
