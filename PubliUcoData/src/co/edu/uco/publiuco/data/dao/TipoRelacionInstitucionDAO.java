package co.edu.uco.publiuco.data.dao;

import java.util.List;

import co.edu.uco.publiuco.entities.TipoRelacionInstitucionEntity;

public interface TipoRelacionInstitucionDAO {
	
void create(TipoRelacionInstitucionEntity entity);
	
	List <TipoRelacionInstitucionEntity> read(TipoRelacionInstitucionEntity entity);
	
	void update(TipoRelacionInstitucionEntity entity);
	
	void delete(TipoRelacionInstitucionEntity entity);

}
