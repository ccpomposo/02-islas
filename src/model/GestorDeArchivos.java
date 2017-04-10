/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Usuario
 */
public class GestorDeArchivos {
    
    public static Integer[][] leerArchivo(File archivo) throws FileNotFoundException, IOException {
        FileInputStream iStream = new FileInputStream(archivo);
        Integer filas = Integer.parseInt(""+(char)iStream.read());
        System.out.println(filas);
        Integer columnas = Integer.parseInt(""+(char)iStream.read());
        System.out.println(columnas);
        Integer matriz[][] = new Integer[filas][columnas];
        Integer valor = 0, i = 0, j = 0;
        while (valor != -1) {
            if(valor == 48 || valor == 49) {
                matriz[i][j] = valor-48;
                if (j < (columnas-1)) {
                    j++;
                } else {
                    j = 0;
                    i++;
                }
            }
            valor = iStream.read();
        }
        iStream.close();
        return matriz;
    }
}
