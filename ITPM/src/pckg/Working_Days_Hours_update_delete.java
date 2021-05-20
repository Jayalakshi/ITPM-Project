import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import java.awt.Button;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Working_Days_Hours_update_delete {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Working_Days_Hours_update_delete window = new Working_Days_Hours_update_delete();
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
	public Working_Days_Hours_update_delete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(243,235,242));
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 56, 618, 240);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Days count", "Days", "Time per day", "Time slot"
			}
		));
		scrollPane.setViewportView(table);
		table.setBorder(UIManager.getBorder("CheckBox.border"));
		
		JLabel lblUpdateDelete = new JLabel("Update & Delete Working Days & Hours");
		lblUpdateDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUpdateDelete.setBounds(163, 11, 374, 31);
		frame.getContentPane().add(lblUpdateDelete);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int selectedrow=table.getSelectedRow();
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					DB.DB.iud("update working_hours set count_day='"+dtm.getValueAt(selectedrow, 1)+"', days='"+dtm.getValueAt(selectedrow, 2)+"', d_time='"+dtm.getValueAt(selectedrow, 3)+"', slot='"+dtm.getValueAt(selectedrow, 4)+"' where idworking_hours='" + dtm.getValueAt(selectedrow, 0).toString() + "'");
	                JOptionPane.showMessageDialog(null, "Successfully Updated");
	                
	                ResultSet rs = DB.DB.search("select * from working_hours where status!='deactive'");
	                dtm.setRowCount(0);
	                while (rs.next()) {
	                    Vector v = new Vector();
	                    v.add(rs.getString(1));
	                    v.add(rs.getString(2));
	                    v.add(rs.getString(3));
	                    v.add(rs.getString(4));
	                    v.add(rs.getString(5));
	                    dtm.addRow(v);
	                }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
			}
		});
		btnNewButton.setBounds(486, 353, 165, 34);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int selectedrow=table.getSelectedRow();
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					DB.DB.iud("update working_hours set status='deactive' where idworking_hours='" + dtm.getValueAt(selectedrow, 0).toString() + "'");
	                JOptionPane.showMessageDialog(null, "Successfully Deleted");
	                
	                ResultSet rs = DB.DB.search("select * from working_hours where status!='deactive'");
	                dtm.setRowCount(0);
	                while (rs.next()) {
	                    Vector v = new Vector();
	                    v.add(rs.getString(1));
	                    v.add(rs.getString(2));
	                    v.add(rs.getString(3));
	                    v.add(rs.getString(4));
	                    v.add(rs.getString(5));
	                    dtm.addRow(v);
	                }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
			}
		});
		btnNewButton_1.setBounds(252, 353, 165, 34);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.setBounds(38, 353, 165, 34);
		frame.getContentPane().add(btnNewButton_2);
		
		try {
            ResultSet rs = DB.DB.search("select * from working_hours where status!='deactive'");
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
		Button button = new Button("Back to Home");
		button.setBounds(10, 10, 80, 22);
		frame.getContentPane().add(button);
		frame.setBounds(100, 100, 700, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
