import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class JFontChooser {

    private JFrame jfrm;
    private JDialog jdlg;
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
        jdlg.setLocationRelativeTo(parent);
        jdlg.setVisible(true);

        return false;
    }

    private void generateDialog(){

        jdlg = new JDialog(jfrm,"Font",true);
        jdlg.setSize(500,500);
        jdlg.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

       JLabel jlSampleTxt = new JLabel("AaBbYyZz");
       jlSampleTxt.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(5,5,5,5);

        ///////column 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        jdlg.add(generateFontPane(),gbc);

        ///////column 2
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc. gridy = 0;
        jdlg.add(generateFontStylePane(),gbc);

        ///////column 3
        gbc.gridx = 2;
        gbc.gridy = 0;
        jdlg.add(generateFontSizePane(), gbc);

        //sample text area
        Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
        Border margin = new EmptyBorder(40,80,40, 80);
        jlSampleTxt.setBorder(new CompoundBorder(border,margin));
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        jdlg.add(jlSampleTxt,gbc);
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;

        //button: ok cancel color chooser
        gbc.gridx = 2;
        gbc.gridy = 1;
        jdlg.add(buttonCreation(),gbc);
        jdlg.pack();
    }

    private JPanel buttonCreation(){
        JButton jbOkay = new JButton("OK");
        JButton jbCancel = new JButton("Cancel");
        JButton jbColorChooser = new JButton("Color Chooser");
        GridBagConstraints gbcs = new GridBagConstraints();

        JPanel butt = new JPanel();
        butt.setLayout(new GridBagLayout());

        gbcs.insets = new Insets(10,5,5,5);

        gbcs.gridx = 0;
        gbcs.gridy = 0;
        gbcs.gridwidth = 2;
        gbcs.fill = GridBagConstraints.HORIZONTAL;
        butt.add(jbColorChooser, gbcs);
        gbcs.gridwidth = 1;
        gbcs.fill = GridBagConstraints.NONE;

        gbcs.gridx = 0;
        gbcs.gridy = 1;
        butt.add(jbOkay,gbcs);

        gbcs.gridx = 1;
        gbcs.gridy = 1;
        butt.add(jbCancel,gbcs);
        gbcs.gridx = 0;
        gbcs.gridy = 0;

        return butt;
    }

    private JPanel generateFontPane(){
        String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        DefaultListModel lm = new DefaultListModel();

        for(int i = 0; i < fonts.length; i++)
            lm.addElement(fonts[i]);

        JList jlst = new JList(lm);
        JScrollPane jscrlp = new JScrollPane(jlst);

        JLabel jlFont = new JLabel("Font:");
        JTextField jtFont = new JTextField(10);

        JPanel jpln = new JPanel();
        jpln.setLayout(new BorderLayout());
        jpln.add(jlFont, BorderLayout.NORTH);
        jpln.add(jtFont, BorderLayout.CENTER);
        jpln.add(jscrlp, BorderLayout.SOUTH);

        return jpln;
    }

    private JPanel generateFontStylePane(){
        String fontsStyles[] = {"Plain", "Italic", "Bold", "Bold Italic"};
        DefaultListModel lm = new DefaultListModel();

        for(int i = 0; i < fontsStyles.length; i++)
            lm.addElement(fontsStyles[i]);

        JList jlst = new JList(lm);
        JScrollPane jscrlp = new JScrollPane(jlst);

        JLabel jlStyle = new JLabel("Style:");
        JTextField jtStyle = new JTextField(10);

        JPanel jpln = new JPanel();
        jpln.setLayout(new BorderLayout());
        jpln.add(jlStyle, BorderLayout.NORTH);
        jpln.add(jtStyle, BorderLayout.CENTER);
        jpln.add(jscrlp, BorderLayout.SOUTH);

        return jpln;
    }


    private JPanel generateFontSizePane(){
        String fontSize[] = {"8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "36", "48", "72"};
        DefaultListModel lm = new DefaultListModel();

        for(int i = 0; i < fontSize.length; i++)
            lm.addElement(fontSize[i]);

        JList jlst = new JList(lm);
        JScrollPane jscrlp = new JScrollPane(jlst);

        JLabel jlSize = new JLabel("Size:");
        JTextField jtSize = new JTextField(10);
        JPanel jpln = new JPanel();
        jpln.setLayout(new BorderLayout());
        jpln.add(jlSize, BorderLayout.NORTH);
        jpln.add(jtSize, BorderLayout.CENTER);
        jpln.add(jscrlp, BorderLayout.SOUTH);
        return jpln;
    }

}