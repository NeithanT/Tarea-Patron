/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.strategyy.view;

import com.mycompany.strategyy.model.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;
import java.util.List;

/**
 *
 * @author melissa
 */
public class PanelJugador extends javax.swing.JPanel {
    private Jugador jugador;
    private boolean esJugador1;
    private JuegoFrame frameParent;
    private IArteMarcial arteSeleccionada;
    private Combo comboGenerado;
    private JPanel panelImagenesJ2;
    private Image imagenFondo; 
    
    
    //Crea un pln de jugador vacío (para el editor de GUI)
    public PanelJugador() {
        cargarImagenFondo(); 
        initComponents();
    }
    
    public PanelJugador(Jugador jugador, boolean esJugador1, JuegoFrame parent) {
        this.jugador = jugador;
        this.esJugador1 = esJugador1;
        this.frameParent = parent;
        
        cargarImagenFondo();
        initComponents();
        inicializarDatos();
        configurarSegunTipoJugador();// pq j1 y j2 juegan distinto
    }
     
   private void configurarSegunTipoJugador() {
        if (esJugador1) {
            // Manual (elige arte)
            cmbArtesMarciales.setVisible(true);
            lblSeleccionarArte.setVisible(true);
            btnGenerarCombo.setVisible(true);
            lblImagenArte.setText("Imagen del arte marcial del ataque");
            lblInfoJ2.setVisible(false);

            // Cargar artes en ComboBox
            cmbArtesMarciales.removeAllItems();
            List<IArteMarcial> artes = jugador.getArtesMarciales();
            for (IArteMarcial arte : artes) {
                cmbArtesMarciales.addItem(arte.getNombre());
            }

            // Agregar listener para cambiar imagen al seleccionar arte en el combo
            cmbArtesMarciales.addActionListener(e -> {
                String arteSeleccionada = (String) cmbArtesMarciales.getSelectedItem();
                if (arteSeleccionada != null) {
                    cargarImagenArte(arteSeleccionada);
                }
            });

        } else {
            // jugador 2
             cmbArtesMarciales.setVisible(false);
            lblSeleccionarArte.setVisible(false);
            btnGenerarCombo.setVisible(false);

            lblImagenArte.setText("Imágenes de las artes marciales usadas en el ataque");

            lblInfoJ2.setVisible(true);
            lblInfoJ2.setText("<html><center>De 3 a 6 golpes de cualquiera de las<br>artes marciales disponibles</center></html>");

            // acá se crea el panel para poder colocar las imágenes para el j2
            panelImagenesJ2 = new JPanel();
            panelImagenesJ2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
            panelImagenesJ2.setBackground(Color.WHITE);

            // para reemplazar el contenido de lblImagenArte con el panel
            lblImagenArte.setLayout(new BorderLayout());
            lblImagenArte.removeAll();
            lblImagenArte.add(panelImagenesJ2, BorderLayout.CENTER);
            lblImagenArte.setText(""); // Quitar el texto
        }
    }
  
   
   private void cargarImagenFondo() {
        try {
            java.net.URL imgURL = getClass().getResource("/imagenes/Monet.png");
            if (imgURL != null) {
                imagenFondo = new ImageIcon(imgURL).getImage();
            } else {
                System.out.println("No se encontró Monet.png");
            }
        } catch (Exception e) {
            System.out.println("Error cargando fondo: " + e.getMessage());
        }
    }
    
