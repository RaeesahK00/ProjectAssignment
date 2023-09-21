/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package runproject;

import javax.swing.JFrame;

/**
 *
 * @author 221376321 Mogammad Mas'ood Lamera
 */
public class RunProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         studyChoiceGui gui = new studyChoiceGui();
        gui.setVisible(true);
        gui.setTitle("University Selection");
        gui.setGui();
        gui.setSize(800, 800);
        gui.setLocationRelativeTo(null);
        gui.setDefaultCloseOperation(gui.EXIT_ON_CLOSE);

        
    }
    
}
