package management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class addbook extends JFrame {

	private JPanel contentPane;
	private JTextField bk;
	private JTextField au;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addbook frame = new addbook();
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
	public addbook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTER BOOKS DETAILS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(103, 11, 279, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BOOK NAME");
		lblNewLabel_1.setBounds(73, 79, 100, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("AUTHOR NAME");
		lblNewLabel_2.setBounds(73, 121, 87, 14);
		contentPane.add(lblNewLabel_2);
		
		bk = new JTextField();
		bk.setBounds(209, 76, 140, 20);
		contentPane.add(bk);
		bk.setColumns(10);
		
		au = new JTextField();
		au.setBounds(209, 118, 140, 20);
		contentPane.add(au);
		au.setColumns(10);
		
		JButton btnNewButton = new JButton("OKAY");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String book= bk.getText();
				String auth=au.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/create","root","");
					Statement stmt=con.createStatement();
	               stmt.executeUpdate("INSERT INTO `books` ( `bname`, `author`) VALUES ('"+book+"', '"+auth+"');");
					//JOptionPane.showMessageDialog(null, "succesfully Inserted");
					//con.close();
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
					
				}
			}
		});
		btnNewButton.setBounds(149, 182, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				home obj= new home();
				obj.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(293, 182, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
