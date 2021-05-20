package pckg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

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
	

	public static void BHPS() {
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
	
	public static void BHAR() {
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
	
	public static void BHAR1() {
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
	public static void BHWDH() {
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
	public static void BHC() {
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
	public static void BHMNAR() {
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
	
	public static void BHMNAT() {
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
	
	public static void BHMR() {
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
	public static void BHMR2() {
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
	public static void BHML() {
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
	public static void BHML3() {
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
	
	public static void BHNAR() {
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
	
	public static void BHSANA() {
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
	
	public static void BHW() {
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
	
	public static void BHMLH() {
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
	
	public static void BHSUB() {
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
	public static void BHMS() {
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
	public static void BHT() {
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
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setBackground(new Color(243, 235, 242));
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Add Working Days");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Add_Working_Days_Hours hwd = new Add_Working_Days_Hours();
					hwd.HWD();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		btnNewButton.setBounds(534, 175, 189, 48);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add Not Available Time");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Sessions_And_Not_Available_Time_Allocations hsn = new Sessions_And_Not_Available_Time_Allocations();
					hsn.HSN();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_1.setBounds(534, 234, 189, 48);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add Preffered Sessions");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Add_Preffered_Sessions haps = new Add_Preffered_Sessions();
					haps.HAPS();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_2.setBounds(534, 351, 189, 48);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Add Not Available Rooms");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Not_Available_Rooms hnmr = new Not_Available_Rooms();
					hnmr.HNMR();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_3.setBounds(534, 293, 189, 44);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Edit Working Days");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Working_Days_Hours_update_delete hwdhud = new Working_Days_Hours_update_delete();
					hwdhud.HWDHUD();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_4.setBounds(759, 117, 194, 47);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Manage Locations");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ManageLocations hml = new ManageLocations();
					hml.HML();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_5.setBounds(759, 176, 194, 47);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Dashbord ");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Chart hc = new Chart();
					hc.HC();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_6.setBounds(759, 235, 194, 47);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Allocate Rooms");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Manage_Rooms hmr = new Manage_Rooms();
					hmr.HMR();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_7.setBounds(759, 292, 194, 47);
		frame.getContentPane().add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Add Lecture");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Add_Lecturer hml = new Add_Lecturer();
					hml.HML();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_8.setBounds(290, 292, 189, 48);
		frame.getContentPane().add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Add Subject");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Add_Subject hasub = new Add_Subject();
					hasub.HASUB();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		
		
		
		btnNewButton_9.setBounds(290, 351, 189, 48);
		frame.getContentPane().add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("Add Sessions");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Add_Session has1 = new Add_Session();
					has1.HAS4();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_10.setBounds(534, 116, 189, 48);
		frame.getContentPane().add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("AddStudentGroups");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudentGroups	 addStu = new AddStudentGroups();
				addStu.addStu();
				frame.setVisible(false);
			}
		});
		btnNewButton_11.setBounds(51, 116, 186, 48);
		frame.getContentPane().add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("Manage Student Group");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageStudentGroups ManStu = new ManageStudentGroups();
				ManStu.ManStu();
				frame.setVisible(false);
			}
		});
		btnNewButton_12.setBounds(51, 175, 186, 48);
		frame.getContentPane().add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("Add Tags");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTag atag = new AddTag();
				atag.atag();
				frame.setVisible(false);
			}
		});
		btnNewButton_13.setBounds(51, 234, 186, 48);
		frame.getContentPane().add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("Manage Tags");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageTags ManTags = new ManageTags();
				ManTags.ManTags();
				frame.setVisible(false);
			}
		});
		btnNewButton_14.setBounds(51, 294, 186, 44);
		frame.getContentPane().add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("Sessions");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SessionsNNotAvbTime hsnnat = new SessionsNNotAvbTime();
				hsnnat.hsnnat();
				frame.setVisible(false);
				
			}
		});
		btnNewButton_15.setBounds(48, 350, 189, 48);
		frame.getContentPane().add(btnNewButton_15);
		
		JButton btnNewButton_16 = new JButton("Update Concecative");
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UpdateConsecutive updateCon = new UpdateConsecutive();
				updateCon.updateCon();
				frame.setVisible(false);
			}
		});
		btnNewButton_16.setBounds(290, 116, 189, 48);
		frame.getContentPane().add(btnNewButton_16);
		
		JButton btnNewButton_17 = new JButton("Update Not Overlaping");
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateNonOver nonOver = new UpdateNonOver();
				nonOver.nonOver();
				frame.setVisible(false);
			}
		});
		btnNewButton_17.setBounds(290, 175, 189, 48);
		frame.getContentPane().add(btnNewButton_17);
		
		JButton btnNewButton_18 = new JButton("Update Parallel");
		btnNewButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdatePar updatePar = new UpdatePar();
				updatePar.updatePar();
				frame.setVisible(false);
			}
		});
		btnNewButton_18.setBounds(290, 234, 189, 48);
		frame.getContentPane().add(btnNewButton_18);
		
		JLabel lblNewLabel = new JLabel("HOME PAGE");
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 25));
		lblNewLabel.setBounds(447, 11, 276, 64);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_19 = new JButton("Time Table");
		btnNewButton_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					GenerateTimeTable htime = new GenerateTimeTable();
					htime.HTIME();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_19.setBounds(759, 352, 194, 47);
		frame.getContentPane().add(btnNewButton_19);
		frame.setBounds(100, 100, 1002, 503);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
