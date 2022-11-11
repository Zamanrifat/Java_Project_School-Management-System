import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TeacherTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	
	private String[] colNames= {"Teacher Name","Id","Mail","Phone","Adress","Join Date"};
	private ArrayList<Teacher> teachers=new ArrayList<Teacher>();

	public TeacherTableModel() {
		String query = "select * from teacherinfo";
		DataAccess da = new DataAccess();
		teachers = da.getTeacher(query);
	}

	
	public int getColumnCount() {
		
		return colNames.length;
	}

	public String getColumnName(int col) {
		
		return colNames[col];
	}
	
	
	public int getRowCount() {
		
		return teachers.size();
	}

	
	public Object getValueAt(int row, int col) {
		
		if(teachers.size()==0) 
			return null;
		
		try {
			Teacher t =teachers.get(row);
			switch(col){
			case 0:
				return t.tname;
			case 1:
				return t.tid;
			case 2:
				return t.tmail;
			case 3:
				return t.tphone;
			case 4:
				return t.taddress;
			case 5:
				return t.tjoindate;
			default:
				return null;
			}
		}
		catch(Exception e){
			return null;
		}
	}
	
}