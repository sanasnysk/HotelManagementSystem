package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame {

    JButton btnEmployee, btnRoom, btnDrivers, btnSignUp, btnAdmin, btnLogout, btnBack;
    JLabel lblUser, lblAdmin;
    static JLabel users, admins;
    Admin(){

        initAdmin();
        actionListener();
        users = lblUser;
        admins = lblAdmin;

        getContentPane().setBackground(new Color(10, 25, 37));
        setLayout(null);
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initAdmin(){
        btnEmployee = new JButton("ADD EMPLOYEE");
        btnEmployee.setBounds(250, 80, 200, 30);
        btnEmployee.setBackground(Color.WHITE);
        btnEmployee.setForeground(Color.BLACK);
        btnEmployee.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(btnEmployee);

        btnRoom = new JButton("ADD ROOM");
        btnRoom.setBounds(250, 230, 200, 30);
        btnRoom.setBackground(Color.WHITE);
        btnRoom.setForeground(Color.BLACK);
        btnRoom.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(btnRoom);

        btnDrivers = new JButton("ADD DRIVERS");
        btnDrivers.setBounds(250, 380, 200, 30);
        btnDrivers.setBackground(Color.WHITE);
        btnDrivers.setForeground(Color.BLACK);
        btnDrivers.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(btnDrivers);

        btnSignUp = new JButton("Sign Up");
        btnSignUp.setBounds(250, 530, 200, 30);
        btnSignUp.setBackground(Color.WHITE);
        btnSignUp.setForeground(Color.BLACK);
        btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(btnSignUp);

        btnAdmin = new JButton("Add Admin");
        btnAdmin.setBounds(250, 680, 200, 30);
        btnAdmin.setBackground(Color.WHITE);
        btnAdmin.setForeground(Color.BLACK);
        btnAdmin.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(btnAdmin);

        btnLogout = new JButton("LOG OUT");
        btnLogout.setBounds(70, 800, 150, 30);
        btnLogout.setBackground(Color.BLACK);
        btnLogout.setForeground(Color.WHITE);
        btnLogout.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(btnLogout);

        btnBack = new JButton("BACK");
        btnBack.setBounds(230, 800, 150, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(btnBack);

        lblUser = new JLabel("user name");
        lblUser.setBounds(1600,5, 120, 20);
        lblUser.setFont(new Font("Tahoma", Font.PLAIN,18));
        lblUser.setForeground(new Color(10, 25, 37));
        add(lblUser);

        lblAdmin = new JLabel("admin name");
        lblAdmin.setBounds(1800,5, 120, 20);
        lblAdmin.setFont(new Font("Tahoma", Font.PLAIN,18));
        lblAdmin.setForeground(new Color(200, 220, 250));
        add(lblAdmin);

        ImageIcon imageEMP = new ImageIcon(ClassLoader.getSystemResource("icon/employee.png"));
        Image img_emp = imageEMP.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon ic_emp = new ImageIcon(img_emp);
        JLabel label_emp = new JLabel(ic_emp);
        label_emp.setBounds(70, 30, 120, 120);
        add(label_emp);

        ImageIcon imageRm = new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
        Image img_rm = imageRm.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon ic_rm = new ImageIcon(img_rm);
        JLabel label_room = new JLabel(ic_rm);
        label_room.setBounds(70, 190, 120, 120);
        add(label_room);

        ImageIcon imageDr = new ImageIcon(ClassLoader.getSystemResource("icon/driver.png"));
        Image img_dr = imageDr.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon ic_dr = new ImageIcon(img_dr);
        JLabel label_driver = new JLabel(ic_dr);
        label_driver.setBounds(70, 350, 120, 120);
        add(label_driver);

        ImageIcon imageSu = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image imgSu = imageSu.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon iconSu = new ImageIcon(imgSu);
        JLabel label_signup = new JLabel(iconSu);
        label_signup.setBounds(70, 500, 100, 100);
        add(label_signup);

        ImageIcon imageAd = new ImageIcon(ClassLoader.getSystemResource("icon/settings.png"));
        Image imgAd = imageAd.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon iconAd = new ImageIcon(imgAd);
        JLabel label_setting = new JLabel(iconAd);
        label_setting.setBounds(70, 650, 100, 100);
        add(label_setting);

        ImageIcon imageLogin = new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
        Image imgLogin = imageLogin.getImage().getScaledInstance(750,600,Image.SCALE_DEFAULT);
        ImageIcon imgLogin1 = new ImageIcon(imgLogin);
        JLabel label_login = new JLabel(imgLogin1);
        label_login.setBounds(850, 200, 750, 500);
        add(label_login);

    }

    public void actionListener(){
        btnEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployee();
            }
        });

        btnRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddRoom();
            }
        });

        btnDrivers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDriver();
            }
        });

        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignUp();
            }
        });

        btnAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewAdmin();
            }
        });

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(101);
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Deshboard();
                Deshboard.users.setText(lblUser.getText());
            }
        });
    }

    public static void main(String[] args) {
        new Admin();
    }
}
