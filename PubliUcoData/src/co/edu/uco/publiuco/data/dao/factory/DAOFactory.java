package co.edu.uco.publiuco.data.dao.factory;

import co.edu.uco.publiuco.data.dao.EstadoTipoRelacionInstitucionDAO;
import co.edu.uco.publiuco.data.dao.TipoRelacionInstitucionDAO;
import co.edu.uco.publiuco.data.dao.factory.relational.postgresql.PostgreSQLDAOFactory;
import co.edu.uco.publiuco.data.dao.factory.relational.sqlserver.SQLServerDAOFactory;

public abstract class DAOFactory {

	public static DAOFactory getFactory(final Factory factory) {

		DAOFactory daoFactory;

		switch (factory) {
		case SQLSERVER: {
			daoFactory = new SQLServerDAOFactory();
			break;
		}
		case POSTGRESQL: {
			daoFactory = new PostgreSQLDAOFactory();
			break;
		}
		default:
			throw new IllegalArgumentException("Not Implemented yet!!" + factory);
		}
		
		return daoFactory;
	}

	protected abstract void abrirConexion();

	public abstract void cerrarConexion();

	public abstract void iniciarTransaccion();

	public abstract void confirmarTransaccion();

	public abstract void cancelarTransaccion();

	public abstract EstadoTipoRelacionInstitucionDAO getEstadoTipoRelacionInstitucionDAO();

	public abstract TipoRelacionInstitucionDAO geTipoRelacionInstitucionDAO();

}
