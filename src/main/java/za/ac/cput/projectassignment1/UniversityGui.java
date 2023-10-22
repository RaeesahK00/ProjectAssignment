package za.ac.cput.projectassignment1;

/**
 * 222518596
 *
 * @author Ronald Hercules
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UniversityGui extends JFrame implements ActionListener {

    private final JPanel panelNorth;
    private final JPanel panelSouth;

    private final JPanel panelCenter, panelCombo, panelLeft, panelRight;
    private final ApsScorePage ApsScorePage;
    private final JButton btnNext, btnExternalTest, btnSave, btnClear;
    String selectedOption;
    private final JComboBox<String> comboFaculty;
    private final JLabel lblMessage1, lblMessage2, lblMessage3, lblMessage4, lblHeading, txt1Label, txt2Label;
    public JTextField txt1, txt2;
    private final Font ft1, ft2, ft3, ft4;
    private final DAO dao;
    private studyChoiceGui classB;
    private String choice1, choice2;

    public void updateChoiceLabels(String choice1, String choice2) {
        ApsScorePage.updateChoiceLabels(choice1, choice2);
    }

    public UniversityGui() {
        super("University Gui");

        panelNorth = new JPanel();
        panelSouth = new JPanel();
        panelCenter = new JPanel();
        panelCombo = new JPanel();
        panelLeft = new JPanel();
        panelRight = new JPanel();

        ft1 = new Font("Arial", Font.BOLD, 18);
        ft2 = new Font("Arial", Font.BOLD, 16);
        ft3 = new Font("Arail", Font.PLAIN, 16);
        ft4 = new Font("Arial", Font.BOLD, 12);

        btnNext = new JButton("NEXT");
        btnExternalTest = new JButton("EXTERNAL TEST");
        btnSave = new JButton("Save Option");
        btnClear = new JButton("CLEAR ");

        comboFaculty = new JComboBox<>();

        lblHeading = new JLabel("UNILINK Career Options", SwingConstants.CENTER);
        lblHeading.setPreferredSize(new Dimension(300, 40));
        lblHeading.setFont(ft1);

//    //    ImageIcon originalIcon = new ImageIcon(UniversityGui.class.getResource("/images/UniLinkLogo.JPG"));
//        Image originalImage = originalIcon.getImage();
//        Image scaledImage = originalImage.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
//        ImageIcon scaledIcon = new ImageIcon(scaledImage);
//        lblImage = new JLabel(scaledIcon, SwingConstants.CENTER);
        txt1 = new JTextField(10);
        txt1.setPreferredSize(new Dimension(10, 10));
        txt1Label = new JLabel("First Choice");
        txt1Label.setFont(ft2);
        txt2 = new JTextField(10);
        txt2.setPreferredSize(new Dimension(10, 10));
        txt2Label = new JLabel("Second Choice");
        txt2Label.setFont(ft2);
        lblMessage1 = new JLabel("Not Sure What To Study?", SwingConstants.CENTER);
        lblMessage1.setFont(ft2);
        lblMessage2 = new JLabel("Try this career Aptitude Test for free", SwingConstants.CENTER);
        lblMessage2.setFont(ft2);
        lblMessage3 = new JLabel("Find Study Options Per Faculty", SwingConstants.CENTER);
        lblMessage3.setFont(ft2);
        lblMessage4 = new JLabel("Click Next to take check APS Score ", SwingConstants.CENTER);
        lblMessage4.setFont(ft2);

        ApsScorePage = new ApsScorePage();

        btnExternalTest.setForeground(Color.BLACK);
        btnExternalTest.setBackground(Color.WHITE);
        btnExternalTest.setFont(ft2);
        btnSave.setForeground(Color.BLACK);
        btnSave.setBackground(Color.WHITE);
        btnSave.setFont(ft2);
        btnClear.setForeground(Color.black);
        btnClear.setBackground(Color.white);
        btnClear.setFont(ft2);
        btnNext.setForeground(Color.black);
        btnNext.setBackground(Color.white);
        btnNext.setFont(ft2);
        btnNext.setVisible(false);
        dao = new DAO();

    }

    public void setGUI() {
        panelNorth.setLayout(new GridLayout(1, 1));
        panelCenter.setLayout(new GridLayout(1, 2));
        panelLeft.setLayout(new GridLayout(7, 1));
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        panelSouth.setLayout(new GridLayout(1, 2));

        panelNorth.add(lblHeading);
        panelNorth.setBackground(Color.LIGHT_GRAY);
        lblHeading.setForeground(Color.black);
        lblHeading.setFont(ft1);

        comboFaculty.addItem("Choose a faculty of your choice");
        comboFaculty.addItem("Faculty of Applied Sciences");
        comboFaculty.addItem("Faculty of Business and Management Sciences");
        comboFaculty.addItem("Faculty of Engineering & the Built Environment");
        comboFaculty.addItem("Faculty of Informatics and Design");
        comboFaculty.addItem("Faculty of Education");
        
        panelCombo.setLayout(new GridLayout(2, 1, 5, 5));
        panelCombo.add(comboFaculty);
        panelCombo.setBackground(Color.LIGHT_GRAY);
        comboFaculty.setFont(ft4);

        panelLeft.add(lblMessage1);
        lblMessage1.setFont(ft1);
        panelLeft.add(lblMessage2);
        lblMessage2.setFont(ft4);
        panelLeft.add(btnExternalTest);
        panelLeft.add(lblMessage3);
        lblMessage3.setFont(ft4);
        panelLeft.add(panelCombo);
        panelLeft.add(lblMessage4);
        lblMessage4.setFont(ft4);
        panelLeft.setBackground(Color.LIGHT_GRAY);

        //  lblImage.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //  panelRight.add(lblImage);
        //  lblImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelRight.add(txt1Label);
        txt1Label.setFont(ft2);
        panelRight.add(txt1);
        panelRight.add(txt2Label);
        txt2Label.setFont(ft2);
        panelRight.add(txt2);
        panelRight.setBackground(Color.LIGHT_GRAY);

        txt1.setPreferredSize(new Dimension(20, 20));
        txt2.setPreferredSize(new Dimension(20, 20));
        txt1.setEditable(false);
        txt2.setEditable(false);
        txt1Label.setFont(ft3);
        txt2Label.setFont(ft3);

        panelRight.add(Box.createVerticalStrut(10));
        panelRight.add(txt1Label);
        panelRight.add(Box.createVerticalStrut(5));
        panelRight.add(txt1);
        panelRight.add(Box.createVerticalStrut(10));
        panelRight.add(txt2Label);
        panelRight.add(Box.createVerticalStrut(5));
        panelRight.add(txt2);
        panelRight.add(Box.createVerticalStrut(10));
        panelCenter.add(panelLeft);
        panelCenter.add(panelRight);
        panelCenter.setBackground(Color.LIGHT_GRAY);
        panelLeft.add(Box.createHorizontalStrut(10));
        panelLeft.setBackground(Color.LIGHT_GRAY);

        panelSouth.add(btnSave);
        panelSouth.add(btnClear);
        panelSouth.add(btnNext);
        panelSouth.setBackground(Color.LIGHT_GRAY);

        btnNext.addActionListener(this);
        btnExternalTest.addActionListener(this);
        btnSave.addActionListener(this);
        btnClear.addActionListener(this);

        getContentPane().add(panelNorth, BorderLayout.NORTH);
        getContentPane().add(panelCenter, BorderLayout.CENTER);
        getContentPane().add(panelSouth, BorderLayout.SOUTH);

        panelLeft.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelRight.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setVisible(true);
        btnSave.setEnabled(false);

        comboFaculty.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                btnSave.setEnabled(true);
            }

        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            // Get the text from the text fields
            choice1 = txt1.getText();
            choice2 = txt2.getText();

            studyChoiceGui.displayText(choice1);
            studyChoiceGui.displayText(choice2);
            // Show the ApsScorePage
            ApsScorePage.setVisible(true);
            ApsScorePage.updateChoiceLabels(choice1, choice2);

            setEnabled(false);
            setVisible(false);
        } else if (e.getSource() == btnExternalTest) {

            try {
                java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://www.careerizma.com/app/ct/freecareertest.php"));
            } catch (java.io.IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else if (e.getSource() == btnSave) {

            selectedOption = (String) comboFaculty.getSelectedItem();
            JOptionPane.showMessageDialog(this, "Choice of study: " + selectedOption);
            btnNext.setVisible(true);

            String textField1Text = txt1.getText();
            String textField2Text = txt2.getText();

            if (textField1Text.isEmpty()) {
                txt1.setText(selectedOption);
            } else if (textField2Text.isEmpty()) {
                txt2.setText(selectedOption);
            }
            if (selectedOption != null) {
                // Disable the selected item to prevent it from being chosen again
                comboFaculty.removeItem(selectedOption);
            }

            if (!textField1Text.isEmpty() && !textField2Text.isEmpty()) {
                btnSave.setEnabled(false);

                // Save the choices to the database
                Study_choice study_choice = new Study_choice(textField1Text, textField2Text);

                try {
                    dao.save(study_choice);
                } catch (SQLException ex) {
                    Logger.getLogger(UniversityGui.class.getName()).log(Level.SEVERE, null, ex);
                }

                JOptionPane.showMessageDialog(this, "Study choices saved.");
            }
        } else if (e.getSource() == btnClear) {
            txt1.setText("");
            txt2.setText("");
        }
    }

    public void showMainPage() {
        setVisible(true);
    }

    public static void main(String[] args) {
        UniversityGui gui = new UniversityGui();
        gui.setGUI();
        gui.setLocationRelativeTo(null);
    }
}
