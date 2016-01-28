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
import fr.ensim.locvoiture.model.Voiture;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Wojciech Rousseau (Vrong)
 */
public class ContratWindow extends MvcView {

    /**
     * Creates new form ContratWindow
     */
    
    List<Client> clients;
    List<Voiture> voitures;
    Contrat contrat = null;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    
    public static final String NOUVEAU_CLIENT_ITEM = "  ~ Nouveau Client ~  ";
    
    public ContratWindow(AbstractController controller, Contrat contrat, Voiture voiture) {
        super(controller);
        initComponents();
        this.contrat = contrat;
        voitures = controller.getVoitures();
        
        comboVoitures.removeAllItems();
        for(Voiture v : voitures)
            comboVoitures.addItem(v.toString());
        
        
        
        updateClients(null);
        
        comboVoitures.setSelectedIndex(0);
        int tmp = voitures.indexOf(voiture);
        comboVoitures.setSelectedIndex(tmp);
        
        
        debutLocation.setText(formatter.format(new Date()));
        finLocation.setText(formatter.format(new Date()));
        
        if(contrat != null)
        {
            titre.setText("Modifier un contrat");
            
            if(contrat.getId() >= 0)
                numero.setText(contrat.getId() + "");
            
            debutLocation.setText(formatter.format(contrat.getDateDebut()));
            finLocation.setText(formatter.format(contrat.getDateFin()));
            departKm.setText(contrat.getKilometrageDebut() + "");
            arriveeKm.setText(contrat.getKilometrageFin() + "");
            
            updateClients(controller.getClient(contrat));
            
        }
        this.setVisible(true);
    }
    
    public void updateClients(Client client)
    {
        clients = controller.getClients();
        comboClient.removeAllItems();
        comboClient.addItem(NOUVEAU_CLIENT_ITEM);
        
        for(Client c : clients)
            comboClient.addItem(c.toString());
        
        comboClient.setSelectedIndex(0);
        if(client != null)
        {
            int tmp = clients.indexOf(client);
            comboClient.setSelectedIndex(tmp+1);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JComboBox<String> comboClients = new javax.swing.JComboBox<>();
        titre = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        numero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboClient = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        comboVoitures = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        debutLocation = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        finLocation = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        departKm = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        arriveeKm = new javax.swing.JTextField();

        comboClients.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboClients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboClientsActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        titre.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        titre.setText("Nouveau contrat");
        getContentPane().add(titre, java.awt.BorderLayout.PAGE_START);

        jButton1.setBackground(new java.awt.Color(51, 255, 51));
        jButton1.setText("Valider");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, java.awt.BorderLayout.PAGE_END);

        jPanel1.setLayout(new java.awt.GridLayout(7, 2));

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

        jLabel2.setText("Client");
        jPanel1.add(jLabel2);

        comboClient.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1----------------------------------", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(comboClient);

        jLabel4.setText("Voiture");
        jPanel1.add(jLabel4);

        comboVoitures.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboVoitures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboVoituresActionPerformed(evt);
            }
        });
        jPanel1.add(comboVoitures);

        jLabel3.setText("Début de la location");
        jPanel1.add(jLabel3);

        debutLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debutLocationActionPerformed(evt);
            }
        });
        jPanel1.add(debutLocation);

        jLabel5.setText("Fin de la location");
        jPanel1.add(jLabel5);
        jPanel1.add(finLocation);

        jLabel6.setText("Kilomérage au départ");
        jPanel1.add(jLabel6);

        departKm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departKmActionPerformed(evt);
            }
        });
        jPanel1.add(departKm);

        jLabel7.setText("Kilométrage à l'arrivée");
        jPanel1.add(jLabel7);
        jPanel1.add(arriveeKm);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        
        Contrat c;
        if(contrat != null)
        {
            c = contrat;
        }
        else
        {
            c = new Contrat();
            c.setAgent(controller.getConnectedAgent());
        }
        
        int tmp = comboVoitures.getSelectedIndex();
        c.setVoiture(voitures.get(tmp));
        
        
        try {
            c.setDateDebut(formatter.parse(debutLocation.getText()));
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(null,"Date de début de location incorrecte"); 
        }
        try {
            c.setDateFin(formatter.parse(finLocation.getText()));
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(null,"Date de fin de location incorrecte"); 
        }
        
        try {
            c.setKilometrageFin(Integer.parseInt(arriveeKm.getText()));
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(null,"Kilométrage d'arrivée incorrect"); 
        }
        
        try {
            c.setKilometrageDebut(Integer.parseInt(departKm.getText()));
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(null,"Kilométrage de départ incorrect"); 
        }
        
        if(comboClient.getSelectedIndex() == 0)
        {
            new ClientWindow(controller, c, contrat == null);
        }
        else
        {
           Client cl = clients.get(comboClient.getSelectedIndex() -1 );
           c.setClient(cl);
                   
           if(contrat == null)
               controller.addContrat(c);
           else
               controller.modifierContrat(c);
        }
        
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void departKmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departKmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departKmActionPerformed

    private void debutLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_debutLocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_debutLocationActionPerformed

    private void comboClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboClientsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboClientsActionPerformed

    private void numeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroActionPerformed

    private void comboVoituresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboVoituresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboVoituresActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField arriveeKm;
    private javax.swing.JComboBox<String> comboClient;
    private javax.swing.JComboBox<String> comboVoitures;
    private javax.swing.JTextField debutLocation;
    private javax.swing.JTextField departKm;
    private javax.swing.JTextField finLocation;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField numero;
    private javax.swing.JLabel titre;
    // End of variables declaration//GEN-END:variables
}
