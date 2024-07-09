import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class DBTest implements ActionListener{
	JFrame jf;
	JButton submit,display;
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10;
	JTextField jt1,jt2,jt3,jt4,jt5,jt6,jt7,jt8,jt9,jt10;
	Connection con;PreparedStatement st,st2;
	ResultSet rs;
	DBTest()
	{
		jf=new JFrame("Enter details");
		jl1=new JLabel("Enter repno");
		jt1=new JTextField(20);
		jl2=new JLabel("Enter repname");
		jt2=new JTextField(20);
		jl3=new JLabel("Enter state");
		jt3=new JTextField(20);
		jl4=new JLabel("Enter commision");
		jt4=new JTextField(20);
		jl5=new JLabel("Enter rate");
		jt5=new JTextField(20);
		jl6=new JLabel("Enter custno");
		jt6=new JTextField(20);
		jl7=new JLabel("Enter custname");
		jt7=new JTextField(20);
		jl8=new JLabel("Enter state");
		jt8=new JTextField(20);
		jl9=new JLabel("Enter credit_limit");
		jt9=new JTextField(20);
		jl10=new JLabel("Enter repno");
		jt10=new JTextField(20);
		submit=new JButton("Submit values");
		display=new JButton("Display credit details");
		jf.add(jl1);jf.add(jt1);jf.add(jl2);jf.add(jt2);
		jf.add(jl3);jf.add(jt3);jf.add(jl4);jf.add(jt4);
		jf.add(jl5);jf.add(jt5);jf.add(jl6);jf.add(jt6);
		jf.add(jl7);jf.add(jt7);jf.add(jl8);jf.add(jt8);
		jf.add(jl9);jf.add(jt9);jf.add(jl10);jf.add(jt10);
		jf.add(submit);submit.addActionListener(this);
		jf.add(display);display.addActionListener(this);
		jf.setVisible(true);jf.setSize(300,400);jf.setLayout(new GridLayout(20,2));
		
		try 
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","password");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==submit)
		{
			int repn=Integer.parseInt(jt1.getText());
			String repna=jt2.getText();
			String sta=jt3.getText();
			String com=jt4.getText();
			String rat=jt5.getText();
			int custn=Integer.parseInt(jt6.getText());
			String custna=jt7.getText();
			String state2=jt8.getText();
			String cred=jt9.getText();
			int repno=Integer.parseInt(jt10.getText());
			String query="insert into Rep values(?,?,?,?,?)";
			try
			{
				st=con.prepareStatement(query);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			try 
			{
				st.setInt(1, repn);
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			try 
			{
				st.setString(2, repna);
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			try 
			{
				st.setString(3, sta);
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			try 
			{
				st.setString(4, com);
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			try 
			{
				st.setString(5, rat);
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			try 
			{
				int i=st.executeUpdate();
			} 
			catch (SQLException e) 
			{
			e.printStackTrace();
			}
			String query1="insert into cust values(?,?,?,?,?)";
			try 
			{
				st2 = con.prepareStatement(query1);
			} 
			catch (SQLException e1) 
			{
			e1.printStackTrace();
			}
			try 
			{
			st2.setInt(1, custn);
			} 
			catch (SQLException e) 
			{
			e.printStackTrace();
			}
			try 
			{
			st2.setString(2, custna);
			} 
			catch (SQLException e) 
			{
			e.printStackTrace();
			}
			try 
			{
			st2.setString(3, state2);
			} 
			catch (SQLException e) 
			{
			e.printStackTrace();
			}
			try 
			{
			st2.setString(4, cred);
			} 
			catch (SQLException e) 
			{
			e.printStackTrace();
			}
			try 
			{
			st2.setInt(5, repno);
			} 
			catch (SQLException e) 
			{
			e.printStackTrace();
			}
			try 
			{
			int i=st2.executeUpdate();
			} 
			catch (SQLException e) 
			{
			e.printStackTrace();
			}
			
		}
		if(ae.getSource()==display)
		{
		try 
		{
			rs=st.executeQuery("select * from Rep where repno in(select repno from cust where credit_limit>15000)" );
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		if(rs!=null)
		{
			try 
			{
			while(rs.next())
			{
			JFrame frm=new JFrame("Output Details");
			JLabel s5=new JLabel("repno");
			JLabel s1=new JLabel("repname");
			JLabel s2=new JLabel("state");
			JLabel s3=new JLabel("comm");
			JLabel s4=new JLabel("rate");
			JTextField repno1=new JTextField(20);
			JTextField repname1=new JTextField(20);
			JTextField state1=new JTextField(20);
			JTextField comm1=new JTextField(20);
			JTextField rate1=new JTextField(20);
			frm.add(s5);
			frm.add(repno1);
			frm.add(s1);
			frm.add(repname1);
			frm.add(s2);
			frm.add(state1);
			frm.add(s3);
			frm.add(comm1);
			frm.add(s4);
			frm.add(rate1);
			repno1.setText(String.valueOf(rs.getInt(1)));
			repname1.setText(rs.getString(2));
			state1.setText(rs.getString(3));
			comm1.setText(rs.getString(4));
			rate1.setText(rs.getString(5));
			frm.setVisible(true);
			frm.setSize(300,300);
			frm.setLayout(new GridLayout(2,10));
			}
			} 
			catch (SQLException e) 
			{
			e.printStackTrace();
			}
	}
		}
}
	public static void main(String[] args)
	{
		DBTest dbtest=new DBTest();
	}

}
