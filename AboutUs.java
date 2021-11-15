import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AboutUs extends JPanel{
    JLabel heading, fahad, usman, fahadtxt, usmantxt;
    AboutUs(){
        this.setBackground(new Color(220, 220, 220));
        this.setBounds(300, 90, 600, 450);
        this.setLayout(null);

        heading = new JLabel("Team Members");
        heading.setBounds(180,30,300,80);
        heading.setFont(new Font("Arial", Font.BOLD, 40));

        fahad = new JLabel();
        fahad.setBounds(100,150,200,200);

        usman = new JLabel();
        usman.setBounds(350,150,200,200);

        fahadtxt = new JLabel("Fahad");
        fahadtxt.setBounds(130,350,170,50);
        fahadtxt.setFont(new Font("Arial", Font.BOLD, 30));

        usmantxt = new JLabel("M.Usman");
        usmantxt.setBounds(380,350,170,50);
        usmantxt.setFont(new Font("Arial", Font.BOLD, 30));

        BufferedImage f = null;
        try {
            f = ImageIO.read(new File("Fahad1.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int diameter = Math.min(f.getWidth(), f.getHeight());
        BufferedImage f1 = new BufferedImage(f.getWidth(), f.getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = f1.createGraphics();
        applyQualityRenderingHints(g2d);
        g2d.fillOval(0, 0, diameter - 1, diameter - 1);
        g2d.dispose();

        BufferedImage f2 = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
        g2d = f2.createGraphics();
        applyQualityRenderingHints(g2d);
        int x = (diameter - f.getWidth()) / 2;
        int y = (diameter - f.getHeight()) / 2;
        g2d.drawImage(f, x, y, null);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
        g2d.drawImage(f1, 0, 0, null);
        g2d.dispose();

        fahad.setIcon(new ImageIcon((new ImageIcon(f2).getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT))));

        BufferedImage u = null;
        try {
            u = ImageIO.read(new File("usman.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        diameter = Math.min(u.getWidth(), u.getHeight());
        BufferedImage u1 = new BufferedImage(u.getWidth(), u.getHeight(), BufferedImage.TYPE_INT_ARGB);

        g2d = u1.createGraphics();
        applyQualityRenderingHints(g2d);
        g2d.fillOval(0, 0, diameter - 1, diameter - 1);
        g2d.dispose();

        BufferedImage u2 = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
        g2d = u2.createGraphics();
        applyQualityRenderingHints(g2d);
        x = (diameter - u.getWidth()) / 2;
        y = (diameter - u.getHeight()) / 2;
        g2d.drawImage(u, x, y, null);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
        g2d.drawImage(u1, 0, 0, null);
        g2d.dispose();

        usman.setIcon(new ImageIcon((new ImageIcon(f2).getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT))));
        usman.setIcon(new ImageIcon((new ImageIcon(u2).getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT))));

        add(heading);
        add(fahad);
        add(fahadtxt);
        add(usmantxt);
        add(usman);
    }

    public static void applyQualityRenderingHints(Graphics2D g2d) {

        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

    }


    public static void main(String[] args) {
        JFrame frame =new JFrame();
        frame.setSize(1100,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.add(new AboutUs());
        frame.setVisible(true);
    }
}
