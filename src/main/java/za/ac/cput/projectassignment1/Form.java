package za.ac.cput.projectassignment1;


import javax.swing.*;

public class Form extends JFrame {
    // create constructor
    public Form(String title){
        super(title);
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(CommonConstrants.PRIMARY_COLOR);
    }
}