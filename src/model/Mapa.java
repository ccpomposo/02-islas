/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Usuario
 */
public class Mapa {
    
    private Integer[][] mapa;
    private Integer filas;
    private Integer columnas;
    
    public Mapa(Integer[][] mapa) {
        this.mapa = mapa;
        this.filas = mapa.length;
        this.columnas = mapa[0].length;
    }
    
    private void buscarIslas(int fila, int columna) {
        if (fila >= 0 && columna >= 0 && fila < mapa.length && columna < mapa[0].length && mapa[fila][columna] == 1) {
            mapa[fila][columna] = -1;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    buscarIslas(fila + i, columna + j);
                }
            }
        }
    }
    
    public int contarIslas() {
        int cont = 0;
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[0].length; j++) {
                if(mapa[i][j] == 1){
                    cont++;
                    this.buscarIslas(i, j);
                }
            }
        }
        return cont;
    }
    
    public Integer getValor(int fila, int columna) {
        return this.mapa[fila][columna];
    }

    public Integer getFilas() {
        return filas;
    }

    public Integer getColumnas() {
        return columnas;
    }

    public Integer[][] getMapa() {
        return mapa;
    }
    
    
}
