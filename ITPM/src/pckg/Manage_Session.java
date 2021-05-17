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

	public static void AddRowToJTable(Object[] dataRow) {
		DefaultTableModel model = (DefaultTableModel)Table3.getModel();
		model.addRow(dataRow);
	}
	
	public void table_load()
    {
		try {
     	   Class.forName("com.mysql.cj.jdbc.Driver");
     	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","Abcd123#");
     	   String sql = "select * from itpm.session";
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
		frame6.setBounds(100, 100, 1109, 756);
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
		cmb_lecturer1.addItem("Mr.Jagath Fernando");
		cmb_lecturer1.addItem("Mrs.Shalini Silva");
		cmb_lecturer1.addItem("Mr.Akila Perera");
		cmb_lecturer1.addItem("Ms.Manjula Peris");
		
		JComboBox cmb_lecturer2 = new JComboBox();
		cmb_lecturer2.setBounds(672, 370, 157, 28);
		frame6.getContentPane().add(cmb_lecturer2);
		cmb_lecturer2.addItem("Select");
		cmb_lecturer2.addItem("Mr.Jagath Fernando");
		cmb_lecturer2.addItem("Mrs.Shalini Silva");
		cmb_lecturer2.addItem("Mr.Akila Perera");
		cmb_lecturer2.addItem("Ms.Manjula Peris");
		
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
		cmbSubCode.addItem("IT1010");
		cmbSubCode.addItem("IT1020");
		cmbSubCode.addItem("IT1040");
		cmbSubCode.addItem("IT1050");
		
		JComboBox cmbSubject = new JComboBox();
		cmbSubject.setBounds(292, 551, 151, 28);
		frame6.getContentPane().add(cmbSubject);
		cmbSubject.addItem("Select");
		cmbSubject.addItem("OOP");
		cmbSubject.addItem("MC");
		cmbSubject.addItem("OOC");
		cmbSubject.addItem("DS");
		
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
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(98, 141, 685, 125);
		frame6.getContentPane().add(scrollPane);
		
		Table3 = new JTable();
		Table3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Table3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Lecturer_1", "Lecturer_2", "Tag", "Subject_code", "Subject", "Group", "Duration", "No_Of_Students"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Object.class
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
		btnBack.setBounds(95, 635, 129, 48);
		frame6.getContentPane().add(btnBack);
		
		
		
		JButton btnUpdate5 = new JButton("Update");
		btnUpdate5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
	             	   Class.forName("com.mysql.cj.jdbc.Driver");
	             	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","Abcd123#");
	             	   System.out.println("connected");
	             		//int row = Table3.getSelectedRow();
	             	  //	String value1=(Table3.getModel().getValueAt(row, 0).toString());
	             	 
	             	  PreparedStatement ps=conn.prepareStatement("UPDATE session SET lecturer_1=?, lecturer_2=?, tag=?, subject_code=?, subject=?, group=?, duration=?, no_student=? WHERE id=?");
	             	  	ps.setString(1,cmb_lecturer1.getSelectedItem().toString());
	             	   ps.setString(2,cmb_lecturer2.getSelectedItem().toString());
	             	   ps.setString(3,cmb_tag.getSelectedItem().toString());
	             	   ps.setString(4,cmbSubCode.getSelectedItem().toString());
	             	   ps.setString(5,cmbSubject.getSelectedItem().toString());
	             	   ps.setString(6,cmbGroup.getSelectedItem().toString());
	             	   ps.setString(7,txtDuration.getText());
	             	   ps.setString(8,txt_No_Student.getText());
	             	   ps.setString(9,txtID.getText());
	             	   ps.executeUpdate();
	             	
	             	 table_load();
	             	 JOptionPane.showMessageDialog(null, "Record updated successfully!!!!!");
	             	
	             	   
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
	             		PreparedStatement ps=conn.prepareStatement("delete from session where id="+value);
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
	              	   String sql = "select * from session";
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
				int k = Table3.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel)Table3.getModel();
				//TableModel model = Table1.getModel();
				txtID.setText(model.getValueAt(k, 0).toString());
				String cmb_lecturer11 = model.getValueAt(k, 1).toString();
				switch(cmb_lecturer11) {
				case "Select":
					cmb_lecturer1.setSelectedIndex(0);
					break;
				case "Mr.Jagath Fernando":
					cmb_lecturer1.setSelectedIndex(1);
					break;
				case "Mrs.Shalini Silva":
					cmb_lecturer1.setSelectedIndex(2);
					break;
				case "Mr.Akila Perera":
					cmb_lecturer1.setSelectedIndex(3);
					break;
				case "Ms.Manjula Peris":
					cmb_lecturer1.setSelectedIndex(4);
					break;
				}
				
				String cmb_lecturer12 = model.getValueAt(k, 2).toString();
				switch(cmb_lecturer12) {
				case "Select":
					cmb_lecturer1.setSelectedIndex(0);
					break;
				case "Mr.Jagath Fernando":
					cmb_lecturer2.setSelectedIndex(1);
					break;
				case "Mrs.Shalini Silva":
					cmb_lecturer2.setSelectedIndex(2);
					break;
				case "Mr.Akila Perera":
					cmb_lecturer2.setSelectedIndex(3);
					break;
				case "Ms.Manjula Peris":
					cmb_lecturer2.setSelectedIndex(4);
					break;
				}
				
				String cmb_tag1 = model.getValueAt(k, 3).toString();
				switch(cmb_tag1) {
				case "Select":
					cmb_tag.setSelectedIndex(0);
					break;
				case "Lecture":
					cmb_tag.setSelectedIndex(1);
					break;
				case "Tutorial":
					cmb_tag.setSelectedIndex(2);
					break;
				case "Lab":
					cmb_tag.setSelectedIndex(3);
					break;
				}
				
				
				String cmbSubCode1 = model.getValueAt(k, 4).toString();
				switch(cmbSubCode1) {
				case "Select":
					cmbSubCode.setSelectedIndex(0);
					break;
				case "IT1010":
					cmbSubCode.setSelectedIndex(1);
					break;
				case "IT1020":
					cmbSubCode.setSelectedIndex(2);
					break;
				case "IT1040":
					cmbSubCode.setSelectedIndex(3);
					break;
				case "IT1050":
					cmbSubCode.setSelectedIndex(4);
					break;
				}
				
				String cmbSubject1 = model.getValueAt(k, 5).toString();
				switch(cmbSubject1) {
				case "Select":
					cmbSubject.setSelectedIndex(0);
					break;
				case "OOP":
					cmbSubject.setSelectedIndex(1);
					break;
				case "MC":
					cmbSubject.setSelectedIndex(2);
					break;
				case "OOC":
					cmbSubject.setSelectedIndex(3);
					break;
				case "DS":
					cmbSubject.setSelectedIndex(4);
					break;
				}
				
				String cmbGroup1 = model.getValueAt(k, 6).toString();
				switch(cmbGroup1) {
				case "Select":
					cmbGroup.setSelectedIndex(0);
					break;
				case "Y1S1 IT.1":
					cmbGroup.setSelectedIndex(1);
					break;
				case "Y1S1 IT.2":
					cmbGroup.setSelectedIndex(2);
					break;
				case "Y2S1 IT.1":
					cmbGroup.setSelectedIndex(3);
					break;
				case "Y2S2 IT.2":
					cmbGroup.setSelectedIndex(4);
					break;
				}
				
				txtDuration.setText(model.getValueAt(k, 7).toString());
				txt_No_Student.setText(model.getValueAt(k, 8).toString());
			}
		});
		btnSelect_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSelect_3.setBounds(795, 145, 129, 38);
		frame6.getContentPane().add(btnSelect_3);
		
		
	}
}
