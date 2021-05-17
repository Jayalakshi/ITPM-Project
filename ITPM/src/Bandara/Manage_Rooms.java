package Bandara;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.Choice;
import java.awt.Label;
import java.awt.Panel;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Manage_Rooms {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage_Rooms window = new Manage_Rooms();
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
	public Manage_Rooms() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(243,235,242));
		frame.setBounds(100, 100, 1001, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Allocate Rooms for Sessions");
		lblNewLabel.setBounds(294, 16, 331, 34);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		frame.getContentPane().add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 66, 979, 378);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("For Sessions", null, panel, null);
		panel.setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(10, 116, 867, -2);
		panel.add(panel_1);
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(0, 0, 771, 140);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Select Tag");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(391, 16, 96, 36);
		panel_2.add(lblNewLabel_4);
		
		Choice choice_2 = new Choice();
		choice_2.setBounds(153, 16, 204, 26);
		panel_2.add(choice_2);
		
		Choice choice = new Choice();
		choice.setBounds(535, 16, 198, 26);
		panel_2.add(choice);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(153, 62, 204, 26);
		panel_2.add(choice_1);
		
		Choice choice_3 = new Choice();
		choice_3.setBounds(535, 62, 204, 26);
		panel_2.add(choice_3);
		
		JLabel lblNewLabel_1 = new JLabel("Select Subject");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(15, 16, 147, 26);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Select Lecturer");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(15, 62, 147, 20);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Select Group");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(391, 55, 122, 35);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("Select Session");
		lblNewLabel_5.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(15, 104, 122, 20);
		panel_2.add(lblNewLabel_5);
		
		Choice choice_4 = new Choice();
		choice_4.setBounds(153, 104, 204, 26);
		panel_2.add(choice_4);
		
		Label label = new Label("Select Room");
		label.setBounds(391, 104, 122, 27);
		panel_2.add(label);
		label.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		
		Choice choice_5 = new Choice();
		choice_5.setBounds(535, 105, 206, 20);
		panel_2.add(choice_5);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String subjectid="";
					String tagid="";
					String lecturerid="";
					String groupid="";
					String roomid="";
					ResultSet rs1 = DB.DB.search("select idsubjects from subjects where name='" + choice_2.getSelectedItem().toString() + "'");
	                if (rs1.first()) {
	                    subjectid = rs1.getString(1);
	                }
	                ResultSet rs2 = DB.DB.search("select idtags from tags where name='" + choice.getSelectedItem().toString() + "'");
	                if (rs2.first()) {
	                	tagid = rs2.getString(1);
	                }
	                ResultSet rs3 = DB.DB.search("select idlecturer from lecturer where name='" + choice_1.getSelectedItem().toString() + "'");
	                if (rs3.first()) {
	                	lecturerid = rs3.getString(1);
	                }
	                ResultSet rs4 = DB.DB.search("select idstudent_groups from student_groups where groupno='" + choice_3.getSelectedItem().toString() + "'");
	                if (rs4.first()) {
	                	groupid = rs4.getString(1);
	                }
	                ResultSet rs5 = DB.DB.search("select idsession_rooms from rooms where name='" + choice_5.getSelectedItem().toString() + "'");
	                if (rs5.first()) {
	                	roomid = rs5.getString(1);
	                }
	                String sessionsid=choice_4.getSelectedItem().toString();
	                DB.DB.iud("insert into sessions(subject, group_id, tag, lecturer1, rooms_id, status) values('"+subjectid+"','"+groupid+"','"+tagid+"','"+lecturerid+"','"+roomid+"','deactive')");
		            JOptionPane.showMessageDialog(null, "Succesfully inserted");
//		            choice_2.setSelectedItem("<-Select->");
//		            choice.setSelectedItem("<-Select->");
//		            choice_1.setSelectedItem("<-Select->");
//		            choice_3.setSelectedItem("<-Select->");
//		            choice_5.setSelectedItem("<-Select->");
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(772, 209, 192, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.setBounds(772, 242, 192, 29);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back to Home");
		btnNewButton_2.setBounds(772, 310, 192, 29);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_7 = new JButton("View Added Sessions");
		btnNewButton_7.setBounds(772, 276, 192, 29);
		panel.add(btnNewButton_7);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("For Consecutive Sessions", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Select Sessions");
		lblNewLabel_7.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(44, 41, 145, 20);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Select Rooms");
		lblNewLabel_8.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(429, 41, 132, 20);
		panel_3.add(lblNewLabel_8);
		
		Choice choice_6 = new Choice();
		choice_6.setBounds(195, 41, 201, 26);
		panel_3.add(choice_6);
		
		Choice choice_7 = new Choice();
		choice_7.setBounds(567, 41, 201, 26);
		panel_3.add(choice_7);
		
		JButton btnNewButton_3 = new JButton("Submit");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String roomid="";
					ResultSet rs5 = DB.DB.search("select idsession_rooms from rooms where name='" + choice_7.getSelectedItem().toString() + "'");
	                if (rs5.first()) {
	                	roomid = rs5.getString(1);
	                }
	                String sessionsid=choice_6.getSelectedItem().toString();
	                DB.DB.iud("insert into consecutive_temp(lecture_sessions_id, rooms_id, status) values('"+sessionsid+"','"+roomid+"','deactive')");
		            JOptionPane.showMessageDialog(null, "Succesfully inserted");
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(707, 126, 183, 29);
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Clear");
		btnNewButton_4.setBounds(707, 171, 183, 29);
		panel_3.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Back to Home");
		btnNewButton_5.setBounds(707, 261, 183, 29);
		panel_3.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("View Added Sessions");
		btnNewButton_6.setBounds(707, 216, 183, 29);
		panel_3.add(btnNewButton_6);
		
		try {
			choice_1.addItem("<-Select->");
            ResultSet rs = DB.DB.search("select distinct name from lecturer");
            while (rs.next()) {
            	choice_1.addItem(rs.getString(1));
            }
            choice_3.addItem("<-Select->");
            ResultSet rs2 = DB.DB.search("select groupno from student_groups");
            while (rs2.next()) {
            	choice_3.addItem(rs2.getString(1));
            }
            choice_4.addItem("<-Select->");
            choice_6.addItem("<-Select->");
            ResultSet rs3 = DB.DB.search("select idlecture_sessions from lecture_sessions");
            while (rs3.next()) {
            	choice_4.addItem(rs3.getString(1));
            	choice_6.addItem(rs3.getString(1));
            }
            choice_2.addItem("<-Select->");
            ResultSet rs4 = DB.DB.search("select name from subjects");
            while (rs4.next()) {
            	choice_2.addItem(rs4.getString(1));
            }
            choice.addItem("<-Select->");
            ResultSet rs5 = DB.DB.search("select name from tags");
            while (rs5.next()) {
            	choice.addItem(rs5.getString(1));
            }
            choice_5.addItem("<-Select->");
            choice_7.addItem("<-Select->");
            ResultSet rs6 = DB.DB.search("select name from rooms");
            while (rs6.next()) {
            	choice_5.addItem(rs6.getString(1));
            	choice_7.addItem(rs6.getString(1));
            }
            
        } catch (Exception e) {
        }
	}
}
