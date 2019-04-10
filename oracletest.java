
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class oracletest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Getting All Rows from a table!");
		Connection con = null;
		String serverName = "localhost";
	    String portNumber = "1521";
	    String db = "test";
	    String url =  "jdbc:oracle:thin:@"  + serverName + ":" + portNumber + ":" +db;
	    String user = "scott";
	    String pass = "tiger";
	    String driver = "oracle.jdbc.driver.OracleDriver";
		try{
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url, user, pass);
			try{
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("SELECT * FROM  dept");
				System.out.println("Department Code: " + "\t" + "deptno: ");
				while (res.next()) {
					int i = res.getInt("DEPTNO");
					String s = res.getString("DNAME");
					String s1 = res.getString("LOC");
					System.out.println(i + "\t\t" + s);
					System.out.println(i + "\t\t" + s1);
				}
				con.close();
			}
			catch (SQLException s){
				System.out.println("SQL code does not execute.");
			}		
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

}
