package co.edu.uco.publiuco.business.business.impl;

import java.util.List;


import co.edu.uco.publiuco.business.assembler.concrete.TipoRelacionInstitucionAssembler;
import co.edu.uco.publiuco.business.business.TipoRelacionInstitucionBusiness;
import co.edu.uco.publiuco.business.domain.TipoRelacionInstitucionDomain;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoTipoRelacionInstitucionEntity;
import co.edu.uco.publiuco.entities.TipoRelacionInstitucionEntity;

public class TipoRelacionInstitucionBusinessImpl implements TipoRelacionInstitucionBusiness {

	private DAOFactory daoFactory;

	public TipoRelacionInstitucionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(TipoRelacionInstitucionDomain domain) {
		
		 
		
		final TipoRelacionInstitucionEntity entity =
				TipoRelacionInstitucionAssembler
				.getInstance().toEntityFromDomain(domain);
		daoFactory.geTipoRelacionInstitucionDAO()
		.create(entity);
		
	}

	@Override
	public List<TipoRelacionInstitucionDomain> list(TipoRelacionInstitucionDomain domain) {
		final TipoRelacionInstitucionEntity entity =
				TipoRelacionInstitucionAssembler
				.getInstance().toEntityFromDomain(domain);
		final List<TipoRelacionInstitucionEntity> resultEntities = daoFactory.
				geTipoRelacionInstitucionDAO().read(entity);
		return TipoRelacionInstitucionAssembler.getInstance().
				toDomainListFromEntityList(resultEntities);
	}

	@Override
	public void modify(TipoRelacionInstitucionDomain domain) {
		final TipoRelacionInstitucionEntity entity =
TipoRelacionInstitucionAssembler
				.getInstance().toEntityFromDomain(domain);
		daoFactory.geTipoRelacionInstitucionDAO()
		.update(entity);
		
	}

	@Override
	public void drop(TipoRelacionInstitucionDomain domain) {
		final TipoRelacionInstitucionEntity entity =
				TipoRelacionInstitucionAssembler
				.getInstance().toEntityFromDomain(domain);
		daoFactory.geTipoRelacionInstitucionDAO()
		.delete(entity);
		
	}

}
