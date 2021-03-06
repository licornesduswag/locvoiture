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
package fr.ensim.locvoiture;

import fr.ensim.locvoiture.controller.AbstractController;
import fr.ensim.locvoiture.controller.Controller;
import fr.ensim.locvoiture.controller.DummyController;
import fr.ensim.locvoiture.view.LoginWindow;

/**
 *
 * @author Wojciech Rousseau (Vrong)
 */
public class TrueMain {
    
    public static final boolean dummy = false;
    
    public static void main(String args[])
    {
        System.out.println("test");
        AbstractController controller;
        if(dummy)
            controller = new DummyController();
        else
            controller = new Controller();
        
        new LoginWindow(controller);
        System.out.println("fin");
    }
}
