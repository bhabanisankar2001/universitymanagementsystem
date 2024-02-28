package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class UpdateTeacher extends JFrame implements ActionListener {
    JLabel heading,lname,lfname,ldob,laadhar,lemail,lx,lxii,lph,lempno,lcourse,ldept,laddress,llempno,empname,fathername,dateofbirth,aadhar,x,xii;
    JTextField temail,tph,taddress,ccourse,cdept;

    JButton submit,cancel;
    Choice cempno;
    UpdateTeacher(){
        setSize(900,700);
        setLocation(250,50);
        setLayout(null);

        heading=new JLabel("Update Teacher Details");
        heading.setBounds(60,30,500,50);
        heading.setFont(new Font("serif", Font.BOLD,30));
        add(heading);

        lempno= new JLabel("Search by Emp Number");
        lempno.setBounds(60, 100, 220, 23);
        lempno.setFont(new Font("serif",Font.BOLD,20));
        add(lempno);

        cempno = new Choice();
        cempno.setBounds(290, 100, 150, 23);
        add(cempno);

        try{
            Conn c=new Conn();
            String query="select * from teacher";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                cempno.add(rs.getString("empid"));
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        lname=new JLabel("Name");
        lname.setBounds(50,150,100,30);
        lname.setFont(new Font("serif",Font.BOLD,20));
        add(lname);

        empname=new JLabel();
        empname.setBounds(200,150,150,30);
        empname.setFont(new Font("serif",Font.BOLD,15));
        add(empname);

        lfname=new JLabel("Father's Name");
        lfname.setBounds(400, 150, 200, 30);
        lfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lfname);

        fathername = new JLabel();
        fathername.setBounds(600, 150, 150, 30);
        add(fathername);

        ldob=new JLabel("Date Of Birth");
        ldob.setBounds(400, 200, 200, 30);
        ldob.setFont(new Font("serif", Font.BOLD, 20));
        add(ldob);


        dateofbirth=new JLabel();
        dateofbirth.setBounds(600, 200, 150, 30);
        add(dateofbirth);

        laadhar=new JLabel("Aadhar");
        laadhar.setBounds(400, 350, 200, 30);
        laadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(laadhar);

        aadhar = new JLabel();
        aadhar.setBounds(600, 350, 150, 30);
        add(aadhar);

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

        x = new JLabel();
        x.setBounds(600, 300, 150, 30);
        add(x);

        lxii = new JLabel("Class XII (%)");
        lxii.setBounds(50, 350, 200, 30);
        lxii.setFont(new Font("serif", Font.BOLD, 20));
        add(lxii);

        xii = new JLabel();
        xii.setBounds(200, 350, 150, 30);
        add(xii);

        lph= new JLabel("Phone");
        lph.setBounds(400, 250, 200, 30);
        lph.setFont(new Font("serif", Font.BOLD, 20));
        add(lph);

        tph = new JTextField();
        tph.setBounds(600, 250, 150, 30);
        add(tph);

        lempno=new JLabel("Emp ID");
        lempno.setBounds(50, 200, 200, 30);
        lempno.setFont(new Font("serif", Font.BOLD, 20));
        add(lempno);

        llempno=new JLabel();
        llempno.setBounds(200, 200, 200, 30);
        llempno.setFont(new Font("serif", Font.BOLD, 20));
        add(llempno);

        lcourse=new JLabel("Courses");
        lcourse.setBounds(50, 400, 200, 30);
        lcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lcourse);


        ccourse = new JTextField();
        ccourse.setBounds(200, 400, 150, 30);
        add(ccourse);

        ldept = new JLabel("Branch");
        ldept.setBounds(400, 400, 200, 30);
        ldept.setFont(new Font("serif", Font.BOLD, 20));
        add(ldept);


        cdept = new JTextField();
        cdept.setBounds(600, 400, 150, 30);
        add(cdept);

        laddress = new JLabel("Address");
        laddress.setBounds(50, 250, 200, 30);
        laddress.setFont(new Font("serif", Font.BOLD, 20));
        add(laddress);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        add(taddress);

        submit = new JButton("Update");
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

        try{
            Conn c=new Conn();
            String query="select * from teacher where empid='"+cempno.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                empname.setText(rs.getString("name"));
                fathername.setText(rs.getString("fathers_name"));
                dateofbirth.setText(rs.getString("dob"));
                aadhar.setText(rs.getString("aadhar"));
                temail.setText(rs.getString("email"));
                x.setText(rs.getString("class_x"));
                xii.setText(rs.getString("class_xii"));
                tph.setText(rs.getString("phone"));
                llempno.setText(rs.getString("empid"));
                ccourse.setText(rs.getString("course"));
                cdept.setText(rs.getString("branch"));
                taddress.setText(rs.getString("address"));
            }
        }
        catch (Exception e)
        {

        }

        cempno.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Conn c=new Conn();
                    String query="select * from teacher where empid='"+cempno.getSelectedItem()+"'";
                    ResultSet rs=c.s.executeQuery(query);
                    while(rs.next())
                    {
                        empname.setText(rs.getString("name"));
                        fathername.setText(rs.getString("fathers_name"));
                        dateofbirth.setText(rs.getString("dob"));
                        aadhar.setText(rs.getString("aadhar"));
                        temail.setText(rs.getString("email"));
                        x.setText(rs.getString("class_x"));
                        xii.setText(rs.getString("class_xii"));
                        tph.setText(rs.getString("phone"));
                        llempno.setText(rs.getString("empid"));
                        ccourse.setText(rs.getString("course"));
                        cdept.setText(rs.getString("branch"));
                        taddress.setText(rs.getString("address"));
                    }
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            String email=temail.getText();
            String phone=tph.getText();
            String address=taddress.getText();
            String course=ccourse.getText();
            String branch=cdept.getText();
          try{
              Conn c=new Conn();
              String query="update teacher set email='"+email+"',phone='"+phone+"',address='"+address+"',course='"+course+"',branch='"+branch+"' where empid='"+cempno.getSelectedItem()+"'";
              c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null,"teacher details update successfully");
              setVisible(false);
          }catch (Exception e)
          {
                e.printStackTrace();
          }
        }
        else{
            System.exit(0);
        }
    }


    public static void main(String[] args) {
        new UpdateTeacher();
    }
}
