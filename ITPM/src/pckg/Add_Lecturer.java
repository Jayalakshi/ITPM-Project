package pckg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Add_Lecturer  extends JFrame {
	private static final long serialVersionUID = 1L;
	JFrame frame;
	private JTextField txtLecturerName;
	private JTextField txtEmpID;
	private JTextField txtRank;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Lecturer window = new Add_Lecturer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Add_Lecturer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		//frame.setBackground(new Color(219,239,248));
		frame.getContentPane().setBackground(new Color(243,235,242));
		frame.setBounds(100, 100, 782, 636);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD LECTURER");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(283, 21, 204, 48);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lecturer Name");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 109, 136, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Employee ID");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 184, 115, 27);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Faculty");
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(10, 272, 115, 27);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		txtLecturerName = new JTextField();
		txtLecturerName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtLecturerName.setColumns(10);
		txtLecturerName.setBounds(166, 112, 147, 28);
		frame.getContentPane().add(txtLecturerName);
		
		txtEmpID = new JTextField();
		txtEmpID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmpID.setColumns(10);
		txtEmpID.setBounds(166, 187, 147, 28);
		frame.getContentPane().add(txtEmpID);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Department");
		lblNewLabel_2_1_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(10, 344, 115, 27);
		frame.getContentPane().add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Center");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(362, 112, 96, 27);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JComboBox FacultyName = new JComboBox();
		FacultyName.setBounds(166, 271, 147, 28);
		frame.getContentPane().add(FacultyName);
		FacultyName.addItem("Select");
		FacultyName.addItem("Computing");
		FacultyName.addItem("Engineering");
		FacultyName.addItem("Business");
		FacultyName.addItem("Humanities & Sciences");
		
		JComboBox DepName = new JComboBox();
		DepName.setBounds(166, 348, 147, 28);
		frame.getContentPane().add(DepName);
		DepName.addItem("Select");
		DepName.addItem("Informatin Technology");
		DepName.addItem("Civil Engineering");
		DepName.addItem("Business Analytics");
		DepName.addItem("Nursing");


		JComboBox CenterName = new JComboBox();
		CenterName.setBounds(458, 118, 147, 28);
		frame.getContentPane().add(CenterName);
		CenterName.addItem("Select");
		CenterName.addItem("Malabe");
		CenterName.addItem("Kandy");
		CenterName.addItem("Jaffna");
		CenterName.addItem("Metro");
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Building");
		lblNewLabel_1_1_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(362, 187, 96, 27);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Level");
		lblNewLabel_1_1_1_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(362, 279, 96, 27);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Rank");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1.setBounds(362, 356, 96, 27);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		JComboBox BuildingName = new JComboBox();
		BuildingName.setBounds(458, 192, 147, 28);
		frame.getContentPane().add(BuildingName);
		BuildingName .addItem("Select");
		BuildingName .addItem("Main Building");
		BuildingName .addItem("New Building");
		
		JComboBox Level = new JComboBox();
		Level.setBounds(458, 276, 147, 28);
		frame.getContentPane().add(Level);
		Level .addItem("Select");
		Level .addItem("1");
		Level .addItem("2");
		Level .addItem("3");
		Level .addItem("4");
		Level .addItem("5");
		Level .addItem("6");
		
		
		txtRank = new JTextField();
		txtRank.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtRank.setColumns(10);
		txtRank.setBounds(458, 348, 147, 28);
		frame.getContentPane().add(txtRank);
		
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String emp_id = txtEmpID.getText(); 
				int len = emp_id.length();
				if(len!=6) {
					txtRank.setText("Error");
					JOptionPane.showMessageDialog(btnGenerate, "Enter a vaild Employee ID");
				}else {
				long E = Long.parseLong(txtEmpID.getText());
			    long L = Long.parseLong(Level.getSelectedItem().toString());
				
				
				String R = String.format(L + "."+ E);
				txtRank.setText(R);
				}
			}
		});
		btnGenerate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGenerate.setBounds(615, 342, 129, 36);
		frame.getContentPane().add(btnGenerate);
		
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Manage_Lecturer manage_lecturer = new Manage_Lecturer();
				manage_lecturer.frame2.setVisible(true);
				
			}
	});
		
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnView.setBounds(117, 479, 115, 48);
		frame.getContentPane().add(btnView);
		
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String emp_id = txtEmpID.getText();
				String lecturer_name = txtLecturerName.getText();
				String faculty = FacultyName.getSelectedItem().toString();
				String department = DepName.getSelectedItem().toString();
				String center = CenterName.getSelectedItem().toString();
				String building = BuildingName.getSelectedItem().toString();
				String lecturer_level = Level.getSelectedItem().toString();
				String lecturer_rank = txtRank.getText();
            	
				 String msg = "" + lecturer_name;
	                msg += " \n";
				try {
                	   Class.forName("com.mysql.cj.jdbc.Driver");
                	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","Abcd123#");
                	   String query = "INSERT INTO lecturer values('" + emp_id + "','" + lecturer_name + "','" + faculty + "','" +
                               department + "','" + center + "','" + building + "','" + lecturer_level + "','" + lecturer_rank + "')";
                	   
                	   Statement sta = conn.createStatement();
                       int x = sta.executeUpdate(query);
                       if (x == 0) {
                           JOptionPane.showMessageDialog(btnSave, "This is alredy exist");
                       } else {
                           JOptionPane.showMessageDialog(btnSave,
                               "Welcome, " + msg + "Your data is sucessfully added");
                       }
                       conn.close();
				 }catch(Exception e1) {
					 System.out.println(e1);
				 }
			}
		});
                	 
				 
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave.setBounds(327, 479, 115, 48);
		frame.getContentPane().add(btnSave);
		
		
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtLecturerName.setText("");
				txtEmpID.setText("");
				FacultyName.setSelectedIndex(0);
				DepName.setSelectedIndex(0);
				CenterName.setSelectedIndex(0);
				BuildingName.setSelectedIndex(0);
				Level.setSelectedIndex(0);
				txtRank.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClear.setBounds(551, 479, 115, 48);
		frame.getContentPane().add(btnClear);
		
		
	}
}
