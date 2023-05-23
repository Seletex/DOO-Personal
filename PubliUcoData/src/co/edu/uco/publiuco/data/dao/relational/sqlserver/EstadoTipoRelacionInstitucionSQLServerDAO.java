package co.edu.uco.publiuco.data.dao.relational.sqlserver;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.exception.PubliUcoDataException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.EstadoTipoRelacionInstitucionSQLServerDAOMEssage;
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
		final var sqlStatement = "INSERT INTO EstadoTipoRelacionInstitucion (identificacion, nombre, descripcion)";
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {
			preparedStatement.setObject(1, entity.getIdenficador());
			preparedStatement.setObject(2, entity.getNombre());
			preparedStatement.setObject(3, entity.getDescripcion());

			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
			
			throw PubliUcoDataException.create(EstadoTipoRelacionInstitucionSQLServerDAOMEssage.TECHNICAL_PROBLEM_CREATE_SQLEXCEPTION,EstadoTipoRelacionInstitucionSQLServerDAOMEssage.USER_PROBLEM_CREATE_SQLEXCEPTION, exception);

		} catch (final Exception exception) {
			
			throw PubliUcoDataException.create(EstadoTipoRelacionInstitucionSQLServerDAOMEssage.TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_SQLEXCEPTION, EstadoTipoRelacionInstitucionSQLServerDAOMEssage.USER_UNEXPECTED_PROBLEM_UPDATE_SQLEXCEPTION, exception);

		}

	}

	@Override
	public final List<EstadoTipoRelacionInstitucionEntity> read(final EstadoTipoRelacionInstitucionEntity entity) {
		final var sqlStatement = new StringBuilder();
		final var parameters = new ArrayList<>();
		sqlStatement.append(prepareSelec());
		sqlStatement.append(prepareFrom());
		sqlStatement.append(prepareWhere(entity, parameters));
		sqlStatement.append(prepareStringOrderBy());

		try (var preparedStatement = getConnection().prepareStatement(sqlStatement.toString())) {
			setParameters(preparedStatement, parameters);
			return executeQuery(preparedStatement);
		} catch (final PubliUcoException exception) {
			
			throw exception;
		} catch (final SQLException exception) {


			throw PubliUcoDataException.create(EstadoTipoRelacionInstitucionSQLServerDAOMEssage.TECHNICAL_PROBLEM_READ_SQLEXCEPTION, EstadoTipoRelacionInstitucionSQLServerDAOMEssage.USER_PROBLEM_READ_SQLEXCEPTION, exception);

		} catch (final Exception exception) {
	
			throw PubliUcoDataException.create(EstadoTipoRelacionInstitucionSQLServerDAOMEssage.TECHNICAL_UNEXPECTED_PROBLEM_READ_SQLEXCEPTION, EstadoTipoRelacionInstitucionSQLServerDAOMEssage.USER_UNEXPECTED_PROBLEM_READ_SQLEXCEPTION, exception);

		}
		
	}

	@Override
	public final void update(final EstadoTipoRelacionInstitucionEntity entity) {
		final var sqlStatement = "UPDATE EstadoTipoRelacionInstitucion SET nombre = ?,descripcion = ? WHERE Identificador = ?";
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setObject(2, entity.getNombre());
			preparedStatement.setObject(3, entity.getDescripcion());

			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {
		
			throw PubliUcoDataException.create(EstadoTipoRelacionInstitucionSQLServerDAOMEssage.TECHNICAL_PROBLEM_UPDATE_SQLEXCEPTION, EstadoTipoRelacionInstitucionSQLServerDAOMEssage.TECHNICAL_PROBLEM_UPDATE_SQLEXCEPTION, exception);

		} catch (final Exception exception) {


			throw PubliUcoDataException.create(EstadoTipoRelacionInstitucionSQLServerDAOMEssage.TECHNICAL_UNEXPECTED_PROBLEM_UPDATE_SQLEXCEPTION, EstadoTipoRelacionInstitucionSQLServerDAOMEssage.USER_UNEXPECTED_PROBLEM_UPDATE_SQLEXCEPTION, exception);
		}

	}

	@Override
	public final void delete(final EstadoTipoRelacionInstitucionEntity entity) {
		final var sqlStatement = "DELETE FROM EstadoTipoRelacionInstitucion WHERE Identificador = ?";
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {

			preparedStatement.setObject(1, entity.getIdenficador());

			preparedStatement.executeUpdate();
		} catch (final SQLException exception) {

		
			throw PubliUcoDataException.create(EstadoTipoRelacionInstitucionSQLServerDAOMEssage.TECHNICAL_PROBLEM_DELETE_SQLEXCEPTION, EstadoTipoRelacionInstitucionSQLServerDAOMEssage.USER_PROBLEM_DELETE_SQLEXCEPTION, exception);

		} catch (final Exception exception) {

			throw PubliUcoDataException.create(EstadoTipoRelacionInstitucionSQLServerDAOMEssage.TECHNICAL_UNEXPECTED_PROBLEM_DELETE_SQLEXCEPTION, EstadoTipoRelacionInstitucionSQLServerDAOMEssage.USER_UNEXPECTED_PROBLEM_DELETE_SQLEXCEPTION, exception);

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
		parameters = UtilObject.getDefault(parameters, new ArrayList<>());
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
				where.append(setWhere ? "WHERE " : " AND ").append(" nombre=? ");
				setWhere = false;
			}

			if (UtilText.getUtilText().isEmpty(entity.getDescripcion())) {
				parameters.add(entity.getDescripcion());
				where.append(setWhere ? "WHERE " : " AND ").append("descripcion LIKE %?% ");
			}
		}
		return where.toString();
	}

	@Override
	protected String prepareStringOrderBy() {

		return "ORDER BY nombre ASC";
	}

	@Override
	protected void setParameters(PreparedStatement preparedStatement, List<Object> parameters) {
		try {
			if (!UtilObject.isNull(parameters) && !UtilObject.isNull(preparedStatement)) {
				for (int index = 0; index < parameters.size(); index++) {
					preparedStatement.setObject(index + 1, parameters.get(index));
				}
			}
		} catch (final SQLException exception) {
			
			throw PubliUcoDataException.create(EstadoTipoRelacionInstitucionSQLServerDAOMEssage.TECHNICAL_PROBLEM_READ_SETWHERE_SQLEXCEPTION, EstadoTipoRelacionInstitucionSQLServerDAOMEssage.USER_PROBLEM_READ_SETWHERE_SQLEXCEPTION, exception);

		} catch (final Exception exception) {
			
			throw PubliUcoDataException.create(EstadoTipoRelacionInstitucionSQLServerDAOMEssage.TECHNICAL_PROBLEM_READ_SETWHERE_SQLEXCEPTION, EstadoTipoRelacionInstitucionSQLServerDAOMEssage.USER_UNEXPECTED_PROBLEM_READ_SETWHERE_SQLEXCEPTION, exception);

		}

	}

	@Override
	protected List<EstadoTipoRelacionInstitucionEntity> executeQuery(PreparedStatement preparedStatement) {
		final List<EstadoTipoRelacionInstitucionEntity> resultEntities = new ArrayList<>();
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
			final 	var entityTmp = new EstadoTipoRelacionInstitucionEntity(
						resultSet.getObject("identificador", UUID.class), resultSet.getString("nombre"),
						resultSet.getString("descripcion"));
				resultEntities.add(entityTmp);
			}
			
			return resultEntities;
		} catch (final SQLException exception) {
			var userMessage = "Se ha presentado un problema tratando de dar de consultar la informacion de los estados tipo relacion institucion... ";

			var technicalMessage = "Se ha presentado un problema de tipo SQL EXCEPTIONdentro del metodo de la clase setParameters de ETRI SQL server DAO. Porfavor verifica la traza completa del error";

			throw PubliUcoDataException.create(technicalMessage, userMessage, exception);

		} catch (final Exception exception) {
			var userMessage = "Se ha presentado un problema inesperado tratando de dar de consutar la informacion del nuevo estado ETRI ";

			var technicalMessage = "Se ha presentado un problema inesperado de tipo setParameters dentro del metodo de la clase delete de ETRI SQL server DAO. Porfavor verifica la traza completa del error";

			throw PubliUcoDataException.create(technicalMessage, userMessage, exception);

		}
		
	}

}
