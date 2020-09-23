package management;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Font;

public class book extends JFrame {
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					book frame = new book();
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
	public book() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 375);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Books");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(88, 24, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Get data");
		btnNewButton.setBounds(285, 22, 89, 23);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 76, 436, 249);
		getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				home obj= new home();
				obj.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(428, 22, 89, 23);
		getContentPane().add(btnNewButton_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel)table_1.getModel();
				int sno;
				String bk,au;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/create","root","");
					Statement stmt=con.createStatement();
					String sql="Select * from books ";
					ResultSet rs=stmt.executeQuery(sql);
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
//				while(rs.next())
//					{
//						
//						 sno=rs.getInt("S.NO");
//						bk=rs.getString("bname");
//						au=rs.getString("author");
//								model.addRow(new Object[] {sno,bk,au});
//					}
//						rs.close();
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
	
//		getContentPane().setLayout(null);
//		getContentPane().setLayout(null);
//		getContentPane().setLayout(null);
	}
}
