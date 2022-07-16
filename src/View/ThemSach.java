package View;

import Model.Sach;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Controller.SachController.insertSach;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class ThemSach extends JDialog{
    private JTextField textField1;
    private JPanel panel1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JButton cancelButton;
    private JButton thêmSáchButton;

    public ThemSach(JFrame parent) {
        super(parent);
        setTitle("Thêm sách");
        setContentPane(panel1);
        setMinimumSize(new Dimension(500, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        thêmSáchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sach s= new Sach(parseInt(textField1.getText()),parseDouble(textField9.getText()),parseDouble(textField8.getText()),parseInt(textField7.getText()),parseInt(textField6.getText()),textField2.getText(),textField3.getText(),textField4.getText(),textField5.getText());
                insertSach(s);
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
        ThemSach a = new ThemSach(null);
    }
}
