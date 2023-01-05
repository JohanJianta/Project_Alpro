package UserInterface;

import javax.swing.ImageIcon;

public class JLabelItem {
    private String Text;
    private ImageIcon Icon;

    public JLabelItem(String Text, ImageIcon Icon) {
        super();
        this.Text = Text;
        this.Icon = Icon;
    }

    public String getText() {
        return Text;
    }
    
    public void setText(String text){
        Text = text;
    }

    public ImageIcon getIcon() {
        return Icon;
    }
    
    public void setIcon(ImageIcon icon){
        this.Icon = icon;
    }
}