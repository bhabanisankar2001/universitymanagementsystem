package university.management.system;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class ExaminationDetails extends JFrame implements ActionListener {
 JLabel heading;
 JTextField search;
 JButton submit,cancel;
 JTable table;
 JScrollPane scrollbar;
    ExaminationDetails(){
        setSize(900,600);
        setLocation(100,50);
        setLayout(null);
        setVisible(true);

        heading=new JLabel("Examination Results");
        heading.setBounds(40,20,400,30);
        heading.setFont(new Font("", Font.BOLD,25));
        add(heading);

        search=new JTextField();
        search.setBounds(40,80,200,25);
        search.setFont(new Font("",Font.BOLD,19));
        add(search);

        submit=new JButton("Check");
        submit.setBounds(250,80,100,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("Back");
        cancel.setBounds(380,80,100,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        table=new JTable();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        scrollbar = new JScrollPane(table);
        scrollbar.setBounds(0, 110, 900, 600);
        add(scrollbar);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row=table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row,8).toString());
            }
        });
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            new Marks(search.getText());
            setVisible(false);
        }
        else{
            setVisible(false);
        }
    }


    public static void main(String[] args) {
        new ExaminationDetails();
    }
}
