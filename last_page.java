import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class last_page implements ActionListener {

    JPanel panel;
    JLabel  label1,label2;
    JButton select;
    boolean isPass = (Test_Page.score>=8);
    ImageIcon image;
    CPN cpn;

    last_page(){
        cpn = new CPN();
        panel= new JPanel();
        panel.setBounds(270,100,500,400);
        panel.setLayout(null);
        panel.setBackground(new Color(238,237,238));

        label1= new JLabel();
        label1.setBounds(0,0,500,250);

        label2= new JLabel("You have passed the test!");
        label2.setBounds(0,270,400,60);
        label2.setFont(new Font("Mv Boli",Font.BOLD,30));
        label2.setForeground(Color.BLACK);

        select= new JButton("NEXT");
        select.setBounds(330,340,150,40);
        select.setBackground(new Color(0,120,246));
        select.setForeground(Color.white);
        select.addActionListener(this);
        select.setFocusable(false);

        if(isPass) {
            image = new ImageIcon(new ImageIcon("congratulations.jpg").getImage().getScaledInstance(500, 250, Image.SCALE_DEFAULT));
        }
        else {
            image = new ImageIcon(new ImageIcon("fail.jpg").getImage().getScaledInstance(500, 250, Image.SCALE_DEFAULT));
            select.setText("EXIT");
            label2.setText("Oops! You haven't passed the test");
        }
        label1.setIcon(image);
        panel.add(label1);
        panel.add(label2);
        panel.add(select);
    }

    public static void main(String[] args) {
        new last_page();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==select){
            if(select.getText().equals("EXIT")){
                Main_Frame.frame.setVisible(false);
                Main_Frame.frame.dispose();
                System.exit(0);
            }
            else {
                Main_Frame.label.add(cpn.CPN_panel);
                cpn.CPN_panel.setVisible(true);
                panel.setVisible(false);
                Main_Frame.label.repaint();
            }
        }
    }
}
