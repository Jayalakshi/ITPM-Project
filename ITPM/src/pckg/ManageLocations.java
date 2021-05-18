package pckg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.ScrollPane;
import javax.swing.JSpinner;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;


public class ManageLocations {

	private JFrame frame;
	private JTable table;
	private JTextField buildingName;
	private JTable table_1;
	private JTextField rname;
	DefaultTableModel model;
	DefaultTableModel model1;
	 private static final AtomicInteger count = new AtomicInteger(000); 
	 private JTextField numberOfRooms;
	 private JTextField cap;
	 private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageLocations window = new ManageLocations();
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
	public ManageLocations() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(243,235,242));
		frame.getContentPane().setBackground(new Color(243,235,242));
		frame.setBounds(100, 100, 1028, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 68, 978, 376);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 978, 376);
		panel.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Manage Buildings", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 37, 750, 198);
		panel_1.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane.setViewportView(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i= table.getSelectedRow();
				buildingName.setText(model.getValueAt(i, 1).toString());
				numberOfRooms.setText(model.getValueAt(i, 2).toString());
				
			}
		});
		table.setBackground(Color.WHITE);
		model = new DefaultTableModel();
		Object [] column = {"BID","Building Name","Number of Rooms"};
		Object [] row =new Object [3];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane_1.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Building Name");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(25, 246, 132, 37);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Number of Rooms");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(25, 299, 174, 23);
		panel_1.add(lblNewLabel_2);
		
		buildingName = new JTextField();
		buildingName.setBounds(234, 246, 206, 26);
		panel_1.add(buildingName);
		buildingName.setColumns(10);
		
		JButton btnNewButton = new JButton("Back to Home");
		btnNewButton.setBounds(814, 241, 144, 29);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i>=0) {
					model.setValueAt(buildingName.getText(), i, 1);
					model.setValueAt(numberOfRooms.getText(), i, 2);
					int selectedrow=table.getSelectedRow();
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					try {
						DB.DB.iud("update building set name='"+buildingName.getText()+"', capacity='"+numberOfRooms.getText()+"' where idbuilding='"+dtm.getValueAt(selectedrow, 0)+"'");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Updated Successfully");
				}
				else {
					JOptionPane.showMessageDialog(null, "Please select a row");
				}
			}
		});
		btnNewButton_1.setBounds(814, 106, 144, 29);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i =table.getSelectedRow();
				if (i>= 0) {
					int selectedrow=table.getSelectedRow();
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					try {
						DB.DB.iud("update building set status='deactive' where idbuilding='" + dtm.getValueAt(selectedrow, 0).toString() + "'");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	                
				model.removeRow(i);
				JOptionPane.showMessageDialog(null, "Delete Successfully");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "First select a row");
					
				}
			}
		});
		btnNewButton_2.setBounds(814, 151, 144, 29);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Clear");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buildingName.setText("");
				numberOfRooms.setText("");
			}
		});
		btnNewButton_3.setBounds(814, 196, 144, 29);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_12 = new JButton("Add");
	
	
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (buildingName.getText().equals("") || numberOfRooms.getText().equals("") ) {
					JOptionPane.showMessageDialog(null, "Please fill all necessary feilds");
				}  
				else {

					try {
					row[0]= count.incrementAndGet(); 
					row[1]=buildingName.getText();
					row[2]=numberOfRooms.getText();
					model.addRow(row);
						DB.DB.iud("insert into building(name, capacity, status) values('"+buildingName.getText()+"','"+numberOfRooms.getText()+"','Active')");
					
					
					buildingName.setText("");
					numberOfRooms.setText("");
					JOptionPane.showMessageDialog(null, "Saved Successfully");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton_12.setBounds(814, 61, 144, 29);
		panel_1.add(btnNewButton_12);
		
		numberOfRooms = new JTextField();
		numberOfRooms.setBounds(234, 296, 206, 26);
		panel_1.add(numberOfRooms);
		numberOfRooms.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Manage Rooms", null, panel_2, null);
		panel_2.setLayout(null);
		
		
		
		JButton btnNewButton_5 = new JButton("Delete");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int t = table_1.getSelectedRow();
				if(t>=0) {
					int selectedrow=table_1.getSelectedRow();
				DefaultTableModel dtm = (DefaultTableModel) table_1.getModel();
				try {
					DB.DB.iud("update rooms set status='deactive' where idsession_rooms='" + dtm.getValueAt(selectedrow, 0).toString() + "'");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					model1.removeRow(t);
					JOptionPane.showMessageDialog(null,"Delete Successfully");
				}
				else {
					
					JOptionPane.showMessageDialog(null,"please Select a row");
				}
				
			}
		});
		btnNewButton_5.setBounds(796, 122, 162, 29);
		panel_2.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Clear");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rname.setText("");
				cap.setText("");
				
			}
		});
		btnNewButton_6.setBounds(796, 163, 162, 29);
		panel_2.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Back to Home");
		btnNewButton_7.setBounds(796, 208, 163, 29);
		panel_2.add(btnNewButton_7);
		
		JLabel lblNewLabel_3 = new JLabel("Building Name");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(30, 252, 138, 39);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Room");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(30, 297, 115, 29);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Room Type");
		lblNewLabel_5.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(422, 252, 150, 39);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Capacity");
		lblNewLabel_6.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(422, 297, 105, 29);
		panel_2.add(lblNewLabel_6);
		
		rname = new JTextField();
		rname.setBounds(168, 301, 214, 26);
		panel_2.add(rname);
		rname.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(30, 39, 722, 170);
		panel_2.add(scrollPane_2);
		

		JComboBox comboBox = new JComboBox();
		
		
		JRadioButton rlec = new JRadioButton("Lecture Hall");
		rlec.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		rlec.setBounds(537, 260, 155, 29);
		panel_2.add(rlec);
		
		JRadioButton rlan = new JRadioButton("\r\nLaboratory");
		rlan.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		rlan.setBounds(705, 260, 155, 29);
		panel_2.add(rlan);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int t =table_1.getSelectedRow();
				comboBox.setSelectedItem(model1.getValueAt(t, 1).toString());
				rname.setText(model1.getValueAt(t, 2).toString());
				cap.setText(model1.getValueAt(t, 4).toString());
				if(model1.getValueAt(t, 3).toString().equals("Lecture Hall")) {
					rlec.setSelected(true);
					rlan.setSelected(false);
				}else {
					rlec.setSelected(false);
					rlan.setSelected(true);
				}
			}
		});
		table_1.setBackground(Color.WHITE);
		model1 = new DefaultTableModel();
		Object [] column1 = {"RID","Building","Room","Type","Capacity"};
		Object [] row1 =new Object [5];
		model1.setColumnIdentifiers(column1);
		table_1.setModel(model1);
		
		scrollPane_2.setViewportView(table_1);
		;
		
		JButton btnNewButton_11 = new JButton("Add");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rname.getText().equals("")|| cap.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Please fill compleate details");
				}
				else {
				row1[0]= count.incrementAndGet(); 
				//String comboBox =model.getValueAt(addRow, 1).toString;
				String value =  comboBox.getSelectedItem().toString();
				row1[1]=value;
				row1[2]=rname.getText();
				//row3[2]=rLec.getText();
				//row4[3]=rLab.getText();
				row1[4]=cap.getText();
				String roomtype="";
				if(rlec.isSelected()) {
					roomtype="Lecture Hall";
				}else {
					roomtype="Laboratory";
				}
				row1[3]=roomtype;
				model1.addRow(row1);
				try {
					String buildingid="";
					ResultSet rs2 = DB.DB.search("select idbuilding from building where name='" + comboBox.getSelectedItem().toString() + "'");
	                if (rs2.first()) {
	                	buildingid = rs2.getString(1);
	                }
					DB.DB.iud("insert into rooms(building, type, name, status, capacity) values('"+buildingid+"','"+roomtype+"','"+rname.getText()+"','Active','"+cap.getText()+"')");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				rname.setText("");
				cap.setText("");
				//JOptionPane.showMessageDialog(null,"Saved Successfully");
				}
			}
		});
		btnNewButton_11.setBounds(796, 29, 162, 29);
		panel_2.add(btnNewButton_11);
		
		JButton btnNewButton_4 = new JButton("Update");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int t=table_1.getSelectedRow();
				String roomtype="";
				if(rlec.isSelected()) {
					roomtype="Lecture Hall";
				}else {
					roomtype="Laboratory";
				}
					model1.setValueAt(comboBox.getSelectedItem() ,t ,1);
					model1.setValueAt(rname.getText() ,t ,2);
					model1.setValueAt(roomtype ,t ,3);
					model1.setValueAt(cap.getText(), t, 4);
					int selectedrow=table_1.getSelectedRow();
					DefaultTableModel dtm = (DefaultTableModel) table_1.getModel();
					try {
						
						String buildingid="";
						ResultSet rs2 = DB.DB.search("select idbuilding from building where name='" + comboBox.getSelectedItem().toString() + "'");
		                if (rs2.first()) {
		                	buildingid = rs2.getString(1);
		                }
						DB.DB.iud("update rooms set building='"+buildingid+"', type='"+roomtype+"', name='"+rname.getText()+"', capacity='"+cap.getText()+"' where idsession_rooms='"+dtm.getValueAt(selectedrow, 0)+"'");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Updated Successfully");
				//}
				//else {
					
					//JOptionPane.showMessageDialog(null,"please Select a row");
				//}
			}
		});
		btnNewButton_4.setBounds(796, 74, 162, 29);
		panel_2.add(btnNewButton_4);
		
		cap = new JTextField();
		cap.setBounds(537, 301, 203, 26);
		panel_2.add(cap);
		cap.setColumns(10);
		String [] a= {"aa","nn"};


	
		comboBox.setBounds(168, 261, 214, 26);
		panel_2.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Manage Locations");
		lblNewLabel.setBounds(317, 23, 249, 34);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		try {
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            ResultSet rs = DB.DB.search("select b.idbuilding,b.name,b.capacity from building b where b.status!='deactive'");
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                dtm.addRow(v);
            }
            
            DefaultTableModel dtm2 = (DefaultTableModel) table_1.getModel();
            ResultSet rs2 = DB.DB.search("select r.idsession_rooms,b.name,r.name,r.`type`,r.capacity from rooms r join building b on r.building=b.idbuilding where r.status!='deactive'");
            dtm2.setRowCount(0);
            while (rs2.next()) {
                Vector v = new Vector();
                v.add(rs2.getString(1));
                v.add(rs2.getString(2));
                v.add(rs2.getString(3));
                v.add(rs2.getString(4));
                v.add(rs2.getString(5));
                dtm2.addRow(v);
            }
            comboBox.removeAllItems();
            comboBox.addItem("<-Select->");
            ResultSet rs3 = DB.DB.search("select distinct name from building");
            while (rs3.next()) {
            	comboBox.addItem(rs3.getString(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
}
