package pckg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Choice;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class SessionsNNotAvbTime {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SessionsNNotAvbTime window = new SessionsNNotAvbTime();
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
	public SessionsNNotAvbTime() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.getContentPane().setBackground(new Color(243,235,242));
		frame.setBounds(100, 100, 1079, 780);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnSessionsAndNot = new JTextPane();
		txtpnSessionsAndNot.setEditable(false);
		txtpnSessionsAndNot.setFont(new Font("Times New Roman", Font.BOLD, 25));
		txtpnSessionsAndNot.setText("SESSIONS AND NOT AVAILABLE TIME ALLOCATIONS");
		txtpnSessionsAndNot.setBackground(new Color(243,235,242));
		txtpnSessionsAndNot.setBounds(350, 35, 707, 49);
		frame.getContentPane().add(txtpnSessionsAndNot);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(38, 135, 1002, 392);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Parallel       ", null, panel_1, null);
		panel_1.setLayout(null);
		
		JTextPane txtpnStartTime = new JTextPane();
		txtpnStartTime.setBackground(new Color(230, 230, 250));
		txtpnStartTime.setText("Start Time");
		txtpnStartTime.setBounds(37, 29, 243, 40);
		panel_1.add(txtpnStartTime);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setBackground(Color.WHITE);
		comboBox_7.setBounds(37, 204, 243, 31);
		panel_1.add(comboBox_7);
		comboBox_7.addItem("Monday");
		comboBox_7.addItem("Tuesday");
		comboBox_7.addItem("Wednesday");
		comboBox_7.addItem("Thursday");
		comboBox_7.addItem("Friday");
		comboBox_7.setSelectedItem(null);
		
		JTextPane txtpnDay = new JTextPane();
		txtpnDay.setBackground(new Color(230, 230, 250));
		txtpnDay.setText("Day");
		txtpnDay.setBounds(37, 148, 243, 40);
		panel_1.add(txtpnDay);
		
		textField = new JTextField();
		textField.setBounds(37, 85, 243, 35);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JTextPane txtpnDuration = new JTextPane();
		txtpnDuration.setBackground(new Color(230, 230, 250));
		txtpnDuration.setText("Duration");
		txtpnDuration.setBounds(37, 255, 243, 40);
		panel_1.add(txtpnDuration);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setBackground(Color.WHITE);
		comboBox_8.setBounds(37, 311, 243, 31);
		panel_1.add(comboBox_8);
		comboBox_8.addItem("1 hour");
		comboBox_8.addItem("2 hours");
		comboBox_8.addItem("3 hours");
		comboBox_8.addItem("4 hours");
		comboBox_8.setSelectedItem(null);
		
		JTextPane txtpnSubject_4 = new JTextPane();
		txtpnSubject_4.setBackground(new Color(230, 230, 250));
		txtpnSubject_4.setText("Subject 1");
		txtpnSubject_4.setBounds(402, 29, 243, 40);
		panel_1.add(txtpnSubject_4);
		
		JTextPane txtpnSubject_5 = new JTextPane();
		txtpnSubject_5.setBackground(new Color(230, 230, 250));
		txtpnSubject_5.setText("Subject 2");
		txtpnSubject_5.setBounds(723, 29, 243, 40);
		panel_1.add(txtpnSubject_5);
		
		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setBackground(Color.WHITE);
		comboBox_9.setBounds(402, 85, 243, 31);
		panel_1.add(comboBox_9);
		comboBox_9.addItem("SPM");
		comboBox_9.addItem("SE");
		comboBox_9.addItem("DSA");
		comboBox_9.addItem("MAD");
		comboBox_9.addItem("IWT");
		comboBox_9.setSelectedItem(null);
		
		JComboBox comboBox_10 = new JComboBox();
		comboBox_10.setBackground(Color.WHITE);
		comboBox_10.setBounds(723, 85, 243, 29);
		panel_1.add(comboBox_10);
		comboBox_10.addItem("NF");
		comboBox_10.addItem("AN");
		comboBox_10.addItem("FA");
		comboBox_10.addItem("CSA");
		comboBox_10.addItem("WAN");
		comboBox_10.setSelectedItem(null);
		
		JButton btnNewButton_5 = new JButton("Add Session");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String Stime = textField.getText();
				String day = (String) comboBox_7.getSelectedItem();
				String duration = (String) comboBox_8.getSelectedItem();
				String subject1 = (String) comboBox_9.getSelectedItem();
				String subject2 = (String) comboBox_10.getSelectedItem();
				
                try {
					
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","root");
					
				
					String query = "Insert into parallelsessions (startTime,day,duration,subject1,subject2) values ('" + Stime + "', '" + day + "','" + duration + "','" + subject1 + "','" + subject2 + "')";
					
					Statement sta = connection.createStatement();
					int x = sta.executeUpdate(query);
			
					
					JOptionPane.showMessageDialog(null, "Sucessfully Inserted");
					
					
				
					connection.close();
					
				}catch (Exception exception) {
                    exception.printStackTrace();
                }
				
				
			}
		});
		btnNewButton_5.setBounds(526, 190, 119, 29);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("View");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				    UpdatePar par = new UpdatePar();
					
					par.updatePar();
					frame.setVisible(false);
				
			}
		});
		btnNewButton_6.setBounds(723, 190, 115, 29);
		panel_1.add(btnNewButton_6);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Consecutive    ", null, panel, null);
		panel.setLayout(null);
		
		JTextPane txtpnLecture = new JTextPane();
		txtpnLecture.setBackground(new Color(230, 230, 250));
		txtpnLecture.setText("                     Lecture");
		txtpnLecture.setBounds(191, 60, 197, 40);
		panel.add(txtpnLecture);
		
		JTextPane txtpnTutorial = new JTextPane();
		txtpnTutorial.setBackground(new Color(230, 230, 250));
		txtpnTutorial.setText("                    Tutorial");
		txtpnTutorial.setBounds(191, 134, 197, 40);
		panel.add(txtpnTutorial);
		
		JTextPane txtpnLab = new JTextPane();
		txtpnLab.setBackground(new Color(230, 230, 250));
		txtpnLab.setText("                          Lab");
		txtpnLab.setBounds(191, 201, 197, 40);
		panel.add(txtpnLab);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(445, 60, 296, 29);
		panel.add(comboBox);
		comboBox.addItem("IP lecture");
		comboBox.addItem("OOP lecture");
		comboBox.addItem("MC lecrure");
		comboBox.addItem("PAF lecture");
		comboBox.addItem("MAD lecture");
		comboBox.setSelectedItem(null);
		
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(445, 134, 296, 29);
		panel.add(comboBox_1);
		comboBox_1.addItem("IP tute");
		comboBox_1.addItem("OOP tute");
		comboBox_1.addItem("MC tute");
		comboBox_1.addItem("PAF tute");
		comboBox_1.addItem("MAD tute");
		comboBox_1.setSelectedItem(null);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(445, 201, 296, 29);
		panel.add(comboBox_2);
		comboBox_2.addItem("IP lab");
		comboBox_2.addItem("OOP lab");
		comboBox_2.addItem("MC lab");
		comboBox_2.addItem("PAF lab");
		comboBox_2.addItem("MAD lab");
		comboBox_2.setSelectedItem(null);
		
		JButton btnNewButton = new JButton("Add Session");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String lec =  (String) comboBox.getSelectedItem();
				String tute =  (String) comboBox_1.getSelectedItem();
				String lab =  (String) comboBox_2.getSelectedItem();
				
                try {
					
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","root");
					
				
					String query = "Insert into consecutivesessions (Lecture,Tutorial,Lab) values ('" + lec + "', '" + tute + "','" + lab + "')";
					
					Statement sta = connection.createStatement();
					int x = sta.executeUpdate(query);
			
					
					JOptionPane.showMessageDialog(null, "Sucessfully Inserted");
					
					
				
					connection.close();
					
				}catch (Exception exception) {
                    exception.printStackTrace();
                }
					
				
			}
		});
		btnNewButton.setBounds(273, 313, 127, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				    UpdateConsecutive con = new UpdateConsecutive();
					
					con.updateCon();
					frame.setVisible(false);
				
			}
		});
		btnNewButton_1.setBounds(518, 313, 115, 29);
		panel.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Non Overlapping", null, panel_2, null);
		panel_2.setLayout(null);
		
		JTextPane txtpnSubject = new JTextPane();
		txtpnSubject.setBackground(new Color(230, 230, 250));
		txtpnSubject.setForeground(Color.BLACK);
		txtpnSubject.setText("Subject 1");
		txtpnSubject.setBounds(122, 48, 221, 39);
		panel_2.add(txtpnSubject);
		
		JTextPane txtpnSubject_1 = new JTextPane();
		txtpnSubject_1.setBackground(new Color(230, 230, 250));
		txtpnSubject_1.setText("Subject 2");
		txtpnSubject_1.setForeground(Color.BLACK);
		txtpnSubject_1.setBounds(423, 48, 221, 39);
		panel_2.add(txtpnSubject_1);
		
		JTextPane txtpnSubject_2 = new JTextPane();
		txtpnSubject_2.setBackground(new Color(230, 230, 250));
		txtpnSubject_2.setText("Subject 3");
		txtpnSubject_2.setBounds(122, 176, 221, 39);
		panel_2.add(txtpnSubject_2);
		
		JTextPane txtpnSubject_3 = new JTextPane();
		txtpnSubject_3.setBackground(new Color(230, 230, 250));
		txtpnSubject_3.setText("Subject 4");
		txtpnSubject_3.setBounds(423, 176, 221, 39);
		panel_2.add(txtpnSubject_3);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBackground(Color.WHITE);
		comboBox_3.setBounds(121, 103, 222, 29);
		panel_2.add(comboBox_3);
		comboBox_3.addItem("DS");
		comboBox_3.addItem("NF");
		comboBox_3.addItem("FA");
		comboBox_3.addItem("TPSM");
		comboBox_3.addItem("AF");
		comboBox_3.setSelectedItem(null);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBackground(Color.WHITE);
		comboBox_4.setBounds(121, 231, 222, 29);
		panel_2.add(comboBox_4);
		comboBox_4.addItem("NDM");
		comboBox_4.addItem("EAP");
		comboBox_4.addItem("PAF");
		comboBox_4.addItem("SOS");
		comboBox_4.addItem("MAD");
		comboBox_4.setSelectedItem(null);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBackground(Color.WHITE);
		comboBox_5.setBounds(423, 103, 221, 29);
		panel_2.add(comboBox_5);
		comboBox_5.addItem("ITPM");
		comboBox_5.addItem("DSDA");
		comboBox_5.addItem("ANT");
		comboBox_5.addItem("SE");
		comboBox_5.addItem("WAN");
		comboBox_5.setSelectedItem(null);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBackground(Color.WHITE);
		comboBox_6.setBounds(423, 231, 221, 29);
		panel_2.add(comboBox_6);
		comboBox_6.addItem("ESD");
		comboBox_6.addItem("Profs");
		comboBox_6.addItem("EAP");
		comboBox_6.addItem("CS");
		comboBox_6.addItem("OOP");
		comboBox_6.setSelectedItem(null);
		
		JButton btnNewButton_2 = new JButton("Add Session");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String sub1 =  (String) comboBox_3.getSelectedItem();
				String sub2 =  (String) comboBox_4.getSelectedItem();
				String sub3 =  (String) comboBox_5.getSelectedItem();
                String sub4 =  (String) comboBox_6.getSelectedItem();
                

                try {
					
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","root");
					
				
					String query = "Insert into nonoverlappingsessions (Subject_1,Subject_2,Subject_3,Subject_4) values ('" + sub1 + "', '" + sub2 + "','" + sub3 + "','" + sub4 + "')";
					
					Statement sta = connection.createStatement();
					int x = sta.executeUpdate(query);
					
			
					
					JOptionPane.showMessageDialog(null, "Sucessfully Inserted");
					
					
				
					connection.close();
					
				}catch (Exception exception) {
                    exception.printStackTrace();
                }
 				
				
				
			}
		});
		btnNewButton_2.setBounds(224, 301, 119, 29);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 UpdateNonOver nonOver = new UpdateNonOver();
				 nonOver.nonOver();
				 frame.setVisible(false);
				
			}
		});
		btnNewButton_3.setBounds(423, 301, 115, 29);
		panel_2.add(btnNewButton_3);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Not Available  ", null, panel_3, null);
		
		JButton btnNewButton_4 = new JButton("Home");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(396, 570, 197, 29);
		frame.getContentPane().add(btnNewButton_4);
	}
}
