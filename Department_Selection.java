import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.*;
public class Department_Selection extends JPanel implements ActionListener {
    JFrame frame= new JFrame();
    JPanel panel;
    JRadioButton civil, sw, electrical, mechanical, cs, electronics, biomedical, telecom,
                 industrial, textile, pg, mining;
    ButtonGroup firstCategory, secondCategoy, thirdCategory;
    JButton nextButton;
    String first="",second="",third="";
    Department_Selection(){

        frame = new JFrame();
        frame.setSize(1100,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        setBounds(270,90,600,450);
        setBackground(new Color(220,220,220));
        setLayout(null);

        JLabel logo = new JLabel("Department Selection");
        logo.setHorizontalTextPosition(JLabel.RIGHT);
        logo.setFont(new Font("Arial",Font.BOLD | Font.ITALIC, 40));
        logo.setBounds(10,0,600,100);
        logo.setIcon(new ImageIcon(new ImageIcon("logo.png").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT)));

        panel = new JPanel();
        panel.setBounds(0,0,600,100);
        panel.setBackground(new Color(51,153,255));
        panel.setLayout(null);
        panel.add(logo);
        add(panel);

        JLabel head = new JLabel("Note: Select One Department from each category..");
        head.setFont(new Font("Arial",Font.ITALIC, 20));
        head.setBounds(10,80,600,100);
        add(head);

        JLabel first = new JLabel("First Category");
        first.setFont(new Font("Arial",Font.BOLD, 16));
        first.setBounds(50,120,600,100);
        add(first);

        civil = new JRadioButton("Civil");
        civil.setFont(new Font("Arial", Font.PLAIN,14));
        civil.setBackground(new Color(220,220,220));
        civil.setFocusable(false);
        civil.setActionCommand("Civil");
        civil.setBounds(50,190,100,20);

        sw = new JRadioButton("Software");
        sw.setFont(new Font("Arial", Font.PLAIN,14));
        sw.setBackground(new Color(220,220,220));
        sw.setFocusable(false);
        sw.setActionCommand("Software");
        sw.setBounds(50,220,100,20);

        electrical = new JRadioButton("Electrical");
        electrical.setFont(new Font("Arial", Font.PLAIN,14));
        electrical.setBackground(new Color(220,220,220));
        electrical.setFocusable(false);
        electrical.setActionCommand("Electrical");
        electrical.setBounds(50,250,100,20);

        mechanical = new JRadioButton("Mechanical");
        mechanical.setFont(new Font("Arial", Font.PLAIN,14));
        mechanical.setBackground(new Color(220,220,220));
        mechanical.setFocusable(false);
        mechanical.setActionCommand("Mechanical");
        mechanical.setBounds(50,280,100,20);

        firstCategory = new ButtonGroup();
        firstCategory.add(civil);
        firstCategory.add(sw);
        firstCategory.add(electrical);
        firstCategory.add(mechanical);

        add(civil);
        add(sw);
        add(electrical);
        add(mechanical);

        JLabel second = new JLabel("Second Category");
        second.setFont(new Font("Arial",Font.BOLD, 16));
        second.setBounds(250,120,600,100);
        add(second);

        cs = new JRadioButton("Computer System");
        cs.setFont(new Font("Arial", Font.PLAIN,14));
        cs.setBackground(new Color(220,220,220));
        cs.setFocusable(false);
        cs.setActionCommand("Computer System");
        cs.setBounds(250,190,200,20);

        biomedical = new JRadioButton("Bio Medical");
        biomedical.setFont(new Font("Arial", Font.PLAIN,14));
        biomedical.setBackground(new Color(220,220,220));
        biomedical.setFocusable(false);
        biomedical.setActionCommand("Bio Medical");
        biomedical.setBounds(250,220,100,20);

        electronics = new JRadioButton("Electronics");
        electronics.setFont(new Font("Arial", Font.PLAIN,14));
        electronics.setBackground(new Color(220,220,220));
        electronics.setFocusable(false);
        electronics.setActionCommand("Electronics");
        electronics.setBounds(250,250,100,20);

        telecom = new JRadioButton("Telecommunication");
        telecom.setFont(new Font("Arial", Font.PLAIN,14));
        telecom.setBackground(new Color(220,220,220));
        telecom.setFocusable(false);
        telecom.setActionCommand("Telecommunication");
        telecom.setBounds(250,280,200,20);

        secondCategoy = new ButtonGroup();
        secondCategoy.add(cs);
        secondCategoy.add(electronics);
        secondCategoy.add(biomedical);
        secondCategoy.add(telecom);

        add(cs);
        add(electronics);
        add(biomedical);
        add(telecom);

        JLabel third = new JLabel("Third Category");
        third.setFont(new Font("Arial",Font.BOLD, 16));
        third.setBounds(450,120,600,100);
        add(third);

        pg = new JRadioButton("Petroleum And Gas");
        pg.setFont(new Font("Arial", Font.PLAIN,14));
        pg.setBackground(new Color(220,220,220));
        pg.setFocusable(false);
        pg.setActionCommand("Petroleum And Gas");
        pg.setBounds(450,190,200,20);

        industrial = new JRadioButton("Industrial");
        industrial.setFont(new Font("Arial", Font.PLAIN,14));
        industrial.setBackground(new Color(220,220,220));
        industrial.setFocusable(false);
        industrial.setActionCommand("Industrial");
        industrial.setBounds(450,220,100,20);

        textile = new JRadioButton("Textile");
        textile.setFont(new Font("Arial", Font.PLAIN,14));
        textile.setBackground(new Color(220,220,220));
        textile.setFocusable(false);
        textile.setActionCommand("Textile");
        textile.setBounds(450,250,100,20);

        mining = new JRadioButton("Mining");
        mining.setFont(new Font("Arial", Font.PLAIN,14));
        mining.setBackground(new Color(220,220,220));
        mining.setFocusable(false);
        mining.setActionCommand("Mining");
        mining.setBounds(450,280,100,20);

        thirdCategory = new ButtonGroup();
        thirdCategory.add(industrial);
        thirdCategory.add(textile);
        thirdCategory.add(pg);
        thirdCategory.add(mining);

        add(industrial);
        add(textile);
        add(pg);
        add(mining);

        nextButton = new JButton("Next");
        nextButton.setFocusable(false);
        nextButton.setFont(new Font("Arial", Font.BOLD, 12));
        nextButton.setBounds(450,350,80,30);
        nextButton.setBackground(new Color(51,153,255));
        nextButton.addActionListener(this);
        add(nextButton);

       /* frame.add(this);
        frame.setVisible(true);*/
    }

