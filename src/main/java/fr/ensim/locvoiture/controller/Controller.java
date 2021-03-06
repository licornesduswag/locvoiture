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
import fr.ensim.locvoiture.bdd.BDDInterface;
import fr.ensim.locvoiture.model.Client;
import fr.ensim.locvoiture.model.Contrat;
import fr.ensim.locvoiture.bdd.PostgresBDD;
import fr.ensim.locvoiture.model.Voiture;
import java.util.List;

/**
 *
 * @author Wojciech Rousseau (Vrong)
 */
public class Controller extends AbstractController{
    
    private final BDDInterface bdd = new PostgresBDD();
    private Agent agent = null;
    
    @Override
    public boolean checkLogin(String login, String password)
    {
        Agent a = bdd.checkLogin(login, password);
        
        if (a != null) {
            agent = a;
            return true;
        }
        
        return false;
    }
    
    @Override
    public List<Voiture> getVoitures()
    {
        return bdd.listVoitures();
    }
    
    @Override
    public List<Contrat> getContrats(Voiture v)
    {
        return bdd.listContrats(v);
    }

    @Override
    public List<Client> getClients() {
        return bdd.listClients();
    }

    @Override
    public Client getClient(Contrat c) {
        return c.getClient();
    }

    @Override
    public Client addClient(Client c) {
        bdd.saveClient(c);
        return c;
    }

    @Override
    public Contrat addContrat(Contrat c) {
        bdd.saveContrat(c);
        notifyObservers();
        return c;
    }

    @Override
    public boolean modifierContrat(Contrat c) {
        bdd.removeContrat(c);
        bdd.saveContrat(c);
        notifyObservers();
        return true;
    }

    @Override
    public Agent getConnectedAgent() {
        return agent;
    }

    @Override
    public Agent getAgent(Contrat c) {
        return c.getAgent();
    }

    @Override
    public boolean modifierClient(Client c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void annulerContrat(Contrat contrat) {
        bdd.removeContrat(contrat);
        notifyObservers();
    }
}
