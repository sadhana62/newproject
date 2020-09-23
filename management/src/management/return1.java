package management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class return1 extends JFrame {

	private JPanel contentPane;
	private JTextField book;
	private JTextField author1;
	private JTextField id;
	private JTextField name;
	private JTextField text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					return1 frame = new return1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public return1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 394);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel sname = new JLabel("NAME");
		sname.setBounds(72, 42, 46, 14);
		contentPane.add(sname);
		
		JLabel sid = new JLabel("ID");
		sid.setBounds(72, 90, 46, 14);
		contentPane.add(sid);
		
		JLabel author = new JLabel("AUTHOR");
		author.setBounds(63, 143, 55, 14);
		contentPane.add(author);
		
		JLabel bookn = new JLabel("BOOK");
		bookn.setBounds(63, 194, 46, 14);
		contentPane.add(bookn);
		
		JLabel date2 = new JLabel("ISSUED DATE");
		date2.setBounds(48, 241, 70, 14);
		contentPane.add(date2);
		
		JDateChooser date = new JDateChooser();
		date.setBounds(158, 241, 214, 20);
		date.setDateFormatString("yyyy-MM-dd");
		contentPane.add(date);
		
		book = new JTextField();
		book.setBounds(158, 191, 214, 20);
		contentPane.add(book);
		book.setColumns(10);
		
		author1 = new JTextField();
		author1.setBounds(158, 140, 199, 20);
		contentPane.add(author1);
		author1.setColumns(10);
		
		id = new JTextField();
		id.setBounds(158, 87, 201, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setBounds(158, 39, 199, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JDateChooser date23 = new JDateChooser();
		date23.setBounds(158, 296, 214, 20);
		date23.setDateFormatString("yyyy-MM-dd");
		contentPane.add(date23);
		
		JLabel lblNewLabel = new JLabel("RETURN DATE");
		lblNewLabel.setBounds(51, 296, 81, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Get info");
		btnNewButton.setBounds(428, 86, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nm= name.getText();
				String id1= id.getText();
				String author2= author1.getText();
				String bn= book.getText();
				String date1=((JTextField)date.getDateEditor().getUiComponent()).getText();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/create","root","");
					Statement stmt=con.createStatement();
	               String sql=("SELECT author,book,date from issued where student='"+nm+"' and ID= '"+id1+"'" );
	           	ResultSet rs=stmt.executeQuery(sql);
	               if(rs.next())
					{
						author1.setText(rs.getString("author"));
						book.setText(rs.getString("book"));
						((JTextField)date.getDateEditor().getUiComponent()).setText(rs.getString("date"));
						//JOptionPane.showMessageDialog(null, "  succesfull");
					//ques.setText(str1);
					
					}
				}
				catch(Exception e1)
				{
						System.out.println("error"+e1);
						JOptionPane.showMessageDialog(null, " not succesfull");
					}
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SAVE");
		btnNewButton_1.setBounds(428, 190, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nm= name.getText();
				String id1= id.getText();
				String author2= author1.getText();
			
				String bn= book.getText();
				
				
				String date1=((JTextField)date.getDateEditor().getUiComponent()).getText();	
				
				String date3=((JTextField)date23.getDateEditor().getUiComponent()).getText();
			
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/create","root","");
					Statement stmt=con.createStatement();
	               stmt.executeUpdate("INSERT INTO `returntbl` (`Name`, `id`, `author`, `book`, `issued date`, `receied date`) "
	               		+ "VALUES ('"+nm+"', '"+id1+"', '"+author2+"', '"+bn+"', '"+date1+"', '"+date3+"');");
					JOptionPane.showMessageDialog(null, "succesfully Inserted");
					//con.close();
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
//				Date d1= (Date)date.getDate();
//				Date d2= (Date)date23.getDate();
//				long diffinmillies= Math.abs(d1.getTime()-d2.getTime());
//				long diff=TimeUnit.DAYS.convert(diffinmillies,TimeUnit.MILLISECONDS);
//				text.setText(""+diff);
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/create","root","");
					Statement stmt=con.createStatement();
	               stmt.executeUpdate("Delete from issued where ID='"+id1+"'");
					//JOptionPane.showMessageDialog(null, "succesfully Inserted");
					//con.close();
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
					
				}
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/create","root","");
					Statement stmt=con.createStatement();
	               stmt.executeUpdate("INSERT INTO `books` (`S.NO`, `bname`, `author`) VALUES ('"+id1+"', '"+bn+"', '"+author2+"');");
					//JOptionPane.showMessageDialog(null, "succesfully Inserted");
					//con.close();
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
					
				}
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("EXIT");
		btnNewButton_2.setBounds(428, 296, 89, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit();
			}
			//dispose();
			//System.exit();
		});
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("BACK");
		btnNewButton_3.setBounds(428, 23, 89, 23);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				home obj= new home();
				obj.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_3);
		
		text = new JTextField();
		text.setBounds(193, 327, 86, 20);
		contentPane.add(text);
		text.setColumns(10);
	}
}
