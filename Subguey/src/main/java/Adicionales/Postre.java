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
public class Postre extends AdicionalDecorator{
    //CONSTRUCTOR
    public Postre(ISandwich sandwich) {
        super(sandwich, 3.5 , "galleta");
    }
}
