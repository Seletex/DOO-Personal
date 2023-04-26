package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.TipoRelacionInstitucionDomain;
import co.edu.uco.publiuco.dto.TipoRelacionInstitucionDTO;
import co.edu.uco.publiuco.entities.EstadoTipoRelacionInstitucionEntity;
import co.edu.uco.publiuco.entities.TipoRelacionInstitucionEntity;

public class TipoRelacionInstitucionAssembler implements
Assembler<TipoRelacionInstitucionDomain, TipoRelacionInstitucionDTO, TipoRelacionInstitucionEntity> {

@Override
public TipoRelacionInstitucionDTO toDTOFromDomain(TipoRelacionInstitucionDomain domain) {
return TipoRelacionInstitucionDTO.crete().setIdenficador(domain.getIdenficador())
		.setNombre(domain.getNombre()).setDescripcion(domain.getDescripcion());

}

@Override
public TipoRelacionInstitucionDomain toDomainFromDTO(TipoRelacionInstitucionDTO dto) {
return new TipoRelacionInstitucionDomain(dto.getIdenficador(), dto.getNombre(), dto.getDescripcion());
}

@Override
public TipoRelacionInstitucionEntity toEntityFromDomain(TipoRelacionInstitucionDomain domain) {
return new TipoRelacionInstitucionEntity(domain.getIdenficador(), domain.getNombre(),
		domain.getDescripcion());
}

@Override
public EstadoTipoRelacionInstitucionDomain toDomainFromEntity(EstadoTipoRelacionInstitucionEntity entity) {
return new EstadoTipoRelacionInstitucionDomain(entity.getIdenficador(), entity.getNombre(),
		entity.getDescripcion());
}
}
