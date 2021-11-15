import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.*;
public class Test_instructions implements ActionListener {
    JPanel test_panel;
    JLabel instructions,label;
    JButton start;
    Border border2= BorderFactory.createLineBorder(Color.blue,2);
    Test_instructions(){
        JFrame frame =new JFrame();
        frame.setSize(1100,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        test_panel = new JPanel();
        test_panel.setBackground(new Color(2, 0, 0));
        test_panel.setBounds(400, 90, 300, 450);
        test_panel.setLayout(null);
        test_panel.setBorder(border2);

        instructions= new JLabel();
        label= new JLabel("Instructions for test");
        label.setForeground(Color.red);
        label.setFont(new Font("Arial",Font.BOLD,20));
        label.setBounds(50,10,200,20);

        instructions.setText("<html><br/>Before starting the test please read instructions carefully"+
                    "<br/><br/>1.Each Question carries 1 marks <br/><br/>2.You have 10 minutes to attempt All questions "+
                    "<br/><br/>3.Please select option carefully once you select option it will be consid final"+
                    "answer <br/><br/>4.If you complete your test don't forgot to submit the test"+
                    "<br/><br/>5.Read Question carefully <br/><br/>6.There is Skip button you can Skip Questions</html>");
        instructions.setFont(new Font("Arial",Font.BOLD,15));
        instructions.setForeground(Color.white);
        instructions.setBackground(new Color(2,0,0,100));
        instructions.setBounds(0,20,300,400);

        start= new JButton("Start Test");
        start.setFont(new Font("Arial",Font.BOLD,20));
        start.setBackground(new Color(0,120,246));
        start.setForeground(Color.white);
        start.setBounds(150,400,130,30);
        start.setFocusable(false);
        start.addActionListener(this);

        test_panel.add(label);
        test_panel.add(instructions);
        test_panel.add(start);


    }
    public static void main(String[] args){
        new Test_instructions();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==start){
            Main_Frame.label.removeAll();
            Main_Frame.label.validate();
           // Main_Frame.label.add(new HomePage().home_panel);
            Main_Frame.label.add(new Test_Page().panel1);
          ///  Main_Frame.label.add(Main_Frame.logoimage);
            Main_Frame.label.repaint();

        }
    }
}
