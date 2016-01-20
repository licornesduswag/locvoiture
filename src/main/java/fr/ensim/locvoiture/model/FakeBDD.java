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

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Romain Porte (MicroJoe) microjoe at mailoo.org
 */
public class FakeBDD implements BDDInterface {

    @Override
    public void saveContrat(Contrat contrat) {
        System.out.println("SaveContrat " + contrat);
    }

    @Override
    public void removeContrat(Contrat contrat) {
        System.out.println("RemoveContrat " + contrat);
    }

    @Override
    public List<Contrat> listContrats() {
        System.out.println("ListContrats");
        
        return new ArrayList<>();
    }

    @Override
    public List<Voiture> listVoitures() {
        System.out.println("ListVoitures");
        
        return new ArrayList<>();
    }

    @Override
    public void saveClient(Client client) {
        System.out.println("SaveClient");
    }

    @Override
    public List<Client> listClients() {
        System.out.println("ListClients");
        
        return new ArrayList<>();
    }

}
