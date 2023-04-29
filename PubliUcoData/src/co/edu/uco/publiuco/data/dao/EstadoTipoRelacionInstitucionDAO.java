package co.edu.uco.publiuco.data.dao;

import java.util.List;

import co.edu.uco.publiuco.entities.EstadoTipoRelacionInstitucionEntity;

public interface EstadoTipoRelacionInstitucionDAO {
	
	void create(EstadoTipoRelacionInstitucionEntity entity);
	
	List <EstadoTipoRelacionInstitucionEntity> read(EstadoTipoRelacionInstitucionEntity entity);
	
	void update(EstadoTipoRelacionInstitucionEntity entity);
	
	void delete(EstadoTipoRelacionInstitucionEntity entity);

}
