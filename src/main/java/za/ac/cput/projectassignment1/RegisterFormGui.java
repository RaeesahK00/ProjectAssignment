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
        JTextField nameField = new JTextField();
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
        JTextField surnameField = new JTextField();
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
        JTextField idenityField = new JTextField();
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
        JTextField emailField = new JTextField();
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
        JTextField usernameField = new JTextField();
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
        JPasswordField passwordField = new JPasswordField();
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        passwordField.setBounds(140, 520, 450, 30);
        passwordField.setBackground(CommonConstrants.SECONDARY_COLOR);
        passwordField.setForeground(CommonConstrants.TEXT_COLOR);
        add(passwordField);

        // create re-enter password label
        JLabel rePasswordLabel = new JLabel("Re-enter Password: ");
        rePasswordLabel.setBounds(140, 560, 300, 25);
        rePasswordLabel.setForeground(CommonConstrants.TEXT_COLOR);
        rePasswordLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        add(rePasswordLabel);

        // create re-enter password text field
        JPasswordField rePasswordField = new JPasswordField();
        rePasswordField.setBounds(140, 600, 450, 30);
        rePasswordField.setBackground(CommonConstrants.SECONDARY_COLOR);
        rePasswordField.setForeground(CommonConstrants.TEXT_COLOR);
        add(rePasswordField);

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

    }
}
