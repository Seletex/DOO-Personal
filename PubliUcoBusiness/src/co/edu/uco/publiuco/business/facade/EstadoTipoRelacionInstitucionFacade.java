package co.edu.uco.publiuco.business.facade;

import java.util.List;

import co.edu.uco.publiuco.dto.EstadoTipoRelacionInstitucionDTO;

public interface EstadoTipoRelacionInstitucionFacade {

	void register(EstadoTipoRelacionInstitucionDTO dto);

	List<EstadoTipoRelacionInstitucionDTO> list(EstadoTipoRelacionInstitucionDTO dto);

	void modify(EstadoTipoRelacionInstitucionDTO dto);

	void drop(EstadoTipoRelacionInstitucionDTO dto);
}
