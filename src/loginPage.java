import java.awt.event.*;
import javax.swing.*;


public class loginPage extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JLabel userId,password; 
	private JTextField name;
	private JPasswordField pass;
	private JButton login,clear,createNewAccount; 
	private DataAccess dataaccess;

	public loginPage() {
		//LOGIN_WINDOW
		this.setTitle("LOGIN FRAME");
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		this.initComponents();
		this.dataaccess=new DataAccess();
	}
	
	private void initComponents() {
		//NAME
		this.userId=new JLabel("User ID: ");
		this.add(userId);
		this.userId.setBounds(165, 75, 150, 30);
		
		this.name=new JTextField("msr@nayeem");
		this.add(name);
		this.name.setBounds(215,75,180,30);
		
		//PASSWORD 
		this.password=new JLabel("Password  : ");
		this.add(password);
		this.password.setBounds(142,115,100,30);
		
		this.pass=new JPasswordField("msr@nayeem");
		this.add(pass);
		this.pass.setBounds(215,115,180,30);
	
		//BUTTON
		
		this.login=new JButton("Login");
		this.add(login);
		this.login.setBounds(220,162,75,30);
		this.login.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("deprecation")
				boolean lgn=dataaccess.loginCheck(name.getText(),pass.getText());
				if(lgn) {
					setVisible(false);
					adminHome home=new adminHome();
					home.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"Enter Correct user id or password first");
				}
			}
		});
		
		this.clear=new JButton("Clear");
		this.add(clear);
		this.clear.setBounds(315,162,75,30);
		this.clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				name.setText("");
				pass.setText("");
			}
		});
		
		//CREATE_NEW_ACCOUNT
		this.createNewAccount=new JButton("Create New Account");
		this.add(createNewAccount);
		this.createNewAccount.setBounds(230,208,150,30);
		this.createNewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new createUser();
			}
		});
		}
	
}