package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckOut extends JFrame {
    JPanel panel;
    Choice cho;
    String date;
    JLabel lrno, lcit, lcot;
    JButton btnOut, btnBack, btnCheck;
    Connecting con = new Connecting();
    CheckOut(){

        initCheckOut();
        actionListener();

        setLayout(null);
        //setUndecorated(true);
        setLocation(500, 200);
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initCheckOut(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 790, 390);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        JLabel lbl1 = new JLabel("Check-Out");
        lbl1.setBounds(100, 20, 150,30);
        lbl1.setForeground(Color.WHITE);
        lbl1.setFont(new Font("Tahoma", Font.BOLD, 24));
        panel.add(lbl1);

        JLabel uid = new JLabel("Customer Id");
        uid.setBounds(30, 80, 200,20);
        uid.setForeground(Color.WHITE);
        uid.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(uid);

        customerId();

        JLabel rno = new JLabel("Room Number");
        rno.setBounds(30, 130, 200,20);
        rno.setForeground(Color.WHITE);
        rno.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(rno);

        lrno = new JLabel();
        lrno.setBounds(250, 130, 200,20);
        lrno.setForeground(Color.WHITE);
        lrno.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(lrno);

        JLabel cit = new JLabel("Check-In Time");
        cit.setBounds(30, 180, 200,20);
        cit.setForeground(Color.WHITE);
        cit.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(cit);

        lcit = new JLabel();
        lcit.setBounds(250, 180, 200,20);
        lcit.setForeground(Color.WHITE);
        lcit.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(lcit);

        JLabel cot = new JLabel("Check-Out Time");
        cot.setBounds(30, 230, 200,20);
        cot.setForeground(Color.WHITE);
        cot.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(cot);

        // 날짜
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        date = dtf.format(now);

        lcot = new JLabel("" + date);
        lcot.setBounds(250, 230, 200,20);
        lcot.setForeground(Color.WHITE);
        lcot.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(lcot);

        btnOut = new JButton("Check-Out");
        btnOut.setBounds(30, 300, 120, 20);
        btnOut.setBackground(Color.BLACK);
        btnOut.setForeground(Color.WHITE);
        btnOut.setFont(new Font("Tahoma", Font.BOLD,16));
        panel.add(btnOut);

        btnBack = new JButton("BACK");
        btnBack.setBounds(170, 300, 120, 20);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Tahoma", Font.BOLD,16));
        panel.add(btnBack);

        btnCheck = new JButton("CHECK");
        btnCheck.setBounds(300, 300, 120, 20);
        btnCheck.setBackground(Color.BLACK);
        btnCheck.setForeground(Color.WHITE);
        btnCheck.setFont(new Font("Tahoma", Font.BOLD,16));
        panel.add(btnCheck);

    }

    public void actionListener(){
        btnCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = cho.getSelectedItem();

                try {
                    String query = "SELECT * FROM customer WHERE number = '" + id + "'";
                    ResultSet rs = con.statement.executeQuery(query);
                    while (rs.next()){
                        lrno.setText(rs.getString("room"));
                        lcit.setText(rs.getString("checkInTime"));
                    }

                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        btnOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = cho.getSelectedItem();
                String rno = lrno.getText();
                try {
                    String query2 = "DELETE FROM customer WHERE number = '" + id + "'";
                    con.statement.executeUpdate(query2);

                    String query3 = "UPDATE room SET availability = 'Available' WHERE roomNumber = '" + rno + "'";

                    JOptionPane.showMessageDialog(null, "Delete Customer Updated Room Successfully");
                    setVisible(false);

                }catch (Exception ex){
                    ex.printStackTrace();
                }


            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //setVisible(false);
                dispose();
            }
        });
    }

    public void customerId(){
        cho = new Choice();
        cho.setBounds(250, 80, 200, 20);
        cho.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(cho);

        try {
            String q = "SELECT * FROM customer";
            ResultSet rs = con.statement.executeQuery(q);
            while (rs.next()){
                cho.add(rs.getString("number"));
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new CheckOut();
    }
}
