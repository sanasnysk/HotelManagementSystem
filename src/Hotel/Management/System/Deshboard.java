package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Deshboard extends JFrame {

    JButton btn_add, btn_rec;
    JLabel lblUser;
    static JLabel users;
    String user;
    Deshboard(){
        super("   HOTEL MANAGEMENT SYSTEM");

        initDeshboard();
        actionListener();
        users = lblUser;

        getContentPane().setBackground(new Color(3, 45, 48));
        setLayout(null);
        setLocation(-10, 0);
        setSize(1940, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initDeshboard(){

        btn_rec = new JButton("RECEPTION");
        btn_rec.setBounds(425, 510, 140, 30);
        btn_rec.setFont(new Font("Tahoma", Font.BOLD, 16));
        btn_rec.setBackground(new Color(255, 98, 0));
        btn_rec.setForeground(Color.WHITE);
        add(btn_rec);

        btn_add = new JButton("ADMIN");
        btn_add.setBounds(880, 510, 140, 30);
        btn_add.setFont(new Font("Tahoma", Font.BOLD, 16));
        btn_add.setBackground(new Color(255, 98, 0));
        btn_add.setForeground(Color.WHITE);
        add(btn_add);

        ImageIcon imageAdd = new ImageIcon(ClassLoader.getSystemResource("icon/boss.png"));
        Image img_add = imageAdd.getImage().getScaledInstance(200,195,Image.SCALE_DEFAULT);
        ImageIcon ic_add = new ImageIcon(img_add);
        JLabel label_add = new JLabel(ic_add);
        label_add.setBounds(850, 300, 200, 195);
        add(label_add);

        ImageIcon imageRec = new ImageIcon(ClassLoader.getSystemResource("icon/Reception.png"));
        Image img_rec = imageRec.getImage().getScaledInstance(200,195,Image.SCALE_DEFAULT);
        ImageIcon ic_rec = new ImageIcon(img_rec);
        JLabel label_rec = new JLabel(ic_rec);
        label_rec.setBounds(400, 300, 200, 195);
        add(label_rec);

        ImageIcon imageDeshboard = new ImageIcon(ClassLoader.getSystemResource("icon/deshboard.gif"));
        Image imgDeshboard = imageDeshboard.getImage().getScaledInstance(1940,1080,Image.SCALE_DEFAULT);
        ImageIcon imgBoard = new ImageIcon(imgDeshboard);
        JLabel label_deshboard = new JLabel(imgBoard);
        label_deshboard.setBounds(-10, 0, 1940, 1080);
        add(label_deshboard);

        lblUser = new JLabel("user admin");
        lblUser.setBounds(1800,5, 120, 20);
        lblUser.setFont(new Font("Tahoma", Font.PLAIN,18));
        lblUser.setForeground(new Color(3, 10, 195));
        label_deshboard.add(lblUser);
    }

    public void actionListener(){
        btn_rec.addActionListener(e -> {
            setVisible(false);
            new Reception();
            user = lblUser.getText();
            Reception.users.setText(user);
        });

        btn_add.addActionListener(e -> {
            setVisible(false);
            new LoginAdmin();
            user = lblUser.getText();
            LoginAdmin.users.setText(user);
        });

        lblUser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int result = JOptionPane.showConfirmDialog(null,"Do you want to log out?", "Log Out", JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_NO_OPTION){
                    System.exit(101);
                }else {
                    JOptionPane.showMessageDialog(null, "Do you want to keep your login?");
                }

            }
        });
    }

    public static void main(String[] args) {
        new Deshboard();
    }
}
