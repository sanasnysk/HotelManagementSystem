package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame {

    JPanel panel;
    JTable tblRoom;
    JButton btnBack;
    Connecting con = new Connecting();
    Room(){

        initRoom();
        actionListener();

        setLayout(null);
        setUndecorated(true);
        setLocation(450, 100);
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initRoom(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        ImageIcon imageRoom = new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
        Image imgRoom = imageRoom.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imgRo = new ImageIcon(imgRoom);
        JLabel label_room = new JLabel(imgRo);
        label_room.setBounds(600, 150, 300, 300);
        panel.add(label_room);

        tableRoom();

        JLabel room = new JLabel("Room No.");
        room.setBounds(12, 15, 100, 20);
        room.setForeground(Color.WHITE);
        room.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(room);

        JLabel availability = new JLabel("Availability");
        availability.setBounds(119, 15, 100, 20);
        availability.setForeground(Color.WHITE);
        availability.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(availability);

        JLabel clean = new JLabel("Clean Status");
        clean.setBounds(215, 15, 100, 20);
        clean.setForeground(Color.WHITE);
        clean.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(clean);

        JLabel price = new JLabel("Price");
        price.setBounds(330, 15, 100, 20);
        price.setForeground(Color.WHITE);
        price.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(price);

        JLabel bed = new JLabel("Bed Type");
        bed.setBounds(417, 15, 100, 20);
        bed.setForeground(Color.WHITE);
        bed.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(bed);

        btnBack = new JButton("BACK");
        btnBack.setBounds(200, 500, 120,30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(btnBack);

    }

    public void actionListener(){
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    public void tableRoom(){
        tblRoom = new JTable();
        tblRoom.setBounds(10, 40, 500, 400);
        tblRoom.setBackground(new Color(3, 45, 48));
        tblRoom.setForeground(Color.WHITE);
        tblRoom.setFont(new Font("Tahoma", Font.PLAIN,16));
        panel.add(tblRoom);

        try {
            String roomInfo = "SELECT * FROM room";
            ResultSet rs = con.statement.executeQuery(roomInfo);
            tblRoom.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Room();
    }


}
