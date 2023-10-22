package za.ac.cput.projectassignment1;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Desktop
 */
public class GuiA extends JFrame implements ActionListener {

    private JPanel panelN, panelS, panelE, panelC;
    private JLabel heading, picture, applicationHead, text1, text2, text3, text4, space1, space2, space3, space4, space5, space6, space7, space8, space9, space10, space11, space12, space13, space14;
    private JLabel sectionA, surname, name, email, identity, id, fPassport, nationality, date, address, code, province, number, homeLan, submit;
    private JRadioButton saId, passport;
    private JCheckBox male, female;
    private JComboBox status;
    private JTextArea text;
    private JButton home, faq, profile, next, back;
    private JTextField surnameTxt, nameTxt, emailTxt,  fPassportTxt, nationalityTxt, dateTxt, addressTxt1, addressTxt2, codeTxt, provinceTxt, numberTxt, homeLanTxt;
    JTextField idTxt;
    private JScrollPane scrollPane;
    private Font font1, font2, font3;
    private JTextField attachmentField;
    private JButton browseButton;

    private DAO dao;
    private Student stud;

    public GuiA() {
//        try {
//            connection = DBConnection.getConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        font1 = new Font("Arial", Font.BOLD, 18);
        font2 = new Font("Arial", Font.BOLD, 16);
        font3 = new Font("Arial", Font.PLAIN, 16);

        panelN = new JPanel(new GridLayout(2, 1));
        panelN.setBackground(Color.LIGHT_GRAY);
        panelS = new JPanel(new GridLayout(1, 3, 5, 5));
        panelC = new JPanel(new GridLayout(20, 2, 5, 5));
        panelE = new JPanel();

        submit = new JLabel("Submit a certified copy of your identity document below.");
        submit.setFont(font3);
        space1 = new JLabel();
        space2 = new JLabel();
        space3 = new JLabel();
        space4 = new JLabel();
        space5 = new JLabel();
        space6 = new JLabel();

        home = new JButton("HomeButton");
        home.setFont(font2);
        faq = new JButton("FAQ");
        faq.setFont(font2);
        profile = new JButton("Profile");
        profile.setFont(font2);

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

        sectionA = new JLabel("Section A: User Details");
        sectionA.setFont(font2);
        sectionA.setBackground(Color.lightGray);

        surname = new JLabel("Surname:");
        surname.setFont(font3);

        name = new JLabel("Name:");
        name.setFont(font3);

        email = new JLabel("Email:");
        email.setFont(font3);

        identity = new JLabel("Identification Type:");
        identity.setFont(font3);

        id = new JLabel("ID:");
        id.setFont(font3);

        fPassport = new JLabel("Passport:");
        fPassport.setFont(font3);

        nationality = new JLabel("Nationality:");
        nationality.setFont(font3);

        date = new JLabel("Date of Birth: dd/mm/yyy");
        date.setFont(font3);

        address = new JLabel("Home Address:");
        address.setFont(font3);

        code = new JLabel("Postal Code:");
        code.setFont(font3);

        homeLan = new JLabel("Home Language:");
        homeLan.setFont(font3);

        province = new JLabel("Province:");
        province.setFont(font3);

        number = new JLabel("Phone Number:");
        number.setFont(font3);

        saId = new JRadioButton("SA Id Number");
        saId.setFont(font3);
        passport = new JRadioButton("Foreign Passport");
        passport.setFont(font3);

        ButtonGroup group = new ButtonGroup();
        group.add(saId);
        group.add(passport);

        male = new JCheckBox("Male");
        male.setFont(font3);
        female = new JCheckBox("Female");
        female.setFont(font3);

        home = new JButton("Home");
        faq = new JButton("FAQ Page");
        profile = new JButton("Profile");
        next = new JButton("Next Section");
        back = new JButton("Go Back");

        surnameTxt = new JTextField();
        surnameTxt.setPreferredSize(new Dimension(200, 40));
        nameTxt = new JTextField();
        emailTxt = new JTextField();
        idTxt = new JTextField(13);
        fPassportTxt = new JTextField();
        nationalityTxt = new JTextField();
        dateTxt = new JTextField();
        addressTxt1 = new JTextField();
        addressTxt2 = new JTextField();
        codeTxt = new JTextField(4);
        provinceTxt = new JTextField();
        numberTxt = new JTextField(10);
        homeLanTxt = new JTextField();

        attachmentField = new JTextField();
        attachmentField.setEditable(false);
        browseButton = new JButton("Browse");

        dao = new DAO();
        stud = new Student();

    }

