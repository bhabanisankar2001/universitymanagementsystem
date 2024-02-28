package university.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

class TeacherLeaveDetails extends JFrame implements ActionListener {

    JLabel heading;
    JTable table;
    Choice cempno;
    JButton search, print, cancel;
    JScrollPane scrollbar;

    TeacherLeaveDetails(){
        setLayout(null);
        setBackground(Color.white);

        heading = new JLabel("Search by EMPID");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        cempno = new Choice();
        cempno.setBounds(180, 20, 150, 20);
        add(cempno);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacherleave");
            while (rs.next()) {
                cempno.add(rs.getString("empid"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacherleave");
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
        print.setBounds(220, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        cancel = new JButton("Cancel");
        cancel.setBounds(420, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == search) {
            String query = "select * from teacherleave where empid = '" + cempno.getSelectedItem() + "'";
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

            setVisible(false);
            new UpdateStudent();
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
       new TeacherLeaveDetails();
    }
}
