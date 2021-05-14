package pckg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.Choice;
import java.awt.Label;
import java.awt.Panel;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Color;

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
		lblNewLabel_2.setBounds(391, 68, 122, 35);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("Select Session");
		lblNewLabel_5.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(15, 104, 122, 20);
		panel_2.add(lblNewLabel_5);
		
		Choice choice_4 = new Choice();
		choice_4.setBounds(153, 104, 204, 26);
		panel_2.add(choice_4);
		
		Label label = new Label("Select Room");
		label.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		label.setBounds(10, 291, 122, 27);
		panel.add(label);
		
		Choice choice_5 = new Choice();
		choice_5.setBounds(154, 292, 206, 26);
		panel.add(choice_5);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(144, 182, 414, 100);
		panel.add(textPane);
		
		JLabel lblNewLabel_6 = new JLabel("Selected Sessions");
		lblNewLabel_6.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(10, 146, 147, 37);
		panel.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(772, 209, 192, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.setBounds(772, 242, 192, 29);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back to Home");
		btnNewButton_2.setBounds(772, 310, 192, 29);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_7 = new JButton("Viwe Added Sessions");
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
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(new Color(248, 248, 255));
		textPane_1.setBounds(216, 126, 362, 108);
		panel_3.add(textPane_1);
		
		JButton btnNewButton_3 = new JButton("Submit");
		btnNewButton_3.setBounds(707, 126, 183, 29);
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Clear");
		btnNewButton_4.setBounds(707, 171, 183, 29);
		panel_3.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Back to Home");
		btnNewButton_5.setBounds(707, 261, 183, 29);
		panel_3.add(btnNewButton_5);
		
		JLabel lblNewLabel_9 = new JLabel("Selected Sessions");
		lblNewLabel_9.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(44, 167, 145, 26);
		panel_3.add(lblNewLabel_9);
		
		JButton btnNewButton_6 = new JButton("View Added Sessions");
		btnNewButton_6.setBounds(707, 216, 183, 29);
		panel_3.add(btnNewButton_6);
	}
}
