import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Frame implements  ActionListener {
    static JFrame frame;
    static JLabel label, logoimage,label2;
    ImageIcon image1 = new ImageIcon(new ImageIcon("mehran.jpg").getImage().getScaledInstance(1100, 650, Image.SCALE_DEFAULT));
    ImageIcon image = new ImageIcon(new ImageIcon("muet_logo.png").getImage().getScaledInstance(400, 70, Image.SCALE_DEFAULT));
    ImageIcon image2= new ImageIcon(new ImageIcon("logo.png").getImage().getScaledInstance(350,350,Image.SCALE_DEFAULT));
    int counter;
    Timer timer;
    HomePage home=new HomePage();
    Wellcome wel;

    Main_Frame() {
        counter = 5;
         timer = new Timer(1100, this);
        frame = new JFrame();
        frame.setSize(1100, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(220,220,220));

        label2= new JLabel();
        label2.setBounds(400,120,350,350);
        label2.setIcon(image2);
        label2.setVisible(false);


        label = new JLabel();
        label.setBounds(0, 0, 1100, 650);
      // label.setIcon(image1);

        label.setLayout(null);

        logoimage = new JLabel();
        logoimage.setBounds(20, 10, 400, 70);
        logoimage.setIcon(image);
        label.add(logoimage);
        label.add(label2);

        wel = new Wellcome();
        label.add(wel);
        timer.start();
        home = new HomePage();

        frame.add(label);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main_Frame();
    }

    public void actionPerformed(ActionEvent e) {
        if (counter == 0) {
            label.add(home.home_panel);
            label.remove(wel);
            label.revalidate();
            frame.repaint();
            label2.setVisible(true);
            timer.stop();
        } else {
            counter--;
        }
        if (e.getSource() == home.register) {
            label.add(new Registration());
        }
    }
}

