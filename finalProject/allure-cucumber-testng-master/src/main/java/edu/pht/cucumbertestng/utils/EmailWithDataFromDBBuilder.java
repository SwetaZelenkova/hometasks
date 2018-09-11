package edu.pht.cucumbertestng.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class EmailWithDataFromDBBuilder extends EmailBuilder {

	private static final Logger logger = Logger.getLogger(EmailWithDataFromDBBuilder.class);
	private int id;
	private String email;
	private String moreEmails;
	private String subject;
	private String body;

	public EmailWithDataFromDBBuilder() {
	}

	public EmailWithDataFromDBBuilder init(int id) {
		this.id = id;
		logger.info("Connection initialization finished.....");
		String sql = "select email, moreemails, subject, body from emaildata where id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = Connector.getConnection().prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				email = rs.getString("email");
				moreEmails = rs.getString("moreEmails");
				subject = rs.getString("subject");
				body = rs.getString("body");
			}
		} catch (SQLException e) {
			logger.info("sql exc....." + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					logger.info("sql exc rs close....." + e.getMessage());
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					logger.info("sql exc pstmt close....." + e.getMessage());
				}
			}
			Connector.closeConnection();
		}
		return this;
	}

	@Override
	public void buildEmail() {
		emailObj.setEmail(email);
	}

	@Override
	public void buildmoreEmails() {
		emailObj.setMoreEmails(moreEmails);
	}

	@Override
	public void buildSubject() {
		emailObj.setSubject(subject);
	}

	@Override
	public void buildBody() {
		emailObj.setBody(body);
	}

}
