package pckg;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class UpdatePar {

	private JFrame frame;
	private final JTextPane txtpnManageTag = new JTextPane();
	private JTable table;
	private JTextPane txtpnTagName;
	private JTextPane txtpnTagCode;
	private JComboBox comboBox;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JComboBox comboBox_3;

	/**
	 * Launch the application.
	 */
	public static void updatePar(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePar window = new UpdatePar();
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
	public UpdatePar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.getContentPane().setBackground(new Color(243,235,242));
		frame.setBounds(100, 100, 1274, 671);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		txtpnManageTag.setEditable(false);
		txtpnManageTag.setForeground(Color.BLACK);
		txtpnManageTag.setBounds(396, 30, 671, 41);
		txtpnManageTag.setText("UPDATE AND DELETE NON PARALLEL SESSIONS");
		txtpnManageTag.setBackground(new Color(243,235,242));
		txtpnManageTag.setFont(new Font("Times New Roman", Font.BOLD, 25));
		frame.getContentPane().add(txtpnManageTag);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(169, 93, 996, 200);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "8.30", "Monday", "2", "NF", "SPM"},
				{"2", "12.30", "Thursday", "2", "DSA", ""},
				{null, null, null, null, null, null},
				{null, null, "", null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Starting Time", "Day", "Duration", "Subject 1", "Subject 2"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(131);
		table.getColumnModel().getColumn(2).setPreferredWidth(85);
		table.getColumnModel().getColumn(3).setPreferredWidth(85);
		table.getColumnModel().getColumn(4).setPreferredWidth(78);
		scrollPane.setViewportView(table);
		
		txtpnTagName = new JTextPane();
		txtpnTagName.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnTagName.setText("Starting Time");
		txtpnTagName.setBackground(new Color(243,235,242));
		txtpnTagName.setBounds(169, 309, 228, 41);
		frame.getContentPane().add(txtpnTagName);
		
		txtpnTagCode = new JTextPane();
		txtpnTagCode.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnTagCode.setText("Duration");
		txtpnTagCode.setBackground(new Color(243,235,242));
		txtpnTagCode.setBounds(169, 408, 146, 41);
		frame.getContentPane().add(txtpnTagCode);
		
		comboBox = new JComboBox();
		comboBox.setBounds(169, 351, 228, 29);
		frame.getContentPane().add(comboBox);
		
		btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(181, 573, 115, 29);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(482, 573, 115, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setBounds(789, 573, 115, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Home");
		btnNewButton_3.setBounds(1050, 570, 115, 29);
		frame.getContentPane().add(btnNewButton_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(169, 465, 228, 29);
		frame.getContentPane().add(comboBox_1);
		
		JTextPane txtpnSubGroupId = new JTextPane();
		txtpnSubGroupId.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnSubGroupId.setText("Day");
		txtpnSubGroupId.setBackground(new Color(243,235,242));
		txtpnSubGroupId.setBounds(569, 309, 200, 41);
		frame.getContentPane().add(txtpnSubGroupId);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(569, 351, 221, 29);
		frame.getContentPane().add(comboBox_2);
		
		JTextPane txtpnGroupId = new JTextPane();
		txtpnGroupId.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnGroupId.setText("Subject 1");
		txtpnGroupId.setBackground(new Color(243,235,242));
		txtpnGroupId.setBounds(569, 408, 247, 41);
		frame.getContentPane().add(txtpnGroupId);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setBounds(569, 465, 221, 29);
		frame.getContentPane().add(comboBox_3);
		
		JTextPane txtpnSubject = new JTextPane();
		txtpnSubject.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnSubject.setText("Subject 2");
		txtpnSubject.setBackground(new Color(243,235,242));
		txtpnSubject.setBounds(1007, 309, 184, 39);
		frame.getContentPane().add(txtpnSubject);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(1007, 348, 184, 34);
		frame.getContentPane().add(comboBox_4);
		

	}
}
