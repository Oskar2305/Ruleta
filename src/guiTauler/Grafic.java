package guiTauler;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Grafic {
    private JFrame frame;

    private JTextField txtResum;

    private boolean apostaAmount;

    public void Initialize() throws FontFormatException, IOException {
        {
            Font fntDigital = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/CursedTimerULiL.ttf"));
            fntDigital = fntDigital.deriveFont(Font.PLAIN, 40);
            Font fntBitty = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/Bittypix.otf"));
            fntBitty = fntBitty.deriveFont(Font.PLAIN, 40);
            Font fntResum = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/digital-7 (italic).ttf"));
            fntResum = fntDigital.deriveFont(Font.PLAIN, 15);

            frame.setBounds(100, 100, 450, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setLayout(new BorderLayout(0, 0));
        }


    }
}