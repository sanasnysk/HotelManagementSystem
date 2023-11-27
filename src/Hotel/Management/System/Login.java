package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class Login extends JFrame {

    JTextField txtUser;
    JPasswordField pass;
    JButton btnSigin, btnCancel;
    Connecting con = new Connecting();
    Login(){

       initLogin();
       actionListener();

        getContentPane().setBackground(new Color(10, 25, 37));
        setLayout(null);
        setLocation(400, 270);
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initLogin(){
        JLabel label1 = new JLabel("User Name");
        label1.setBounds(40, 20, 100, 30);
        label1.setFont(new Font("Tahoma", Font.BOLD, 16));
        label1.setForeground(Color.WHITE);
        add(label1);

        txtUser = new JTextField();
        txtUser.setBounds(150, 20, 150, 30);
        txtUser.setForeground(Color.WHITE);
        txtUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtUser.setBackground(new Color(26, 104, 110));
        add(txtUser);

        JLabel label2 = new JLabel("Password");
        label2.setBounds(40, 70, 100, 30);
        label2.setFont(new Font("Tahoma", Font.BOLD, 16));
        label2.setForeground(Color.WHITE);
        add(label2);

        pass = new JPasswordField();
        pass.setBounds(150, 70, 150, 30);
        pass.setForeground(Color.WHITE);
        pass.setFont(new Font("Tahoma", Font.PLAIN, 16));
        pass.setBackground(new Color(26, 104, 110));
        add(pass);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
        Image img = imageIcon.getImage().getScaledInstance(240,200,Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img);
        JLabel label_login = new JLabel(img2);
        label_login.setBounds(320, 30, 260, 180);
        add(label_login);

        btnSigin = new JButton("LOGIN");
        btnSigin.setBounds(40, 140, 120, 30);
        btnSigin.setForeground(Color.WHITE);
        btnSigin.setFont(new Font("serif", Font.BOLD, 16));
        btnSigin.setBackground(Color.BLACK);
        add(btnSigin);

        btnCancel = new JButton("CANCEL");
        btnCancel.setBounds(180, 140, 120, 30);
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setFont(new Font("serif", Font.BOLD, 16));
        btnCancel.setBackground(Color.BLACK);
        add(btnCancel);
    }

    public void actionListener(){
        btnSigin.addActionListener(e -> setLogin());

        btnCancel.addActionListener(e -> System.exit(101));
    }

    public void setLogin(){
        try {
            String user = txtUser.getText();
            String pas = new String(pass.getPassword());
            String q = "SELECT * FROM login WHERE username = '" + user + "' AND password = '" + pas + "'";
            ResultSet rs =  con.statement.executeQuery(q);
            if (rs.next()){
                setVisible(false);
                new Deshboard();
            }else {
                JOptionPane.showMessageDialog(null, "Invalid");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