    // sobreescribir paintComponent para dibujar el fondo
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenFondo != null) {
            // Dibujar la imagen escalada al tamaño del panel
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
    private void actualizarBotonesArtes() {
        List<IArteMarcial> artes = jugador.getArtesMarciales();
        btnArte1.setText(crearTextoBotonArte(artes.get(0)));
        btnArte2.setText(crearTextoBotonArte(artes.get(1)));
        btnArte3.setText(crearTextoBotonArte(artes.get(2)));
    }
     
      private String crearTextoBotonArte(IArteMarcial arte) {
        StringBuilder sb = new StringBuilder("<html><center><b>" + arte.getNombre() + "</b><br>");
        Golpe[] golpes = arte.getGolpes();
        for (Golpe golpe : golpes) {
            sb.append(golpe.getNombre()).append(" - ").append(golpe.getPoder()).append("<br>");
        }
        sb.append("</center></html>");
        return sb.toString();
    }
    
    public void actualizar() {
        lblVida.setText(jugador.getVida() + " de 200");
        actualizarBotonesArtes();
        
        // Actualizar ComboBox si cambiaron las artes
        if (esJugador1) {
        cmbArtesMarciales.removeAllItems();
        List<IArteMarcial> artes = jugador.getArtesMarciales();
        for (IArteMarcial arte : artes) {
            cmbArtesMarciales.addItem(arte.getNombre());
        }
        } else {
            // Actualizar imágenes de artes usadas
            List<String> artesUsadas = frameParent.getControlador().getArtesUsadasJ2();
            mostrarImagenesArtesUsadas(artesUsadas);
        }

        // Actualizar bitácora
        List<String> registros = BitacoraJuego.getInstancia().getRegistros();
        StringBuilder bitacora = new StringBuilder();
        int inicio = Math.max(0, registros.size() - 10);
        for (int i = inicio; i < registros.size(); i++) {
            if (registros.get(i).contains(jugador.getNombre())) {
                bitacora.append(registros.get(i)).append("\n");
            }
        }
        txtBitacora.setText(bitacora.toString());
    }

    /**
     * Indica si hay un combo generado listo para usar
     */
    public boolean tieneComboGenerado() {
        return comboGenerado != null;
    }

    /**
     * Ejecuta el combo generado (si existe) contra el oponente.
     * Limpia el combo y actualiza la bitácora.
     */
    public void usarCombo() {
        if (comboGenerado != null) {
            // Consumir el combo preparado desde el Jugador para garantizar
            // que se usa la misma instancia que pueda haber sido guardada
            // por la UI o por otros flujos.
            Combo preparado = jugador.tomarComboPreparado();
            if (preparado == null) {
                // si no hay combo en el jugador, usar
                // el que tiene el panel (cuesta que esto suceda)
                preparado = comboGenerado;
            }

            if (preparado != null) {
                preparado.ejecutar(jugador, frameParent.getControlador().getJugador2());
            }

            comboGenerado = null;
            txaCombos.setText("");
        }
    }
 


   private void inicializarDatos() {
    lblNombre.setText(jugador.getNombre());
    
    // Ajustar tamaño de botones
    Dimension tamañoBoton = new Dimension(120, 80);
    btnArte1.setPreferredSize(tamañoBoton);
    btnArte2.setPreferredSize(tamañoBoton);
    btnArte3.setPreferredSize(tamañoBoton);
    
    // Configurar label de imagen
    lblImagenArte.setPreferredSize(new Dimension(250, 180));
    lblImagenArte.setMinimumSize(new Dimension(250, 180));
    lblImagenArte.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
    lblImagenArte.setHorizontalAlignment(SwingConstants.CENTER);
    
    // ComboBox
    cmbArtesMarciales.removeAllItems();
    List<IArteMarcial> artes = jugador.getArtesMarciales();
    for (IArteMarcial arte : artes) {
        cmbArtesMarciales.addItem(arte.getNombre());
    }
    
    actualizarBotonesArtes();
    lblVida.setText("Vida actual del jugador: " + jugador.getVida() + " de 200");
    
    txaCombos.setEditable(false);
    txtBitacora.setEditable(false);
}
    
    private void cargarImagenArte(String nombreArte) {
        try {
            // Normalizar el nombre (quitar espacios, poner en minúsculas)
            String nombreArchivo = nombreArte.toLowerCase().replace(" ", "");
            String rutaImagen = "/imagenes/" + nombreArchivo + ".png";

            // Cargar la imagen
            java.net.URL imgURL = getClass().getResource(rutaImagen);

            if (imgURL != null) {
                ImageIcon iconOriginal = new ImageIcon(imgURL);

                // Redimensionar la imagen
                Image imgEscalada = iconOriginal.getImage().getScaledInstance(
                    250, 180, Image.SCALE_SMOOTH
                );

                lblImagenArte.setIcon(new ImageIcon(imgEscalada));
                lblImagenArte.setText(""); // Quitar el texto
            } else {
                // Si no se encuentra la imagen
                lblImagenArte.setIcon(null);
                lblImagenArte.setText("Imagen no disponible");
            }
        } catch (Exception e) {
            lblImagenArte.setIcon(null);
            lblImagenArte.setText("Error al cargar imagen");
            System.err.println("Error cargando imagen: " + e.getMessage());
        }
    }
    private void mostrarImagenesArtesUsadas(List<String> artesUsadas) {
        if (panelImagenesJ2 == null) return;

        panelImagenesJ2.removeAll();

        if (artesUsadas == null || artesUsadas.isEmpty()) {
            JLabel lblSinArtes = new JLabel("Sin artes usadas aún");
            lblSinArtes.setHorizontalAlignment(SwingConstants.CENTER);
            panelImagenesJ2.add(lblSinArtes);
        } else {
            // Crear una mini imagen por cada arte usada
            for (int i = 0; i < artesUsadas.size(); i++) {
                String nombreArte = artesUsadas.get(i);
                JLabel lblMiniImagen = crearMiniImagen(nombreArte);
                panelImagenesJ2.add(lblMiniImagen);
            }
        }

        panelImagenesJ2.revalidate();
        panelImagenesJ2.repaint();
    }
    
    private JLabel crearMiniImagen(String nombreArte) {
        JLabel lblImagen = new JLabel();
        lblImagen.setPreferredSize(new Dimension(80, 60));
        lblImagen.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);

        try {
            String nombreArchivo = nombreArte.toLowerCase()
                                             .replace(" ", "")
                                             .replace("-", "");
            String rutaImagen = "/imagenes/" + nombreArchivo + ".png";

            System.out.println("🔍 Buscando mini imagen: " + rutaImagen);

            java.net.URL imgURL = getClass().getResource(rutaImagen);

            if (imgURL != null) {
                ImageIcon iconOriginal = new ImageIcon(imgURL);
                Image imgEscalada = iconOriginal.getImage().getScaledInstance(
                    75, 55, Image.SCALE_SMOOTH
                );
                lblImagen.setIcon(new ImageIcon(imgEscalada));
                lblImagen.setToolTipText(nombreArte); // Tooltip con el nombre
            } else {
                System.out.println(" Mini imagen NO encontrada :(");
                lblImagen.setText("<html><center>" + nombreArte + "</center></html>"); // Mostrar nombre si no hay imagen
                lblImagen.setFont(new Font("Arial", Font.PLAIN, 9));
            }
        } catch (Exception e) {
            System.out.println("Error cargando mini imagen: " + e.getMessage());
            lblImagen.setText(nombreArte.substring(0, Math.min(nombreArte.length(), 5)));
        }

        return lblImagen;
    }

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        btnArte1 = new javax.swing.JButton();
        btnArte2 = new javax.swing.JButton();
        btnArte3 = new javax.swing.JButton();
        cmbArtesMarciales = new javax.swing.JComboBox<>();
        btnAtacar = new javax.swing.JButton();
        btnGenerarCombo = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        lblSeleccionarArte = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaCombos = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtBitacora = new javax.swing.JTextArea();
        lblInfoJ2 = new javax.swing.JLabel();
        lblVida = new javax.swing.JLabel();
        lblImagenArte = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));

        lblNombre.setText("jLabel1");

        btnArte1.setBackground(new java.awt.Color(255, 204, 204));
        btnArte1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnArte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArte1ActionPerformed(evt);
            }
        });

        btnArte2.setBackground(new java.awt.Color(255, 204, 204));
        btnArte2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnArte3.setBackground(new java.awt.Color(255, 204, 204));
        btnArte3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cmbArtesMarciales.setBackground(new java.awt.Color(255, 204, 153));
        cmbArtesMarciales.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAtacar.setBackground(new java.awt.Color(255, 204, 204));
        btnAtacar.setText("Atacar");
        btnAtacar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 153), 3));
        btnAtacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtacarActionPerformed(evt);
            }
        });

        btnGenerarCombo.setBackground(new java.awt.Color(255, 204, 204));
        btnGenerarCombo.setText("Generar Combo de 3-6 golpes");
        btnGenerarCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 153), 3));
        btnGenerarCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarComboActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(255, 204, 204));
        btnActualizar.setText("Actualizar Vidas y golpes");
        btnActualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 153), 3));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        lblSeleccionarArte.setText("Seleccionar Arte Marcial:");

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));

        txaCombos.setColumns(20);
        txaCombos.setRows(5);
        jScrollPane2.setViewportView(txaCombos);

        txtBitacora.setColumns(20);
        txtBitacora.setRows(5);
        jScrollPane1.setViewportView(txtBitacora);

        lblInfoJ2.setText("jLabel2");

        lblVida.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblInfoJ2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(lblVida)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInfoJ2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblVida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        lblImagenArte.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(250, 250, 250)
                                .addComponent(lblNombre))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAtacar, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnGenerarCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(btnArte1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(btnArte2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnArte3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 24, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblImagenArte)
                .addGap(154, 154, 154))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSeleccionarArte)
                    .addComponent(cmbArtesMarciales, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnArte2, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(btnArte3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnArte1, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                .addGap(88, 88, 88)
                .addComponent(lblSeleccionarArte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbArtesMarciales, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(lblImagenArte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenerarCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnAtacar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnArte1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArte1ActionPerformed
        // Aca no va nada porque el ataque se hace con el combo generado pero se me fue, y no sé como quitarlo jaja
    }//GEN-LAST:event_btnArte1ActionPerformed

    private void btnGenerarComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarComboActionPerformed
       if (!esJugador1) return;
        
        String arteSeleccionadaNombre = (String) cmbArtesMarciales.getSelectedItem();
        if (arteSeleccionadaNombre == null) {
            JOptionPane.showMessageDialog(this, "Selecciona un arte marcial");
            return; 
             }
        
        // Buscar el arte marcial seleccionada
        for (IArteMarcial arte : jugador.getArtesMarciales()) {
            if (arte.getNombre().equals(arteSeleccionadaNombre)) {
                arteSeleccionada = arte;
                jugador.setArteMarcial(arteSeleccionada);
                break;
            }
        }
        
        cargarImagenArte(arteSeleccionadaNombre);
        
         java.util.Random random = new java.util.Random();
        int cantidadGolpes = random.nextInt(4) + 3; // 3-6 golpes

        comboGenerado = new Combo(arteSeleccionada.getNombre());
        StringBuilder comboTexto = new StringBuilder();

        Golpe[] golpes = arteSeleccionada.getGolpes();
        for (int i = 0; i < cantidadGolpes; i++) {
            Golpe golpe = golpes[random.nextInt(golpes.length)];
            comboGenerado.agregarGolpe(golpe); // Guardar en el combo
            comboTexto.append((i + 1)).append(". ").append(golpe.toString()).append("\n");
        }

        txaCombos.setText(comboTexto.toString());
        // Guardar también el combo en el modelo (Jugador) para que el flujo
        // de ataque use exactamente este combo cuando se invoque desde el
        // controlador o desde la propia UI.
        jugador.setComboPreparado(comboGenerado);
        
    }//GEN-LAST:event_btnGenerarComboActionPerformed

    private void btnAtacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtacarActionPerformed
        if (esJugador1) {
            if (comboGenerado == null) {
                JOptionPane.showMessageDialog(this, "Primero genera un combo");
                return;
            }

            // Usar el combo generado a través del método público (reutilizable)
            usarCombo();

        } else {
            frameParent.getControlador().jugador2AtacaAleatorio();
        }

        frameParent.actualizarVista();              
    }//GEN-LAST:event_btnAtacarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizar();
    }//GEN-LAST:event_btnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnArte1;
    private javax.swing.JButton btnArte2;
    private javax.swing.JButton btnArte3;
    private javax.swing.JButton btnAtacar;
    private javax.swing.JButton btnGenerarCombo;
    private javax.swing.JComboBox<String> cmbArtesMarciales;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblImagenArte;
    private javax.swing.JLabel lblInfoJ2;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSeleccionarArte;
    private javax.swing.JLabel lblVida;
    private javax.swing.JTextArea txaCombos;
    private javax.swing.JTextArea txtBitacora;
    // End of variables declaration//GEN-END:variables
}
