package co.edu.uco.publiuco.dto;

import java.util.UUID;

import static co.edu.uco.publiuco.crosscutting.utils.UtilText.getUtilText;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.EMPTY;

public final class EstadoTipoRelacionInstitucionDTO {

	private UUID idenficador;
	private String nombre;
	private String descripcion;

	public EstadoTipoRelacionInstitucionDTO(UUID idenficador, String nombre, String descripcion) {
		super();
		setIdenficador(idenficador);
		setNombre(nombre);
		setDescripcion(descripcion);

	}

	public EstadoTipoRelacionInstitucionDTO() {
		super();
		setIdenficador(idenficador);
		setNombre(getUtilText().getDefaultValue(nombre));
		setDescripcion(EMPTY);// Quitar el ""
	}

	public final UUID getIdenficador() {
		return idenficador;
	}

	public final EstadoTipoRelacionInstitucionDTO setIdenficador(final UUID idenficador) {
		this.idenficador = idenficador;
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final EstadoTipoRelacionInstitucionDTO setNombre(final String nombre) {
		
		this.nombre = getUtilText().applyTrim(nombre);
		return this;
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final EstadoTipoRelacionInstitucionDTO setDescripcion(final String descripcion) {
		this.descripcion = getUtilText().applyTrim(descripcion);
		return this;
	}

}
