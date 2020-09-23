package management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.util.Date;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
public class home extends JFrame {

	private JPanel contentPane;
	private JTextField student;
	private JTextField bookname;
	private JTextField id;
	private JTextField author;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
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
	public home() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 469);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NATIONAL LIBRARY");
		lblNewLabel.setForeground(new Color(255, 0, 102));
		lblNewLabel.setBounds(186, 23, 255, 27);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		contentPane.add(lblNewLabel);
		 
		 Panel panel = new Panel();
		 panel.setBackground(Color.LIGHT_GRAY);
		 panel.setBounds(39, 70, 479, 256);
		 contentPane.add(panel);
		 panel.setLayout(null);
		 
		 JLabel lblNewLabel_2 = new JLabel("Student Name");
		 lblNewLabel_2.setBounds(28, 41, 81, 16);
		 panel.add(lblNewLabel_2);
		 lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 
		 JLabel lblNewLabel_3 = new JLabel("Book Name");
		 lblNewLabel_3.setBounds(28, 68, 78, 14);
		 panel.add(lblNewLabel_3);
		 lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 
		 JLabel lblNewLabel_4 = new JLabel("Date");
		 lblNewLabel_4.setBounds(28, 93, 78, 14);
		 panel.add(lblNewLabel_4);
		 lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 
		 student = new JTextField();
		 student.setBounds(133, 40, 253, 20);
		 panel.add(student);
		 student.setColumns(10);
		 
		 bookname = new JTextField();
		 bookname.setBounds(133, 66, 253, 20);
		 panel.add(bookname);
		 bookname.setColumns(10);
		 JDateChooser jDatechosser1 = new JDateChooser();
		 jDatechosser1.setDateFormatString("yyyy-MM-dd");
		  jDatechosser1.setBounds(133, 93, 214, 20);
		  panel.add(jDatechosser1);
		  
		  
		  JLabel lblNewLabel_5 = new JLabel("Issued Book");
		  lblNewLabel_5.setForeground(Color.BLUE);
		  lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		  lblNewLabel_5.setBounds(28, 11, 114, 14);
		  panel.add(lblNewLabel_5);
		  
		  JLabel lblNewLabel_6 = new JLabel("ID");
		  lblNewLabel_6.setBounds(28, 126, 46, 14);
		  panel.add(lblNewLabel_6);
		  
		  JLabel lblNewLabel_7 = new JLabel("Author name");
		  lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		  lblNewLabel_7.setBounds(28, 151, 81, 14);
		  panel.add(lblNewLabel_7);
		  
		  id = new JTextField();
		  id.setBounds(133, 124, 224, 20);
		  panel.add(id);
		  id.setColumns(10);
		  
		  author = new JTextField();
		  author.setBounds(133, 148, 224, 20);
		  panel.add(author);
		  author.setColumns(10);
		  
		  JButton btnNewButton_5 = new JButton("Get info");
		  
		  btnNewButton_5.setBounds(368, 93, 89, 23);
		  panel.add(btnNewButton_5);
		  
		  JButton btnNewButton_3 = new JButton("Submit");
		  btnNewButton_3.setBounds(195, 201, 89, 23);
		  panel.add(btnNewButton_3);
		  btnNewButton_3.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		String nm=student.getText();
		  		String bk=bookname.getText();
		  		String id1=id.getText();
		  		String author1=author.getText();
		  		String dt=((JTextField)jDatechosser1.getDateEditor().getUiComponent()).getText();
		  		//int value=Integer.parseInt(dt);
		  		//System.out.print(value);
		  		
		  		
		  		try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/create","root","");
					Statement stmt=con.createStatement();
	               stmt.executeUpdate("INSERT INTO `issued` (`student`, `book`, `date`,`ID`,`author`) VALUES ('"+nm+"', '"+bk+"', '"+dt+"','"+id1+"','"+author1+"');");
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
	               stmt.executeUpdate("Delete from books where bname='"+bk+"'");
					//JOptionPane.showMessageDialog(null, "succesfully Inserted");
					//con.close();
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
					
				}
		  	}
		  });
		  
		 
		  JButton btnNewButton = new JButton("Return");
		  btnNewButton.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		dispose();
		  		return1 obj= new return1();
		  		obj.setVisible(true);
		  		
		  		
		  		
		  	}
		  });
		  btnNewButton.setBounds(566, 80, 111, 23);
		  contentPane.add(btnNewButton);
		  
		  JButton btnNewButton_1 = new JButton("View Book");
		  btnNewButton_1.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		dispose();
		  		book obj= new book();
		  		obj.setVisible(true);
		  	}
		  });
		  btnNewButton_1.setBounds(566, 150, 111, 23);
		  contentPane.add(btnNewButton_1);
		  
		  JButton btnNewButton_2 = new JButton("Exit");
		  btnNewButton_2.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		System.exit(0);
		  	}
		  });
		  btnNewButton_2.setBounds(574, 303, 103, 23);
		  contentPane.add(btnNewButton_2);
		  
		  JButton btnNewButton_4 = new JButton("Issued book");
		  btnNewButton_4.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		dispose();
		  		issuedbook obj= new issuedbook();
		  		obj.setVisible(true);
		  	}
		  });
		  btnNewButton_4.setBounds(566, 207, 115, 23);
		  contentPane.add(btnNewButton_4);
		  
		  JButton btnNewButton_6 = new JButton("ADD books");
		  btnNewButton_6.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		dispose();
		  		addbook obj= new addbook();
		  		obj.setVisible(true);
		  		
		  	}
		  	
		  });
		  btnNewButton_6.setBounds(574, 254, 103, 23);
		  contentPane.add(btnNewButton_6);
		  btnNewButton_5.addActionListener(new ActionListener() {
			  	public void actionPerformed(ActionEvent e) {
			  		String nm=student.getText();
			  		String bk=bookname.getText();
			  		String id1=id.getText();
			  		String author1=author.getText();
			  		String dt=((JTextField)jDatechosser1.getDateEditor().getUiComponent()).getText();
			  		//int value=Integer.parseInt(dt);
			  		try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/create","root","");
						Statement stmt=con.createStatement();
		               String sql=("SELECT `s.no`,author from books where bname='"+bk+"'");
		           	ResultSet rs=stmt.executeQuery(sql);
		               if(rs.next())
						{
							id.setText(rs.getString(1));
							author.setText(rs.getString("author"));
							//JOptionPane.showMessageDialog(null, "  succesfull");
						//ques.setText(str1);
						
						}
						//JOptionPane.showMessageDialog(null, "succesfully Inserted");
						//con.close();
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
						
					}
			  	}
			  });
		 
		//UtilDateModel model= new UtilDateModel();
	}
}
