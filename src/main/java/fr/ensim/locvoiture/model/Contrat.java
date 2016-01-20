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

    public Contrat(Voiture voiture, Date dateDebut, Date dateFin, int kilometrageDebut, int kilometrageFin) {
        this.voiture = voiture;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.kilometrageDebut = kilometrageDebut;
        this.kilometrageFin = kilometrageFin;
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

    @Override
    public String toString() {
        return "Contrat{" + "voiture=" + voiture + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", kilometrageDebut=" + kilometrageDebut + ", kilometrageFin=" + kilometrageFin + '}';
    }
}
