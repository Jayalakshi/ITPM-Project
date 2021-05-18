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
		txtpnManageTag.setText("UPDATE AND DELETE PARALLEL SESSIONS");
		txtpnManageTag.setBackground(new Color(243,235,242));
		txtpnManageTag.setFont(new Font("Times New Roman", Font.BOLD, 25));
		frame.getContentPane().add(txtpnManageTag);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(169, 93, 996, 200);
		frame.getContentPane().add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel();
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));

		try {
		
		Object[] column = {"ID","Start Time","Day","Duration","Subject 1"," Subject 2"};
		model.setColumnIdentifiers(column);
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","root");
		PreparedStatement pstm = connection.prepareStatement("SELECT * FROM parallelsessions");
        ResultSet Rs = pstm.executeQuery();
        while(Rs.next()){
            model.addRow(new Object[]{Rs.getInt(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getString(6)});
        }
		
		table.setModel(model);
		
		}catch (Exception e) {
            System.out.println(e.getMessage());
        }
		
		table.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 16));
		 
		scrollPane.setViewportView(table);
		
		table.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 16));
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
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(169, 351, 228, 29);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("8.30");
		comboBox.addItem("10.30");
		comboBox.addItem("12.30");
		comboBox.addItem("1.30");
		comboBox.addItem("3.30");
		comboBox.setSelectedItem(null);
		
		btnNewButton_3 = new JButton("Home");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                Home home = new Home();
				
				home.main(null);
				frame.setVisible(false);
				
			}
		});
		btnNewButton_3.setBounds(1050, 570, 115, 29);
		frame.getContentPane().add(btnNewButton_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(169, 465, 228, 29);
		frame.getContentPane().add(comboBox_1);
		comboBox_1.addItem("1 hour");
		comboBox_1.addItem("2 hours");
		comboBox_1.addItem("3 hours");
		comboBox_1.addItem("4 hours");
		comboBox_1.setSelectedItem(null);
		
		JTextPane txtpnSubGroupId = new JTextPane();
		txtpnSubGroupId.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnSubGroupId.setText("Day");
		txtpnSubGroupId.setBackground(new Color(243,235,242));
		txtpnSubGroupId.setBounds(569, 309, 200, 41);
		frame.getContentPane().add(txtpnSubGroupId);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(569, 351, 221, 29);
		frame.getContentPane().add(comboBox_2);
		comboBox_2.addItem("Monday");
		comboBox_2.addItem("Tuesday");
		comboBox_2.addItem("Wednesday");
		comboBox_2.addItem("Thursday");
		comboBox_2.addItem("Friday");
		comboBox_2.setSelectedItem(null);
		
		
		JTextPane txtpnGroupId = new JTextPane();
		txtpnGroupId.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnGroupId.setText("Subject 1");
		txtpnGroupId.setBackground(new Color(243,235,242));
		txtpnGroupId.setBounds(569, 408, 247, 41);
		frame.getContentPane().add(txtpnGroupId);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setBackground(Color.WHITE);
		comboBox_3.setBounds(569, 465, 221, 29);
		frame.getContentPane().add(comboBox_3);
		comboBox_3.addItem("SPM");
		comboBox_3.addItem("SE");
		comboBox_3.addItem("DSA");
		comboBox_3.addItem("MAD");
		comboBox_3.addItem("IWT");
		comboBox_3.setSelectedItem(null);
		
		JTextPane txtpnSubject = new JTextPane();
		txtpnSubject.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnSubject.setText("Subject 2");
		txtpnSubject.setBackground(new Color(243,235,242));
		txtpnSubject.setBounds(1007, 309, 184, 39);
		frame.getContentPane().add(txtpnSubject);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBackground(Color.WHITE);
		comboBox_4.setBounds(1007, 348, 184, 34);
		frame.getContentPane().add(comboBox_4);
		comboBox_4.addItem("NF");
		comboBox_4.addItem("AN");
		comboBox_4.addItem("FA");
		comboBox_4.addItem("CSA");
		comboBox_4.addItem("WAN");
		comboBox_4.setSelectedItem(null);
		
        table.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				
				int i = table.getSelectedRow();
				comboBox.setSelectedItem(model.getValueAt(i,1).toString());
				comboBox_2.setSelectedItem(model.getValueAt(i,2).toString());
				comboBox_1.setSelectedItem(model.getValueAt(i,3).toString());
				comboBox_3.setSelectedItem(model.getValueAt(i,4).toString());
				comboBox_4.setSelectedItem(model.getValueAt(i,5).toString());
				
			}
			
		});
        
        btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
				       Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","root");
					   int i = table.getSelectedRow();
					   String query = " UPDATE parallelsessions SET startTime = '" + (String) comboBox.getSelectedItem() + "',day = '" +  (String) comboBox_2.getSelectedItem() + "',duration = '" + (String) comboBox_1.getSelectedItem() + "',subject1 = '" + (String) comboBox_3.getSelectedItem() + "',subject2 = '" + (String) comboBox_4.getSelectedItem() + "' where id = '"+model.getValueAt(i,0)+"' ";
							
					   Statement sta = connection.createStatement();
					   int x = sta.executeUpdate(query);
							
					   model.setValueAt((String) comboBox.getSelectedItem() , i,1);
					   model.setValueAt((String) comboBox_2.getSelectedItem(), i,2);
					   model.setValueAt((String) comboBox_1.getSelectedItem(), i,3);
					   model.setValueAt((String) comboBox_3.getSelectedItem(), i,4);
					   model.setValueAt((String) comboBox_4.getSelectedItem(), i,5);
					   table.setModel(model);
							
					    JOptionPane.showMessageDialog(null, "Sucessfully  Updated");
							
					    connection.close();
							
							
						}catch (Exception exception) {
		                    exception.printStackTrace();
		                }
				
			}
		});
		btnNewButton.setBounds(181, 573, 115, 29);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {	
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","root");
					int i = table.getSelectedRow();
					String delRow = "delete from parallelsessions where id= '"+model.getValueAt(i,0)+"'";
			        
					Statement sta = connection.createStatement();
					int x = sta.executeUpdate(delRow);
					model.removeRow(i);
					 JOptionPane.showMessageDialog(null, "Sucessfully Deleted");
			        } catch (Exception e1) {
			            JOptionPane.showMessageDialog(null,  e1.getMessage());
			        }
				
			}
		});
		btnNewButton_1.setBounds(482, 573, 115, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				comboBox.setSelectedItem(null);
				comboBox_1.setSelectedItem(null);
				comboBox_2.setSelectedItem(null);
				comboBox_3.setSelectedItem(null);
				comboBox_4.setSelectedItem(null);
				
			}
		});
		btnNewButton_2.setBounds(789, 573, 115, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		

	}
}
