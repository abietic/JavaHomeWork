import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.derby.iapi.sql.ResultSet;
import org.apache.derby.iapi.sql.Statement;

public class DBTest {

	static String select = "select sno , name , sex , salary from employee";
	public static String emp = "('2017' , 'XingXH' , 'female' , 650)";
	static String CreatTable = "create table employee(sno varchar(4) , name varchar(8) , sex varchar(10) , salary float)";
	static String[] employees = {"('1001' , 'ZhangQ' , 'male' , 675.20)" , "('1004' , 'LiX' , 'female' , 842.00)" , "('1007' , 'WangDS' , 'male' , 765.00)" , "('1010' , 'ZhaoYH' , 'female' , 690.00)"}; 
	Connection cn = null;
	java.sql.Statement statement = null;
	java.sql.ResultSet res = null;
	public DBTest() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated constructor stub
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		cn = DriverManager.getConnection("jdbc:derby:helloDB;create=true");
		cn.setAutoCommit(false);
		statement = cn.createStatement();
		statement.execute(CreatTable);
		System.out.println(CreatTable);
		for (int i = 0 ; i < employees.length ; i ++) {
			statement.execute("insert into employee values" + employees[i]);
			System.out.println("insert " + i + " : " +employees[i]);
		}
		System.out.println("Initiate Completed");
	}
	public void queryMale() throws SQLException {
		res = statement.executeQuery(select + " where sex = 'male'");
		showResult();
		return;
	}
	public void addEmployee(String emp) throws SQLException {
		statement.execute("insert into employee values" + emp);
		res = statement.executeQuery(select);
		showResult();
		return;
	}
	public void updateEmployee() throws SQLException {
		statement.execute("update employee set salary = 900 where sno = '2017'");
		res = statement.executeQuery(select);
		showResult();
		return;
	}
	private void showResult() throws SQLException {
		if (res == null) {
			return;
		}
		while (res.next()) {
			StringBuilder builder = new StringBuilder("");
			int i = 0;
			for (i = 1 ; i < 4 ; i ++) {
				builder.append(res.getString(i) + "\t");
			}
			builder.append(res.getFloat(i));
			System.out.println(builder);
		}
		res.close();
		res = null;
		System.out.println("resultset closed");
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		String drop = "drop table employee";
		statement.execute(drop);
		System.out.println(drop);
		statement.close();
		System.out.println("closed statement");
		cn.commit();
		cn.close();
		System.out.println("commited transaction and closed connection");
		DriverManager.getConnection("jdbc:derby:;shutdown=true");
		super.finalize();
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		DBTest tes = new DBTest();
		tes.queryMale();
		tes.addEmployee(emp);
		tes.updateEmployee();
	}

}
