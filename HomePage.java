import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage implements ActionListener {
    JPanel home_panel;
    JButton register=new JButton("Register now "), login,student, About;
    Font font= new Font("Arial",Font.BOLD,15);
    static login_form lin;
    Registration reg;
    ImageIcon image1=new ImageIcon(new ImageIcon("register.png").getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
    ImageIcon image2=new ImageIcon(new ImageIcon("login.jpg").getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
    ImageIcon image3=new ImageIcon(new ImageIcon("studentrecord.png").getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
    ImageIcon image4=new ImageIcon(new ImageIcon("aboutus.png").getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
    AboutUs us;
    Student_record sd=  sd= new Student_record();
    HomePage(){
        try {
            home_panel = new JPanel();
            home_panel.setBounds(10, 90, 260, 460);
            home_panel.setBackground(new Color(0, 0, 0, 200));
            home_panel.setLayout(null);

            reg = new Registration();
            lin = new login_form();
            us = new AboutUs();


            register.setBounds(30, 20, 200, 80);
            register.setBackground(new Color(0, 120, 246));
            register.setForeground(Color.black);
            register.setOpaque(true);
            register.setFont(font);
            register.addActionListener(this);
            register.setFocusable(false);
            register.setIcon(image1);

            login = new JButton("login now ");
            login.setBounds(30, 120, 200, 80);
            login.setBackground(new Color(0, 120, 246));
            login.setForeground(Color.black);
            login.setOpaque(true);
            login.addActionListener(this);
            login.setFont(font);
            login.setIconTextGap(8);
            login.setFocusable(false);
            login.setIcon(image2);

            student = new JButton("Student Record ");
            student.setBounds(30, 220, 200, 80);
            student.setBackground(new Color(0, 120, 246));
            student.setForeground(Color.black);
            student.setOpaque(true);
            student.setFont(font);
            student.setFocusable(false);
            student.addActionListener(this);
            student.setIcon(image3);

            About = new JButton("About Us ");
            About.setBounds(30, 320, 200, 80);
            About.setBackground(new Color(0, 120, 246));
            About.setForeground(Color.black);
            About.setOpaque(true);
            About.setFont(font);
            About.addActionListener(this);
            About.setFocusable(false);
            About.setIconTextGap(8);
            About.setIcon(image4);

            home_panel.add(register);
            home_panel.add(login);
            home_panel.add(student);
            home_panel.add(About);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }

    public static void main(String[] args) {
        new HomePage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==register){
            Main_Frame.label.add(reg);
            reg.setVisible(true);
            us.setVisible(false);
            sd.setVisible(false);
            Main_Frame.label2.setVisible(false);
            lin.panel.setVisible(false);
            login.setEnabled(true);
            About.setEnabled(true);
            student.setEnabled(true);
            Main_Frame.label.repaint();
            register.setEnabled(false);
        }
        else if(e.getSource()==login){
            reg.setVisible(false);
            lin.panel.setVisible(true);
            register.setEnabled(true);
            About.setEnabled(true);
            student.setEnabled(true);
            Main_Frame.label2.setVisible(false);
            us.setVisible(false);
            sd.setVisible(false);
            Main_Frame.label.add(lin.panel);
            Main_Frame.label.repaint();
            login.setEnabled(false);
        }
        else if(e.getSource()==About){
            reg.setVisible(false);
            lin.panel.setVisible(false);
            register.setEnabled(true);
            login.setEnabled(true);
            Main_Frame.label2.setVisible(false);
            us.setVisible(true);
            sd.setVisible(false);
            student.setEnabled(true);
            Main_Frame.label.add(us);
            Main_Frame.label.repaint();
            About.setEnabled(false);
        }
        else if(e.getSource()==student){
            reg.setVisible(false);
            lin.panel.setVisible(false);
            register.setEnabled(true);
            login.setEnabled(true);
            us.setVisible(false);
            Main_Frame.label2.setVisible(false);
            sd.setVisible(true);
            student.setEnabled(false);
            Main_Frame.label.add(sd);
            Main_Frame.label.repaint();
            About.setEnabled(true);
        }
    }
}
