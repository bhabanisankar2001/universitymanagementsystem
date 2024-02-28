package university.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherDetails extends JFrame implements ActionListener {


    JTable table;
    Choice emp;
    JButton search, print, add, update;
    JButton cancel;
    JScrollPane scrollbar;
    TeacherDetails(){
        setLayout(null);
        JLabel heading;
        JTable table;
        Choice cempno;
        JButton search, print, cancel, add, update;
        JScrollPane scrollbar;

        heading=new JLabel("Search by Employee Id");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        emp=new Choice();
        emp.setBounds(180, 20, 150, 20);
        add(emp);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from teacher");
            while(rs.next())
            {
                emp.add(rs.getString("empid"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        table=new JTable();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        scrollbar = new JScrollPane(table);
        scrollbar.setBounds(0, 100, 900, 600);
        add(scrollbar);

        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        add = new JButton("Add");
        add.setBounds(220, 70, 80, 20);
        add.addActionListener(this);
        add(add);

        update = new JButton("Update");
        update.setBounds(320, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(420, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);
        setSize(900,600);
        setVisible(true);



    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == search) {
            String query = "select * from teacher where empid = '" +emp.getSelectedItem() + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == add) {
            setVisible(false);
            new AddTeacher();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateTeacher();
        } else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
new TeacherDetails();
    }
    }






