package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewAdmin extends JFrame {
    JPanel panel;
    JTextField txtadm;
    JPasswordField pass, re;
    JButton btnAdd, btnCancel;
    Connecting con = new Connecting();

    NewAdmin() {
        initSignUp();
        actionListener();

        setLayout(null);
        setUndecorated(true);
        setLocation(60, 200);
        setSize(850, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initSignUp() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 840, 490);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        JLabel lblAdmin = new JLabel("New  Admin");
        lblAdmin.setBounds(194, 10, 250, 30);
        lblAdmin.setForeground(Color.WHITE);
        lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 28));
        panel.add(lblAdmin);

        JLabel lblNa = new JLabel("Name");
        lblNa.setBounds(64, 150, 150, 25);
        lblNa.setForeground(Color.WHITE);
        lblNa.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(lblNa);

        txtadm = new JTextField();
        txtadm.setBounds(200, 150, 150, 25);
        txtadm.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtadm.setForeground(Color.WHITE);
        txtadm.setBackground(new Color(16, 108, 115));
        panel.add(txtadm);

        JLabel lblPas = new JLabel("Password");
        lblPas.setBounds(64, 190, 150, 25);
        lblPas.setForeground(Color.WHITE);
        lblPas.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(lblPas);

        pass = new JPasswordField();
        pass.setBounds(200, 190, 150, 25);
        pass.setFont(new Font("Tahoma", Font.PLAIN, 16));
        pass.setForeground(Color.WHITE);
        pass.setBackground(new Color(16, 108, 115));
        panel.add(pass);

        JLabel lblRe = new JLabel("Repassword");
        lblRe.setBounds(64, 230, 150, 25);
        lblRe.setForeground(Color.WHITE);
        lblRe.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(lblRe);

        re = new JPasswordField();
        re.setBounds(200, 230, 150, 25);
        re.setFont(new Font("Tahoma", Font.PLAIN, 16));
        re.setForeground(Color.WHITE);
        re.setBackground(new Color(16, 108, 115));
        panel.add(re);

        btnAdd = new JButton("Submit");
        btnAdd.setBounds(64, 320, 130, 30);
        btnAdd.setBackground(Color.BLACK);
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(btnAdd);

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(210, 320, 130, 30);
        btnCancel.setBackground(Color.BLACK);
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(btnCancel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
        Image img = imageIcon.getImage().getScaledInstance(340, 250, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img);
        JLabel label_login = new JLabel(img2);
        label_login.setBounds(420, 150, 340, 200);
        panel.add(label_login);
    }

    public void actionListener() {
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String adm = txtadm.getText();
                String pas = new String(pass.getPassword());
                String rep = new String(re.getPassword());

                if (adm.equals("")){
                    JOptionPane.showMessageDialog(null, "Name Invalid");
                    return;
                }

                if (pas.equals("")){
                    JOptionPane.showMessageDialog(null, "Password Invalid");
                    return;
                }

                if (!pas.equals(rep)) {
                    JOptionPane.showMessageDialog(null, "Password Invalid");
                    return;
                } else {
                    try {
                        String query = "INSERT INTO admin VALUES('" + adm + "', '" + pas + "')";
                        con.statement.executeUpdate(query);

                        JOptionPane.showMessageDialog(null, "Add Admin Successfully");

                        dispose();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        new NewAdmin();
    }
}
