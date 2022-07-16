package View;

import Model.DiaNhac;
import Model.DiaPhim;
import Model.Sach;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Controller.DiaPhimController.insertDiaPhim;
import static Controller.SachController.insertSach;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class ThemDiaPhim extends JDialog{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JButton thêmĐĩaPhimButton;
    private JButton cancelButton;
    private JLabel panel1;
    private JPanel panel2;

    public ThemDiaPhim(JFrame parent) {
        super(parent);
        setTitle("Thêm đĩa phim");
        setContentPane(panel2);
        setMinimumSize(new Dimension(500, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        thêmĐĩaPhimButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DiaPhim s= new DiaPhim(parseInt(textField1.getText()),parseDouble(textField10.getText()),parseDouble(textField9.getText()),parseInt(textField8.getText()),parseInt(textField7.getText()),textField2.getText(),textField3.getText(),textField4.getText(),textField5.getText(),textField6.getText());
                insertDiaPhim(s);
                dispose();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);

    }
    public static void main(String[] args) {
        ThemDiaPhim a = new ThemDiaPhim(null);
    }
}
