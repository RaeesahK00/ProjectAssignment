package za.ac.cput.projectassignment1;
//import Database.MyJDBC;

import javax.swing.*;

public class AppLauncher {

    public static void main(String[] args) {
         SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // instantiate a LoginFormGui obj and make it visible
                new LoginFormGUI().setVisible(true);

                // check user test
//                System.out.println(MyJDBC.checkUser("username"));
            }
        });
    }
}
