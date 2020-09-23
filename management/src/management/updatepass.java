package management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class updatepass extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JTextField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updatepass frame = new updatepass();
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
	public updatepass() {
		setTitle("RESET PASSWORD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		user = new JTextField();
		user.setBounds(110, 87, 205, 20);
		contentPane.add(user);
		user.setColumns(10);
		
		pass = new JTextField();
		pass.setBounds(110, 132, 205, 20);
		contentPane.add(pass);
		pass.setColumns(10);
		
		JButton btnNewButton = new JButton("Apply");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str,str2;
				//str=user.getText();
				library obj=new library();
				str=obj.getuser();
				str2=pass.getText();
				//ResultSet rs=null;
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/create","root","");
					Statement stmt=con.createStatement();
					//String sql="Update enquary where username ='"+user+"' set password='"+str2+"'"  ;
					stmt.executeUpdate("Update enquary  set password='"+str2+"'where username ='"+str+"'");
				
					JOptionPane.showMessageDialog(null, "  succesfull");
					dispose();
					home obj= new home();
					obj.setVisible(true);
					
			
						//JOptionPane.showMessageDialog(null, " not succesfull");
					con.close();

			}catch(Exception e1)
			{
					System.out.println("error"+e1);
				}
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/create","root","");
					Statement stmt=con.createStatement();
					//String sql="Update enquary where username ='"+user+"' set password='"+str2+"'"  ;
					stmt.executeUpdate("Update Details  set password='"+str2+"'where username ='"+str+"'");
				
					JOptionPane.showMessageDialog(null, "  succesfull");
					
			
						//JOptionPane.showMessageDialog(null, " not succesfull");
					con.close();

			}catch(Exception e1)
			{
					System.out.println("error"+e1);
				}
			}
		});
		btnNewButton.setBounds(147, 185, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("RESET PASSWORD");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(110, 23, 188, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 88, 90, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PassWord");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 133, 71, 14);
		contentPane.add(lblNewLabel_2);
	}
}
