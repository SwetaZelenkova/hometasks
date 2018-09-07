package edu.pht.cucumberjunit.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Connector {

	private static final Logger logger = Logger.getLogger(Connector.class);
	private static final String FILE_WITH_DB_PARAMS = "DBParams.properties";
	private static Connection dbConnection;

	private Connector() {
	}

	public static Connection getConnection() {
		try {
			if (dbConnection == null || dbConnection.isClosed()) {
				Properties props = new Properties();
				props.load(new FileInputStream(FILE_WITH_DB_PARAMS));
				Class.forName(props.getProperty("DB_DRIVER"));

				dbConnection = DriverManager.getConnection(props.getProperty("DB_URL"),
						props.getProperty("DB_USERNAME"), props.getProperty("DB_PASSWORD"));
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			if (e instanceof ClassNotFoundException) {
				logger.info("class..not..found.." + e.getMessage());
			} else if (e instanceof IOException) {
				logger.info("i/o..exc.." + e.getMessage());
			} else if (e instanceof SQLException) {
				logger.info("sql..exc.." + e.getMessage());
			}
		}
		return dbConnection;
	}

	public static void closeConnection() {
		try {
			if (dbConnection != null && !dbConnection.isClosed()) {
				dbConnection.close();
			}
		} catch (SQLException e) {
			logger.info("sql..exc..by..closed.." + e.getMessage());
		}
	}
}
