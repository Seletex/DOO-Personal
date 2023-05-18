package co.edu.uco.publiuco.data.dao.relational;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.publiuco.crosscutting.exception.PubliUcoDataException;
import co.edu.uco.publiuco.crosscutting.utils.UtilSql;


public abstract class SQLDAO<E> {
	private Connection connection;

	protected final Connection getConnection() {
		return connection;
	}

	private void setConnection(Connection connection) {
		if(!UtilSql.connectionIsOpen(connection)) {
			var userMessage = "Se ha presentado un problema tratando de llevar a cabo la operación sobre el Estado del Tipo Relacion Institucion. Porfavor intentelo de nuevo y si el problema persiste contacte al administrador ";
		var technicalMessage = "No se ha podido crear el EstadoTipoRelacionInstitucionSQLServerDAO , debido a la mconexion no esta abierta ";
		throw PubliUcoDataException.create(technicalMessage, userMessage); 
		}
		this.connection = connection;
	}

	protected abstract String prepareSelec();
	protected abstract String prepareFrom();
	protected abstract String prepareWhere(E entity, List<Object> parameters);
	protected abstract String prepareStringOrderBy();

	
}
