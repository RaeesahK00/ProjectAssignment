package za.ac.cput.projectassignment1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ApsScorePage extends JFrame {

    private JPanel panelNorth, panelSouth, panelCenter;
    private JLabel lblHeading, lblImage, lblChoice1, lblChoice2;
    private JButton btnNext, btnCalculateAps, btnBack;
    private JButton btnSave;
    private Font ft1, ft2, ft3, ft4;
//    private UniversityGui universityGui;

    public void updateChoiceLabels(String choice1, String choice2) {
        lblChoice1.setText(  choice1);
        lblChoice2.setText( choice2);
    }

    public ApsScorePage() {
        super("Aps Score Page");

        ft1 = new Font("Arial", Font.BOLD, 18);
        ft2 = new Font("Arial", Font.BOLD, 16);
        ft3 = new Font("Arial", Font.PLAIN, 14);
        ft4 = new Font("Arial", Font.BOLD, 12);

        lblHeading = new JLabel("Have you taken your APS score?", SwingConstants.CENTER);
        lblHeading.setFont(ft1);

//        
//        ImageIcon originalIcon = new ImageIcon(UniversityGui.class.getResource("/images/UniLinkLogo.JPG"));
//Image originalImage = originalIcon.getImage();
//Image scaledImage = originalImage.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
//ImageIcon scaledIcon = new ImageIcon(scaledImage);
//lblImage = new JLabel(scaledIcon, SwingConstants.CENTER);
        btnNext = new JButton("NEXT");
        btnCalculateAps = new JButton("CALCULATE APS");
        btnBack = new JButton("BACK");
        btnSave = new JButton("SAVE");

        panelNorth = new JPanel();
        panelSouth = new JPanel();
        panelCenter = new JPanel();

        panelNorth.setLayout(new GridLayout(1, 1));
        panelCenter.setLayout(new GridLayout(1, 1));
        panelSouth.setLayout(new FlowLayout());

        panelNorth.add(lblHeading);
        panelNorth.setBackground(Color.LIGHT_GRAY);
        lblHeading.setForeground(Color.black);
        lblHeading.setFont(ft1);

        lblChoice1 = new JLabel("Choice 1: ");
        lblChoice1.setFont(ft2);

        lblChoice2 = new JLabel("Choice 2: ");
        lblChoice2.setFont(ft2);

        panelCenter.setLayout(new BorderLayout());
        panelCenter.setBackground(Color.LIGHT_GRAY);

        JPanel choicesPanel = new JPanel();
        choicesPanel.setLayout(new GridLayout(2, 1, 0, 10));
        choicesPanel.add(lblChoice1);
        choicesPanel.add(lblChoice2);

        panelCenter.add(choicesPanel, BorderLayout.NORTH);
//        panelCenter.add(lblImage, BorderLayout.CENTER);

        panelSouth.add(btnCalculateAps);
        panelSouth.add(btnSave);
        panelSouth.add(btnBack);
        panelSouth.add(btnNext);
        panelSouth.setBackground(Color.LIGHT_GRAY);

//        this.universityGui = universityGui;
        btnBack.addActionListener((ActionEvent e) -> {
            UniversityGui GUI = new UniversityGui();
            setVisible(false);
            GUI.setVisible(true);
        });

        btnNext.addActionListener((ActionEvent e) -> {
            String c1 = lblChoice1.getText();
            String c2 = lblChoice2.getText();
            studyChoiceGui gui = new studyChoiceGui();
            gui.lblDiploma.setText(c1);
            gui.setTitle("University Selection");
            gui.setGui();
            gui.setDefaultCloseOperation(gui.EXIT_ON_CLOSE);
            gui.setSize(800, 800);
            gui.setVisible(true);
            gui.setLocationRelativeTo(null);

            setVisible(false);

        });
        btnCalculateAps.addActionListener((ActionEvent e) -> {

            APSGui abt = new APSGui();
            abt.setTitle("Calculate APS Score");
            abt.setVisible(true);
            abt.setLocationRelativeTo(null);
            setVisible(false);
        });

        setLayout(new BorderLayout());
        add(panelNorth, BorderLayout.NORTH);
        add(panelCenter, BorderLayout.CENTER);
        add(panelSouth, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setVisible(false);
    }

    public JButton getBtnNext() {
        return btnNext;
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnCalculateAps() {
        return btnCalculateAps;
    }
}
