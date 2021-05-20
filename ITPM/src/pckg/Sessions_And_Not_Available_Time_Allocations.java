import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Color;
import java.awt.Button;
import java.awt.Font;
import java.awt.TextField;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sessions_And_Not_Available_Time_Allocations {

	private JFrame frame;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sessions_And_Not_Available_Time_Allocations window = new Sessions_And_Not_Available_Time_Allocations();
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
	public Sessions_And_Not_Available_Time_Allocations() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setBackground(new Color(243,235,242));
		frame.setBounds(100, 100, 700, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sessions And Not Available Time Allocations");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(157, 11, 418, 22);
		frame.getContentPane().add(lblNewLabel);
		
		Button button = new Button("Back to Home");
		button.setBounds(10, 11, 80, 22);
		frame.getContentPane().add(button);
		
		JLabel lblNewLabel_1 = new JLabel("Lectures , Groups and Sub Group");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 64, 217, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Select Lecture");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(34, 127, 108, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Select Group");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(34, 167, 108, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sub Group");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(34, 209, 108, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Select Session ID");
		lblNewLabel_5.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(34, 251, 108, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(" Time");
		lblNewLabel_6.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(34, 293, 108, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(157, 124, 199, 20);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ResultSet rs2 = DB.DB.search("select subgroupno from student_groups where groupno='" + comboBox_1.getSelectedItem().toString() + "'");
	                if (rs2.first()) {
	                	textField_1.setText(rs2.getString(1));
	                }
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		comboBox_1.setBounds(157, 164, 199, 20);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(157, 248, 199, 20);
		frame.getContentPane().add(comboBox_3);
		
		TextField textField = new TextField();
		textField.setBounds(157, 285, 199, 22);
		frame.getContentPane().add(textField);
		
		JButton btnNewButton_2 = new JButton("Add");
		btnNewButton_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String lectureid="";
					String groupid="";
					ResultSet rs1 = DB.DB.search("select idlecturer from lecturer where name='" + comboBox.getSelectedItem().toString() + "'");
	                if (rs1.first()) {
	                    lectureid = rs1.getString(1);
	                }
	                ResultSet rs2 = DB.DB.search("select idstudent_groups from student_groups where groupno='" + comboBox_1.getSelectedItem().toString() + "'");
	                if (rs2.first()) {
	                	groupid = rs2.getString(1);
	                }
	                String sessionsid=comboBox_3.getSelectedItem().toString();
	                String subgroup_id=textField_1.getText();
	                String time=textField.getText();
	                DB.DB.iud("insert into notav_time(sub_group, time, lecturer_idlecturer, sessions_id, groups_id, status) values('"+subgroup_id+"','"+time+"','"+lectureid+"','"+sessionsid+"','"+groupid+"','Active')");
		            JOptionPane.showMessageDialog(null, "Succesfully inserted");
		            textField.setText("");
		            textField_1.setText("");
		            comboBox.setSelectedItem("<-Select->");
		            comboBox_3.setSelectedItem("<-Select->");
		            comboBox_1.setSelectedItem("<-Select->");
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_2.setBounds(34, 345, 165, 34);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("View");
		btnNewButton_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Manage_Not_Available_Time mt = new Manage_Not_Available_Time();
					mt.MNT();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_1.setBounds(248, 345, 165, 34);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
	            textField_1.setText("");
	            comboBox.setSelectedItem("<-Select->");
	            comboBox_3.setSelectedItem("<-Select->");
	            comboBox_1.setSelectedItem("<-Select->");
			}
		});
		btnNewButton.setBounds(482, 345, 165, 34);
		frame.getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(157, 206, 199, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		try {
			comboBox.addItem("<-Select->");
            ResultSet rs = DB.DB.search("select distinct name from lecturer");
            while (rs.next()) {
            	comboBox.addItem(rs.getString(1));
            }
            comboBox_1.addItem("<-Select->");
            ResultSet rs2 = DB.DB.search("select groupno from student_groups");
            while (rs2.next()) {
            	comboBox_1.addItem(rs2.getString(1));
            }
            comboBox_3.addItem("<-Select->");
            ResultSet rs3 = DB.DB.search("select idlecture_sessions from lecture_sessions");
            while (rs3.next()) {
            	comboBox_3.addItem(rs3.getString(1));
            }
            String subgroup=textField_1.getText();
            String time=textField.getText();
            
        } catch (Exception e) {
        }
	}
}
