package pckg;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;


import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Manage_Session {
	private static final long serialVersionUID = 1L;
	 JFrame frame6;
	static JTable Table3;
	private JTextField txtDuration;
	private JTextField txt_No_Student;
	private JTextField txtID;
	private JTextField txt_time;
	private JTextField textSearch;

	public static void AddRowToJTable(Object[] dataRow) {
		DefaultTableModel model = (DefaultTableModel)Table3.getModel();
		model.addRow(dataRow);
	}
	
	public void table_load()
    {
		try {
     	   Class.forName("com.mysql.cj.jdbc.Driver");
     	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","Abcd123#");
     	   String sql = "select * from itpm.session_detail";
     	 PreparedStatement ps = conn.prepareStatement(sql);
     	  
     	  
     	  ResultSet rs = ps.executeQuery();
     	  Table3.setModel(DbUtils.resultSetToTableModel(rs));
     	  
	} catch (Exception e) 
    	 {
    		e.printStackTrace();
	  } 
    }

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage_Session window = new Manage_Session();
					window.frame6.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Manage_Session() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame6 = new JFrame();
		frame6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame6.getContentPane().setBackground(new Color(243,235,242));
		frame6.setBounds(100, 100, 1109, 852);
		frame6.getContentPane().setBackground(new Color(243,235,242));
		frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame6.getContentPane().setLayout(null);
		
		JLabel lblManageSessions = new JLabel("MANAGE SESSIONS");
		lblManageSessions.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblManageSessions.setBounds(370, 50, 339, 48);
		frame6.getContentPane().add(lblManageSessions);
		
		JLabel lbl1 = new JLabel("Lecturer 1");
		lbl1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lbl1.setBounds(116, 370, 157, 31);
		frame6.getContentPane().add(lbl1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Select Tag");
		lblNewLabel_1_1_2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_1_2.setBounds(125, 427, 99, 31);
		frame6.getContentPane().add(lblNewLabel_1_1_2);
		
		
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Select Group");
		lblNewLabel_1_1_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(116, 486, 157, 31);
		frame6.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Select Subject");
		lblNewLabel_1_1_1_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(116, 548, 157, 31);
		frame6.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Select Subject Code ");
		lblNewLabel_1_1_2_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_1_2_1.setBounds(505, 486, 185, 31);
		frame6.getContentPane().add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Duration (Hrs)");
		lblNewLabel_1_1_3.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_1_3.setBounds(499, 427, 157, 31);
		frame6.getContentPane().add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("No Of Students");
		lblNewLabel_1_1_4.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_1_4.setBounds(499, 548, 157, 31);
		frame6.getContentPane().add(lblNewLabel_1_1_4);
		
		JComboBox cmb_lecturer1 = new JComboBox();
		cmb_lecturer1.setBounds(286, 370, 157, 28);
		frame6.getContentPane().add(cmb_lecturer1);
		cmb_lecturer1.addItem("Select");
		try {  
		Class.forName("com.mysql.cj.jdbc.Driver");
 	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","Abcd123#");
		Statement st = conn.createStatement();
		 ResultSet r=st.executeQuery("select lecturer_name from lecturer");
		 while (r.next()) {  
			 cmb_lecturer1.addItem(r.getString("lecturer_name"));  
			 }
			  conn.close();
		    } catch (Exception e) {  
		JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE);  
		System.exit(0);  
		} 
	
		JComboBox cmb_lecturer2 = new JComboBox();
		cmb_lecturer2.setBounds(672, 370, 157, 28);
		frame6.getContentPane().add(cmb_lecturer2);
		cmb_lecturer2.addItem("Select");
		try {  
		Class.forName("com.mysql.cj.jdbc.Driver");
 	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","Abcd123#");
		Statement st = conn.createStatement();
		 ResultSet r=st.executeQuery("select lecturer_name from lecturer");
		 while (r.next()) {  
			 cmb_lecturer2.addItem(r.getString("lecturer_name"));  
			 }
			  conn.close();
		    } catch (Exception e) {  
		JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE);  
		System.exit(0);  
		} 
		
		JComboBox cmb_tag = new JComboBox();
		cmb_tag.setBounds(286, 433, 157, 28);
		frame6.getContentPane().add(cmb_tag);
		cmb_tag .addItem("Select");
		cmb_tag .addItem("Lecture");
		cmb_tag .addItem("Tutorial");
		cmb_tag .addItem("Lab");
		
		JComboBox cmbSubCode = new JComboBox();
		cmbSubCode.setBounds(705, 492, 137, 28);
		frame6.getContentPane().add(cmbSubCode);
		cmbSubCode.addItem("Select");
		try {  
		Class.forName("com.mysql.cj.jdbc.Driver");
 	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","Abcd123#");
		Statement st = conn.createStatement();
		 ResultSet r=st.executeQuery("select subject_code from subject");
		 while (r.next()) {  
			 cmbSubCode.addItem(r.getString("subject_code"));  
			 }
			  conn.close();
		    } catch (Exception e) {  
		JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE);  
		System.exit(0);  
		} 
		
		JComboBox cmbSubject = new JComboBox();
		cmbSubject.setBounds(292, 551, 151, 28);
		frame6.getContentPane().add(cmbSubject);
		cmbSubject.addItem("Select");
		try {  
		Class.forName("com.mysql.cj.jdbc.Driver");
 	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","Abcd123#");
		Statement st = conn.createStatement();
		 ResultSet r=st.executeQuery("select subject_name from subject");
		 while (r.next()) {  
			 cmbSubject.addItem(r.getString("subject_name"));  
			 }
			  conn.close();
		    } catch (Exception e) {  
		JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE);  
		System.exit(0);  
		} 
		
		JComboBox cmbGroup = new JComboBox();
		cmbGroup.setBounds(292, 492, 151, 28);
		frame6.getContentPane().add(cmbGroup);
		cmbGroup.addItem("Select");
		cmbGroup.addItem("Y1S1 IT.1");
		cmbGroup.addItem("Y1S1 IT.2");
		cmbGroup.addItem("Y2S1 IT.1");
		cmbGroup.addItem("Y2S2 IT.2");
		
		
		
		txtDuration = new JTextField();
		txtDuration.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDuration.setColumns(10);
		txtDuration.setBounds(685, 432, 157, 28);
		frame6.getContentPane().add(txtDuration);
		
		txt_No_Student = new JTextField();
		txt_No_Student.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_No_Student.setColumns(10);
		txt_No_Student.setBounds(691, 553, 151, 28);
		frame6.getContentPane().add(txt_No_Student);
		
		JLabel lbl2 = new JLabel("Lecturer 2");
		lbl2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lbl2.setBounds(499, 370, 157, 31);
		frame6.getContentPane().add(lbl2);
		
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblId.setBounds(116, 307, 157, 31);
		frame6.getContentPane().add(lblId);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtID.setColumns(10);
		txtID.setBounds(264, 310, 268, 28);
		frame6.getContentPane().add(txtID);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Available Day");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1.setBounds(116, 611, 157, 31);
		frame6.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		JComboBox cmb_day = new JComboBox();
		cmb_day.setBounds(292, 611, 151, 28);
		frame6.getContentPane().add(cmb_day);
		cmb_day.addItem("Select");
		cmb_day.addItem("Monday");
		cmb_day.addItem("Tuesday");
		cmb_day.addItem("Wednesday");
		cmb_day.addItem("Thursday");
		cmb_day.addItem("Friday");
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("Time");
		lblNewLabel_1_1_3_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_1_3_1.setBounds(524, 611, 88, 31);
		frame6.getContentPane().add(lblNewLabel_1_1_3_1);
		
		txt_time = new JTextField();
		txt_time.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_time.setColumns(10);
		txt_time.setBounds(691, 611, 151, 28);
		frame6.getContentPane().add(txt_time);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(98, 141, 685, 125);
		frame6.getContentPane().add(scrollPane);
		
		Table3 = new JTable();
		Table3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		Table3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Table3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Lecturer_1", "Lecturer_2", "Tag", "Subject_code", "Subject", "Group", "Duration", "No_Of_Students", "Day", "Time"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Object.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(Table3);
		
		JButton btnAddSession = new JButton("Add Session");
		btnAddSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame6.dispose();
				Add_Session add_session = new Add_Session();
				add_session.frame5.setVisible(true);
			}
		});
		btnAddSession.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddSession.setBounds(891, 25, 129, 48);
		frame6.getContentPane().add(btnAddSession);
		
	
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(98, 744, 129, 48);
		frame6.getContentPane().add(btnBack);
		
		
		
		JButton btnUpdate5 = new JButton("Update");
		btnUpdate5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				
							 
	             Class.forName("com.mysql.cj.jdbc.Driver");
	             	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","Abcd123#");
	             	   System.out.println("connected");
	             	   	PreparedStatement ps=conn.prepareStatement("UPDATE session_detail SET lecturer_1=?, lecturer_2=?, tag=?, sub_code=?, subject=?, grp_no=?, duration=?, no_student=?, day=?, time=? where sessionID=?");
	             	  	ps.setString(1,cmb_lecturer1.getSelectedItem().toString());
	             	  	ps.setString(2,cmb_lecturer2.getSelectedItem().toString());
	             	  	ps.setString(3,cmb_tag.getSelectedItem().toString());
	             	  	ps.setString(4,cmbSubCode.getSelectedItem().toString());
	             	  	ps.setString(5,cmbSubject.getSelectedItem().toString());
	             	   ps.setString(6,cmbGroup.getSelectedItem().toString());
	             	   ps.setString(7,txtDuration.getText());
	             	   ps.setString(8,txt_No_Student.getText());
	             	   ps.setString(9,cmb_day.getSelectedItem().toString());
	             	   ps.setString(10,txt_time.getText());
	             	   ps.setString(11,txtID.getText());
	             	   ps.executeUpdate();
	             	  table_load();
		          		JOptionPane.showMessageDialog(null, "Record updated successfully!!!!!");
		             	// table_load();
		             	
		             	
		             	   
		             	conn.close();
		    					
						 }catch(Exception e1) {
							 System.out.println(e1);
						 }
					}
				});
	             	
	    btnUpdate5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate5.setBounds(793, 191, 129, 38);
		frame6.getContentPane().add(btnUpdate5);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					 Class.forName("com.mysql.cj.jdbc.Driver");
	             	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","Abcd123#");
	             	  
	             	   	int row = Table3.getSelectedRow();
	             	   	String value=(Table3.getModel().getValueAt(row, 0).toString());
	             		PreparedStatement ps=conn.prepareStatement("delete from session_detail where sessionID="+value);
		             	ps.executeUpdate();
		         	  	table_load();
		         	  	JOptionPane.showMessageDialog(null, "Your data deleted successfully!!!!!");
	             	  				
	             	  	conn.close();
		}catch(Exception e1) {
			 System.out.println(e1);
		 }
		}
	});
		
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setBounds(793, 239, 129, 38);
		frame6.getContentPane().add(btnDelete);
		
		
		JButton btnHome_3 = new JButton("Home");
		btnHome_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHome_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHome_3.setBounds(915, 635, 129, 48);
		frame6.getContentPane().add(btnHome_3);
		
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
	              	   Class.forName("com.mysql.cj.jdbc.Driver");
	              	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","Abcd123#");
	              	   String sql = "select * from session_detail";
	              	 PreparedStatement ps = conn.prepareStatement(sql);
	              	   ResultSet rs = ps.executeQuery();
	              	  Table3.setModel(DbUtils.resultSetToTableModel(rs));
					   
				 }catch(Exception e1) {
					 System.out.println(e1);
				 }
				}
			});
			
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnView.setBounds(793, 103, 129, 38);
		frame6.getContentPane().add(btnView);
		
		
		
		
		JButton btnSelect_3 = new JButton("Select");
		btnSelect_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnSelect_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 DefaultTableModel dtm = (DefaultTableModel) Table3.getModel(); 
	    			int selectedRowIndex = Table3.getSelectedRow(); 
	    				String sessionID = (String) dtm.getValueAt(selectedRowIndex, 0); 
	    
					try {  
						Class.forName("com.mysql.cj.jdbc.Driver");
			     	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","Abcd123#");
						Statement st = conn.createStatement();
						 ResultSet r=st.executeQuery("select * from session_detail where sessionID='"+sessionID+"'");
						 while (r.next()) {  
							 txtID.setText(r.getString("sessionID"));
							 cmb_lecturer1.setSelectedItem(r.getString("lecturer_1"));  
							 cmb_lecturer2.setSelectedItem(r.getString("lecturer_2"));
							 cmb_tag.setSelectedItem(r.getString("tag"));
							 cmbSubCode.setSelectedItem(r.getString("sub_code"));
							 cmbSubject.setSelectedItem(r.getString("subject"));
							 cmbGroup.setSelectedItem(r.getString("grp_no"));
							 txtDuration.setText(r.getString("duration"));
							 txt_No_Student.setText(r.getString("no_student"));
							 cmb_day.setSelectedItem(r.getString("day"));
							 txt_time.setText(r.getString("time"));
						 }

						    conn.close();
						    } catch (Exception erorr) {  
						JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE);  
						System.exit(0);  
						} 
			}
		});
	
		btnSelect_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSelect_3.setBounds(795, 145, 129, 38);
		frame6.getContentPane().add(btnSelect_3);
		
		textSearch = new JTextField();
		textSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textSearch.setColumns(10);
		textSearch.setBounds(116, 100, 268, 28);
		frame6.getContentPane().add(textSearch);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
			     	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","Abcd123#");
						Statement st = conn.createStatement();
				        String query = "SELECT sessionID,lecturer_1,lecturer_2,subject FROM session_detail WHERE subject LIKE '%" + textSearch.getText() + "%'";
				        ResultSet rs = st.executeQuery(query);
				      Table3.setModel(DbUtils.resultSetToTableModel(rs)); 
				    conn.close();
				}
				     catch (Exception e) { 
				        JOptionPane.showMessageDialog(null,"Got an exception!");
				        System.err.println(e.getMessage()); 
				    }   
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSearch.setBounds(403, 97, 105, 31);
		frame6.getContentPane().add(btnSearch);
		
		
			
		
	}
}
