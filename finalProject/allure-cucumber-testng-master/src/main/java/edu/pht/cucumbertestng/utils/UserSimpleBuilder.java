package edu.pht.cucumbertestng.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import edu.pht.cucumbertestng.beans.User;

public class UserSimpleBuilder {

	private static final Logger logger = Logger.getLogger(UserSimpleBuilder.class);

	public User build() {
		User user = new User();
		logger.info("Create user with data from data base.....");
		String sql = "select login, domain, password from user";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = Connector.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user.setLogin(rs.getString("login"));
				user.setDomain(rs.getString("domain"));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			logger.error("sql exc....." + e.getMessage(), e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					logger.error("sql exc rs close....." + e.getMessage(), e);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					logger.error("sql exc pstmt close....." + e.getMessage(), e);
				}
			}
			Connector.closeConnection();
		}
		return user;
	}
}
