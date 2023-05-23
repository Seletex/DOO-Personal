package co.edu.uco.publiuco.data.dao.factory.relational.sqlserver;

import java.sql.Connection;

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
		connection = null;
	}

	@Override
	public final void cerrarConexion() {
		
		
	}

	@Override
	public final void initTransaction() {
		//setAutoCommit = false
		
	}

	@Override
	public final void commitTransaction() {
		//Commit
	}

	@Override
	public void cancelarTransaccion() {
		
		
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
