/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.projectassignment1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.*;

/**
 *
 * @author 221376321 Mogammad Mas'ood Lamera
 */
public class studyChoiceGui extends JFrame {

    ApsScorePage aps = new ApsScorePage();
    Font font1 = new Font("Arial", Font.BOLD, 20);
    Font font2 = new Font("Arial", Font.BOLD, 16);
    Font font3 = new Font("Arial", Font.PLAIN, 16);
    JPanel pnlN, pnlC, pnlS;
    // JTextArea courseInfoArea, courseInfoArea2, courseInfoArea3;
    JTextArea txtInfo;
    JLabel lblSelect, lblSpace;
    JLabel lblDiploma;
    JComboBox cmbUniOne;
    JButton btnFaq, btnProfile, btnHome, btnSave, btnSpace, btnSpace2;
    JRadioButton rbtnCourseOne, rbtnCourseOne1, rbtnCourseTwo, rbtnCourseTwo2, rbtnCourseThree, rbtnCourseThree3, rbtnCourseThree4, rbtnCourseThree5, rbtnCourseThree6;
    FileWriter fw;
    BufferedWriter bw;
    String txtFileHeadingOne, txtFileHeadingTwo;
    //  UniversityGui uG = new UniversityGui();
    UniversityDomain domain;
    DAO dao;

    public studyChoiceGui() {
        pnlN = new JPanel();
        pnlN.setBackground(Color.LIGHT_GRAY);
        pnlC = new JPanel();
        pnlS = new JPanel();

        cmbUniOne = new JComboBox();
        cmbUniOne.setFont(font2);
        cmbUniOne.setPreferredSize(new Dimension(60, 60));

        btnFaq = new JButton("FAQ");
        btnFaq.setFont(font2);
        btnProfile = new JButton("Profile");
        btnProfile.setFont(font2);
        btnHome = new JButton("Home");
        btnHome.setFont(font2);
        btnSave = new JButton("Save");
        btnSave.setFont(font2);
        btnSpace = new JButton();
        btnSpace.setVisible(false);
        btnSpace2 = new JButton();
        btnSpace2.setVisible(false);

        lblSelect = new JLabel("Please select a University of your choice below.");
        lblSelect.setFont(font2);
        lblSelect.setHorizontalAlignment(JLabel.CENTER);
        lblDiploma = new JLabel("DIPLOMA IN INFORMATION & COMMUNICATION TECHNOLOGY \n    ");
        lblDiploma.setFont(font1);
        lblDiploma.setHorizontalAlignment(JLabel.CENTER);
        lblDiploma.setForeground(Color.blue);
        lblSpace = new JLabel();
        txtInfo = new JTextArea(30, 50);
        txtInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        txtInfo.setFont(font3);
        rbtnCourseOne = new JRadioButton();
        rbtnCourseOne.setPreferredSize(new Dimension(55, 55));
        rbtnCourseOne.setVisible(false);
        rbtnCourseOne.setFont(font2);
        rbtnCourseTwo = new JRadioButton();
        rbtnCourseTwo.setPreferredSize(new Dimension(55, 55));
        rbtnCourseTwo.setVisible(false);
        rbtnCourseTwo.setFont(font2);
        rbtnCourseThree = new JRadioButton();
        rbtnCourseThree.setPreferredSize(new Dimension(55, 55));
        rbtnCourseThree.setVisible(false);
        rbtnCourseThree.setFont(font2);

        ButtonGroup group = new ButtonGroup();
        group.add(rbtnCourseOne);
        group.add(rbtnCourseTwo);
        group.add(rbtnCourseThree);

        domain = new UniversityDomain();
        dao = new DAO();
    }
    String id;
    int submissionID;

