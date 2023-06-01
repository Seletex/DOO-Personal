package co.edu.uco.publiuco.dto;

import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

public final class EstadoTipoRelacionInstitucionDTO {

	private UUID idenficador;
	private String nombre;
	private String descripcion;

	public EstadoTipoRelacionInstitucionDTO(UUID idenficador, String nombre, String descripcion) {

		setIdenficador(idenficador);
		setNombre(nombre);
		setDescripcion(descripcion);

	}

	public EstadoTipoRelacionInstitucionDTO() {

		setIdenficador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.getDefaultValue());
		setDescripcion(UtilText.EMPTY);// Quitar el ""
	}

	public static EstadoTipoRelacionInstitucionDTO crete() {
		return new EstadoTipoRelacionInstitucionDTO();
	}

	public static EstadoTipoRelacionInstitucionDTO crete(UUID idenficador, String nombre, String descripcion) {
		return new EstadoTipoRelacionInstitucionDTO();
	}
	
	public final UUID getIdenficador() {
		return idenficador;
	}

	public final EstadoTipoRelacionInstitucionDTO setIdenficador(final UUID idenficador) {
		this.idenficador = UtilUUID.getDefault(idenficador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final EstadoTipoRelacionInstitucionDTO setNombre(final String nombre) {

		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final EstadoTipoRelacionInstitucionDTO setDescripcion(final String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}

}
