import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class studentTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	
	private String[] colNames= {"Name","id","class","Fother's Name","Fother's No","Mother's Name","Mother's No","Address"};
	private ArrayList<Student> students=new ArrayList<Student>();

	public studentTableModel() {
		String query = "select * from student";
		DataAccess da = new DataAccess();
		students= da.getStudent(query);
	}

	
	public int getColumnCount() {
		
		return colNames.length;
	}

	public String getColumnName(int col) {
		
		return colNames[col];
	}
	
	
	public int getRowCount() {
		
		return students.size();
	}

	
	public Object getValueAt(int row, int col) {
		
		if(students.size()==0) 
			return null;
		
		try {
			Student s=students.get(row);
			switch(col){
			
			case 0:
				return s.name;
			case 1:
				return s.id;
			case 2:
				return s.classname;
			case 3:
				return s.fname;
			case 4:
				return s.fno;
			case 5:
				return s.mname;
			case 6:
				return s.mno;
			case 7:
				return s.address;
			default:
				return null;
			}
		}
		catch(Exception e){
			return null;
		}
	}
	
}