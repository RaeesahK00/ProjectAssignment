package za.ac.cput.projectassignment1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterFormGui extends Form {
    public RegisterFormGui() {
        super("Register");
        addGuiComponents();
    }

    private void addGuiComponents() {
        // create register label
        JLabel registerLabel = new JLabel("Register");
        registerLabel.setBounds(0, 10, 780, 120); // Adjusted position to be higher
        registerLabel.setForeground(CommonConstrants.TEXT_COLOR);
        registerLabel.setFont(new Font("Arial", Font.BOLD, 60));
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(registerLabel);

        // create name label
        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(30, 150, 100, 25);
        nameLabel.setForeground(CommonConstrants.TEXT_COLOR);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        add(nameLabel);

        // create name text field
        JTextField nameField = new JTextField();
        nameField.setBounds(30, 180, 450, 39);
        nameField.setBackground(CommonConstrants.SECONDARY_COLOR);
        nameField.setForeground(CommonConstrants.TEXT_COLOR);
        add(nameField);

        // create surname label
        JLabel surnameLabel = new JLabel("Surname: ");
        surnameLabel.setBounds(30, 230, 120, 25);
        surnameLabel.setForeground(CommonConstrants.TEXT_COLOR);
        surnameLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        add(surnameLabel);

        // create surname text field
        JTextField surnameField = new JTextField();
        surnameField.setBounds(30, 260, 450, 39);
        surnameField.setBackground(CommonConstrants.SECONDARY_COLOR);
        surnameField.setForeground(CommonConstrants.TEXT_COLOR);
        add(surnameField);

        // create email label
        JLabel emailLabel = new JLabel("Email Address: ");
        emailLabel.setBounds(30, 310, 200, 25);
        emailLabel.setForeground(CommonConstrants.TEXT_COLOR);
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        add(emailLabel);

        // create email text field
        JTextField emailField = new JTextField();
        emailField.setBounds(30, 340, 450, 39);
        emailField.setBackground(CommonConstrants.SECONDARY_COLOR);
        emailField.setForeground(CommonConstrants.TEXT_COLOR);
        add(emailField);

        // create username label
        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setBounds(30, 390, 150, 25);
        usernameLabel.setForeground(CommonConstrants.TEXT_COLOR);
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        add(usernameLabel);

        // create username text field
        JTextField usernameField = new JTextField();
        usernameField.setBounds(30, 420, 450, 39);
        usernameField.setBackground(CommonConstrants.SECONDARY_COLOR);
        usernameField.setForeground(CommonConstrants.TEXT_COLOR);
        add(usernameField);

        // create password label
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(30, 470, 150, 25);
        passwordLabel.setForeground(CommonConstrants.TEXT_COLOR);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        add(passwordLabel);

        // create password text field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(30, 500, 450, 39);
        passwordField.setBackground(CommonConstrants.SECONDARY_COLOR);
        passwordField.setForeground(CommonConstrants.TEXT_COLOR);
        add(passwordField);

        // create re-enter password label
        JLabel rePasswordLabel = new JLabel("Re-enter Password: ");
        rePasswordLabel.setBounds(30, 550, 250, 25);
        rePasswordLabel.setForeground(CommonConstrants.TEXT_COLOR);
        rePasswordLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        add(rePasswordLabel);

        // create re-enter password text field
        JPasswordField rePasswordField = new JPasswordField();
        rePasswordField.setBounds(30, 580, 450, 39);
        rePasswordField.setBackground(CommonConstrants.SECONDARY_COLOR);
        rePasswordField.setForeground(CommonConstrants.TEXT_COLOR);
        add(rePasswordField);

        // Create the "Register" button
        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Arial", Font.BOLD, 24));
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerButton.setBounds(205, 630, 250, 40);
        add(registerButton);

        // create login label
        JLabel loginLabel = new JLabel("Have an account? Login Here!");
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
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

    }
}