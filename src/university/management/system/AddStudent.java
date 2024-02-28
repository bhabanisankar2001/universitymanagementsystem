package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.chrono.*;
import java.util.Random;

public class AddStudent extends JFrame implements ActionListener {
    JLabel heading,lname,lfname,ldob,laadhar,lemail,lx,lxii,lph,lrollno,lcourse,lbranch,laddress,llrollno;
    JTextField tname,tfname,tdob,taadhar,temail,tx,txii,tph,taddress;
    JComboBox cbranch,ccourse;
    JButton submit,cancel;

    Random ran=new Random();
    long remain=Math.abs((ran.nextLong()%900L)+100L);

AddStudent(){
    setSize(900,700);
    setLocation(250,50);

    setLayout(null);

    heading=new JLabel("New Student Detatils");
    heading.setBounds(310,30,500,50);
    heading.setFont(new Font("serif", Font.BOLD,30));
    add(heading);

    lname=new JLabel("Name");
    lname.setBounds(50,150,100,30);
    lname.setFont(new Font("serif",Font.BOLD,20));
    add(lname);

    tname=new JTextField();
    tname.setBounds(200,150,150,30);
    add(tname);

    lfname=new JLabel("Father's Name");
    lfname.setBounds(400, 150, 200, 30);
    lfname.setFont(new Font("serif", Font.BOLD, 20));
    add(lfname);

    tfname = new JTextField();
    tfname.setBounds(600, 150, 150, 30);
    add(tfname);

    ldob=new JLabel("Date Of Birth");
    ldob.setBounds(400, 200, 200, 30);
    ldob.setFont(new Font("serif", Font.BOLD, 20));
    add(ldob);

    tdob=new JTextField();
    tdob.setBounds(600, 200, 150, 30);
    add(tdob);

    laadhar=new JLabel("Aadhar");
    laadhar.setBounds(400, 350, 200, 30);
    laadhar.setFont(new Font("serif", Font.BOLD, 20));
    add(laadhar);

    taadhar = new JTextField();
    taadhar.setBounds(600, 350, 150, 30);
    add(taadhar);

    lemail=new JLabel("Email");
    lemail.setBounds(50, 300, 200, 30);
    lemail.setFont(new Font("serif", Font.BOLD, 20));
    add(lemail);

    temail = new JTextField();
    temail.setBounds(200, 300, 150, 30);
    add(temail);

    lx = new JLabel("Class X (%)");
    lx.setBounds(400, 300, 200, 30);
    lx.setFont(new Font("serif", Font.BOLD, 20));
    add(lx);

    tx = new JTextField();
    tx.setBounds(600, 300, 150, 30);
    add(tx);

    lxii = new JLabel("Class XII (%)");
    lxii.setBounds(50, 350, 200, 30);
    lxii.setFont(new Font("serif", Font.BOLD, 20));
    add(lxii);

    txii = new JTextField();
    txii.setBounds(200, 350, 150, 30);
    add(txii);

    lph= new JLabel("Phone");
    lph.setBounds(400, 250, 200, 30);
    lph.setFont(new Font("serif", Font.BOLD, 20));
    add(lph);

    tph = new JTextField();
    tph.setBounds(600, 250, 150, 30);
    add(tph);

    lrollno=new JLabel("Roll Number");
    lrollno.setBounds(50, 200, 200, 30);
    lrollno.setFont(new Font("serif", Font.BOLD, 20));
    add(lrollno);

    llrollno=new JLabel("2205289"+remain);
    llrollno.setBounds(200, 200, 200, 30);
    llrollno.setFont(new Font("serif", Font.BOLD, 20));
    add(llrollno);

    lcourse=new JLabel("Courses");
    lcourse.setBounds(50, 400, 200, 30);
    lcourse.setFont(new Font("serif", Font.BOLD, 20));
    add(lcourse);

    String course[] = {"B.Tech", "BBA", "BCA", "Bsc", "Msc", "MBA", "MCA", "M.Tech"};
    ccourse = new JComboBox(course);
    ccourse.setBounds(200, 400, 150, 30);
    ccourse.setBackground(Color.WHITE);
    add(ccourse);

    lbranch = new JLabel("Branch");
    lbranch.setBounds(400, 400, 200, 30);
    lbranch.setFont(new Font("serif", Font.BOLD, 20));
    add(lbranch);

    String branch[] = {"Computer Science", "Electronics", "Mechanical", "Civil", "IT"};
    cbranch = new JComboBox(branch);
    cbranch.setBounds(600, 400, 150, 30);
    cbranch.setBackground(Color.WHITE);
    add(cbranch);

    laddress = new JLabel("Address");
    laddress.setBounds(50, 250, 200, 30);
    laddress.setFont(new Font("serif", Font.BOLD, 20));
    add(laddress);

    taddress = new JTextField();
    taddress.setBounds(200, 250, 150, 30);
    add(taddress);

    submit = new JButton("Submit");
    submit.setBounds(250, 550, 120, 30);
    submit.setBackground(Color.BLACK);
    submit.setForeground(Color.WHITE);
    submit.addActionListener(this);
    submit.setFont(new Font("Tahoma", Font.BOLD, 15));
    add(submit);

    cancel = new JButton("Cancel");
    cancel.setBounds(450, 550, 120, 30);
    cancel.setBackground(Color.BLACK);
    cancel.setForeground(Color.WHITE);
    cancel.addActionListener(this);
    cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
    add(cancel);

    setVisible(true);
}
public void actionPerformed(ActionEvent ae){
     if(ae.getSource()==submit)
     {
         String name=tname.getText();
         String fname=tfname.getText();
         String dob=tdob.getText();
         String aadhar=taadhar.getText();
         String email=temail.getText();
         String class_x=tx.getText();
         String class_xii=txii.getText();
         String phone=tph.getText();
         String rollno=llrollno.getText();
         String course=(String) ccourse.getSelectedItem();
         String branch=(String)cbranch.getSelectedItem();
         String address=taddress.getText();

         try{
             String query="insert into student values('"+name+"','"+fname+"','"+dob+"','"+aadhar+"','"+email+"','"+class_x+"','"+class_xii+"','"+phone+"','"+rollno+"','"+course+"','"+branch+"','"+address+"')";
             Conn c=new Conn();
             c.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null,"Student details inserted successfully");
             setVisible(false);

         }catch(Exception e)
         {
          e.printStackTrace();
         }
     }
     else if(ae.getSource()==cancel){
         System.exit(0);
     }
      new MainFrame().setVisible(true);


}
    public static void main(String[] args) {
        new AddStudent();
    }
}
