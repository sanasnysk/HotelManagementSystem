package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {

    JPanel imagePanel, boardPanel;
    JLabel lblUser;
    public static JLabel users;
    String user;
    JButton btnNCF, btnRoom, btnDepartment, btnAEI, btnCI, btnMI, btnCO, btnUCID, btnURS, btnPUS, btnSR, btnLogOut, btnBack;
    Reception(){

        initReception();
        actionListener();

        users = lblUser;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocation(0, 0);
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initReception(){
        imagePanel = new JPanel();
        imagePanel.setLayout(null);
        imagePanel.setBounds(305, 5, 1615, 980);
        imagePanel.setBackground(new Color(15, 31, 45));
        add(imagePanel);

        boardPanel = new JPanel();
        boardPanel.setLayout(null);
        boardPanel.setBounds(5, 5, 295, 980);
        boardPanel.setBackground(new Color(10, 25, 37));
        add(boardPanel);

        ImageIcon imageReception = new ImageIcon(ClassLoader.getSystemResource("icon/ccc.gif"));
        Image imgReception = imageReception.getImage().getScaledInstance(750,450,Image.SCALE_DEFAULT);
        ImageIcon imgBoard = new ImageIcon(imgReception);
        JLabel label_reception = new JLabel(imgBoard);
        label_reception.setBounds(450, 250, 750, 450);
        imagePanel.add(label_reception);

        ImageIcon imageLogin = new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
        Image imgLogin = imageLogin.getImage().getScaledInstance(240,200,Image.SCALE_DEFAULT);
        ImageIcon imgLogin1 = new ImageIcon(imgLogin);
        JLabel label_login = new JLabel(imgLogin1);
        label_login.setBounds(15, 700, 260, 180);
        boardPanel.add(label_login);

        btnNCF = new JButton("New Customer Form");
        btnNCF.setBounds(25, 30, 250, 30);
        btnNCF.setBackground(Color.BLACK);
        btnNCF.setForeground(Color.WHITE);
        btnNCF.setFont(new Font("Tahoma", Font.BOLD, 16));
        boardPanel.add(btnNCF);

        btnRoom = new JButton("Room");
        btnRoom.setBounds(25, 70, 250, 30);
        btnRoom.setBackground(Color.BLACK);
        btnRoom.setForeground(Color.WHITE);
        btnRoom.setFont(new Font("Tahoma", Font.BOLD, 16));
        boardPanel.add(btnRoom);

        btnDepartment = new JButton("Department");
        btnDepartment.setBounds(25, 110, 250, 30);
        btnDepartment.setBackground(Color.BLACK);
        btnDepartment.setForeground(Color.WHITE);
        btnDepartment.setFont(new Font("Tahoma", Font.BOLD, 16));
        boardPanel.add(btnDepartment);

        btnAEI = new JButton("All Enployee Info");
        btnAEI.setBounds(25, 150, 250, 30);
        btnAEI.setBackground(Color.BLACK);
        btnAEI.setForeground(Color.WHITE);
        btnAEI.setFont(new Font("Tahoma", Font.BOLD, 16));
        boardPanel.add(btnAEI);

        btnCI = new JButton("Customer Info");
        btnCI.setBounds(25, 190, 250, 30);
        btnCI.setBackground(Color.BLACK);
        btnCI.setForeground(Color.WHITE);
        btnCI.setFont(new Font("Tahoma", Font.BOLD, 16));
        boardPanel.add(btnCI);

        btnMI = new JButton("Manager Info");
        btnMI.setBounds(25, 230, 250, 30);
        btnMI.setBackground(Color.BLACK);
        btnMI.setForeground(Color.WHITE);
        btnMI.setFont(new Font("Tahoma", Font.BOLD, 16));
        boardPanel.add(btnMI);

        btnCO = new JButton("Check Out");
        btnCO.setBounds(25, 270, 250, 30);
        btnCO.setBackground(Color.BLACK);
        btnCO.setForeground(Color.WHITE);
        btnCO.setFont(new Font("Tahoma", Font.BOLD, 16));
        boardPanel.add(btnCO);

        btnUCID = new JButton("Update Check-In Details");
        btnUCID.setBounds(25, 310, 250, 30);
        btnUCID.setBackground(Color.BLACK);
        btnUCID.setForeground(Color.WHITE);
        btnUCID.setFont(new Font("Tahoma", Font.BOLD, 16));
        boardPanel.add(btnUCID);

        btnURS = new JButton("Update Room Status");
        btnURS.setBounds(25, 350, 250, 30);
        btnURS.setBackground(Color.BLACK);
        btnURS.setForeground(Color.WHITE);
        btnURS.setFont(new Font("Tahoma", Font.BOLD, 16));
        boardPanel.add(btnURS);

        btnPUS = new JButton("Pick up Service");
        btnPUS.setBounds(25, 390, 250, 30);
        btnPUS.setBackground(Color.BLACK);
        btnPUS.setForeground(Color.WHITE);
        btnPUS.setFont(new Font("Tahoma", Font.BOLD, 16));
        boardPanel.add(btnPUS);

        btnSR = new JButton("Search Room");
        btnSR.setBounds(25, 430, 250, 30);
        btnSR.setBackground(Color.BLACK);
        btnSR.setForeground(Color.WHITE);
        btnSR.setFont(new Font("Tahoma", Font.BOLD, 16));
        boardPanel.add(btnSR);

        btnLogOut = new JButton("Logout");
        btnLogOut.setBounds(25, 470, 120, 30);
        btnLogOut.setBackground(Color.BLACK);
        btnLogOut.setForeground(Color.WHITE);
        btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 16));
        boardPanel.add(btnLogOut);

        btnBack = new JButton("Back");
        btnBack.setBounds(155, 470, 120, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
        boardPanel.add(btnBack);

        lblUser = new JLabel("User");
        lblUser.setBounds(25,560, 250, 30);
        lblUser.setForeground(new Color(3, 255, 25));
        lblUser.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblUser.setHorizontalAlignment(SwingConstants.CENTER);
        boardPanel.add(lblUser);

    }

    public void actionListener(){
        btnNCF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewCustomer();
            }
        });

        btnRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Room();
            }
        });

        btnDepartment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Department();
            }
        });

        btnAEI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Employee();
            }
        });

        btnCI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CustomerInfo();
            }
        });

        btnMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManageInfo();
            }
        });

        btnCO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CheckOut();
            }
        });

        btnUCID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateCheck();
            }
        });

        btnURS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateRoom();
            }
        });

        btnPUS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PickUp();
            }
        });

        btnSR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchRoom();
            }
        });

        btnLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(101);
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user = lblUser.getText();
                setVisible(false);
                new Deshboard();
                Deshboard.users.setText(user);
            }
        });

    }

    public static void main(String[] args) {
        new Reception();
    }
}
