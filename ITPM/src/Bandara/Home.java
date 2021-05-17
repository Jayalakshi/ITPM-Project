package location;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Home {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(243, 235, 242));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HOME PAGE ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(387, 16, 177, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add Student Groups ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(15, 56, 277, 55);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Add Tags ");
		btnNewButton_2.setBounds(15, 127, 277, 55);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Time Allocations For Sessions ");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_4.setBounds(15, 195, 277, 55);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_6 = new JButton("Manage Locations");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_6.setBounds(677, 269, 277, 55);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_8 = new JButton("Allocate Rooms");
		btnNewButton_8.setBounds(677, 340, 277, 61);
		frame.getContentPane().add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Dash Board");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_9.setBounds(677, 195, 277, 55);
		frame.getContentPane().add(btnNewButton_9);
		
		JButton btnNewButton_14 = new JButton("Add Lecturer ");
		btnNewButton_14.setBounds(340, 52, 277, 61);
		frame.getContentPane().add(btnNewButton_14);
		
		JButton btnNewButton_16 = new JButton("Add Preffered Sessions");
		btnNewButton_16.setBounds(677, 126, 277, 55);
		frame.getContentPane().add(btnNewButton_16);
		
		JButton btnNewButton_17 = new JButton("Add Subjects");
		btnNewButton_17.setBounds(340, 126, 277, 55);
		frame.getContentPane().add(btnNewButton_17);
		
		JButton btnNewButton_19 = new JButton("Add Sessions");
		btnNewButton_19.setBounds(340, 198, 277, 55);
		frame.getContentPane().add(btnNewButton_19);
		
		JButton btnNewButton_21 = new JButton("Add Working Days");
		btnNewButton_21.setBounds(340, 269, 277, 55);
		frame.getContentPane().add(btnNewButton_21);
		
		JButton btnNewButton_22 = new JButton("Not Available Rooms");
		btnNewButton_22.setBounds(340, 340, 277, 61);
		frame.getContentPane().add(btnNewButton_22);
		
		JButton btnNewButton_1 = new JButton("Not Available Time");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(677, 41, 277, 55);
		frame.getContentPane().add(btnNewButton_1);
	}
}
