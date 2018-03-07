import javax.swing.*;
import java.awt.*;

public class JFontChooser {

    private JFrame jfrm;
    private JDialog jdlg;
    private GridBagConstraints gbc;
    private Font defaultFont;
    private Color defaultColor;
    private Font selectedFont;
    private Color selectedColor;

    public void setDefault(Font font){
        defaultFont = font;
    }

    public void setDefault(Color color){
        defaultColor = color;
    }

    public Color getColor(){return selectedColor;}

    public Font getFont() {return selectedFont;}

    public boolean showDialog(JFrame parent){
        jfrm = parent;
        generateDialog();
        jdlg.setVisible(true);

        return false;
    }

    private void generateDialog(){

        jdlg = new JDialog(jfrm,"Font",true);
        jdlg.setSize(400,500);
        jdlg.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;

        jdlg.add(generateFontPane(),gbc);



        gbc.gridx = 20;
        gbc.gridy = 20;
        jdlg.add(buttonCreation(),gbc);


    }

    private JPanel buttonCreation(){
        JButton jbOkay = new JButton("OK");
        JButton jbCancel = new JButton("Cancel");

        JPanel butt = new JPanel();
        butt.setLayout(new GridLayout(1,2));

        butt.add(jbOkay);
        butt.add(jbCancel);

        return butt;
    }

    private JScrollPane generateFontPane(){
        String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        DefaultListModel lm = new DefaultListModel();

        for(int i = 0; i < fonts.length; i++)
            lm.addElement(fonts[i]);

        JList jlst = new JList(lm);
        JScrollPane jscrlp = new JScrollPane(jlst);

        return jscrlp;
    }

    private JScrollPane generateFontStylePane(){
        String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        DefaultListModel lm = new DefaultListModel();

        for(int i = 0; i < fonts.length; i++)
            lm.addElement(fonts[i]);

        JList jlst = new JList(lm);
        JScrollPane jscrlp = new JScrollPane(jlst);

        return jscrlp;
    }


    private JScrollPane generateFontSizePane(){

    }


}