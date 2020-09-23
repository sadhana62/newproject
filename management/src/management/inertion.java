package management;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;

public class inertion extends JFrame {

	private JPanel contentPane;
	private JTextField phone1;
	private JTextField textField_2;
	private JTextField name1;
	private JTextField textField_4;
	private JTextField ans;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inertion frame = new inertion();
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
	public inertion() {
		setTitle("Insert data");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel name = new JLabel("Name");
		name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		name.setBounds(49, 75, 69, 14);
		contentPane.add(name);
		
		phone1 = new JTextField();
		phone1.setBounds(186, 106, 141, 20);
		contentPane.add(phone1);
		phone1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(186, 243, 141, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		name1 = new JTextField();
		name1.setBounds(186, 69, 141, 20);
		contentPane.add(name1);
		name1.setColumns(10);
		
		JLabel phone = new JLabel("Phone no");
		phone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		phone.setBounds(49, 107, 69, 14);
		contentPane.add(phone);
		
		JLabel question = new JLabel("Generate your Recovery Question:");
		question.setFont(new Font("Tahoma", Font.PLAIN, 14));
		question.setBounds(45, 137, 240, 20);
		contentPane.add(question);
		
		JLabel lblNewLabel_3 = new JLabel("User Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(45, 243, 73, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Pass word");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(45, 268, 96, 23);
		contentPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(186, 274, 141, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nam=name1.getText();
				String phon=phone1.getText();
				String ques=textField.getText();
				String ans1=ans.getText();
				
				String user=textField_2.getText();
				//System.out.print(user);
				String pass=textField_4.getText();
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/create","root","");
					Statement stmt=con.createStatement();
	               stmt.executeUpdate("INSERT INTO `enquary` (`Name`, `Phone`, `Question`, `Answer`, `username`, `password`) VALUES ('"+nam+"', '"+phon+"', '"+ques+"', '"+ans1+"', '"+user+"', '"+pass+"');");
					JOptionPane.showMessageDialog(null, "succesfully Inserted");
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
					stmt.executeUpdate("INSERT INTO `details` (`username`, `password`) VALUES ('"+user+"', '"+pass+"');");
				
					JOptionPane.showMessageDialog(null, "succesfully Inserted");
					con.close();
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
			
		});
		btnNewButton.setBounds(438, 88, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login Now");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	           dispose();
				library window = new library();
				window.frmLogin.setVisible(true);
				 
			}
			
		});
		btnNewButton_1.setBounds(449, 242, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel ans1 = new JLabel("Answer");
		ans1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ans1.setBounds(45, 207, 89, 14);
		contentPane.add(ans1);
		
		ans = new JTextField();
		ans.setBounds(186, 206, 141, 20);
		contentPane.add(ans);
		ans.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(10, 168, 571, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Your Details:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(49, 21, 388, 29);
		contentPane.add(lblNewLabel);
	}
}
