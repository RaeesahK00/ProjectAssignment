/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.projectassignment1;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Desktop
 */
public class HomePage extends JFrame {

    private JPanel panelN, panelS, panelE, panelC;
    private JLabel picture, heading, username, applied, links, outcome;
    private JTextField usernameTxt, appliedTxt1, appliedTxt2, appliedTxt3, linkTxt, outcomeTxt;
    private JButton home, faq, profile;

    public HomePage() {

        panelN = new JPanel(new GridLayout(2, 1));
        panelN.setBackground(Color.LIGHT_GRAY);
        panelS = new JPanel(new GridLayout(1, 3, 5, 5));
        panelC = new JPanel(new GridLayout(20, 2, 5, 5));

        picture = new JLabel(new ImageIcon("1.jpg"));
        heading = new JLabel("Hello, Username");
        username = new JLabel();
        applied = new JLabel();
        links = new JLabel();
        outcome = new JLabel();

    }

    public void setGui() {

        faq.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (e.getSource() == faq) {

                    int result = JOptionPane.showOptionDialog(null,
                            "Are you sure you want to go to the FAQ page, going there will clear all information entered here.", "Confirmation",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                            new String[]{"Yes", "No"}, "Yes");

                    if (result == JOptionPane.YES_OPTION) {
                        FAQ faqs = new FAQ();
                        faqs.setTitle("FAQ Page");
                        faqs.setVisible(true);
                        faqs.setLocationRelativeTo(null);
                        setVisible(false);

                    }
                }
            }
        }
        );

        profile.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (e.getSource() == profile) {
                    int result = JOptionPane.showOptionDialog(null,
                            "Are you sure you want to go to the profile page, going there will clear all information entered here.", "Confirmation",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                            new String[]{"Yes", "No"}, "Yes");

                    if (result == JOptionPane.YES_OPTION) {
                        UserGui gui2 = new UserGui();
                        gui2.setVisible(true);
                        gui2.setTitle("User Information");
                        gui2.setGui2();
                        gui2.setSize(800, 800);
                        gui2.setLocationRelativeTo(null);
                        gui2.setDefaultCloseOperation(gui2.EXIT_ON_CLOSE);
                        setVisible(false);
                    }
                }
            }
        }
        );
    }

}
