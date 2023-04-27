package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.EstadoTipoRelacionInstitucionDomain;
import co.edu.uco.publiuco.business.domain.TipoRelacionInstitucionDomain;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.EMPTY;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import co.edu.uco.publiuco.dto.EstadoTipoRelacionInstitucionDTO;
import co.edu.uco.publiuco.dto.TipoRelacionInstitucionDTO;
import co.edu.uco.publiuco.entities.EstadoTipoRelacionInstitucionEntity;
import co.edu.uco.publiuco.entities.TipoRelacionInstitucionEntity;

public class TipoRelacionInstitucionAssembler
		implements Assembler<TipoRelacionInstitucionDomain, TipoRelacionInstitucionDTO, TipoRelacionInstitucionEntity> {

	private static final Assembler<TipoRelacionInstitucionDomain, TipoRelacionInstitucionDTO, TipoRelacionInstitucionEntity> INSTANCE_ASSEMBLER = new TipoRelacionInstitucionAssembler();

	private TipoRelacionInstitucionAssembler() {

	}

	public static final Assembler<TipoRelacionInstitucionDomain, TipoRelacionInstitucionDTO, TipoRelacionInstitucionEntity> getInstance() {
		return INSTANCE_ASSEMBLER;
	}

	@Override
	public TipoRelacionInstitucionDTO toDTOFromDomain(TipoRelacionInstitucionDomain domain) {
		return TipoRelacionInstitucionDTO.crete().setIdenficador(domain.getIdenficador()).setNombre(domain.getNombre())
				.setEstado(EstadoTipoRelacionInstitucionAssembler.getInstance().toDTOFromDomain(domain.getEstado())).setDescripcion(domain.getDescripcion());

	}

	@Override
	public TipoRelacionInstitucionDomain toDomainFromDTO(TipoRelacionInstitucionDTO dto) {
		return new TipoRelacionInstitucionDomain(dto.getIdenficador(), dto.getNombre(), dto.getDescripcion(), null);
	}

	@Override
	public TipoRelacionInstitucionEntity toEntityFromDomain(TipoRelacionInstitucionDomain domain) {
		return new TipoRelacionInstitucionEntity(domain.getIdenficador(), domain.getNombre(), domain.getDescripcion(),
				EstadoTipoRelacionInstitucionEntity.create(UtilUUID.DEFAULT_UUID, UtilText.EMPTY, UtilText.EMPTY));
	}

	@Override
	public TipoRelacionInstitucionDomain toDomainFromEntity(TipoRelacionInstitucionEntity entity) {
		// TODO Auto-generated method stub
		return new TipoRelacionInstitucionDomain(entity.getIdenficador(), entity.getNombre(), entity.getDescripcion(), null);
	}
}