    public static void main(String[] args) {
        new Department_Selection();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()== nextButton){
            if(civil.isSelected()){
                first=civil.getText();
            }
            else if(sw.isSelected()){
                first=sw.getText();
            }
            else if(electrical.isSelected()){
                first=electrical.getText();
            }
            else if(mechanical.isSelected()){
                first=mechanical.getText();
            }

             if(cs.isSelected()){
                second=cs.getText();
            }
            else if(biomedical.isSelected()){
                second=biomedical.getText();
            }
            else if(electronics.isSelected()){
                second=electronics.getText();
            }
            else if(telecom.isSelected()){
                second=telecom.getText();
            }

             if(pg.isSelected()){
                third=pg.getText();
            }
            else if(textile.isSelected()){
                third=textile.getText();
            }
            else if(industrial.isSelected()){
                third=industrial.getText();
            }
            else if(mining.isSelected()){
                third=mining.getText();
            }

            if(first.equals("")||second.equals("")||third.equals("")){
                JOptionPane.showMessageDialog(null,"Please select disciplines from All Categories ","Warnig",JOptionPane.WARNING_MESSAGE);
            }
            else {
                try{
                    Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root586");
                    Statement stm= conn.createStatement();
                    stm.execute("update candidates set FirstChoice='"+first+"',SecondChoice='"+second+"',ThirdChoice='"+third+"' WHERE Cnic='"+login_form.user+"'");
                    stm.close();
                }
                catch (Exception a){
                    JOptionPane.showMessageDialog(null,a);
                }
                Main_Frame.label.removeAll();
                Main_Frame.label.add(new Admission_letter().Admission_panel);
                Main_Frame.label.add(new Admission_letter().main_menu);
                Main_Frame.label.add(new Admission_letter().Exit);
                this.setVisible(false);
                Main_Frame.label.repaint();
            }
        }
    }
}
