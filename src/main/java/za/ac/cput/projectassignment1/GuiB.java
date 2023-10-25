package za.ac.cput.projectassignment1;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Desktop
 */
public class GuiB extends JFrame {

    private JPanel panelN, panelS, panelE, panelC;
    private JLabel heading, picture, applicationHead, text1, text2, text3, text4, space1, space2, space3, space4, space5;
    private JLabel sectionB, surname, name, email, id, fPassport, nationality, address, code, province, number, who;
    private JButton home, faq, profile, next, back;
    private JTextField surnameTxt, nameTxt, emailTxt, idTxt, nationalityTxt, addressTxt1, addressTxt2, codeTxt, provinceTxt, numberTxt;
    private JComboBox parent;
    private Font font1, font2, font3;
    private JTextArea text;
    private JScrollPane scrollPane;
    private DAO dao;

    public GuiB() {

        font1 = new Font("Arial", Font.BOLD, 16);
        font2 = new Font("Arial", Font.BOLD, 14);
        font3 = new Font("Arial", Font.PLAIN, 14);

        panelN = new JPanel(new GridLayout(2, 1));
        panelN.setBackground(Color.LIGHT_GRAY);
        panelS = new JPanel(new GridLayout(1, 3, 5, 5));
        panelC = new JPanel(new GridLayout(13, 2, 5, 5));
        panelE = new JPanel();

        parent = new JComboBox(new String[]{"Mother", "Father", "Grandparents", "Social worker", "School"});

        home = new JButton("HomeButton");
        faq = new JButton("FAQ");
        profile = new JButton("Profile");

        picture = new JLabel(new ImageIcon("1.jpg"));
        applicationHead = new JLabel("New Application");
        applicationHead.setFont(font1);

        text = new JTextArea(""" 
                            Online Application 
                            New Application
                             
                            1) This Application will consist of 3 Sections, please complete all these sections.
                             
                            2)  Read carefully before completing, submitting the application form.
                             
                            3)  Please complete and fill in all information requested on the application form.
                             
                            4)  Please ensure that all documents required are certified copies and are submitted in pdf format. 
                             """);
        text.setFont(font2);
        text.setEditable(false);
        text.setBackground(Color.LIGHT_GRAY);
        text.setPreferredSize(new Dimension(190, 190));

        /*
        picture = new JLabel(new ImageIcon("1.jpg"));
        applicationHead = new JLabel("New Application");
        applicationHead.setFont(font1);

        heading = new JLabel("Online Application");
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setFont(font1);

        text1 = new JLabel("1:This Application will consist of 3 Sections , please complete all these sections.");
        text1.setFont(font2);
        //  text1.setPreferredSize(new Dimension(200, 50));
        // text1.setBackground(Color.red);

        text2 = new JLabel("2:Read carefully before completing, submitting the application form.");
        text2.setFont(font2);

        text3 = new JLabel("3:Please complete all information requested on the application form.");
        text3.setFont(font2);

        text4 = new JLabel("4:Please ensure that all documents required are certified copies and are submitted in pdf format. ");
        text4.setFont(font2);
         */
        sectionB = new JLabel("Section B: Guardian Details");
        sectionB.setFont(font2);
        surname = new JLabel("Surname:");
        surname.setFont(font3);
        name = new JLabel("Name:");
        name.setFont(font3);
        email = new JLabel("Email:");
        email.setFont(font3);
        id = new JLabel("ID:");
        id.setFont(font3);
        nationality = new JLabel("Nationality:");
        nationality.setFont(font3);
        who = new JLabel("Your Gardian:");
        who.setFont(font3);

        address = new JLabel("Home Address:");
        address.setFont(font3);
        code = new JLabel("Postal Code:");
        code.setFont(font3);
        province = new JLabel("Province:");
        province.setFont(font3);
        number = new JLabel("Phone Number:");
        number.setFont(font3);

        home = new JButton("Home");
        faq = new JButton("FAQ Page");
        profile = new JButton("Profile");
        next = new JButton("Next Section");

        surnameTxt = new JTextField();
        surnameTxt.setPreferredSize(new Dimension(200, 40));
        nameTxt = new JTextField();
        emailTxt = new JTextField();
        idTxt = new JTextField();

        nationalityTxt = new JTextField();

        addressTxt1 = new JTextField();
        addressTxt2 = new JTextField();
        codeTxt = new JTextField();
        provinceTxt = new JTextField();
        numberTxt = new JTextField();

        space1 = new JLabel();
        space2 = new JLabel();
        space3 = new JLabel();
        
        dao = new DAO();

    }

