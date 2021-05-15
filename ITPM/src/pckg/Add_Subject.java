package pckg;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Add_Subject extends JFrame {
	private static final long serialVersionUID = 1L;
	JFrame frame3;
	private JTextField txtSubjectCode;
	private JTextField txtSubjectName;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Subject window = new Add_Subject();
					window.frame3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Add_Subject() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame3 = new JFrame();
		frame3.setBounds(100, 100, 963, 670);
		frame3.getContentPane().setBackground(new Color(243,235,242));
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.getContentPane().setLayout(null);
		
		JLabel lblAddSubject = new JLabel("ADD SUBJECT");
		lblAddSubject.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblAddSubject.setBounds(401, 34, 208, 48);
		frame3.getContentPane().add(lblAddSubject);
		
		JLabel lblNewLabel_1 = new JLabel("Offered Year");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(33, 296, 136, 31);
		frame3.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Offered Semester");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(33, 382, 157, 31);
		frame3.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Subject Name");
		lblNewLabel_1_2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(33, 205, 136, 31);
		frame3.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Subject Code");
		lblNewLabel_1_3.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(33, 123, 136, 31);
		frame3.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Number Of Lecture Hours");
		lblNewLabel_1_4.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(551, 123, 218, 31);
		frame3.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Number Of Tutorial Hours");
		lblNewLabel_1_5.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_5.setBounds(551, 205, 218, 31);
		frame3.getContentPane().add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Number Of Lab Hours");
		lblNewLabel_1_6.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_6.setBounds(551, 291, 218, 31);
		frame3.getContentPane().add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Number Of Evaluation Hours");
		lblNewLabel_1_7.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1_7.setBounds(551, 382, 252, 31);
		frame3.getContentPane().add(lblNewLabel_1_7);
		
		JComboBox OfferedSemester = new JComboBox();
		OfferedSemester.setBounds(225, 388, 208, 28);
		frame3.getContentPane().add(OfferedSemester);
		OfferedSemester.addItem("Select");
		OfferedSemester.addItem("1");
		OfferedSemester.addItem("2");
		
		JComboBox EvaHour = new JComboBox();
		EvaHour.setBounds(813, 382, 101, 28);
		frame3.getContentPane().add(EvaHour);
		EvaHour.addItem("Select");
		EvaHour.addItem("1");
		EvaHour.addItem("2");
		EvaHour.addItem("3");
		
		txtSubjectCode = new JTextField();
		txtSubjectCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSubjectCode.setColumns(10);
		txtSubjectCode.setBounds(203, 128, 208, 28);
		frame3.getContentPane().add(txtSubjectCode);
		
		txtSubjectName = new JTextField();
		txtSubjectName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSubjectName.setColumns(10);
		txtSubjectName.setBounds(203, 210, 208, 28);
		frame3.getContentPane().add(txtSubjectName);
		JComboBox LabHour = new JComboBox();
		LabHour.setBounds(813, 291, 101, 28);
		frame3.getContentPane().add(LabHour);
		LabHour.addItem("Select");
		LabHour.addItem("1");
		LabHour.addItem("2");
		LabHour.addItem("3");
		
		JComboBox TuteHour = new JComboBox();
		TuteHour.setBounds(813, 211, 101, 28);
		frame3.getContentPane().add(TuteHour);
		TuteHour.addItem("Select");
		TuteHour.addItem("1");
		TuteHour.addItem("2");
		TuteHour.addItem("3");
		
		JComboBox LecHour = new JComboBox();
		LecHour.setBounds(813, 123, 101, 28);
		frame3.getContentPane().add(LecHour);
		LecHour.addItem("Select");
		LecHour.addItem("1");
		LecHour.addItem("2");
		LecHour.addItem("3");
		
		JComboBox OfferedYear = new JComboBox();
		OfferedYear.setBounds(225, 301, 196, 31);
		frame3.getContentPane().add(OfferedYear);
		OfferedYear.addItem("Select");
		OfferedYear.addItem("1");
		OfferedYear.addItem("2");
		OfferedYear.addItem("3");
		OfferedYear.addItem("4");
		
		JButton btnView1 = new JButton("View");
		btnView1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame3.dispose();
				Manage_Subject manage_subject = new Manage_Subject();
				manage_subject.frame4.setVisible(true);
			}
		});
		btnView1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnView1.setBounds(179, 476, 129, 48);
		frame3.getContentPane().add(btnView1);
		
		JButton btnSave1 = new JButton("Save");
		btnSave1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String subject_code = txtSubjectCode.getText();
				String subject_name = txtSubjectName.getText();
				String offered_year = OfferedYear.getSelectedItem().toString();
				String offered_semester = OfferedSemester.getSelectedItem().toString();
				String lecture_hour = LecHour.getSelectedItem().toString();
				String tute_hour = TuteHour.getSelectedItem().toString();
				String lab_hour = LabHour.getSelectedItem().toString();
				String evaluation_hour = EvaHour.getSelectedItem().toString();
				
					try {
	                	   Class.forName("com.mysql.cj.jdbc.Driver");
	                	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","Abcd123#");
	                	   String query = "INSERT INTO subject values('" + subject_code + "','" + subject_name + "','" + offered_year + "','" +
	                			   offered_semester + "','" + lecture_hour + "','" + tute_hour + "','" + lab_hour + "','" + evaluation_hour + "')";
	                	   
	                	   Statement sta = conn.createStatement();
	                       int x = sta.executeUpdate(query);
	                       if (x == 0) {
	                           JOptionPane.showMessageDialog(btnSave1, "This is alredy exist");
	                       } else {
	                           JOptionPane.showMessageDialog(btnSave1,
	                               "Welcome, Subject informations are sucessfully added");
	                       }
	                       conn.close();
					 }catch(Exception e1) {
						 System.out.println(e1);
					 }
				}
			});
		btnSave1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave1.setBounds(405, 476, 129, 48);
		frame3.getContentPane().add(btnSave1);
		
		JButton btnClear1 = new JButton("Clear");
		btnClear1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSubjectCode.setText("");
				txtSubjectName.setText("");
				OfferedYear.setSelectedIndex(0);
				OfferedSemester.setSelectedIndex(0);
				LecHour.setSelectedIndex(0);
				TuteHour.setSelectedIndex(0);
				LabHour.setSelectedIndex(0);
				EvaHour.setSelectedIndex(0);
			}
		});
		btnClear1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClear1.setBounds(640, 476, 129, 48);
		frame3.getContentPane().add(btnClear1);
		
		
	}
}
