package co.edu.uco.publiuco.business.assembler.concrete;


import java.util.List;


import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.EstadoTipoRelacionInstitucionDomain;
import co.edu.uco.publiuco.dto.EstadoTipoRelacionInstitucionDTO;
import co.edu.uco.publiuco.entities.EstadoTipoRelacionInstitucionEntity;

public class EstadoTipoRelacionInstitucionAssembler implements
		Assembler<EstadoTipoRelacionInstitucionDomain, EstadoTipoRelacionInstitucionDTO, EstadoTipoRelacionInstitucionEntity> {

	private static final Assembler<EstadoTipoRelacionInstitucionDomain, EstadoTipoRelacionInstitucionDTO, EstadoTipoRelacionInstitucionEntity> INSTANCE_ASSEMBLER = new EstadoTipoRelacionInstitucionAssembler();

	private EstadoTipoRelacionInstitucionAssembler() {

	}

	public static final Assembler<EstadoTipoRelacionInstitucionDomain, EstadoTipoRelacionInstitucionDTO, EstadoTipoRelacionInstitucionEntity> getInstance() {
		return INSTANCE_ASSEMBLER;
	}

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

	@Override
	public final List<EstadoTipoRelacionInstitucionDomain> toDomainListFromEntityList(
			final List<EstadoTipoRelacionInstitucionEntity> entityList) {

		return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();

	}

	@Override
	public List<EstadoTipoRelacionInstitucionDTO> toDTOListFromDomainList(EstadoTipoRelacionInstitucionDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

}
