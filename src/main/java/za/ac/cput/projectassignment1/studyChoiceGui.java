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
import static java.awt.SystemColor.text;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    JLabel lblDiploma1;
    JLabel lblDiploma2;

    // private JTextField choice1, choice2;
    JComboBox cmbUniOne;
    //JButton btnFaq, btnProfile,  btnSave, btnSpace, btnSpace2
    JButton btnSave, btnSpace, btnSpace2, btnHome;
    JRadioButton rbtnCourseOne, rbtnCourseOne1, rbtnCourseTwo, rbtnCourseTwo2, rbtnCourseThree, rbtnCourseThree3, rbtnCourseThree4, rbtnCourseThree5, rbtnCourseThree6;
    FileWriter fw;
    BufferedWriter bw;
    String txtFileHeadingOne, txtFileHeadingTwo, faculty;
    int id;
    UniversityGui uG;
    UniversityDomain domain;
    DAO dao;
    LoginFormGUI lfg;
    WorkerLogin wl;

    public studyChoiceGui() {
        pnlN = new JPanel();
        pnlN.setBackground(Color.LIGHT_GRAY);
        pnlC = new JPanel();
        pnlS = new JPanel();

        uG = new UniversityGui();

////        choice1 = new JTextField(50);
////        
////        choice2 = new JTextField();
        cmbUniOne = new JComboBox();
        cmbUniOne.setFont(font2);
        cmbUniOne.setPreferredSize(new Dimension(60, 60));

//        btnFaq = new JButton("FAQ");
//        btnFaq.setFont(font2);
//        btnProfile = new JButton("Profile");
//        btnProfile.setFont(font2);
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
        lblDiploma1 = new JLabel();
        lblDiploma1.setFont(font1);
        lblDiploma1.setHorizontalAlignment(JLabel.CENTER);
        lblDiploma1.setForeground(Color.blue);

        lblDiploma2 = new JLabel();
        lblDiploma2.setFont(font1);
        lblDiploma2.setHorizontalAlignment(JLabel.CENTER);
        lblDiploma2.setForeground(Color.blue);
        lblDiploma2.setVisible(false);

        lblSpace = new JLabel();
        txtInfo = new JTextArea(100, 50);
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
        wl = new WorkerLogin();
        dao = new DAO();
        lfg = new LoginFormGUI();

    }

    int submissionID;

    public void setGui() {
//        id = JOptionPane.showInputDialog("Please enter your ID to continue");
//
//        if (id.equals(JOptionPane.CANCEL_OPTION)) {
//            System.exit(0);
//        }
//        while (id.length() != 13 || !(id.matches("[0-9]+"))) {
//
//            JOptionPane.showMessageDialog(null, "Please enter a valid ID");
//            id = JOptionPane.showInputDialog("Please enter your ID to continue");
//
//        }
//       submissionID = dao.submission();

        String[] universities = {"University of Cape Town", "Cape Peninsula University of Technology", "University of Western Cape"};
        for (int i = 0; i < 3; i++) {
            cmbUniOne.addItem(universities[i]);
        }

        txtInfo.setBackground(Color.WHITE);

//        btnProfile.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (e.getSource() == btnProfile) {
//                    int result = JOptionPane.showOptionDialog(null,
//                            "Are you sure you want to go to Profile Page? "
//                            + "Going there will clear all information entered here.", "Confirmation",
//                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
//                            new String[]{"Yes", "No"}, "Yes");
//
//                    if (result == JOptionPane.YES_OPTION) {
//
//                        UserGui gui2 = new UserGui();
//                        gui2.setVisible(true);
//                        gui2.setTitle("User Information");
//                        gui2.setGui2();
//                        gui2.setSize(800, 800);
//                        gui2.setDefaultCloseOperation(gui2.EXIT_ON_CLOSE);
//                        gui2.setLocationRelativeTo(null);
//                        setVisible(false);
//                    }
//                }
//
//            }
//
//        });
        //Add array elements to combobox
        //combobox one action listener
        cmbUniOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                rbtnCourseOne.setSelected(false);
                rbtnCourseTwo.setSelected(false);
                rbtnCourseThree.setSelected(false);
                String selected = (String) cmbUniOne.getSelectedItem();
                txtInfo.setText("");

                if (lblDiploma1.getText().equals("Faculty of Informatics and Design")) {

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
                    }

                } else if (lblDiploma1.getText().equals("Faculty of Applied Sciences")) {

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

                } else if (lblDiploma1.getText().equals("Faculty of Business and Management Sciences")) {
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
                    }
                } else if (lblDiploma1.getText().equals("Faculty of Engineering & the Built Environment")) {
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
                    }
                } else if (lblDiploma1.getText().equals("Faculty of Education")) {
                    if (selected.equals("University of Cape Town")) {
                        rbtnCourseOne.setVisible(true);
                        rbtnCourseOne.setText("Education Development Unit");
                        rbtnCourseTwo.setVisible(true);
                        rbtnCourseTwo.setText("Eng Language Education");
                        rbtnCourseThree.setVisible(true);
                        rbtnCourseThree.setText("Center faculty of Education");

                    } else if (selected.equals("Cape Peninsula University of Technology")) {

                        rbtnCourseOne.setVisible(true);
                        rbtnCourseOne.setText("Foundation Phase");
                        rbtnCourseTwo.setVisible(true);
                        rbtnCourseTwo.setText("Intermediate Phase");
                        rbtnCourseThree.setVisible(true);
                        rbtnCourseThree.setText("Senior and further Education");

                    } else if (selected.equals("University of Western Cape")) {
                        rbtnCourseOne.setVisible(true);
                        rbtnCourseOne.setText("BED Foundation studies");
                        rbtnCourseTwo.setVisible(true);
                        rbtnCourseTwo.setText("BEd FET");
                        rbtnCourseThree.setVisible(true);
                        rbtnCourseThree.setText("Language Education");
                    }
                }

                /*-----------------------------------------------------------------------------------------------------------------------------------*/
            }
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
                } else if (rbtnCourseOne.isSelected() && rbtnCourseOne.getText().equals("Archaeology")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Discover the mysteries of the past through the captivating field of archaeology. This introductory course offers a fascinating journey into the study of human history by exploring"
                            + " the artifacts, structures, and cultural remnants left behind by ancient civilizations. Learn the essential methods, techniques, and principles of archaeological investigation, and gain"
                            + " insights into how archaeologists unlock the secrets of our ancestors. From unearthing ancient cities to deciphering enigmatic inscriptions, this course provides a window into the past "
                            + "and a deeper understanding of the human story. Join us on an expedition through time as we unearth the wonders of our shared heritage.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseOne.isSelected() && rbtnCourseOne.getText().equals("Biotechnology")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Delve into the world of biotechnology with this foundational course. Explore the cutting-edge science and applications of biotechnology, "
                            + "from genetic engineering to pharmaceutical advancements. Gain a fundamental understanding of the principles driving breakthroughs in healthcare, "
                            + "agriculture, and more. Discover how biotechnology is shaping the future.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseOne.isSelected() && rbtnCourseOne.getText().equals("Bachelor of Pharmacy")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Pursue a Bachelor of Pharmacy to embark on a journey into the world of pharmaceutical science. This program equips you with the knowledge and skills to excel in the dynamic "
                            + "field of medication, health, and patient care. Explore drug development, pharmacology, and pharmacy practice, and prepare for a rewarding career improving healthcare and enhancing well-being.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseOne.isSelected() && rbtnCourseOne.getText().equals("Commerce IT Support")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Learn how to provide essential IT support for businesses in the world of commerce, assisting in maintaining technology systems critical for modern operations.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseOne.isSelected() && rbtnCourseOne.getText().equals("Paralegal")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Gain the skills and knowledge to assist legal professionals in research, document preparation, and case management as a valuable member of the legal team.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseOne.isSelected() && rbtnCourseOne.getText().equals("Bachelor of Administration")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Develop a strong foundation in business administration, preparing for leadership roles in various industries through strategic management and organizational skills.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseOne.isSelected() && rbtnCourseOne.getText().equals("Architecture and Planning")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Dive into the world of design and urban development, studying the art and science of creating functional and aesthetically pleasing spaces.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseOne.isSelected() && rbtnCourseOne.getText().equals("Chemical Engineering")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Explore the principles of chemistry and engineering to design and optimize chemical processes, from pharmaceuticals to energy production.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseOne.isSelected() && rbtnCourseOne.getText().equals("Electrical Engineering")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Master the art of designing and managing electrical systems and devices, from power distribution to electronic circuits.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseOne.isSelected() && rbtnCourseOne.getText().equals("Education Development Unit")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("This unit provides valuable resources and support to enhance educational programs, ensuring a nurturing environment for students' growth and development.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseOne.isSelected() && rbtnCourseOne.getText().equals("Foundation Phase")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Focus on the early years of education, equipping students with the skills and knowledge to teach young learners in their formative years.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseOne.isSelected() && rbtnCourseOne.getText().equals("Artificial Intelligence")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("This unit provides valuable resources and support to enhance educational programs, ensuring a nurturing environment for students' growth and development.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseOne.isSelected() && rbtnCourseOne.getText().equals("BED Foundation studies")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Develop a strong educational foundation, preparing for a career in teaching while gaining a broad understanding of educational principles.");
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
                } else if (rbtnCourseTwo.isSelected() && rbtnCourseTwo.getText().equals("Chemistry")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Dive into the fascinating world of matter and its transformations, exploring the properties, composition, and reactions of substances.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseTwo.isSelected() && rbtnCourseTwo.getText().equals("Marine Science")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Study the mysteries of the world's oceans, delving into marine ecosystems, conservation, and the scientific exploration of aquatic environments.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseTwo.isSelected() && rbtnCourseTwo.getText().equals("BSc Biotechnology")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Learn the principles and applications of biotechnology, harnessing biology and technology to revolutionize fields like healthcare and agriculture.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseTwo.isSelected() && rbtnCourseTwo.getText().equals("Management Studies")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Gain comprehensive knowledge in the principles of management, leadership, and organizational operations, preparing for leadership roles in various industries.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseTwo.isSelected() && rbtnCourseTwo.getText().equals("Hospitality")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Explore the dynamic and customer-centric world of the hospitality industry, including hotel management, tourism, and event planning.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseTwo.isSelected() && rbtnCourseTwo.getText().equals("Financial Accounting")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Master the art of financial reporting and analysis, essential for understanding and managing a company's financial health.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseTwo.isSelected() && rbtnCourseTwo.getText().equals("Construction Economics and Management")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Learn the economics, project management, and cost estimation of construction projects, contributing to the development of infrastructure and buildings.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseTwo.isSelected() && rbtnCourseTwo.getText().equals("Civil Engineering")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Study the design and construction of infrastructure, from bridges to buildings, and gain the skills to shape our modern world.\n"
                            + "");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseTwo.isSelected() && rbtnCourseTwo.getText().equals("Environmental Health")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Focus on public health and environmental protection, understanding the impact of the environment on human well-being and exploring solutions to promote a healthier world.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseTwo.isSelected() && rbtnCourseTwo.getText().equals("Eng Language Education")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Specialize in teaching the English language, helping students master language skills, literature, and communication.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseTwo.isSelected() && rbtnCourseTwo.getText().equals("Intermediate Phase")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Concentrate on the middle years of education, preparing to teach students in their transition from primary to secondary education.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseTwo.isSelected() && rbtnCourseTwo.getText().equals("BEd FET")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Prepare to teach in the further education and training phase, working with older students as they prepare for their future careers or higher education.");
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
                } else if (rbtnCourseThree.isSelected() && rbtnCourseThree.getText().equals("Environmental And Geographical Science")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Explore the intricacies of our planet's environment and geography, studying ecosystems, climate, and the relationship between humans and the Earth.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseThree.isSelected() && rbtnCourseThree.getText().equals("Environmental Health")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Focus on public health and environmental protection, understanding the impact of the environment on human well-being and exploring solutions to promote a healthier world.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseThree.isSelected() && rbtnCourseThree.getText().equals("BCom in Information Systems")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Gain expertise in the fusion of business and technology, studying how information systems drive modern organizations and decision-making.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseThree.isSelected() && rbtnCourseThree.getText().equals("College of Accounting")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Develop a strong foundation in accounting principles, preparing for careers in financial management and auditing.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseThree.isSelected() && rbtnCourseThree.getText().equals("Tourism and Sports")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Explore the dynamic industries of tourism and sports management, learning about travel, recreation, and the business of athletics.");
                    txtInfo.setEditable(false);
                } //                else if (rbtnCourseThree.isSelected() && rbtnCourseThree.getText().equals("BCom in Information Systems")) {
                //                    txtInfo.setVisible(true);
                //                    txtInfo.setText("");
                //                    txtInfo.setEditable(false);
                //                }
                else if (rbtnCourseThree.isSelected() && rbtnCourseThree.getText().equals("Electronic Engineering")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Master the design and application of electronic systems and devices, from circuits to telecommunications technology.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseThree.isSelected() && rbtnCourseThree.getText().equals("Mechanical and Mechatronic Engineering")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Learn the principles of mechanical engineering and mechatronics, which combines mechanical and electronic systems to create innovative products and machines.\n"
                            + "");
                    txtInfo.setEditable(false);
                } //                else if (rbtnCourseThree.isSelected() && rbtnCourseThree.getText().equals("Environmental Science")) {
                //                    txtInfo.setVisible(true);
                //                    txtInfo.setText("");
                //                    txtInfo.setEditable(false);
                //                }
                else if (rbtnCourseThree.isSelected() && rbtnCourseThree.getText().equals("Center faculty of Education")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Prepare for a career in education, focusing on teaching and shaping the minds of future generations.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseThree.isSelected() && rbtnCourseThree.getText().equals("Senior and further Education")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Specialize in the education of senior and adult learners, enhancing their knowledge and skills for personal and professional development.");
                    txtInfo.setEditable(false);
                } else if (rbtnCourseThree.isSelected() && rbtnCourseThree.getText().equals("Language Education")) {
                    txtInfo.setVisible(true);
                    txtInfo.setText("Explore the art and science of teaching languages, helping students master new languages and fostering cultural understanding.");
                    txtInfo.setEditable(false);
                }
            }

        }
        );
