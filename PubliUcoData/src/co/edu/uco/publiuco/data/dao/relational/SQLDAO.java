package co.edu.uco.publiuco.data.dao.relational;

import java.sql.Connection;impor co.edu.uco.publiuco.crosscutting.util.UtilSql;

public abstract class SQLDAO {
	private Connection connection;

	protected final Connection getConnection() {
		return connection;
	}

	private final void setConnection(final Connection connection) {
		if(UtilSQL.connectionis)
		this.connection = connection;
	}
	
}
