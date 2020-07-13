package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	private static Properties p = new Properties();

	public static Connection getConnection() throws Exception {
		FileReader reader = null;
		try {
			//remember: change conf.properties file path by your own
			reader = new FileReader("C:\\Users\\picci\\Documents\\repository\\biblioteca\\libraryon\\WebContent\\WEB-INF\\conf.properties");

			p.load(reader);
		} catch (FileNotFoundException e) {
			throw new Exception("File conf.properties non trovato" + "\nCopiare il file in: " + new java.io.File("").getAbsolutePath());
		} catch (IOException e) {
			throw new Exception(e.getMessage());
		}

		String user = p.getProperty("user");
		String password = p.getProperty("password");
		String jdbc = p.getProperty("jdbc");
		String indirizzo = p.getProperty("indirizzo");
		String porta = p.getProperty("porta");
		String db = p.getProperty("db");

		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:" + jdbc + "://" + indirizzo + ":" + porta + "/" + db + "?serverTimezone=UTC";

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}

		return conn;
	}

}
