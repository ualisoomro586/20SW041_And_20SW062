import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login_form implements FocusListener, ActionListener {
    JFrame frame;
    JPanel panel;
    JLabel back,login,label1,label2;
    JButton button,show_button;
    static String user="";
    String getuser;
    boolean isShowed;
    JTextField t1;
    JPasswordField t2;

    Font font= new Font("Arial",Font.BOLD,20);
    Border border= BorderFactory.createLineBorder(Color.black,2);
    Border border1=  BorderFactory.createLineBorder(Color.blue,2);
    Border line;
    Border empty;
    CompoundBorder borderr;

    ImageIcon imageIcon= new ImageIcon(new ImageIcon("pic.jpg").getImage().getScaledInstance(1100,600,Image.SCALE_DEFAULT));
    ImageIcon imageshow= new ImageIcon(new ImageIcon("show.png").getImage().getScaledInstance(26,26,Image.SCALE_DEFAULT));
    ImageIcon imagehide= new ImageIcon(new ImageIcon("hide.png").getImage().getScaledInstance(26,26,Image.SCALE_DEFAULT));

    public login_form(){
        frame= new JFrame("Login form");
        frame.setSize(1100,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        line = BorderFactory.createLineBorder(Color.GRAY,2);
        empty = BorderFactory.createEmptyBorder(0,5,00,10);
        borderr = new CompoundBorder(line, empty);

        back= new JLabel();
        back.setSize(1100,600);
        back.setIcon(imageIcon);

        panel =  new JPanel();
        panel.setBounds(280,100,600,400);
        panel.setBackground(new Color(2, 0, 0, 200));
        panel.setLayout(null);
        panel.setBorder(border1);

        login= new JLabel("LOGIN");
        login.setBounds(260,120,100,20);
        login.setFocusable(true);
        login.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 25));
        login.setForeground(Color.red);

        label1= new JLabel("Username");
        label1.setBounds(180,160,120,30);
        label1.setForeground(new Color(220, 220, 220));
        label1.setFont(new Font("Arial", Font.BOLD, 16));

        t1= new JTextField();
        t1.setBounds(180,190,220,30);
        t1.setFont(new Font("Arial", Font.PLAIN, 16));
        t1.setText("Enter Username");
        t1.setForeground(new Color(150, 150, 150));
        t1.setBackground(new Color(220, 220, 220));
        t1.setBorder(borderr);
        t1.addFocusListener(this);

        label2= new JLabel("Password");
        label2.setBounds(180,230,120,30);
        label2.setForeground(new Color(220, 220, 220));
        label2.setFont(new Font("Arial", Font.BOLD, 16));

        show_button= new JButton();
        show_button.setBounds(185,2,30,26);
        show_button.setFocusable(false);
        show_button.setBackground(new Color(220, 220, 220));
        show_button.setBorder(BorderFactory.createEmptyBorder());
        show_button.setIcon(imageshow);
        isShowed = false;

        t2= new JPasswordField();
        t2.setBounds(180,260,220,30);
        t2.setFont(new Font("Arial", Font.PLAIN, 16));
        t2.setText("Enter Password");
        t2.setForeground(new Color(150, 150, 150));
        t2.setBackground(new Color(220, 220, 220));
        t2.setBorder(borderr);
        t2.setLayout(null);
        t2.addFocusListener(this);
        t2.setEchoChar((char)0);
        t2.add(show_button);

        button= new JButton("LOGIN");
        button.setBounds(290,320,100,25);
        button.setFocusable(false);
        button.setFont(font);
        button.setForeground(Color.white);
        button.addActionListener(this);
        button.setBackground(new Color(0,120,246));

        panel.add(login);
        panel.add(label1);
        panel.add(t1);
        panel.add(label2);
        panel.add(t2);
        panel.add(button);



    }

    @Override
    public void focusGained(FocusEvent e) {
        if(e.getSource()==t1 || e.getSource() == t2)
        {
            line = BorderFactory.createLineBorder(Color.BLACK,2);
            empty = BorderFactory.createEmptyBorder(0,5,00,10);
            borderr = new CompoundBorder(line, empty);
        }
        if(e.getSource()==t1){
            t1.setForeground(Color.BLACK);
            if(t1.getText().equals("Enter Username"))
                t1.setText("");
            t1.setBorder(borderr);
        }
        if(e.getSource()==t2){
            t2.setForeground(Color.BLACK);
            if(t2.getText().equals("Enter Password"))
                t2.setText("");
            t2.setBorder(borderr);
            t2.setEchoChar('*');
            show_button.addActionListener(this);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button){
            try {
                user= t1.getText();
                String pass=t2.getText();
                 getuser="";
                String getpass="";

                Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root586");
                Statement stm= conn.createStatement();
                ResultSet set= stm.executeQuery("select username,password from candidates where Cnic='"+user+"'");
                System.out.println("user is "+user);

                while (set.next()){
                     getuser= set.getString("username");
                     getpass = set.getString("password");
                }
                if(user.equals(getuser) && pass.equals(getpass)){
                    JOptionPane.showMessageDialog(null,"Login Successful ");
                    Main_Frame.label.removeAll();
                    Main_Frame.label.validate();
                    Main_Frame.label.add(new Test_instructions().test_panel);
                    Main_Frame.label.add(Main_Frame.logoimage);
                    Main_Frame.label.repaint();

                }
                else{
                    JOptionPane.showMessageDialog(null,"invailid username or password","error",JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (Exception a){
                JOptionPane.showMessageDialog(null,a);
            }
        }










        if(e.getSource()==show_button){
            if(isShowed){
                show_button.setIcon(imageshow);
                isShowed = false;
                t2.setEchoChar('*');
            }
            else{
                isShowed = true;
                show_button.setIcon(imagehide);
                t2.setEchoChar((char) 0);
            }
        }
    }
}
