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

/**
 *
 * @author Romain Porte (MicroJoe) microjoe at mailoo.org
 */
public class Agent extends Personne {
    private String login;
    private String mdp;

    public Agent(String login, String mdp, String nom, String prenom) {
        super(nom, prenom);
        this.login = login;
        this.mdp = mdp;
    }

    public Agent(String login, String mdp, String nom, String prenom, int id) {
        super(nom, prenom, id);
        this.login = login;
        this.mdp = mdp;
    }
    
    public static Agent fromResultSet(ResultSet result) throws SQLException {
        return new Agent(result.getString("login"), result.getString("mdp"), result.getString("nom"), result.getString("prenom"), result.getInt("id_agent"));
    }
    
    // Getters & setters

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    
}
