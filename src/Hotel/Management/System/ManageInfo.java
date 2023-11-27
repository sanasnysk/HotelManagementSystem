package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ManageInfo extends JFrame {
    JPanel panel;
    JTable tblEmp;
    JButton btnBack;
    Connecting con = new Connecting();
    ManageInfo(){

        initEmployee();
        actionListener();

        setLayout(null);
        setUndecorated(true);
        setLocation(430, 100);
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initEmployee(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 990, 590);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        tableEmployee();

        btnBack = new JButton("Back");
        btnBack.setBounds(350, 500, 120, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Tahoma", Font.BOLD,16));
        panel.add(btnBack);

        JLabel name = new JLabel("NAME");
        name.setBounds(41, 11, 70, 19);
        name.setFont(new Font("Tahoma", Font.BOLD, 16));
        name.setForeground(Color.WHITE);
        panel.add(name);

        JLabel age = new JLabel("AGE");
        age.setBounds(170, 11, 50, 19);
        age.setFont(new Font("Tahoma", Font.BOLD, 16));
        age.setForeground(Color.WHITE);
        panel.add(age);

        JLabel gender = new JLabel("GENDER");
        gender.setBounds(280, 11, 150, 19);
        gender.setFont(new Font("Tahoma", Font.BOLD, 16));
        gender.setForeground(Color.WHITE);
        panel.add(gender);

        JLabel job = new JLabel("JOB");
        job.setBounds(420, 11, 150, 19);
        job.setFont(new Font("Tahoma", Font.BOLD, 16));
        job.setForeground(Color.WHITE);
        panel.add(job);

        JLabel salary = new JLabel("SALARY");
        salary.setBounds(530, 11, 150, 19);
        salary.setFont(new Font("Tahoma", Font.BOLD, 16));
        salary.setForeground(Color.WHITE);
        panel.add(salary);

        JLabel phone = new JLabel("PHONE");
        phone.setBounds(650, 11, 150, 19);
        phone.setFont(new Font("Tahoma", Font.BOLD, 16));
        phone.setForeground(Color.WHITE);
        panel.add(phone);

        JLabel email = new JLabel("EMAIL");
        email.setBounds(770, 11, 150, 19);
        email.setFont(new Font("Tahoma", Font.BOLD, 16));
        email.setForeground(Color.WHITE);
        panel.add(email);

        JLabel aadhar = new JLabel("AADHAR");
        aadhar.setBounds(890, 11, 150, 19);
        aadhar.setFont(new Font("Tahoma", Font.BOLD, 16));
        aadhar.setForeground(Color.WHITE);
        panel.add(aadhar);

    }

    public void actionListener(){
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    public void tableEmployee(){
        tblEmp = new JTable();
        tblEmp.setBounds(10, 34, 980, 450);
        tblEmp.setBackground(new Color(3, 45, 48));
        tblEmp.setForeground(Color.WHITE);
        tblEmp.setFont(new Font("Tahoma", Font.PLAIN,16));
        panel.add(tblEmp);

        try {
            String q = "SELECT * FROM employee WHERE job = 'Manager'";
            ResultSet rs = con.statement.executeQuery(q);
            tblEmp.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new ManageInfo();
    }
}
