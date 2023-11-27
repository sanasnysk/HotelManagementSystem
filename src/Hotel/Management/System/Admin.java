package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame {

    JButton btnEmployee, btnRoom, btnDrivers, btnLogout, btnBack;
    Admin(){

        initAdmin();
        actionListener();

        getContentPane().setBackground(new Color(10, 25, 37));
        setLayout(null);
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initAdmin(){
        btnEmployee = new JButton("ADD EMPLOYEE");
        btnEmployee.setBounds(250, 230, 200, 30);
        btnEmployee.setBackground(Color.WHITE);
        btnEmployee.setForeground(Color.BLACK);
        btnEmployee.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(btnEmployee);

        btnRoom = new JButton("ADD ROOM");
        btnRoom.setBounds(250, 380, 200, 30);
        btnRoom.setBackground(Color.WHITE);
        btnRoom.setForeground(Color.BLACK);
        btnRoom.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(btnRoom);

        btnDrivers = new JButton("ADD DRIVERS");
        btnDrivers.setBounds(250, 530, 200, 30);
        btnDrivers.setBackground(Color.WHITE);
        btnDrivers.setForeground(Color.BLACK);
        btnDrivers.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(btnDrivers);

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

        ImageIcon imageEMP = new ImageIcon(ClassLoader.getSystemResource("icon/employee.png"));
        Image img_emp = imageEMP.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon ic_emp = new ImageIcon(img_emp);
        JLabel label_emp = new JLabel(ic_emp);
        label_emp.setBounds(70, 180, 120, 120);
        add(label_emp);

        ImageIcon imageRm = new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
        Image img_rm = imageRm.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon ic_rm = new ImageIcon(img_rm);
        JLabel label_room = new JLabel(ic_rm);
        label_room.setBounds(70, 340, 120, 120);
        add(label_room);

        ImageIcon imageDr = new ImageIcon(ClassLoader.getSystemResource("icon/driver.png"));
        Image img_dr = imageDr.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon ic_dr = new ImageIcon(img_dr);
        JLabel label_driver = new JLabel(ic_dr);
        label_driver.setBounds(70, 500, 120, 120);
        add(label_driver);

        ImageIcon imageLogin = new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
        Image imgLogin = imageLogin.getImage().getScaledInstance(600,650,Image.SCALE_DEFAULT);
        ImageIcon imgLogin1 = new ImageIcon(imgLogin);
        JLabel label_login = new JLabel(imgLogin1);
        label_login.setBounds(1000, 250, 600, 500);
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

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.exit(102);
                new Deshboard();
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Deshboard();
            }
        });
    }

    public static void main(String[] args) {
        new Admin();
    }
}