    public void setGui() {
        id = JOptionPane.showInputDialog("Please enter your ID to continue");

        if (id.equals(JOptionPane.CANCEL_OPTION)) {
            System.exit(0);
        }
        while (id.length() != 13 || !(id.matches("[0-9]+"))) {

            JOptionPane.showMessageDialog(null, "Please enter a valid ID");
            id = JOptionPane.showInputDialog("Please enter your ID to continue");

        }
        submissionID = dao.submission();
        String[] universities = {"University of Cape Town", "Cape Peninsula University of Technology", "University of Western Cape"};
        for (int i = 0; i < 3; i++) {
            cmbUniOne.addItem(universities[i]);
        }

        txtInfo.setBackground(Color.WHITE);

        btnProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnProfile) {
                    int result = JOptionPane.showOptionDialog(null,
                            "Are you sure you want to go to Profile Page? "
                            + "Going there will clear all information entered here.", "Confirmation",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                            new String[]{"Yes", "No"}, "Yes");

                    if (result == JOptionPane.YES_OPTION) {

                        UserGui gui2 = new UserGui();
                        gui2.setVisible(true);
                        gui2.setTitle("User Information");
                        gui2.setGui2();
                        gui2.setSize(800, 800);
                        gui2.setDefaultCloseOperation(gui2.EXIT_ON_CLOSE);
                        gui2.setLocationRelativeTo(null);
                        setVisible(false);
                    }
                }

            }

        });

        //Add array elements to combobox
        //combobox one action listener
        cmbUniOne.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                rbtnCourseOne.setSelected(false);
                rbtnCourseTwo.setSelected(false);
                rbtnCourseThree.setSelected(false);
                String selected = (String) cmbUniOne.getSelectedItem();
                txtInfo.setText("");

