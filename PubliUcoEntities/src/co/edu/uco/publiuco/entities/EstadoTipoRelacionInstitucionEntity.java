package co.edu.uco.publiuco.entities;

import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

public final class EstadoTipoRelacionInstitucionEntity {

	private UUID idenficador;
	private String nombre;
	private String descripcion;

	public EstadoTipoRelacionInstitucionEntity(UUID idenficador, String nombre, String descripcion) {

		setIdenficador(idenficador);
		setNombre(nombre);
		setDescripcion(descripcion);

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

}
