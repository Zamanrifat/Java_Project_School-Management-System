import java.sql.*;
import java.util.ArrayList;

public class DataAccess{
	Connection con;
	Statement st;
	ResultSet res;
	String url,check;
	public DataAccess() {
		try{
			 url="jdbc:mysql://localhost:3306/schoolmanagement?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			 con=(Connection) DriverManager.getConnection(url,"root","");
	         st=con.createStatement();
		}
		catch(Exception r){
			System.out.println(r);
		}	
	
}		
	
	
	public boolean addUser(String sql){
			try{
				st.execute(sql);
				return true;
			} 
			
			catch(SQLException e){
				e.printStackTrace();
				//return false;
			}
			return true;
		}
	
	public boolean addStudent(String sql) {
		try {
			st.execute(sql);
			return true;
		}
		
		catch(SQLException e) {
			e.printStackTrace();
			//return false;
		}
		return true;
	}
	public boolean addTeacher(String sql) {
		try {
			st.execute(sql);
			return true;
		}
		
		catch(SQLException e) {
			e.printStackTrace();
			//return false;
		}
		return true;
	}
	
	public boolean loginCheck(String username,String password){
		
		 try{
	         check="SELECT * FROM admininfo WHERE userName='"+username+"' AND password='"+password+"'";
	         res=st.executeQuery(check);	 
	         while(res.next()){
	        	 return true;
	         }
				 
		 }
		 catch(Exception r){
			System.out.println(r);
		 }	
		 return false;
	}
	
	public ArrayList<User> getUsers(String sql){
			ArrayList<User> list=new ArrayList<User>();
			
			try {
				res=st.executeQuery(sql);
				while(res.next()) {
					User u=new User();
					u.username=res.getString("username");
					u.position=res.getString("position");
					u.phone=res.getString("phone");
					list.add(u);
				}
			}
			catch (SQLException e){
				e.printStackTrace();
			}
			return list;
		}
	
	
	public ArrayList<Student> getStudent(String query){
		ArrayList<Student> lst=new ArrayList<Student>();
		
		try {
			res=st.executeQuery(query);
			while(res.next()) {
				Student s=new Student();
				s.name=res.getString("name");
				s.id=res.getInt("id");
				s.classname=res.getString("Class");
				s.fname=res.getString("fother's name");
				s.fno=res.getString("fother's no");
				s.mname=res.getString("Mother's name");
				s.fno=res.getString("Mother's no");
				s.address=res.getString("Address");
				lst.add(s);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return lst;
	}
	public void deleteStudent(int id) {
		try {
			st.executeUpdate("DELETE FROM `student` WHERE `student`.`id` ='"+id+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}

	public ArrayList<Teacher> getTeacher(String query) {
			ArrayList<Teacher> teacherList=new ArrayList<Teacher>();
					try {
						res=st.executeQuery(query);
						while(res.next()){
							Teacher t=new Teacher();
							t.tname=res.getString("Name");
							t.tid=res.getInt("id");
							t.tmail=res.getString("mail");
							t.tphone=res.getString("phone");
							t.taddress=res.getString("address");
							t.tjoindate=res.getString("Joining Date");
							teacherList.add(t);
						}
					}
					catch (SQLException e){
						e.printStackTrace();
					}
					return teacherList;
		
	}
	
	public void deleteTeacher(int id) {
		try {
			st.executeUpdate("DELETE FROM `teacherinfo` WHERE `teacherinfo`.`id` = '"+id+"'");
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	
}
	
	
	
	
	
	
	
	
	
	

	
