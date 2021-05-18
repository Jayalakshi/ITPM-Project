package pckg;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
	public static void updateCon(){
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
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.getContentPane().setBackground(new Color(243,235,242));
		frame.setBounds(100, 100, 1033, 656);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		txtpnManageTag.setEditable(false);
		txtpnManageTag.setBounds(350, 21, 630, 51);
		txtpnManageTag.setText("UPDATE AND DELETE CONSECUTIVE SESSIONS");
		txtpnManageTag.setBackground(new Color(243,235,242));
		txtpnManageTag.setFont(new Font("Times New Roman", Font.BOLD, 25));
		frame.getContentPane().add(txtpnManageTag);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(280, 88, 755, 190);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		DefaultTableModel model = new DefaultTableModel();
		 
		try {
			
			Object[] column = {"ID","Lecture","Tutorial","Lab"};
			model.setColumnIdentifiers(column);
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","root");
			PreparedStatement pstm = connection.prepareStatement("SELECT * FROM consecutivesessions");
	        ResultSet Rs = pstm.executeQuery();
	        while(Rs.next()){
	            model.addRow(new Object[]{Rs.getInt(1), Rs.getString(2),Rs.getString(3),Rs.getString(4)});
	        }
			
			table.setModel(model);
			
			}catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
		
		table.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 16));
				
		scrollPane.setViewportView(table);
		
		txtpnTagName = new JTextPane();
		txtpnTagName.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnTagName.setText("Lecture");
		txtpnTagName.setBackground(new Color(243,235,242));
		txtpnTagName.setBounds(559, 294, 146, 33);
		frame.getContentPane().add(txtpnTagName);
		
		txtpnTagCode = new JTextPane();
		txtpnTagCode.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnTagCode.setText("Tutorial");
		txtpnTagCode.setBackground(new Color(243,235,242));
		txtpnTagCode.setBounds(559, 366, 146, 33);
		frame.getContentPane().add(txtpnTagCode);
		
		txtpnRelatedTag = new JTextPane();
		txtpnRelatedTag.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnRelatedTag.setText("Lab");
		txtpnRelatedTag.setBackground(new Color(243,235,242));
		txtpnRelatedTag.setBounds(559, 443, 146, 33);
		frame.getContentPane().add(txtpnRelatedTag);
		
		comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(559, 486, 228, 26);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("IP lab");
		comboBox.addItem("OOP lab");
		comboBox.addItem("MC lab");
		comboBox.addItem("PAF lab");
		comboBox.addItem("MAD lab");
		comboBox.setSelectedItem(null);
		
		btnNewButton_3 = new JButton("Home");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                Home home = new Home();
				
				home.main(null);
				frame.setVisible(false);
				
			}
		});
		btnNewButton_3.setBounds(934, 555, 115, 29);
		frame.getContentPane().add(btnNewButton_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(559, 330, 228, 26);
		comboBox_1.setBackground(Color.WHITE);
		frame.getContentPane().add(comboBox_1);
		comboBox_1.addItem("IP lecture");
		comboBox_1.addItem("OOP lecture");
		comboBox_1.addItem("MC lecture");
		comboBox_1.addItem("PAF lecture");
		comboBox_1.addItem("MAD lecture");
		comboBox_1.setSelectedItem(null);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(559, 401, 228, 26);
		frame.getContentPane().add(comboBox_2);
		comboBox_2.addItem("IP tute");
		comboBox_2.addItem("OOP tute");
		comboBox_2.addItem("MC tute");
		comboBox_2.addItem("PAF tute");
		comboBox_2.addItem("MAD tute");
		comboBox_2.setSelectedItem(null);
		
		
		
		 table.addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent arg0) {
					
					int i = table.getSelectedRow();
					comboBox_1.setSelectedItem(model.getValueAt(i,1).toString());
					comboBox_2.setSelectedItem(model.getValueAt(i,2).toString());
					comboBox.setSelectedItem(model.getValueAt(i,3).toString());
					
				}
				
			});
		
		 btnNewButton = new JButton("Update");
		 btnNewButton.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0) {
					
		   try {
							
				       Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","root");
					   int i = table.getSelectedRow();
					   String query = " UPDATE consecutivesessions SET Lecture = '" + (String) comboBox_1.getSelectedItem() + "',Tutorial = '" +  (String) comboBox_2.getSelectedItem() + "',Lab = '" + (String) comboBox.getSelectedItem() + "' where id = '"+model.getValueAt(i,0)+"' ";
							
					   Statement sta = connection.createStatement();
					   int x = sta.executeUpdate(query);
							
					   model.setValueAt((String) comboBox_1.getSelectedItem() , i,1);
					   model.setValueAt((String) comboBox_2.getSelectedItem(), i,2);
					   model.setValueAt((String) comboBox.getSelectedItem(), i,3);
					   table.setModel(model);
							
					    JOptionPane.showMessageDialog(null, "Sucessfully  Updated");
							
					    connection.close();
							
							
						}catch (Exception exception) {
		                    exception.printStackTrace();
		                }
						
					
				}
			});
		 
			btnNewButton.setBounds(162, 555, 115, 29);
			frame.getContentPane().add(btnNewButton);
		
			btnNewButton_1 = new JButton("Delete");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {	
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","root");
						int i = table.getSelectedRow();
						String delRow = "delete from consecutivesessions where id= '"+model.getValueAt(i,0)+"'";
				        
						Statement sta = connection.createStatement();
						int x = sta.executeUpdate(delRow);
						model.removeRow(i);
						 JOptionPane.showMessageDialog(null, "Sucessfully Deleted");
				        } catch (Exception e1) {
				            JOptionPane.showMessageDialog(null,  e1.getMessage());
				        }
					
					
				}
			});
			btnNewButton_1.setBounds(431, 555, 115, 29);
			frame.getContentPane().add(btnNewButton_1);
			
			btnNewButton_2 = new JButton("Clear");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					comboBox.setSelectedItem(null);
					comboBox_1.setSelectedItem(null);
					comboBox_2.setSelectedItem(null);
					
				}
			});
			btnNewButton_2.setBounds(679, 555, 115, 29);
			frame.getContentPane().add(btnNewButton_2);	
		

	}
}
