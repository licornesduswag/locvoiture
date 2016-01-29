/*
 * The MIT License
 *
 * Copyright 2016 Wojciech Rousseau (Vrong).
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package fr.ensim.locvoiture.view;

import fr.ensim.locvoiture.controller.AbstractController;
import fr.ensim.locvoiture.model.Client;
import fr.ensim.locvoiture.model.Contrat;
import fr.ensim.locvoiture.model.InfoPermis;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Wojciech Rousseau (Vrong)
 */
public class ClientWindow extends MvcView {

    /**
     * Creates new form ClientWindow
     */
    
    Contrat contrat;
    boolean ajouter;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    
    public ClientWindow(AbstractController controller, Contrat contrat, boolean ajouter) {
        super(controller);
        initComponents();
        this.ajouter = ajouter;
        this.controller = controller;
        this.contrat = contrat;
        
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titre = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        numero = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        prenom = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dateNaissance = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lieuNaissance = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        numeroPermis = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        dateObtention = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        villeDelivrance = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lieuDelivrance = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titre.setBackground(new java.awt.Color(255, 255, 0));
        titre.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        titre.setText("Nouveau client");
        titre.setOpaque(true);
        getContentPane().add(titre, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.GridLayout(9, 2));

        jLabel1.setText("Numéro");
        jPanel1.add(jLabel1);

        numero.setEditable(false);
        numero.setToolTipText("");
        numero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroActionPerformed(evt);
            }
        });
        jPanel1.add(numero);

        jLabel6.setText("Nom");
        jPanel1.add(jLabel6);
        jPanel1.add(nom);

        jLabel7.setText("Prénom");
        jPanel1.add(jLabel7);

        prenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prenomActionPerformed(evt);
            }
        });
        jPanel1.add(prenom);

        jLabel3.setText("Date de naissance");
        jPanel1.add(jLabel3);
        jPanel1.add(dateNaissance);

        jLabel5.setText("Lieu de naissance");
        jPanel1.add(jLabel5);
        jPanel1.add(lieuNaissance);

        jLabel4.setText("Numéro de permis");
        jPanel1.add(jLabel4);

        numeroPermis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroPermisActionPerformed(evt);
            }
        });
        jPanel1.add(numeroPermis);

        jLabel9.setText("Date d'obtention");
        jPanel1.add(jLabel9);
        jPanel1.add(dateObtention);

        jLabel2.setText("Ville de délivrance");
        jPanel1.add(jLabel2);
        jPanel1.add(villeDelivrance);

        jLabel8.setText("Lieu de délivrance");
        jPanel1.add(jLabel8);
        jPanel1.add(lieuDelivrance);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jButton1.setBackground(new java.awt.Color(51, 255, 51));
        jButton1.setText("Valider");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //TODO add client if needed

        int numPermis;
        Date dDelivrance, dNaissance;
        String lDelivrance, vDelivrance, lNaissance;
        
        
        lDelivrance = lieuDelivrance.getText();
        vDelivrance = villeDelivrance.getText();
        lNaissance = lieuNaissance.getText();
        
         try {
            numPermis = Integer.parseInt(numeroPermis.getText());
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(null,"Numéro permis incorrect");
            return;
        }
        

        try {
            dNaissance = formatter.parse(dateNaissance.getText());
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(null,"Date de naissance incorrecte");
            return;
        }
        try {
            dDelivrance = formatter.parse(dateObtention.getText());
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(null,"Date d'obtention du permis incorrecte");
            return;
        }
        
        Client c = new Client(nom.getText(), prenom.getText(), dNaissance, lNaissance,
        new InfoPermis(numPermis, dDelivrance, lDelivrance, vDelivrance));

        controller.addClient(c);
        contrat.setClient(c);
        
        if(ajouter)
            controller.addContrat(contrat);
        else
            controller.modifierContrat(contrat);

        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void prenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prenomActionPerformed

    private void numeroPermisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroPermisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroPermisActionPerformed

    private void numeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dateNaissance;
    private javax.swing.JTextField dateObtention;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lieuDelivrance;
    private javax.swing.JTextField lieuNaissance;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField numero;
    private javax.swing.JTextField numeroPermis;
    private javax.swing.JTextField prenom;
    private javax.swing.JLabel titre;
    private javax.swing.JTextField villeDelivrance;
    // End of variables declaration//GEN-END:variables
}
