/*
 * The MIT License
 *
 * Copyright 2016 Romain Porte (MicroJoe) microjoe at mailoo.org.
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

package fr.ensim.locvoiture.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Romain Porte (MicroJoe) microjoe at mailoo.org
 */
public class PostgresBDD implements BDDInterface {
    
    private Connection conn;
    private Statement stmt;

    public PostgresBDD() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver PostgreSQL chargé !");
            
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/microjoe", "microjoe", "");
            stmt = conn.createStatement();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PostgresBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   

    @Override
    public void saveContrat(Contrat contrat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeContrat(Contrat contrat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contrat> listContrats(Voiture vo) {
        try {
            PreparedStatement prep = conn.prepareStatement("SELECT * FROM contrats NATURAL JOIN voitures NATURAL JOIN agents WHERE id_voiture = ?");
            prep.setInt(1, vo.getId());
            ResultSet result = prep.executeQuery();
            ArrayList<Contrat> contrats = new ArrayList<>();
            
            while (result.next()) {
                
                Agent a = new Agent(result.getString("login"), result.getString("mdp"), result.getString("nom"), result.getString("prenom"), result.getInt("id_agent"));
                Voiture v = new Voiture(result.getString("matricule"), result.getString("marque"), result.getInt("kilometrage"), result.getString("couleur"), result.getInt("id_voiture"));
                Contrat c = new Contrat(v, result.getDate("date_debut"), result.getDate("date_fin"), result.getInt("kilometrage_debut"), result.getInt("kilometrage_fin"), a, result.getInt("id_contrat"));
                
                contrats.add(c);
            }
            
            return contrats;
            
        } catch (SQLException ex) {
            Logger.getLogger(PostgresBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public List<Voiture> listVoitures() {
        try {
            ResultSet result = stmt.executeQuery("SELECT * FROM voitures");
            
            List<Voiture> voitures = new ArrayList<>();
            
            while (result.next()) {
                Voiture v = Voiture.fromResultSet(result);
                voitures.add(v);
            }
            
            return voitures;
            
        } catch (SQLException ex) {
            Logger.getLogger(PostgresBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public void saveClient(Client client) {
        try {
            String insert = "INSERT INTO clients VALUES (?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setInt(1, 42); // id
            ps.setString(2, client.getNom());
            ps.setString(3, client.getPrenom());
            ps.setDate(4, new java.sql.Date(client.getDateNaissance().getTime()));
            ps.setString(5, client.getLieuNaissance());
            ps.setInt(6, client.getInfoPermis().getNumero());
            ps.setDate(7, new java.sql.Date(client.getInfoPermis().getDateDelivrance().getTime()));
            ps.setString(8, client.getInfoPermis().getLieuDelivrance());
            ps.setString(9, client.getInfoPermis().getVilleDelivrance());
            
            if (ps.executeUpdate() != 1) {
                System.out.println("L'insertion a échoué");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PostgresBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Client> listClients() {
        try {
            ResultSet result = stmt.executeQuery("SELECT * FROM clients");
            
            List<Client> clients = new ArrayList();
            
            while(result.next()) {
                InfoPermis ip = InfoPermis.fromResultSet(result);
                Client c = Client.fromResultSet(result, ip);
                
                clients.add(c);
            }
            
            return clients;
            
        } catch (SQLException ex) {
            Logger.getLogger(PostgresBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    @Override
    public List<Agent> listAgents() {
        try {
            ResultSet result = stmt.executeQuery("SELECT * FROM agents");
            
            List<Agent> agents = new ArrayList<>();
            
            while(result.next()) {
                Agent a = Agent.fromResultSet(result);
                agents.add(a);
            }
            
            return agents;
            
        } catch (SQLException ex) {
            Logger.getLogger(PostgresBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public boolean checkLogin(String login, String mdp) {
        try {
            PreparedStatement p = conn.prepareStatement("SELECT * FROM agents WHERE login = ? AND mdp = ?");
            
            p.setString(1, login);
            p.setString(2, mdp);
            
            // true si il y a au moins un resultat, false sinon
            return p.executeQuery().next();
            
        } catch (SQLException ex) {
            Logger.getLogger(PostgresBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

}
