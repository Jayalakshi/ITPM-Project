package pckg;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.Panel;
import javax.swing.JComboBox;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.ScrollPane;
import javax.swing.JSpinner;

public class GenerateTimeTable {

	private JFrame frame;
	private final JButton btnNewButton_1 = new JButton("Print");
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateTimeTable window = new GenerateTimeTable();
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
	public GenerateTimeTable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.getContentPane().setBackground(new Color(243,235,242));
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnGenerateTimeTables = new JTextPane();
		txtpnGenerateTimeTables.setEditable(false);
		txtpnGenerateTimeTables.setText("GENERATE TIME TABLES");
		txtpnGenerateTimeTables.setFont(new Font("Times New Roman", Font.BOLD, 25));
		txtpnGenerateTimeTables.setBackground(new Color(243,235,242));
		txtpnGenerateTimeTables.setBounds(563, 28, 332, 45);
		frame.getContentPane().add(txtpnGenerateTimeTables);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(354, 187, 756, 404);
		frame.getContentPane().add(tabbedPane);
		
		Panel panel = new Panel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Lecturer ", null, panel, null);
		panel.setLayout(null);
		
		JTextPane txtpnLecturer = new JTextPane();
		txtpnLecturer.setEditable(false);
		txtpnLecturer.setFont(new Font("Yu Gothic Light", Font.PLAIN, 18));
		txtpnLecturer.setText("Lecturer");
		txtpnLecturer.setBounds(15, 2, 90, 40);
		panel.add(txtpnLecturer);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(111, 16, 182, 26);
		panel.add(comboBox);
		comboBox.addItem("Nalaka Dissanayake");
		comboBox.addItem("Dilshan De silva");
		comboBox.addItem("Shashika Lokugamange");
		comboBox.addItem("Uthapala Samaranayake");
		comboBox.addItem("Nelum Amarasena");
		comboBox.addItem("Hansika Mayadunne");
		comboBox.setSelectedItem(null);
		
		
		btnNewButton_1.setBounds(513, 16, 122, 29);
		panel.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 84, 721, 270);
		panel.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JButton btnNewButton = new JButton("Generate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox.getSelectedItem().toString().equals("Nalaka Dissanayake") || comboBox.getSelectedItem().toString().equals("Dilshan De silva")){
					
					
					try {
						
						Object[] column = {"Time Slots","Monday", "Tuesday", "Wednesday","Thursday","Friday"};
						model.setColumnIdentifiers(column);
						
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","root");
						PreparedStatement pstm = connection.prepareStatement("SELECT * FROM lecture_1");
				        ResultSet Rs = pstm.executeQuery();
				        while(Rs.next()){
				            model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getString(6)});
				        }
						
						
						
						}catch (Exception e1) {
				            System.out.println(e1.getMessage());
				        }
								
				}
				
				else if(comboBox.getSelectedItem().toString().equals("Shashika Lokugamange") || comboBox.getSelectedItem().toString().equals("Uthapala Samaranayake")){
					
					
					try {
						
						Object[] column = {"Time Slots","Monday", "Tuesday", "Wednesday","Thursday","Friday"};
						model.setColumnIdentifiers(column);
						
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","root");
						PreparedStatement pstm = connection.prepareStatement("SELECT * FROM lecture_2");
				        ResultSet Rs = pstm.executeQuery();
				        while(Rs.next()){
				            model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getString(6)});
				        }
						
						
						
						}catch (Exception e1) {
				            System.out.println(e1.getMessage());
				        }
								
				}
				
                else {
					
					
					try {
						
						Object[] column = {"Time Slots","Monday", "Tuesday", "Wednesday","Thursday","Friday"};
						model.setColumnIdentifiers(column);
						
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","root");
						PreparedStatement pstm = connection.prepareStatement("SELECT * FROM lecture_3");
				        ResultSet Rs = pstm.executeQuery();
				        while(Rs.next()){
				            model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getString(6)});
				        }
						
						
						
						}catch (Exception e1) {
				            System.out.println(e1.getMessage());
				        }
								
				}
				
				
				
			}
		});
		
		table.setModel(model);
		table.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 16));
		scrollPane.setViewportView(table);
		
		btnNewButton.setBounds(383, 16, 115, 29);
		panel.add(btnNewButton);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				try {
//				    if (! table.print()) {
//				        System.err.println("User cancelled printing");
//				    }
//				} catch (java.awt.print.PrinterException e1) {
//				    System.err.format("Cannot print %s%n", e1.getMessage());
//				}
//
//				MessageFormat header = new MessageFormat("Page {0,number,integer}");
//				try {
//				    table.print(JTable.PrintMode.FIT_WIDTH, header, null);
//				} catch (java.awt.print.PrinterException e2) {
//				    System.err.format("Cannot print %s%n", e2.getMessage());
//				}
				
				try {
					table.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
			}
		});
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Student ", null, panel_1, null);
		panel_1.setLayout(null);
		
		JTextPane txtpnGroup = new JTextPane();
		txtpnGroup.setEditable(false);
		txtpnGroup.setBounds(15, 16, 74, 26);
		txtpnGroup.setText("Group");
		txtpnGroup.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		panel_1.add(txtpnGroup);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(105, 16, 190, 26);
		panel_1.add(comboBox_1);
		comboBox_1.addItem("Y1S1.IT.1");
		comboBox_1.addItem("Y1S2.IT.2");
		comboBox_1.addItem("Y2S2.BM.5");
		comboBox_1.addItem("Y3S1.ENG.2");
		comboBox_1.addItem("Y3S2.IT.10");
		comboBox_1.addItem("Y4S2.IT.6");
		comboBox_1.setSelectedItem(null);

		JButton btnNewButton_3 = new JButton("Print");
		btnNewButton_3.setBounds(527, 16, 115, 29);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnNewButton_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(15, 84, 721, 270);
		panel_1.add(scrollPane_1);
		
		DefaultTableModel model1 = new DefaultTableModel();
		table_1 = new JTable();
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JButton btnNewButton_2 = new JButton("Generate");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
        if(comboBox_1.getSelectedItem().toString().equals("Y1S1.IT.1") || comboBox_1.getSelectedItem().toString().equals("Y1S2.IT.2")){
					
					
					try {
						
						Object[] column = {"Time Slots","Monday", "Tuesday", "Wednesday","Thursday","Friday"};
						model1.setColumnIdentifiers(column);
						
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","root");
						PreparedStatement pstm = connection.prepareStatement("SELECT * FROM student_1");
				        ResultSet Rs = pstm.executeQuery();
				        while(Rs.next()){
				            model1.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getString(6)});
				        }
						
						
						
						}catch (Exception e1) {
				            System.out.println(e1.getMessage());
				        }
								
				}
				
		else if(comboBox_1.getSelectedItem().toString().equals("Y2S2.BM.5") || comboBox_1.getSelectedItem().toString().equals("Y3S1.ENG.2")){
					
					
					try {
						
						Object[] column = {"Time Slots","Monday", "Tuesday", "Wednesday","Thursday","Friday"};
						model1.setColumnIdentifiers(column);
						
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","root");
						PreparedStatement pstm = connection.prepareStatement("SELECT * FROM student_2");
				        ResultSet Rs = pstm.executeQuery();
				        while(Rs.next()){
				            model1.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getString(6)});
				        }
						
						
						
						}catch (Exception e1) {
				            System.out.println(e1.getMessage());
				        }
								
				}
				
         else {
					
					
					try {
						
						Object[] column = {"Time Slots","Monday", "Tuesday", "Wednesday","Thursday","Friday"};
						model1.setColumnIdentifiers(column);
						
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","root");
						PreparedStatement pstm = connection.prepareStatement("SELECT * FROM student_3");
				        ResultSet Rs = pstm.executeQuery();
				        while(Rs.next()){
				            model1.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getString(6)});
				        }
						
						
						
						}catch (Exception e1) {
				            System.out.println(e1.getMessage());
				        }
								
				}
				
				
			}
		});

		table_1.setModel(model1);
		table_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 16));
		scrollPane_1.setViewportView(table_1);
		
		btnNewButton_2.setBounds(396, 16, 115, 29);
		panel_1.add(btnNewButton_2);
	
		Panel panel_2 = new Panel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Location ", null, panel_2, null);
		panel_2.setLayout(null);
		
		JTextPane txtpnLocation = new JTextPane();
		txtpnLocation.setEditable(false);
		txtpnLocation.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		txtpnLocation.setText("Location");
		txtpnLocation.setBounds(15, 16, 77, 26);
		panel_2.add(txtpnLocation);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(107, 16, 187, 26);
		panel_2.add(comboBox_2);
		comboBox_2.addItem("A502");
		comboBox_2.addItem("B503");
		comboBox_2.addItem("A504");
		comboBox_2.addItem("N3D");
		comboBox_2.addItem("F502");
		comboBox_2.addItem("B501");
		comboBox_2.setSelectedItem(null);
		
		JButton btnNewButton_5 = new JButton("Print");
		btnNewButton_5.setBounds(524, 16, 115, 29);
		panel_2.add(btnNewButton_5);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(15, 83, 721, 271);
		panel_2.add(scrollPane_2);
		
		DefaultTableModel model2 = new DefaultTableModel();
		table_2 = new JTable();
		table_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JButton btnNewButton_4 = new JButton("Generate");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
            if(comboBox_2.getSelectedItem().toString().equals("A502") || comboBox_2.getSelectedItem().toString().equals("N3D")){
					
					
					try {
						
						Object[] column = {"Time Slots","Monday", "Tuesday", "Wednesday","Thursday","Friday"};
						model2.setColumnIdentifiers(column);
						
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","root");
						PreparedStatement pstm = connection.prepareStatement("SELECT * FROM location_1");
				        ResultSet Rs = pstm.executeQuery();
				        while(Rs.next()){
				            model2.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getString(6)});
				        }
						
						
						
						}catch (Exception e1) {
				            System.out.println(e1.getMessage());
				        }
								
				}
				
			else if(comboBox_2.getSelectedItem().toString().equals("B503") || comboBox_2.getSelectedItem().toString().equals("F502")){
					
					
					try {
						
						Object[] column = {"Time Slots","Monday", "Tuesday", "Wednesday","Thursday","Friday"};
						model2.setColumnIdentifiers(column);
						
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","root");
						PreparedStatement pstm = connection.prepareStatement("SELECT * FROM location_2");
				        ResultSet Rs = pstm.executeQuery();
				        while(Rs.next()){
				            model2.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getString(6)});
				        }
						
						
						
						}catch (Exception e1) {
				            System.out.println(e1.getMessage());
				        }
								
				}
				
             else {
					
					
					try {
						
						Object[] column = {"Time Slots","Monday", "Tuesday", "Wednesday","Thursday","Friday"};
						model2.setColumnIdentifiers(column);
						
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","root");
						PreparedStatement pstm = connection.prepareStatement("SELECT * FROM location_3");
				        ResultSet Rs = pstm.executeQuery();
				        while(Rs.next()){
				            model2.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getString(6)});
				        }
						
						
						
						}catch (Exception e1) {
				            System.out.println(e1.getMessage());
				        }
								
				}
				
				
				
			}
		});
		
		scrollPane_2.setViewportView(table_2);
		table_2.setModel(model2);
		table_2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 16));
		
		btnNewButton_4.setBounds(394, 15, 115, 29);
		panel_2.add(btnNewButton_4);
		
		
		frame.setBounds(100, 100, 1062, 740);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
