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

import fr.ensim.locvoiture.controller.AbstractController;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 *
 * @author Wojciech Rousseau (Vrong)
 */
public class LoginWindow extends MvcView {
    
    
    private JTextField login;
    private JPasswordField password;
    private JButton connexion;
    private JLabel titre = new JLabel("Veuillez vous connecter", JLabel.CENTER);
    
    
    public LoginWindow(AbstractController controller)
    {
        super(controller);
        
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        
        this.setLayout(new GridLayout(6, 1));
        
        JLabel tmp = titre;
        tmp.setOpaque(true);
        tmp.setBackground(Color.YELLOW);
        //TODO changer la taille du texte Connexion
        this.add(tmp);
        
        tmp = new JLabel("Login", JLabel.CENTER);
        this.add(tmp);
        
        login = new JTextField();
        this.add(login);
        
        tmp = new JLabel("Password", JLabel.CENTER);
        this.add(tmp);
        
        password = new JPasswordField();
        this.add(password);
        
        connexion = new JButton("Se connecter");
        connexion.setBackground(Color.GREEN);
        this.add(connexion);
        
        connexion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                connexion.setText("Connexion en cours...");
                connexion.setBackground(Color.GRAY);
                if(controller.checkLogin(login.getText(), password.getText()))
                {
                    //LoginWindow.this.setVisible(false);
                    
                    new MainWindow(controller, login.getText(), password.getText());
                    
                    
                    //LoginWindow.this.dispatchEvent(new WindowEvent(LoginWindow.this, WindowEvent.WINDOW_CLOSING));
                    
                    titre.setText("Veuillez vous connecter");
                    titre.setBackground(Color.CYAN);
                    LoginWindow.this.dispose();
                            
                }else
                {
                    titre.setText("Login ou mot de passe incorrect");
                    titre.setBackground(Color.red);
                }
                
                /*LoginWindow.this.setVisible(true);
                connexion.setText("Connexion");
                connexion.setBackground(Color.GREEN);*/
                
            }
        });
        
        
        
        
        this.setVisible(true);
    }
}
