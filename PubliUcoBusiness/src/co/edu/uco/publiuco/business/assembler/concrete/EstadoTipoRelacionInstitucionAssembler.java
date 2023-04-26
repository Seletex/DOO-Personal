package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.EstadoTipoRelacionInstitucionDomain;
import co.edu.uco.publiuco.dto.EstadoTipoRelacionInstitucionDTO;
import co.edu.uco.publiuco.entities.EstadoTipoRelacionInstitucionEntity;

public class EstadoTipoRelacionInstitucionAssembler implements
		Assembler<EstadoTipoRelacionInstitucionDomain, EstadoTipoRelacionInstitucionDTO, EstadoTipoRelacionInstitucionEntity> {

	@Override
	public EstadoTipoRelacionInstitucionDTO toDTOFromDomain(EstadoTipoRelacionInstitucionDomain domain) {
		return EstadoTipoRelacionInstitucionDTO.crete().setIdenficador(domain.getIdenficador())
				.setNombre(domain.getNombre()).setDescripcion(domain.getDescripcion());

	}

	@Override
	public EstadoTipoRelacionInstitucionDomain toDomainFromDTO(EstadoTipoRelacionInstitucionDTO dto) {
		return new EstadoTipoRelacionInstitucionDomain(dto.getIdenficador(), dto.getNombre(), dto.getDescripcion());
	}

	@Override
	public EstadoTipoRelacionInstitucionEntity toEntityFromDomain(EstadoTipoRelacionInstitucionDomain domain) {
		return new EstadoTipoRelacionInstitucionEntity(domain.getIdenficador(), domain.getNombre(),
				domain.getDescripcion());
	}

	@Override
	public EstadoTipoRelacionInstitucionDomain toDomainFromEntity(EstadoTipoRelacionInstitucionEntity entity) {
		return new EstadoTipoRelacionInstitucionDomain(entity.getIdenficador(), entity.getNombre(),
				entity.getDescripcion());
	}

}
