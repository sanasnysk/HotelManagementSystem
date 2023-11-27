package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame {

    JTextField txtName, txtAge, txtSalary, txtPhone, txtEmail, txtAadhar;
    JRadioButton rbM, rbF;
    JComboBox cbJ;
    JButton btnBa, btnSa;
    Connecting con = new Connecting();
    AddEmployee(){

        initAddEmployee();
        actionListener();

        setLayout(null);
        setUndecorated(true);
        setLocation(60, 200);
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initAddEmployee(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 890, 490);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        JLabel name = new JLabel("NAME");
        name.setBounds(60, 30, 150, 30);
        name.setFont(new Font("Tahoma", Font.BOLD, 16));
        name.setForeground(Color.WHITE);
        panel.add(name);
        txtName = new JTextField();
        txtName.setBounds(200, 30, 200, 30);
        txtName.setFont(new Font("Tahoma", Font.BOLD, 16));
        txtName.setForeground(Color.WHITE);
        txtName.setBackground(new Color(16, 108, 115));
        panel.add(txtName);

        JLabel age = new JLabel("AGE");
        age.setBounds(60, 70, 150, 30);
        age.setFont(new Font("Tahoma", Font.BOLD, 16));
        age.setForeground(Color.WHITE);
        panel.add(age);
        txtAge = new JTextField();
        txtAge.setBounds(200, 70, 200, 30);
        txtAge.setFont(new Font("Tahoma", Font.BOLD, 16));
        txtAge.setForeground(Color.WHITE);
        txtAge.setBackground(new Color(16, 108, 115));
        panel.add(txtAge);

        JLabel gender = new JLabel("GENDER");
        gender.setBounds(60, 120, 150, 30);
        gender.setFont(new Font("Tahoma", Font.BOLD, 16));
        gender.setForeground(Color.WHITE);
        panel.add(gender);
        rbM = new JRadioButton("MALE");
        rbM.setBounds(200, 120, 70, 16);
        rbM.setFont(new Font("Tahoma", Font.BOLD, 16));
        rbM.setForeground(Color.WHITE);
        rbM.setBackground(new Color(10, 25, 37));
        panel.add(rbM);
        rbF = new JRadioButton("FEMALE");
        rbF.setBounds(280, 120, 100, 16);
        rbF.setFont(new Font("Tahoma", Font.BOLD, 16));
        rbF.setForeground(Color.WHITE);
        rbF.setBackground(new Color(10, 25, 37));
        panel.add(rbF);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbM);
        bg.add(rbF);

        JLabel job = new JLabel("JOB");
        job.setBounds(60, 160, 150, 30);
        job.setFont(new Font("Tahoma", Font.BOLD, 16));
        job.setForeground(Color.WHITE);
        panel.add(job);
        String[] j = new String[]{"Front Desk", "Housekeeping", "Kitchen Staff", "Room Service", "Manager", "Accountant", "Chef"};
        cbJ = new JComboBox(j);
        cbJ.setBounds(200, 160, 200, 30);
        cbJ.setFont(new Font("Tahoma", Font.BOLD, 16));
        cbJ.setForeground(Color.WHITE);
        cbJ.setBackground(new Color(16, 108, 115));
        panel.add(cbJ);

        JLabel salary = new JLabel("SALARY");
        salary.setBounds(60, 210, 150, 30);
        salary.setFont(new Font("Tahoma", Font.BOLD, 16));
        salary.setForeground(Color.WHITE);
        panel.add(salary);
        txtSalary = new JTextField();
        txtSalary.setBounds(200, 210, 200, 30);
        txtSalary.setFont(new Font("Tahoma", Font.BOLD, 16));
        txtSalary.setForeground(Color.WHITE);
        txtSalary.setBackground(new Color(16, 108, 115));
        panel.add(txtSalary);

        JLabel phone = new JLabel("PHONE");
        phone.setBounds(60, 250, 150, 30);
        phone.setFont(new Font("Tahoma", Font.BOLD, 16));
        phone.setForeground(Color.WHITE);
        panel.add(phone);
        txtPhone = new JTextField();
        txtPhone.setBounds(200, 250, 200, 30);
        txtPhone.setFont(new Font("Tahoma", Font.BOLD, 16));
        txtPhone.setForeground(Color.WHITE);
        txtPhone.setBackground(new Color(16, 108, 115));
        panel.add(txtPhone);

        JLabel email = new JLabel("EMAIL");
        email.setBounds(60, 290, 150, 30);
        email.setFont(new Font("Tahoma", Font.BOLD, 16));
        email.setForeground(Color.WHITE);
        panel.add(email);
        txtEmail = new JTextField();
        txtEmail.setBounds(200, 290, 200, 30);
        txtEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
        txtEmail.setForeground(Color.WHITE);
        txtEmail.setBackground(new Color(16, 108, 115));
        panel.add(txtEmail);

        JLabel aadhar = new JLabel("AADHAR");
        aadhar.setBounds(60, 330, 150, 30);
        aadhar.setFont(new Font("Tahoma", Font.BOLD, 16));
        aadhar.setForeground(Color.WHITE);
        panel.add(aadhar);
        txtAadhar = new JTextField();
        txtAadhar.setBounds(200, 330, 200, 30);
        txtAadhar.setFont(new Font("Tahoma", Font.BOLD, 16));
        txtAadhar.setForeground(Color.WHITE);
        txtAadhar.setBackground(new Color(16, 108, 115));
        panel.add(txtAadhar);

        btnSa = new JButton("SAVE");
        btnSa.setBounds(150, 400, 80, 30);
        btnSa.setBackground(Color.BLACK);
        btnSa.setForeground(Color.WHITE);
        btnSa.setFont(new Font("Tahoma", Font.BOLD,16));
        panel.add(btnSa);

        btnBa = new JButton("BACK");
        btnBa.setBounds(280, 400, 80, 30);
        btnBa.setBackground(Color.BLACK);
        btnBa.setForeground(Color.WHITE);
        btnBa.setFont(new Font("Tahoma", Font.BOLD,16));
        panel.add(btnBa);

        JLabel lblEmp = new JLabel("Add Employee DEtails");
        lblEmp.setBounds(500, 10, 420,30);
        lblEmp.setForeground(Color.WHITE);
        lblEmp.setFont(new Font("Tahoma", Font.BOLD, 24));
        panel.add(lblEmp);

        ImageIcon imageRoomser = new ImageIcon(ClassLoader.getSystemResource("icon/addemp.png"));
        Image imgrooms = imageRoomser.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imgroom = new ImageIcon(imgrooms);
        JLabel label_rooms = new JLabel(imgroom);
        label_rooms.setBounds(500, 120, 300, 300);
        panel.add(label_rooms);
    }

    public void actionListener(){
        btnSa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtName.getText().equals("")){
                    try {
                        String name = txtName.getText();
                        String age = txtAge.getText();
                        String salary = txtSalary.getText();
                        String phone = txtPhone.getText();
                        String email = txtEmail.getText();
                        String aadhar = txtAadhar.getText();
                        String job = (String) cbJ.getSelectedItem();
                        String gender = null;
                        if (rbM.isSelected()){
                            gender = "Male";
                        } else if (rbF.isSelected()) {
                            gender = "Female";
                        }

                        String q = "INSERT INTO employee VALUES('" + name + "', '" + age + "', '" + gender + "', '" + job + "', '" + salary + "', '" + phone + "', '" + email + "', '" + aadhar + "')";
                        con.statement.executeUpdate(q);
                        JOptionPane.showMessageDialog(null, "Employee Successfully Added");

                        setVisible(false);

                    }catch (Exception ex){
                        ex.printStackTrace();
                    }

                }else {
                    JOptionPane.showMessageDialog(null, "There is no input.");
                }
            }
        });

        btnBa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