    public void setGuiA() {

        panelN.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelC.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panelN.add(picture);
        panelN.add(text);

        for (int i = 0; i < 33; i++) {
            panelC.add(sectionA);
            panelC.add(space1);
            panelC.add(surname);
            panelC.add(surnameTxt);
            panelC.add(name);
            panelC.add(nameTxt);
            panelC.add(email);
            panelC.add(emailTxt);
            panelC.add(identity);
            panelC.add(space2);
            panelC.add(saId);
            panelC.add(passport);
            panelC.add(id);
            panelC.add(idTxt);
            panelC.add(nationality);
            panelC.add(nationalityTxt);
            panelC.add(date);
            panelC.add(dateTxt);
            panelC.add(address);
            panelC.add(addressTxt1);
            panelC.add(code);
            panelC.add(codeTxt);
            panelC.add(homeLan);
            panelC.add(homeLanTxt);
            panelC.add(province);
            panelC.add(provinceTxt);
            panelC.add(number);
            panelC.add(numberTxt);
            panelC.add(male);
            panelC.add(female);
            panelC.add(submit);
            panelC.add(space5);
            panelC.add(attachmentField);
            panelC.add(browseButton);
            panelC.add(space3);
            panelC.add(space4);
            panelC.add(next);

        }

        panelS.add(home);
        panelS.add(faq);
        panelS.add(profile);

        add(panelN, BorderLayout.NORTH);
        add(panelC, BorderLayout.CENTER);
        add(panelS, BorderLayout.SOUTH);

        ButtonGroup group2 = new ButtonGroup();
        group2.add(male);
        group2.add(female);

        saId.addActionListener(this);
        passport.addActionListener(this);

        scrollPane = new JScrollPane(panelC);

        scrollPane.setPreferredSize(new Dimension(700, 600));

        add(getContentPane().add(scrollPane));

        UUID uniqueID = UUID.randomUUID();
        String randomID = uniqueID.toString();

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == next) {

                    int result = JOptionPane.showOptionDialog(null,
                            "Are you sure everything in this section is correct, going to the next section will save all this information and there is no backtracking.", "Confirmation",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                            new String[]{"Yes", "No"}, "Yes");
                    if (result == JOptionPane.YES_OPTION) {

                   //     try {
                            //                        UUID uniqueID = UUID.randomUUID();
//                        String randomID = uniqueID.toString();
                            String identity = idTxt.getText();
                            String firstName = nameTxt.getText();
                            String surname = surnameTxt.getText();
                            boolean id = saId.isSelected();
                            boolean passport1 = passport.isSelected();
                            String email = emailTxt.getText();
                            String nationality = nationalityTxt.getText();
                            String date = dateTxt.getText();
                            String address = addressTxt1.getText();
                            String code = codeTxt.getText();
                            String number = numberTxt.getText();
                            String province1 = provinceTxt.getText();
                            boolean male1 = male.isSelected();
                            boolean female1 = female.isSelected();
                            String language = homeLanTxt.getText();
                            String subId = attachmentField.getText();

                            /*                         if (surname.isEmpty() || !surname.matches("[a-zA-Z]+(\\s[a-zA-Z]+)?")) {
                            JOptionPane.showMessageDialog(null, "Please enter a valid last name.");
                            surnameTxt.setText("");
                            surnameTxt.requestFocus();
                            return;
                            }

                            if (firstName.isEmpty() || !firstName.matches("[a-zA-Z]+(\\s[a-zA-Z]+)?")) {
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
                            if (saId.isSelected()) {
                            if (identity.isEmpty() || identity.matches("[a-zA-Z]+") || !identity.matches("\\d{13}")) {
                            JOptionPane.showMessageDialog(null, "Please enter a valid ID number.(13 numbers)");
                            idTxt.setText("");
                            idTxt.requestFocus();
                            return;
                            }

                            }
                            if (passport.isSelected()) {
                            if (identity.isEmpty() || identity.matches("[a-zA-Z]\\d{9}")) {
                            JOptionPane.showMessageDialog(null, "Please enter a valid Passport number.\n(1 letter followed by 8 numbers with no spaces)");
                            idTxt.setText("");
                            idTxt.requestFocus();
                            return;
                            }

                            }

                            if (nationality.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please enter a valid nationality.");
                            nationalityTxt.setText("");
                            nationalityTxt.requestFocus();
                            return;
                            }

                            if (date.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please enter your date of birth.");
                            dateTxt.setText("");;
                            dateTxt.requestFocus();
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

                            if (province1.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please enter a valid province.");
                            provinceTxt.setText("");
                            provinceTxt.requestFocus();
                            return;
                            }

                            if (number.isEmpty() || number.matches("[a-zA-Z]+") || !number.matches("\\d{10}")) {
                            JOptionPane.showMessageDialog(null, "Please enter a valid phone number.");
                            numberTxt.setText("");
                            numberTxt.requestFocus();
                            return;
                            }

                            if (subId.isBlank()) {
                            JOptionPane.showMessageDialog(null, "Please attatch a certified copy of your identification document.");
                            return;
                            }
//                             */
                            
//                            Student stud = new Student(identity, firstName, surname, id, passport1, email, nationality, date, language, address, code, province1, number, male1, female1, subId);
//
//                            stud = dao.addStudentToDB(stud);

                            GuiB run = new GuiB();
                            run.setTitle("Online Application Section B");
                            run.setVisible(true);
                            run.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            run.setGuiB();
                            run.setSize(800, 800);
                            run.setLocationRelativeTo(null);

                            setVisible(false);
                        }
//                        catch (IOException ex) {
//                            Logger.getLogger(GuiA.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (SQLException ex) {
//                            Logger.getLogger(GuiA.class.getName()).log(Level.SEVERE, null, ex);
//                        }
                    }

                }
          //  }
        }
        );

        home.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (e.getSource() == home) {

                    int result = JOptionPane.showOptionDialog(null,
                            "Are you sure you want to go to the home page, going there will clear all information entered here.", "Confirmation",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                            new String[]{"Yes", "No"}, "Yes");

                    if (result == JOptionPane.YES_OPTION) {

                       ProjectHomePage faqs = new ProjectHomePage();
                        faqs.setTitle("Home Page");
                        faqs.setVisible(true);
                        faqs.setLocationRelativeTo(null);
                        setVisible(false);
                    }
                }
            }
        }
        );

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

        browseButton.addActionListener(new ActionListener() {
            @Override
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

//    public void insertUserData(String surname, String firstName, String email, boolean id ,boolean passport1, String nationality, String dateOfBirth, String address, int postalCode, String address, String province    ) {
//        String insertQuery = "INSERT INTO user_data (surname, first_name, /* ... other columns */) VALUES (?, ?, /* ... other placeholders */)";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
//            preparedStatement.setString(1, surname);
//            preparedStatement.setString(2, firstName);
//            // ... (set other parameters)
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (saId.isSelected()) {
            id.setText("ID:");
            idTxt.setText(" ");
        } else if (passport.isSelected()) {
            id.setText("Passport:");
            idTxt.setText(" ");

        }
    }

}
