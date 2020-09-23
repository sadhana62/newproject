package management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class issuedbook extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					issuedbook frame = new issuedbook();
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
	public issuedbook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Get data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int sno;
				String bk,au;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/create","root","");
					Statement stmt=con.createStatement();
					String sql="Select * from issued ";
					ResultSet rs=stmt.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));

						stmt.close();
						
						JOptionPane.showMessageDialog(null, "  succesfull");
					//ques.setText(str1);
					
					
				
						//JOptionPane.showMessageDialog(null, " not succesfull");
					con.close();

			}catch(Exception e1)
			{
					System.out.println("error"+e1);
					JOptionPane.showMessageDialog(null, " not succesfull");
				}
				
			}
			
		});
		btnNewButton.setBounds(187, 11, 135, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(73, 68, 348, 228);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				home obj= new home();
				obj.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(38, 11, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
