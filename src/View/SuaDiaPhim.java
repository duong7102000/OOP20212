package View;

import Model.DiaPhim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Controller.DiaPhimController.updateDiaPhim;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class SuaDiaPhim extends JDialog{
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
    private JButton suaDiaPhimButton;
    private JButton cancelButton;
    private JPanel suaDiaPhim;
    private JPanel panel2;

    public SuaDiaPhim(JFrame parent) {
        super(parent);
        setTitle("Thêm đĩa phim");
        setContentPane(suaDiaPhim);
        setMinimumSize(new Dimension(500, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        suaDiaPhimButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DiaPhim s= new DiaPhim(parseInt(textField10.getText()),parseDouble(textField9.getText()),parseDouble(textField8.getText()),parseInt(textField7.getText()),parseInt(textField6.getText()),textField1.getText(),textField2.getText(),textField3.getText(),textField4.getText(),textField5.getText());
                updateDiaPhim(s);
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
