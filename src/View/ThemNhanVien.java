package View;

import Controller.AccountController;
import Model.Account;
import Model.NhanVienFullTime;
import Model.NhanVienPartTime;
import Model.QuanLy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static Controller.AccountController.getAccountByUsername;
import static Controller.NhanVienFullTimeController.insertNhanVienFullTime;
import static Controller.NhanVienPartTimeController.insertNhanVienPartTime;
import static Controller.QuanLyController.insertQuanLy;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class ThemNhanVien extends JDialog{
    private JPanel SuaNhanVien;
    private JButton thêmNhânViênButton;
    private JButton cancelButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;

    public ThemNhanVien (JFrame parent){
        super(parent);
        setTitle("Thêm nhân viên");
        setContentPane(SuaNhanVien);
        setMinimumSize(new Dimension(500, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        thêmNhânViênButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Account> accountList = AccountController.getAllAccount();
                for (Account a : accountList){
                    if (textField1.getText().equals(a.getUsername())){
                        JOptionPane.showMessageDialog(ThemNhanVien.this, "Xin mời bạn nhập Username khác");
                    }else{
                        switch (textField3.getText()){
                            case "employee part time":
                                NhanVienPartTime s =new NhanVienPartTime(textField1.getText(),textField2.getText(),textField3.getText(),textField4.getText(),parseInt(textField5.getText()),parseDouble(textField6.getText()),parseInt(textField7.getText()));
                                insertNhanVienPartTime(s);
                                dispose();
                                break;
                        }
                        switch (textField3.getText()){
                            case "employee full time":
                                NhanVienFullTime s=new NhanVienFullTime(textField1.getText(),textField2.getText(),textField3.getText(),textField4.getText(),parseInt(textField5.getText()),parseDouble(textField8.getText()));
                                insertNhanVienFullTime(s);
                                dispose();
                                break;
                        }
                        switch (textField3.getText()) {
                            case "admin":
                                QuanLy s = new QuanLy(textField1.getText(), textField2.getText(), textField3.getText(), textField4.getText(), parseInt(textField5.getText()), parseDouble(textField8.getText()));
                                insertQuanLy(s);
                                dispose();
                                break;
                        }
                    }
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
        ThemNhanVien a = new ThemNhanVien(null);
    }
}
