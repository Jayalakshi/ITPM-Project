package pckg;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;


public class Chart extends JPanel {
	
	private Map<Color, Integer> bars =
            new LinkedHashMap<Color, Integer>();
	public void addBar(Color color, int value)
	{
		bars.put(color, value);
		repaint();
	}
	@Override
	protected void paintComponent(Graphics g)
	{
		// determine longest bar
		
		int max = Integer.MIN_VALUE;
		for (Integer value : bars.values())
		{
			max = Math.max(max, value);
		}
		
		// paint bars
		
		int width = (getWidth() / bars.size()) - 2;
		int x = 1;
		for (Color color : bars.keySet())
		{
			int value = bars.get(color);
			int height = (int) 
                            ((getHeight()-5) * ((double)value / max));
			g.setColor(color);
			g.fillRect(x, getHeight() - height, width, height);
			g.setColor(Color.black);
			g.drawRect(x, getHeight() - height, width, height);
			x += (width + 2);
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(bars.size() * 10 + 2, 50);
	}

	private JFrame frame;
	private JTextField txtMssamanRathnayake;
	private JTextField txtYs;
	private JTextField txtOop;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chart window = new Chart();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		JFrame panel_4 = new JFrame();
		Chart chart = new Chart();
		chart.addBar(Color.blue, 10);
		
		chart.addBar(Color.red, 30);
			
		panel_4.getContentPane().add(chart);
		panel_4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel_4.pack();
		panel_4.setLocationRelativeTo(null);
		panel_4.setVisible(true);
		
	}

	/**
	 * Create the application.
	 */
	public Chart() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(243,235,242));
		frame.setBounds(100, 100, 1004, 503);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(43, 11, 170, 70);
		panel.setBackground(new Color(153, 204, 204));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(15, 16, 146, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setBounds(270, 11, 165, 70);
		panel_1.setBackground(new Color(153, 204, 204));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(15, 16, 135, 26);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		panel_2 = new JPanel();
		panel_2.setBounds(510, 11, 180, 70);
		panel_2.setBackground(new Color(153, 204,204));
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(15, 16, 146, 26);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		panel_3 = new JPanel();
		panel_3.setBounds(769, 11, 187, 70);
		panel_3.setBackground(new Color(153, 204, 204));
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(15, 16, 146, 26);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Registered Lecturers");
		lblNewLabel.setBounds(43, 89, 170, 27);
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Registerd Students");
		lblNewLabel_1.setBounds(270, 89, 156, 27);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Registered Subjects");
		lblNewLabel_2.setBounds(519, 89, 162, 27);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Registered Rooms");
		lblNewLabel_3.setBounds(769, 89, 150, 27);
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel_3);
		
		panel_4 = new JPanel();
		panel_4.setBounds(415, 190, 363, 227);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(102, 251, 69, 20);
		panel_4.add(lblNewLabel_8);
		
		panel_5 = new JPanel();
		panel_5.setBounds(43, 190, 319, 223);
		panel_5.setBackground(new Color(204, 153, 204));
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("WHAT'S NEW");
		lblNewLabel_7.setBounds(15, 16, 162, 24);
		panel_5.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		txtMssamanRathnayake = new JTextField();
		txtMssamanRathnayake.setEditable(false);
		txtMssamanRathnayake.setBounds(138, 53, 177, 26);
		panel_5.add(txtMssamanRathnayake);
		txtMssamanRathnayake.setColumns(10);
		
		txtYs = new JTextField();
		txtYs.setEditable(false);
		txtYs.setBounds(138, 95, 177, 26);
		panel_5.add(txtYs);
		txtYs.setColumns(10);
		
		txtOop = new JTextField();
		txtOop.setEditable(false);
		txtOop.setBounds(138, 157, 177, 26);
		panel_5.add(txtOop);
		txtOop.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Latest Lecturer ");
		lblNewLabel_4.setBounds(15, 56, 108, 20);
		panel_5.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("  Latest Subject");
		lblNewLabel_6.setBounds(0, 160, 108, 20);
		panel_5.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("Latest Group");
		lblNewLabel_5.setBounds(15, 113, 90, 20);
		panel_5.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Back to Home");
		btnNewButton.setBounds(824, 424, 154, 29);
		frame.getContentPane().add(btnNewButton);
		

		try {
            ResultSet rs = DB.DB.search("select count(l.name) from lecturer l where l.`status`='Active'");
            if (rs.next()) {
            	textField.setText(rs.getString(1));
            }
            ResultSet rs2 = DB.DB.search("select count(l.name) from students l");
            if (rs2.next()) {
            	textField_1.setText(rs2.getString(1));
            }
            ResultSet rs3 = DB.DB.search("select count(l.name) from subjects l where l.`status`='Active'");
            if (rs3.next()) {
            	textField_2.setText(rs3.getString(1));
            }
            ResultSet rs4 = DB.DB.search("select count(l.name) from rooms l where l.`status`='Active'");
            if (rs4.next()) {
            	textField_3.setText(rs4.getString(1));
            }
            ResultSet rs5 = DB.DB.search("select l.name from lecturer l where l.`status`='Active'");
            while (rs5.next()) {
            	txtMssamanRathnayake.setText(rs5.getString(1));
            }
            ResultSet rs6 = DB.DB.search("select groupno from student_groups l where l.`status`='Active'");
            while (rs6.next()) {
            	txtYs.setText(rs6.getString(1));
            }
            ResultSet rs7 = DB.DB.search("select l.name from subjects l where l.`status`='Active'");
            while (rs7.next()) {
            	txtOop.setText(rs7.getString(1));
            }
        } catch (Exception e) {
        }
		
	}
}
