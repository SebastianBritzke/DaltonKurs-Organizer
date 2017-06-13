import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
//import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.*;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;
import java.awt.Button;
import javax.swing.JPasswordField;
import javax.swing.JSlider;
import javax.swing.JToggleButton;

public class gui extends db {

	private JPanel contentPane;
	private JTextField t;
	private JTextField t1;
	private JTextField t2;
	JFrame f = new JFrame();
	private JTable table;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				try 
				{
					gui frame = new gui();
					frame.f.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public gui() {
		
		initComponents();
		bActions();
		
	}

	public void initComponents(){
		
		//JOptionPane.showMessageDialog(null, "message");
		

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 593, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		f.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		t = new JTextField();	
		t.setBounds(48, 312, 86, 20);
		contentPane.add(t);
		t.setColumns(10);
		
		t1 = new JTextField();
		t1.setBounds(179, 312, 86, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(327, 312, 86, 20);
		contentPane.add(t2);
		t2.setColumns(10);
		
		JLabel fname = new JLabel("First Name");
		fname.setBounds(53, 282, 46, 14);
		contentPane.add(fname);
		
		JLabel lname = new JLabel("Last Name");
		lname.setBounds(179, 287, 46, 14);
		contentPane.add(lname);
		
		JLabel age = new JLabel("Age");
		age.setBounds(327, 287, 46, 14);
		contentPane.add(age);
			
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 34, 538, 145);
		contentPane.add(scrollPane);
			
		table = new JTable();
		scrollPane.setViewportView(table);
		
		try
		{			
			rs.next();
			t.setText(rs.getString("Fname"));
			t1.setText(rs.getString("Lname"));
			t2.setText(rs.getString("Age"));
			
		}
		catch(Exception ex){}
			
	}
	private void bActions() {
		JButton b1 = new JButton("Next");
		b1.setBounds(45, 190, 89, 23);
		contentPane.add(b1);
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					if(rs.next()){
						t.setText(rs.getString("Fname"));
						t1.setText(rs.getString("Lname"));
						t2.setText(rs.getString("Age"));
					}
					else
					{
						rs.previous();
						JOptionPane.showMessageDialog(null, "No more records");
					}
				} catch (Exception e1) {}
			}
		});

		JButton b2 = new JButton("Previous");
		b2.setBounds(45, 224, 89, 23);
		contentPane.add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				try {
					if(rs.previous()){
						t.setText(rs.getString("Fname"));
						t1.setText(rs.getString("Lname"));
						t2.setText(rs.getString("Age"));
					}
					else
					{
						rs.next();
						JOptionPane.showMessageDialog(null, "No more records");
					} 
				}
					catch (Exception e2) {}
			}
		});

			
		JButton b3 = new JButton("Last");
		b3.setBounds(179, 190, 89, 23);
		contentPane.add(b3);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					rs.last();
					t.setText(rs.getString("Fname"));
					t1.setText(rs.getString("Lname"));
					t2.setText(rs.getString("Age"));					
				}
					catch (Exception e2) {}
			}
		});

		
		JButton b4 = new JButton("First");
		b4.setBounds(179, 224, 89, 23);
		contentPane.add(b4);
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					rs.first();
					t.setText(rs.getString("Fname"));
					t1.setText(rs.getString("Lname"));
					t2.setText(rs.getString("Age"));					
				}
					catch (Exception e2) {}
			}
		});
		
		JButton load = new JButton("Load");
		load.setBounds(232, 0, 89, 23);
		contentPane.add(load);
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					rs = st.executeQuery("select Fname, Lname, Age from Table1");
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} 
				catch (Exception e) {}
			}
		});
		
		JButton up = new JButton("Update");
		up.setBounds(315, 190, 89, 23);
		contentPane.add(up);
		up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fname = t.getText();
				String lname = t1.getText();
				String age   = t2.getText();
				
				try {
					
					rs.updateString("Fname", fname);
					rs.updateString("Lname", lname);
					rs.updateString("Age", age);
					rs.updateRow();
					
					JOptionPane.showMessageDialog(null,"Record updated");
				} catch (Exception e2) {}
			}
		});

				
		JButton del = new JButton("Delete");
		del.setBounds(315, 224, 89, 23);
		contentPane.add(del);
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					rs.deleteRow();
					st.close();
					rs.close();
					
					st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
					String sql = "select * from Table1";
					rs = st.executeQuery(sql);	
					
					rs.next();
					
					t.setText(rs.getString("Fname"));
					t1.setText(rs.getString("Lname"));
					t2.setText(rs.getString("Age"));
					
				} catch (Exception e2) {}
			}
		});
				
		JButton nw = new JButton("New");
		nw.setBounds(448, 190, 89, 23);
		contentPane.add(nw);
		nw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				t.setText(" ");
				t1.setText(" ");
				t2.setText(" ");
			}
		});

		
		JButton save = new JButton("Save");
		save.setBounds(448, 224, 89, 23);
		contentPane.add(save);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fname = t.getText();
				String lname = t1.getText();
				String age = t2.getText();
				
				try {
					
					rs.moveToInsertRow();
					rs.updateString("Fname", fname);
					rs.updateString("Lname", lname);
					rs.updateString("Age", age);
					rs.insertRow();
					
					st.close();
					rs.close();
					
					st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
					String sql = "select * from Table1";
					rs = st.executeQuery(sql);	
					
					rs.next();
					
					t.setText(rs.getString("Fname"));
					t1.setText(rs.getString("Lname"));
					t2.setText(rs.getString("Age"));
					
				} catch (Exception e2) {}
			}
		});

	}
}

