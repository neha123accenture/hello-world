package learntrix;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Person {

	public static void main(String[] args) {
		System.out.println("Incrementing the primary key of a table");
		Connection con = null;
		String url ="jdbc:mysql://localhost:3306/";
		String db = "learntrix";
		String driver = "com.mysql.jdbc.Driver";
		int key =0;
		try {
			Class.forName(driver);//to register the driver class
			con = DriverManager.getConnection(url + db ,"root" ,"Generali7$");//to establish connection with the database
			try {
				Statement st = con.createStatement();//used to create statement ,object of statement is responsible to execute queries with the database.
				ResultSet query = st.executeQuery("Select max(ID) from jdbctest.person having count(*)>0");//to execute queries to the database
				if(query.next()) {
					key = query.getInt("max(ID)") + 1;
				}
				else {
					key = key +1;
				}
				String sql = "insert into jdbctest.person " + "values ( " + key + "," + "'Neha'" + "," + "'Sahu'"
				+ "," + "'Delhi'" +"," + "'2019-08-01'  )";
				
			System.out.println(sql);
			int val = st.executeUpdate(sql);
			System.out.println("1 row affected + return value: " + val );
			}
			catch (SQLException s) {
				System.out.println("Sql statment is not exectued :Error is  " + s.getMessage());
			}
			
		}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
}
