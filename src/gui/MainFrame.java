/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.Controlador;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Usuario
 */
public class MainFrame extends JFrame{
    
    private JButton btnArchivo;
    private JButton btnDibujar;
    private JFileChooser fchChooser;
    private Controlador controlador;
    private MapaPanel pnlMapa;
    
    public MainFrame(){
        super("Islas v1.0");
        super.setSize(500,500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new BorderLayout());
        this.controlador = new Controlador();
        super.add(this.crearPnlBotones(), BorderLayout.SOUTH);
        
        super.setVisible(true);
    }
    
    private JPanel crearPnlBotones() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        this.fchChooser = new JFileChooser();
        this.btnArchivo = new JButton("Cargar archivo");
        this.btnArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                fchChooser.showOpenDialog(MainFrame.this);
                File archivo = fchChooser.getSelectedFile();
                try {
                    controlador.crearMapa(archivo);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Ocurrió un error al abrir el archivo");
                }
                btnDibujar.setEnabled(true);
            }
        });
        this.btnDibujar = new JButton("Dibujar mapa");
        this.btnDibujar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(MainFrame.this, String.format("Se encontraron %d islas", controlador.contarIslas()));
                pnlMapa = new MapaPanel(controlador.getMapa());
                MainFrame.super.add(pnlMapa, BorderLayout.CENTER);
            }
        });
        
        panel.add(this.btnArchivo);
        panel.add(this.btnDibujar);
        return panel;
    }
}

class Test {
    public static void main(String[] args) {
        new MainFrame();
    }
}