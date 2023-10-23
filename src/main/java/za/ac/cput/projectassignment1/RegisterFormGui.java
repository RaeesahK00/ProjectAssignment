package za.ac.cput.projectassignment1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegisterFormGui extends Form {

    JTextField idenityField;
    JTextField nameField;
    JTextField usernameField;
    JTextField surnameField;
    JTextField emailField;
    JPasswordField passwordField;
    //JPasswordField rePasswordField;
    DAO dao;

    public RegisterFormGui() {
        super("Register");
        addGuiComponents();
        dao = new DAO();
    }

    private void addGuiComponents() {
        // create register label
        JLabel registerLabel = new JLabel("Register");
        registerLabel.setBounds(02, 10, 780, 120); // Adjusted position to be higher
        registerLabel.setForeground(CommonConstrants.TEXT_COLOR);
        registerLabel.setFont(new Font("Arial", Font.BOLD, 50));
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(registerLabel);

        // create name label
        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(140, 110, 100, 25);
        nameLabel.setForeground(CommonConstrants.TEXT_COLOR);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        add(nameLabel);

        // create name text field
        nameField = new JTextField();
        nameField.setBounds(140, 140, 450, 30);
        nameField.setBackground(CommonConstrants.SECONDARY_COLOR);
        nameField.setForeground(CommonConstrants.TEXT_COLOR);
        add(nameField);

        // create surname label
        JLabel surnameLabel = new JLabel("Surname: ");
        surnameLabel.setBounds(140, 190, 120, 25);
        surnameLabel.setForeground(CommonConstrants.TEXT_COLOR);
        surnameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        add(surnameLabel);

        // create surname text field
        surnameField = new JTextField();
        surnameField.setBounds(140, 220, 450, 30);
        surnameField.setBackground(CommonConstrants.SECONDARY_COLOR);
        surnameField.setForeground(CommonConstrants.TEXT_COLOR);
        add(surnameField);

        // create identity label
        JLabel idenityLabel = new JLabel("Identity Number: ");
        idenityLabel.setBounds(140, 270, 200, 25);
        idenityLabel.setForeground(CommonConstrants.TEXT_COLOR);
        idenityLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        add(idenityLabel);

        // create identity text field
        idenityField = new JTextField();
        idenityField.setBounds(140, 300, 450, 30);
        idenityField.setBackground(CommonConstrants.SECONDARY_COLOR);
        idenityField.setForeground(CommonConstrants.TEXT_COLOR);
        add(idenityField);

        // create email label
        JLabel emailLabel = new JLabel("Email Address: ");
        emailLabel.setBounds(140, 350, 200, 25);
        emailLabel.setForeground(CommonConstrants.TEXT_COLOR);
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        add(emailLabel);

        // create email text field
        emailField = new JTextField();
        emailField.setBounds(140, 380, 450, 30);
        emailField.setBackground(CommonConstrants.SECONDARY_COLOR);
        emailField.setForeground(CommonConstrants.TEXT_COLOR);
        add(emailField);

        // create username label
        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setBounds(140, 420, 150, 25);
        usernameLabel.setForeground(CommonConstrants.TEXT_COLOR);
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        add(usernameLabel);

        // create username text field
        usernameField = new JTextField();
        usernameField.setBounds(140, 450, 450, 30);
        usernameField.setBackground(CommonConstrants.SECONDARY_COLOR);
        usernameField.setForeground(CommonConstrants.TEXT_COLOR);
        add(usernameField);

        // create password label
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(140, 490, 250, 25);
        passwordLabel.setForeground(CommonConstrants.TEXT_COLOR);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        add(passwordLabel);

        // create password text field
        passwordField = new JPasswordField();
        passwordField.setBounds(140, 520, 450, 30);
        passwordField.setBackground(CommonConstrants.SECONDARY_COLOR);
        passwordField.setForeground(CommonConstrants.TEXT_COLOR);
        add(passwordField);

        // create re-enter password label
//        JLabel rePasswordLabel = new JLabel("Re-enter Password: ");
//        rePasswordLabel.setBounds(140, 560, 300, 25);
//        rePasswordLabel.setForeground(CommonConstrants.TEXT_COLOR);
//        rePasswordLabel.setFont(new Font("Arial", Font.PLAIN, 18));
//        add(rePasswordLabel);
//
//        // create re-enter password text field
//        rePasswordField = new JPasswordField();
//        rePasswordField.setBounds(140, 600, 450, 30);
//        rePasswordField.setBackground(CommonConstrants.SECONDARY_COLOR);
//        rePasswordField.setForeground(CommonConstrants.TEXT_COLOR);
//        add(rePasswordField);
        // Create the "Register" button
        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Arial", Font.BOLD, 18));
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerButton.setBounds(150, 650, 250, 40);
        add(registerButton);

        // create login label
        JLabel loginLabel = new JLabel("Have an account? Login Here!");
        loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginLabel.setForeground(CommonConstrants.TEXT_COLOR);

        // add functionality so that when clicks it will launch it will the register form gui
        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //dispose of this GUI
                RegisterFormGui.this.dispose();

                //launch the register gui
                new RegisterFormGui().setVisible(true);
            }
        });
        loginLabel.setBounds(185, 670, 250, 30);
        add(loginLabel);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idenityField.getText();
                String name = nameField.getText();
                String surname = surnameField.getText();
                String username = usernameField.getText();
                String email = emailField.getText();
                char[] password = passwordField.getPassword();
//                char[] rePassword = rePasswordField.getPassword();
                if (name.isEmpty() || !name.matches("[a-zA-Z]+(\\s[a-zA-Z]+)?")) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid first name.");
                    nameField.setText("");;
                    nameField.requestFocus();
                    return;
                } else if (surname.isEmpty() || !surname.matches("[a-zA-Z]+(\\s[a-zA-Z]+)?")) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid surname.");
                    surnameField.setText("");;
                    surnameField.requestFocus();
                    return;
                } else if (id.isEmpty() || id.matches("[a-zA-Z]+(\\s[a-zA-Z]+)?")) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid ID.");
                    idenityField.setText("");
                    idenityField.requestFocus();
                    return;
                } else if (password.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid password.");
                    passwordField.setText("");;
                    passwordField.requestFocus();
                    return;
                } else if (dao.authenticateID(id)) {
                    JOptionPane.showMessageDialog(null, "This ID has already been registered");
                } else if (dao.authenticateUsername(username)) {
                    JOptionPane.showMessageDialog(null, "This username has already been taken");
                    usernameField.setText("");
                } else {
                    try {

                        JOptionPane.showMessageDialog(null, "You have been successfully registered. Please Log In.");
                        dao.enrollStudent(id, name, surname, email, username, String.valueOf(password));
                        dao.saveUserProfile(id, name, surname);
                        new LoginFormGUI().setVisible(true);
                        setVisible(false);

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Your information could not be saved");
                    }

                }
                return;
            }

        });

    }
}
