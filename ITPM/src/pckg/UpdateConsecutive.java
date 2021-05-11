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
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class UpdateConsecutive {

	private JFrame frame;
	private final JTextPane txtpnManageTag = new JTextPane();
	private JTable table;
	private JTextPane txtpnTagName;
	private JTextPane txtpnTagCode;
	private JTextPane txtpnRelatedTag;
	private JComboBox comboBox;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateConsecutive window = new UpdateConsecutive();
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
	public UpdateConsecutive() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(243,235,242));
		frame.setBounds(100, 100, 1033, 656);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		txtpnManageTag.setEditable(false);
		txtpnManageTag.setBounds(153, 21, 630, 51);
		txtpnManageTag.setText("UPDATE AND DELETE CONSECUTIVE SESSIONS");
		txtpnManageTag.setBackground(new Color(243,235,242));
		txtpnManageTag.setFont(new Font("Times New Roman", Font.BOLD, 25));
		frame.getContentPane().add(txtpnManageTag);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(101, 88, 755, 190);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1 ", "Ms.Disni", "MAD", "IT2030", "Y2S2..IT.8", "Lec"},
				{"2", "Ms.Disni", "MAD", "IT2030", "Y2S2.IT.8", "Tutorial"},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, " ", null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Lecturer ", "Subject", "Subject Code", "Group ID", "Tag"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(89);
		scrollPane.setViewportView(table);
		
		txtpnTagName = new JTextPane();
		txtpnTagName.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnTagName.setText("Lecture");
		txtpnTagName.setBackground(new Color(243,235,242));
		txtpnTagName.setBounds(327, 294, 146, 33);
		frame.getContentPane().add(txtpnTagName);
		
		txtpnTagCode = new JTextPane();
		txtpnTagCode.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnTagCode.setText("Tutorial");
		txtpnTagCode.setBackground(new Color(243,235,242));
		txtpnTagCode.setBounds(327, 368, 146, 33);
		frame.getContentPane().add(txtpnTagCode);
		
		txtpnRelatedTag = new JTextPane();
		txtpnRelatedTag.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnRelatedTag.setText("Lab");
		txtpnRelatedTag.setBackground(new Color(243,235,242));
		txtpnRelatedTag.setBounds(327, 448, 146, 33);
		frame.getContentPane().add(txtpnRelatedTag);
		
		comboBox = new JComboBox();
		comboBox.setBounds(327, 482, 228, 26);
		frame.getContentPane().add(comboBox);
		
		btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(105, 550, 115, 29);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setBounds(293, 550, 115, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.setBounds(484, 550, 115, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Home");
		btnNewButton_3.setBounds(668, 550, 115, 29);
		frame.getContentPane().add(btnNewButton_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(327, 333, 228, 26);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(327, 406, 228, 26);
		frame.getContentPane().add(comboBox_2);
		
		

	}
}
