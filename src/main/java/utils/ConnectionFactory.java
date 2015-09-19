package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	private static String driver = "com.mysql.jdbc.Driver";
	private static String dburl="jdbc:mysql://localhost:3306/ssh_training";
	private static String user="root";
	private static String password="123456";
	
	private static final ConnectionFactory factory = new ConnectionFactory();
	
	private Connection conn;
	
	static {
		Properties prop = new Properties();
		try {
			InputStream is = ConnectionFactory.class.getClassLoader().getResourceAsStream("com/hand/dbconfig.properties");
			prop.load(is);
			
		} catch (IOException e) {
			System.out.println("=======配置文件读取出错=======");
			e.printStackTrace();
		}
		driver = prop.getProperty("driver");
		dburl = prop.getProperty("dburl");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
	}
	
	private ConnectionFactory(){}
	
	public static ConnectionFactory getInstance(){
		return factory;
	}
	
	public Connection makeConnection(){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}