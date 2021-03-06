package View;

import Model.Account;
import Model.NhanVienFullTime;
import Model.NhanVienPartTime;
import Model.QuanLy;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Controller.NhanVienFullTimeController.insertNhanVienFullTime;
import static Controller.NhanVienPartTimeController.insertNhanVienPartTime;
import static Controller.QuanLyController.insertQuanLy;


public class Signup extends JDialog{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField4;
    private JButton signUpButton;
    private JButton cancelButton;
    private JPanel signUpPanel;
    private JTextField textField0;
    private JTextField textField3;

    public Signup(JFrame parent) {
        super(parent);
        setTitle("Signup");
        setContentPane(signUpPanel);
        setMinimumSize(new Dimension(500, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Account account = new Account(textField0.getText(), textField1.getText(), textField2.getText());
                switch (account.getPosition()) {
                    case "employee part time":
                        NhanVienPartTime nhanVienPartTime = new NhanVienPartTime(textField0.getText(), textField1.getText(), textField2.getText(), textField3.getText(), Integer.parseInt(textField4.getText()), 0, 0);
                        if (!insertNhanVienPartTime(nhanVienPartTime)){
                            JOptionPane.showMessageDialog(Signup.this, "Xin mời bạn nhập Username khác");
                        }
                        else{
                            insertNhanVienPartTime(nhanVienPartTime);
                            JOptionPane.showMessageDialog(Signup.this, "Đăng ký thành công!");
                            dispose();
                            new Login(null);
                        }
                        break;
                    case "employee full time":
                        NhanVienFullTime nhanVienFullTime = new NhanVienFullTime(textField0.getText(), textField1.getText(), textField2.getText(), textField3.getText(), Integer.parseInt(textField4.getText()), 0);
                        if (!insertNhanVienFullTime(nhanVienFullTime)){
                            JOptionPane.showMessageDialog(Signup.this, "Xin mời bạn nhập Username khác");
                        }
                        else{
                            insertNhanVienFullTime(nhanVienFullTime);
                            JOptionPane.showMessageDialog(Signup.this, "Đăng ký thành công!");
                            dispose();
                            new Login(null);
                        }
                        break;
                    case "admin":
                        QuanLy quanLy = new QuanLy(textField0.getText(), textField1.getText(), textField2.getText(), textField3.getText(), Integer.parseInt(textField4.getText()), 0);
                        if (!insertQuanLy(quanLy)){
                            JOptionPane.showMessageDialog(Signup.this, "Xin mời bạn nhập Username khác");
                        }
                        else{
                            JOptionPane.showMessageDialog(Signup.this, "Đăng ký thành công!");
                            dispose();
                            new Login(null);
                        }
                        break;
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        Signup a = new Signup(null);
    }
}
