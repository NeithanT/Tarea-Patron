/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.strategyy.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author melissa
 * Esta clase es una fábrica para crear instancias de IArteMarcial
 * según el tipo solicitado.
 */

public class ArteMarcialFactory {
    
    public enum TipoArte {
        TAEKWONDO, WUSHU, SUMO, KUNG_FU, KARATE,
        CAPOEIRA, JUDO, SAMBO, AIKIDO, BOXING
    }
    
    public static IArteMarcial crear(TipoArte tipo) {
        switch (tipo) {
            case TAEKWONDO: return new Taekwondo();
            case WUSHU: return new Wushu();
            case SUMO: return new Sumo();
            case KUNG_FU: return new KungFu();
            case KARATE: return new Karate();
            case CAPOEIRA: return new Capoeira();
            case JUDO: return new Judo();
            case SAMBO: return new Sambo();
            case AIKIDO: return new Aikido();
            case BOXING: return new Boxing();
            default: throw new IllegalArgumentException("Tipo inválido");
        }
    }
    
    public static List<IArteMarcial> asignarArtesAleatorias() { 
        List<TipoArte> tipos = new ArrayList<>(Arrays.asList(TipoArte.values())); //Se obtienen todos los tipos
        Collections.shuffle(tipos); // Se mezclan aleatoriamente
        
        List<IArteMarcial> artes = new ArrayList<>();
        for (int i = 0; i < 3; i++) { // Se seleccionan los primeros 3 tipos mezclados
            artes.add(crear(tipos.get(i))); // Se crean las instancias correspondientes
        }
        
        return artes; // Se retorna la lista de arts marciales asignadas
    }
    
    public static IArteMarcial crearAleatorio() {
        TipoArte[] tipos = TipoArte.values(); // Obtener todos los tipos disponibles
        Random random = new Random(); 
        return crear(tipos[random.nextInt(tipos.length)]); //
    }
}