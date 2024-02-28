package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class UpdateStudent extends JFrame implements ActionListener {
    JLabel heading,lname,lfname,ldob,laadhar,lemail,lx,lxii,lph,lrollno,lcourse,lbranch,laddress,llrollno,stdname,fathername,dateofbirth,aadhar,x,xii;
    JTextField temail,tph,taddress,ccourse,cbranch;

    JButton submit,cancel;
    Choice crollno;


    UpdateStudent(){
        setSize(900,700);
        setLocation(250,50);

        setLayout(null);

        heading=new JLabel("Update Student Details");
        heading.setBounds(60,30,500,50);
        heading.setFont(new Font("serif", Font.BOLD,30));
        add(heading);

        lrollno= new JLabel("Search by Roll Number");
        lrollno.setBounds(60, 100, 200, 23);
        lrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lrollno);

        crollno = new Choice();
        crollno.setBounds(270, 100, 150, 23);
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

        lname=new JLabel("Name");
        lname.setBounds(50,150,100,30);
        lname.setFont(new Font("serif",Font.BOLD,20));
        add(lname);

        stdname=new JLabel();
        stdname.setBounds(200,150,150,30);
        stdname.setFont(new Font("serif",Font.BOLD,15));
        add(stdname);

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

        lrollno=new JLabel("Roll Number");
        lrollno.setBounds(50, 200, 200, 30);
        lrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(lrollno);

        llrollno=new JLabel();
        llrollno.setBounds(200, 200, 200, 30);
        llrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(llrollno);

        lcourse=new JLabel("Courses");
        lcourse.setBounds(50, 400, 200, 30);
        lcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lcourse);


        ccourse = new JTextField();
        ccourse.setBounds(200, 400, 150, 30);
        add(ccourse);

        lbranch = new JLabel("Branch");
        lbranch.setBounds(400, 400, 200, 30);
        lbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lbranch);


        cbranch = new JTextField();
        cbranch.setBounds(600, 400, 150, 30);
        add(cbranch);

        laddress = new JLabel("Address");
        laddress.setBounds(50, 250, 200, 30);
        laddress.setFont(new Font("serif", Font.BOLD, 20));
        add(laddress);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        add(taddress);

        try{
            Conn c=new Conn();
            String query="select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                stdname.setText(rs.getString("name"));
                fathername.setText(rs.getString("fathers_name"));
                dateofbirth.setText(rs.getString("dob"));
                aadhar.setText(rs.getString("aadhar"));
                temail.setText(rs.getString("email"));
                x.setText(rs.getString("class_x"));
                xii.setText(rs.getString("class_xii"));
                tph.setText(rs.getString("phone"));
                llrollno.setText(rs.getString("rollno"));
                ccourse.setText(rs.getString("course"));
                cbranch.setText(rs.getString("branch"));
                taddress.setText(rs.getString("address"));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }

        crollno.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Conn c=new Conn();
                    String query="select * from student where rollno='"+crollno.getSelectedItem()+"'";
                    ResultSet rs=c.s.executeQuery(query);
                    while(rs.next())
                    {
                        stdname.setText(rs.getString("name"));
                        fathername.setText(rs.getString("fathers_name"));
                        dateofbirth.setText(rs.getString("dob"));
                        aadhar.setText(rs.getString("aadhar"));
                        temail.setText(rs.getString("email"));
                        x.setText(rs.getString("class_x"));
                        xii.setText(rs.getString("class_xii"));
                        tph.setText(rs.getString("phone"));
                        llrollno.setText(rs.getString("rollno"));
                        ccourse.setText(rs.getString("course"));
                        cbranch.setText(rs.getString("branch"));
                        taddress.setText(rs.getString("address"));
                    }

                }catch(Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

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

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit)
        {
            String email=temail.getText();
            String phone=tph.getText();
            String address=taddress.getText();
            String course=ccourse.getText();
            String branch=cbranch.getText();

            try{
                Conn c=new Conn();
                String query="update student set email='"+email+"', phone='"+phone+"',address='"+address+"',course='"+course+"',branch='"+branch+"' where rollno='"+crollno.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Student details Update successfully");
                setVisible(false);

            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else {
            System.exit(0);
        }


    }
    public static void main(String[] args) {
        new UpdateStudent();
    }
}