////                String facultyOne = uG.txt1.getText();
////                if (facultyOne.equalsIgnoreCase("Faculty of Informatics and Design")) {
                if (selected.equals("University of Cape Town")) {
                    rbtnCourseOne.setVisible(true);
                    rbtnCourseOne.setText("Mobile Application Development");
                    rbtnCourseTwo.setVisible(true);
                    rbtnCourseTwo.setText("Human-Computer Interaction");
                    rbtnCourseThree.setVisible(true);
                    rbtnCourseThree.setText("Web Development ");

                }
                if (selected.equals("Cape Peninsula University of Technology")) {
                    rbtnCourseOne.setVisible(true);
                    rbtnCourseOne.setText("Application Development Foundation");
                    rbtnCourseTwo.setVisible(true);
                    rbtnCourseTwo.setText("Communication Network Foundation");
                    rbtnCourseThree.setVisible(true);
                    rbtnCourseThree.setText("Multimedia");

                }
                if (selected.equals("University of Western Cape")) {
                    rbtnCourseOne.setVisible(true);
                    rbtnCourseOne.setText("Artificial Intelligence");
                    rbtnCourseTwo.setVisible(true);
                    rbtnCourseTwo.setText("Information Security");
                    rbtnCourseThree.setVisible(true);
                    rbtnCourseThree.setText("Computer Graphics");
                } //  }
                else //                if (facultyOne.equalsIgnoreCase("Faculty of Applied Sciences")) {
                if (selected.equals("University of Cape Town")) {
                    rbtnCourseOne.setVisible(true);
                    rbtnCourseOne.setText("Archaeology");
                    rbtnCourseTwo.setVisible(true);
                    rbtnCourseTwo.setText("Chemistry");
                    rbtnCourseThree.setVisible(true);
                    rbtnCourseThree.setText("Environmental And Geographical Science");

                } else if (selected.equals("Cape Peninsula University of Technology")) {

                    rbtnCourseOne.setVisible(true);
                    rbtnCourseOne.setText("Biotechnology");
                    rbtnCourseTwo.setVisible(true);
                    rbtnCourseTwo.setText("Marine Science");
                    rbtnCourseThree.setVisible(true);
                    rbtnCourseThree.setText("Environmental Health");

                } else if (selected.equals("University of Western Cape")) {
                    rbtnCourseOne.setVisible(true);
                    rbtnCourseOne.setText("Bachelor of Pharmacy");
                    rbtnCourseTwo.setVisible(true);
                    rbtnCourseTwo.setText("BSc Biotechnology");
                    rbtnCourseThree.setVisible(true);
                    rbtnCourseThree.setText("BSc Chemical Sciences");
                } //  } 
                else //if (facultyOne.equalsIgnoreCase("Faculty of Business and Management Sciences")) {
                if (selected.equals("University of Cape Town")) {
                    rbtnCourseOne.setVisible(true);
                    rbtnCourseOne.setText("Commerce IT Support");
                    rbtnCourseTwo.setVisible(true);
                    rbtnCourseTwo.setText("Management Studies");
                    rbtnCourseThree.setVisible(true);
                    rbtnCourseThree.setText("College of Accounting");

                } else if (selected.equals("Cape Peninsula University of Technology")) {

                    rbtnCourseOne.setVisible(true);
                    rbtnCourseOne.setText("Paralegal");
                    rbtnCourseTwo.setVisible(true);
                    rbtnCourseTwo.setText("Hospitality");
                    rbtnCourseThree.setVisible(true);
                    rbtnCourseThree.setText("Tourism and Sports");

                } else if (selected.equals("University of Western Cape")) {
                    rbtnCourseOne.setVisible(true);
                    rbtnCourseOne.setText("Bachelor of Administration");
                    rbtnCourseTwo.setVisible(true);
                    rbtnCourseTwo.setText("Financial Accounting");
                    rbtnCourseThree.setVisible(true);
                    rbtnCourseThree.setText("BCom in Information Systems");
                } //      }
                else //    if (facultyOne.equalsIgnoreCase("Faculty of Engineering & the Built Environment")) {
                if (selected.equals("University of Cape Town")) {
                    rbtnCourseOne.setVisible(true);
                    rbtnCourseOne.setText("Architecture and Planning");
                    rbtnCourseTwo.setVisible(true);
                    rbtnCourseTwo.setText("Construction Economics and Management");
                    rbtnCourseThree.setVisible(true);
                    rbtnCourseThree.setText("Electronic Engineering");

                } else if (selected.equals("Cape Peninsula University of Technology")) {

                    rbtnCourseOne.setVisible(true);
                    rbtnCourseOne.setText("Chemical Engineering");
                    rbtnCourseTwo.setVisible(true);
                    rbtnCourseTwo.setText("Civil Engineering");
                    rbtnCourseThree.setVisible(true);
                    rbtnCourseThree.setText("Mechanical and Mechatronic Engineering");

                } else if (selected.equals("University of Western Cape")) {
                    rbtnCourseOne.setVisible(true);
                    rbtnCourseOne.setText("Electrical Engineering");
                    rbtnCourseTwo.setVisible(true);
                    rbtnCourseTwo.setText("Environmental Health");
                    rbtnCourseThree.setVisible(true);
                    rbtnCourseThree.setText("Environmental Science");
                } //  } 
                else //if (facultyOne.equalsIgnoreCase("")) {
                if (selected.equals("University of Cape Town")) {
                    rbtnCourseOne.setVisible(true);
                    rbtnCourseOne.setText("Archaeology");
                    rbtnCourseTwo.setVisible(true);
                    rbtnCourseTwo.setText("Chemistry");
                    rbtnCourseThree.setVisible(true);
                    rbtnCourseThree.setText("Environmental And Geographical Science");

                } else if (selected.equals("Cape Peninsula University of Technology")) {

                    rbtnCourseOne.setVisible(true);
                    rbtnCourseOne.setText("Biotechnology");
                    rbtnCourseTwo.setVisible(true);
                    rbtnCourseTwo.setText("Marine Science");
                    rbtnCourseThree.setVisible(true);
                    rbtnCourseThree.setText("Environmental Health");

                } else if (selected.equals("University of Western Cape")) {
                    rbtnCourseOne.setVisible(true);
                    rbtnCourseOne.setText("Bachelor of Pharmacy");
                    rbtnCourseTwo.setVisible(true);
                    rbtnCourseTwo.setText("BSc Biotechnology");
                    rbtnCourseThree.setVisible(true);
                    rbtnCourseThree.setText("BSc Chemical Sciences");
                }
            }
            // }
        }
        );
        //radio button one action listener
        rbtnCourseOne.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                txtInfo.setVisible(false);
                if (rbtnCourseOne.isSelected() && rbtnCourseOne.getText().equals("Mobile Application Development")) {

                    txtInfo.setVisible(true);
                    txtInfo.setText("Mobile Application Development:\nStudents learn the principles and practices of developing mobile applications, focusing on platform-\nspecific technologies and frameworks for iOS and Android.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseOne.isSelected() && rbtnCourseOne.getText().equals("Application Development Foundation")) {

                    txtInfo.setVisible(true);
                    txtInfo.setText(""" 
                                           Application development encompasses the entire lifecycle of creating software applications. It involves analyzing user requirements, designing the application's 
                                           architecture and user interface, writing code to implement the desired functionality, testing for bugs and performance issues, and deploying the application for users to use.
                                           Application developers employ various programming languages, development frameworks, and software development methodologies to efficiently and effectively build robust and 
                                           user-friendly applications.""");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseOne.isSelected() && rbtnCourseOne.getText().equals("Artificial Intelligence")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Artificial Intelligence:\nThis course provides an introduction to artificial intelligence, covering topics such as problem-solving,\nknowledge representation,machine learning, and natural language processing.");
                    txtInfo.setEditable(false);
                }
            }
        }
        );

        //radio button Two action listener
        rbtnCourseTwo.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {

                if (rbtnCourseTwo.isSelected() && rbtnCourseTwo.getText().equals("Human-Computer Interaction")) {

                    txtInfo.setVisible(true);
                    txtInfo.setText("Human-Computer Interaction:\nThis course explores the design and evaluation of user  interfaces, emphasizing user-centered design\nprinciples,usability testing, and interaction design patterns. ");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseTwo.isSelected() && rbtnCourseTwo.getText().equals("Communication Network Foundation")) {

                    txtInfo.setVisible(true);
                    txtInfo.setText("""
                                            Communication networks are complex systems that enable the seamless exchange of information and data between different devices, such
                                            as computers, smartphones, servers, and IoT devices. These networks establish connections, protocols, and infrastructure to facilitate
                                            data transmission over short or long distances. Communication networks can be wired (using technologies like Ethernet) or wireless 
                                            (utilizing technologies like Wi-Fi, cellular networks, or satellite connections). """);
                    txtInfo.setEditable(false);
                } else if (rbtnCourseTwo.isSelected() && rbtnCourseTwo.getText().equals("Information Security")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Information Security:\nAn exploration of the principles and practices of information security, including cryptography, network\nsecurity, secure coding, and risk management to protect data and systems.");
                    txtInfo.setEditable(false);
                }
            }
        }
        );
        //radio button Three action listener
        rbtnCourseThree.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (rbtnCourseThree.isSelected() && rbtnCourseThree.getText().equals("Web Development ")) {

                    txtInfo.setVisible(true);
                    txtInfo.setText("Web Development: \n"
                            + "This course covers the development of web-based applications, including front-end technologies (HTML,\nCSS, JavaScript)and back-end technologies (web servers, databases, frameworks)  to create\ninteractive and dynamic websites. ");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseThree.isSelected() && rbtnCourseThree.getText().equals("Multimedia")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("""
                                            Multimedia applications involve the integration of various media elements, such as text,  images, audio, video, and animations, to create interactive and engaging content. These
                                            applications are used for purposes like entertainment, education, marketing, and communication.  Multimedia applications encompass a wide range of software, including video editing tools,
                                            interactive presentations, virtual reality experiences, and gaming applications. They leverage different media formats to deliver rich and immersive experiences to users.""");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseThree.isSelected() && rbtnCourseThree.getText().equals("Computer Graphics")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Computer Graphics:\nStudents learn the principles and techniques behind computer-generated imagery,including 2D and 3D graphics rendering,\n animation, and graphics programming.");
                    txtInfo.setEditable(false);
                }
            }

        }
        );
        btnFaq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnFaq) {

                    int result = JOptionPane.showOptionDialog(null,
                            "Are you sure you want to go to the FAQ page, going there will clear all information entered here and there is no backtracking.", "Confirmation",
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

        });
        btnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Goes to Home page");
                ProjectHomePage faqs = new ProjectHomePage();
                faqs.setTitle("Home Page");
                faqs.setVisible(true);
                faqs.setLocationRelativeTo(null);
                setVisible(false);
            }

        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                submissionID++;
                System.out.println("Submission ID: " + submissionID);
                String University = (String) cmbUniOne.getSelectedItem();
                String course = "";
                if (rbtnCourseOne.isSelected()) {
                    course = (String) rbtnCourseOne.getText();
                } else if (rbtnCourseTwo.isSelected()) {
                    course = (String) rbtnCourseTwo.getText();
                } else if (rbtnCourseThree.isSelected()) {
                    course = (String) rbtnCourseThree.getText();
                }
                String[] options = new String[2];
                options[0] = "Save and Continue";
                options[1] = "Save";
                if (rbtnCourseOne.isSelected() || rbtnCourseTwo.isSelected() || rbtnCourseThree.isSelected()) {
                    // int response = JOptionPane.showConfirmDialog(null, "If you are satisfied with the chosen universities, click 'Save'." + " If you would like to choose more, click 'Save and Continue'");
                    int response = JOptionPane.showOptionDialog(null, "If you are satisfied with the chosen universities, click 'Save and continue'." + " If you would like to choose more, click 'Save'", "Save ", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);
                    if (response == JOptionPane.YES_OPTION) {
                        UniversityDomain dom = new UniversityDomain(submissionID, id, University, course);

                        domain = dao.save(dom);
                        if (domain.equals(dom)) {
                            JOptionPane.showMessageDialog(null, "Information Saved, please proceed");
                             GuiPOP1 run = new GuiPOP1();
                            run.setTitle("CONSENT TO PROCESS PERSONAL INFORMATION");
                            run.setVisible(true);
                            run.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            run.setGui();
                            run.setSize(890, 700);
                            run.setLocationRelativeTo(null);
                            setVisible(false);
                            //Move to Raeesah's SubSystem
                        }
                    } else {
                        UniversityDomain dom = new UniversityDomain(submissionID, id, University, course);
                        domain = dao.save(dom);
                        if (domain.equals(dom)) {
                            JOptionPane.showMessageDialog(null, "Information Saved");
                           

                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please choose a course of your choice");
                }
            }
        });
//        

        pnlN.setLayout(
                new GridLayout(4, 1));
        pnlC.setLayout(
                new GridLayout(8, 3));
        pnlS.setLayout(
                new GridLayout(1, 3));
        pnlC.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));
        pnlN.setBorder(BorderFactory.createEmptyBorder(40, 20, 0, 20));
        pnlN.add(lblDiploma);
        pnlN.add(btnSpace);
        pnlN.add(lblSelect);

        pnlC.add(cmbUniOne);

        pnlC.add(rbtnCourseOne);

        pnlC.add(rbtnCourseTwo);

        pnlC.add(rbtnCourseThree);

        pnlC.add(txtInfo);

        pnlC.add(lblSpace);

        pnlC.add(btnSave);

        pnlC.add(btnSpace2);

        pnlS.add(btnHome);

        pnlS.add(btnFaq);

        pnlS.add(btnProfile);

        add(pnlN, BorderLayout.NORTH);

        add(pnlS, BorderLayout.SOUTH);

        add(pnlC, BorderLayout.CENTER);
        // add(pnlC, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        studyChoiceGui scg = new studyChoiceGui();
        scg.setGui();
    }
}
