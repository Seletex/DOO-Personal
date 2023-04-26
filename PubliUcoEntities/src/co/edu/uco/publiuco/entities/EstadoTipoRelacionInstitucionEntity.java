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

	public EstadoTipoRelacionInstitucionEntity() {
		
		setIdenficador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.getDefaultValue());
		setDescripcion(UtilText.EMPTY);// Quitar el ""
	}
	
	public static EstadoTipoRelacionInstitucionEntity crete() {
		return new EstadoTipoRelacionInstitucionEntity();
	}

	public final UUID getIdenficador() {
		return idenficador;
	}

	public final EstadoTipoRelacionInstitucionEntity setIdenficador(final UUID idenficador) {
		this.idenficador = UtilUUID.getDefault(idenficador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final EstadoTipoRelacionInstitucionEntity setNombre(final String nombre) {
		
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final EstadoTipoRelacionInstitucionEntity setDescripcion(final String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}

	
	
	

}
