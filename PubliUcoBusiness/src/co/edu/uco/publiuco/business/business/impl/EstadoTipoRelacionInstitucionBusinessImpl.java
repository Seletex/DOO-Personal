package co.edu.uco.publiuco.business.business.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoTipoRelacionInstitucionAssembler;
import co.edu.uco.publiuco.business.business.EstadoTipoRelacionInstitucionBusiness;
import co.edu.uco.publiuco.business.domain.EstadoTipoRelacionInstitucionDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoTipoRelacionInstitucionEntity;

public final class EstadoTipoRelacionInstitucionBusinessImpl implements EstadoTipoRelacionInstitucionBusiness {

	private DAOFactory daoFactory;

	public EstadoTipoRelacionInstitucionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public final void register(EstadoTipoRelacionInstitucionDomain domain) {
		final EstadoTipoRelacionInstitucionEntity entity =
				EstadoTipoRelacionInstitucionAssembler
				.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoTipoRelacionInstitucionDAO()
		.create(entity);

	}

	@Override
	public final List<EstadoTipoRelacionInstitucionDomain> list(EstadoTipoRelacionInstitucionDomain domain) {
		
		final EstadoTipoRelacionInstitucionEntity entity =
				EstadoTipoRelacionInstitucionAssembler
				.getInstance().toEntityFromDomain(domain);
		final List<EstadoTipoRelacionInstitucionEntity> resultEntities = daoFactory.
				getEstadoTipoRelacionInstitucionDAO().read(entity);
		return EstadoTipoRelacionInstitucionAssembler.getInstance().
				toDomainListFromEntityList(resultEntities);
	
	}

	@Override
	public final void modify(EstadoTipoRelacionInstitucionDomain domain) {
		final EstadoTipoRelacionInstitucionEntity entity =
				EstadoTipoRelacionInstitucionAssembler
				.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoTipoRelacionInstitucionDAO()
		.update(entity);

	}

	@Override
	public final void drop(EstadoTipoRelacionInstitucionDomain domain) {
		final EstadoTipoRelacionInstitucionEntity entity =
				EstadoTipoRelacionInstitucionAssembler
				.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoTipoRelacionInstitucionDAO()
		.delete(entity);

	}

}
