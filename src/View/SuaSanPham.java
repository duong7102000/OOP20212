package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuaSanPham extends JDialog {
    private JButton sửaSáchButton;
    private JButton sửaĐĩaPhimButton;
    private JButton sửaĐĩaNhạcButton;
    private JPanel SuaSanPham;

    public SuaSanPham(JFrame parent) {
        super(parent);
        setTitle("Sửa sản phẩm");
        setContentPane(SuaSanPham);
        setMinimumSize(new Dimension(500, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        sửaSáchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SuaSach(null);
            }
        });
        sửaĐĩaNhạcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SuaDiaNhac(null);
            }
        });
        sửaĐĩaPhimButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        setVisible(true);
    }
}
