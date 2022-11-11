import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class studentForm extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JTextField name,id,fname,mname,rel,fConNo,mConNo,nationality;
	private DataAccess da;
	private String gender;
	private JTextArea address;
	

	private JLabel schoolName,formName,nameLbl,idlbl, fnamelbl, mnamelbl,relLbl; 
	private JLabel addressLbl,fathersConLbl,mothersConLbl,nationLbl,genderLbl,classNameLbl;
		
    private JButton entryBtn, clearBtn,back;
    private JRadioButton male,female;   
 
    private JPanel panel;
	private Font schoolFont,fieldFont;
	
	public studentForm(){
		
		super("Student Registration");
		this.setSize(800, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		schoolFont = new Font("Black", Font.PLAIN | Font.BOLD, 35);
		fieldFont = new Font("Black", Font.PLAIN, 12);
		panel = new JPanel();
		this.panel.setLayout(null);
		this.setVisible(true);
		
		this.components();
	}		
		public void components() {
			
			schoolName = new JLabel("ABS Primary School");
	        schoolName.setBounds(215,10,350,50);
			schoolName.setFont(schoolFont);
			schoolName.setOpaque(true);
			panel.add(schoolName);
			
			formName = new JLabel("Student Registration Form");
			this.formName.setBounds(300,100,400,50);
			panel.add(this.formName);
			
			nameLbl = new JLabel("Name :");
			this.nameLbl.setBounds(60,180,130,30);
			panel.add(this.nameLbl);
			
			name = new JTextField();
			this.name.setBounds(160,180, 180, 30);
			this.name.setFont(this.fieldFont);
			panel.add(this.name);
			
			genderLbl = new JLabel("Gender :");
			this.genderLbl.setBounds(440,180,130,30);
			panel.add(this.genderLbl);
		
			male=new JRadioButton("Male");
			panel.add(this.male);
			this.male.setBounds(530,180,70,30);
			this.male.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					female.setSelected(false);
					gender="Male";
				}
			});
			 
			female=new JRadioButton("Female");
			panel.add(this.female);
			this.female.setBounds(610,180,70,30);
			this.female.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					male.setSelected(false);
					gender="Female";
				}
			});
			
			idlbl = new JLabel("Student ID :");
			this.idlbl.setBounds(60,235,130,30);
			panel.add(this.idlbl);
			
			id = new JTextField();
			this.id.setBounds(160,235, 180, 30);
			id.setFont(this.fieldFont);
			panel.add(this.id);
			
			//CLASS
			classNameLbl = new JLabel("Class :");
			this.classNameLbl.setBounds(440,235,130,30);
			panel.add(this.classNameLbl);
			
			
			/*className = new JTextField();
			this.className.setBounds(530,235, 180, 30);
			this.className.setFont(this.fieldFont);
			panel.add(this.className);
*/			
			String classList[]={"One","Two","Three","Four","Five"};        
		    @SuppressWarnings({ "rawtypes", "unchecked" })
			final JComboBox classname=new JComboBox(classList);    
		    classname.setBounds(530, 235,130,30); 
		    panel.add(classname);
			
			//FOTHER'S INFO
			fnamelbl = new JLabel("Father's Name :");
			this.fnamelbl.setBounds(60,290,130,30);
			panel.add(this.fnamelbl);
			
			fname = new JTextField();
			this.fname.setBounds(160,290, 180, 30);
			this.fname.setFont(this.fieldFont);
			panel.add(this.fname);
			
		    fathersConLbl = new JLabel("Fother's  No :");
		    this.fathersConLbl.setBounds(440,290,130,30);
			panel.add(this.fathersConLbl);
			
		    fConNo = new JTextField();
		    this.fConNo.setBounds(530,290, 180, 30);
			this.fConNo.setFont(this.fieldFont);
			panel.add(this.fConNo);
			
			//MOTHER'S INFO
			mnamelbl = new JLabel("Mother's Name :");
			this.mnamelbl.setBounds(60,345,130,30);
			panel.add(this.mnamelbl);
			
			mname = new JTextField();
			this.mname.setBounds(160,345, 180, 30);
			this.mname.setFont(this.fieldFont);
			panel.add(this.mname);
			
			mothersConLbl= new JLabel("Mother's no :");
			this.mothersConLbl.setBounds(440,345,130,30);
			panel.add(this.mothersConLbl);
			
			mConNo = new JTextField();
			this.mConNo.setBounds(530,345, 180, 30);
			this.mConNo.setFont(this.fieldFont);
			panel.add(this.mConNo);
			
			//RELIGION
		    relLbl = new JLabel("Religion :");
		    this.relLbl.setBounds(60,400,130,30);
			panel.add(this.relLbl);
			
			rel = new JTextField();
			this.rel.setBounds(160,400, 180, 30);
			this.rel.setFont(this.fieldFont);
			panel.add(this.rel);
			
			//NATIONALITY
			nationLbl = new JLabel("Nationality :");
			this.nationLbl.setBounds(440,400,130,30);
			panel.add(this.nationLbl);
			
			nationality = new JTextField();
			this.nationality.setBounds(530,400, 180, 30);
			this.nationality.setFont(this.fieldFont);
			panel.add(this.nationality);
			
			//ADDRESS
			addressLbl = new JLabel("Adress :");
			this.addressLbl.setBounds(60,455,130,30);
			panel.add(this.addressLbl);
			
			address = new JTextArea();
			this.address.setBounds(160,455, 180,35);
			this.address.setFont(this.fieldFont);
			panel.add(this.address);
			
			//BUTTONS
			entryBtn = new JButton("Entry");
			this.entryBtn.setBounds(280,570,70,30);
			panel.add(this.entryBtn);
			this.entryBtn.addActionListener(new ActionListener() {	
				
				public void actionPerformed(ActionEvent arg0) {
					
					
					if(name.getText().contentEquals("")||id.getText().contentEquals("")||nationality.getText().contentEquals("")||fname.getText().contentEquals("")
							||fConNo.getText().contentEquals("")||mname.getText().contentEquals("")||mConNo.getText().contentEquals("")||rel.getText().contentEquals("")
							||address.getText().contentEquals("")){
						JOptionPane.showMessageDialog(null,"First Fill up all the field");
					}
					
					else { 
							 String sql = "INSERT INTO student VALUES ('"+name.getText()+"','"+id.getText()+"','"+classname.getItemAt(classname.getSelectedIndex())+"','"+gender+"','"+nationality.getText()+"',"
							 + "'"+fname.getText()+"','"+fConNo.getText()+"','"+mname.getText()+"','"+mConNo.getText()+"','"+rel.getText()+"','"+address.getText()+"')";
							da=new DataAccess();
							boolean studentadd=da.addStudent(sql);
								if(studentadd==true) {
									clearField();
									JOptionPane.showMessageDialog(null, "Student information added Successfully.");
								}
								else
									JOptionPane.showMessageDialog(null, "Try again");
					    }	
				}
			});
			
			clearBtn = new JButton("Clear");
			this.clearBtn.setBounds(360,570,70,30);
			this.panel.add(this.clearBtn);
			this.clearBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(id.getText().contentEquals("")&&name.getText().contentEquals("")&&fname.getText().contentEquals("")&&mname.getText().contentEquals("")
							&&address.getText().contentEquals("")&&rel.getText().contentEquals("")&&fConNo.getText().contentEquals("")&&mConNo.getText().contentEquals("")
							&&nationality.getText().contentEquals("")){
						female.setSelected(false);
						male.setSelected(false);
					}
					else
						clearField();
				}
			});
			
			back = new JButton("Back");
			this.back.setBounds(440,570,70,30);
			panel.add(this.back);
			this.back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					new adminHome();
					
				}
			});
			
			this.add(panel);
		}
		public void clearField() {
			id.setText("");
			name.setText("");
			fname.setText("");
			mname.setText("");
			address.setText("");
			rel.setText("");
			fConNo.setText("");
			mConNo.setText("");
			nationality.setText("");
			female.setSelected(false);
			male.setSelected(false);
			
		}
}
		
		