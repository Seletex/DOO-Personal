package co.edu.uco.publiuco.data.dao.factory.relational.postgresql;

import java.sql.Connection;

import co.edu.uco.publiuco.crosscutting.utils.UtilSql;
import co.edu.uco.publiuco.data.dao.EstadoTipoRelacionInstitucionDAO;
import co.edu.uco.publiuco.data.dao.TipoRelacionInstitucionDAO;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;


public final class PostgreSQLDAOFactory  extends DAOFactory{

	private Connection connection;
	
	 public PostgreSQLDAOFactory() {
		abrirConexion();// TODO Auto-generated constructor stub
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
	public final void iniciarTransaccion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void confirmarTransaccion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void cancelarTransaccion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final EstadoTipoRelacionInstitucionDAO getEstadoTipoRelacionInstitucionDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final TipoRelacionInstitucionDAO geTipoRelacionInstitucionDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
