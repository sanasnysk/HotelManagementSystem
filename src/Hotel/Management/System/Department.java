package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {

    JPanel panel;
    JButton btnBack;
    JTable tblDepart;
    Connecting con = new Connecting();
    Department(){

        initDepartment();
        actionListener();

        setLayout(null);
        setUndecorated(true);
        setLocation(550, 150);
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public  void initDepartment(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 690, 490);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        tableDepartment();

        btnBack = new JButton("Back");
        btnBack.setBounds(400, 410, 120, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Tahoma", Font.BOLD,16));
        panel.add(btnBack);

        JLabel depar = new JLabel("Department");
        depar.setBounds(145, 15, 100, 20);
        depar.setForeground(Color.WHITE);
        depar.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(depar);

        JLabel budget = new JLabel("Budget");
        budget.setBounds(431, 15, 100, 20);
        budget.setForeground(Color.WHITE);
        budget.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(budget);

    }

    public void actionListener(){
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    public void tableDepartment(){
        tblDepart = new JTable();
        tblDepart.setBounds(0, 40, 700, 350);
        tblDepart.setBackground(new Color(3, 45, 48));
        tblDepart.setForeground(Color.WHITE);
        tblDepart.setFont(new Font("Tahoma", Font.PLAIN,16));
        panel.add(tblDepart);

        try {
            String roomInfo = "SELECT * FROM department";
            ResultSet rs = con.statement.executeQuery(roomInfo);
            tblDepart.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Department();
    }
}
