package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame {
    JPanel panel;
    Choice cho;
    JButton btnUp, btnBack, btnCheck;
    JTextField txtnum, txtname, txtci, txtap, txtpa;
    Connecting con = new Connecting();
    UpdateCheck(){
        initUpdateCheck();
        actionListener();

        setLayout(null);
        setUndecorated(true);
        setLocation(400, 200);
        setSize(950, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initUpdateCheck(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 940, 490);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image img = icon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon iconImage = new ImageIcon(img);
        JLabel lbl_icon = new JLabel(iconImage);
        lbl_icon.setBounds(500, 80, 300, 300);
        panel.add(lbl_icon);

        JLabel lbl1 = new JLabel("Check-In Details");
        lbl1.setBounds(194, 10, 250,30);
        lbl1.setForeground(Color.WHITE);
        lbl1.setFont(new Font("Tahoma", Font.BOLD, 24));
        panel.add(lbl1);

        JLabel id = new JLabel("ID :");
        id.setBounds(25, 88, 150, 20);
        id.setFont(new Font("Tahoma", Font.BOLD, 16));
        id.setForeground(Color.WHITE);
        panel.add(id);
        customerId();

        JLabel num = new JLabel("Room Number :");
        num.setBounds(25, 129, 150, 14);
        num.setForeground(Color.WHITE);
        num.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(num);
        txtnum = new JTextField();
        txtnum.setBounds(248, 129, 150, 20);
        txtnum.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(txtnum);

        JLabel name = new JLabel("Name :");
        name.setBounds(25, 174, 150, 14);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(name);
        txtname = new JTextField();
        txtname.setBounds(248, 174, 150, 20);
        txtname.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(txtname);

        JLabel ci = new JLabel("Check-In :");
        ci.setBounds(25, 216, 150, 14);
        ci.setForeground(Color.WHITE);
        ci.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(ci);
        txtci = new JTextField();
        txtci.setBounds(248, 216, 150, 20);
        txtci.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(txtci);

        JLabel ap = new JLabel("Amount Paid (Rs) :");
        ap.setBounds(25, 258, 200, 14);
        ap.setForeground(Color.WHITE);
        ap.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(ap);
        txtap = new JTextField();
        txtap.setBounds(248, 258, 150, 20);
        txtap.setFont(new Font("Tahoma", Font.BOLD, 16));

        panel.add(txtap);

        JLabel pa = new JLabel("Pending Amount (Rs) :");
        pa.setBounds(25, 302, 200, 14);
        pa.setForeground(Color.WHITE);
        pa.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(pa);
        txtpa = new JTextField();
        txtpa.setBounds(248, 302, 150, 20);
        txtpa.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(txtpa);

        btnUp = new JButton("UPDATE");
        btnUp.setBounds(40, 378, 120, 30);
        btnUp.setBackground(Color.BLACK);
        btnUp.setForeground(Color.WHITE);
        btnUp.setFont(new Font("Tahoma", Font.BOLD,16));
        panel.add(btnUp);

        btnBack = new JButton("BACK");
        btnBack.setBounds(170, 378, 120, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Tahoma", Font.BOLD,16));
        panel.add(btnBack);

        btnCheck = new JButton("CHECK");
        btnCheck.setBounds(300, 378, 120, 30);
        btnCheck.setBackground(Color.BLACK);
        btnCheck.setForeground(Color.WHITE);
        btnCheck.setFont(new Font("Tahoma", Font.BOLD,16));
        panel.add(btnCheck);

    }

    public void actionListener(){
        btnUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = cho.getSelectedItem();
                String room = txtnum.getText();
                String name = txtname.getText();
                String check = txtci.getText();
                String amount = txtap.getText();

                try {
                    String qu = "UPDATE customer SET room = '" + room + "'," +
                            "name = '" + name + "', " +
                            "checkInTime = '" + check + "'," +
                            "deposite = '" + amount + "'" +
                            "WHERE number = '" + id + "'";
                    con.statement.executeUpdate(qu);

                    JOptionPane.showMessageDialog(null, "Update Successfully");
                    setVisible(false);

                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        btnCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = cho.getSelectedItem();

                try {
                    String query = "SELECT * FROM customer WHERE number = '" + id + "'";
                    ResultSet rs = con.statement.executeQuery(query);
                    while (rs.next()){
                        txtnum.setText(rs.getString("room"));
                        txtname.setText(rs.getString("name"));
                        txtci.setText(rs.getString("checkInTime"));
                        txtap.setText(rs.getString("deposite"));
                    }

                    String roomnum = txtnum.getText();
                    String ap = txtap.getText();
                    String query2 = "SELECT * FROM room WHERE roomNumber = '" + roomnum + "'";
                    ResultSet rs2 = con.statement.executeQuery(query2);
                    while (rs2.next()){
                        String pri = rs2.getString("price");

                        //int amountPaid = Integer.parseInt(pri) - Integer.getInteger(txtap.getText());
                        int pa = Integer.parseInt(pri) - Integer.parseInt(ap);
                        txtpa.setText("" + pa);
                    }

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
        cho.setBounds(248, 88, 150, 20);
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
        new UpdateCheck();
    }
}
