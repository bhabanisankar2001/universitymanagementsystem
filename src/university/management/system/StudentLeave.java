package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.awt.event.*;


public class StudentLeave extends JFrame implements ActionListener {
    JLabel heading,lrollno,ldate,lduration;
    JTextField tdate;
    Choice crollno,cduration;
    JButton submit,cancel;
    StudentLeave(){
        heading=new JLabel("Apply Student Leave");
        heading.setBounds(40,20,200,30);
        heading.setFont(new Font("serif",Font.BOLD,20));
        add(heading);

        lrollno= new JLabel("Search by Roll Number");
        lrollno.setBounds(60, 100, 150, 20);
        add(lrollno);

        crollno = new Choice();
        crollno.setBounds(60, 130, 150, 20);
        add(crollno);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                crollno.add(rs.getString("rollno"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        ldate=new JLabel("Date");
        ldate.setBounds(60,160,200,20);
        ldate.setFont(new Font("serif",Font.BOLD,15));
        add(ldate);

        tdate=new JTextField();
        tdate.setBounds(60,190,150,20);
        add(tdate);

        lduration=new JLabel("Time Duration");
        lduration.setBounds(60,220,100,20);
        lduration.setFont(new Font("serif",Font.BOLD,15));
        add(lduration);

        cduration=new Choice();
        cduration.setBounds(60,250,150,20);
        cduration.add("Full Day");
        cduration.add("Half Day");
        add(cduration);

        submit = new JButton("Submit");
        submit.setBounds(60, 290, 80, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 10));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(145, 290, 80, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 10));
        add(cancel);

        setSize(500,450);
        setLayout(null);
        setLocation(550,100);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
          if(ae.getSource()==submit)
          {
              String rollno=crollno.getSelectedItem();
              String date=tdate.getText();
              String duration=cduration.getSelectedItem();
              String query="insert into studentleave values('"+rollno+"','"+date+"','"+duration+"')";
             try{
              Conn c=new Conn();
              c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null,"student leave details inserted successfully");
              setVisible(false);
             }catch (Exception e)
             {
                 e.printStackTrace();
             }
          }
          else {
              setVisible(false);
          }
    }


    public static void main(String[] args) {
new StudentLeave();
    }
}
