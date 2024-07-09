package ex3;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
public class Student_Mgmnt implements ActionListener{
	ArrayList<Student> arr=new ArrayList<Student>();
	static JFrame jf;
	JPanel jp;
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9;
	JTextField name,usn,address,age,sgpa1,sgpa2,sgpa3,sgpa4,category;
	JButton compute,done,ADDSgpa;
	JTextArea jt;
	double cgpa;double a[]=new double[4];
	Student_Mgmnt()
	{
		jf=new JFrame();
		jp=new JPanel();
		jl1=new JLabel("Enter name");
		jl2=new JLabel("Enter usn");
		jl3=new JLabel("Enter address");
		jl4=new JLabel("Enter age");
		jl5=new JLabel("Enter sgpa1");
		jl6=new JLabel("Enter sgpa2");
		jl7=new JLabel("Enter sgpa3");
		jl8=new JLabel("Enter sgpa4");
		jl9=new JLabel("Enter category");
		name=new JTextField(20);
		usn=new JTextField(20);
		address=new JTextField(20);
		age=new JTextField(20);
		sgpa1=new JTextField(20);
		sgpa2=new JTextField(20);
		sgpa3=new JTextField(20);
		sgpa4=new JTextField(20);
		category=new JTextField(20);
		jt=new JTextArea(3,50);
		compute=new JButton("Compute");
		done=new JButton("Display");
		ADDSgpa=new JButton("SGPA compute");
		
		jp.add(jl1);jp.add(name);
		jp.add(jl2);jp.add(usn);
		jp.add(jl3);jp.add(address);
		jp.add(jl4);jp.add(age);
		jp.add(jl5);jp.add(sgpa1);
		jp.add(jl6);jp.add(sgpa2);
		jp.add(jl7);jp.add(sgpa3);
		jp.add(jl8);jp.add(sgpa4);
		jp.add(jl9);jp.add(category);
		jp.add(jt);
		jp.add(compute);
		jp.add(done);
		jp.add(ADDSgpa);
		jf.add(jp);	
		done.addActionListener(this);
		compute.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		
		if(ae.getSource()==compute)
		{
			double sum=0.0;
			a[0]=Double.parseDouble(sgpa1.getText());
			a[1]=Double.parseDouble(sgpa2.getText());
			a[2]=Double.parseDouble(sgpa3.getText());
			a[3]=Double.parseDouble(sgpa4.getText());
			
			for(int i=0;i<4;i++)
			{
				sum=sum+a[i];
			}
			cgpa=(double)sum;
			String result="Final cgpa is:"+cgpa;
			JOptionPane.showMessageDialog(null,result);
		}
		if(ae.getSource()==done)
		{
			String name1=name.getText();
			String address1=address.getText();
			String usn1=usn.getText();
			String age1=age.getText();
			int a=Integer.parseInt(age1);
			if(a<18 || a>23)
			{
				JOptionPane.showMessageDialog(null, "Age invalid");
			}
			if(name1.isEmpty()||address1.isEmpty()||usn1.isEmpty()||age1.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Some details are not filled");
			}
			Student s1=new Student(name1,address1,usn1,a,cgpa);
			arr.add(s1);
			for(Student c :arr) 
			{
				jt.append(c.name+" "+c.usn+" "+c.address+" "+c.age+" "+c.marks);
			}
		}
	}
	public static void main(String[] args)
	{
		Student_Mgmnt sm=new Student_Mgmnt();
		jf.setVisible(true);
		jf.setSize(300,400);
		jf.setLayout(new GridLayout(4,1));
	}

}

package ex3;

public class Student {
	String name;
	String address,usn;
	int age;
	double marks;
	Student(String name,String address,String usn,int age,double m)
	{
	this.name=name;
	this.age=age;
	this.address=address;
	this.usn=usn;
	this.marks=m;
	}

}
