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

public class LoginFormGUI extends Form {

    JTextField usernameField;
    JTextField passwordField;
    DAO dao;
    String userId;
//    WorkerLogin wl;
    studyChoiceGui scg;

    public LoginFormGUI() {
        super("Login"); // This sets the title of the JFrame
        addGuiComponents();
        dao = new DAO();
//        wl = new WorkerLogin();
    }

    public void addGuiComponents() {
        // create login label
        JLabel loginLabel = new JLabel("Login");

        //configure component's x,y position and width/height values relative to the Gui
        loginLabel.setBounds(0, 25, 780, 120);

        // change the font color
        loginLabel.setForeground(CommonConstrants.TEXT_COLOR);

        // change the font size
        loginLabel.setFont(new Font("Arial", Font.BOLD, 50));

        // center text
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //add component to GUI
        add(loginLabel);

        // create username label
        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setBounds(150, 150, 400, 25);
        usernameLabel.setForeground(CommonConstrants.TEXT_COLOR);
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 24));

        // create username text field
        usernameField = new JTextField();
        usernameField.setBounds(150, 190, 450, 50);
        usernameField.setBackground(CommonConstrants.SECONDARY_COLOR);
        usernameField.setForeground(CommonConstrants.TEXT_COLOR);
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 24));

        // Add the username label and field to the GUI
        add(usernameLabel);
        add(usernameField);

        // create password label
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(150, 335, 400, 25);
        passwordLabel.setForeground(CommonConstrants.TEXT_COLOR);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 24));

        // create password text field
        passwordField = new JPasswordField();
        passwordField.setBounds(150, 365, 450, 50);
        passwordField.setBackground(CommonConstrants.SECONDARY_COLOR);
        passwordField.setForeground(CommonConstrants.TEXT_COLOR);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 24));

        // Add the password label and field to the GUI
        add(passwordLabel);
        add(passwordField);

        //create login button
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 24));

        // change the cursor to a hand when hover over the button
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.setBounds(230, 500, 250, 60);
        add(loginButton);

        // create register label (used to load the register GUI
        JLabel registerLabel = new JLabel("Not a user? Register Here!");
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // add functionality so that when clicks it will launch it will the register form gui
        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //dispose of this GUI
                LoginFormGUI.this.dispose();

                //launch the register gui
                new RegisterFormGui().setVisible(true);
            }

        });
        registerLabel.setBounds(125, 600, 250, 30);
        add(registerLabel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username1 = usernameField.getText();
                String password1 = passwordField.getText();
                
                String username2 = username1;
                String password2 = password1;
                UniversityGui gui = new UniversityGui();
                gui.lblMessage4.setText(username1);
                DAO userDAO = new DAO();
                userId = userDAO.getUserId(username1, password1);
                String idd = userId;
                studyChoiceGui scg = new studyChoiceGui();
                scg.lblUsername.setText(idd);
                if (dao.authenticateUser(username1, password1)) {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    UniversityGui gui2 = new UniversityGui();
                    gui2.setGUI();
                    setVisible(false);
                    if (userId != null) {
                        System.out.println("User ID: " + idd);

                    } else {
                        System.out.println("Error: user not found");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
                }

            }

        });

    }

}
