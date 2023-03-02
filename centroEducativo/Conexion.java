package centroEducativo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexion {

	private static Connection conexion = null;
	
	
	public static Connection getConexion () throws SQLException {
		// Si es la primera vez que accedemos a la conexi�n, debemos instanciarla
		if (conexion == null) {
			conectar();
		}
		// Compruebo si la conexi�n sigue estando activa
		while (!conexion.isValid(5)) {
			conectar();
		}
		
		return conexion;
	}
	
	
	
	private static void conectar () throws SQLException {
		String driver = JDBCProperties.getProperty("JDBC_DRIVER_CLASS");
		String user =  JDBCProperties.getProperty("JDBC_USER");
		String password =  JDBCProperties.getProperty("JDBC_PASSWORD");
		String host =  JDBCProperties.getProperty("JDBC_HOST");
		String schema =  JDBCProperties.getProperty("JDBC_SCHEMA_NAME");
		String properties =  JDBCProperties.getProperty("JDBC_PROPERTIES");

		
		try {
			Class.forName(driver);
		   
			conexion = (Connection) DriverManager.getConnection ("jdbc:mysql://" + host + "/" + schema + properties, user, password);			   
		}
		catch (ClassNotFoundException ex) {
			System.out.println("Imposible acceder al driver Mysql");
		}
	}
}
