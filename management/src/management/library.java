package management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*
;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
public class library {

	public JFrame frmLogin;
	public JTextField username;
	public JPasswordField password;
	public String getuser()
	{
		return(""+username);
	}
	public String getpass()
	{
		return(""+password);
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public JTextField username;
			public void run() {
				try {
					library window = new library();
					window.frmLogin.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public library() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login ");
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		username = new JTextField();
		username.setBounds(148, 38, 159, 20);
		frmLogin.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(148, 80, 159, 20);
		frmLogin.getContentPane().add(password);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frmLogin.dispose();
			inertion obj=new inertion();
			obj.setVisible(true);
			}
		});
		btnNewButton.setBounds(23, 167, 89, 23);
		frmLogin.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/create","root","");
					Statement stmt=con.createStatement();
					String sql="Select * from details where username ='"+username.getText()+"'and password='"+password.getText()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null, "succesfull");
						frmLogin.dispose();
						home obj=new home();
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
		btnNewButton_1.setBounds(159, 167, 89, 23);
		frmLogin.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Forgot pass");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.dispose();
				forgot obj=new forgot();
				obj.setVisible(true);
						
						
						
						
			}
		});
		btnNewButton_2.setBounds(288, 167, 89, 23);
		frmLogin.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("User name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(28, 39, 99, 14);
		frmLogin.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(28, 81, 89, 14);
		frmLogin.getContentPane().add(lblNewLabel_1);
	}
}
