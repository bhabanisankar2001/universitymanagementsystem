package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Marks extends JFrame implements ActionListener {
    String roll;
    JLabel heading,subheading,lroll,lsemester,sub1,sub2,sub3,sub4,sub5;
    JButton back;
        Marks(String rollno)
        {
           this.roll=rollno;
           setSize(600,600);
           setLocation(100,50);
           setLayout(null);
           getContentPane().setBackground(Color.white);

           heading=new JLabel("University Of Technology");
           heading.setBounds(100,10,500,30);
           heading.setFont(new Font("serif",Font.BOLD,20));
           add(heading);

            subheading=new JLabel("Result Of Examinaiton 2024");
            subheading.setBounds(100,50,500,20);
            subheading.setFont(new Font("serif",Font.BOLD,20));
            add(subheading);

            lroll=new JLabel("Roll No "+roll);
            lroll.setBounds(60,100,500,20);
            lroll.setFont(new Font("serif",Font.PLAIN,18));
            add(lroll);

            lsemester=new JLabel("");
            lsemester.setBounds(60,130,500,20);
            lsemester.setFont(new Font("serif",Font.PLAIN,18));
            add(lsemester);



            sub1=new JLabel();
            sub1.setBounds(100,200,500,25);
            sub1.setFont(new Font("serif",Font.PLAIN,18));
            add(sub1);

            sub2=new JLabel();
            sub2.setBounds(100,230,500,25);
            sub2.setFont(new Font("serif",Font.PLAIN,18));
            add(sub2);

            sub3=new JLabel();
            sub3.setBounds(100,260,500,25);
            sub3.setFont(new Font("serif",Font.PLAIN,18));
            add(sub3);

            sub4=new JLabel();
            sub4.setBounds(100,290,500,25);
            sub4.setFont(new Font("serif",Font.PLAIN,18));
            add(sub4);

            sub5=new JLabel();
            sub5.setBounds(100,320,500,25);
            sub5.setFont(new Font("serif",Font.PLAIN,18));
            add(sub5);

            back=new JButton("Back");
            back.setBounds(400,500,100,30);
            back.setForeground(Color.white);
            back.setBackground(Color.black);
            back.addActionListener(this);
            add(back);
            try{
              Conn c=new Conn();
              ResultSet rs1=c.s.executeQuery("select * from subject where rollno='"+rollno+"'");
              while (rs1.next())
              {
                  sub1.setText(rs1.getString("subject1"));
                  sub2.setText(rs1.getString("subject2"));
                  sub3.setText(rs1.getString("subject3"));
                  sub4.setText(rs1.getString("subject4"));
                  sub5.setText(rs1.getString("subject5"));
              }

              ResultSet rs2=c.s.executeQuery("select * from marks where rollno='"+rollno+"'");
              while(rs2.next())
              {
                  sub1.setText(sub1.getText() + "------------" + rs2.getString("marks1"));
                  sub2.setText(sub2.getText() + "------------" + rs2.getString("marks2"));
                  sub3.setText(sub3.getText() + "------------" + rs2.getString("marks3"));
                  sub4.setText(sub4.getText() + "------------" + rs2.getString("marks4"));
                  sub5.setText(sub5.getText() + "------------" + rs2.getString("marks5"));
                  lsemester.setText(rs2.getString("semester"));
              }
            }catch (Exception e)
            {
                e.printStackTrace();
            }



           setVisible(true);
        }
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource()==back)
            {
                setVisible(false);
            }
        }

    public static void main(String[] args) {
            new Marks("");
    }
}
