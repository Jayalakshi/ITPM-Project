package pckg;

import java.awt.EventQueue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.List;
import javax.swing.UIManager;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
 

public class ManageStudentGroups extends JFrame {

	private JFrame frame;
	private final JTextPane txtpnManageTag = new JTextPane();
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextPane txtpnTagName;
	private JTextPane txtpnTagCode;
	private JTextPane txtpnRelatedTag;
	private JComboBox comboBox;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void ManStu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStudentGroups window = new ManageStudentGroups();
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
	public ManageStudentGroups() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setExtendedState(MAXIMIZED_BOTH);
		
	
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.getContentPane().setBackground(new Color(243,235,242));
		frame.setBounds(100, 100, 1115, 615);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		txtpnManageTag.setEditable(false);
		txtpnManageTag.setForeground(Color.BLACK);
		txtpnManageTag.setBounds(460, 16, 408, 33);
		txtpnManageTag.setBackground(new Color(243,235,242));
		txtpnManageTag.setText("MANAGE STUDENT GROUPS");
		txtpnManageTag.setFont(new Font("Times New Roman", Font.BOLD, 25));
		frame.getContentPane().add(txtpnManageTag);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(130, 65, 1048, 171);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		
        DefaultTableModel model = new DefaultTableModel();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{" 1", "Y1S1", "IT", "9", "Y1S1.IT.9", "2", "Y1S1.IT.9.2"},
//				{" 2", "Y3S1 ", "IT", "14", "Y3S1.IT.14", "1", "Y1S1.IT.14.2"},
//				{null, null, null, null, null, null, null},
//				{null, null, "", null, null, null, null},
//				{null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null},
//			},
//			new String[] {
//				"ID", "Academic Year & sem", "Program", "Group No", "Group ID", "SubGroup No", "SubGroup ID"
//			}
//		));
		
		try {
		
		Object[] column = {"ID","Academic Year and sem", "Program", "Group No","Sub Group No","Group ID","SubGroup ID"};
		model.setColumnIdentifiers(column);
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","root");
		PreparedStatement pstm = connection.prepareStatement("SELECT * FROM studentgroups");
        ResultSet Rs = pstm.executeQuery();
        while(Rs.next()){
            model.addRow(new Object[]{Rs.getInt(1), Rs.getString(2),Rs.getString(3),Rs.getInt(4),Rs.getInt(5),Rs.getString(6),Rs.getString(7)});
        }
		
		table.setModel(model);
		
		}catch (Exception e) {
            System.out.println(e.getMessage());
        }
		
		table.getColumnModel().getColumn(1).setPreferredWidth(131);
		table.getColumnModel().getColumn(2).setPreferredWidth(85);
		table.getColumnModel().getColumn(3).setPreferredWidth(85);
		table.getColumnModel().getColumn(4).setPreferredWidth(78);
		table.getColumnModel().getColumn(5).setPreferredWidth(108);
		table.getColumnModel().getColumn(6).setPreferredWidth(115);
		scrollPane.setViewportView(table);
		
