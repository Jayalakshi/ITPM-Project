package pckg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Panel;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import pckg.ManageTags;
import sun.applet.Main;

public class AddTag {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTag window = new AddTag();
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
	public AddTag() {
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
		
		JTextPane txtpnAddTag = new JTextPane();
		txtpnAddTag.setEditable(false);
		txtpnAddTag.setFont(new Font("Times New Roman", Font.BOLD, 25));
		txtpnAddTag.setText("ADD TAG");
		txtpnAddTag.setBackground(new Color(243,235,242));
		txtpnAddTag.setBounds(531, 16, 156, 33);
		frame.getContentPane().add(txtpnAddTag);
		
		JTextPane txtpnTagName = new JTextPane();
		txtpnTagName.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnTagName.setText("Tag Name");
		txtpnTagName.setBounds(436, 93, 224, 35);
		txtpnTagName.setBackground(new Color(243,235,242));
		frame.getContentPane().add(txtpnTagName);
		
		JTextPane txtpnTagCode = new JTextPane();
		txtpnTagCode.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnTagCode.setText("Tag Code");
		txtpnTagCode.setBounds(436, 222, 224, 33);
		txtpnTagCode.setBackground(new Color(243,235,242));
		frame.getContentPane().add(txtpnTagCode);
		
		JTextPane txtpnRelatedTag = new JTextPane();
		txtpnRelatedTag.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		txtpnRelatedTag.setText("Related Tag");
		txtpnRelatedTag.setBounds(436, 344, 224, 35);
		txtpnRelatedTag.setBackground(new Color(243,235,242));
		frame.getContentPane().add(txtpnRelatedTag);
		
		textField = new JTextField();
		textField.setBounds(436, 158, 360, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(436, 274, 360, 33);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(436, 396, 360, 33);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("Lecture");
		comboBox.addItem("Tutorial");
		comboBox.addItem("Lab");
		comboBox.setSelectedItem(null);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textField.setText(" ");
				textField_1.setText(" ");
				comboBox.setSelectedItem(null);
				
				
			}
		});
		btnNewButton.setBounds(106, 513, 201, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String tagname = textField.getText();
				String tagcode = textField_1.getText();
				String rtag = (String) comboBox.getSelectedItem();
				
                 try {
					
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root","root");
				
					String query = "Insert into tags(tagname,tagcode,rTag) values('" + tagname + "', '" + tagcode + "','" + rtag + "')";
					
					Statement sta = connection.createStatement();
					int x = sta.executeUpdate(query);
					
					 JOptionPane.showMessageDialog(null, "Sucessfully Inserted");
					
					connection.close();
					
				}catch (Exception exception) {
                    exception.printStackTrace();
                }
				
				
				}
				
			
		});
		btnNewButton_1.setBounds(394, 513, 191, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Home");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                Home home = new Home();
				
				home.main(null);
				frame.setVisible(false);
				
			}
		});
		btnNewButton_2.setBounds(681, 513, 185, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ManageTags mt = new ManageTags();
				AddTag at = new AddTag();
				
				mt.ManTags();
				
				frame.setVisible(false);
				
			 
			}
		});
		btnNewButton_3.setBounds(949, 513, 179, 29);
		frame.getContentPane().add(btnNewButton_3);
		frame.setBounds(100, 100, 1128, 614);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		
	}
}
