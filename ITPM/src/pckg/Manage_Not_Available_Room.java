package pckg;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Button;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Manage_Not_Available_Room {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage_Not_Available_Room window = new Manage_Not_Available_Room();
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
	public Manage_Not_Available_Room() {
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
		
		Button button = new Button("Back to Home");
		button.setBounds(10, 11, 80, 22);
		frame.getContentPane().add(button);
		
		JLabel lblNotAvailableRoom = new JLabel("Manage Not Available Rooms");
		lblNotAvailableRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNotAvailableRoom.setBounds(222, 11, 271, 22);
		frame.getContentPane().add(lblNotAvailableRoom);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 68, 603, 230);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Building", "Room name", "Room Type", "Time"
			}
		));
		scrollPane.setViewportView(table);
		table.setBorder(UIManager.getBorder("CheckBox.border"));
		
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
					DB.DB.iud("update rooms set status='deactive' where idsession_rooms='" + dtm.getValueAt(selectedrow, 0).toString() + "'");
	                JOptionPane.showMessageDialog(null, "Successfully Deleted");
	                
	                ResultSet rs = DB.DB.search("select r.idsession_rooms,b.name,r.name,r.`type`,r.time from rooms r join building b on r.building=b.idbuilding where r.status!='deactive'");
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
		btnDelete.setBounds(487, 345, 165, 34);
		frame.getContentPane().add(btnDelete);
		
		try {
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            ResultSet rs = DB.DB.search("select r.idsession_rooms,b.name,r.name,r.`type`,r.time from rooms r join building b on r.building=b.idbuilding where r.status!='deactive'");
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

}
