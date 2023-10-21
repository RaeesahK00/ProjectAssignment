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
public class GuiC extends JFrame {

    private JPanel panelN, panelS, panelE, panelC;
    private JLabel heading, picture, applicationHead, text1, text2, text3, text4, space1, space2, space3, space4, space5, space6, space7, space8, space9, space10, space11, space12, space13, space14;
    private JButton home, faq, profile, apply, back;
    private JLabel sectionC, school, year, examinResults, whichresults, subject, percent, submit;
    private JTextField schoolTxt, yearTxt, percent1, percent2, percent3, percent4, percent5, percent6, percent7, sub1, sub2, sub3, sub4, sub5, sub6, sub7;
    private JCheckBox grade11, grade12;
    private Font font1, font2, font3;
    private JScrollPane scrollPane;
    private JTextField attachmentField;
    private JButton browseButton;
    private JTextArea text;
    private DAO dao;

    public GuiC() {
        font1 = new Font("Arial", Font.BOLD, 16);
        font2 = new Font("Arial", Font.BOLD, 14);
        font3 = new Font("Arial", Font.PLAIN, 14);

        panelN = new JPanel(new GridLayout(2, 1));
        panelN.setBackground(Color.LIGHT_GRAY);
        panelS = new JPanel(new GridLayout(1, 3, 5, 5));
        panelC = new JPanel(new GridLayout(20, 2, 5, 5));
        panelE = new JPanel();

        attachmentField = new JTextField();
        attachmentField.setEditable(false);
        browseButton = new JButton("Browse");

        space1 = new JLabel();
        space2 = new JLabel();
        space3 = new JLabel();
        space4 = new JLabel();
        space5 = new JLabel();
        space6 = new JLabel();
        submit = new JLabel("Submit a certified copy of your results below.");
        submit.setFont(font3);

        home = new JButton("Home");
        faq = new JButton("FAQ");
        profile = new JButton("Profile");

        apply = new JButton("Apply");

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

        /*  heading = new JLabel("Online Application");
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setFont(font1);

        picture = new JLabel(new ImageIcon("1.jpg"));
        applicationHead = new JLabel("New Application");
        applicationHead.setFont(font1);

        text1 = new JLabel("1: This Application will consist of 3 Sections , please complete all these sections.");
        text1.setFont(font2);
        //  text1.setPreferredSize(new Dimension(200, 50));
        // text1.setBackground(Color.red);

        text2 = new JLabel("2: Read carefully before completing, submitting the application form.");
        text2.setFont(font2);

        text3 = new JLabel("3: Please complete all information requested on the application form.");
        text3.setFont(font2);

        text4 = new JLabel("4: Please ensure that all documents required are certified copies and are submitted in pdf format.");
        text4.setFont(font2);
         */
        sectionC = new JLabel("Section C: School History and Results");
        // sectionC.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        sectionC.setFont(font2);

        school = new JLabel("High School attended:");
        school.setFont(font3);

        year = new JLabel("Year of completion:");
        year.setFont(font3);

        examinResults = new JLabel("Examination Results");
        examinResults.setFont(font2);

        whichresults = new JLabel("Which results will you be providing:");
        whichresults.setFont(font3);

        subject = new JLabel("Subject");
        subject.setFont(font3);

        percent = new JLabel("Percent %");
        percent.setFont(font3);

        schoolTxt = new JTextField();
        schoolTxt.setPreferredSize(new Dimension(200, 40));
        yearTxt = new JTextField();
        sub1 = new JTextField();
        sub2 = new JTextField();
        sub3 = new JTextField();
        sub4 = new JTextField();
        sub5 = new JTextField();
        sub6 = new JTextField();
        sub7 = new JTextField();
        percent1 = new JTextField();
        percent2 = new JTextField();
        percent3 = new JTextField();
        percent4 = new JTextField();
        percent5 = new JTextField();
        percent6 = new JTextField();
        percent7 = new JTextField();

        grade11 = new JCheckBox("Grade 11 Results");
        grade11.setFont(font3);

        grade12 = new JCheckBox("Grade 12 Results");
        grade12.setFont(font3);

        dao = new DAO();

    }

