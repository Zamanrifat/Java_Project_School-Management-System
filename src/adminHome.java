import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class adminHome extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JPanel header,left,studentPanel,userPanel,teacherPanel;
	private JButton home,tentry,student,teacher,admin,logout;
	private JLabel schoolName;
	private Font bfont = new Font("Default", Font.PLAIN | Font.BOLD, 35);
	private Font lblfont = new Font("Default", Font.PLAIN, 14);

	private JButton sentry;
	static JComboBox<String> classname=new JComboBox<String>(new String[]{"One","Two","Three","Four","Five"});
	
	private static JTable tblUser,tblteacher,tblstudent;

	public adminHome() {
		super("Admin Home");
		this.setSize(800,800);
		this.setVisible(true);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.WHITE);
		
		
		//PANEL
		//HEADER/SCHOOLENAME
		header=new JPanel();
		this.header.setSize(800,100);
		this.header.setBorder(new LineBorder(Color.LIGHT_GRAY,1/2));
		add(this.header);
		header.setBackground(Color.CYAN);
		headcom();
		

		//LEFTPANEL
		left = new JPanel(null);
		this.left.setBorder(new LineBorder(Color.BLACK,1/2));
		this.left.setBounds(0,100,135,679);
		add(this.left);
		left.setBackground(Color.GREEN);
		leftcom();
		
		//STUDENTPANEL
		studentPanel = new JPanel(null);
		this.studentPanel.setBorder(new LineBorder(Color.BLACK, 1/2));
		this.studentPanel.setBounds(135, 100,660,670);
		this.add(this.studentPanel);
		studentPanel.setBackground(Color.CYAN);
		studentPanel.setVisible(false);
		studentComp();
		
		//UserPANEl
		userPanel = new JPanel(null);
		this.userPanel.setBorder(new LineBorder(Color.BLACK, 1/2));
		this.userPanel.setBounds(135, 100,660,670);
		this.add(this.userPanel);
		userPanel.setBackground(Color.ORANGE);
		userPanel.setVisible(false);
		usercom();
		
		//TeacherPanel
		teacherPanel = new JPanel(null);
		this.teacherPanel.setBorder(new LineBorder(Color.BLACK, 1/2));
		this.teacherPanel.setBounds(135, 100,660,670);
		this.add(this.teacherPanel);
		teacherPanel.setBackground(Color.ORANGE);
		teacherPanel.setVisible(false);
		teacherComp();
	}
	
	
	private void headcom() {
		schoolName = new JLabel("ABS Primary School");
        schoolName.setBounds(300,10,300,10);
		schoolName.setFont(bfont);
		//schoolName.setOpaque(true);
		header.add(schoolName);
	}
		
	private void leftcom() {
		home=new JButton("Home");
		left.add(this.home);
		home.setBounds(2,10,130,30);
		this.home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hidepanel();
		}
		});
		
		tentry=new JButton("Teacher Entry");
		left.add(this.tentry);
		tentry.setFont(lblfont);
		tentry.setBounds(2,40,130,30);
		this.tentry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			new TeacherRegistration();
		}
		});
		
		teacher=new JButton("Teacher");
		left.add(this.teacher);
		teacher.setFont(lblfont);
		teacher.setBounds(2,70,130,30);
		this.teacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hidepanel();
				teacherPanel.setVisible(true);
				tblteacher=new JTable();
				tblteacher.setBounds(0,150,660,570);
				
				JScrollPane tp = new JScrollPane();
				tp.setBounds(0, 40, 660,632);
				teacherPanel.add(tp);
				tp.setViewportView(tblteacher);
				populateTeacherTable();
		}
		});
		
		student=new JButton("Student");
		left.add(this.student);
		student.setFont(lblfont);
		student.setBounds(2,100,130,30);
		this.student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hidepanel();
				studentPanel.setVisible(true);
				
				studentPanel.setVisible(true);
				tblstudent=new JTable();
				tblstudent.setBounds(0,150,660,570);
				
				JScrollPane sp = new JScrollPane();
				sp.setBounds(0, 40, 660,632);
				studentPanel.add(sp);
				sp.setViewportView(tblstudent);
				
				populateStudentTable();
				}
		});
		
		sentry=new JButton("Student Entry");
		left.add(this.sentry);
		sentry.setFont(lblfont);
		sentry.setBounds(2,130,130,30);
		this.sentry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			new studentForm();
		}
		});
		
		
	
		admin=new JButton("Admin"); 
		left.add(this.admin);
		admin.setFont(lblfont);
		admin.setBounds(2,160,130,30);
		this.admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			hidepanel();
			userPanel.setVisible(true);
		}
		});
		
		logout=new JButton("Logout");
		this.left.add(this.logout);
		this.logout.setBounds(2,190,130,30);
		this.logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			new loginPage();
		}
		});			
	}
	
	public void studentComp() {
		JButton dlt,search;
		JTextField srchtext;
	   
		srchtext=new JTextField();
		studentPanel.add(srchtext);
		srchtext.setBounds(2,10,100,25);
		
		
		search=new JButton("Search");
		studentPanel.add(search);
		search.setBounds(120,10,80,25);
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//searchStudent(srchtext);
			}
		});
		 dlt=new JButton("Delete");
			studentPanel.add(dlt);
			dlt.setBounds(210,10,80,25); 
			dlt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					int row = tblstudent.getSelectedRow();

					if(row<0)
					{
						JOptionPane.showMessageDialog(null, "Please Select A Row First");
						return;
					}
					
					int id = (int)tblstudent.getValueAt(row, 1);
					new DataAccess().deleteStudent(id);
					populateStudentTable();
			}
			});	
	}
	
	
	public void teacherComp() {
		JButton dlt;
	    dlt=new JButton("Delete");
		teacherPanel.add(dlt);
		dlt.setBounds(150,2,70,30); 
		dlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int row = tblteacher.getSelectedRow();

				if(row<0)
				{
					JOptionPane.showMessageDialog(null, "Please Select A Row First");
					return;
				}
				int id = (int)tblteacher.getValueAt(row, 1);
				new DataAccess().deleteTeacher(id);
				populateTeacherTable();
		}
		});	
	}
	

	
	private void usercom() {
		tblUser = new JTable();
		tblUser.setBackground(Color.white);
		
		JScrollPane sp = new JScrollPane();
		sp.setBounds(0, 0, 660,670);
		userPanel.add(sp);
		sp.setViewportView(tblUser);
		
		populateTable();
	}
	public static void populateTable() {
		UserTableModel m=new UserTableModel();
		tblUser.setModel(m);
	}

	public void populateTeacherTable() {
		
		TeacherTableModel m=new TeacherTableModel();
		tblteacher.setModel(m);
		
	}	
	
	private void populateStudentTable() {
		studentTableModel m=new studentTableModel();
		tblstudent.setModel(m);
	}

	private void hidepanel() {
		userPanel.setVisible(false);
		studentPanel.setVisible(false);
		teacherPanel.setVisible(false);	
	}
}
