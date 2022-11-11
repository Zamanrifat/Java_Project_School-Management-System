import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;


public class UserTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	
	private String[] colNames= {"User Name","Type","Phone"};
	private ArrayList<User> users=new ArrayList<User>();

	public UserTableModel() {
		String query = "select * from admininfo";
		DataAccess da = new DataAccess();
		users = da.getUsers(query);
	}

	
	public int getColumnCount() {
		
		return colNames.length;
	}

	public String getColumnName(int col) {
		
		return colNames[col];
	}
	
	
	public int getRowCount() {
		
		return users.size();
	}

	
	public Object getValueAt(int row, int col) {
		
		if(users.size()==0) 
			return null;
		
		try {
			User u=users.get(row);
			switch(col){
			case 0:
				return u.username;
			case 1:
				return u.position;
			case 2:
				return u.phone;
			default:
				return null;
			}
		}
		catch(Exception e){
			return null;
		}
	}
	
}