		table.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setBounds(270, 301, 276, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(804, 387, 261, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		txtpnTagName = new JTextPane();
		txtpnTagName.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnTagName.setText("Academic Year & sem");
		txtpnTagName.setBackground(new Color(243,235,242));
		txtpnTagName.setBounds(270, 252, 228, 33);
		frame.getContentPane().add(txtpnTagName);
		
		txtpnTagCode = new JTextPane();
		txtpnTagCode.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnTagCode.setText("Program");
		txtpnTagCode.setBackground(new Color(243,235,242));
		txtpnTagCode.setBounds(270, 343, 146, 33);
		frame.getContentPane().add(txtpnTagCode);
		
		txtpnRelatedTag = new JTextPane();
		txtpnRelatedTag.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnRelatedTag.setText("Group Number");
		txtpnRelatedTag.setBackground(new Color(243,235,242));
		txtpnRelatedTag.setBounds(270, 419, 146, 33);
		frame.getContentPane().add(txtpnRelatedTag);
		
		comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(270, 387, 276, 26);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("IT");
		comboBox.addItem("BM");
		comboBox.addItem("ENG");
		comboBox.addItem("QS");
		comboBox.setSelectedItem(null);
		
		
		
		btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {	
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","root");
					int i = table.getSelectedRow();
					String delRow = "delete from studentgroups where id= '"+model.getValueAt(i,0)+"'";
			        
					Statement sta = connection.createStatement();
					int x = sta.executeUpdate(delRow);
					model.removeRow(i);
					 JOptionPane.showMessageDialog(null, "Sucessfully Deleted");
			        } catch (Exception e) {
			            JOptionPane.showMessageDialog(null,  e.getMessage());
			        }
					
				
			}
		});
		btnNewButton_1.setBounds(456, 570, 153, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		
		btnNewButton_3 = new JButton("Home");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_3.setBounds(947, 570, 146, 29);
		frame.getContentPane().add(btnNewButton_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(270, 468, 276, 26);
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
		
		
		JTextPane txtpnSubGroupId = new JTextPane();
		txtpnSubGroupId.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnSubGroupId.setText("Sub Group Number");
		txtpnSubGroupId.setBackground(new Color(243,235,242));
		txtpnSubGroupId.setBounds(804, 252, 164, 33);
		frame.getContentPane().add(txtpnSubGroupId);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(804, 301, 261, 26);
		frame.getContentPane().add(comboBox_2);
		comboBox_2.addItem(1);
		comboBox_2.addItem(2);
		comboBox_2.setSelectedItem(null);
		
		
		JTextPane txtpnGroupId = new JTextPane();
		txtpnGroupId.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnGroupId.setText("Group ID");
		txtpnGroupId.setBackground(new Color(243,235,242));
		txtpnGroupId.setBounds(804, 343, 247, 33);
		frame.getContentPane().add(txtpnGroupId);
		
		JTextPane txtpnSubGroupId_1 = new JTextPane();
		txtpnSubGroupId_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnSubGroupId_1.setText("Sub Group ID");
		txtpnSubGroupId_1.setBackground(new Color(243,235,242));
		txtpnSubGroupId_1.setBounds(804, 429, 132, 33);
		frame.getContentPane().add(txtpnSubGroupId_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(804, 468, 261, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
        table.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				
				int i = table.getSelectedRow();
				textField.setText(model.getValueAt(i,1).toString());
				comboBox.setSelectedItem(model.getValueAt(i,2).toString());
				comboBox_1.setSelectedItem(model.getValueAt(i,3));
				comboBox_2.setSelectedItem(model.getValueAt(i,4));
				textField_1.setText(model.getValueAt(i,5).toString());
				textField_2.setText(model.getValueAt(i,6).toString());
				
			}
			
		});
        
        btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
                 try {
					
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","root");
					int i = table.getSelectedRow();
					String query = " UPDATE studentgroups SET AYearAndSem = '" + textField.getText() + "',program = '" +  (String) comboBox.getSelectedItem() + "',groupNum = '" + (Integer) comboBox_1.getSelectedItem()+"',SubGroupNum ='" + (Integer) comboBox_2.getSelectedItem()+"',groupID = '" + textField_1.getText() + "',subGroupID = '" + textField_2.getText() + "' where id = '"+model.getValueAt(i,0)+"' ";
					
					Statement sta = connection.createStatement();
					int x = sta.executeUpdate(query);
					
					model.setValueAt(textField.getText() , i,1);
					model.setValueAt((String) comboBox.getSelectedItem(),i,2);
					model.setValueAt((Integer) comboBox_1.getSelectedItem(),i,3);
					model.setValueAt((Integer) comboBox_2.getSelectedItem(),i,4);
					model.setValueAt(textField_1.getText() , i,5);
					model.setValueAt(textField_2.getText() , i,6);
					table.setModel(model);
					
					 JOptionPane.showMessageDialog(null, "Sucessfully  Updated");
					
					connection.close();
					
					
				}catch (Exception exception) {
                    exception.printStackTrace();
                }
				
				
			}
		});
		btnNewButton.setBounds(200, 570, 153, 29);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textField.setText(" "); 
				comboBox.setSelectedItem(null);
				comboBox_1.setSelectedItem(null);
				comboBox_2.setSelectedItem(null);
				textField_1.setText("");
				textField_2.setText("");
			
				
			}
		});
		btnNewButton_2.setBounds(715, 570, 153, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		
	}
}
