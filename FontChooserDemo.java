import javax.swing.*;
import java.awt.*;

public class FontChooserDemo {

    JFrame jfrm;

    public FontChooserDemo(){

        jfrm = new JFrame ("FontChooserDemo");
        jfrm.setSize(650,325);
        jfrm.setLayout(new BorderLayout());
        jfrm.setDefaultCloseOperation(jfrm.EXIT_ON_CLOSE);

        Color color = new Color(0, 0, 0);
        Font font = new Font("Arial",Font.PLAIN,25);

        JFontChooser jfontc = new JFontChooser();
        jfontc.setDefault(font);
        jfontc.setDefault(color);
        if (jfontc.showDialog(jfrm)) { // user selected ok
            System.out.println(jfontc.getFont());
            System.out.println(jfontc.getColor());

        } else{
            System.out.println(jfontc.getFont());
            System.out.println(jfontc.getColor());
        }
        System.exit(10);
        jfrm.setLocationRelativeTo(null);
        jfrm.setVisible(true);
    }

    public static void main (String args[]){
        SwingUtilities.invokeLater( ()->{
            new FontChooserDemo();
        });
    }
}
