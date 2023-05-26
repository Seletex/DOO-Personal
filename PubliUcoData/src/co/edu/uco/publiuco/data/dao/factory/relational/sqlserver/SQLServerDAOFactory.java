package co.edu.uco.publiuco.data.dao.factory.relational.sqlserver;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.publiuco.crosscutting.utils.UtilSql;
import co.edu.uco.publiuco.data.dao.EstadoTipoRelacionInstitucionDAO;
import co.edu.uco.publiuco.data.dao.TipoRelacionInstitucionDAO;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.relational.sqlserver.EstadoTipoRelacionInstitucionSQLServerDAO;
import co.edu.uco.publiuco.data.dao.relational.sqlserver.TipoRelacionInstitucionSQLServerDAO;

public final class SQLServerDAOFactory extends DAOFactory{

	private Connection connection;
	
	public SQLServerDAOFactory() {
		abrirConexion();
	}
	
	@Override
	protected final void abrirConexion() {
	UtilSql.connectionIsOpen(connection);
	}

	@Override
	public final void cerrarConexion() {
		
		UtilSql.closeConnection(connection);
	}

	@Override
	public final void initTransaction() {
		try {
			UtilSql.initTransaction(connection);
		} catch (SQLException exception) {
			
		}
		
	}

	@Override
	public final void commitTransaction() {
		UtilSql.commitTransaction(connection);
	}

	@Override
	public void cancelarTransaccion() {
		try {
			UtilSql.rollBackTransaction(connection);
		} catch (SQLException e) {
			
		}
		
	}

	@Override
	public EstadoTipoRelacionInstitucionDAO getEstadoTipoRelacionInstitucionDAO() {
		return new EstadoTipoRelacionInstitucionSQLServerDAO(connection);
	}

	@Override
	public TipoRelacionInstitucionDAO geTipoRelacionInstitucionDAO() {
		
		return new TipoRelacionInstitucionSQLServerDAO(connection);
	}

}
