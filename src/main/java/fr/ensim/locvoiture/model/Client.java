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
public class Client extends Personne {
    
    
    private Date dateNaissance;
    private String lieuNaissance;
    
    private InfoPermis infoPermis;

    public Client(String nom, String prenom, Date dateNaissance, String lieuNaissance, InfoPermis infoPermis) {
        super(nom, prenom);
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.infoPermis = infoPermis;
    }

    public Client(String nom, String prenom, Date dateNaissance, String lieuNaissance, InfoPermis infoPermis, int id) {
        super(nom, prenom, id);
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.infoPermis = infoPermis;
    }
    

    public static Client fromResultSet(ResultSet result, InfoPermis ip) throws SQLException {
        return new Client(result.getString("nom"), result.getString("prenom"), result.getDate("date_naissance"), result.getString("lieu_naissance"), ip, result.getInt("id_client"));
    }

    public Client(String nom, String prenom) {
        super(nom, prenom);
    }

    // Getters & setters

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
        notifyObservers();
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
        notifyObservers();
    }

    public InfoPermis getInfoPermis() {
        return infoPermis;
    }

    public void setInfoPermis(InfoPermis infoPermis) {
        this.infoPermis = infoPermis;
        notifyObservers();
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}
