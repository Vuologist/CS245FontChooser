import javax.swing.*;
import java.awt.*;

public class FontChooserDemo {

    JFrame jfrm;

    public FontChooserDemo(){

        jfrm = new JFrame ("Untitled-Notepad");
        jfrm.setSize(650,325);
        jfrm.setLayout(new BorderLayout());
        jfrm.setDefaultCloseOperation(jfrm.EXIT_ON_CLOSE);

        Color color = new Color(200, 120, 32, 10);
        Font font = new Font(Font.SERIF,Font.BOLD,12);

        JFontChooser jfontc = new JFontChooser();
        jfontc.setDefault(font);
        jfontc.setDefault(color);
        if (jfontc.showDialog(jfrm)) { // user selected ok
            jfontc.getFont();
            jfontc.getColor();
        }

        jfrm.setLocationRelativeTo(null);
        jfrm.setVisible(true);
    }

    public static void main (String args[]){
        SwingUtilities.invokeLater( ()->{
            new FontChooserDemo();
        });
    }

}
