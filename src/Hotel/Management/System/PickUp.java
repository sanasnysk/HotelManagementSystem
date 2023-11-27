package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PickUp extends JFrame {

    JPanel panel;
    Choice cho;
    JTable table;
    JButton display, btnBack;
    Connecting con = new Connecting();
    PickUp(){

        initPickUp();
        actionListener();

        setLayout(null);
        setUndecorated(true);
        setLocation(500, 100);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initPickUp(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 790, 590);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        JLabel pus = new JLabel("Pick up Service");
        pus.setBounds(90, 11, 300, 30);
        pus.setForeground(Color.WHITE);
        pus.setFont(new Font("Tahoma", Font.BOLD, 28));
        panel.add(pus);

        JLabel toc = new JLabel("Type of Car");
        toc.setBounds(32, 97, 160, 30);
        toc.setForeground(Color.WHITE);
        toc.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(toc);

        cho = new Choice();
        cho.setBounds(210, 96, 150, 20);
        cho.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(cho);

        carName();

        tablePickUp();

        JLabel name = new JLabel("Name");
        name.setBounds(5, 150, 108, 20);
        name.setBorder(new LineBorder(Color.WHITE));
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(name);

        JLabel age = new JLabel("Age");
        age.setBounds(113, 150, 112, 20);
        age.setBorder(new LineBorder(Color.WHITE));
        age.setHorizontalAlignment(SwingConstants.CENTER);
        age.setForeground(Color.WHITE);
        age.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(age);

        JLabel gend = new JLabel("Gender");
        gend.setBounds(225, 150, 112, 20);
        gend.setBorder(new LineBorder(Color.WHITE));
        gend.setHorizontalAlignment(SwingConstants.CENTER);
        gend.setForeground(Color.WHITE);
        gend.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(gend);

        JLabel cp = new JLabel("Company");
        cp.setBounds(337, 150, 112, 20);
        cp.setBorder(new LineBorder(Color.WHITE));
        cp.setHorizontalAlignment(SwingConstants.CENTER);
        cp.setForeground(Color.WHITE);
        cp.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(cp);

        JLabel cn = new JLabel("Car Name");
        cn.setBounds(449, 150, 112, 20);
        cn.setBorder(new LineBorder(Color.WHITE));
        cn.setHorizontalAlignment(SwingConstants.CENTER);
        cn.setForeground(Color.WHITE);
        cn.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(cn);

        JLabel avai = new JLabel("Available");
        avai.setBounds(561, 150, 112, 20);
        avai.setBorder(new LineBorder(Color.WHITE));
        avai.setForeground(Color.WHITE);
        avai.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(avai);

        JLabel loca = new JLabel("Location");
        loca.setBounds(673, 150, 112, 20);
        loca.setBorder(new LineBorder(Color.WHITE));
        loca.setHorizontalAlignment(SwingConstants.CENTER);
        loca.setForeground(Color.WHITE);
        loca.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(loca);

        JPanel line = new JPanel();
        line.setBounds(0, 172, 790, 1);
        line.setForeground(Color.WHITE);
        panel.add(line);

        display = new JButton("Display");
        display.setBounds(200, 500, 120, 30);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        display.setFont(new Font("Tahoma", Font.BOLD,16));
        panel.add(display);

        btnBack = new JButton("Back");
        btnBack.setBounds(350, 500, 120, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Tahoma", Font.BOLD,16));
        panel.add(btnBack);
    }

    public void actionListener(){
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String car = cho.getSelectedItem();
                String q = "SELECT * FROM driver WHERE carname = '" + car + "'";
                try {
                    ResultSet rs = con.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //setVisible(true);
                dispose();
            }
        });

    }

    public void carName(){
        try {
            String car = "SELECT * FROM driver";
            ResultSet rs = con.statement.executeQuery(car);
            while (rs.next()){
                cho.add(rs.getString("carname"));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void tablePickUp(){
        table = new JTable();
        table.setBounds(5, 180, 780, 250);
        table.setBackground(new Color(3, 45, 48));
        table.setBorder(new LineBorder(Color.WHITE));
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(table);

        try {
            String q = "SELECT * FROM driver";
            ResultSet rs = con.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new PickUp();
    }
}