    public void setGuiC() {
        // panelN.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelN.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelC.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        for (int i = 0; i < 33; i++) {

            panelN.add(picture);
            panelN.add(text);
            /*     panelN.add(applicationHead);
            panelN.add(text1);
            panelN.add(text2);
            panelN.add(text3);
            panelN.add(text4);
             */
            panelC.add(sectionC);
            panelC.add(space1);
            panelC.add(school);
            panelC.add(schoolTxt);
            panelC.add(year);
            panelC.add(yearTxt);
            panelC.add(examinResults);
            panelC.add(space2);
            panelC.add(whichresults);
            panelC.add(space3);
            panelC.add(grade11);
            panelC.add(grade12);
            panelC.add(subject);
            panelC.add(percent);

            panelC.add(sub1);
            panelC.add(percent1);
            panelC.add(sub2);
            panelC.add(percent2);
            panelC.add(sub3);
            panelC.add(percent3);
            panelC.add(sub4);
            panelC.add(percent4);
            panelC.add(sub5);
            panelC.add(percent5);
            panelC.add(sub6);
            panelC.add(percent6);
            panelC.add(sub7);
            panelC.add(percent7);
            panelC.add(submit);
            panelC.add(space6);
            panelC.add(attachmentField);
            panelC.add(browseButton);
        }
        panelC.add(space4);
        panelC.add(space5);

        panelC.add(apply);

        ButtonGroup group = new ButtonGroup();
        group.add(grade11);
        group.add(grade12);

        panelS.add(home);
        panelS.add(faq);
        panelS.add(profile);

        add(panelN, BorderLayout.NORTH);
        add(panelC, BorderLayout.CENTER);
        add(panelS, BorderLayout.SOUTH);

        scrollPane = new JScrollPane(panelC);

        scrollPane.setPreferredSize(new Dimension(700, 600));

        add(getContentPane().add(scrollPane));

