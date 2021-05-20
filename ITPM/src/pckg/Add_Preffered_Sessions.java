import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.Font;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Add_Preffered_Sessions {

	private JFrame frame;
	private JComboBox comboBox;
	private JTextField day;
	private JTextField stime;
	private JTextField etime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Preffered_Sessions window = new Add_Preffered_Sessions();
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
	public Add_Preffered_Sessions() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 734, 477);
		frame.getContentPane().setBackground(new Color(243,235,242));
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddPrefferedSession = new JLabel("Add Preffered Session");
		lblAddPrefferedSession.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddPrefferedSession.setBounds(227, 10, 237, 31);
		frame.getContentPane().add(lblAddPrefferedSession);
		
		Button button = new Button("Back to Home");
		button.setBounds(10, 10, 109, 22);
		frame.getContentPane().add(button);
		
		JLabel lblNewLabel_1 = new JLabel("Select Room");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(31, 89, 91, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Start Time");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(31, 130, 91, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("End Time");
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(31, 178, 97, 20);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Day");
		lblNewLabel_2_2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(31, 228, 97, 22);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		day = new JTextField();
		day.setBounds(147, 225, 250, 20);
		frame.getContentPane().add(day);
		day.setColumns(10);
		
		stime = new JTextField();
		stime.setBounds(147, 130, 250, 20);
		frame.getContentPane().add(stime);
		stime.setColumns(10);
		
		etime = new JTextField();
		etime.setBounds(147, 178, 250, 20);
		frame.getContentPane().add(etime);
		etime.setColumns(10);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<-Select->"}));
		comboBox.setBounds(147, 86, 250, 20);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(480, 332, 164, 41);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(268, 332, 164, 41);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add Session");
		btnNewButton_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stime.getText().equals("")|| etime.getText().equals("")|| day.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Please fill compleate details");
				}else {
					String value =  comboBox.getSelectedItem().toString();
				try {
					String idsession_rooms="";
					ResultSet rs2 = DB.DB.search("select name from rooms where name='" + comboBox.getSelectedItem().toString() + "'");
	                if (rs2.first()) {
	                	idsession_rooms = rs2.getString(1);
	                }
					DB.DB.iud("insert into preffered_session(room, start_time, end_time, day) values('"+idsession_rooms+"','"+stime.getText()+"','"+etime.getText()+"','"+day.getText()+"')");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				stime.setText("");
				etime.setText("");
				day.setText("");
				//JOptionPane.showMessageDialog(null,"Saved Successfully");
				JOptionPane.showMessageDialog(null,"Save Successfully");
				}
			}
		});
		btnNewButton_2.setBounds(58, 332, 164, 41);
		frame.getContentPane().add(btnNewButton_2);
		
		try {
            comboBox.removeAllItems();
            comboBox.addItem("<-Select->");
            ResultSet rs2 = DB.DB.search("select distinct name  from rooms");
            while (rs2.next()) {
            	comboBox.addItem(rs2.getString(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
}
