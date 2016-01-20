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
package fr.ensim.locvoiture.view;

import fr.ensim.locvoiture.controller.Controller;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 *
 * @author Wojciech Rousseau (Vrong)
 */
public class LoginWindow extends MvcView {
    
    
    private JTextField login;
    private JTextField password;
    private JButton connexion;
    
    public LoginWindow(Controller controller)
    {
        super(controller);
        this.setLayout(new GridLayout(6, 1));
        JLabel tmp = new JLabel("Connexion");
        //TODO changer la taille tu texte Connexion
        this.add(tmp);
        
        this.add(new JLabel("Login"));
        
        login = new JTextField();
        this.add(login);
        
        this.add(new JLabel("Password"));
        
        password = new JTextField();
        this.add(password);
        
        this.add(connexion);
        
        this.setVisible(true);
    }
}
