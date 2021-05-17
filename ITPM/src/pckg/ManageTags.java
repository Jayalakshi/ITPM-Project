package pckg;

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

public class ManageTags {

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

	/**
	 * Launch the application.
	 */
	public static void ManTags() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageTags window = new ManageTags();
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
	public ManageTags() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.getContentPane().setBackground(new Color(243,235,242));
		frame.setBounds(100, 100, 1129, 626);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		txtpnManageTag.setEditable(false);
		txtpnManageTag.setBounds(511, 16, 270, 33);
		txtpnManageTag.setBackground(new Color(243,235,242));
		txtpnManageTag.setText("MANAGE TAGS");
		txtpnManageTag.setFont(new Font("Times New Roman", Font.BOLD, 25));
		frame.getContentPane().add(txtpnManageTag);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(139, 65, 1034, 182);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
 
		DefaultTableModel model = new DefaultTableModel();
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{new Integer(1), "lec", "100", "Lecture"},
//				{new Integer(2), "tute", "101", "Tutorial"},
//			},
//			new String[] {
//				"ID", "Tag Name", "Tag Code", "Related Tag"
//			}
//		) {
//			Class[] columnTypes = new Class[] {
//				Integer.class, String.class, String.class, String.class
//			};
//			public Class getColumnClass(int columnIndex) {
//				return columnTypes[columnIndex];
//			}
//		});
		
		
		try {
		
		Object[] column = {"ID","Tag Name", "Tag Code", "Related tag"};
		model.setColumnIdentifiers(column);
		 
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","root");
		PreparedStatement pstm = connection.prepareStatement("SELECT * FROM tags");
        ResultSet Rs = pstm.executeQuery();
        while(Rs.next()){
            model.addRow(new Object[]{Rs.getInt(1), Rs.getString(2),Rs.getString(3),Rs.getString(4)});
        }
		
		table.setModel(model);
		
		}catch (Exception e) {
            System.out.println(e.getMessage());
        }
		
		table.getColumnModel().getColumn(3).setPreferredWidth(89);
		scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				
				int i = table.getSelectedRow();
				textField.setText(model.getValueAt(i,1).toString());
				textField_1.setText(model.getValueAt(i,2).toString());
				comboBox.setSelectedItem(model.getValueAt(i,3).toString());
			}
			
		});
		
		table.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setBounds(486, 292, 307, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(486, 374, 307, 29);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		txtpnTagName = new JTextPane();
		txtpnTagName.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnTagName.setText("Tag Name");
		txtpnTagName.setBounds(581, 251, 146, 33);
		txtpnTagName.setBackground(new Color(243,235,242));
		frame.getContentPane().add(txtpnTagName);
		
		txtpnTagCode = new JTextPane();
		txtpnTagCode.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnTagCode.setText("Tag Code");
		txtpnTagCode.setBounds(581, 337, 146, 33);
		txtpnTagCode.setBackground(new Color(243,235,242));
		frame.getContentPane().add(txtpnTagCode);
		
		txtpnRelatedTag = new JTextPane();
		txtpnRelatedTag.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnRelatedTag.setText("Related Tag");
		txtpnRelatedTag.setBackground(new Color(243,235,242));
		txtpnRelatedTag.setBounds(581, 419, 146, 33);
		frame.getContentPane().add(txtpnRelatedTag);
		
		comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(486, 453, 307, 29);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("Lecture");
		comboBox.addItem("Tutorial");
		comboBox.addItem("Lab");
		comboBox.setSelectedItem(null);
		
		
		btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","root");
					int i = table.getSelectedRow();
					String query = " UPDATE tags SET tagname = '" + textField.getText() + "',tagcode = '" + textField_1.getText() + "',rTag = '" + (String) comboBox.getSelectedItem()+"' where id = '"+model.getValueAt(i,0)+"' ";
					
					Statement sta = connection.createStatement();
					int x = sta.executeUpdate(query);
					
					model.setValueAt(textField.getText() , i,1);
					model.setValueAt(textField_1.getText() , i,2);
					model.setValueAt((String) comboBox.getSelectedItem(),i,3);
					table.setModel(model);
					
					 JOptionPane.showMessageDialog(null, "Sucessfully Updated");
					
					connection.close();
					
					
				}catch (Exception exception) {
                    exception.printStackTrace();
                }
				
				
			}
		});
		btnNewButton.setBounds(116, 541, 187, 29);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			try {	
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","root");
				int i = table.getSelectedRow();
				String delRow = "delete from tags where id= '"+model.getValueAt(i,0)+"'";
		        
				Statement sta = connection.createStatement();
				int x = sta.executeUpdate(delRow);
				model.removeRow(i);
		        JOptionPane.showMessageDialog(null, "Sucessfully Deleted");
		        } catch (Exception e) {
		            JOptionPane.showMessageDialog(null,  e.getMessage());
		        }
				
			}
		});
		btnNewButton_1.setBounds(392, 541, 171, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				textField.setText(" ");
				textField_1.setText(" ");
				comboBox.setSelectedItem(null);
				
			}
		});
		btnNewButton_2.setBounds(670, 541, 177, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Home");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(954, 541, 171, 29);
		frame.getContentPane().add(btnNewButton_3);
		
		
		
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
		
		
	}
	
	 

}