//        btnFaq.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (e.getSource() == btnFaq) {
//
//                    int result = JOptionPane.showOptionDialog(null,
//                            "Are you sure you want to go to the FAQ page, going there will clear all information entered here and there is no backtracking.", "Confirmation",
//                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
//                            new String[]{"Yes", "No"}, "Yes");
//
//                    if (result == JOptionPane.YES_OPTION) {
//                        FAQ faqs = new FAQ();
//                        faqs.setTitle("FAQ Page");
//                        faqs.setVisible(true);
//                        faqs.setLocationRelativeTo(null);
//                        setVisible(false);
//                    }
//                }
//            }
//
//        });
        btnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Goes to Home page");

                HomePage home = new HomePage();
                home.setSize(800, 800);
                home.setGui();
                home.setVisible(true);
                home.setTitle("Home Page");
                home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                home.setLocationRelativeTo(null);
                setVisible(false);
//                ProjectHomePage faqs = new ProjectHomePage();
//                faqs.setTitle("Home Page");
//                faqs.setVisible(true);
//                faqs.setLocationRelativeTo(null);
//                setVisible(false);
            }

        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //  id = Integer.parseInt(wl.getId());
                String val = wl.getId();
                if (val != null) {
                    System.out.println(val + " moo say");
                } else {
                    System.out.println("wl.getId() returned null");
                }

                domain.setId(id);

                String facultyOne = uG.txt1.getText();
                DAO facDao = new DAO();
                faculty = facDao.getfacId(facultyOne);
                System.out.println(facultyOne + "  sdc");
                submissionID++;
                System.out.println(
                        "Submission ID: " + submissionID);
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
                if (rbtnCourseOne.isSelected()
                        || rbtnCourseTwo.isSelected() || rbtnCourseThree.isSelected()) {
                    // int response = JOptionPane.showConfirmDialog(null, "If you are satisfied with the chosen universities, click 'Save'." + " If you would like to choose more, click 'Save and Continue'");
                    int response = JOptionPane.showOptionDialog(null, "If you are satisfied with the chosen universities, click 'Save and continue'." + " If you would like to choose more, click 'Save'", "Save ", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);
                    if (response == JOptionPane.YES_OPTION) {

                        UniversityDomain dom = new UniversityDomain(submissionID, id, University, course, faculty);

                        domain = dao.save(dom);
                        if (domain.equals(dom)) {
                            JOptionPane.showMessageDialog(null, "Information Saved, please proceed");
                            GuiPOP1 run = new GuiPOP1();
                            setVisible(false);
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
                        UniversityDomain dom = new UniversityDomain(submissionID, id, University, course, faculty);
                        domain = dao.save(dom);
                        if (domain.equals(dom)) {
                            JOptionPane.showMessageDialog(null, "Information Saved");

                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please choose a course of your choice");
                }
            }

        }
        );

        pnlN.setLayout(
                new GridLayout(4, 1));
        pnlC.setLayout(
                new GridLayout(8, 3));
        pnlS.setLayout(
                new GridLayout(1, 3));
        pnlC.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));
        pnlN.setBorder(BorderFactory.createEmptyBorder(40, 20, 0, 20));
        pnlN.add(lblDiploma1);

        pnlN.add(btnSpace);
//        pnlN.add(choice1);
//        pnlN.add(choice2);
        pnlN.add(lblSelect);

        pnlC.add(cmbUniOne);

        pnlC.add(rbtnCourseOne);

        pnlC.add(rbtnCourseTwo);

        pnlC.add(rbtnCourseThree);

        pnlC.add(txtInfo);

        pnlC.add(lblSpace);

        pnlC.add(btnSave);

        pnlC.add(btnSpace2);
//
        pnlS.add(btnHome);
//
//        pnlS.add(btnFaq);
//
//        pnlS.add(btnProfile);

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
