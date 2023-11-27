package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame {
    JPanel panel;
    Choice cho;
    JButton btnUp, btnBack, btnCheck;
    JTextField txtnum, txtavai, txtcs;
    Connecting con = new Connecting();
    UpdateRoom(){
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

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
        Image img = icon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon iconImage = new ImageIcon(img);
        JLabel lbl_icon = new JLabel(iconImage);
        lbl_icon.setBounds(500, 80, 300, 300);
        panel.add(lbl_icon);

        JLabel lbl1 = new JLabel("Update Room Status");
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

        JLabel avai = new JLabel("Availability :");
        avai.setBounds(25, 174, 150, 14);
        avai.setForeground(Color.WHITE);
        avai.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(avai);
        txtavai = new JTextField();
        txtavai.setBounds(248, 174, 150, 20);
        txtavai.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(txtavai);

        JLabel cs = new JLabel("Clean Status :");
        cs.setBounds(25, 216, 150, 14);
        cs.setForeground(Color.WHITE);
        cs.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(cs);
        txtcs = new JTextField();
        txtcs.setBounds(248, 216, 150, 20);
        txtcs.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(txtcs);

        btnUp = new JButton("UPDATE");
        btnUp.setBounds(120, 315, 120, 30);
        btnUp.setBackground(Color.BLACK);
        btnUp.setForeground(Color.WHITE);
        btnUp.setFont(new Font("Tahoma", Font.BOLD,16));
        panel.add(btnUp);

        btnBack = new JButton("BACK");
        btnBack.setBounds(190, 355, 120, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Tahoma", Font.BOLD,16));
        panel.add(btnBack);

        btnCheck = new JButton("CHECK");
        btnCheck.setBounds(60, 355, 120, 30);
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
                String num = txtnum.getText();
                String avai = txtavai.getText();
                String clean = txtcs.getText();

                try {
                    String qu = "UPDATE room SET cleaning_status = '" + clean + "' WHERE roomNumber = '" + num + "'";
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

                    }

                    String rn = txtnum.getText();
                    String query2 = "SELECT * FROM room WHERE roomNumber = '" + rn + "'";
                    ResultSet rs2 = con.statement.executeQuery(query2);
                    while (rs2.next()){
                        txtavai.setText(rs2.getString("availability"));
                        txtcs.setText(rs2.getString("cleaning_status"));
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
        new UpdateRoom();
    }
}
