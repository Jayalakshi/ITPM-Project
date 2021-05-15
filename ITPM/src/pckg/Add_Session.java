package pckg;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Add_Session {
	private static final long serialVersionUID = 1L;
	 JFrame frame5;
	private JTextField txt_ID;
	private JTextField txt_no_student;
	private JTextField txt_duration;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Session window = new Add_Session();
					window.frame5.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Add_Session() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame5 = new JFrame();
		frame5.getContentPane().setBackground(new Color(243,235,242));
		frame5.setBounds(100, 100, 913, 703);
		frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame5.getContentPane().setLayout(null);
		
		JLabel lblAddLecturersAnd = new JLabel("ADD LECTURERS AND TAG FOR SESSION");
		lblAddLecturersAnd.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblAddLecturersAnd.setBounds(39, 40, 546, 48);
		frame5.getContentPane().add(lblAddLecturersAnd);
		
		JLabel lblNewLabel_1 = new JLabel("1st Lecturer Name");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(39, 194, 181, 31);
		frame5.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("2nd Lecturer Name");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(478, 194, 171, 31);
		frame5.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("ID");
		lblNewLabel_1_2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(98, 124, 59, 31);
		frame5.getContentPane().add(lblNewLabel_1_2);
		
		JComboBox cmb__lecturer_1 = new JComboBox();
		cmb__lecturer_1.setBounds(205, 204, 208, 28);
		frame5.getContentPane().add(cmb__lecturer_1);
		cmb__lecturer_1.addItem("Select");
		cmb__lecturer_1.addItem("Mr.Jagath Fernando");
		cmb__lecturer_1.addItem("Mrs.Shalini Silva");
		cmb__lecturer_1.addItem("Mr.Akila Perera");
		cmb__lecturer_1.addItem("Ms.Manjula Peris");
		
		JComboBox cmb__lecturer_2 = new JComboBox();
		cmb__lecturer_2.setBounds(659, 197, 208, 28);
		frame5.getContentPane().add(cmb__lecturer_2);
		cmb__lecturer_2.addItem("Select");
		cmb__lecturer_2.addItem("Mr.Jagath Fernando");
		cmb__lecturer_2.addItem("Mrs.Shalini Silva");
		cmb__lecturer_2.addItem("Mr.Akila Perera");
		cmb__lecturer_2.addItem("Ms.Manjula Peris");
		
		
		txt_ID = new JTextField();
		txt_ID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_ID.setColumns(10);
		txt_ID.setBounds(205, 127, 199, 28);
		frame5.getContentPane().add(txt_ID);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Select Tag");
		lblNewLabel_1_1_2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_1_2.setBounds(492, 122, 129, 31);
		frame5.getContentPane().add(lblNewLabel_1_1_2);
		
		JComboBox cmbTag = new JComboBox();
		cmbTag.setBounds(659, 128, 191, 28);
		frame5.getContentPane().add(cmbTag);
		cmbTag.addItem("Select");
		cmbTag.addItem("Lecture");
		cmbTag.addItem("Tutorial");
		cmbTag.addItem("Lab");
		
		
		JLabel lblAddGroupAnd = new JLabel("ADD GROUP AND SUBJECT FOR SESSION");
		lblAddGroupAnd.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblAddGroupAnd.setBounds(39, 266, 546, 48);
		frame5.getContentPane().add(lblAddGroupAnd);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Select Group");
		lblNewLabel_1_1_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(39, 338, 163, 31);
		frame5.getContentPane().add(lblNewLabel_1_1_1);
		
		JComboBox cmb_grp = new JComboBox();
		cmb_grp.setBounds(224, 341, 208, 28);
		frame5.getContentPane().add(cmb_grp);
		cmb_grp.addItem("Select");
		cmb_grp.addItem("Y1S1 IT.1");
		cmb_grp.addItem("Y1S1 IT.2");
		cmb_grp.addItem("Y2S1 IT.1");
		cmb_grp.addItem("Y2S2 IT.2");
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Select Subject");
		lblNewLabel_1_1_1_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(39, 404, 157, 31);
		frame5.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JComboBox cmb_subject = new JComboBox();
		cmb_subject.setBounds(224, 404, 208, 28);
		frame5.getContentPane().add(cmb_subject);
		cmb_subject.addItem("Select");
		cmb_subject.addItem("OOP");
		cmb_subject.addItem("MC");
		cmb_subject.addItem("OOC");
		cmb_subject.addItem("DS");
		
		JLabel lblNewLabel_1_1_4 = new JLabel("No Of Students");
		lblNewLabel_1_1_4.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_1_4.setBounds(39, 472, 157, 31);
		frame5.getContentPane().add(lblNewLabel_1_1_4);
		
		txt_no_student = new JTextField();
		txt_no_student.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_no_student.setColumns(10);
		txt_no_student.setBounds(224, 472, 216, 28);
		frame5.getContentPane().add(txt_no_student);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Duration (Hrs)");
		lblNewLabel_1_1_3.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_1_3.setBounds(535, 338, 157, 31);
		frame5.getContentPane().add(lblNewLabel_1_1_3);
		
		txt_duration = new JTextField();
		txt_duration.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_duration.setColumns(10);
		txt_duration.setBounds(703, 343, 136, 28);
		frame5.getContentPane().add(txt_duration);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Select Subject Code ");
		lblNewLabel_1_1_2_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_1_2_1.setBounds(520, 410, 185, 31);
		frame5.getContentPane().add(lblNewLabel_1_1_2_1);
		
		JComboBox cmb_subject_code = new JComboBox();
		cmb_subject_code.setBounds(715, 410, 124, 28);
		frame5.getContentPane().add(cmb_subject_code);
		cmb_subject_code.addItem("Select");
		cmb_subject_code.addItem("IT1010");
		cmb_subject_code.addItem("IT1020");
		cmb_subject_code.addItem("IT1040");
		cmb_subject_code.addItem("IT1050");
		
		JButton btnView2 = new JButton("View");
		btnView2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame5.dispose();
				Manage_Session manage_session = new Manage_Session();
				manage_session.frame6.setVisible(true);
			}
		});
		btnView2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnView2.setBounds(135, 534, 129, 48);
		frame5.getContentPane().add(btnView2);
		
		JButton btnSave2 = new JButton("Save");
		btnSave2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txt_ID.getText();
				String lecturer_1 = cmb__lecturer_1.getSelectedItem().toString();
				String lecturer_2 = cmb__lecturer_2.getSelectedItem().toString();
				String tag = cmbTag.getSelectedItem().toString();
				String subject_code = cmb_subject_code.getSelectedItem().toString();
				String subject = cmb_subject.getSelectedItem().toString();
				String group = cmb_grp.getSelectedItem().toString();
				String duration = txt_duration.getText();
				String no_student = txt_no_student.getText();
            	
				try {
                	   Class.forName("com.mysql.cj.jdbc.Driver");
                	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","Abcd123#");
                	   String query = "INSERT INTO session values('" + id + "','" + lecturer_1 + "','" + lecturer_2 + "','" + tag + "','" +
                			   subject_code + "','" + subject + "','" + group + "','" + duration + "','" + no_student + "')";
                	   
                	   Statement sta = conn.createStatement();
                       int x = sta.executeUpdate(query);
                       if (x == 0) {
                           JOptionPane.showMessageDialog(btnSave2, "This is alredy exist");
                       } else {
                           JOptionPane.showMessageDialog(btnSave2,
                               "Data is sucessfully added");
                       }
                       conn.close();
				 }catch(Exception e1) {
					 System.out.println(e1);
				 }
			}
		});
			
	
		btnSave2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave2.setBounds(411, 534, 129, 48);
		frame5.getContentPane().add(btnSave2);
		
		JButton btnClear2 = new JButton("Clear");
		btnClear2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_ID.setText("");
				cmb__lecturer_1.setSelectedIndex(0);
				cmb__lecturer_2.setSelectedIndex(0);
				cmbTag.setSelectedIndex(0);
				cmb_subject_code.setSelectedIndex(0);
				cmb_subject.setSelectedIndex(0);
				cmb_grp.setSelectedIndex(0);
				txt_duration.setText("");
				txt_no_student.setText("");
			}
		});
		btnClear2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClear2.setBounds(644, 534, 129, 48);
		frame5.getContentPane().add(btnClear2);
		
		
		
	}
}
