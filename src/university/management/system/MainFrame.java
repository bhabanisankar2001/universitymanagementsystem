package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {

    JMenuBar mb;

    MainFrame(){
        setSize(1920,1080);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1920,980, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        add(l1);

        mb=new JMenuBar();

        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.RED);
        mb.add(newInformation);
        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);
        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);

        JMenu details = new JMenu("View Details");
        details.setForeground(Color.BLUE);
        mb.add(details);
        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultydetails.addActionListener(this);
        details.add(facultydetails);
        JMenuItem studentdetails = new JMenuItem("View Student Details");
        studentdetails.addActionListener(this);
        details.add(studentdetails);

        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.RED);
        mb.add(leave);
        JMenuItem facultyleave = new JMenuItem("Faculty Leave");
        facultyleave.addActionListener(this);
        leave.add(facultyleave);
        JMenuItem studentleave = new JMenuItem("Student Leave");
        studentleave.addActionListener(this);
        leave.add(studentleave);

        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.BLUE);
        mb.add(leaveDetails);
        JMenuItem facultyleavedetails = new JMenuItem("Faculty Leave Details");
        facultyleavedetails.addActionListener(this);
        leaveDetails.add(facultyleavedetails);
        JMenuItem studentleavedetails = new JMenuItem("Student Leave Details");
        studentleavedetails.addActionListener(this);
        leaveDetails.add(studentleavedetails);

        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.RED);
        mb.add(exam);
        JMenuItem examinationdetails = new JMenuItem("Examination Results");
        examinationdetails.addActionListener(this);
        exam.add(examinationdetails);
        JMenuItem entermarks = new JMenuItem("Enter Marks");
        entermarks.addActionListener(this);
        exam.add(entermarks);

        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.BLUE);
        mb.add(updateInfo);
        JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Details");
        updatefacultyinfo.addActionListener(this);
        updateInfo.add(updatefacultyinfo);
        JMenuItem updatestudentinfo = new JMenuItem("Update Student Details");
        updatestudentinfo.addActionListener(this);
        updateInfo.add(updatestudentinfo);

        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.RED);
        mb.add(fee);
        JMenuItem feestructure = new JMenuItem("Fee Structure");
        feestructure.addActionListener(this);
        fee.add(feestructure);
        JMenuItem feeform = new JMenuItem("Student Fee Form");
        feeform.addActionListener(this);
        fee.add(feeform);

        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLUE);
        mb.add(utility);
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.addActionListener(this);
        utility.add(notepad);
        JMenuItem calc = new JMenuItem("Calculator");
        calc.addActionListener(this);
        utility.add(calc);

        JMenu about = new JMenu("About");
        about.setForeground(Color.RED);
        mb.add(about);
        JMenuItem ab = new JMenuItem("About");
        ab.addActionListener(this);
        about.add(ab);

        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.BLUE);
        mb.add(exit);
        JMenuItem ex = new JMenuItem("Exit");
        ex.addActionListener(this);
        exit.add(ex);

        setJMenuBar(mb);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        String s=e.getActionCommand();
        if(s=="New Faculty Information"){
            new AddTeacher();

        }
        else if(s=="New Student Information")
        {
            new AddStudent();

        }
        else if(s=="View Faculty Details")
        {
            new TeacherDetails();

        }
        else if(s=="View Student Details")
        {
            new StudentDetails();

        }
        else if(s=="Faculty Leave")
        {
            new TeacherLeave();

        }
        else if(s=="Student Leave")
        {
            new StudentLeave();

        }
        else if(s=="Faculty Leave Details")
        {
            new TeacherLeaveDetails();

        }
        else if(s=="Student Leave Details")
        {
            new StudentLeaveDetails();

        }
        else if(s=="Examination Results")
        {
            new ExaminationDetails();

        }
        else if(s=="Enter Marks")
        {
            new EnterMarks();

        }
        else if(s=="Update Faculty Details")
        {
            new UpdateTeacher();

        }
        else if(s=="Update Student Details")
        {
            new UpdateStudent();

        }
        else if(s=="Fee Structure")
        {
            new FeeStructure();

        }
        else if(s=="Student Fee Form")
        {
            new StudentFeeForm();
        }
        else if(s=="Notepad")
        {
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
        else if(s=="Calculator")
        {
            try{
                Runtime.getRuntime().exec("calc.exe");
            }
            catch (Exception ee)
            {
                ee.printStackTrace();
            }
        }
        else if(s=="About")
        {
            new About();
        }
        else if(s=="Exit")
        {
            System.exit(0);
        }


    }



    public static void main(String[] args) {
        new MainFrame();
    }

}
