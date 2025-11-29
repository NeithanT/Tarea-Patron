/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.subguey;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class VerSandwich extends JPanel{

    private ArrayList<Image> capas;
    private ArrayList<Image> acompanamientos; // Refresco, sopa, galleta
    private static final String IMAGE_PATH = "/images/";
    private static final int ANCHO_IMAGEN = 300;
    private static final int ALTO_CAPA = 40;
    private static final int ANCHO_ACOMPANAMIENTO = 100;
    private static final int ALTO_ACOMPANAMIENTO = 100;

    private Image cargarImagen(String nombreImagen){
        try {
            URL imgURL = getClass().getResource(IMAGE_PATH + nombreImagen);
            if (imgURL == null) {
                System.out.println("ERROR: No se encontró la ruta de la imagen: " + IMAGE_PATH + nombreImagen);
                System.out.println("Verifica que la carpeta resources/images/ contenga el archivo: " + nombreImagen);
                return null;
            }
            System.out.println("Cargando imagen: " + IMAGE_PATH + nombreImagen);
            Image imagen = ImageIO.read(imgURL);
            return imagen;
        } catch (IOException e) {
            System.out.println("ERROR: No se pudo cargar la imagen: " + nombreImagen);
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            System.out.println("ERROR inesperado al cargar: " + nombreImagen);
            e.printStackTrace();
            return null;
        }
    }
    
    public VerSandwich() {
        System.out.println("Inicializando VerSandwich...");
        capas = new ArrayList<>();
        acompanamientos = new ArrayList<>();
        agregarPanBase();
        setOpaque(false); // Hacer el fondo transparente para que se vea el verde del panel
        System.out.println("VerSandwich inicializado correctamente.");
    }
    
    public void agregarPanBase() {
        Image panBase = cargarImagen("panBase.png");
        if (panBase != null) {
            capas.add(panBase);
            repaint();
        }
    }
    
    public void agregarProteina(String tipo) {
        Image proteina = cargarImagen(tipo.toLowerCase() + ".png");
        if (proteina != null) {
            capas.add(proteina);
            repaint();
        }
    }
    
    public void agregarAdicional(String nombreArchivo) {
        //verificar si es un acompañamiento (refresco, sopa, galleta)
        if (nombreArchivo.equals("refresco.png") || nombreArchivo.equals("sopa.png") || nombreArchivo.equals("galleta.png")) {
            agregarAcompanamiento(nombreArchivo);
        } else {
            //es un ingrediente del sandwich
            Image imagen = cargarImagen(nombreArchivo);
            if (imagen != null) {
                capas.add(imagen);
                repaint();
            }
        }
    }

    public void agregarAcompanamiento(String nombreArchivo) {
        Image imagen = cargarImagen(nombreArchivo);
        if (imagen != null) {
            acompanamientos.add(imagen);
            repaint();
        }
    }
    
    public void agregarPanTop() {
        Image panTop = cargarImagen("panTop.png");
        if (panTop != null) {
            capas.add(panTop);
            repaint();
        }
    }
    
    //para nuevas ordenes, solo deja el pan base
    public void reiniciar() {
        capas.clear();
        acompanamientos.clear();
        agregarPanBase();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        //dibuja el panBase
        int xSandwich = 50;
        int yPanBase = getHeight() - ALTO_CAPA - 50;

        if (!capas.isEmpty() && capas.get(0) != null) {
            g2d.drawImage(capas.get(0), xSandwich, yPanBase, ANCHO_IMAGEN, ALTO_CAPA, this);
        }
        
        //dibujar los ingredientes
        for (int i = 1; i < capas.size(); i++) {
            Image capa = capas.get(i);
            if (capa != null) {
                int yIngrediente = yPanBase - (i * ALTO_CAPA); //se dibuja arriba de la capa anterior
                g2d.drawImage(capa, xSandwich, yIngrediente, ANCHO_IMAGEN, ALTO_CAPA, this);
            }
        }

        //dibujar acompañamientos a la derecha del sandwich
        int xAcompanamiento = xSandwich + ANCHO_IMAGEN + 50;
        int yAcompanamiento = 50;

        for (Image acomp : acompanamientos) {
            if (acomp != null) {
                g2d.drawImage(acomp, xAcompanamiento, yAcompanamiento, ANCHO_ACOMPANAMIENTO, ALTO_ACOMPANAMIENTO, this);
                yAcompanamiento += ALTO_ACOMPANAMIENTO + 20; //espacio entre acompañamientos
            }
        }
    }

}
