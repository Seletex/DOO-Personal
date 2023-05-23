package co.edu.uco.publiuco.data.dao.factory.relational.postgresql;

import java.sql.Connection;

import co.edu.uco.publiuco.crosscutting.utils.UtilSql;
import co.edu.uco.publiuco.data.dao.EstadoTipoRelacionInstitucionDAO;
import co.edu.uco.publiuco.data.dao.TipoRelacionInstitucionDAO;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;


public final class PostgreSQLDAOFactory  extends DAOFactory{

	private Connection connection;
	
	 public PostgreSQLDAOFactory() {
		abrirConexion();
	}
	@Override
	protected final void abrirConexion() {
	connection = null;
		
	}

	@Override
	public final void cerrarConexion() {
		UtilSql.closeConnection(connection);
		
	}

	@Override
	public final void initTransaction() {
	
		
	}

	@Override
	public final void commitTransaction() {

 }

	@Override
	public final void cancelarTransaccion() {
		
		
	}

	@Override
	public final EstadoTipoRelacionInstitucionDAO getEstadoTipoRelacionInstitucionDAO() {
	
		return null;
	}

	@Override
	public final TipoRelacionInstitucionDAO geTipoRelacionInstitucionDAO() {
	
		return null;
	}

}
