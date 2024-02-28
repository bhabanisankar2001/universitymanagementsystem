package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JLabel userl,passl;
    JTextField usert;
    JPasswordField passt;
    JButton submit,cancel;
    Login(){
        super("Login");
        setSize(500,300);
        setLocation(300,150);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        userl=new JLabel("Username");
        userl.setBounds(30,60,70,20);
        add(userl);

        usert=new JTextField();
        usert.setBounds(120,60,120,20);
        add(usert);

        passl=new JLabel("Password");
        passl.setBounds(30,100,70,20);
        add(passl);

        passt=new JPasswordField();
        passt.setBounds(120,100,120,20);
        add(passt);

        submit=new JButton("Login");
        submit.setBounds(30,150,80,30);
        submit.setForeground(Color.white);
        submit.setBackground(Color.black);
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBounds(120,150,80,30);
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(300,40,200,100);
        add(l1);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            try{
                Conn c=new Conn();
               String username=usert.getText();
               String password=passt.getText();
               String query="select * from login where username='"+username+"' and password='"+password+"'";
               ResultSet rs= c.s.executeQuery(query);

               if(rs.next())
               {
                   setVisible(false);
                   new MainFrame();
               }
               else{
                       JOptionPane.showMessageDialog(null,"Invalid Login Credential");
               }
            }
            catch(Exception e){

            }
        }
        else if(ae.getSource()==cancel)
        {
           System.exit(0);
        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}