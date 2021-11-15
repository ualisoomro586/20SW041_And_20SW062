import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.sql.*;

public class Student_record extends JPanel {
    JTable tabel;
    JScrollPane pane;
    TableColumnModel model;
    Connection con;
    String  row="";
    String[] name,father,cnic,surname,district,contact,depart;
    String[] Score;
    String[] cpn;
    int number;
    String [][] data;
    String[][] data2;
    Student_record(){
        setSize(800,490);
        setBounds(300, 90, 650, 450);
        name = new String[25];
        father = new String[25];
        cnic = new String[25];
        surname = new String[25];
        district = new String[25];
        contact = new String[25];
        depart = new String[25];
        Score = new String[25];
        cpn = new String[25];

        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root586");
            Statement stm= con.createStatement();
            ResultSet set= stm.executeQuery("select* from candidates");

            while(set.next()){
                name[number]=set.getString("Name");
                father[number]=set.getString("FatherName");
                cnic[number]=set.getString("Cnic");
                surname[number]=set.getString("Surname");
                district[number]=set.getString("District");
                contact[number]=set.getString("Contact");
                Score[number]=String.valueOf(set.getInt("TestScore"));
                cpn[number]=String.valueOf(set.getDouble("Cpn"));
                depart[number]=set.getString("DisciplineAwarded");
                ++number;
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }

        String[] coulums={"S.No","Name","Father's Name","Cnic","Surname","District","Contact","Score","CPN"};
        data =new String [25][9];
        for(int i=0; i<25; i++){
            if(i<=number)
                data[i][0]= ""+i;
            data[i][1]= name[i];
            data[i][2]= father[i];
            data[i][3]= cnic[i];
            data[i][4]= surname[i];
            data[i][5]= district[i];
            data[i][6]= contact[i];
            data[i][7]= Score[i];
            data[i][8]= cpn[i];
        }
        tabel= new JTable(data,coulums){
            @Override
            public boolean isCellEditable(int data, int colums) {
                return false;
            }
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component comp = super.prepareRenderer(renderer, row, column);
                Color alternateColor = new Color(200, 201, 210);
                Color whiteColor = Color.WHITE;
                if(!comp.getBackground().equals(getSelectionBackground())) {
                    Color c = (row % 2 == 0 ? alternateColor : whiteColor);
                    comp.setBackground(c);
                    c = null;
                }
                return comp;
            }
        };

        model=tabel.getColumnModel();
        model.getColumn(1).setPreferredWidth(100);
        model.getColumn(0).setPreferredWidth(40);
        model.getColumn(2).setPreferredWidth(150);
        model.getColumn(3).setPreferredWidth(160);
        model.getColumn(4).setPreferredWidth(120);
        model.getColumn(6).setPreferredWidth(140);
        tabel.setPreferredScrollableViewportSize(new Dimension(630,400));

        pane= new JScrollPane(tabel);

        add(pane);

    }

    public static void main(String[] args) {
        new Student_record();
    }
}
