package co.edu.uco.publiuco.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoTipoRelacionInstitucionAssembler;
import co.edu.uco.publiuco.business.business.EstadoTipoRelacionInstitucionBusiness;
import co.edu.uco.publiuco.business.domain.EstadoTipoRelacionInstitucionDomain;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.EstadoTipoRelacionInstitucionBusinessImplMessage;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;
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
			throw PubliUcoBusinessException.create(EstadoTipoRelacionInstitucionBusinessImplMessage.CREATE_EXCEPTION_PROBLEM_BUSINESS_IMPLEMENTATION_STRING);
		}
		
		//final var domainToCreate = new EstadoTipoRelacionInstitucionDomain(idenficador,domain.getNombre(),domain.getDescripcion());
		
		
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
		String nombre;
		
		EstadoTipoRelacionInstitucionEntity entityTmp;
		List<EstadoTipoRelacionInstitucionEntity> resultEntities;
		do {
		nombre = UtilText.getDefaultValue();
			entityTmp =  EstadoTipoRelacionInstitucionEntity.createWithNombrer(nombre);
			resultEntities = daoFactory.getEstadoTipoRelacionInstitucionDAO().read(entityTmp);
		} while (!resultEntities.isEmpty());
		entityTmp= EstadoTipoRelacionInstitucionEntity.createWithDescripcion(domain.getNombre());
		resultEntities = daoFactory.getEstadoTipoRelacionInstitucionDAO().read(entityTmp);
		
		if(!resultEntities.isEmpty()) {
			throw PubliUcoBusinessException.create(EstadoTipoRelacionInstitucionBusinessImplMessage.UPDATE_EXCEPTION_PROBLEM_BUSINESS_IMPLEMENTATION_STRING);
		}
		
		final EstadoTipoRelacionInstitucionEntity entity = EstadoTipoRelacionInstitucionAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getEstadoTipoRelacionInstitucionDAO().update(entity);

	}

	@Override
	public final void drop(EstadoTipoRelacionInstitucionDomain domain) {
		UUID idenficador;
		EstadoTipoRelacionInstitucionEntity entityTmp;
		List<EstadoTipoRelacionInstitucionEntity> resultEntities;
		do {
			idenficador = UtilUUID.genereteNewUUID();
			entityTmp =  EstadoTipoRelacionInstitucionEntity.createWithIdentificador(idenficador);
			resultEntities = daoFactory.getEstadoTipoRelacionInstitucionDAO().read(entityTmp);
		} while (!resultEntities.isEmpty());
	
		
		if(!resultEntities.isEmpty()) {
			throw PubliUcoBusinessException.create(EstadoTipoRelacionInstitucionBusinessImplMessage.DROP_EXCEPTION_PROBLEM_BUSINESS_IMPLEMENTATION_STRING);
		}
		
		final EstadoTipoRelacionInstitucionEntity entity = EstadoTipoRelacionInstitucionAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getEstadoTipoRelacionInstitucionDAO().delete(entity);

	}

}
