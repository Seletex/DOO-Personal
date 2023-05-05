package co.edu.uco.publiuco.business.business;

import java.util.List;


import co.edu.uco.publiuco.business.domain.TipoRelacionInstitucionDomain;

public interface TipoRelacionInstitucionBusiness {
	
	void register(TipoRelacionInstitucionDomain domain);
	
	List<TipoRelacionInstitucionDomain>list (TipoRelacionInstitucionDomain domain);

	void modify(TipoRelacionInstitucionDomain domain);
	
	void drop(TipoRelacionInstitucionDomain domain );

}
