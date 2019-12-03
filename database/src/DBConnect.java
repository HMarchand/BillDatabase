import java.sql.*;
public class DBConnect {
	public DBConnect() {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url="jdbc:ucanaccess://C:/Users/heathermarchand/eclipse-workspace/database/DB/database1.accdb";
			Connection conn= DriverManager.getConnection(url);
			Statement s= conn.createStatement();
			System.out.println("Connection Successful");
			
			ResultSet rs= s.executeQuery("SELECT * FROM [tblUsers]");
			while(rs.next())
				System.out.println(rs.getString(1));
		}catch(Exception e) {
		e.printStackTrace();
		System.out.println("Unable to Connect");
	}
	}

}
