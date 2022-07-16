package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThemSanPham extends JDialog{
    private JButton thêmSáchButton;
    private JButton thêmĐĩaNhạcButton;
    private JButton thêmĐĩaPhimButton;
    private JPanel ThêmSảnPhẩm;

    public ThemSanPham(JFrame parent) {
        super(parent);
        setTitle("Thêm sản phẩm");
        setContentPane(ThêmSảnPhẩm);
        setMinimumSize(new Dimension(500, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        thêmSáchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThemSach(null);
            }
        });
        thêmĐĩaNhạcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThemDiaNhac(null);
            }
        });
        thêmĐĩaPhimButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThemDiaPhim(null);
            }
        });
        setVisible(true);
    }
}
