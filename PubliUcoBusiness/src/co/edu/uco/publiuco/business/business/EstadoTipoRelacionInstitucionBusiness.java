package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.EstadoTipoRelacionInstitucionDomain;

public interface EstadoTipoRelacionInstitucionBusiness {

	void register(EstadoTipoRelacionInstitucionDomain domain);
	
	List<EstadoTipoRelacionInstitucionDomain>list (EstadoTipoRelacionInstitucionDomain domain);

	void modify(EstadoTipoRelacionInstitucionDomain domain);
	
	void drop(EstadoTipoRelacionInstitucionDomain domain );
}
