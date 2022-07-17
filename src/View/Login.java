package View;

import Model.Account;
import Model.NhanVienFullTime;
import Model.NhanVienPartTime;
import Model.QuanLy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static Controller.AccountController.logIn;
import static Controller.NhanVienFullTimeController.getAllNhanVienFullTime;
import static Controller.NhanVienPartTimeController.getAllNhanVienPartTime;
import static Controller.QuanLyController.getAllQuanLy;


public class Login extends JDialog{
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton signInButton;
    private JButton signUpButton;
    private JPanel loginPanel;

    public Login(JFrame parent){
        super(parent);
        setTitle("Login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(500, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Account account = logIn(textField1.getText(), String.valueOf(passwordField1.getPassword()));
                if (account==null){
                    JOptionPane.showMessageDialog(Login.this, "Xin mời bạn nhập lại");
                }
                else switch(account.getPosition()){
                    case "admin":
                    QuanLy quanLy = null;
                    List<QuanLy> listQuanLy = getAllQuanLy();
                    for (QuanLy ql:
                            listQuanLy) {
                        if (ql.getAccount().getUsername().equals(account.getUsername())){
                            quanLy = ql;
                            break;
                        }
                    }
                    dispose();
                    new QuanLyForm(null, quanLy);
                    break;
                    case "employee part time":
                    NhanVienPartTime nhanVienPartTime = null;
                    List<NhanVienPartTime> listNhanVienPartTime = getAllNhanVienPartTime();
                    for (NhanVienPartTime nvpt:
                            listNhanVienPartTime) {
                        if (nvpt.getAccount().getUsername().equals(account.getUsername())){
                            nhanVienPartTime = nvpt;
                            break;
                        }
                    }
                    dispose();
                    new NhanVienForm(null);
                    case "employee full time":
                    NhanVienFullTime nhanVienFullTime = null;
                    List<NhanVienFullTime> listNhanVienFullTime = getAllNhanVienFullTime();
                    for (NhanVienFullTime nvft:
                            listNhanVienFullTime) {
                        if (nvft.getAccount().getUsername().equals(account.getUsername())){
                            nhanVienFullTime = nvft;
                            break;
                        }
                    }
                    dispose();
                    new NhanVienForm(null);
                }
            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Signup(null);
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login(null);
    }
}