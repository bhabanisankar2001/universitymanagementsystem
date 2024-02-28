package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EnterMarks extends JFrame implements ActionListener {
 JLabel heading,lrollno,lsemester,lsubject,lmarks;
 Choice roll;
 JComboBox semester;
 JTextField s1,s2,s3,s4,s5,m1,m2,m3,m4,m5;

 JButton submit,back;
    EnterMarks(){
        setSize(900,600);
        setLocation(100,50);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        heading=new JLabel("Enter Marks Of Student");
        heading.setBounds(30,30,270,30);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        lrollno=new JLabel("Select Roll Number");
        lrollno.setBounds(30,100,150,20);
        add(lrollno);

        roll=new Choice();
        roll.setBounds(210,100,150,20);
        add(roll);

        try{
             Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from student");
            while(rs.next())
            {
                roll.add(rs.getString("rollno"));
            }
        }
        catch(Exception e)
        {
  e.printStackTrace();
        }

        lsemester=new JLabel("Select Semester");
        lsemester.setBounds(30,160,150,20);
        add(lsemester);

        String seme[]={"1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester"};
        semester=new JComboBox(seme);
        semester.setBounds(210,160,150,20);
        add(semester);

        lsubject=new JLabel("Enter Subject");
        lsubject.setBounds(90,200,100,20);
        add(lsubject);

        lmarks=new JLabel("Enter Marks");
        lmarks.setBounds(250,200,100,20);
        add(lmarks);

        s1=new JTextField();
        s1.setBounds(60,230,160,20);
        add(s1);

        m1=new JTextField();
        m1.setBounds(220,230,160,20);
        add(m1);

        s2=new JTextField();
        s2.setBounds(60,260,160,20);
        add(s2);

        m2=new JTextField();
        m2.setBounds(220,260,160,20);
        add(m2);

        s3=new JTextField();
        s3.setBounds(60,290,160,20);
        add(s3);

        m3=new JTextField();
        m3.setBounds(220,290,160,20);
        add(m3);

        s4=new JTextField();
        s4.setBounds(60,320,160,20);
        add(s4);

        m4=new JTextField();
        m4.setBounds(220,320,160,20);
        add(m4);

        s5=new JTextField();
        s5.setBounds(60,350,160,20);
        add(s5);

        m5=new JTextField();
        m5.setBounds(220,350,160,20);
        add(m5);

        submit=new JButton("Submit");
        submit.setBounds(80,380,100,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        back=new JButton("Back");
        back.setBounds(240,380,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
           try{
               Conn c=new Conn();
               String query1="insert into subject values('"+roll.getSelectedItem()+"','"+semester.getSelectedItem()+"','"+s1.getText()+"','"+s2.getText()+"','"+s3.getText()+"','"+s4.getText()+"','"+s5.getText()+"')";
               String query2="insert into marks values('"+roll.getSelectedItem()+"','"+semester.getSelectedItem()+"','"+m1.getText()+"','"+m2.getText()+"','"+m3.getText()+"','"+m4.getText()+"','"+m5.getText()+"')";
               c.s.executeUpdate(query1);
               c.s.executeUpdate(query2);
               JOptionPane.showMessageDialog(null,"Subject and Marks successfully entered");
               setVisible(false);
           }
           catch (Exception e)
           {

           }
        }
        else{
            setVisible(false);
        }


    }


    public static void main(String[] args) {
        new EnterMarks();
    }
}
