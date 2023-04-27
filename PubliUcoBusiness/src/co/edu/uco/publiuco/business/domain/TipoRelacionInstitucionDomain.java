package co.edu.uco.publiuco.business.domain;

import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;


public class TipoRelacionInstitucionDomain {

	private UUID idenficador;
	private String nombre;
	private String descripcion;
	private EstadoTipoRelacionInstitucionDomain estado;

	public TipoRelacionInstitucionDomain
	(final UUID idenficador,final String nombre,
			final String descripcion, final
			TipoRelacionInstitucionDomain estado) {

		setIdenficador(idenficador);
		setNombre(nombre);
		setDescripcion(descripcion);
		setEstado(estado);

	}

	

	public static TipoRelacionInstitucionDomain create(final UUID idenficador,final String nombre,
			final String descripcion,
			TipoRelacionInstitucionDomain estado) {
		return new TipoRelacionInstitucionDomain(idenficador, nombre, descripcion, estado);
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

	public EstadoTipoRelacionInstitucionDomain getEstado() {
		return estado;
	}

	private void setEstado(TipoRelacionInstitucionDomain estado2) {
		this.estado = (EstadoTipoRelacionInstitucionDomain) UtilObject.getDefault(estado2,
				EstadoTipoRelacionInstitucionDomain.getDefaultObject()
				);
		
	}

}
