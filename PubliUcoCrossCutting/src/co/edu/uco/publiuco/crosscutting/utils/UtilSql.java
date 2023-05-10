package co.edu.uco.publiuco.crosscutting.utils;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.publiuco.crosscutting.exception.PubliUcoCrossCuttingException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.UtilSqlMessage;

public final class UtilSql {

	private UtilSql() {
		super();
	}

	public static final boolean connectionIsNull(final Connection connection) {
		return UtilObject.isNull(connection);
	}

	public static boolean connectionIsOpen(final Connection connection) {
		if (connectionIsNull(connection)) {

			var userMessage = UtilSqlMessage.CONNECTION_IS_OPEN_USER_MESSAGE_STRING;
			var technicalMessage = UtilSqlMessage.CONNECTION_IS_OPEN_TECHNICAL_NULL_CONNECTION_STRING;
			throw PubliUcoCrossCuttingException.create(technicalMessage, userMessage);
		}

		try {
			return !connection.isClosed();
		} catch (SQLException exception) {
			var userMessage = UtilSqlMessage.CONNECTION_IS_OPEN_USER_MESSAGE_STRING;
			var technicalMessage = UtilSqlMessage.CONNECTION_IS_OPEN_TECHNICAL_SQL_EXCEPTION_STRING;
			;
			throw PubliUcoCrossCuttingException.create(technicalMessage, userMessage, exception);
		} catch (final Exception exception) {
			var userMessage = UtilSqlMessage.CONNECTION_IS_OPEN_USER_MESSAGE_STRING;
			var technicalMessage = UtilSqlMessage.CONNECTION_IS_OPEN_TECHNICAL_EXCEPTION_STRING;
			;
			throw PubliUcoCrossCuttingException.create(technicalMessage, userMessage, exception);
		}
	}

	public static final void closeConnection(final Connection connection) {
		try {
			if (!connectionIsOpen(connection)) {
				connection.close();
			}
		} catch (PubliUcoCrossCuttingException exception) {
			throw exception;
		} catch (SQLException exception) {
			var userMessage = UtilSqlMessage.CONNECTION_IS_OPEN_USER_MESSAGE_STRING;
			var technicalMessage = UtilSqlMessage.CONNECTION_IS_OPEN_TECHNICAL_SQL_EXCEPTION_STRING;
			;
			throw PubliUcoCrossCuttingException.create(technicalMessage, userMessage, exception);
		} catch (final Exception exception) {
			var userMessage = UtilSqlMessage.CONNECTION_IS_OPEN_USER_MESSAGE_STRING;
			var technicalMessage = UtilSqlMessage.CONNECTION_IS_OPEN_TECHNICAL_EXCEPTION_STRING;
			;
			throw PubliUcoCrossCuttingException.create(technicalMessage, userMessage, exception);
		}
	}

	public static final void initTransaction(final Connection connection) throws SQLException {

		try {
			if (connectionIsOpen(connection)) {

				var userMessage = UtilSqlMessage.CONNECTION_IS_OPEN_USER_MESSAGE_STRING;
				var technicalMessage = UtilSqlMessage.CONNECTION_IS_OPEN_TECHNICAL_NULL_CONNECTION_STRING;
				throw PubliUcoCrossCuttingException.create(technicalMessage, userMessage);
			}

			connection.setAutoCommit(false);
		} catch (SQLException exception) {

			throw exception;
		} catch (final Exception exception) {
			var userMessage = UtilSqlMessage.CONNECTION_IS_OPEN_USER_MESSAGE_STRING;
			var technicalMessage = UtilSqlMessage.CONNECTION_IS_OPEN_TECHNICAL_EXCEPTION_STRING;
			;
			throw PubliUcoCrossCuttingException.create(technicalMessage, userMessage, exception);
		}

		// .createTechnicalException(Messages.SqlConnectionHelper.TECHNICAL_TRY_INIT_TRANSACTION,
		// exception);

	}

	public static final void commitTransaction(final Connection connection) {

		try {
			if (connectionIsOpen(connection)) {
				var userMessage = UtilSqlMessage.CONNECTION_IS_OPEN_USER_MESSAGE_STRING;
				var technicalMessage = UtilSqlMessage.CONNECTION_IS_OPEN_TECHNICAL_NULL_CONNECTION_STRING;
				throw PubliUcoCrossCuttingException.create(technicalMessage, userMessage);
						//Messages.UtilSqlMessage.TECHNICAL_CONNECTION_IS_CLOSED_FOR_COMMIT_TRANSACTION);
			}
			connection.setAutoCommit(false);
		} catch (PubliUcoCrossCuttingException exception) {
			throw exception;
		}

		catch (final SQLException exception) {
			var userMessage = UtilSqlMessage.CONNECTION_IS_OPEN_USER_MESSAGE_STRING;
			var technicalMessage = UtilSqlMessage.CONNECTION_IS_OPEN_TECHNICAL_NULL_CONNECTION_STRING;
			throw PubliUcoCrossCuttingException.create(technicalMessage, userMessage);
					//.createTechnicalException(Messages.UtilSqlMessage.TECHNICAL_TRY_INIT_TRANSACTION);
		}
		
		

	}
	
	public static final void rollBackTransaction(final Connection connection) throws SQLException {
		try {
			if(!connectionIsOpen(connection)) {
				var userMessage = UtilSqlMessage.CONNECTION_IS_OPEN_TECHNICAL_EXCEPTION_STRING;
				var technicalMessage = UtilSqlMessage.CONNECTION_IS_OPEN_TECHNICAL_NULL_CONNECTION_STRING;
				
				throw PubliUcoCrossCuttingException.create(technicalMessage, userMessage);
			}
			
			if(connection.getAutoCommit()) {
				var userMessage = UtilSqlMessage.CONNECTION_IS_OPEN_TECHNICAL_EXCEPTION_STRING;
				var technicalMessage = UtilSqlMessage.CONNECTION_IS_OPEN_TECHNICAL_NULL_CONNECTION_STRING;
			}
		}finally {
			
		}
	}
}
