/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adicionales;

import com.mycompany.subguey.ISandwich;

/**
 *
 * @author Alina
 */
public class Sopa extends AdicionalDecorator{
    //CONSTRUCTOR
    public Sopa(ISandwich sandwich) {
        super(sandwich, 4.2, "sopa");
    }
    
}
