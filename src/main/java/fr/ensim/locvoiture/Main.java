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

package fr.ensim.locvoiture;

import fr.ensim.locvoiture.model.Agent;
import fr.ensim.locvoiture.model.Client;
import fr.ensim.locvoiture.model.Contrat;
import fr.ensim.locvoiture.model.InfoPermis;
import fr.ensim.locvoiture.model.PostgresBDD;
import fr.ensim.locvoiture.model.Voiture;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Romain Porte (MicroJoe) microjoe at mailoo.org
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        
        PostgresBDD bdd = new PostgresBDD();
        
        System.out.println("Liste des contrats...");
        
        List<Contrat> list = bdd.listContrats();
        
        for (Contrat c : list) {
            System.out.println(c.getId());
            System.out.println(c);
        }
        
        System.out.println("Liste des clients...");
        
        List<Client> listC = bdd.listClients();
        
        for (Client c : listC) {
            System.out.println(c.getId());
            System.out.println(c);
        }
        
        System.out.println("Liste des voitures...");
        
        List<Voiture> listV = bdd.listVoitures();
        
        for (Voiture v : listV) {
            System.out.println(v.getId());
            System.out.println(v);
        }
        
        System.out.println("Liste des agents...");
        
        List<Agent> listA = bdd.listAgents();
        
        for (Agent a : listA) {
            System.out.println(a.getId());
            System.out.println(a);
        }
        
        Client c = new Client("toto", "truc", new Date(123456), "Le Mans", new InfoPermis(123456, new Date(123456), "Le Mans", "Le Mans"));
        bdd.saveClient(c);
    }
}