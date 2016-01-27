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
package fr.ensim.locvoiture.controller;

import fr.ensim.locvoiture.model.Agent;
import fr.ensim.locvoiture.model.Client;
import fr.ensim.locvoiture.model.Contrat;
import fr.ensim.locvoiture.model.InfoPermis;
import fr.ensim.locvoiture.model.Voiture;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Wojciech Rousseau (Vrong)
 */
public class DummyController extends AbstractController{

    Agent agent;
    
    @Override
    public boolean checkLogin(String login, String password) {
        agent = new Agent("patrick", "biginjapan", "Porte", "Patrick");
        return true;
    }

    @Override
    public List<Voiture> getVoitures() {
        List<Voiture> voitures = new ArrayList<>();
        voitures.add(new Voiture("SUPER5", "Renault", 18555, "ROUGE"));
        voitures.add(new Voiture("mat12", "JAVA", 8945, "VERTE"));
        voitures.add(new Voiture("mat851", "TRUC", 3657, "MARRON"));
        voitures.add(new Voiture("SUPERMAN", "PONEY", 159, "JAUNE FLUO"));
        
        return voitures;
    }

    @Override
    public List<Contrat> getContrats(Voiture v) {
        List<Contrat> contrats = new ArrayList<>();
        contrats.add(new Contrat(v, new Date(2015, 12, 2), new Date(2016, 2, 2), 52, 89, getConnectedAgent()));
        contrats.add(new Contrat(v, new Date(2014, 06, 24), new Date(2015, 1, 21), 52, 89, getConnectedAgent()));
        
        return contrats;
    }

    @Override
    public List<Client> getClients() {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Séchan", "Renaud", new Date(1952, 3, 11), "Paris", new InfoPermis(547, new Date(1967, 11, 24), "PARIS", "PARIS")));
        clients.add(new Client("Poole", "Christopher", new Date(1988, 5, 15), "moot", new InfoPermis(854, new Date(1994, 8, 2), "moot", "moot"))); 
        
        return clients;
    }

    @Override
    public Client getClient(Voiture v) {
        return new Client("Séchan", "Renaud", new Date(1952, 3, 11), "Paris", new InfoPermis(547, new Date(1967, 11, 24), "PARIS", "PARIS"));
    }

    @Override
    public boolean addClient(Client c) {
        return true;
    }

    @Override
    public boolean addContrat(Contrat c) {
        return true;
    }

    @Override
    public boolean modifierContrat(Contrat c) {
        return true;
    }

    @Override
    public Agent getConnectedAgent() {
        return agent;
    }
    
}
