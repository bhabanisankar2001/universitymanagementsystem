package university.management.system;
import javax.swing.*;
import java.awt.*;

public class Welcome extends JFrame implements Runnable {
Thread th1;
    Welcome(){
super("University Of Technology");
ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
Image i2=i1.getImage().getScaledInstance(1000,500, Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
JLabel l1=new JLabel(i3);
add(l1);
       setVisible(true);
       setSize(1000,500);
       setLocation(200,100);
       th1=new Thread(this);
       th1.start();

    }
    public void run(){
        try{
            Thread.sleep(5000);
            setVisible(false);
            new Login();
        }catch (Exception e){}
    }



    public static void main(String[] args) {
        new Welcome();
    }
}
