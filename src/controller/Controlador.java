/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import model.GestorDeArchivos;
import model.Mapa;

/**
 *
 * @author Usuario
 */
public class Controlador {

    private Mapa mapa;

    public void crearMapa(File archivo) throws IOException {
        Integer[][] matriz = GestorDeArchivos.leerArchivo(archivo);
        this.mapa = new Mapa(matriz);
    }

    public int contarIslas() {
        return this.mapa.contarIslas();
    }

    public Mapa getMapa() {
        return mapa;
    }

}

//class Test {
//
//    public static void main(String[] args) throws IOException {
//        Controlador controlador = new Controlador();
//        controlador.crearMapa(new File(".Islas.txt"));
//        Integer[][] matriz = controlador.getMapa().getMapa();
//        for (int i = 0; i < matriz.length; i++) {
//            for (int j = 0; j < matriz[0].length; j++) {
//                System.out.print(matriz[i][j]);
//            }
//            System.out.println("");
//        }
//    }
//}
