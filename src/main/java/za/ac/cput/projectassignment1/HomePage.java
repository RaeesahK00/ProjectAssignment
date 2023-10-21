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

    private JPanel panelN, panelS, panelE, panelC, panelheading;
    private JLabel picture, heading, username, applied, links,link1,link2,link3, outcome, outcomeTxt;
    private JLabel usernameTxt, appliedTxt1, appliedTxt2, appliedTxt3, linkTxt;
    private JButton home, faq, profile;
    private JTextArea text, text1;
    private Font font1, font2, font3;
    private JScrollPane scrollPane;

    public HomePage() {

        font1 = new Font("Arial", Font.BOLD, 20);
        font2 = new Font("Arial", Font.BOLD, 18);
        font3 = new Font("Arial", Font.PLAIN, 16);

        panelN = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelN.setBackground(Color.LIGHT_GRAY);
        panelS = new JPanel(new GridLayout(1, 3, 5, 5));
        panelC = new JPanel(new GridLayout(13, 1, 5, 5));

        picture = new JLabel(new ImageIcon("1.jpg"));
        heading = new JLabel("Hello, Username");
        heading.setFont(font1);

        username = new JLabel("Username");
        username.setFont(font2);

        applied = new JLabel("Courses applied for: ");
        applied.setFont(font2);

        links = new JLabel("Links to bursary opprtunities: ");
        links.setFont(font2);
        
        link1 = new JLabel("Link1 ");
        link1.setFont(font3);
        
        link2 = new JLabel("Link2 ");
        link2.setFont(font3);
        
        link3 = new JLabel("Link3 ");
        link3.setFont(font3);

        outcome = new JLabel("Outcome of application status: ");
        outcome.setFont(font2);

        outcomeTxt = new JLabel("Application pending:  ");
        outcomeTxt.setFont(font3);

        usernameTxt = new JLabel("Hello, Username");
        heading.setFont(font3);

        appliedTxt1 = new JLabel("course1");
        appliedTxt1.setFont(font3);

        appliedTxt2 = new JLabel("course2");
        appliedTxt2.setFont(font3);

        appliedTxt3 = new JLabel("course3");
        appliedTxt3.setFont(font3);

        linkTxt = new JLabel("link1");
        linkTxt.setFont(font3);

        home = new JButton("Home Page");
        home.setFont(font2);
        faq = new JButton("FAQ Page");
        faq.setFont(font2);
        profile = new JButton("Profile Page");
        profile.setFont(font2);

//        text = new JTextArea(""" 
//                            Online Application 
//                            New Application
//                             
//                            1) This Application will consist of 3 Sections, please complete all these sections.
//                             
//                            2)  Read carefully before completing, submitting the application form.
//                             
//                            3)  Please complete and fill in all information requested on the application form.
//                             
//                            4)  Please ensure that all documents required are certified copies and are submitted in pdf format. 
//                             """);
//        text.setFont(font2);
//        text.setEditable(false);
//        text.setBackground(Color.LIGHT_GRAY);
//        text.setPreferredSize(new Dimension(190, 190));
//        
//---------------------------------
        //        text1 = new JTextArea(""" 
//                            Online Application 
//                            New Application
//                             
//                            1) This Application will consist of 3 Sections, please complete all these sections.
//                             
//                            2)  Read carefully before completing, submitting the application form.
//                             
//                            3)  Please complete and fill in all information requested on the application form.
//                             
//                            4)  Please ensure that all documents required are certified copies and are submitted in pdf format. 
//                             """);
//        text1.setFont(font2);
//        text1.setEditable(false);
//        text1.setBackground(Color.LIGHT_GRAY);
//        text1.setPreferredSize(new Dimension(190, 190));
    }

    public void setGui() {

        panelN.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelC.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panelN.add(picture);
        panelN.add(heading);

        panelC.add(username);
        panelC.add(usernameTxt);
        panelC.add(applied);
        panelC.add(appliedTxt1);
        panelC.add(appliedTxt2);
        panelC.add(appliedTxt3);
        panelC.add(links);
        panelC.add(link1);
        panelC.add(link2);
        panelC.add(link3);
        panelC.add(linkTxt);
        panelC.add(outcome);
        panelC.add(outcomeTxt);

        panelS.add(home);
        panelS.add(faq);
        panelS.add(profile);

        add(panelN, BorderLayout.NORTH);
        add(panelC, BorderLayout.CENTER);
        add(panelS, BorderLayout.SOUTH);

        scrollPane = new JScrollPane(panelC);

        scrollPane.setPreferredSize(new Dimension(800, 800));

        add(getContentPane().add(scrollPane));

        faq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

        profile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
