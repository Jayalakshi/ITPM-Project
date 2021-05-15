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
import javax.swing.table.TableModel;


import com.mysql.cj.protocol.Resultset;


import net.proteanit.sql.DbUtils;

import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Manage_Lecturer extends JFrame {
	private static final long serialVersionUID = 1L;
	JFrame frame2;
	static JTable Table1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_1_1;
	private JTextField txtlectuerername;
	private JTextField txtempid;
	private JTextField txtrank;
	
	public static  void AddRowToJTable(Object[] dataRow) {
		DefaultTableModel model = (DefaultTableModel)Table1.getModel();
		model.addRow(dataRow);
	}
	
	public void table_load()
    {
		try {
     	   Class.forName("com.mysql.cj.jdbc.Driver");
     	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","Abcd123#");
     	   String sql = "select * from itpm.lecturer";
     	   PreparedStatement ps = conn.prepareStatement(sql);
     	  
     	  
     	  ResultSet rs = ps.executeQuery();
     	  Table1.setModel(DbUtils.resultSetToTableModel(rs));
     	  
     	  
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
					Manage_Lecturer window = new Manage_Lecturer();
					window.frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Manage_Lecturer() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame2 = new JFrame();
		frame2.getContentPane().setBackground(new Color(243,235,242));
		frame2.setBounds(100, 100, 925, 719);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MANAGE LECTURERS");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(308, 26, 290, 48);
		frame2.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 111, 725, 113);
		frame2.getContentPane().add(scrollPane);
		
		Table1 = new JTable();
		Table1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		Table1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Employee ID", "Lecturer Name", "Faculty", "Department", "Center", "Building", "Level", "Rank"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		Table1.getColumnModel().getColumn(0).setPreferredWidth(103);
		Table1.getColumnModel().getColumn(1).setPreferredWidth(78);
		Table1.getColumnModel().getColumn(2).setPreferredWidth(92);
		Table1.getColumnModel().getColumn(3).setPreferredWidth(87);
		Table1.getColumnModel().getColumn(4).setPreferredWidth(80);
		Table1.getColumnModel().getColumn(5).setPreferredWidth(92);
		scrollPane.setViewportView(Table1);
		
		lblNewLabel_1 = new JLabel("Lecturer Name");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(27, 234, 136, 31);
		frame2.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Employee ID");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(27, 297, 115, 27);
		frame2.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_2_1 = new JLabel("Faculty");
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(27, 357, 115, 27);
		frame2.getContentPane().add(lblNewLabel_2_1);
		
		lblNewLabel_2_1_1 = new JLabel("Department");
		lblNewLabel_2_1_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(27, 413, 115, 27);
		frame2.getContentPane().add(lblNewLabel_2_1_1);
		
		txtlectuerername = new JTextField();
		txtlectuerername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtlectuerername.setColumns(10);
		txtlectuerername.setBounds(223, 239, 147, 28);
		frame2.getContentPane().add(txtlectuerername);
		
		txtempid = new JTextField();
		txtempid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtempid.setColumns(10);
		txtempid.setBounds(223, 300, 147, 28);
		frame2.getContentPane().add(txtempid);
		
		JComboBox cmbfaculty = new JComboBox();
		cmbfaculty.setBounds(223, 361, 147, 28);
		frame2.getContentPane().add(cmbfaculty);
		cmbfaculty .addItem("Select");
		cmbfaculty .addItem("Computing");
		cmbfaculty .addItem("Engineering");
		cmbfaculty .addItem("Business");
		cmbfaculty .addItem("Humanities & Sciences");
		
		JComboBox cmbdepartment = new JComboBox();
		cmbdepartment.setBounds(223, 417, 147, 28);
		frame2.getContentPane().add(cmbdepartment);
		cmbdepartment .addItem("Select");
		cmbdepartment .addItem("Informatin Technology");
		cmbdepartment .addItem("Civil Engineering");
		cmbdepartment .addItem("Business Analytics");
		cmbdepartment .addItem("Nursing");

		
		JLabel lblNewLabel_1_1 = new JLabel("Center");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(454, 238, 96, 27);
		frame2.getContentPane().add(lblNewLabel_1_1);
		
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Building");
		lblNewLabel_1_1_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(454, 297, 96, 27);
		frame2.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Level");
		lblNewLabel_1_1_1_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(454, 357, 96, 27);
		frame2.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Rank");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1.setBounds(454, 413, 96, 27);
		frame2.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		JComboBox cnbcenter = new JComboBox();
		cnbcenter.setBounds(560, 240, 147, 28);
		frame2.getContentPane().add(cnbcenter);
		cnbcenter.addItem("Select");
		cnbcenter.addItem("Malabe");
		cnbcenter.addItem("Kandy");
		cnbcenter.addItem("Jaffna");
		cnbcenter.addItem("Metro");
		
		JComboBox cmbbuilding = new JComboBox();
		cmbbuilding.setBounds(564, 301, 147, 28);
		frame2.getContentPane().add(cmbbuilding);
		cmbbuilding .addItem("Select");
		cmbbuilding .addItem("Main Building");
		cmbbuilding .addItem("New Building");
		
		
		JComboBox cmblevel = new JComboBox();
		cmblevel.setBounds(564, 361, 147, 28);
		frame2.getContentPane().add(cmblevel);
		cmblevel .addItem("Select");
		cmblevel .addItem("1");
		cmblevel .addItem("2");
		cmblevel .addItem("3");
		cmblevel .addItem("4");
		cmblevel .addItem("5");
		cmblevel .addItem("6");
		
		
		txtrank = new JTextField();
		txtrank.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrank.setColumns(10);
		txtrank.setBounds(564, 416, 147, 28);
		frame2.getContentPane().add(txtrank);
		
		JButton btnNewButton = new JButton("Generate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long E = Long.parseLong(txtempid.getText());
			    long L = Long.parseLong(cmblevel.getSelectedItem().toString());
				
				
				String R = String.format(L + "."+ E);
				txtrank.setText(R);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(733, 414, 129, 31);
		frame2.getContentPane().add(btnNewButton);
		
		JButton btnHome_2 = new JButton("Home");
		btnHome_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHome_2.setBounds(49, 602, 129, 48);
		frame2.getContentPane().add(btnHome_2);
		
		JButton btnNext_1 = new JButton("Next");
		btnNext_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNext_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2.dispose();
				Add_Subject add_subject = new Add_Subject();
				add_subject.frame3.setVisible(true);
			}
		});
		btnNext_1.setBounds(745, 602, 129, 48);
		frame2.getContentPane().add(btnNext_1);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
             	   Class.forName("com.mysql.cj.jdbc.Driver");
             	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","Abcd123#");
             	 
             	  PreparedStatement ps=conn.prepareStatement("UPDATE lecturer SET lecturer_name=?, faculty=?, department=?, center=?, building=?, lecturer_level=?, lecturer_rank=? where emp_id=?");
             	  ps.setString(1,txtlectuerername.getText());
             	  ps.setString(2,cmbfaculty.getSelectedItem().toString());
             	  ps.setString(3,cmbdepartment.getSelectedItem().toString());
             	  ps.setString(4,cnbcenter.getSelectedItem().toString());
             	  ps.setString(5,cmbbuilding.getSelectedItem().toString());
             	  ps.setString(6,cmblevel.getSelectedItem().toString());
             	  ps.setString(7,txtrank.getText());
             	  ps.setString(8,txtempid.getText());
             	  ps.executeUpdate();
             	
             	 table_load();
             	 JOptionPane.showMessageDialog(null, "Record updated successfully!!!!!");
             	
             	   
             	conn.close();
    					
				 }catch(Exception e1) {
					 System.out.println(e1);
				 }
			}
		});
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		}
		});
		
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setBounds(745, 154, 129, 48);
		frame2.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
					
					 try {
						 Class.forName("com.mysql.cj.jdbc.Driver");
		             	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","Abcd123#");
		             	  
		             	   	int row = Table1.getSelectedRow();
		             	   	String value=(Table1.getModel().getValueAt(row, 0).toString());
		             		PreparedStatement ps=conn.prepareStatement("delete from lecturer where emp_id="+value);
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
		btnDelete.setBounds(745, 212, 129, 48);
		frame2.getContentPane().add(btnDelete);
		
		
		
		JButton btnRefresh = new JButton("Refresh");
		 btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
                	   Class.forName("com.mysql.cj.jdbc.Driver");
                	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","Abcd123#");
                	   String sql = "select * from itpm.lecturer";
                	PreparedStatement ps = conn.prepareStatement(sql);
                	  
                	  
                	  ResultSet rs = ps.executeQuery();
                	  Table1.setModel(DbUtils.resultSetToTableModel(rs));
                	 }catch(Exception e1) {
					 System.out.println(e1);
				 }
			}
		 });
				
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRefresh.setBounds(745, 39, 129, 48);
		frame2.getContentPane().add(btnRefresh);
		
		JButton btnEdit = new JButton("Select");
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = Table1.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel)Table1.getModel();
				//TableModel model = Table1.getModel();
				txtempid.setText(model.getValueAt(i, 0).toString());
				txtlectuerername.setText(model.getValueAt(i, 1).toString());
				String cmbfaculty1 = model.getValueAt(i, 2).toString();
				switch(cmbfaculty1) {
				case "Select":
					cmbfaculty.setSelectedIndex(0);
					break;
				case "Computing":
					cmbfaculty.setSelectedIndex(1);
					break;
				case "Engineering":
					cmbfaculty.setSelectedIndex(2);
					break;
				case "Business":
					cmbfaculty.setSelectedIndex(3);
					break;
				case "Humanities & Sciences":
					cmbfaculty.setSelectedIndex(4);
					break;
				}
				
				String cmbdepartment1 = model.getValueAt(i, 3).toString();
				switch(cmbdepartment1) {
				case "Select":
					cmbdepartment.setSelectedIndex(0);
					break;
				case "Information Technology":
					cmbdepartment.setSelectedIndex(1);
					break;
				case "Civil Engineering":
					cmbdepartment.setSelectedIndex(2);
					break;
				case "Business Analytics":
					cmbdepartment.setSelectedIndex(3);
					break;
				case "Nursing":
					cmbdepartment.setSelectedIndex(4);
					break;
				}
				
				String cnbcenter1 = model.getValueAt(i, 4).toString();
				switch(cnbcenter1) {
				case "Select":
					cnbcenter.setSelectedIndex(0);
					break;
				case "Malabe":
					cnbcenter.setSelectedIndex(1);
					break;
				case "Kandy":
					cnbcenter.setSelectedIndex(2);
					break;
				case "Jaffna":
					cnbcenter.setSelectedIndex(3);
					break;
				case "Metro":
					cnbcenter.setSelectedIndex(4);
					break;
				}
				
				String cmbbuilding1 = model.getValueAt(i, 5).toString();
				switch(cmbbuilding1) {
				case "Select":
					cmbbuilding.setSelectedIndex(0);
					break;
				case "Main Building":
					cmbbuilding.setSelectedIndex(1);
					break;
				case "New Building":
					cmbbuilding.setSelectedIndex(2);
					break;
				
				}
				
				String cmblevel1 = model.getValueAt(i, 6).toString();
				switch(cmblevel1) {
				case "Select":
					cmblevel.setSelectedIndex(0);
					break;
				case "1":
					cmblevel.setSelectedIndex(1);
					break;
				case "2":
					cmblevel.setSelectedIndex(2);
					break;
				case "3":
					cmblevel.setSelectedIndex(3);
					break;
				case "4":
					cmblevel.setSelectedIndex(4);
					break;
				case "5":
					cmblevel.setSelectedIndex(3);
					break;
				case "6":
					cmblevel.setSelectedIndex(4);
					break;
				}
				
				txtrank.setText(model.getValueAt(i, 7).toString());
				
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEdit.setBounds(745, 96, 129, 48);
		frame2.getContentPane().add(btnEdit);
		
		
	}
}