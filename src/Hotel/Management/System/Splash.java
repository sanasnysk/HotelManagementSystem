package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

    Splash(){
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/splash.gif"));
        Image img = imageIcon.getImage().getScaledInstance(858,680,Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img);
        JLabel label_splash = new JLabel(img2);
        label_splash.setBounds(0, 0, 858, 680);
        add(label_splash);

        setLayout(null);
        setUndecorated(true);
        setLocation(300, 80);
        setSize(858, 680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        try {
            Thread.sleep(5000);
            setVisible(false);
            new Login();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
            new Splash();
    }
}
