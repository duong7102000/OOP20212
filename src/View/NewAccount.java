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
        NewAccount acc= new NewAccount();
    }

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    // Khai bao cac component
    JLabel lbName=new JLabel("Name");
    JLabel lbYOB=new JLabel("Year of birth");
    JLabel lbUser=new JLabel("Username");
    JLabel lbPassword=new JLabel("Password");
    JTextField txtUser=new JTextField();
    JTextField txtYOB=new JTextField();
    JTextField txtName=new JTextField();
    JPasswordField txtPassword=new JPasswordField();

    JLabel lbPosition=new JLabel("Position");
    JComboBox cbPosition=new JComboBox();

    JButton btnSave=new JButton("Save");
    JButton btnCancel=new JButton("Cancel");

    // Luu danh sach nguoi dung
    ArrayList listUser=new ArrayList();

    // Ham khoi tao
    public NewAccount(){
        setBounds(450, 180, 1024, 234);
        setResizable(false);

        // Tao container
        Container con=this.getContentPane();

        // Tao panel 1 chua thong tin
        JPanel panel1=new JPanel();
        panel1.setLayout(new GridLayout(5,5,5,5));
        panel1.add(lbName);
        panel1.add(txtName);
        panel1.add(lbYOB);
        panel1.add(txtYOB);
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
            String name = txtName.getText();
            String YOB = txtYOB.getText();
            String userName = txtUser.getText();
            String passWord = txtPassword.getText();
            String position = (String) cbPosition.getSelectedItem();

            // Tao nguoi dung moi
           Account newUser = new Account(userName, passWord, position);
            // Them nguoi dung vao danh sach
            listUser.add(newUser);
        } else {
            // Neu click Cancel thi thoat chuong trinh
            this.dispose();
        }
    }
}

