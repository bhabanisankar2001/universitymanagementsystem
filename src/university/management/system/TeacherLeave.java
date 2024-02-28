package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeave extends JFrame implements ActionListener {

        JLabel heading,lempno,date,lduration;
        JTextField tdate;
        Choice cempno,cduration;
        JButton submit,cancel;
        TeacherLeave(){
            heading=new JLabel("Apply Teacher Leave");
            heading.setBounds(40,20,200,30);
            heading.setFont(new Font("serif",Font.BOLD,20));
            add(heading);

            lempno= new JLabel("Search by EMPID Number");
            lempno.setBounds(60, 100, 150, 20);
            add(lempno);

            cempno = new Choice();
            cempno.setBounds(60, 130, 150, 20);
            add(cempno);

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from teacher");
                while (rs.next()) {
                    cempno.add(rs.getString("empid"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            date=new JLabel("Date");
            date.setBounds(60,160,200,20);
            date.setFont(new Font("serif",Font.BOLD,15));
            add(date);

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
                String empid=cempno.getSelectedItem();
                String date=tdate.getText();
                String duration=cduration.getSelectedItem();
                String query="insert into teacherleave  values('"+empid+"','"+ date+"','"+duration+"')";
                try{
                    Conn c=new Conn();
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"teacher leave details inserted successfully");
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
         new TeacherLeave();
        }
    }

