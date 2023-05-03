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

	public static boolean connectionIsOpen(final Connection connection) {
		if (UtilObject.isNull(connection)) {

			var userMessage = UtilSqlMessage.CONNECTION_IS_OPEN_USER_MESSAGE_STRING;
			var technicalMessage = UtilSqlMessage.CONNECTION_IS_OPEN_TECHNICAL_NULL_CONNECTION_STRING;
			throw PubliUcoCrossCuttingException.create(technicalMessage, userMessage);
		}

		try {
			return !connection.isClosed();
		} catch (SQLException exception) {
			var userMessage = UtilSqlMessage.CONNECTION_IS_OPEN_USER_MESSAGE_STRING;
			var technicalMessage = UtilSqlMessage.CONNECTION_IS_OPEN_TECHNICAL_SQL_EXCEPTION_STRING;;
			throw PubliUcoCrossCuttingException.create(technicalMessage, userMessage, exception);
		} catch (final Exception exception) {
			var userMessage = UtilSqlMessage.CONNECTION_IS_OPEN_USER_MESSAGE_STRING;
			var technicalMessage = UtilSqlMessage.CONNECTION_IS_OPEN_TECHNICAL_EXCEPTION_STRING;;
			throw PubliUcoCrossCuttingException.create(technicalMessage, userMessage, exception);
		}
	}
	
	public static final void closeConnection(final Connection connection) {
	try {
		if(!connectionIsOpen(connection)) {
			connection.close();
		}
	}catch (PubliUcoCrossCuttingException exception) {
		throw exception;
	}
	catch (SQLException exception) {
			var userMessage = UtilSqlMessage.CONNECTION_IS_OPEN_USER_MESSAGE_STRING;
			var technicalMessage = UtilSqlMessage.CONNECTION_IS_OPEN_TECHNICAL_SQL_EXCEPTION_STRING;;
			throw PubliUcoCrossCuttingException.create(technicalMessage, userMessage, exception);
		} catch (final Exception exception) {
			var userMessage = UtilSqlMessage.CONNECTION_IS_OPEN_USER_MESSAGE_STRING;
			var technicalMessage = UtilSqlMessage.CONNECTION_IS_OPEN_TECHNICAL_EXCEPTION_STRING;;
			throw PubliUcoCrossCuttingException.create(technicalMessage, userMessage, exception);
		}
	}

}
