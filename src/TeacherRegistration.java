import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TeacherRegistration extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTextField nameTF,phoneTF,mailTF,joinTF, addressTF,idTF;
		
	JLabel schoolLbl, formLbl, nameLbl,phoneLbl,mailLbl,joinlbl,adressLbl,idlbl;
		
    JButton entryBtn, clearBtn,backBtn;
		 
    JPanel panel;
	Color myColor;
	Font myFont,myButtonFont;
	DataAccess da;
	
	public TeacherRegistration(){
		
		super("Teacher Registration");
		this.setSize(660, 670);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		myFont = new Font("Black", Font.ITALIC | Font.BOLD, 20);
		myButtonFont = new Font("Black", Font.ITALIC, 25);
		panel = new JPanel();
		this.add(panel);
		panel.setLayout(null);
		
		   
	 
  
		schoolLbl = new JLabel("ABS Primary School");
        schoolLbl.setBounds(230,20,600,50);
		schoolLbl.setFont(myFont);
		schoolLbl.setOpaque(true);
		panel.add(schoolLbl);
		
		formLbl = new JLabel("Teacher Registration Form");
		formLbl.setBounds(250,80,400,50);
		panel.add(formLbl);
		
		nameLbl = new JLabel("Name :");
		nameLbl.setBounds(40,180,130,30);
		panel.add(nameLbl);
		
		nameTF = new JTextField();
		nameTF.setBounds(110,180, 180, 30);
		panel.add(nameTF);
		
		
		
		phoneLbl = new JLabel("Phone :");
		phoneLbl.setBounds(330,180,130,30);
		panel.add(phoneLbl);
		
		phoneTF = new JTextField();
		phoneTF.setBounds(390,180, 180, 30);
		panel.add(phoneTF);
		
		mailLbl = new JLabel("Mail :");
		mailLbl.setBounds(40,235,130,30);
		panel.add(mailLbl);
		
		mailTF = new JTextField();
		mailTF.setBounds(110,235, 180, 30);
		panel.add(mailTF);
		
		
		adressLbl = new JLabel("Adress :");
		adressLbl.setBounds(330,235,130,30);
		panel.add(adressLbl);
		
		addressTF = new JTextField();
		addressTF.setBounds(390,235, 180, 30);
		panel.add(addressTF);
		
		
	    joinlbl = new JLabel("Join Date:");
		joinlbl.setBounds(40,290,130,30);
		panel.add(joinlbl);
		
	    joinTF = new JTextField();
		joinTF.setBounds(110,290, 180, 30);
		panel.add(joinTF);
		
		idlbl = new JLabel("ID:");
		idlbl.setBounds(330,290,130,30);
		panel.add(idlbl);
		
	    idTF = new JTextField();
	    idTF.setBounds(390,290, 180, 30);
		panel.add(idTF);
		
		
		entryBtn = new JButton("Entry");
		entryBtn.setBounds(180,350,70,30);
		panel.add(entryBtn);
		this.entryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(nameTF.getText().contentEquals("")||phoneTF.getText().contentEquals("")||mailTF.getText().contentEquals("")||joinTF.getText().contentEquals("")
						||addressTF.getText().contentEquals("")||idTF.getText().contentEquals("")){
					JOptionPane.showMessageDialog(null, "Fill All The Field");
				}
				else {
					
					String sql = "INSERT INTO teacherinfo VALUES ('"+nameTF.getText()+"','"+idTF.getText()+"','"+mailTF.getText()+"','"+phoneTF.getText()+"','"+addressTF.getText()+"','"+joinTF.getText()+"')";
							da=new DataAccess();
							boolean teacheradd=da.addTeacher(sql);
								if(teacheradd==true) {
									clearField();
									JOptionPane.showMessageDialog(null, "Teacher information added Successfully.");
								}
								else
									JOptionPane.showMessageDialog(null, "Try again");
				}
					
		}
		});
		
		clearBtn = new JButton("Clear");
		clearBtn.setBounds(270,350,70,30);
		panel.add(clearBtn);
		this.clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(nameTF.getText().contentEquals("")&&phoneTF.getText().contentEquals("")&&mailTF.getText().contentEquals("")&&joinTF.getText().contentEquals("")
						&&addressTF.getText().contentEquals("")&&idTF.getText().contentEquals("")){
					JOptionPane.showMessageDialog(null, "Already Empty");
				}
				else
					clearField();
		}
		});
		
		backBtn = new JButton("Back");
		backBtn.setBounds(360,350,70,30);
		panel.add(backBtn);
		this.backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				adminHome m=new adminHome();
				m.setVisible(true);
		}
		});
		
	}
	private void clearField(){
		nameTF.setText("");
		phoneTF.setText("");
		mailTF.setText("");
		joinTF.setText("");
		addressTF.setText("");
		idTF.setText("");
	}
}
		
		