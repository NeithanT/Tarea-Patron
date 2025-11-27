/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adicionales;

import com.mycompany.subguey.ISandwich;

public class Refresco extends AdicionalDecorator  {
    //CONSTRUCTOR
    public Refresco(ISandwich sandwich) {
        super(sandwich, 1.0, "Refresco");
    }
}
