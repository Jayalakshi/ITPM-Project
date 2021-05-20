package pckg;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;


import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Manage_Subject extends JFrame {
	private static final long serialVersionUID = 1L;
	JFrame frame4;
 	static JTable Table2;
	private JTextField txtsubjectcode;
	private JTextField txtsubjectname;
	
	
	
	public static void AddRowToJTable(Object[] dataRow) {
		DefaultTableModel model = (DefaultTableModel)Table2.getModel();
		model.addRow(dataRow);
	}
	
	public void table_load()
    {
		try {
     	   Class.forName("com.mysql.cj.jdbc.Driver");
     	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","Abcd123#");
     	   String sql = "select * from itpm.subject";
     	 PreparedStatement ps = conn.prepareStatement(sql);
     	  
     	  
     	  ResultSet rs = ps.executeQuery();
     	  Table2.setModel(DbUtils.resultSetToTableModel(rs));
     	  
	} catch (Exception e) 
    	 {
    		e.printStackTrace();
	  } 
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage_Subject window = new Manage_Subject();
					window.frame4.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Manage_Subject() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame4 = new JFrame();
		frame4.setBounds(100, 100, 1019, 705);
		frame4.getContentPane().setBackground(new Color(243,235,242));
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame4.getContentPane().setLayout(null);
		
		JLabel lblManageSubjects = new JLabel("MANAGE SUBJECTS");
		lblManageSubjects.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblManageSubjects.setBounds(338, 21, 339, 48);
		frame4.getContentPane().add(lblManageSubjects);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 127, 680, 120);
		frame4.getContentPane().add(scrollPane);
		
		Table2 = new JTable();
		Table2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		Table2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Subject Code", "Subject Name", "Offered Year", "offered Sem", "Lec Hrs", "Tute Hrs", "Lab Hrs", "Evaluation Hrs"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		Table2.getColumnModel().getColumn(0).setPreferredWidth(103);
		Table2.getColumnModel().getColumn(1).setPreferredWidth(78);
		Table2.getColumnModel().getColumn(2).setPreferredWidth(92);
		Table2.getColumnModel().getColumn(3).setPreferredWidth(87);
		Table2.getColumnModel().getColumn(4).setPreferredWidth(80);
		Table2.getColumnModel().getColumn(5).setPreferredWidth(92);
		scrollPane.setViewportView(Table2);
		
		JLabel lblNewLabel_1 = new JLabel("Subject Code");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(44, 257, 136, 31);
		frame4.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Subject Name");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(40, 335, 157, 31);
		frame4.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Offered Year");
		lblNewLabel_1_2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(30, 414, 136, 31);
		frame4.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Offered Semester");
		lblNewLabel_1_3.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(30, 499, 167, 31);
		frame4.getContentPane().add(lblNewLabel_1_3);
		
		JComboBox cmboffyear = new JComboBox();
		cmboffyear.setBounds(231, 420, 193, 28);
		frame4.getContentPane().add(cmboffyear);
		cmboffyear .addItem("Select");
		cmboffyear .addItem("1");
		cmboffyear .addItem("2");
		cmboffyear .addItem("3");
		cmboffyear .addItem("4");
		
		JComboBox cmboffsem = new JComboBox();
		cmboffsem.setBounds(231, 499, 193, 28);
		frame4.getContentPane().add(cmboffsem);
		cmboffsem .addItem("Select");
		cmboffsem .addItem("1");
		cmboffsem .addItem("2");
		
		txtsubjectcode = new JTextField();
		txtsubjectcode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtsubjectcode.setColumns(10);
		txtsubjectcode.setBounds(216, 262, 208, 28);
		frame4.getContentPane().add(txtsubjectcode);
		
		txtsubjectname = new JTextField();
		txtsubjectname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtsubjectname.setColumns(10);
		txtsubjectname.setBounds(216, 340, 208, 28);
		frame4.getContentPane().add(txtsubjectname);
		
		JLabel lblNewLabel_1_4 = new JLabel("Number Of Lecture Hours");
		lblNewLabel_1_4.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(536, 257, 218, 31);
		frame4.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Number Of Tutorial Hours");
		lblNewLabel_1_5.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_5.setBounds(536, 335, 218, 31);
		frame4.getContentPane().add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Number Of Lab Hours");
		lblNewLabel_1_6.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_6.setBounds(536, 414, 218, 31);
		frame4.getContentPane().add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Number Of Evaluation Hours");
		lblNewLabel_1_7.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_7.setBounds(536, 499, 252, 31);
		frame4.getContentPane().add(lblNewLabel_1_7);
		
		JComboBox cmblecHrs = new JComboBox();
		cmblecHrs.setBounds(827, 257, 101, 28);
		frame4.getContentPane().add(cmblecHrs);
		cmblecHrs .addItem("Select");
		cmblecHrs .addItem("1");
		cmblecHrs .addItem("2");
		cmblecHrs .addItem("3");
		
		JComboBox cmbtuteHrs = new JComboBox();
		cmbtuteHrs.setBounds(827, 338, 101, 28);
		frame4.getContentPane().add(cmbtuteHrs);
		cmbtuteHrs .addItem("Select");
		cmbtuteHrs .addItem("1");
		cmbtuteHrs .addItem("2");
		cmbtuteHrs .addItem("3");
		
		JComboBox cmblabHrs = new JComboBox();
		cmblabHrs.setBounds(827, 420, 101, 28);
		frame4.getContentPane().add(cmblabHrs);
		cmblabHrs .addItem("Select");
		cmblabHrs .addItem("1");
		cmblabHrs .addItem("2");
		cmblabHrs .addItem("3");
	
		
		JComboBox cmbevalHrs = new JComboBox();
		cmbevalHrs.setBounds(827, 509, 101, 28);
		frame4.getContentPane().add(cmbevalHrs);
		cmbevalHrs .addItem("Select");
		cmbevalHrs .addItem("1");
		cmbevalHrs .addItem("2");
		cmbevalHrs .addItem("3");
		
		
		JButton btnHome_2 = new JButton("Home");
		btnHome_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHome_2.setBounds(51, 584, 129, 48);
		frame4.getContentPane().add(btnHome_2);
		
		JButton btnNext_2 = new JButton("Next");
		btnNext_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame4.dispose();
				Add_Session add_session = new Add_Session();
				add_session.frame5.setVisible(true);
			}
		});
		btnNext_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNext_2.setBounds(780, 584, 129, 48);
		frame4.getContentPane().add(btnNext_2);
		
		
		JButton btnUpdate2 = new JButton("Update");
		btnUpdate2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
	             	   Class.forName("com.mysql.cj.jdbc.Driver");
	             	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","Abcd123#");
	             	  PreparedStatement ps=conn.prepareStatement("UPDATE subject SET subject_name=?, offered_year=?, offered_semester=?, lecture_hour=?, tute_hour=?, lab_hour=?, evaluation_hour=? where subject_code=?");
	             	  	ps.setString(1,txtsubjectname.getText());
	             	   ps.setString(2,cmboffyear.getSelectedItem().toString());
	             	   ps.setString(3,cmboffsem.getSelectedItem().toString());
	             	   ps.setString(4,cmblecHrs.getSelectedItem().toString());
	             	   ps.setString(5,cmbtuteHrs.getSelectedItem().toString());
	             	   ps.setString(6,cmblabHrs.getSelectedItem().toString());
	             	   ps.setString(7,cmbevalHrs.getSelectedItem().toString());
	             	   ps.setString(8,txtsubjectcode.getText());
	             	   ps.executeUpdate();
	             	 table_load();
	             	 JOptionPane.showMessageDialog(null, "Record Update!!!!!");
	           
	             	   
	             	
	             	
	    					
					 }catch(Exception e1) {
						 System.out.println(e1);
					 }
			}
		});
		btnUpdate2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate2.setBounds(722, 185, 129, 48);
		frame4.getContentPane().add(btnUpdate2);
		
		
		JButton btnRefresh2 = new JButton("Refresh");
		btnRefresh2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
              	   Class.forName("com.mysql.cj.jdbc.Driver");
              	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","Abcd123#");
              	   String sql = "select * from subject";
              	 PreparedStatement ps = conn.prepareStatement(sql);
              	   ResultSet rs = ps.executeQuery();
              	  Table2.setModel(DbUtils.resultSetToTableModel(rs));
				   
			 }catch(Exception e1) {
				 System.out.println(e1);
			 }
			}
		});
		btnRefresh2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRefresh2.setBounds(851, 23, 129, 48);
		frame4.getContentPane().add(btnRefresh2);
		
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 DefaultTableModel dtm = (DefaultTableModel) Table2.getModel(); 
	    			int selectedRowIndex = Table2.getSelectedRow(); 
	    				String id = (String) dtm.getValueAt(selectedRowIndex, 0); 
	    
					try {  
						Class.forName("com.mysql.cj.jdbc.Driver");
			     	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","Abcd123#");
						Statement st = conn.createStatement();
						 ResultSet r=st.executeQuery("select * from subject where subject_code='"+id+"'");
						 while (r.next()) {  
							 txtsubjectcode.setText(r.getString("subject_code"));
							 txtsubjectname.setText(r.getString("subject_name"));
							 cmboffyear.setSelectedItem(r.getString("offered_year"));  
							 cmboffsem.setSelectedItem(r.getString("offered_semester"));
							 cmblecHrs.setSelectedItem(r.getString("lecture_hour"));
							 cmbtuteHrs.setSelectedItem(r.getString("tute_hour"));
							 cmblabHrs.setSelectedItem(r.getString("lab_hour"));
							 cmbevalHrs.setSelectedItem(r.getString("evaluation_hour"));
						
						 }

						    conn.close();
						    } catch (Exception erorr) {  
						JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE);  
						System.exit(0);  
						} 
			}
		});
	
		
		btnSelect.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSelect.setBounds(781, 118, 167, 48);
		frame4.getContentPane().add(btnSelect);
		
		JButton btnDelete2 = new JButton("Delete");
		btnDelete2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					 Class.forName("com.mysql.cj.jdbc.Driver");
	             	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","Abcd123#");

	             	   	int row = Table2.getSelectedRow();
	             	   	String value=(Table2.getModel().getValueAt(row, 0).toString());
	             		PreparedStatement ps=conn.prepareStatement("delete from subject where subject_code='"+value+"'");
		             	ps.executeUpdate();
		         	  	table_load();
		         	  	JOptionPane.showMessageDialog(null, "Your data deleted successfully!!!!!");
	             	  				
	             	  	conn.close();
		}catch(Exception e1) {
			 System.out.println(e1);
		 }
		}
	});
		
		btnDelete2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete2.setBounds(870, 185, 114, 48);
		frame4.getContentPane().add(btnDelete2);
		
		
		
		
	}
}
