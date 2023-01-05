package UserInterface;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class JLabelModel extends JLabel implements ListCellRenderer {

    public JLabelModel() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        JLabelItem item = (JLabelItem) value;
        this.setText(item.getText());
        this.setFont(new java.awt.Font("Segoe UI", 0, 18));
        this.setIcon(new ImageIcon((item.getIcon()).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        this.setIconTextGap(10);
        Color biru = new Color(153, 204, 255);
        Color biru2 = new Color(0, 153, 255);

        if (isSelected) {
            setBackground(biru);
            setForeground(Color.WHITE);
        }

        if (!isSelected) {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }

        if (cellHasFocus) {
            setBorder(BorderFactory.createLineBorder(biru2));
        } else {
            setBorder(BorderFactory.createEmptyBorder());
        }

        return this;
    }

}
