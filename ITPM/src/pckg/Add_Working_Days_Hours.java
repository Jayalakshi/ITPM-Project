import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Checkbox;
import java.awt.List;
import java.awt.Button;

public class Add_Working_Days_Hours {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Working_Days_Hours window = new Add_Working_Days_Hours();
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
	public Add_Working_Days_Hours() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(243,235,242));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 728, 488);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Add Working Days & Hours");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(220, 11, 268, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("No of working Days");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(28, 55, 141, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
		comboBox.setBounds(185, 53, 160, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Working Days");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(28, 99, 144, 22);
		frame.getContentPane().add(lblNewLabel_2);
		
		Checkbox checkbox = new Checkbox("Monday");
		checkbox.setBounds(182, 99, 95, 22);
		frame.getContentPane().add(checkbox);
		
		Checkbox checkbox_1 = new Checkbox("Tuesday");
		checkbox_1.setBounds(182, 127, 95, 22);
		frame.getContentPane().add(checkbox_1);
		
		Checkbox checkbox_2 = new Checkbox("Wendnesday");
		checkbox_2.setBounds(182, 155, 95, 22);
		frame.getContentPane().add(checkbox_2);
		
		Checkbox checkbox_3 = new Checkbox("Thursday");
		checkbox_3.setBounds(182, 183, 95, 22);
		frame.getContentPane().add(checkbox_3);
		
		Checkbox checkbox_4 = new Checkbox("Friday");
		checkbox_4.setBounds(182, 211, 95, 22);
		frame.getContentPane().add(checkbox_4);
		
		Checkbox checkbox_5 = new Checkbox("Saturday");
		checkbox_5.setBounds(182, 239, 95, 22);
		frame.getContentPane().add(checkbox_5);
		
		Checkbox checkbox_6 = new Checkbox("Sunday");
		checkbox_6.setBounds(182, 267, 95, 22);
		frame.getContentPane().add(checkbox_6);
		
		JLabel lblNewLabel_3 = new JLabel("Working Time Per Day");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(28, 310, 144, 22);
		frame.getContentPane().add(lblNewLabel_3);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(345, 315, 143, 20);
		frame.getContentPane().add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBackground(new Color(127, 255, 212));
		spinner_1.setBounds(184, 315, 127, 20);
		frame.getContentPane().add(spinner_1);
		
		JLabel lblNewLabel_4 = new JLabel("Select Time Slot");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(28, 367, 144, 19);
		frame.getContentPane().add(lblNewLabel_4);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("One Hour time slots");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNewRadioButton.setBounds(183, 363, 143, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Thirty minutes time slots");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNewRadioButton_1.setBounds(345, 363, 167, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String dayscount=comboBox.getSelectedItem().toString();
					String days="";
					if(checkbox.getState()) {
						days+="Monday-";
					}
					if(checkbox_1.getState()) {
						days+="Tuesday-";
					}
 					if(checkbox_2.getState()) {
						days+="Wednesday-";
					}
 					if(checkbox_3.getState()) {
						days+="Thursday-";
					}
 					if(checkbox_4.getState()) {
						days+="Friday-";
					}
 					if(checkbox_5.getState()) {
						days+="Saturday-";
					}
 					if(checkbox_6.getState()) {
						days+="Sunday-";
					}
					String time=spinner_1.getValue().toString()+":"+spinner.getValue().toString();
					String slot="";
					if(rdbtnNewRadioButton.isSelected()) {
						slot="hour";
					}else {
						slot="half";
					}
		            DB.DB.iud("insert into working_hours(count_day, days, d_time, slot,status) values('"+dayscount+"','"+days+"','"+time+"','"+slot+"','Active')");
		            JOptionPane.showMessageDialog(null, "Succesfully inserted");
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
			}
		});
		btnNewButton.setBounds(541, 359, 143, 31);
		frame.getContentPane().add(btnNewButton);
		
		Button button = new Button("Back to Home");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(10, 11, 80, 22);
		frame.getContentPane().add(button);
	}
}
