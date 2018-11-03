/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bw;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author fulviofanelli
 */
public class Matriz implements Constantes {
    
    private Bloco matriz[][]; 
    
    public Matriz() {
        this.matriz = new Bloco[MAX_LINHAS][MAX_COLUNAS];
    }
    
    public Bloco[][] get()
    {
        return this.matriz;
    }
    
    public Bloco getBloco(int linha, int col) {
        return matriz[linha][col];
    }
    
    public void setBloco(Bloco b, int lin, int col)
    {
        this.matriz[lin][col] = b;
    }

    public void push(Bloco b) {
        matriz[getLinha(b.getCol())][b.getCol()] = b;
    }
    
    public int getLinha(int col)
    {
        for (int i = 0; i < MAX_LINHAS; i++) 
        {
            if(i == MAX_LINHAS-1)
                return i;
            else
                if(matriz[i+1][col] != null)
                    return i;
        }
        
        return -1;
    }
    
    public Bloco pop(int col)
    {        
        int linha = getLinha(col)-1;
        
        if(col >= 0 && linha >= 0)
        {
            Bloco b = matriz[linha][col];
            matriz[linha][col] = null;
            
            return b;
        }
        return null;
    }
    
    public Bloco getTopo(int col)
    { 
        int linha = getLinha(col);
        
        if(col >= 0 && linha >= 0){
            Bloco b = matriz[linha][col];
            
            return b;
        }
        return null;
    }
    
    public void exibir()
    {
        for (int i = 0; i < MAX_LINHAS; i++) 
        {
            for (int j = 0; j < MAX_COLUNAS; j++) 
            {
                if(matriz[i][j] != null)
                    System.out.print("_"+matriz[i][j].getId()+"|");
                else
                    System.out.print("__|");
            }
            System.out.print("\n");
        }
        System.out.print("\n\n");
    }
    
    public boolean hasTopo(int col)
    {
        for (int i = 0; i < MAX_LINHAS; i++) 
        {
            
            if(matriz[i][col] == null && i == MAX_LINHAS-1) {
                return true;
            }
            else {
                if(matriz[i][col] != null)
                    return false;
            }
        }
        
        return false;
    }
    
    public void copia(Matriz m)
    {
        for(int i = 0; i < MAX_LINHAS; i++)
            for(int j = 0; j < MAX_COLUNAS; j++)
            {
                if(m.getBloco(i, j) != null)
                {
                    int id = m.getBloco(i, j).getId();
                this.setBloco(new Bloco(id), i, j);
                }              
            }                                    
    }

    public void solucionar(Matriz m)
    {
        ArrayList<Matriz> caminho = new ArrayList();
        ArrayList<Matriz> solucao = new ArrayList();   
        caminho.add(this);
        
        List fila = new List();

        resolver(fila, 0, caminho, m);
    }
    
    public boolean equalsMatriz(Matriz dest)
    {
        for (int i = 0; i < MAX_LINHAS; i++) 
        {
            for (int j = 0; j < MAX_COLUNAS; j++) 
            {
                if(this.getBloco(i, j) != null && dest.getBloco(i, j) != null)
                    if(this.getBloco(i, j).getId() != dest.getBloco(i, j).getId())
                        return false;
                else
                    return false;
            }
        }
        
        return true;
    }
    
    public void exibirLista(ArrayList<Matriz> lista)
    {
        for(Matriz i : lista)
            i.exibir();
    }
    
    public int tamanho(int x){
        int i=0;
        while(i < MAX_COLUNAS && matriz[i][x]!=null)
            i++;
        return i;
    }
    
    private void resolver(List fila, int dist, ArrayList<Matriz> caminho, Matriz destino)
    {
        if(caminho.get(caminho.size()-1).equalsMatriz(destino))
        {
            Matriz m = new Matriz();
            m.copia(this);
            MatrizAux mm = new MatrizAux();
            m.podeIr(fila, destino, caminho, dist);
            
            if(!fila.getFila().isEmpty())
            {
                mm = fila.dequeue();
                mm.getMatriz().resolver(fila, mm.getDistancia()+1, mm.getCaminho(), destino);
            }
        }
        else
            exibirLista(caminho);
    }
    
    public int heuristica(Matriz dest, int pos, int distancia)
    {
        return diferencaPos(dest) + distancia + penalidade(dest, pos);
    }
    
    private int diferencaPos(Matriz destino)
    {
        int q = 0;
        for(int i = 0; i < MAX_LINHAS; i++)
            for(int j = 0; j < MAX_COLUNAS; j++)
                if(this.getBloco(i, j) != null && destino.getBloco(i, j) != null)
                {
                    if(this.getBloco(i, j).getId() != destino.getBloco(i, j).getId())
                        q++;
                }          
                else
                    q++;
                           
        return q;
    }
    
    public void podeIr(List fila, Matriz destino, ArrayList<Matriz> caminho, int distancia)
    {
        int posOrig, posDest;
        
        for(posDest = 0; posDest < MAX_COLUNAS; posDest++)
        {
            for(posOrig = 0; posOrig < MAX_COLUNAS; posOrig++) 
            {
                if(posOrig != posDest && this.tamanho(posOrig) > 0)
                {
                    Matriz aux = new Matriz();
                    aux.copia(this);
                    Bloco auxB = pop(posOrig);
                    aux.setBloco(new Bloco(auxB.getId()), posDest, 4);
                    if(!aux.pertence(caminho))
                    {
                        MatrizAux m = new MatrizAux();
                        m.setCaminho(caminho);
                        m.getCaminho().add(aux);
                        m.setMatriz(aux);
                        int heura = aux.heuristica(destino, posDest, distancia);
                        m.setHeurist(heura);
                        fila.enqueue(m);
                    }
                }
            }      
        }
           
        
    }
    
    public int penalidade(Matriz dest, int pos)
    {
        if(this.getTopo(pos) != null && dest.getBloco(pos, this.tamanho(pos)) != null)
            if(this.getTopo(pos).getId() != dest.getBloco(pos, this.tamanho(pos)).getId())
                return 10;
        
        return -10;
    } 
    
    public boolean pertence(ArrayList<Matriz> caminho)
    {
        for (int i = 0; i < caminho.size(); i++) {
            if(caminho.get(i).equalsMatriz(this))
                return true;
        }

        return false;
    }
}
