package View;

import Model.Account;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NewAccount extends JFrame implements ActionListener {
    public static void main(String[] args) {

    }


    // Khai bao cac component
    JLabel lbUser=new JLabel("Username");
    JLabel lbPassword=new JLabel("Password");
    JTextField txtUser=new JTextField();
    JPasswordField txtPassword=new JPasswordField();

    JLabel lbPosition=new JLabel("Positon");
    JComboBox cbPosition=new JComboBox();

    JButton btnSave=new JButton("Save");
    JButton btnCancel=new JButton("Cancel");

    // Luu danh sach nguoi dung
    ArrayList listUser=new ArrayList();

    // Ham khoi tao
    public NewAccount(){

        // Tao container
        Container con=this.getContentPane();

        // Tao panel 1 chua username, pass, access
        JPanel panel1=new JPanel();
        panel1.setLayout(new GridLayout(3, 2));
        panel1.add(lbUser);
        panel1.add(txtUser);
        panel1.add(lbPassword);
        panel1.add(txtPassword);

        // Tao danh sach quyen truy cap
        cbPosition.addItem("Admin");
        cbPosition.addItem("Employee");

        panel1.add(lbPosition);
        panel1.add(cbPosition);

        // Tao panel 2 chua buttun save, access
        JPanel panel2=new JPanel();
        panel2.setLayout(new FlowLayout());
        panel2.add(btnSave);
        panel2.add(btnCancel);

        // Dat phuong thuc trang thai
        btnSave.addActionListener(this);
        btnCancel.addActionListener(this);

        // Dat panel 1 o vung trung tam
        con.add(panel1);

        // Dat panel 2 vao vung South
        con.add(panel2, "South");

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Neu click btn save thi lay du lieu cua cac tru ng
        if(e.getActionCommand().equals("Save")) {
            String userName = txtUser.getText();
            String passWord = txtPassword.getText();
            String access = (String) cbPosition.getSelectedItem();

            // Tao nguoi dung moi
           Account newUser = new Account(userName, passWord, access);

            // Them nguoi dung vao danh sach
            listUser.add(newUser);
        } else {
            // Neu click Cancel thi thoat chuong trinh
            this.dispose();
        }
    }
}

