/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.projectassignment1;

//import Dao.CourseDao;
//import Domain.UniversityDomain;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author 221376321 Mogammad Mas'ood Lamera
 */
public class UserGui extends JFrame {

    JPanel pnlN, pnlC, pnlS;
    JButton btnEdit, btnOK, btnUpdate, btnSpace;
    JLabel heading = new JLabel("Profile ");

    Border border = BorderFactory.createBevelBorder(WIDTH, Color.black, Color.black);

    JLabel lblName, lblUserSurname, lblMail, lblEmergConName, lblEmergConNum;

    JTextField txtName, txtSurname, txtMail, txtEmergConName, txtEmergConNum;

    UniversityDomain domain;
    DAO dao;
    RegisterFormGui rfg;

    public UserGui() {

        pnlN = new JPanel();
        pnlC = new JPanel();
        pnlS = new JPanel();
        pnlC = new JPanel();
        btnSpace = new JButton();
        btnSpace.setVisible(false);
        btnEdit = new JButton("Edit");
        btnOK = new JButton("OK");
        btnUpdate = new JButton("Update Profile");
        btnUpdate.setVisible(false);

        heading.setFont(new Font("Calibri", Font.BOLD, 30));
//        lblUserImage = new JLabel();
//        lblUserImage.setIcon(new ImageIcon("C:\\Users\\cash\\Documents\\NetBeansProjects\\RunProject2_221376321\\src\\main\\java\\runproject\\UserImage1.jpg"));
//        lblUserImage.setSize(5, 5);
//        lblSchoolImage = new JLabel();

        lblName = new JLabel("Name");
        lblUserSurname = new JLabel("Email");
        lblMail = new JLabel("Email: ");
        lblEmergConName = new JLabel("Emergency Contact Name");
        lblEmergConNum = new JLabel("Emergency Contact Number");
        rfg = new RegisterFormGui();
        dao = new DAO();
    }

    public void setGui2() {
        pnlN.setLayout(new GridLayout(1, 2));
        pnlC.setBorder(BorderFactory.createEmptyBorder(30, 30, 0, 30));
        pnlS.setLayout(new GridLayout(1, 2));
        pnlC.setLayout(new GridLayout(7, 2));

        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                studyChoiceGui gui = new studyChoiceGui();
                gui.setVisible(true);
                gui.setTitle("University Selection");
                gui.setGui();
                gui.setSize(800, 800);
                gui.setLocationRelativeTo(null);
                gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }

        });
        dao = new DAO();
        domain = new UniversityDomain();
        String id = "9907015149088";
        try {
            ArrayList<UniversityDomain> arrInfo = dao.getUserProfileInfo(id);
            UniversityDomain fname = arrInfo.get(0);
            String name = fname.getfName();
            txtName = new JTextField();
            txtName.setText(name);
            txtName.setEditable(false);
            txtName.setBorder(null);

            UniversityDomain surname = arrInfo.get(0);
            String lastName = surname.getlName();
            txtSurname = new JTextField();
            txtSurname.setText(lastName);
            txtSurname.setBorder(null);
            txtSurname.setEditable(false);

            UniversityDomain Mail = arrInfo.get(0);
            String email = Mail.getMail();
            txtMail = new JTextField();
            txtMail.setText(email);
            txtMail.setEditable(false);
            txtMail.setBorder(null);

            UniversityDomain emergName = arrInfo.get(0);
            String emergConName = emergName.getEmergConName();
//            if (emergConName.isBlank()) {
//                txtEmergConName.setText("Please enter your details");
//            } else {
                txtEmergConName = new JTextField();
                txtEmergConName.setText(emergConName);
                txtEmergConName.setEditable(false);
                txtEmergConName.setBorder(null);
//            }
            UniversityDomain emergNum = arrInfo.get(0);
            String emergConNum = emergNum.getEmergConNum();
            if (emergConNum.isEmpty()) {
                txtEmergConName.setText("Please enter your details");
            } else {
                txtEmergConNum = new JTextField();
                txtEmergConNum.setText(emergConNum);
                txtEmergConNum.setEditable(false);
                txtEmergConNum.setBorder(null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserGui.class.getName()).log(Level.SEVERE, null, ex);
        }

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtName.setEditable(true);
                txtName.setBorder(border);
                //     txtName.setText("Abdul Isaacs");

                txtSurname.setBorder(border);
                txtSurname.setEditable(true);
                //   txtSurname.setText("aisaacs@gmail.com");

                txtMail.setEditable(true);
                txtMail.setBorder(border);
                //   txtMail.setText("Spine Road High");

                txtEmergConName.setEditable(true);
                txtEmergConName.setBorder(border);
//                if (txtEmergConName.getText().equalsIgnoreCase("Please enter your details")) {
//                    txtEmergConName.setText("");
//                }
                txtEmergConNum.setEditable(true);
                txtEmergConNum.setBorder(border);
//                
//                if (txtEmergConNum.getText().equalsIgnoreCase("Please enter your details"))
//                txtEmergConNum.setText("");
                btnUpdate.setVisible(true);
            }

        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = txtName.getText();
                String surname = txtSurname.getText();
                String mail = txtMail.getText();
                String emergName = txtEmergConName.getText();
                String emergNum = txtEmergConNum.getText();

                UniversityDomain dom = new UniversityDomain(name, surname, mail, emergName, emergNum);
                domain = dao.updateUserInfo(dom);
                if (domain.equals(dom)) {
                    JOptionPane.showMessageDialog(null, "Your update has been completed. Please Click OK below to proceed ");
                    //Move to Raeesah's SubSystem
                } else {
                    JOptionPane.showMessageDialog(null, "Please choose a course of your choice");
                }

                txtName.setEditable(false);
                txtName.setBorder(null);

                txtSurname.setBorder(null);
                txtSurname.setEditable(false);

                txtMail.setEditable(false);
                txtMail.setBorder(null);

                txtEmergConName.setEditable(false);
                txtEmergConName.setBorder(null);

                txtEmergConNum.setEditable(false);
                txtEmergConNum.setBorder(null);

                btnUpdate.setVisible(false);
            }

        });
        // pnlW.setLayout(new GridLayout(9 ,3));

        pnlN.add(heading);
//      pnlN.add(lblUserImage);

        pnlC.add(lblName);
        pnlC.add(txtName);

        pnlC.add(lblUserSurname);
        pnlC.add(txtSurname);

        pnlC.add(lblMail);
        pnlC.add(txtMail);

        pnlC.add(lblEmergConName);
        pnlC.add(txtEmergConName);

        pnlC.add(lblEmergConNum);
        pnlC.add(txtEmergConNum);
        pnlC.add(btnSpace);
        pnlC.add(btnUpdate);
        pnlS.add(btnEdit);
        pnlS.add(btnOK);

        add(pnlN, BorderLayout.NORTH);
        add(pnlS, BorderLayout.SOUTH);
        add(pnlC, BorderLayout.CENTER);

    }

}
