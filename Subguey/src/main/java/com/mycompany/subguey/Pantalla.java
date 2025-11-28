/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.subguey;

import Adicionales.Aguacate;
import Adicionales.DoblePoteina;
import Adicionales.Hongos;
import Adicionales.Postre;
import Adicionales.Refresco;
import Adicionales.Sopa;
import Proteina.Atun;
import Proteina.Beef;
import Proteina.Italiano;
import Proteina.Pavo;
import Proteina.Pollo;
import Proteina.Veggie;
import javax.swing.JOptionPane;

public class Pantalla extends javax.swing.JFrame {

    private ISandwich sandwichActual;
    private int tamanoActual; //tamano del sandwich en el que se esta trabajando
    private Orden orden;
    
    public Pantalla() {
        initComponents();
        orden = new Orden(); //inicializar la orden

        //Configuraciones adicionales para asegurar que la ventana se muestre
        setTitle("Subguey - Sistema de Pedidos");
        setLocationRelativeTo(null); //centrar en pantalla
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    }
    
    private void crearSandwich(ISandwich nuevoSandwich){
        sandwichActual = nuevoSandwich;
        actualizarPantalla();
    }
    
    private void nuevoSandwich() {
        sandwichActual = null;
        btgTipo.clearSelection();
    }
    
    private void agregarAdicional(ISandwich sandwichDecorado) {
        
        //por si el sandwich aun no esta creado
        if (sandwichActual == null) {
            JOptionPane.showMessageDialog(this, "Primero debes seleccionar un tipo de proteína", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        sandwichActual = sandwichDecorado;
        actualizarPantalla();
    }
    
    private void actualizarPantalla(){
        

    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgTamano = new javax.swing.ButtonGroup();
        btgTipo = new javax.swing.ButtonGroup();
        pnlOpciones = new javax.swing.JPanel();
        lblTamano = new javax.swing.JLabel();
        lblProteina = new javax.swing.JLabel();
        lblAdicional = new javax.swing.JLabel();
        btnAguacate = new javax.swing.JButton();
        btnDobleProteina = new javax.swing.JButton();
        btnHongos = new javax.swing.JButton();
        btnRefresco = new javax.swing.JButton();
        btnSopa = new javax.swing.JButton();
        btnPostre = new javax.swing.JButton();
        btnTerminarOrden = new javax.swing.JButton();
        rbtnTamanoGrande = new javax.swing.JRadioButton();
        rbtnTamanoPequeno = new javax.swing.JRadioButton();
        rbtnPavo = new javax.swing.JRadioButton();
        rbtnVeggie = new javax.swing.JRadioButton();
        rbtnItaliano = new javax.swing.JRadioButton();
        rbtnBeef = new javax.swing.JRadioButton();
        rbtnPollo = new javax.swing.JRadioButton();
        rbtnAtun = new javax.swing.JRadioButton();
        btnAgregar = new javax.swing.JButton();
        pnlSandwich = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlOpciones.setBackground(new java.awt.Color(255, 203, 10));

        lblTamano.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTamano.setText("Escoje el tamaño de tu sandwich:");

        lblProteina.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblProteina.setText("Escoje la proteína de tu sandwich:");

        lblAdicional.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAdicional.setText("Quieres algún adicional?");

        btnAguacate.setBackground(new java.awt.Color(228, 228, 228));
        btnAguacate.setText("+ Aguacate");
        btnAguacate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAguacate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAguacateActionPerformed(evt);
            }
        });

