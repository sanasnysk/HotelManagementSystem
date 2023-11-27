package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInfo extends JFrame {

    JPanel panel;
    JButton btnBack;
    JTable table;
    Connecting con = new Connecting();
    CustomerInfo(){

        initCustomerInfo();
        actionListener();

        setLayout(null);
        setUndecorated(true);
        setLocation(500, 100);
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initCustomerInfo(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        JLabel id = new JLabel("ID");
        id.setBounds(31, 11, 46, 14);
        id.setForeground(Color.WHITE);
        id.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(id);

        JLabel num = new JLabel("Number");
        num.setBounds(150, 11, 80, 14);
        num.setForeground(Color.WHITE);
        num.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(num);

        JLabel name = new JLabel("Name");
        name.setBounds(270, 11, 80, 14);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(name);

        JLabel gen = new JLabel("Gender");
        gen.setBounds(360, 11, 80, 14);
        gen.setForeground(Color.WHITE);
        gen.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(gen);

        JLabel coun = new JLabel("Country");
        coun.setBounds(480, 11, 80, 14);
        coun.setForeground(Color.WHITE);
        coun.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(coun);

        JLabel room = new JLabel("Room");
        room.setBounds(600, 11, 80, 14);
        room.setForeground(Color.WHITE);
        room.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(room);

        JLabel time = new JLabel("CI Time");
        time.setBounds(695, 11, 80, 14);
        time.setForeground(Color.WHITE);
        time.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(time);

        JLabel dpo = new JLabel("Deposite");
        dpo.setBounds(800, 11, 80, 14);
        dpo.setForeground(Color.WHITE);
        dpo.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(dpo);

        tableCustomerInfo();

        btnBack = new JButton("Back");
        btnBack.setBounds(350, 500, 120, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Tahoma", Font.BOLD,16));
        panel.add(btnBack);
    }

    public void actionListener(){
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    public void tableCustomerInfo(){
        table = new JTable();
        table.setBounds(10, 40, 890, 450);
        table.setBackground(new Color(3, 45, 48));
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Tahoma", Font.PLAIN,16));
        panel.add(table);

        try {
            String q = "SELECT * FROM customer";
            ResultSet rs = con.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new CustomerInfo();
    }
}
