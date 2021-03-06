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
 * THE SOFTWARE.Smyste
 */

package fr.ensim.locvoiture.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Romain Porte (MicroJoe) microjoe at mailoo.org
 */
public class Voiture extends BDDBase {
    private String matricule;
    private String marque;
    private int kilometrage;
    private String couleur;
    private int prix;

    public Voiture(String matricule, String marque, int kilometrage, String couleur, int prix) {
        this.matricule = matricule;
        this.marque = marque;
        this.kilometrage = kilometrage;
        this.couleur = couleur;
        this.prix = prix;
    }

    public Voiture(String matricule, String marque, int kilometrage, String couleur, int prix, int id) {
        super(id);
        this.matricule = matricule;
        this.marque = marque;
        this.kilometrage = kilometrage;
        this.couleur = couleur;
        this.prix = prix;
    }    
    
    public static Voiture fromResultSet(ResultSet result) throws SQLException {
        return new Voiture(result.getString("matricule"), result.getString("marque"), result.getInt("kilometrage"), result.getString("couleur"), result.getInt("prix"), result.getInt("id_voiture"));
    }
    
    // Getters & setters

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
        notifyObservers();
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
        notifyObservers();
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
        notifyObservers();
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
        notifyObservers();
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    
    

    @Override
    public String toString() {
        return this.getMatricule();
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Voiture)
            if(((Voiture)o).getId() == this.getId())
                return true;
        return false;
    }
}
