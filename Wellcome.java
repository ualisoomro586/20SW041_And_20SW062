import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.Timer;

public class Wellcome extends JPanel{
    Timer timer;
    Wellcome(){
        setBounds(350,90,500,430);
        setBackground(Color.BLACK);
        timer = new Timer();
        intro();
    }
    public  void intro(){
        JLabel l = new JLabel();
        l.setBounds(50,240,500,450);
        l.setIcon(new ImageIcon(new ImageIcon("1.png").getImage().getScaledInstance(500,450,Image.SCALE_DEFAULT)));
        add(l);
        TimerTask t1 = new TimerTask() {
            @Override
            public void run() {
                l.setIcon(new ImageIcon(new ImageIcon("2.png").getImage().getScaledInstance(500,450,Image.SCALE_DEFAULT)));
            }
        };
        TimerTask t2 = new TimerTask() {
            @Override
            public void run() {
                l.setIcon(new ImageIcon(new ImageIcon("3.png").getImage().getScaledInstance(500,450,Image.SCALE_DEFAULT)));
            }
        };
        TimerTask t3 = new TimerTask() {
            @Override
            public void run() {
                l.setIcon(new ImageIcon(new ImageIcon("4.png").getImage().getScaledInstance(500,450,Image.SCALE_DEFAULT)));
            }
        };
        TimerTask t4 = new TimerTask() {
            @Override
            public void run() {
                l.setIcon(new ImageIcon(new ImageIcon("5.png").getImage().getScaledInstance(500,450,Image.SCALE_DEFAULT)));
            }
        };
        TimerTask t5 = new TimerTask() {
            @Override
            public void run() {
                l.setIcon(new ImageIcon(new ImageIcon("6.png").getImage().getScaledInstance(500,450,Image.SCALE_DEFAULT)));
            }
        };
        TimerTask t6 = new TimerTask() {
            @Override
            public void run() {
                l.setIcon(new ImageIcon(new ImageIcon("7.png").getImage().getScaledInstance(500,450,Image.SCALE_DEFAULT)));
            }
        };
        TimerTask t7 = new TimerTask() {
            @Override
            public void run() {
                l.setIcon(new ImageIcon(new ImageIcon("8.png").getImage().getScaledInstance(500,450,Image.SCALE_DEFAULT)));
            }
        };
        TimerTask t8 = new TimerTask() {
            @Override
            public void run() {
                l.setIcon(new ImageIcon(new ImageIcon("9.png").getImage().getScaledInstance(500,450,Image.SCALE_DEFAULT)));
            }
        };
        timer.schedule(t1, 1800);
        timer.schedule(t2, 2300);
        timer.schedule(t3, 2900);
        timer.schedule(t4, 3400);
        timer.schedule(t5, 3900);
        timer.schedule(t6, 4400);
        timer.schedule(t7, 4900);
        timer.schedule(t8, 5400);
    }
}
