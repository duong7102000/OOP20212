package View;

import Model.Account;
import Model.NhanVienFullTime;
import Model.NhanVienPartTime;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Controller.AccountController.getAccountByUsername;
import static Controller.NhanVienFullTimeController.updateNhanVienFullTime;
import static Controller.NhanVienPartTimeController.updateNhanVienPartTime;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class SuaNhanVien extends JDialog {
    private JButton button1;
    private JButton cancelButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JPanel SuaNhanVien;

    public SuaNhanVien(JFrame parent) {
        super(parent);
        setTitle("Sửa sản phẩm");
        setContentPane(SuaNhanVien);
        setMinimumSize(new Dimension(500, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (textField7.getText()){
                    case "employee part time":
                        NhanVienPartTime s =new NhanVienPartTime(getAccountByUsername(textField1.getText()),textField2.getText(),parseInt(textField3.getText()),parseDouble(textField4.getText()),parseInt(textField5.getText()));
                        updateNhanVienPartTime(s);
                        dispose();
                        break;
                }
                switch (textField7.getText()){
                    case "employee full time":
                        NhanVienFullTime s=new NhanVienFullTime(getAccountByUsername(textField1.getText()),textField2.getText(),parseInt(textField3.getText()),parseDouble(textField6.getText()));
                        updateNhanVienFullTime(s);
                        dispose();
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
        SuaNhanVien a = new SuaNhanVien(null);
    }
}
