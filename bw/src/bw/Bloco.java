/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bw;

/**
 *
 * @author fulviofanelli
 */
public class Bloco {
    
    private int id;
    
    private int linha;
    
    private int col;

    public Bloco(int id) {
        this.id = id;
    }

    public Bloco(int id, int col) {
        this.id = id;
        this.col = col;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
    
    
    
}
