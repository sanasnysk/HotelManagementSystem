package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NewCustomer extends JFrame {
    JPanel panel;
    JComboBox cbIdCard;
    JTextField txtNumber, txtName, txtCountry, txtDeposite;
    JRadioButton rbM, rbF;
    Choice choiNo;
    JLabel lblDate;
    String date;
    JButton btnAdd, btnBack;
    Connecting con = new Connecting();
    NewCustomer(){

        initNewCustomer();
        actionListener();

        setLayout(null);
        setUndecorated(true);
        setLocation(60, 200);
        setSize(850, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void initNewCustomer(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/customer.png"));
        Image img = imageIcon.getImage().getScaledInstance(256,256,Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(img);
        JLabel label_customer = new JLabel(icon);
        label_customer.setBounds(550, 150, 256, 256);
        panel.add(label_customer);

        JLabel lblForm = new JLabel("NEW CUSTOMER FORM");
        lblForm.setBounds(118, 11, 300,53);
        lblForm.setForeground(Color.WHITE);
        lblForm.setFont(new Font("Tahoma", Font.BOLD, 24));
        panel.add(lblForm);

        JLabel lblID = new JLabel("ID :");
        lblID.setBounds(35, 76, 150,20);
        lblID.setForeground(Color.WHITE);
        lblID.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(lblID);
        String[] item = new String[] {"Passport", "Aadhar Card", "Voter Id", "Driving License"};
        cbIdCard = new JComboBox(item);
        cbIdCard.setBounds(285, 76, 150, 20);
        cbIdCard.setBackground(new Color(3,45,48));
        cbIdCard.setForeground(Color.WHITE);
        cbIdCard.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(cbIdCard);

        JLabel lblNo = new JLabel("Number :");
        lblNo.setBounds(35, 111, 150,20);
        lblNo.setForeground(Color.WHITE);
        lblNo.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(lblNo);
        txtNumber = new JTextField();
        txtNumber.setBounds(285, 111, 150, 20);
        txtNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(txtNumber);

        JLabel lblName = new JLabel("Name :");
        lblName.setBounds(35, 151, 150,20);
        lblName.setForeground(Color.WHITE);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(lblName);
        txtName = new JTextField();
        txtName.setBounds(285, 151, 150, 20);
        txtName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(txtName);

        JLabel gender = new JLabel("GENDER");
        gender.setBounds(35, 191, 150, 30);
        gender.setFont(new Font("Tahoma", Font.BOLD, 16));
        gender.setForeground(Color.WHITE);
        panel.add(gender);
        rbM = new JRadioButton("MALE");
        rbM.setBounds(280, 191, 70, 16);
        rbM.setFont(new Font("Tahoma", Font.BOLD, 16));
        rbM.setForeground(Color.WHITE);
        rbM.setBackground(new Color(10, 25, 37));
        panel.add(rbM);
        rbF = new JRadioButton("FEMALE");
        rbF.setBounds(365, 191, 100, 16);
        rbF.setFont(new Font("Tahoma", Font.BOLD, 16));
        rbF.setForeground(Color.WHITE);
        rbF.setBackground(new Color(10, 25, 37));
        panel.add(rbF);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbM);
        bg.add(rbF);

        JLabel lblCountry = new JLabel("Country :");
        lblCountry.setBounds(35, 231, 150,20);
        lblCountry.setForeground(Color.WHITE);
        lblCountry.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(lblCountry);
        txtCountry = new JTextField();
        txtCountry.setBounds(285, 231, 150, 20);
        txtCountry.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(txtCountry);

        JLabel lblRoom = new JLabel("Allocated Room Number :");
        lblRoom.setBounds(35, 274, 250,20);
        lblRoom.setForeground(Color.WHITE);
        lblRoom.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(lblRoom);
        choiceRoomNumber();



        JLabel lblCI = new JLabel("Checked-In :");
        lblCI.setBounds(35, 316, 200,20);
        lblCI.setForeground(Color.WHITE);
        lblCI.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(lblCI);
        // 날짜
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        date = dtf.format(now);
        lblDate = new JLabel("" + date);
        lblDate.setBounds(285, 316, 200, 20);
        lblDate.setForeground(Color.WHITE);
        lblDate.setFont(new Font("Tahoma", Font.BOLD,16));
        panel.add(lblDate);

        JLabel lblDeposite = new JLabel("Deposite :");
        lblDeposite.setBounds(35, 359, 150,20);
        lblDeposite.setForeground(Color.WHITE);
        lblDeposite.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(lblDeposite);
        txtDeposite = new JTextField();
        txtDeposite.setBounds(285, 359, 150, 20);
        txtDeposite.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(txtDeposite);

        btnAdd = new JButton("ADD");
        btnAdd.setBounds(100, 430, 130,30);
        btnAdd.setBackground(Color.BLACK);
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(btnAdd);

        btnBack = new JButton("BACK");
        btnBack.setBounds(260, 430, 130,30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(btnBack);

    }

    public void actionListener(){
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtNumber.equals("") || !txtName.equals("") || !txtCountry.equals("") || !txtDeposite.equals("")){
                    String gend = null;
                    if (rbM.isSelected()){
                        gend = "Male";
                    } else if (rbF.isSelected()) {
                        gend = "Female";
                    }
                    String id = (String) cbIdCard.getSelectedItem();
                    String num = txtNumber.getText();
                    String name = txtName.getText();
                    String gender = gend;
                    String country = txtCountry.getText();
                    String room = choiNo.getSelectedItem();
                    String checkIn = lblDate.getText();
                    String deposite = txtDeposite.getText();

                    try {
                        String q =  "INSERT INTO customer VALUES('" + id + "', '" + num + "', '" + name + "', '" + gender + "', '" + country + "', '" + room + "', '" +checkIn + "', '" + deposite + "')";
                        String qu = "UPDATE room SET availability = 'Occupied' WHERE roomNumber = '" + room +"'";
                        con.statement.executeUpdate(q);
                        con.statement.executeUpdate(qu);

                        JOptionPane.showMessageDialog(null, "added Successfully");

                        setVisible(false);

                    }catch (Exception ex){
                        ex.printStackTrace();
                    }

                }else {
                    JOptionPane.showMessageDialog(null, "There is no input.");
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

    public void choiceRoomNumber(){
        try {
            choiNo = new Choice();
            String q = "SELECT * FROM room";
            ResultSet rs = con.statement.executeQuery(q);
            while (rs.next()){
                choiNo.add(rs.getString(1));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        choiNo.setBounds(285, 274, 150, 20);
        choiNo.setBackground(new Color(3, 45, 48));
        choiNo.setFont(new Font("Tahoma", Font.BOLD,16));
        choiNo.setForeground(Color.WHITE);
        panel.add(choiNo);
    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}
