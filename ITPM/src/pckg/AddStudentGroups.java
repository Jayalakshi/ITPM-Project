package pckg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFormattedTextField;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JTree;
import javax.swing.JCheckBoxMenuItem;
import java.awt.List;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.JEditorPane;
import java.awt.Panel;

public class AddStudentGroups extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void addStu(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentGroups window = new AddStudentGroups();
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
	public AddStudentGroups() {
		initialize();
		
	}
	
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		 
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.getContentPane().setBackground(new Color(243,235,242));
		frame.setBounds(300, 300, 879, 651);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JTextPane txtpnAddStudentGroups = new JTextPane();

		txtpnAddStudentGroups.setEditable(false);
		txtpnAddStudentGroups.setFont(new Font("Times New Roman", Font.BOLD, 25));
		txtpnAddStudentGroups.setBackground(new Color(243,235,242));
		txtpnAddStudentGroups.setText("ADD STUDENT GROUPS");
		txtpnAddStudentGroups.setBounds(460, 16, 338, 50);
		frame.getContentPane().add(txtpnAddStudentGroups);
		
		JTextPane txtpnAcedamicYearAnd = new JTextPane();
		txtpnAcedamicYearAnd.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnAcedamicYearAnd.setText("Academic Year and Semester");
		txtpnAcedamicYearAnd.setBackground(new Color(243,235,242));
		txtpnAcedamicYearAnd.setBounds(214, 99, 260, 38);
		frame.getContentPane().add(txtpnAcedamicYearAnd);
		
		JTextPane txtpnSubGroupNumber = new JTextPane();
		txtpnSubGroupNumber.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnSubGroupNumber.setText("Sub Group Number");
		txtpnSubGroupNumber.setBackground(new Color(243,235,242));
		txtpnSubGroupNumber.setBounds(214, 385, 260, 38);
		frame.getContentPane().add(txtpnSubGroupNumber);
		
		JTextPane txtpnProgram = new JTextPane();
		txtpnProgram.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnProgram.setText("Program");
		txtpnProgram.setBackground(new Color(243,235,242));
		txtpnProgram.setBounds(214, 195, 260, 38);
		frame.getContentPane().add(txtpnProgram);
		
		JTextPane txtpnGroupNumber = new JTextPane();
		txtpnGroupNumber.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnGroupNumber.setText("Group Number");
	    txtpnGroupNumber.setBackground(new Color(243,235,242));
		txtpnGroupNumber.setBounds(214, 284, 260, 38);
		frame.getContentPane().add(txtpnGroupNumber);
		
		textField = new JTextField();
		textField.setBounds(214, 153, 260, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(214, 243, 260, 26);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("IT");
		comboBox.addItem("BM");
		comboBox.addItem("ENG");
		comboBox.addItem("QS");
		comboBox.setSelectedItem(null);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(214, 338, 260, 29);
		frame.getContentPane().add(comboBox_1);
		comboBox_1.addItem(1);
		comboBox_1.addItem(2);
		comboBox_1.addItem(3);
		comboBox_1.addItem(4);
		comboBox_1.addItem(5);
		comboBox_1.addItem(6);
		comboBox_1.addItem(7);
		comboBox_1.addItem(8);
		comboBox_1.addItem(9);
		comboBox_1.addItem(10);
		comboBox_1.setSelectedItem(null);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(214, 430, 260, 26);
		frame.getContentPane().add(comboBox_2);
		comboBox_2.addItem(1);
		comboBox_2.addItem(2);
		comboBox_2.setSelectedItem(null);
		
		
		JTextPane txtpnGroupId = new JTextPane();
		txtpnGroupId.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnGroupId.setText("Group ID");
		txtpnGroupId.setBackground(new Color(243,235,242));
		txtpnGroupId.setBounds(766, 99, 236, 38);
		frame.getContentPane().add(txtpnGroupId);
		
		JTextPane txtpnSubGroupId = new JTextPane();
		txtpnSubGroupId.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnSubGroupId.setText("Sub Group ID");
		txtpnSubGroupId.setBackground(new Color(243,235,242));
		txtpnSubGroupId.setBounds(766, 195, 236, 38);
		frame.getContentPane().add(txtpnSubGroupId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(766, 153, 225, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(766, 243, 225, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ayear = textField.getText();
				String pro =  (String) comboBox.getSelectedItem();
				Integer groupNum =  (Integer) comboBox_1.getSelectedItem();
				Integer subGroupNum =  (Integer) comboBox_2.getSelectedItem();
				String gNum = textField_1.getText();
				String sgNum = textField_2.getText();
				
				
				try {
					
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","root");
					
				
					String query = "Insert into studentgroups (AYearAndSem,program,groupNum,SubGroupNum,groupID,subGroupID) values ('" + ayear + "', '" + pro + "','" + groupNum + "','" + subGroupNum + "','" + gNum + "','" + sgNum +"')";
					
					Statement sta = connection.createStatement();
					int x = sta.executeUpdate(query);
			
					
					JOptionPane.showMessageDialog(null, "Sucessfully Inserted");
					
					
				
					connection.close();
					
				}catch (Exception exception) {
                    exception.printStackTrace();
                }
				
				
				}
		});
		btnNewButton_1.setBounds(391, 550, 151, 29);
		 
		 
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Generate IDs");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String ayear = textField.getText();
				String pro =  (String) comboBox.getSelectedItem();
				Integer groupNum =  (Integer) comboBox_1.getSelectedItem();
				Integer subGroupNum =  (Integer) comboBox_2.getSelectedItem();
				
				textField_1.setText(ayear+"."+pro+"."+groupNum);
				textField_2.setText(ayear+"."+pro+"."+groupNum+"."+subGroupNum);
				
			}
		});
		btnNewButton_2.setBounds(842, 311, 148, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textField.setText(" "); 
				comboBox.setSelectedItem(null);
				comboBox_1.setSelectedItem(null);
				comboBox_2.setSelectedItem(null);
				textField_1.setText("");
				textField_2.setText("");
			
			}
		});
		btnNewButton.setBounds(157, 550, 151, 29);
		//btnNewButton.setBorder(new RoundedBorder(20));
		frame.getContentPane().add(btnNewButton);
		
		
		JButton btnNewButton_3 = new JButton("Home");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Home home = new Home();
				
				home.main(null);
				frame.setVisible(false);
				
			}
		});
		btnNewButton_3.setBounds(614, 550, 151, 29);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("View");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
               ManageStudentGroups mt = new ManageStudentGroups();
				
				mt.ManStu();
				frame.setVisible(false);
				
			}
		});
		btnNewButton_4.setBounds(845, 550, 157, 29);
		frame.getContentPane().add(btnNewButton_4);
	}

	private void setBorder(Border createEmptyBorder) {
		// TODO Auto-generated method stub
		
	}
}
