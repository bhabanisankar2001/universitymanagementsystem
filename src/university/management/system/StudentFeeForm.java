package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class StudentFeeForm extends JFrame implements ActionListener{
JLabel lroll,lname,llname,lfname,llfname,lcourse,lbranch,lsemester,ltpay,lltpay;
Choice roll;
JComboBox course,branch,semester;
JButton update,payfee,back;

    StudentFeeForm(){
    setSize(1000,600);
    setLocation(100,50);
    setLayout(null);

    lroll=new JLabel("Select Roll No");
    lroll.setBounds(50,30,200,30);
    lroll.setFont(new Font("serif",Font.BOLD,20));
    add(lroll);

    lname=new JLabel("Name");
    lname.setBounds(50,70,200,30);
    lname.setFont(new Font("serif",Font.BOLD,20));
    add(lname);

    lfname=new JLabel("Father's Name");
    lfname.setBounds(50,110,200,30);
    lfname.setFont(new Font("serif",Font.BOLD,20));
    add(lfname);

    lcourse=new JLabel("Course");
    lcourse.setBounds(50,150,200,30);
    lcourse.setFont(new Font("serif",Font.BOLD,20));
    add(lcourse);

    lbranch=new JLabel("Branch");
    lbranch.setBounds(50,190,200,30);
    lbranch.setFont(new Font("serif",Font.BOLD,20));
    add(lbranch);

    lsemester=new JLabel("Semester");
    lsemester.setBounds(50,230,200,30);
    lsemester.setFont(new Font("serif",Font.BOLD,20));
    add(lsemester);

    ltpay=new JLabel("Total Payable");
    ltpay.setFont(new Font("serif",Font.BOLD,20));
    ltpay.setBounds(50,270,200,30);
    add(ltpay);

    lltpay = new JLabel();
    lltpay.setBounds(300, 270, 200, 30);
    lltpay.setFont(new Font("serif", Font.PLAIN, 16));
    add(lltpay);


        roll=new Choice();
    roll.setBounds(300,30,200,30);
    add(roll);

//    try{
//        Conn c=new Conn();
//        ResultSet rs=c.s.executeQuery("select * from student where rollno='"+roll.getSelectedItem()+"'");
//        while(rs.next())
//        {
//            llname.setText(rs.getString("name"));
//            llfname.setText(rs.getString("fathers_name"));
//        }
//    }
//    catch(Exception e)
//    {
//        e.printStackTrace();
//    }

    try{
        Conn c=new Conn();
        ResultSet rs1=c.s.executeQuery("select * from student");
        while(rs1.next())
        {
            roll.add(rs1.getString("rollno"));
        }
    }catch (Exception e)
    {
        e.printStackTrace();
    }
   llname=new JLabel();
   llname.setBounds(300,70,200,30);
   llname.setFont(new Font("serif", Font.BOLD,15));
   add(llname);

   llfname=new JLabel();
   llfname.setBounds(300,110,200,30);
   llfname.setFont(new Font("serif", Font.BOLD,15));
   add(llfname);


   roll.addItemListener(new ItemListener() {
       @Override
       public void itemStateChanged(ItemEvent e) {
           try{
               Conn c=new Conn();
               String query="select * from student where rollno='"+roll.getSelectedItem()+"'";
               ResultSet rs=c.s.executeQuery(query);
               while(rs.next())
               {
                   llname.setText(rs.getString("name"));
                   llfname.setText(rs.getString("fathers_name"));
               }

           }catch (Exception ew)
           {
               ew.printStackTrace();
           }
       }
   });



   String courses[] = {"B.Tech", "BBA", "BCA", "Bsc", "Msc", "MBA", "MCA", "M.Tech"};
   course = new JComboBox(courses);
   course.setBounds(300, 150, 200, 30);
   course.setBackground(Color.WHITE);
   add(course);


   String branches[] = {"Computer Science", "Electronics", "Mechanical", "Civil", "IT"};
   branch = new JComboBox(branches);
   branch.setBounds(300, 190, 200, 30);
   branch.setBackground(Color.WHITE);
   add(branch);


   String semesters[] = {"Semester1", "Semester2", "Semester3", "Semester4", "Semester5", "Semester6", "Semester7", "Semester8" };
   semester = new JComboBox(semesters);
   semester.setBounds(300, 230, 200, 30);
   semester.setBackground(Color.WHITE);
   add(semester);



   update = new JButton("Update");
   update.setBounds(30, 380, 100, 25);
   update.setBackground(Color.BLACK);
   update.setForeground(Color.WHITE);
   update.addActionListener(this);
   add(update);

   payfee= new JButton("Pay Fee");
   payfee.setBounds(150, 380, 100, 25);
   payfee.setBackground(Color.BLACK);
   payfee.setForeground(Color.WHITE);
   payfee.addActionListener(this);
   add(payfee);

   back = new JButton("Back");
   back.setBounds(270, 380, 100, 25);
   back.setBackground(Color.BLACK);
   back.setForeground(Color.WHITE);
   back.addActionListener(this);
   add(back);

        setVisible(true);
    }
public void actionPerformed(ActionEvent ae)
{
    if(ae.getSource()==update)
    {
      String Course=(String) course.getSelectedItem();
      String S=(String) semester.getSelectedItem();

      try{
          Conn c=new Conn();
          ResultSet rs=c.s.executeQuery("select * from fee where course='"+Course+"'");
          while(rs.next())
          {
              lltpay.setText(rs.getString(S));
          }
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }

    else if(ae.getSource()==payfee){
        String Roll=roll.getSelectedItem();
        String Course=(String)course.getSelectedItem();
        String Semester=(String)semester.getSelectedItem();
        String Branch=(String)branch.getSelectedItem();
        String Total=lltpay.getText();

        try{
            Conn c=new Conn();
           String query="insert into feedeposit values('"+Roll+"','"+Course+"','"+Semester+"','"+Branch+"','"+Total+"')";
           c.s.executeUpdate(query);
           JOptionPane.showMessageDialog(null,"fee deposit successfully");
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    else{
        setVisible(false);
    }

}




    public static void main(String[] args) {
new StudentFeeForm();
    }
}
