package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoom extends JFrame {

    JTextField txtNum, txtPri;
    JComboBox cbAvai, cbClean, cbType;
    JButton btnAdd, btnBack;
    JPanel panel;
    Connecting con = new Connecting();
    AddRoom(){

        initAddRoom();
        actionListener();

        setLayout(null);
        setUndecorated(true);
        setLocation(60, 200);
        setSize(850, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initAddRoom(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 840, 490);
        panel.setBackground(new Color(10, 25, 37));
        add(panel);

        JLabel lblRoom = new JLabel("Add Rooms Form");
        lblRoom.setBounds(194, 10, 160,30);
        lblRoom.setForeground(Color.WHITE);
        lblRoom.setFont(new Font("Tahoma", Font.BOLD, 24));
        panel.add(lblRoom);

        JLabel lblnum = new JLabel("Room Number");
        lblnum.setBounds(64, 70, 150,25);
        lblnum.setForeground(Color.WHITE);
        lblnum.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(lblnum);

        txtNum = new JTextField();
        txtNum.setBounds(200, 70, 150, 25);
        txtNum.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtNum.setForeground(Color.WHITE);
        txtNum.setBackground(new Color(16, 108, 115));
        panel.add(txtNum);

        JLabel lblAvai = new JLabel("Availability");
        lblAvai.setBounds(64, 110, 150,25);
        lblAvai.setForeground(Color.WHITE);
        lblAvai.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(lblAvai);

        cbAvai = new JComboBox(new String[] {"Available", "Occupied"});// Available(이용할 수 있는) Occupied(사용중)
        cbAvai.setBounds(200, 110, 150, 25);
        cbAvai.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cbAvai.setForeground(Color.WHITE);
        cbAvai.setBackground(new Color(16, 108, 115));
        panel.add(cbAvai);

        JLabel lblPri = new JLabel("Price");
        lblPri.setBounds(64, 150, 150,25);
        lblPri.setForeground(Color.WHITE);
        lblPri.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(lblPri);

        txtPri = new JTextField();
        txtPri.setBounds(200, 150, 150, 25);
        txtPri.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtPri.setForeground(Color.WHITE);
        txtPri.setBackground(new Color(16, 108, 115));
        panel.add(txtPri);

        JLabel lblClean = new JLabel("Cleaning Status");
        lblClean.setBounds(64, 190, 150,25);
        lblClean.setForeground(Color.WHITE);
        lblClean.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(lblClean);

        cbClean = new JComboBox(new String[] {"Cleaned", "Dirty"});// Cleaned(청소했다) Dirty(더러워)
        cbClean.setBounds(200, 190, 150, 25);
        cbClean.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cbClean.setForeground(Color.WHITE);
        cbClean.setBackground(new Color(16, 108, 115));
        panel.add(cbClean);

        JLabel lblType = new JLabel("Bed Type");
        lblType.setBounds(64, 230, 150,25);
        lblType.setForeground(Color.WHITE);
        lblType.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(lblType);

        cbType = new JComboBox(new String[] {"Single Bed", "Double Bed"});
        cbType.setBounds(200, 230, 150, 25);
        cbType.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cbType.setForeground(Color.WHITE);
        cbType.setBackground(new Color(16, 108, 115));
        panel.add(cbType);

        btnAdd = new JButton("ADD");
        btnAdd.setBounds(64, 320, 130,30);
        btnAdd.setBackground(Color.BLACK);
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(btnAdd);

        btnBack = new JButton("BACK");
        btnBack.setBounds(210, 320, 130,30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(btnBack);

        ImageIcon imageRoomser = new ImageIcon(ClassLoader.getSystemResource("icon/roomser.png"));
        Image imgrooms = imageRoomser.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imgroom = new ImageIcon(imgrooms);
        JLabel label_rooms = new JLabel(imgroom);
        label_rooms.setBounds(500, 60, 300, 300);
        panel.add(label_rooms);

    }

    public void actionListener(){
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtNum.getText().equals("")){
                    try {
                        String room = txtNum.getText();
                        String price = txtPri.getText();
                        String avai = (String) cbAvai.getSelectedItem();
                        String status = (String) cbClean.getSelectedItem();
                        String type = (String) cbType.getSelectedItem();

                        String q = "INSERT INTO room VALUES('" + room + "', '" + avai + "', '" + status + "', '" + price + "', '" + type + "')";
                        con.statement.executeUpdate(q);
                        JOptionPane.showMessageDialog(null, "Room Successfully Added");

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
                //new Admin();
            }
        });
    }

    public static void main(String[] args) {
        new AddRoom();
    }
}
