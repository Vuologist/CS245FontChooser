import javax.swing.*;
import java.awt.*;


//
// Name: Vu, Anthony
// Project: 2
// Due: 3/7/2018
// Course: CS-245-01-w18
//
// Description:
// This is class is responsible for initializing the JFontChooser class.
// It returns the font and color if the user selected okay when the dialog
// appears. Else, it will return to the settings before it was cancelled.
//

public class FontChooserDemo {

    JFrame jfrm;

    public FontChooserDemo(){

        jfrm = new JFrame ("FontChooserDemo");
        jfrm.setSize(650,325);
        jfrm.setLayout(new BorderLayout());
        jfrm.setDefaultCloseOperation(jfrm.EXIT_ON_CLOSE);

        Color color = new Color(0, 0, 0);
        Font font = new Font("Forte",Font.PLAIN,12);

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
