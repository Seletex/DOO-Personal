package co.edu.uco.publiuco.data.dao.relational.sqlserver;

import java.awt.datatransfer.StringSelection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uco.publiuco.crosscutting.exception.PubliUcoDataException;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import co.edu.uco.publiuco.data.dao.EstadoTipoRelacionInstitucionDAO;
import co.edu.uco.publiuco.data.dao.relational.SQLDAO;
import co.edu.uco.publiuco.entities.EstadoTipoRelacionInstitucionEntity;

public final class EstadoTipoRelacionInstitucionSQLServerDAO extends SQLDAO<EstadoTipoRelacionInstitucionEntity>
		implements EstadoTipoRelacionInstitucionDAO {

	public EstadoTipoRelacionInstitucionSQLServerDAO(final Connection connection) {

	}

	@Override
	public final void create(final EstadoTipoRelacionInstitucionEntity entity) {
		var sqlStatement = "INSERT INTO EstadoTipoRelacionInstitucion (identificacion, nombre, descripcion)";
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {
			preparedStatement.setObject(1, entity.getIdenficador());
			preparedStatement.setObject(2, entity.getNombre());
			preparedStatement.setObject(3, entity.getDescripcion());

			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			var userMessage = "Se ha presentado un problema tratando de registra la informacion del nuevo estado ETRI ";

			var technicalMessage = "Se ha presentado un problema de tipo SQL EXCEPTIONdentro del metodo de la clase create de ETRI SQL server DAO. Porfavor verifica la traza completa del error";

			throw PubliUcoDataException.create(technicalMessage, userMessage, exception);

		} catch (final Exception exception) {
			var userMessage = "Se ha presentado un problema inesperado tratando de registra la informacion del nuevo estado ETRI ";

			var technicalMessage = "Se ha presentado un problema inesperado de tipo SQL EXCEPTIONdentro del metodo de la clase create de ETRI SQL server DAO. Porfavor verifica la traza completa del error";

			throw PubliUcoDataException.create(technicalMessage, userMessage, exception);

		}

	}

	@Override
	public final List<EstadoTipoRelacionInstitucionEntity> read(final EstadoTipoRelacionInstitucionEntity entity) {
		var sqlStatement = new StringBuilder();
		var parameters = new ArrayList<>();
		sqlStatement.append(prepareSelec());
		sqlStatement.append(prepareFrom());
		sqlStatement.append(prepareWhere(entity, parameters));
		sqlStatement.append(prepareStringOrderBy());
		
		try (var preparedStatement =  getConnection().prepareStatement(sqlStatement.toString())){
			
		}catch (SQLException exception) {
			// TODO: handle exception
		}catch (Exception exception) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public final void update(final EstadoTipoRelacionInstitucionEntity entity) {
		var sqlStatement = "UPDATE EstadoTipoRelacionInstitucion SET nombre = ?,descripcion = ? WHERE Identificador = ?";
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setObject(2, entity.getNombre());
			preparedStatement.setObject(3, entity.getDescripcion());

			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			var userMessage = "Se ha presentado un problema tratando de modificar la informacion del nuevo estado ETRI ";

			var technicalMessage = "Se ha presentado un problema de tipo SQL EXCEPTIONdentro del metodo de la clase update de ETRI SQL server DAO. Porfavor verifica la traza completa del error";

			throw PubliUcoDataException.create(technicalMessage, userMessage, exception);

		} catch (final Exception exception) {
			var userMessage = "Se ha presentado un problema inesperado tratando de registra la informacion del nuevo estado ETRI ";

			var technicalMessage = "Se ha presentado un problema inesperado de tipo SQL EXCEPTIONdentro del metodo de la clase create de ETRI SQL server DAO. Porfavor verifica la traza completa del error";

			throw PubliUcoDataException.create(technicalMessage, userMessage, exception);
		}

	}

	@Override
	public final void delete(final EstadoTipoRelacionInstitucionEntity entity) {
		var sqlStatement = "DELETE FROM EstadoTipoRelacionInstitucion WHERE Identificador = ?";
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setObject(1, entity.getIdenficador());

			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			var userMessage = "Se ha presentado un problema tratando de dar de baja la informacion del nuevo estado ETRI ";

			var technicalMessage = "Se ha presentado un problema de tipo SQL EXCEPTIONdentro del metodo de la clase delete de ETRI SQL server DAO. Porfavor verifica la traza completa del error";

			throw PubliUcoDataException.create(technicalMessage, userMessage, exception);

		} catch (final Exception exception) {
			var userMessage = "Se ha presentado un problema inesperado tratando de dar de baja la informacion del nuevo estado ETRI ";

			var technicalMessage = "Se ha presentado un problema inesperado de tipo SQL EXCEPTIONdentro del metodo de la clase delete de ETRI SQL server DAO. Porfavor verifica la traza completa del error";

			throw PubliUcoDataException.create(technicalMessage, userMessage, exception);

		}
	}

	@Override
	protected String prepareSelec() {

		return "SELECT identificacion, nombre, descripcion ";
	}

	@Override
	protected String prepareFrom() {

		return "FROM EstadoTipoRElacionInstitucion";
	}

	@Override
	protected String prepareWhere(EstadoTipoRelacionInstitucionEntity entity, List<Object> parameters) {
		parameters=UtilObject.getDefault(parameters, new ArrayList<>());
		final var where = new StringBuilder("");
		var setWhere = true;
		if (!UtilObject.isNull(entity)) {
			if (!UtilUUID.isDefaut(entity.getIdenficador())) {
				parameters.add(entity.getIdenficador());
				where.append("WHERE identificador=?");
				setWhere = false;
			}
			if (UtilText.getUtilText().isEmpty(entity.getNombre())) {
				parameters.add(entity.getNombre());
				where.append(setWhere ? "WHERE ":" AND ").append(" nombre=? ");
				setWhere = false;
			}

			if (UtilText.getUtilText().isEmpty(entity.getDescripcion())) {
				parameters.add(entity.getDescripcion());
				where.append(setWhere ? "WHERE ":" AND ").append("descripcion LIKE %?% ");
			}
		}
		return where.toString();
	}

	@Override
	protected String prepareStringOrderBy() {
		
		return "ORDER BY nombre ASC";
	}

}