    public void setGuiB() {

        panelN.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelC.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panelN.add(picture);
        panelN.add(text);
        /*  panelN.add(heading);
        panelN.add(applicationHead);
        panelN.add(text1);
        panelN.add(text2);
        panelN.add(text3);
        panelN.add(text4);
         */
        for (int i = 0; i < 33; i++) {
            panelC.add(sectionB);
            panelC.add(space1);
            panelC.add(space2);
            panelC.add(who);
            panelC.add(parent);
            panelC.add(surname);
            panelC.add(surnameTxt);
            panelC.add(name);
            panelC.add(nameTxt);
            panelC.add(email);
            panelC.add(emailTxt);

            panelC.add(id);
            panelC.add(idTxt);
            panelC.add(nationality);
            panelC.add(nationalityTxt);

            panelC.add(address);
            panelC.add(addressTxt1);
            panelC.add(code);
            panelC.add(codeTxt);
            panelC.add(province);
            panelC.add(provinceTxt);
            panelC.add(number);
            panelC.add(numberTxt);
            panelC.add(space2);
            panelC.add(space3);

            panelC.add(next);
        }

        panelS.add(home);
        panelS.add(faq);
        panelS.add(profile);

        add(panelN, BorderLayout.NORTH);
        add(panelC, BorderLayout.CENTER);
        add(panelS, BorderLayout.SOUTH);

        scrollPane = new JScrollPane(panelC);
        scrollPane.setPreferredSize(new Dimension(700, 600));
        add(getContentPane().add(scrollPane));

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == next) {

                    int result = JOptionPane.showOptionDialog(null,
                            "Are you sure you everything in this section is correct, going to the next section will save all this information and there is no backtracking.", "No Backtracking",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                            new String[]{"Yes", "No"}, "Yes");

                    if (result == JOptionPane.YES_OPTION) {

                     
                        try {
                            
                            String parent1 = parent.getSelectedItem().toString();
                            String surname = surnameTxt.getText();
                            String firstName = nameTxt.getText();
                            String email = emailTxt.getText();
                            String id = idTxt.getText();

                            String nationality = nationalityTxt.getText();
                            String province = provinceTxt.getText();
                            String address = addressTxt1.getText();
                            String code = codeTxt.getText();
                            String number = numberTxt.getText();
                            
                            
                            Student stud = new Student(id,parent1,firstName,surname,email,nationality,address,province,code,number);
                            stud = dao.addGaurdianToDB(stud);
                            
                            if (surname.isEmpty() || !surname.matches("[a-zA-Z]+")) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid last name.");
                                surnameTxt.setText("");
                                surnameTxt.requestFocus();
                                return;
                            }

                            if (firstName.isEmpty() || !firstName.matches("[a-zA-Z]+")) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid first name.");
                                nameTxt.setText("");;
                                nameTxt.requestFocus();
                                return;
                            }

                            if (email.isEmpty() || !email.endsWith("@gmail.com")) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid email address.");
                                emailTxt.setText("");;
                                emailTxt.requestFocus();
                                return;
                            }
                            if (id.isEmpty() || id.matches("[a-zA-Z]+") || !id.matches("\\d{13}")) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid ID/Passport number.");
                                idTxt.setText("");
                                idTxt.requestFocus();
                                return;
                            }

                            if (nationality.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid nationality.");
                                nationalityTxt.setText("");
                                nationalityTxt.requestFocus();
                                return;
                            }

                            if (address.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid address.");
                                addressTxt1.setText("");;
                                addressTxt1.requestFocus();
                                return;
                            }

                            if (code.isEmpty() || code.matches("[a-zA-Z]+") || !code.matches("\\d{4}")) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid postal code.");
                                codeTxt.setText("");
                                codeTxt.requestFocus();
                                return;
                            }

                            if (number.isEmpty() || number.matches("[a-zA-Z]+") || !number.matches("\\d{10}")) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid phone number.");
                                numberTxt.setText("");
                                numberTxt.requestFocus();
                                return;
                            }
                            
                        } catch (IOException ex) {
                            Logger.getLogger(GuiB.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(GuiB.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        } 
                    

                    
                    GuiC run = new GuiC();
                    run.setTitle("Online Application Section C");
                    run.setVisible(true);
                    run.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    run.setGuiC();
                    run.setSize(850, 800);
                    run.setLocationRelativeTo(null);
                }
                setVisible(false);
            }
        });

        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == home) {

                    int result = JOptionPane.showOptionDialog(null,
                            "Are you sure you want to go to the home page, going there will clear all information entered here and there is no backtracking.", "Confirmation",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                            new String[]{"Yes", "No"}, "Yes");

                    if (result == JOptionPane.YES_OPTION) {
                        /* GuiB run = new GuiB();
                        run.setTitle("Online Application Section A");
                        run.setVisible(true);
                        run.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        run.setGuiB();
                        run.setSize(800, 800);
                        setVisible(false);
                        run.setLocationRelativeTo(null);
                         */
                    }
                }
            }
        });

        faq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == faq) {

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

        profile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == profile) {
                    int result = JOptionPane.showOptionDialog(null,
                            "Are you sure you want to go to the profile page, going there will clear all information entered hereand there is no backtracking.", "Confirmation",
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
        });

    }

}
