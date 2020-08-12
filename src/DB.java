import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;



public class DB{ 
	
	
	private Connection conn=null;
	
	
	private String dbURL;
	
	
	public DB() {
	
	
	dbURL = 
			"jdbc:sqlserver://DESKTOP-V59KGGG\\SQLEXPRESS;"
			+"database=Northwid;"
			+"user=sa;"
			+"password=123456;"
			+"encrypt=false;"
			+"trustServerCertificate=false;"
			+"loginTimeout=30;";

}
	
	public DB(String connection) {
		
		dbURL=connection;
		
	}
	
	
	public String getCustomerCount() {
		
		String count=null;
		
		try {
			conn = DriverManager.getConnection(dbURL);
			
			if(conn != null) {
				
				String countQuery = "select count(*) as count from customers;";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(countQuery);
				
				while(rs.next()) {
					count = rs.getString("count");
			}
				
	}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			try {
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return count;
		}
	
	
	public String getCompanyNames() {
		
		String result="";
		
		try {
			conn = DriverManager.getConnection(dbURL);
			
			if(conn != null) {
	}
			String countQuery = "select companyname from customers;";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(countQuery);
			
			while(rs.next()) {
				result += rs.getString("companyname");
				result += "\n";
			}
		
	}catch(SQLException ex) {
		ex.printStackTrace();
	}finally {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
	}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}

		}
	
		return result;
}
}