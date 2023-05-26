package co.edu.uco.publiuco.data.dao.relational;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import co.edu.uco.publiuco.crosscutting.exception.PubliUcoDataException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.SQLDAOMessage;
import co.edu.uco.publiuco.crosscutting.utils.UtilSql;


public abstract class SQLDAO<E> {
	private Connection connection;

	protected final Connection getConnection() {
		return connection;
	}

	protected final void setConnection(final Connection connection) {
		if(!UtilSql.connectionIsOpen(connection)) {
		throw PubliUcoDataException.create(SQLDAOMessage.TECHNICAL_PROBLEM_SQL_DAO_PROBLEM_STRING, SQLDAOMessage.USER_PROBLEM_SQL_DAO_PROBLEM_STRING); 
		}
		this.connection = connection;
	}

	protected abstract String prepareSelec();
	protected abstract String prepareFrom();
	protected abstract String prepareWhere(E entity, List<Object> parameters);
	protected abstract String prepareStringOrderBy();
	protected abstract void setParameters(PreparedStatement preparedStatement, List<Object> parameters);
	protected abstract List<E> executeQuery(PreparedStatement preparedStatement);
	
}
