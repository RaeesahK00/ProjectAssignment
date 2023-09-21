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
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author 221376321 Mogammad Mas'ood Lamera
 */
public class UserGui extends JFrame {

    JPanel pnlN, pnlC, pnlS;
    JButton btnEdit, btnOK, btnUpdate, btnSpace;
    JLabel heading = new JLabel("This is Your Profile ");

    Border border = BorderFactory.createBevelBorder(WIDTH, Color.black, Color.black);

    JLabel lblUserImage, lblSchoolImage, lblNicknameImage, lblEmergConImage;
    JLabel lblName, lblEmail, lblSchool, lblNickname, lblEmergConName, lblEmergConNum;
    JLabel lblUserName, lblUserEmail, lblUserSchool, lblUserNickname, lblUserEmergConName, lblUserEmergConNum;
    JTextField txtName, txtEmail, txtSchool, txtNickname, txtEmergConName, txtEmergConNum;

//    UniversityDomain domain;
//    CourseDao dao;

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
        lblUserImage = new JLabel();
        lblUserImage.setIcon(new ImageIcon("C:\\Users\\cash\\Documents\\NetBeansProjects\\RunProject2_221376321\\src\\main\\java\\runproject\\UserImage1.jpg"));
        lblUserImage.setSize(5, 5);
        lblSchoolImage = new JLabel();

        txtName = new JTextField("Abdul Isaacs");
        txtName.setEditable(false);
        txtName.setBorder(null);
        txtEmail = new JTextField("aisaacs@gmail.com");
        txtEmail.setBorder(null);
        txtEmail.setEditable(false);
        txtSchool = new JTextField("Spine Road High School");
        txtSchool.setEditable(false);
        txtSchool.setBorder(null);
        txtNickname = new JTextField("Dalla");
        txtNickname.setEditable(false);
        txtNickname.setBorder(null);
        txtEmergConName = new JTextField("Faried");
        txtEmergConName.setEditable(false);
        txtEmergConName.setBorder(null);
        txtEmergConNum = new JTextField("0718529654");
        txtEmergConNum.setEditable(false);
        txtEmergConNum.setBorder(null);


        /* lblSchoolImage.setIcon(new ImageIcon("SchoolImage.jpg"));
        lblNicknameImage = new JLabel();
        lblNicknameImage.setIcon(new ImageIcon("NicknameImage.png"));
        lblEmergConImage = new JLabel();
        lblEmergConImage.setIcon(new ImageIcon("EmergConImage.jpg"));*/
        lblName = new JLabel("Name");
        lblEmail = new JLabel("Email");
        lblSchool = new JLabel("School Attended");
        lblNickname = new JLabel("Nickname");
        lblEmergConName = new JLabel("Emergency Contact Name");
        lblEmergConNum = new JLabel("Emergency Contact Number");

//        lblUserName = new JLabel("Mogammad Mas'ood");
//        lblUserEmail = new JLabel("masood@email.com");
//        lblUserSchool = new JLabel("Cape Peninsula University of Technology");
//        lblUserNickname = new JLabel("Mas'ood");
//        lblUserEmergConName = new JLabel("Mogammad");
//        lblUserEmergConNum = new JLabel("0211234567");

//        dao = new CourseDao();
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

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtName.setEditable(true);
                txtName.setBorder(border);
                txtName.setText("Abdul Isaacs");

                txtEmail.setBorder(border);
                txtEmail.setEditable(true);
                txtEmail.setText("aisaacs@gmail.com");

                txtSchool.setEditable(true);
                txtSchool.setBorder(border);
                txtSchool.setText("Spine Road High");

                txtNickname.setEditable(true);
                txtNickname.setBorder(border);
                txtNickname.setText("Dalla");

                txtEmergConName.setEditable(true);
                txtEmergConName.setBorder(border);
                txtEmergConName.setText("Faried");

                txtEmergConNum.setEditable(true);
                txtEmergConNum.setBorder(border);
                txtEmergConNum.setText("0718529654");

                btnUpdate.setVisible(true);
            }

        });

//        btnUpdate.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                String name = txtName.getText();
//                String email = txtEmail.getText();
//                String school = txtSchool.getText();
//                String nickname = txtNickname.getText();
//                String emergName = txtEmergConName.getText();
//                String emergNum = txtEmergConNum.getText();
//                
//                UniversityDomain dom= new UniversityDomain( name, email, school, nickname,emergName,emergNum);
//                 domain = dao.updateUserInfo(dom);
//                if (domain.equals(dom)) {
//                            JOptionPane.showMessageDialog(null, "Your update has been completed. Please Click OK below to proceed ");
//                            //Move to Raeesah's SubSystem
//                        }else {
//                    JOptionPane.showMessageDialog(null, "Please choose a course of your choice");
//                }
//               
//                
//                txtName.setEditable(false);
//                txtName.setBorder(null);
//
//                txtEmail.setBorder(null);
//                txtEmail.setEditable(false);
//
//                txtSchool.setEditable(false);
//                txtSchool.setBorder(null);
//
//                txtNickname.setEditable(false);
//                txtNickname.setBorder(null);
//
//                txtEmergConName.setEditable(false);
//                txtEmergConName.setBorder(null);
//
//                txtEmergConNum.setEditable(false);
//                txtEmergConNum.setBorder(null);
//
//                btnUpdate.setVisible(false);
//            }
//            
//
//        });
//        // pnlW.setLayout(new GridLayout(9 ,3));
//
        pnlN.add(heading);
        pnlN.add(lblUserImage);

        pnlC.add(lblName);
        pnlC.add(txtName);

        pnlC.add(lblEmail);
        pnlC.add(txtEmail);

        pnlC.add(lblSchool);
        pnlC.add(txtSchool);

        pnlC.add(lblNickname);
        pnlC.add(txtNickname);

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
