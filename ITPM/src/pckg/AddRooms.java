package pckg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddRooms {

	private JFrame frame;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRooms window = new AddRooms();
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
	public AddRooms() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(243, 235, 242));
		frame.getContentPane().setBackground(new Color(243, 235, 242));
		frame.setBounds(100, 100, 1028, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manage Locations");
		lblNewLabel.setFont(new Font("Yu Gothic Light", Font.BOLD, 25));
		lblNewLabel.setBounds(337, 11, 322, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 63, 978, 381);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(243, 235, 242));
		tabbedPane.addTab("Sessions", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 16, 973, 234);
		panel.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane.setViewportView(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"SID", "Lecturer 1", "Lecturer 2", "Subject Code", "Subject Name", "Group ID", "Tag", "Room"
			}
		));
		scrollPane_1.setViewportView(table);
		
		JButton btnNewButton = new JButton("Add Room");
		btnNewButton.setBounds(484, 287, 132, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.setBounds(337, 287, 132, 29);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back to Home");
		btnNewButton_2.setBounds(631, 287, 132, 29);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_6 = new JButton("Delete");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int selectedrow=table.getSelectedRow();
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					DB.DB.iud("update sessions set status='deactive' where idconsecutive='" + dtm.getValueAt(selectedrow, 0).toString() + "'");
	                JOptionPane.showMessageDialog(null, "Successfully Deleted");
	                dtm.setRowCount(0);
		            ResultSet rs = DB.DB.search("select ls.idconsecutive,l1.name,l2.name,s.code,s.name,sg.idstudent_groups,t.name,ro.name from sessions ls JOIN lecturer l1 on ls.lecturer1=l1.idlecturer JOIN lecturer l2 on ls.lecturer2=l2.idlecturer JOIN subjects s on ls.subject=s.idsubjects JOIN tags t on ls.tag=t.idtags JOIN student_groups sg on ls.group_id=sg.idstudent_groups JOIN rooms ro on ls.rooms_id=ro.idsession_rooms where ls.status!='deactive'");
		            while (rs.next()) {
		                Vector v = new Vector();
		                v.add(rs.getString(1));
		                v.add(rs.getString(2));
		                v.add(rs.getString(3));
		                v.add(rs.getString(4));
		                v.add(rs.getString(5));
		                v.add(rs.getString(6));
		                v.add(rs.getString(7));
		                v.add(rs.getString(8));
		                dtm.addRow(v);
		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
			}
		});
		btnNewButton_6.setBounds(207, 287, 115, 29);
		panel.add(btnNewButton_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(243, 235, 242));
		tabbedPane.addTab("Consecutive Session", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(976, 180, -973, -182);
		panel_1.add(scrollPane_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 49, 973, 209);
		panel_1.add(scrollPane_3);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"CSID", "Lecturer1", "Lecturer 2", "Subject Code", "Subject Name", "Group ID", "Tag", "Room"
			}
		));
		scrollPane_3.setViewportView(table_1);
		
		JButton btnNewButton_3 = new JButton("Add Room");
		btnNewButton_3.setBounds(431, 284, 144, 29);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Refresh ");
		btnNewButton_4.setBounds(590, 284, 144, 29);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Back to Hoom");
		btnNewButton_5.setBounds(749, 284, 143, 29);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_7 = new JButton("Delete");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int selectedrow=table_1.getSelectedRow();
					DefaultTableModel dtm = (DefaultTableModel) table_1.getModel();
					DB.DB.iud("update consecutive set status='deactive' where idconsecutive='" + dtm.getValueAt(selectedrow, 0).toString() + "'");
	                JOptionPane.showMessageDialog(null, "Successfully Deleted");
	                dtm.setRowCount(0);
		            ResultSet rs = DB.DB.search("select ls.idconsecutive,l1.name,l2.name,s.code,s.name,sg.idstudent_groups,t.name,ro.name from consecutive ls JOIN lecturer l1 on ls.lecturer1=l1.idlecturer JOIN lecturer l2 on ls.lecturer2=l2.idlecturer JOIN subjects s on ls.subject=s.idsubjects JOIN tags t on ls.tag=t.idtags JOIN student_groups sg on ls.group_id=sg.idstudent_groups JOIN rooms ro on ls.rooms_id=ro.idsession_rooms where ls.status!='deactive'");
		            while (rs.next()) {
		                Vector v = new Vector();
		                v.add(rs.getString(1));
		                v.add(rs.getString(2));
		                v.add(rs.getString(3));
		                v.add(rs.getString(4));
		                v.add(rs.getString(5));
		                v.add(rs.getString(6));
		                v.add(rs.getString(7));
		                v.add(rs.getString(8));
		                dtm.addRow(v);
		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
			}
		});
		btnNewButton_7.setBounds(301, 284, 115, 29);
		panel_1.add(btnNewButton_7);
		
		try {
            DefaultTableModel dtm = (DefaultTableModel) table_1.getModel();
            dtm.setRowCount(0);
            ResultSet rs = DB.DB.search("select ls.idconsecutive,l1.name,l2.name,s.code,s.name,sg.idstudent_groups,t.name,ro.name from consecutive ls JOIN lecturer l1 on ls.lecturer1=l1.idlecturer JOIN lecturer l2 on ls.lecturer2=l2.idlecturer JOIN subjects s on ls.subject=s.idsubjects JOIN tags t on ls.tag=t.idtags JOIN student_groups sg on ls.group_id=sg.idstudent_groups JOIN rooms ro on ls.rooms_id=ro.idsession_rooms where ls.status!='deactive'");
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                v.add(rs.getString(8));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		try {
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            ResultSet rs = DB.DB.search("select ls.idconsecutive,l1.name,l2.name,s.code,s.name,sg.idstudent_groups,t.name,ro.name from sessions ls JOIN lecturer l1 on ls.lecturer1=l1.idlecturer JOIN lecturer l2 on ls.lecturer2=l2.idlecturer JOIN subjects s on ls.subject=s.idsubjects JOIN tags t on ls.tag=t.idtags JOIN student_groups sg on ls.group_id=sg.idstudent_groups JOIN rooms ro on ls.rooms_id=ro.idsession_rooms where ls.status!='deactive'");
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                v.add(rs.getString(8));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Not Available Time", null, panel_2, null);
	}
}
