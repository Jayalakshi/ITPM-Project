package pckg;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.Button;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Manage_Not_Available_Time {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage_Not_Available_Time window = new Manage_Not_Available_Time();
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
	public Manage_Not_Available_Time() {
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
		
		JLabel lblManageSessionsAnd = new JLabel("Manage Sessions And Not Available Time Allocations");
		lblManageSessionsAnd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblManageSessionsAnd.setBounds(127, 11, 483, 22);
		frame.getContentPane().add(lblManageSessionsAnd);
		
		Button button = new Button("Back to Home");
		button.setBounds(10, 11, 86, 22);
		frame.getContentPane().add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 68, 603, 230);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID","Lecturer", "Group", "Sub Group", "Session ID", "time"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("Refresh");
		btnNewButton_2.setBounds(39, 345, 165, 34);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(253, 345, 165, 34);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int selectedrow=table.getSelectedRow();
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					DB.DB.iud("update notav_time set status='deactive' where idnotav_time='" + dtm.getValueAt(selectedrow, 0).toString() + "'");
	                JOptionPane.showMessageDialog(null, "Successfully Deleted");
	                ResultSet rs = DB.DB.search("select nt.idnotav_time,l.name,sg.groupno,sg.subgroupno,nt.sessions_id,nt.time from notav_time nt join lecturer l on nt.lecturer_idlecturer=l.idlecturer join student_groups sg on nt.groups_id=sg.idstudent_groups where nt.status!='deactive'");
	                
	                dtm.setRowCount(0);
	                while (rs.next()) {
	                    Vector v = new Vector();
	                    v.add(rs.getString(1));
	                    v.add(rs.getString(2));
	                    v.add(rs.getString(3));
	                    v.add(rs.getString(4));
	                    v.add(rs.getString(5));
	                    v.add(rs.getString(6));
	                    dtm.addRow(v);
	                }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
				
			}
		});
		btnDelete.setBounds(487, 345, 165, 34);
		frame.getContentPane().add(btnDelete);
		
		try {
            ResultSet rs = DB.DB.search("select nt.idnotav_time,l.name,sg.groupno,sg.subgroupno,nt.sessions_id,nt.time from notav_time nt join lecturer l on nt.lecturer_idlecturer=l.idlecturer join student_groups sg on nt.groups_id=sg.idstudent_groups where nt.status!='deactive'");
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                dtm.addRow(v);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}

}
