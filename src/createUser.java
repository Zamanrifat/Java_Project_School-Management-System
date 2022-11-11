import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class createUser extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JLabel schoolName,namelbl,passlbl,positionlbl,phonelbl;
	private JTextField userName,phone;
	private JPasswordField pass;
	private String position;
	private JButton create,reset,back;
	private JRadioButton admin,user; 
	private static boolean addusr;
	Font schoolFont;

	public createUser(){
		super("Creating New User");
		this.setSize(700,600);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		schoolFont = new Font("Black", Font.PLAIN | Font.BOLD, 35);
		components();
		
	}
	
	public void components() {
		//TITLE
		schoolName = new JLabel("ABS Primary School");
        schoolName.setBounds(215,10,350,50);
		schoolName.setFont(schoolFont);
		schoolName.setOpaque(true);
		add(schoolName);

		//USERNAME
		this.namelbl=new JLabel("User Name :");
		this.add(this.namelbl);
		namelbl.setBounds(230,150,70,30);
		
		userName=new JTextField();
		this.add(this.userName);
		userName.setBounds(340,150,140,30);
		
		
		//PASSWORD
		passlbl=new JLabel("Password :");
		this.add(this.passlbl);
		passlbl.setBounds(230,190,70,30);
		
		pass=new JPasswordField();
		this.add(this.pass);
		pass.setBounds(340,190,140,30);
			
		//POSITION
		positionlbl=new JLabel("Position :");
		this.add(this.positionlbl);
		positionlbl.setBounds(230,230,70,30);
		
		admin=new JRadioButton("Admin");
		add(this.admin);
		this.admin.setBounds(340,230,70,30);
		this.admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				user.setSelected(false);
				position="Admin";
			}
		});
		 
		user=new JRadioButton("User");
		add(this.user);
		this.user.setBounds(410,230,70,30);
		this.user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				admin.setSelected(false);
				position="user";
			}
		});
		
		
		//PHONE
		phonelbl=new JLabel("Phone No :");
		this.add(this.phonelbl);
		phonelbl.setBounds(230,270,70,30);
		
		phone=new JTextField();
		this.add(this.phone);
		this.phone.setBounds(340,270,140,30);
		
		
		//CREATE_BUTTON
		create=new JButton("Create");
		this.add(this.create);
		create.setBounds(230,330,73,30);
		this.create.addActionListener(new ActionListener() {	
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(userName.getText().contentEquals("")||pass.getText().contentEquals("")||phone.getText().contentEquals("")){
					JOptionPane.showMessageDialog(null,"First Fill up all the field");
				}
				
				else {
						String sql = "INSERT INTO admininfo VALUES ('"+userName.getText()+"','"+pass.getText()+"','"+position+"','"+phone.getText()+"')";
						DataAccess da=new DataAccess();
						addusr=da.addUser(sql);
						if(addusr) {
						clearField();
						JOptionPane.showMessageDialog(null, "User Created Successfully.");
						}
						else
							JOptionPane.showMessageDialog(null, "Username Already taken.try another One.");
				}	
			}
		});
		
		
		//RESET_BUTTON
		reset=new JButton("Reset");
		this.add(this.reset);
		reset.setBounds(317,330,73,30);
		this.reset.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if(userName.getText().contentEquals("")&&pass.getText().contentEquals("")&&phone.getText().contentEquals("")){
				}
				else 
					clearField();
					admin.setSelected(false);
					user.setSelected(false);
				}
			}
		);
		
		
		//BACK_BUTTON
		back=new JButton("Back");
		this.add(this.back);
		back.setBounds(405,330,73,30);
		this.back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new loginPage();
			}
		});
	}
	
	public void clearField() {
		userName.setText("");
		pass.setText("");
		phone.setText("");
		admin.setSelected(false);
		user.setSelected(false);
	}
}
