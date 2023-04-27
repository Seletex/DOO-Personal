package co.edu.uco.publiuco.business.assembler;

public interface Assembler<D, T, E> {

	T toDTOFromDomain(D domain);

	D toDomainFromDTO(T dto);

	E toEntityFromDomain(D domain);

	D toDomainFromEntity(E entity);

}
