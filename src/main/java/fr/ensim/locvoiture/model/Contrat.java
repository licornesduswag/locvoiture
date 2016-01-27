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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Romain Porte (MicroJoe) microjoe at mailoo.org
 */
public class Contrat extends BDDBase {
    private Voiture voiture;
    
    private Date dateDebut;
    private Date dateFin;
    
    private int kilometrageDebut;
    private int kilometrageFin;
    
    private Agent agent;
    private Client client;

    public Contrat(Voiture voiture, Date dateDebut, Date dateFin, int kilometrageDebut, int kilometrageFin, Agent agent, Client client) {
        this.voiture = voiture;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.kilometrageDebut = kilometrageDebut;
        this.kilometrageFin = kilometrageFin;
        this.agent = agent;
        this.client = client;
    }

    public Contrat(Voiture voiture, Date dateDebut, Date dateFin, int kilometrageDebut, int kilometrageFin, Agent agent, Client client, int id) {
        super(id);
        this.voiture = voiture;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.kilometrageDebut = kilometrageDebut;
        this.kilometrageFin = kilometrageFin;
        this.agent = agent;
        this.client = client;
    }
    
    public static Contrat fromResultSet(ResultSet result, Voiture v, Agent a, Client c) throws SQLException {
        return new Contrat(v, result.getDate("date_debut"), result.getDate("date_fin"), result.getInt("kilometrage_debut"), result.getInt("kilometrage_fin"), a, c, result.getInt("id_contrat"));
    }

    public Contrat() {
    }
    
    // Getters & setters

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
        notifyObservers();
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
        notifyObservers();
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
        notifyObservers();
    }

    public int getKilometrageDebut() {
        return kilometrageDebut;
    }

    public void setKilometrageDebut(int kilometrageDebut) {
        this.kilometrageDebut = kilometrageDebut;
        notifyObservers();
    }

    public int getKilometrageFin() {
        return kilometrageFin;
    }

    public void setKilometrageFin(int kilometrageFin) {
        this.kilometrageFin = kilometrageFin;
        notifyObservers();
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    

    @Override
    public String toString() {
        return getId() + "";
    }

    
}
