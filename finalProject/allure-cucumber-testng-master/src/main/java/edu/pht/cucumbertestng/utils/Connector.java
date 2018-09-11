package edu.pht.cucumbertestng.utils;

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
				logger.debug("Connection opened..");
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			if (e instanceof ClassNotFoundException) {
				logger.error("class..not..load..");
				logger.trace(e.getMessage(), e);
			} else if (e instanceof IOException) {
				logger.error("i/o..exc..");
				logger.trace(e.getMessage(), e);
			} else if (e instanceof SQLException) {
				logger.error("sql..exc..");
				logger.trace(e.getMessage(), e);
			}
		}
		return dbConnection;
	}

	public static void closeConnection() {
		try {
			if (dbConnection != null && !dbConnection.isClosed()) {
				dbConnection.close();
				logger.debug("Connection closed..");
			}
		} catch (SQLException e) {
			logger.warn("sql..exc..by..closed..expensive..resource..is..not..closed");
			logger.trace(e.getMessage(), e);
		}
	}
}
