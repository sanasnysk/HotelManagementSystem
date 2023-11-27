package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver extends JFrame {

    JTextField txtName, txtAge, txtCarC, txtCarN, txtLoca;
    JComboBox cbGend, cbAva;
    JButton btnAdd, btnBack;
    Connecting con = new Connecting();
    AddDriver(){

        initAddDriver();
        actionListener();

        setLayout(null);
        setUndecorated(true);
        setLocation(60, 200);
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initAddDriver(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 890, 490);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        JLabel lblDriver = new JLabel("Add Driver");
        lblDriver.setBounds(194, 10, 250,30);
        lblDriver.setForeground(Color.WHITE);
        lblDriver.setFont(new Font("Tahoma", Font.BOLD, 24));
        panel.add(lblDriver);

        JLabel name = new JLabel("NAME");
        name.setBounds(64, 70, 150, 30);
        name.setFont(new Font("Tahoma", Font.BOLD, 16));
        name.setForeground(Color.WHITE);
        panel.add(name);
        txtName = new JTextField();
        txtName.setBounds(200, 70, 200, 30);
        txtName.setFont(new Font("Tahoma", Font.BOLD, 16));
        txtName.setForeground(Color.WHITE);
        txtName.setBackground(new Color(16, 108, 115));
        panel.add(txtName);

        JLabel age = new JLabel("AGE");
        age.setBounds(64, 110, 150, 30);
        age.setFont(new Font("Tahoma", Font.BOLD, 16));
        age.setForeground(Color.WHITE);
        panel.add(age);
        txtAge = new JTextField();
        txtAge.setBounds(200, 110, 200, 30);
        txtAge.setFont(new Font("Tahoma", Font.BOLD, 16));
        txtAge.setForeground(Color.WHITE);
        txtAge.setBackground(new Color(16, 108, 115));
        panel.add(txtAge);

        JLabel gender = new JLabel("GENDER");
        gender.setBounds(64, 150, 150, 30);
        gender.setFont(new Font("Tahoma", Font.BOLD, 16));
        gender.setForeground(Color.WHITE);
        panel.add(gender);
        cbGend = new JComboBox(new String[]{"Male", "Female"});
        cbGend.setBounds(200, 150, 200, 30);
        cbGend.setFont(new Font("Tahoma", Font.BOLD, 16));
        cbGend.setForeground(Color.WHITE);
        cbGend.setBackground(new Color(16, 108, 115));
        panel.add(cbGend);

        JLabel carC = new JLabel("CAR COMPANY");
        carC.setBounds(64, 190, 150, 30);
        carC.setFont(new Font("Tahoma", Font.BOLD, 16));
        carC.setForeground(Color.WHITE);
        panel.add(carC);
        txtCarC = new JTextField();
        txtCarC.setBounds(200, 190, 200, 30);
        txtCarC.setFont(new Font("Tahoma", Font.BOLD, 16));
        txtCarC.setForeground(Color.WHITE);
        txtCarC.setBackground(new Color(16, 108, 115));
        panel.add(txtCarC);

        JLabel carN = new JLabel("CAR NAME");
        carN.setBounds(64, 230, 150, 30);
        carN.setFont(new Font("Tahoma", Font.BOLD, 16));
        carN.setForeground(Color.WHITE);
        panel.add(carN);
        txtCarN = new JTextField();
        txtCarN.setBounds(200, 230, 200, 30);
        txtCarN.setFont(new Font("Tahoma", Font.BOLD, 16));
        txtCarN.setForeground(Color.WHITE);
        txtCarN.setBackground(new Color(16, 108, 115));
        panel.add(txtCarN);

        JLabel available = new JLabel("AVAILABLE");
        available.setBounds(64, 270, 150, 30);
        available.setFont(new Font("Tahoma", Font.BOLD, 16));
        available.setForeground(Color.WHITE);
        panel.add(available);
        cbAva = new JComboBox(new String[]{"YES", "NO"});
        cbAva.setBounds(200, 270, 200, 30);
        cbAva.setFont(new Font("Tahoma", Font.BOLD, 16));
        cbAva.setForeground(Color.WHITE);
        cbAva.setBackground(new Color(16, 108, 115));
        panel.add(cbAva);

        JLabel loca = new JLabel("LOCATION");
        loca.setBounds(64, 310, 150, 30);
        loca.setFont(new Font("Tahoma", Font.BOLD, 16));
        loca.setForeground(Color.WHITE);
        panel.add(loca);
        txtLoca = new JTextField();
        txtLoca.setBounds(200, 310, 200, 30);
        txtLoca.setFont(new Font("Tahoma", Font.BOLD, 16));
        txtLoca.setForeground(Color.WHITE);
        txtLoca.setBackground(new Color(16, 108, 115));
        panel.add(txtLoca);

        btnBack = new JButton("BACK");
        btnBack.setBounds(150, 370, 100, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Tahoma", Font.BOLD,16));
        panel.add(btnBack);

        btnAdd = new JButton("SUBMIT");
        btnAdd.setBounds(280, 370, 100, 30);
        btnAdd.setBackground(Color.BLACK);
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFont(new Font("Tahoma", Font.BOLD,16));
        panel.add(btnAdd);

        ImageIcon imageDriver = new ImageIcon(ClassLoader.getSystemResource("icon/license.png"));
        Image imgdriver = imageDriver.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imgdri = new ImageIcon(imgdriver);
        JLabel label_driver = new JLabel(imgdri);
        label_driver.setBounds(500, 80, 300, 300);
        panel.add(label_driver);

    }

    public void actionListener(){
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtName.getText().equals("")){
                    String name = txtName.getText();
                    String age = txtAge.getText();
                    String gender = (String) cbGend.getSelectedItem();
                    String company = txtCarC.getText();
                    String car = txtCarN.getText();
                    String available = (String) cbAva.getSelectedItem();
                    String location = txtLoca.getText();

                    try {
                        String q = "INSERT INTO driver VALUES('" + name + "', '" + age + "', '" + gender + "', '" + company + "', '" + car + "', '" + available + "', '" + location + "')";
                        con.statement.executeUpdate(q);
                        JOptionPane.showMessageDialog(null, "Driver Successfully Added");

                        setVisible(false);

                    }catch (Exception ex){
                        ex.printStackTrace();
                    }

                }else {
                    JOptionPane.showMessageDialog(null, "There is no input.");
                }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        new AddDriver();
    }
}
