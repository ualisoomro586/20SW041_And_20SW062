import javax.crypto.spec.PSource;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.sql.*;
import java.util.Locale;

public class Registration extends JPanel implements FocusListener, ActionListener {
    String name, fatherName, Cnic, surname, District, phone;
    JTextField username, fathername, cnic, castt, districtt, contactNo;
    JPasswordField password;
    JButton submitButton, addButton, clearButton;
    Border line;
    Border empty;
    CompoundBorder border;
    String user="";
    String pass = "";
    ImageIcon image;
    JLabel img;
    File file;
    String imgPath;

    Registration() {
        setBounds(300, 90, 550, 490);
        setBackground(new Color(2, 0, 0, 200));
        setLayout(null);

        JLabel heading = new JLabel("Registration Form");
        heading.setForeground(new Color(220, 220, 220));
        heading.setBounds(85, 10, 300, 50);
        heading.setFocusable(true);
        heading.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 25));
        add(heading);

        img = new JLabel("");
        img.setForeground(Color.WHITE);
        img.setBackground(Color.red);
        img.setOpaque(true);
        img.setIcon(new ImageIcon(new ImageIcon("dp.jpg").getImage().getScaledInstance(140,170,Image.SCALE_DEFAULT)));
        img.setBounds(370, 80, 140, 170);
        add(img);

        addButton = new JButton("Select Image");
        addButton.setBounds(370, 255, 140, 20);
        addButton.setFocusable(false);
        addButton.setFont(new Font("Arial", Font.BOLD, 12));
        addButton.addActionListener(this);
        addButton.setBackground(new Color(51, 153, 255));
        add(addButton);

        JLabel userName = new JLabel("Name");
        userName.setBounds(30, 70, 300, 50);
        userName.setForeground(new Color(220, 220, 220));
        userName.setFont(new Font("Arial", Font.BOLD, 16));
        add(userName);

        line = BorderFactory.createLineBorder(Color.GRAY, 2);
        empty = BorderFactory.createEmptyBorder(0, 5, 00, 10);
        border = new CompoundBorder(line, empty);

        username = new JTextField();
        username.setBounds(30, 110, 300, 30);
        username.setFont(new Font("Arial", Font.PLAIN, 16));
        username.setText("Enter Name");
        username.setForeground(new Color(150, 150, 150));
        username.setBackground(new Color(220, 220, 220));
        username.setBorder(border);
        username.addFocusListener(this);
        add(username);

        JLabel fatherName = new JLabel("Father's Name");
        fatherName.setBounds(30, 130, 300, 50);
        fatherName.setForeground(new Color(220, 220, 220));
        fatherName.setFont(new Font("Arial", Font.BOLD, 16));
        add(fatherName);

        fathername = new JTextField();
        fathername.setBounds(30, 170, 300, 30);
        fathername.setFont(new Font("Arial", Font.PLAIN, 16));
        fathername.setText("Enter Your Father's Name");
        fathername.setForeground(new Color(150, 150, 150));
        fathername.setBackground(new Color(220, 220, 220));
        fathername.setBorder(border);
        fathername.addFocusListener(this);
        add(fathername);

        JLabel cNIc = new JLabel("CNIC");
        cNIc.setBounds(30, 190, 300, 50);
        cNIc.setForeground(new Color(220, 220, 220));
        cNIc.setFont(new Font("Arial", Font.BOLD, 16));
        add(cNIc);

        cnic = new JTextField();
        cnic.setBounds(30, 230, 300, 30);
        cnic.setFont(new Font("Arial", Font.PLAIN, 16));
        cnic.setText("Format: xxxxx-xxxxxxxx-x");
        cnic.setForeground(new Color(150, 150, 150));
        cnic.setBackground(new Color(220, 220, 220));
        cnic.setBorder(border);
        cnic.addFocusListener(this);
        add(cnic);

        JLabel cast = new JLabel("Surname");
        cast.setBounds(30, 250, 300, 50);
        cast.setForeground(new Color(220, 220, 220));
        cast.setFont(new Font("Arial", Font.BOLD, 16));
        add(cast);

        castt = new JTextField();
        castt.setBounds(30, 290, 300, 30);
        castt.setFont(new Font("Arial", Font.PLAIN, 16));
        castt.setText("Enter Your Surname");
        castt.setForeground(new Color(150, 150, 150));
        castt.setBackground(new Color(220, 220, 220));
        castt.setBorder(border);
        castt.addFocusListener(this);
        add(castt);

        JLabel district = new JLabel("District");
        district.setBounds(30, 310, 300, 50);
        district.setForeground(new Color(220, 220, 220));
        district.setFont(new Font("Arial", Font.BOLD, 16));
        add(district);

        districtt = new JTextField();
        districtt.setBounds(30, 350, 300, 30);
        districtt.setFont(new Font("Arial", Font.PLAIN, 16));
        districtt.setText("Enter Your District");
        districtt.setForeground(new Color(150, 150, 150));
        districtt.setBackground(new Color(220, 220, 220));
        districtt.setBorder(border);
        districtt.addFocusListener(this);
        add(districtt);

        JLabel contact = new JLabel("Contact");
        contact.setBounds(30, 370, 300, 50);
        contact.setForeground(new Color(220, 220, 220));
        contact.setFont(new Font("Arial", Font.BOLD, 16));
        add(contact);

        contactNo = new JTextField();
        contactNo.setBounds(30, 410, 300, 30);
        contactNo.setFont(new Font("Arial", Font.PLAIN, 16));
        contactNo.setText("Format: 92xxxxxxxxxx");
        contactNo.setForeground(new Color(150, 150, 150));
        contactNo.setBackground(new Color(220, 220, 220));
        contactNo.setBorder(border);
        contactNo.addFocusListener(this);
        add(contactNo);

        submitButton = new JButton("Submit");
        submitButton.setFocusable(false);
        submitButton.setFont(new Font("Arial", Font.BOLD, 12));
        submitButton.setBounds(440, 450, 80, 30);
        submitButton.setBackground(new Color(51, 153, 255));
        submitButton.addActionListener(this);
        add(submitButton);

        clearButton = new JButton("Clear");
        clearButton.setFocusable(false);
        clearButton.setFont(new Font("Arial", Font.BOLD, 12));
        clearButton.setBounds(350, 450, 80, 30);
        clearButton.setBackground(new Color(51, 153, 255));
        clearButton.addActionListener(this);
        add(clearButton);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == username || e.getSource() == fathername
                || e.getSource() == cnic || e.getSource() == contactNo
                || e.getSource() == districtt || e.getSource() == castt) {
            line = BorderFactory.createLineBorder(Color.BLACK, 2);
            empty = BorderFactory.createEmptyBorder(0, 5, 00, 10);
            border = new CompoundBorder(line, empty);
        }
        if (e.getSource() == username) {
            username.setForeground(Color.BLACK);
            username.setBorder(border);
            if (username.getText().equals("Enter Name")) {
                username.setText("");
            }
        }
        if (e.getSource() == fathername) {
            fathername.setForeground(Color.BLACK);
            fathername.setBorder(border);
            if(fathername.getText().equals("Enter Your Father's Name"))
                fathername.setText("");
        }
        if (e.getSource() == cnic) {
            cnic.setForeground(Color.BLACK);
            cnic.setBorder(border);
            if(cnic.getText().equals("Format: xxxxx-xxxxxxxx-x")){
            cnic.setText("");
            }
        }
        if (e.getSource() == castt) {
            castt.setForeground(Color.BLACK);
            castt.setBorder(border);
            if(castt.getText().equals("Enter Your Surname")){
            castt.setText("");
            }
        }
        if (e.getSource() == districtt) {
            districtt.setForeground(Color.BLACK);
            districtt.setBorder(border);
            if(districtt.getText().equals("Enter Your District"))
            districtt.setText("");
        }
        if (e.getSource() == contactNo) {
            contactNo.setForeground(Color.BLACK);
            contactNo.setBorder(border);
            if(contactNo.getText().equals("Format: 92xxxxxxxxxx")) {
                contactNo.setText("");
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == username || e.getSource() == fathername
                || e.getSource() == cnic || e.getSource() == contactNo
                || e.getSource() == districtt || e.getSource() == castt) {
            line = BorderFactory.createLineBorder(Color.GRAY, 2);
            empty = BorderFactory.createEmptyBorder(0, 5, 00, 10);
            border = new CompoundBorder(line, empty);
        }
        if (e.getSource() == username) {
            username.setBorder(border);
        }
        if (e.getSource() == fathername) {
            fathername.setBorder(border);
        }
        if (e.getSource() == cnic) {
            cnic.setBorder(border);
        }
        if (e.getSource() == castt) {
            castt.setBorder(border);
        }
        if (e.getSource() == districtt) {
            districtt.setBorder(border);
        }
        if (e.getSource() == contactNo) {
            contactNo.setBorder(border);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== addButton){
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));// this will save current path
            // in current project
            int response= chooser.showOpenDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                file= new File(chooser.getSelectedFile().getAbsolutePath());
                image = new ImageIcon(new ImageIcon(file.toString()).getImage().getScaledInstance(140,170,Image.SCALE_DEFAULT));
                img.setIcon(image);
                imgPath = chooser.getSelectedFile().getAbsolutePath();
                imgPath=imgPath.replace("\\","\\\\");

            }
        }
        if (e.getSource() == submitButton) {
            name = username.getText();
            name = name.trim();
            fatherName = fathername.getText();
            Cnic = cnic.getText();
            surname = castt.getText();
            District = districtt.getText();
            phone = contactNo.getText();

            boolean isCnicCorrect = false;
            boolean isPhoneCorrect = false;
            boolean isProfileSelected = true;
            if(file==null){
                isProfileSelected = false;
            }

            if(Cnic.charAt(5) == '-' && Cnic.charAt(13) == '-') {
                isCnicCorrect = true;
            }
            if(phone.charAt(0) == '9' && phone.charAt(1) == '2' && phone.length()==12){
                isPhoneCorrect = true;
            }
            if (name.equals("") || name.equals("Enter Name")||fatherName.equals("")||fatherName.equals("Enter Your Father's Name")
                    ||Cnic.equals("")||Cnic.equals("Format: xxxxx-xxxxxxxx-x")||surname.equals("Enter Your Surname")
                     ||surname.equals("")||District.equals("")||District.equals("Enter Your District")||District.equals("")
                         ||phone.equals("")||phone.equals("Format: 92xxxxxxxxxx")) {
                JOptionPane.showMessageDialog(null, "Please Fill All Fields ","Warning",JOptionPane.WARNING_MESSAGE);
            }
            else if (!isCnicCorrect){
                JOptionPane.showMessageDialog(null, "Invalid CNIC","Warning",JOptionPane.WARNING_MESSAGE);
            }
            else if (!isPhoneCorrect){
                JOptionPane.showMessageDialog(null, "Invalid Phone Number","Warning",JOptionPane.WARNING_MESSAGE);
            }
            else if(!isProfileSelected){
                JOptionPane.showMessageDialog(null, "Please Select Image","Warning",JOptionPane.WARNING_MESSAGE);
            }
            else{
                try {
                    user=Cnic;
                    user = user.toLowerCase(Locale.ROOT);
                    pass+=name.charAt(0);
                    pass+=name.charAt(1);
                    pass+=name.charAt(2);
                    pass+=Cnic.charAt(0);
                    pass+=Cnic.charAt(1);
                    pass+=Cnic.charAt(2);
                    pass+=Cnic.charAt(3);
                    pass+=Cnic.charAt(4);
                    pass = pass.toLowerCase(Locale.ROOT);
                    if(pass.length()>8){
                        JOptionPane.showMessageDialog(null,"Soory we can not process your request.\t 1st clear All data than Try Again");
                    }
                    else{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project",
                            "root", "root586");
                    Statement st = con.createStatement();
                    st.execute("insert into Candidates(Name,FatherName,Cnic,Surname,District,Contact,username,password,Image) values('" + name + "','" + fatherName + "','" + Cnic + "','" + surname + "','" + District + "','" + phone + "','" + user + "','" + pass + "','"+imgPath+"')");
                    JOptionPane.showMessageDialog(null, "Registration Successful ");
                    st.close();

                    JOptionPane.showMessageDialog(null,"Your user name is: "+user+"\nYour password is :"+pass.toString());
                    Main_Frame.label.removeAll();
                    Main_Frame.label.validate();
                    Main_Frame.label.add(new HomePage().home_panel);
                    Main_Frame.label.add(HomePage.lin.panel);
                    HomePage.lin.panel.setVisible(true);
                    Main_Frame.label.add(Main_Frame.logoimage);
                    this.setVisible(false);
                    Main_Frame.label.repaint();
                    }
                } catch (Exception a) {
                    String exept= " Cnic Already registered";
                    JOptionPane.showMessageDialog(null, exept, "error", JOptionPane.ERROR_MESSAGE);

                }
            }
        }
        else if (e.getSource()==clearButton){
            username.setText("");
            fathername.setText("");
            castt.setText("");
            cnic.setText("");
            districtt.setText("");
            contactNo.setText("");
        }
    }
}
