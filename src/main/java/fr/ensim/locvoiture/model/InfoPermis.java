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
public class InfoPermis extends BDDBase {
    private int numero;
    
    private Date dateDelivrance;
    private String lieuDelivrance;
    private String villeDelivrance;

    public InfoPermis(int numero, Date dateDelivrance, String lieuDelivrance, String villeDelivrance) {
        this.numero = numero;
        this.dateDelivrance = dateDelivrance;
        this.lieuDelivrance = lieuDelivrance;
        this.villeDelivrance = villeDelivrance;
    }
    
    // Getters & setters

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
        notifyObservers();
    }

    public Date getDateDelivrance() {
        return dateDelivrance;
    }

    public void setDateDelivrance(Date dateDelivrance) {
        this.dateDelivrance = dateDelivrance;
        notifyObservers();
    }

    public String getLieuDelivrance() {
        return lieuDelivrance;
    }

    public void setLieuDelivrance(String lieuDelivrance) {
        this.lieuDelivrance = lieuDelivrance;
        notifyObservers();
    }

    public String getVilleDelivrance() {
        return villeDelivrance;
    }

    public void setVilleDelivrance(String villeDelivrance) {
        this.villeDelivrance = villeDelivrance;
        notifyObservers();
    }

    @Override
    public String toString() {
        return "InfoPermis{" + "numero=" + numero + ", dateDelivrance=" + dateDelivrance + ", lieuDelivrance=" + lieuDelivrance + ", villeDelivrance=" + villeDelivrance + '}';
    }
    
    
}
