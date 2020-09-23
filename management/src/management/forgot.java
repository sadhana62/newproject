package management;
//import library.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.*
;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;public class forgot extends JFrame {

	private JPanel contentPane;
	private JTextField ans;
	private JButton btnNewButton;
	private JTextField usser;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					forgot frame = new forgot();
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
	public forgot() {
		setTitle("Validation Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ques = new JLabel("");
		ques.setBounds(10, 106, 414, 42);
		contentPane.add(ques);
		
		ans = new JTextField();
		ans.setBounds(154, 177, 208, 20);
		contentPane.add(ans);
		ans.setColumns(10);
		
		btnNewButton = new JButton("Get Recovery Question");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str,str1;
				str=usser.getText();
				//ResultSet rs=null;
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/create","root","");
					Statement stmt=con.createStatement();
					String sql="Select Question from enquary where username ='"+str+"'";
					ResultSet rs=stmt.executeQuery(sql);
				if(rs.next())
					{
						ques.setText(rs.getString("Question"));
						JOptionPane.showMessageDialog(null, "  succesfull");
					//ques.setText(str1);
					
					}
				else
						JOptionPane.showMessageDialog(null, " not succesfull");
					con.close();

			}catch(Exception e1)
			{
					System.out.println("error"+e1);
				}
				
			
			}
		});
		btnNewButton.setBounds(84, 83, 243, 23);
		contentPane.add(btnNewButton);
		
		JButton check = new JButton("ckeck");
		check.setFont(new Font("Tahoma", Font.PLAIN, 13));
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/create","root","");
					Statement stmt=con.createStatement();
					String sql="SELECT username,answer FROM `enquary` WHERE username='"+usser.getText()+"'and answer='"+ans.getText()+"'";
					
					ResultSet rs=stmt.executeQuery(sql);
					//JOptionPane.showMessageDialog(null,rs);
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null, " succesfull");
						dispose();
						updatepass obj= new updatepass();
						obj.setVisible(true);
						
					}
					else
						JOptionPane.showMessageDialog(null, " not succesfull");
					con.close();

				}catch(Exception e1)
				{
					System.out.println("error"+e1);
				}
				
			}
		});
		check.setBounds(71, 227, 230, 23);
		contentPane.add(check);
		
		usser = new JTextField();
		usser.setBounds(154, 35, 230, 20);
		contentPane.add(usser);
		usser.setColumns(10);
		
		lblNewLabel = new JLabel("User Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(22, 38, 101, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Answer");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(22, 179, 61, 14);
		contentPane.add(lblNewLabel_1);
	
	}
}
