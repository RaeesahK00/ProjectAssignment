package za.ac.cput.projectassignment1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Desktop
 */
public class GuiPOP1 extends JFrame {

    private JLabel heading, pic1, pic2, pic3;
    private JTextArea text;
    private JButton agree;
    private JPanel panelN, panelC, panelS;
    private Font font1, font2, font3;

    public GuiPOP1() {

        font1 = new Font("Arial", Font.BOLD, 18);
        font2 = new Font("Arial", Font.BOLD, 16);
        font3 = new Font("Arial", Font.PLAIN, 16);

        panelN = new JPanel(new GridLayout(1, 3, 0, 0));
        panelC = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 0));
        panelS = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));

        this.setBackground(Color.WHITE);

        heading = new JLabel("Consent to Process Personal Information");
        heading.setFont(font1);
        heading.setBounds(50, 50, 100, 30);
        pic1 = new JLabel(new ImageIcon("cput.jpg"));
        pic2 = new JLabel(new ImageIcon("uwc.jpg"));
        pic3 = new JLabel(new ImageIcon("uct.jpg"));

        text = new JTextArea("""
                            I hereby agree, understand, consent and irrevocably authorize the Cape Peninsula University of Technology,University 
                            of the Western Cape and University of Cape Town to keep, use process and verify information in paper and electronic 
                            format,including information supplied by me during the application and registration process. 
                             
                            Furthermore,I irrevocably authorise and expressly give my consent that the Cape Peninsula University of Technology,
                            University of the Western Cape and University of Cape Town may use, provide or disclose and information including 
                            my bursaries/sponsorships available to prospective students at Higher Education Institutions such as the Cape 
                            PeninsulaUniversity of Technology, University of the Western Cape and University of Cape Town.
                             """);
        text.setFont(font3);

        text.setEditable(false);

        agree = new JButton("I Agree");
        agree.setFont(font2);
        agree.setBounds(100, 100, 100, 30);
    }

    public void setGui() {
        panelN.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelN.setBackground(Color.WHITE);
        text.setBorder(BorderFactory.createEmptyBorder(20, 5, 20, 20));
        panelC.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelC.setBackground(Color.WHITE);

        panelS.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelS.setBackground(Color.WHITE);

        panelN.add(pic1);
        panelN.add(pic2);
        panelN.add(pic3);

        panelC.add(heading);
        panelC.add(text);

        panelS.add(agree);

        add(panelN, BorderLayout.NORTH);
        add(panelC, BorderLayout.CENTER);
        add(panelS, BorderLayout.SOUTH);

        agree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == agree) {

                    int result = JOptionPane.showOptionDialog(null,
                            "Moving to the next application section you will need to submit a certified copy of your ID and Results.\nDo you have them ready to be submitted?", "Confirmation",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                            new String[]{"Yes", "No"}, "Yes");
                    if (result == JOptionPane.YES_OPTION) {

                        GuiA run = new GuiA();
                        run.setTitle("Online Application Section A");
                        run.setVisible(true);
                        run.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        run.setGuiA();
                        run.setSize(850, 800);
                        run.setLocationRelativeTo(null);
                        setVisible(false);
                    }

                    if (result == JOptionPane.NO_OPTION) {
                        /*  GuiA run = new GuiA();
                        run.setTitle("Online Application Section A");
                        run.setVisible(true);
                        run.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        run.setGuiA();
                        run.setSize(850, 800);
                        run.setLocationRelativeTo(null);
                        setVisible(false);
                         */
                    }
                }
            }
        });
    }

}
