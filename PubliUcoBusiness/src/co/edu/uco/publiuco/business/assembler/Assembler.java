package co.edu.uco.publiuco.business.assembler;

import co.edu.uco.publiuco.entities.EstadoTipoRelacionInstitucionEntity;

public interface Assembler<D, T, E> {

	T toDTOFromDomain(D domain);

	D toDomainFromDTO(T dto);

	E toEntityFromDomain(D domain);

	D toDomainFromEntity(E entity);

	EstadoTipoRelacionInstitucionDomain toDomainFromEntity(EstadoTipoRelacionInstitucionEntity entity);


}
