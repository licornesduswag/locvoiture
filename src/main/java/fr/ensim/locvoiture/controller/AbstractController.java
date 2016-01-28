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
import fr.ensim.locvoiture.model.Voiture;
import fr.ensim.locvoiture.observer.AbstractObservable;
import java.util.List;

/**
 *
 * @author Wojciech Rousseau (Vrong)
 */
public abstract class AbstractController extends AbstractObservable{
    public abstract boolean checkLogin(String login, String password);
    public abstract List<Voiture> getVoitures();
    public abstract List<Contrat> getContrats(Voiture v);
    public abstract List<Client> getClients();
    public abstract Client getClient(Contrat c);
    public abstract Agent getAgent(Contrat c);
    public abstract Client addClient(Client c);
    public abstract Contrat addContrat(Contrat c);
    public abstract boolean modifierContrat(Contrat c);
    public abstract boolean modifierClient(Client c);
    public abstract Agent getConnectedAgent();
    public abstract void annulerContrat(Contrat contrat);
}
