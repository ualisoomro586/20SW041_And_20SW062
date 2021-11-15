import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
public class Instructions {
    JPanel instruction_panel;
    JLabel instruction_label,label;
    JCheckBox check;
    String n="";
    Border border = BorderFactory.createLineBorder(Color.blue,2);
    Instructions() {

        instruction_panel = new JPanel();
        instruction_panel.setBackground(new Color(2, 0, 0, 200));
        instruction_panel.setBounds(400, 100, 300, 400);
        instruction_panel.setLayout(null);
        instruction_panel.setBorder(border);

        label= new JLabel("Instructions");
        label.setBounds(100,0,150,20);
        label.setForeground(Color.RED);
        label.setFont(new Font("Mv Boli",Font.BOLD,20));

        instruction_label = new JLabel();
        instruction_label.setText("<html> Before proceeding to online admission form," +
                "you are advised to read the Guidelines, it will help you to fill the form properly.   <br/> " +
                "<br/>   1. Please Provide correct information otherwise your form will be rejected    <br/>" +
                "<br/>   2. If you have any Query Then you may Contact on helpdesk    <br/>" +
                "<br/>   3.Candidates may gate answer to their queries at frequently asked Question</html>");
        instruction_label.setFont(new Font("Arial", Font.BOLD, 15));
        instruction_label.setForeground(Color.white);
        instruction_label.setBounds(0,30,300,300);
        instruction_label.setOpaque(false);

        check= new JCheckBox("accept terms & conditions");
        check.setBounds(20,350,300,20);
        check.setFont(new Font("Arial",Font.BOLD,20));
        check.setOpaque(false);
        check.setFocusable(false);
        check.setForeground(Color.white);

        instruction_panel.add(label);
        instruction_panel.add(instruction_label);
        instruction_panel.add(check);

    }
    public static  void  main(String[] args){

    }
}
