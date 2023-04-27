package co.edu.uco.publiuco.entities;

import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

public class TipoRelacionInstitucionEntity {

	private UUID idenficador;
	private String nombre;
	private String descripcion;
	private EstadoTipoRelacionInstitucionEntity estado;

	public TipoRelacionInstitucionEntity
	(final UUID idenficador,final String nombre,
			final String descripcion, final
			EstadoTipoRelacionInstitucionEntity estado) {

		setIdenficador(idenficador);
		setNombre(nombre);
		setDescripcion(descripcion);
		setEstado(estado);

	}

	

	public static TipoRelacionInstitucionEntity create(final UUID idenficador,final String nombre,
			final String descripcion,
			EstadoTipoRelacionInstitucionEntity estado) {
		return new TipoRelacionInstitucionEntity(idenficador, nombre, descripcion, estado);
	}

	public final UUID getIdenficador() {
		return idenficador;
	}

	private final void setIdenficador(final UUID idenficador) {
		this.idenficador = UtilUUID.getDefault(idenficador);
	
	}

	public final String getNombre() {
		return nombre;
	}

	private final void setNombre(final String nombre) {

		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		
	}

	public final String getDescripcion() {
		return descripcion;
	}

	private final void setDescripcion(final String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		
	}

	public EstadoTipoRelacionInstitucionEntity getEstado() {
		return estado;
	}

	private void setEstado(EstadoTipoRelacionInstitucionEntity estado) {
		this.estado = UtilObject.getDefault(estado,
				EstadoTipoRelacionInstitucionEntity.getDefaultObject());
		
	}
}