/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.GridLayout;
import javax.swing.*;
import model.Mapa;

/**
 *
 * @author Usuario
 */
public class MapaPanel extends JPanel {

    private Mapa mapa;
    private JLabel[][] lblMapa;

    public MapaPanel(Mapa mapa) {
        super();
        this.mapa = mapa;
        super.setLayout(new GridLayout(this.mapa.getFilas(), this.mapa.getColumnas()));
        this.crearMapa();
    }

    private void crearMapa() {
        int filas = this.mapa.getFilas();
        int columnas = this.mapa.getColumnas();
        this.lblMapa = new JLabel[filas][columnas];
        ImageIcon imgAgua = new ImageIcon("agua.png");
        ImageIcon imgTierra = new ImageIcon("tierra.png");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                this.lblMapa[i][j] = new JLabel();
                this.lblMapa[i][j].setOpaque(true);
                if(this.mapa.getValor(i, j) == 0){
                    this.lblMapa[i][j].setIcon(imgAgua);
                } else {
                    this.lblMapa[i][j].setIcon(imgTierra);
                }
                super.add(this.lblMapa[i][j]);
            }
        }
    }
}
