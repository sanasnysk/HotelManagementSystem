package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SearchRoom extends JFrame {
    JPanel panel;
    JCheckBox checkBox;
    Choice choice;
    JTable table;
    JButton btnSearch, btnBack;
    Connecting con = new Connecting();
    ResultSet rs1, rs2;

    SearchRoom() {

        initSearchRoom();
        actionListener();

        setLayout(null);
        setUndecorated(true);
        setLocation(500, 200);
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initSearchRoom() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 690, 490);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        JLabel lblSearchForm = new JLabel("Search For Room");
        lblSearchForm.setBounds(250, 11, 300, 30);
        lblSearchForm.setForeground(Color.WHITE);
        lblSearchForm.setFont(new Font("Tahoma", Font.BOLD, 24));
        panel.add(lblSearchForm);

        JLabel lblRBT = new JLabel("Room Bed Type :");
        lblRBT.setBounds(50, 73, 120, 20);
        lblRBT.setForeground(Color.WHITE);
        lblRBT.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblRBT);

        JLabel rno = new JLabel("Room Number");
        rno.setBounds(23, 120, 150, 20);
        rno.setForeground(Color.WHITE);
        rno.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(rno);

        JLabel avai = new JLabel("Availability");
        avai.setBounds(175, 120, 150, 20);
        avai.setForeground(Color.WHITE);
        avai.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(avai);

        JLabel clean = new JLabel("Clean Status");
        clean.setBounds(306, 120, 150, 20);
        clean.setForeground(Color.WHITE);
        clean.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(clean);

        JLabel pri = new JLabel("Price");
        pri.setBounds(458, 120, 150, 20);
        pri.setForeground(Color.WHITE);
        pri.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(pri);

        JLabel bt = new JLabel("Bed Type");
        bt.setBounds(580, 120, 150, 20);
        bt.setForeground(Color.WHITE);
        bt.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(bt);

        checkBox = new JCheckBox("Only Display Available");
        checkBox.setBounds(400, 69, 210, 23);
        checkBox.setBackground(new Color(3, 45, 48));
        checkBox.setForeground(Color.WHITE);
        checkBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(checkBox);

        choice = new Choice();
        choice.add("Single Bed");
        choice.add("Double Bed");
        choice.setBounds(175, 70, 120, 20);
        choice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(choice);

        table = new JTable();
        table.setBounds(0, 145, 690, 250);
        table.setBackground(new Color(3, 45, 48));
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(table);

        tableSearchRoom();

        btnSearch = new JButton("Search");
        btnSearch.setBounds(200, 400, 120, 30);
        btnSearch.setBackground(Color.BLACK);
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(btnSearch);

        btnBack = new JButton("Back");
        btnBack.setBounds(380, 400, 130, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(btnBack);
    }

    public void tableSearchRoom() {
        try {
            String q = "SELECT * FROM room";
            ResultSet rs = con.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void actionListener() {
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bed = choice.getSelectedItem();

                String q1 = "SELECT * FROM room WHERE bed_type = '" + bed + "'";
                String q2 = "SELECT * FROM room WHERE availability = 'Available' AND bed_type = '" + bed + "'";

                try {
                    rs1 = con.statement.executeQuery(q1);
                    table.setModel(DbUtils.resultSetToTableModel(rs1));

                    if (checkBox.isSelected()) {
                        rs2 = con.statement.executeQuery(q2);
                        table.setModel(DbUtils.resultSetToTableModel(rs2));
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
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
        new SearchRoom();
    }
}
