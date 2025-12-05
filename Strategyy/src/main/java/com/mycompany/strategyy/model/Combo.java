/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.strategyy.model;

import com.mycompany.strategyy.controller.ControladorJuego;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author melissa
 */
public class Combo {
    private List<Golpe> golpes;
    private String nombreArte;
    
    public Combo(String nombreArte) {
        this.nombreArte = nombreArte;
        this.golpes = new ArrayList<>();
    }
    
    
    public void agregarGolpe(Golpe golpe) {
        golpes.add(golpe);
    }
    
     public ResultadoAtaque ejecutar(Jugador atacante, Jugador defensor) {
        int dañoTotal = 0;
        int vidaRecuperadaTotal = 0;
        List<String> bitacora = new ArrayList<>();
        
        // Debug: mostrar referencias de los jugadores para detectar instancias duplicadas
        System.out.println("[Combo] Ejecutando combo de '" + nombreArte + "' entre " + atacante.getNombre() + " (id=" + System.identityHashCode(atacante) + ") y " + defensor.getNombre() + " (id=" + System.identityHashCode(defensor) + ")");

        for (Golpe golpe : golpes) {
            // Usar el poder definido en el objeto Golpe (coincide con lo mostrado en la UI)
            int poder = golpe.getPoder();
            int dañoGolpe = poder + golpe.getDañoAdicionalDefensor();

            defensor.recibirDaño(dañoGolpe);
            dañoTotal += dañoGolpe;
            
            // Recuperar vida del atacante si aplica (esto es FIJO del golpe)
            if (golpe.getVidaAdicionalAtacante() > 0) {
                atacante.recuperarVida(golpe.getVidaAdicionalAtacante());
                vidaRecuperadaTotal += golpe.getVidaAdicionalAtacante();
                System.out.println("[Combo] " + atacante.getNombre() + " recupera " + golpe.getVidaAdicionalAtacante() + " vida (total rec: " + vidaRecuperadaTotal + ")");
            }
            
            // Registrar en bitácora con el daño REAL aplicado
            String mensaje = construirMensajeBitacora(atacante.getNombre(), golpe, dañoGolpe);
            bitacora.add(mensaje);
            BitacoraJuego.getInstancia().registrar(mensaje);
            // Notificar a la UI que se aplicó un golpe (para actualizar bitácora en tiempo real)
            ControladorJuego.getInstancia().notificarGolpeAplicado(mensaje);

            // Si el defensor quedó sin vida, notificar ganador y detener el combo
            if (!defensor.estaVivo()) {
                ControladorJuego.getInstancia().notificarGanador(atacante);
                break;
            }
        }
        
        return new ResultadoAtaque(dañoTotal, vidaRecuperadaTotal, bitacora);
    }
    
    private String construirMensajeBitacora(String nombreAtacante, Golpe golpe, int daño) {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append(nombreAtacante).append(" usa ").append(golpe.getNombre());
        mensaje.append(" [").append(daño).append(" dmg");
        
        if (golpe.getVidaAdicionalAtacante() > 0) {
            mensaje.append(", +").append(golpe.getVidaAdicionalAtacante()).append(" vida");
        }
        if (golpe.getDañoAdicionalDefensor() > 0) {
            mensaje.append(", +").append(golpe.getDañoAdicionalDefensor()).append(" dmg extra");
        }
        
        mensaje.append("]");
        return mensaje.toString();
    }
    
    public List<Golpe> getGolpes() {
        return golpes;
    }
    
    public String getNombreArte() {
        return nombreArte;
    }
    
    public int getCantidadGolpes() {
        return golpes.size();
    }
}