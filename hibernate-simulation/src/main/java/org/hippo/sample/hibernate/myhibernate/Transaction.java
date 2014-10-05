package org.hippo.sample.hibernate.myhibernate;

import java.sql.Connection;
import java.sql.SQLException;

public class Transaction {

	public Transaction(Connection connection) {
		this.connection = connection;
	}
	
	public void begin() {
		// Do nothing
	}
	
	public void commit() throws SQLException {
		connection.commit();
	}
	
	private Connection connection;
}
