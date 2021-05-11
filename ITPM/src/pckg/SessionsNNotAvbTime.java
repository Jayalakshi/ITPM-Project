package pckg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import java.awt.Choice;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
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
		frame.getContentPane().setBackground(new Color(243,235,242));
		frame.setBounds(100, 100, 1079, 780);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnSessionsAndNot = new JTextPane();
		txtpnSessionsAndNot.setFont(new Font("Times New Roman", Font.BOLD, 25));
		txtpnSessionsAndNot.setText("SESSIONS AND NOT AVAILABLE TIME ALLOCATIONS");
		txtpnSessionsAndNot.setBackground(new Color(243,235,242));
		txtpnSessionsAndNot.setBounds(141, 40, 707, 49);
		frame.getContentPane().add(txtpnSessionsAndNot);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(38, 135, 1002, 392);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Consecutive    ", null, panel, null);
		panel.setLayout(null);
		
		JTextPane txtpnLecture = new JTextPane();
		txtpnLecture.setBackground(new Color(230, 230, 250));
		txtpnLecture.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnLecture.setText("           Lecture");
		txtpnLecture.setBounds(191, 60, 197, 40);
		panel.add(txtpnLecture);
		
		JTextPane txtpnTutorial = new JTextPane();
		txtpnTutorial.setBackground(new Color(230, 230, 250));
		txtpnTutorial.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnTutorial.setText("           Tutorial");
		txtpnTutorial.setBounds(191, 134, 197, 40);
		panel.add(txtpnTutorial);
		
		JTextPane txtpnLab = new JTextPane();
		txtpnLab.setBackground(new Color(230, 230, 250));
		txtpnLab.setText("               Lab");
		txtpnLab.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnLab.setBounds(191, 201, 197, 40);
		panel.add(txtpnLab);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(445, 60, 296, 40);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(445, 134, 296, 40);
		panel.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(445, 201, 296, 40);
		panel.add(comboBox_2);
		
		JButton btnNewButton = new JButton("Add Session");
		btnNewButton.setBounds(273, 313, 127, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View");
		btnNewButton_1.setBounds(518, 313, 115, 29);
		panel.add(btnNewButton_1);
		
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
		comboBox_7.setBounds(37, 204, 243, 35);
		panel_1.add(comboBox_7);
		
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
		comboBox_8.setBounds(37, 311, 243, 33);
		panel_1.add(comboBox_8);
		
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
		comboBox_9.setBounds(402, 85, 243, 35);
		panel_1.add(comboBox_9);
		
		JComboBox comboBox_10 = new JComboBox();
		comboBox_10.setBounds(723, 85, 243, 35);
		panel_1.add(comboBox_10);
		
		JButton btnNewButton_5 = new JButton("Add Session");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_5.setBounds(526, 190, 119, 29);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("View");
		btnNewButton_6.setBounds(723, 190, 115, 29);
		panel_1.add(btnNewButton_6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Non Overlapping", null, panel_2, null);
		panel_2.setLayout(null);
		
		JTextPane txtpnSubject = new JTextPane();
		txtpnSubject.setBackground(new Color(230, 230, 250));
		txtpnSubject.setForeground(Color.BLACK);
		txtpnSubject.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnSubject.setText("            Subject 1");
		txtpnSubject.setBounds(122, 48, 221, 39);
		panel_2.add(txtpnSubject);
		
		JTextPane txtpnSubject_1 = new JTextPane();
		txtpnSubject_1.setBackground(new Color(230, 230, 250));
		txtpnSubject_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnSubject_1.setText("               Subject 2");
		txtpnSubject_1.setForeground(Color.BLACK);
		txtpnSubject_1.setBounds(423, 48, 221, 39);
		panel_2.add(txtpnSubject_1);
		
		JTextPane txtpnSubject_2 = new JTextPane();
		txtpnSubject_2.setBackground(new Color(230, 230, 250));
		txtpnSubject_2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnSubject_2.setText("             Subject 3");
		txtpnSubject_2.setBounds(122, 176, 221, 39);
		panel_2.add(txtpnSubject_2);
		
		JTextPane txtpnSubject_3 = new JTextPane();
		txtpnSubject_3.setBackground(new Color(230, 230, 250));
		txtpnSubject_3.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnSubject_3.setText("              Subject 4");
		txtpnSubject_3.setBounds(423, 176, 221, 39);
		panel_2.add(txtpnSubject_3);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(121, 103, 222, 39);
		 
		panel_2.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(121, 231, 222, 39);
		panel_2.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(423, 103, 221, 39);
		panel_2.add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(423, 231, 221, 39);
		panel_2.add(comboBox_6);
		
		JButton btnNewButton_2 = new JButton("Add Session");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(224, 301, 119, 29);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View");
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