        btnDobleProteina.setBackground(new java.awt.Color(228, 228, 228));
        btnDobleProteina.setText("+ Doble proteína");
        btnDobleProteina.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDobleProteina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDobleProteinaActionPerformed(evt);
            }
        });

        btnHongos.setBackground(new java.awt.Color(228, 228, 228));
        btnHongos.setText("+ Hongos");
        btnHongos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnHongos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHongosActionPerformed(evt);
            }
        });

        btnRefresco.setBackground(new java.awt.Color(228, 228, 228));
        btnRefresco.setText("+ Refresco");
        btnRefresco.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRefresco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescoActionPerformed(evt);
            }
        });

        btnSopa.setBackground(new java.awt.Color(228, 228, 228));
        btnSopa.setText("+ Sopa");
        btnSopa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSopa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSopaActionPerformed(evt);
            }
        });

        btnPostre.setBackground(new java.awt.Color(228, 228, 228));
        btnPostre.setText("+ Galleta");
        btnPostre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPostre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostreActionPerformed(evt);
            }
        });

        btnTerminarOrden.setBackground(new java.awt.Color(228, 228, 228));
        btnTerminarOrden.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTerminarOrden.setText("Terminar orden");
        btnTerminarOrden.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), null));
        btnTerminarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarOrdenActionPerformed(evt);
            }
        });

        btgTamano.add(rbtnTamanoGrande);
        rbtnTamanoGrande.setText("30cm");
        rbtnTamanoGrande.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnTamanoGrandeActionPerformed(evt);
            }
        });

        btgTamano.add(rbtnTamanoPequeno);
        rbtnTamanoPequeno.setText("15cm");
        rbtnTamanoPequeno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnTamanoPequenoActionPerformed(evt);
            }
        });

        btgTipo.add(rbtnPavo);
        rbtnPavo.setText("Pavo");
        rbtnPavo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnPavoActionPerformed(evt);
            }
        });

        btgTipo.add(rbtnVeggie);
        rbtnVeggie.setText("Veggie");
        rbtnVeggie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnVeggieActionPerformed(evt);
            }
        });

        btgTipo.add(rbtnItaliano);
        rbtnItaliano.setText("Italiano");
        rbtnItaliano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnItalianoActionPerformed(evt);
            }
        });

        btgTipo.add(rbtnBeef);
        rbtnBeef.setText("Beef");
        rbtnBeef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnBeefActionPerformed(evt);
            }
        });

        btgTipo.add(rbtnPollo);
        rbtnPollo.setText("Pollo");
        rbtnPollo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnPolloActionPerformed(evt);
            }
        });

        btgTipo.add(rbtnAtun);
        rbtnAtun.setText("Atún");
        rbtnAtun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnAtunActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(228, 228, 228));
        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregar.setText("Agregar a la orden");
        btnAgregar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), null));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOpcionesLayout = new javax.swing.GroupLayout(pnlOpciones);
        pnlOpciones.setLayout(pnlOpcionesLayout);
        pnlOpcionesLayout.setHorizontalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOpcionesLayout.createSequentialGroup()
                        .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAdicional)
                            .addComponent(lblProteina)
                            .addComponent(lblTamano))
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOpcionesLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnPavo)
                            .addComponent(rbtnItaliano)
                            .addComponent(rbtnBeef))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnPollo)
                            .addComponent(rbtnAtun)
                            .addComponent(rbtnVeggie))
                        .addGap(54, 54, 54))))
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDobleProteina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAguacate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHongos, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRefresco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSopa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPostre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11))
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOpcionesLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(rbtnTamanoPequeno)
                        .addGap(45, 45, 45)
                        .addComponent(rbtnTamanoGrande))
                    .addGroup(pnlOpcionesLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(btnTerminarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlOpcionesLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlOpcionesLayout.setVerticalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblTamano)
                .addGap(18, 18, 18)
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnTamanoPequeno)
                    .addComponent(rbtnTamanoGrande))
                .addGap(32, 32, 32)
                .addComponent(lblProteina)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnPavo)
                    .addComponent(rbtnVeggie))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnItaliano)
                    .addComponent(rbtnAtun))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnBeef)
                    .addComponent(rbtnPollo))
                .addGap(21, 21, 21)
                .addComponent(lblAdicional)
                .addGap(18, 18, 18)
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAguacate)
                    .addComponent(btnRefresco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDobleProteina)
                    .addComponent(btnSopa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHongos)
                    .addComponent(btnPostre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnAgregar)
                .addGap(18, 18, 18)
                .addComponent(btnTerminarOrden)
                .addGap(31, 31, 31))
        );

        pnlSandwich.setBackground(new java.awt.Color(0, 151, 0));

        javax.swing.GroupLayout pnlSandwichLayout = new javax.swing.GroupLayout(pnlSandwich);
        pnlSandwich.setLayout(pnlSandwichLayout);
        pnlSandwichLayout.setHorizontalGroup(
            pnlSandwichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 636, Short.MAX_VALUE)
        );
        pnlSandwichLayout.setVerticalGroup(
            pnlSandwichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlSandwich, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlSandwich, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnVeggieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnVeggieActionPerformed
        crearSandwich(new Veggie(tamanoActual));
    }//GEN-LAST:event_rbtnVeggieActionPerformed

    private void rbtnTamanoPequenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnTamanoPequenoActionPerformed
        tamanoActual = 15;
    }//GEN-LAST:event_rbtnTamanoPequenoActionPerformed

    private void rbtnTamanoGrandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnTamanoGrandeActionPerformed
        tamanoActual = 30;
    }//GEN-LAST:event_rbtnTamanoGrandeActionPerformed

    private void rbtnPavoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnPavoActionPerformed
        crearSandwich(new Pavo(tamanoActual));
    }//GEN-LAST:event_rbtnPavoActionPerformed

    private void rbtnItalianoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnItalianoActionPerformed
        crearSandwich(new Italiano(tamanoActual));
    }//GEN-LAST:event_rbtnItalianoActionPerformed

    private void rbtnBeefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnBeefActionPerformed
        crearSandwich(new Beef(tamanoActual));
    }//GEN-LAST:event_rbtnBeefActionPerformed

    private void rbtnAtunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnAtunActionPerformed
        crearSandwich(new Atun(tamanoActual));
    }//GEN-LAST:event_rbtnAtunActionPerformed

    private void rbtnPolloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnPolloActionPerformed
        crearSandwich(new Pollo(tamanoActual));
    }//GEN-LAST:event_rbtnPolloActionPerformed

    private void btnAguacateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAguacateActionPerformed
        agregarAdicional(new Aguacate(sandwichActual, tamanoActual));
    }//GEN-LAST:event_btnAguacateActionPerformed

    private void btnDobleProteinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDobleProteinaActionPerformed
        agregarAdicional(new DoblePoteina(sandwichActual, tamanoActual));
    }//GEN-LAST:event_btnDobleProteinaActionPerformed

    private void btnHongosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHongosActionPerformed
        agregarAdicional(new Hongos(sandwichActual, tamanoActual));
    }//GEN-LAST:event_btnHongosActionPerformed

    private void btnRefrescoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescoActionPerformed
        agregarAdicional(new Refresco(sandwichActual));
    }//GEN-LAST:event_btnRefrescoActionPerformed

    private void btnSopaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSopaActionPerformed
        agregarAdicional(new Sopa(sandwichActual));
    }//GEN-LAST:event_btnSopaActionPerformed

    private void btnPostreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostreActionPerformed
        agregarAdicional(new Postre(sandwichActual));
    }//GEN-LAST:event_btnPostreActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        //por si aun no se ha creado el sandwich
        if (sandwichActual == null) {
            JOptionPane.showMessageDialog(this, "Primero debes crear un sándwich", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        orden.agregarSandwich(sandwichActual);
        JOptionPane.showMessageDialog(this, "Sándwich agregado a la orden", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        nuevoSandwich();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnTerminarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarOrdenActionPerformed
        //si no se crea ningun sandwich
        if (orden.getPrecioTotal() == 0) {
            JOptionPane.showMessageDialog(this, "No has agregado ningún sándwich a la orden", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        //muestra la info de la orden final
        String ordenFinal = "ORDEN FINAL:\n" + orden.getDescripcionOrden() + "\n\n Gracias por tu orden!";
        JOptionPane.showMessageDialog(this, ordenFinal, "Orden completada", JOptionPane.INFORMATION_MESSAGE);

        //limpiar
        orden.limpiarOrden();
        sandwichActual = null;
        btgTipo.clearSelection();
        btgTamano.clearSelection();
    }//GEN-LAST:event_btnTerminarOrdenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pantalla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgTamano;
    private javax.swing.ButtonGroup btgTipo;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAguacate;
    private javax.swing.JButton btnDobleProteina;
    private javax.swing.JButton btnHongos;
    private javax.swing.JButton btnPostre;
    private javax.swing.JButton btnRefresco;
    private javax.swing.JButton btnSopa;
    private javax.swing.JButton btnTerminarOrden;
    private javax.swing.JLabel lblAdicional;
    private javax.swing.JLabel lblProteina;
    private javax.swing.JLabel lblTamano;
    private javax.swing.JPanel pnlOpciones;
    private javax.swing.JPanel pnlSandwich;
    private javax.swing.JRadioButton rbtnAtun;
    private javax.swing.JRadioButton rbtnBeef;
    private javax.swing.JRadioButton rbtnItaliano;
    private javax.swing.JRadioButton rbtnPavo;
    private javax.swing.JRadioButton rbtnPollo;
    private javax.swing.JRadioButton rbtnTamanoGrande;
    private javax.swing.JRadioButton rbtnTamanoPequeno;
    private javax.swing.JRadioButton rbtnVeggie;
    // End of variables declaration//GEN-END:variables
}
