import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.DriverManager;
import javax.swing.border.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

public class Admission_letter implements ActionListener {
    JFrame frame;
    JPanel Admission_panel;
    JLabel logo,uper,uper1,lower,date,Photo,data,congratulations,discipline,place,Rollno,Guardians,choice,signature;
    JLabel depart,city,rollno,father;
    DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDateTime date2 = LocalDateTime.now();
    Connection conn;
    ImageIcon image= new ImageIcon(new ImageIcon("muet-logo1.png").getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT));
    Border border = BorderFactory.createLineBorder(Color.black,2);
    String name,Fathername,Surname,Cnic,District,first,second,third,technology;
    Double Cpn;
    String FutherChoice="",imagepath="";
    File file;
    ImageIcon profile;
    JButton Print,main_menu,Exit;
    String dpt="20";
    Admission_letter(){
        try{

             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root586");
            Statement stm= conn.createStatement();
            ResultSet set =stm.executeQuery("select *from candidates where Cnic='"+login_form.user+"'");

            while(set.next()){
                name= set.getString("Name");Fathername=set.getString("FatherName");Surname=set.getString("Surname");
                Cnic= set.getString("Cnic");District= set.getString("District");first= set.getString("FirstChoice");
                second= set.getString("SecondChoice");third= set.getString("ThirdChoice");
                Cpn= set.getDouble("Cpn");
                imagepath=set.getString("Image");
                if(Cpn>70.0){
                    technology=first;
                    FutherChoice="NFC(No further Choice)";
                }
                else if(Cpn>60&&Cpn<=70){
                    technology=second;
                    FutherChoice=first;
                }
                else if(Cpn>40&&Cpn<=60){
                    technology=third;
                    FutherChoice= first+" and "+second;}

            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        try {
            Statement st= conn.createStatement();
            st.execute("update candidates set DisciplineAwarded='"+technology +"'where Cnic='"+login_form.user+"'");
     }
        catch(Exception a){
            JOptionPane.showMessageDialog(null,a);
        }

        file=new File(imagepath);
        profile= new ImageIcon(new ImageIcon(file.toString()).getImage().getScaledInstance(140,170,Image.SCALE_DEFAULT));

        frame = new JFrame();
        frame.setSize(1100, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        Admission_panel=  new JPanel();
        Admission_panel.setLayout(null);
        Admission_panel.setBounds(130,10,800,540);
        Admission_panel.setBackground(new Color(51,153,255));
        
        Print= new JButton("Print");
        Print.setBounds(830,570,100,30);
        Print.setFocusable(false);
        Print.setForeground(Color.BLACK);
        Print.setFont(new Font("Arial",Font.BOLD,14));
        Print.setBackground(Color.lightGray);
        Print.addActionListener(this);
        
        main_menu= new JButton("Main Menu");
        main_menu.setBounds(130,570,140,30);
        main_menu.setFocusable(false);
        main_menu.setForeground(Color.BLACK);
        main_menu.setFont(new Font("Arial",Font.BOLD,14));
        main_menu.setBackground(Color.green);
        main_menu.addActionListener(this);

        Exit= new JButton("Exit");
        Exit.setBounds(280,570,100,30);
        Exit.setFocusable(false);
        Exit.setForeground(Color.BLACK);
        Exit.setFont(new Font("Arial",Font.BOLD,14));
        Exit.setBackground(Color.RED);
        Exit.addActionListener(this);

        logo= new JLabel();
        logo.setBounds(20,20,80,80);
        logo.setIcon(image);

        uper= new JLabel();
        uper.setText("Mehran University Of Engineering & Technology, Jamshoro");
        uper.setBounds(200,20,500,80);
        uper.setFont(new Font("Arial",Font.BOLD,15));

        uper1= new JLabel();
        uper1.setText("Admission Session (2021-22)");
        uper1.setBounds(300,40,400,80);
        uper1.setFont(new Font("Arial",Font.BOLD,15));

        lower = new JLabel("Jamshoro-Sindh,Pakistan");
        lower.setBounds(320,70,400,60);
        lower.setFont(new Font("Arial",Font.BOLD,12));

         date= new JLabel();
         date.setText("Date: "+dft.format(date2));
         date.setBounds(600,100,400,30);
         date.setFont(new Font("Arial",Font.BOLD,12));

         Photo= new JLabel();
         Photo.setBounds(580,130,140,170);
         Photo.setBackground(Color.white);
         Photo.setOpaque(true);
         Photo.setBorder(border);
         Photo.setIcon(profile);

        data= new JLabel();
        data.setBounds(50,110,500,200);
        data.setFont(new Font("Arial",Font.PLAIN,15));
        data.setText("<html><pre>Name in Full:\t"+name+"<br/>Father's Name:\t"+Fathername+"<br/>Surname:\t"+Surname+"<br/>Cnic Number:\t"+Cnic+"<br/>District:\t"+District+"</pre></html>");

         congratulations= new JLabel();
         congratulations.setText("<html>Congratulations!<br/>You have been provisionally selected for admission BAHELOR OF ENGINEERING PROGRAM  " +
                 "in FIRST YEAR CLASS for academic session  (2021-22) under REGULAR SCHEME in the discipline </html>");
         congratulations.setFont(new Font("Arial",Font.PLAIN,12));
         congratulations.setBounds(50,280,750,100);

         discipline= new JLabel("DISCIPLINE AWARDED");
         discipline.setFont(new Font("Arial",Font.PLAIN,12));
         discipline.setBounds(50,360,200,20);

         depart=  new JLabel();
         depart.setText(""+technology);
         depart.setBounds(350,360,300,20);
         depart.setBorder(border);
         depart.setHorizontalAlignment(JLabel.CENTER);

        place= new JLabel("PLACE OF STUDY");
        place.setFont(new Font("Arial",Font.PLAIN,12));
        place.setBounds(50,390,200,20);

        city=  new JLabel();
        city.setText("Jamshoro");
        city.setBounds(350,390,300,20);
        city.setBorder(border);
        city.setHorizontalAlignment(JLabel.CENTER);
        if(technology.equals("Civil"))
            dpt+="CE01";
        if(technology.equals("Software"))
            dpt+="SW01";
        if(technology.equals("Electrical"))
            dpt+="EL01";
        if(technology.equals("Mechanical"))
            dpt+="ME01";
        if(technology.equals("Computer System"))
            dpt+="CS01";
        if(technology.equals("Bio Medical"))
            dpt+="BM01";
        if(technology.equals("Electronics"))
            dpt+="EE01";
        if(technology.equals("Telecommunication"))
            dpt+="TL01";
        if(technology.equals("Petroleum And Gas"))
            dpt+="PG01";
        if(technology.equals("Industrial"))
            dpt+="IN01";
        if(technology.equals("Textile"))
            dpt+="TE01";
        if(technology.equals("Mining"))
            dpt+="MN01";

        Rollno= new JLabel("ROLL NUMBER");
        Rollno.setFont(new Font("Arial",Font.PLAIN,12));
        Rollno.setBounds(50,420,200,20);

        rollno=  new JLabel();
        rollno.setText(dpt);
        rollno.setBounds(350,420,300,20);
        rollno.setBorder(border);
        rollno.setHorizontalAlignment(JLabel.CENTER);

        Guardians= new JLabel("GUARDIAN's NAME");
        Guardians.setFont(new Font("Arial",Font.PLAIN,12));
        Guardians.setBounds(50,450,200,20);

        father=  new JLabel();
        father.setText(""+Fathername);
        father.setBounds(350,450,300,20);
        father.setBorder(border);
        father.setHorizontalAlignment(JLabel.CENTER);

        choice= new JLabel();
        choice.setText("<html>MY further and final choices are as under;" + "<br/><br/>"+FutherChoice+"</html>");
        choice.setFont(new Font("Arial",Font.BOLD,13));
        choice.setBounds(50,480,400,50);

        signature= new JLabel();
        signature.setText("Signature of Candidate");
        signature.setBounds(600,500,200,20);


        Admission_panel.add(logo);
        Admission_panel.add(uper);
        Admission_panel.add(uper1);
        Admission_panel.add(lower);
        Admission_panel.add(date);
        Admission_panel.add(Photo);
        Admission_panel.add(data);
        Admission_panel.add(congratulations);
        Admission_panel.add(discipline);
        Admission_panel.add(depart);
        Admission_panel.add(place);
        Admission_panel.add(city);
        Admission_panel.add(Rollno);
        Admission_panel.add(rollno);
        Admission_panel.add(Guardians);
        Admission_panel.add(father);
        Admission_panel.add(choice);
        Admission_panel.add(signature);
        frame.add(Admission_panel);
    }
    public static void main(String[] args) {
        new Admission_letter();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

         if(e.getSource()==main_menu){
            Admission_panel.setVisible(false);
            Main_Frame.label.removeAll();
            Main_Frame.label.validate();
            Main_Frame.label.add(Main_Frame.logoimage);
            Main_Frame.label.add(new HomePage().home_panel);
            Main_Frame.label.repaint();
            main_menu.setVisible(false);
            Exit.setVisible(false);
        }
        else if(e.getSource()==Exit){
            System.exit(0);
        }

    }
}