        apply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == apply) {
                    int result = JOptionPane.showOptionDialog(null,
                            "Are you sure that everything was filled in correctly", "Confirmation",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                            new String[]{"Yes", "No"}, "Yes");

                    if (result == JOptionPane.YES_OPTION) {

                        //       try {
                        String id = "get id";
                        String school = schoolTxt.getText();
                        String year = yearTxt.getText();
                        String subj1 = sub1.getText();
                        String subj2 = sub2.getText();
                        String subj3 = sub3.getText();
                        String subj4 = sub4.getText();
                        String subj5 = sub5.getText();
                        String subj6 = sub6.getText();
                        String subj7 = sub7.getText();

                        String percents1 = percent1.getText();
                        String percents2 = percent2.getText();
                        String percents3 = percent3.getText();
                        String percents4 = percent4.getText();
                        String percents5 = percent5.getText();
                        String percents6 = percent6.getText();
                        String percents7 = percent7.getText();
                        boolean grade1 = grade11.isSelected();
                        boolean grade2 = grade12.isSelected();
                        String subResults = attachmentField.getText();

                        Student stud = new Student(id, school, year, grade1, grade2, subj1, percents1, subj2, percents2, subj3, percents3, subj4, percents4, subj5, percents5, subj6, percents6, subj7, percents7, subResults);

                        try {
                            stud = dao.addStudSchoolToDB(stud);
                        } catch (IOException ex) {
                            Logger.getLogger(GuiC.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(GuiC.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        /*            if (school.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Please enter your High school name.");
                                schoolTxt.setText("");
                                schoolTxt.requestFocus();
                                return;
                            }

                            if (year.isEmpty() || year.matches("[a-zA-Z]+") || !year.matches("\\d{4}")) {
                                JOptionPane.showMessageDialog(null, "Please enter a year.");
                                yearTxt.setText("");
                                yearTxt.requestFocus();
                                return;
                            }

                            if (subj1.isEmpty() || !subj1.matches("[a-zA-Z]+(\\s[a-zA-Z]+)?")) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid subject.");
                                sub1.setText("");;
                                sub1.requestFocus();
                                return;
                            }

                            if (subj2.isEmpty() || !subj2.matches("[a-zA-Z]+(\\s[a-zA-Z]+)?")) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid subject.");
                                sub2.setText("");;
                                sub2.requestFocus();
                                return;
                            }
                            if (subj3.isEmpty() || !subj3.matches("[a-zA-Z]+(\\s[a-zA-Z]+)?")) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid subject.");
                                sub3.setText("");;
                                sub3.requestFocus();
                                return;
                            }
                            if (subj4.isEmpty() || !subj4.matches("[a-zA-Z]+(\\s[a-zA-Z]+)?")) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid subject.");
                                sub4.setText("");;
                                sub4.requestFocus();
                                return;
                            }
                            if (subj5.isEmpty() || !subj5.matches("[a-zA-Z]+(\\s[a-zA-Z]+)?")) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid subject.");
                                sub5.setText("");;
                                sub5.requestFocus();
                                return;
                            }
                            if (subj6.isEmpty() || !subj6.matches("[a-zA-Z]+(\\s[a-zA-Z]+)?")) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid subject.");
                                sub6.setText("");;
                                sub6.requestFocus();
                                return;
                            }
                            if (subj7.isEmpty() || !subj7.matches("[a-zA-Z]+(\\s[a-zA-Z]+)?")) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid subject.");
                                sub7.setText("");;
                                sub7.requestFocus();
                                return;
                            }

                            if (percents1.isEmpty() || percents1.matches("[a-zA-Z]+")) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid percentage.");
                                percent1.setText("");;
                                percent1.requestFocus();
                                return;
                            }
                            if (percents2.isEmpty() || percents2.matches("[a-zA-Z]+")) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid percentage.");
                                percent2.setText("");;
                                percent2.requestFocus();
                                return;
                            }
                            if (percents3.isEmpty() || percents3.matches("[a-zA-Z]+")) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid percentage.");
                                percent3.setText("");;
                                percent3.requestFocus();
                                return;
                            }
                            if (percents4.isEmpty() || percents4.matches("[a-zA-Z]+")) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid percentage.");
                                percent4.setText("");;
                                percent4.requestFocus();
                                return;
                            }
                            if (percents5.isEmpty() || percents5.matches("[a-zA-Z]+")) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid percentage.");
                                percent5.setText("");;
                                percent5.requestFocus();
                                return;
                            }
                            if (percents6.isEmpty() || percents6.matches("[a-zA-Z]+")) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid percentage.");
                                percent6.setText("");;
                                percent6.requestFocus();
                                return;
                            }
                            if (percents7.isEmpty() || percents7.matches("[a-zA-Z]+")) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid percentage.");
                                percent7.setText("");;
                                percent7.requestFocus();
                                return;
                            }
                         */
//                        if (subResults.isEmpty()) {
//                            JOptionPane.showMessageDialog(null, "Please attatch a certified copy of your results.");
//                            attachmentField.setText("");
//                            attachmentField.requestFocus();
//                            return;
//                        }
//                            
//                        } catch (IOException ex) {
//                            JOptionPane.showMessageDialog(null, "cannot write to file");
//                        }
                        JOptionPane.showMessageDialog(null, "An email confirmation of completion of application has been sent to you.", "Application Completed", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);

                        ProjectHomePage faqs = new ProjectHomePage();
                        faqs.setTitle("Home Page");
                        faqs.setVisible(true);
                        faqs.setLocationRelativeTo(null);
                        setVisible(false);
                    }

                }

            }
        });

        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == home) {

                    int result = JOptionPane.showOptionDialog(null,
                            "Are you sure you want to go to the home page, going there will clear all information entered here.", "Confirmation",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                            new String[]{"Yes", "No"}, "Yes");

                    if (result == JOptionPane.YES_OPTION) {
                        HomePage run = new HomePage();
                        run.setSize(750, 750);
                        run.setTitle("Home Page");
                        run.setVisible(true);
                        run.setGui();
                        run.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        run.setLocationRelativeTo(null);
                    }
                }
            }
        });

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
        });

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
        });

        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    String selectedFile = fileChooser.getSelectedFile().getName();
                    attachmentField.setText(selectedFile);
                }
            }
        });

    }
}
