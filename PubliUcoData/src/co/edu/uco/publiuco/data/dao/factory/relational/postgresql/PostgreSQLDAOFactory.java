package co.edu.uco.publiuco.data.dao.factory.relational.postgresql;

import java.sql.Connection;
import java.sql.SQLException;

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
	public final EstadoTipoRelacionInstitucionDAO getEstadoTipoRelacionInstitucionDAO() {
	
		return null;
	}

	@Override
	public final TipoRelacionInstitucionDAO geTipoRelacionInstitucionDAO() {
	
		return null;
	}

}
