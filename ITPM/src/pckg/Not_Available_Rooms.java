package pckg;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import java.awt.TextField;
import java.sql.ResultSet;
import java.awt.Font;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Not_Available_Rooms {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Not_Available_Rooms window = new Not_Available_Rooms();
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
	public Not_Available_Rooms() {
		initialize();
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(243,235,242));
		frame.setBounds(100, 100, 700, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(157, 131, 199, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Building Name");
		lblNewLabel_2.setBounds(34, 134, 108, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Room Name");
		lblNewLabel_3.setBounds(34, 174, 108, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Room Type");
		lblNewLabel_4.setBounds(34, 216, 108, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Lecture Hall", "Laboratory"}));
		comboBox_2.setBounds(157, 213, 199, 20);
		frame.getContentPane().add(comboBox_2);
		
		JLabel lblNewLabel_6 = new JLabel(" Time");
		lblNewLabel_6.setBounds(34, 271, 108, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		TextField textField = new TextField();
		textField.setBounds(157, 263, 199, 22);
		frame.getContentPane().add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("Rooms");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(34, 72, 76, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(157, 166, 199, 22);
		frame.getContentPane().add(textField_1);
		
		Button button = new Button("Back to Home");
		button.setBounds(10, 11, 80, 22);
		frame.getContentPane().add(button);
		
		JLabel lblNotAvailableRoom = new JLabel(" Not Available Room");
		lblNotAvailableRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNotAvailableRoom.setBounds(253, 11, 199, 22);
		frame.getContentPane().add(lblNotAvailableRoom);
		
		JButton btnNewButton_2 = new JButton("Add");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String building_id="";
					String rtype=comboBox_2.getSelectedItem().toString();
		            ResultSet rs = DB.DB.search("select idbuilding from building where name='"+comboBox.getSelectedItem().toString()+"'");
		            if (rs.first()) {
		            	building_id=rs.getString(1);
		            }
		            String rname=textField_1.getText();
		            String time=textField.getText();
		            DB.DB.iud("insert into rooms(building, type, time, name, status) values('"+building_id+"','"+rtype+"','"+time+"','"+rname+"','Active')");
		            JOptionPane.showMessageDialog(null, "Succesfully inserted");
		            textField.setText("");
		            textField_1.setText("");
		            comboBox.setSelectedItem("<-Select->");
		            comboBox_2.setSelectedItem("Lecture Hall");
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
			}
		});
		btnNewButton_2.setBounds(34, 345, 165, 34);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("View");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(248, 345, 165, 34);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
	            textField_1.setText("");
	            comboBox.setSelectedItem("<-Select->");
	            comboBox_2.setSelectedItem("Lecture Hall");
			}
		});
		btnClear.setBounds(482, 345, 165, 34);
		frame.getContentPane().add(btnClear);
		
		try {
           ResultSet rs = DB.DB.search("select name from building");
            while (rs.next()) {
            	comboBox.addItem(rs.getString(1));
           	 //comboBox_2.addItem(rs.getString(2));
          }
      } catch (Exception ex) {
          ex.printStackTrace();
       }
	}

}
