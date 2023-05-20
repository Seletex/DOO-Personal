package co.edu.uco.publiuco.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoTipoRelacionInstitucionAssembler;
import co.edu.uco.publiuco.business.business.EstadoTipoRelacionInstitucionBusiness;
import co.edu.uco.publiuco.business.domain.EstadoTipoRelacionInstitucionDomain;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoTipoRelacionInstitucionEntity;

public final class EstadoTipoRelacionInstitucionBusinessImpl implements EstadoTipoRelacionInstitucionBusiness {

	private DAOFactory daoFactory;

	public EstadoTipoRelacionInstitucionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public final void register(EstadoTipoRelacionInstitucionDomain domain) {

		UUID idenficador;
		EstadoTipoRelacionInstitucionEntity entityTmp;
		List<EstadoTipoRelacionInstitucionEntity> resultEntities;
		do {
			idenficador = UtilUUID.genereteNewUUID();
			entityTmp =  EstadoTipoRelacionInstitucionEntity.createWithIdentificador(idenficador);
			resultEntities = daoFactory.getEstadoTipoRelacionInstitucionDAO().read(entityTmp);
		} while (!resultEntities.isEmpty());
		entityTmp= EstadoTipoRelacionInstitucionEntity.createWithNombrer(domain.getNombre());
		resultEntities = daoFactory.getEstadoTipoRelacionInstitucionDAO().read(entityTmp);
		
		if(!resultEntities.isEmpty()) {
			throw PubliUcoBusinessException.create("El estado de tipo relacion institucion que intenta crear ya existe, porfavor verific¡que los datos y de ser necesario proceda a actualizar");
		}
		
		final var domainToCreate = new EstadoTipoRelacionInstitucionDomain(idenficador,domain.getNombre(),domain.getDescripcion());
		
		
		final EstadoTipoRelacionInstitucionEntity entity = EstadoTipoRelacionInstitucionAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getEstadoTipoRelacionInstitucionDAO().create(entity);

	}

	@Override
	public final List<EstadoTipoRelacionInstitucionDomain> list(EstadoTipoRelacionInstitucionDomain domain) {

		final EstadoTipoRelacionInstitucionEntity entity = EstadoTipoRelacionInstitucionAssembler.getInstance()
				.toEntityFromDomain(domain);
		final List<EstadoTipoRelacionInstitucionEntity> resultEntities = daoFactory
				.getEstadoTipoRelacionInstitucionDAO().read(entity);
		return EstadoTipoRelacionInstitucionAssembler.getInstance().toDomainListFromEntityList(resultEntities);

	}

	@Override
	public final void modify(EstadoTipoRelacionInstitucionDomain domain) {
		final EstadoTipoRelacionInstitucionEntity entity = EstadoTipoRelacionInstitucionAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getEstadoTipoRelacionInstitucionDAO().update(entity);

	}

	@Override
	public final void drop(EstadoTipoRelacionInstitucionDomain domain) {
		final EstadoTipoRelacionInstitucionEntity entity = EstadoTipoRelacionInstitucionAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getEstadoTipoRelacionInstitucionDAO().delete(entity);

	}

}
