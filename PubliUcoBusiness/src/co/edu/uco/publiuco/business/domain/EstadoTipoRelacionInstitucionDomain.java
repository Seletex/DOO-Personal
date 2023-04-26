package co.edu.uco.publiuco.business.domain;

import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;




public final class EstadoTipoRelacionInstitucionDomain {

	private UUID idenficador;
	private String nombre;
	private String descripcion;

	public EstadoTipoRelacionInstitucionDomain(UUID idenficador, String nombre, String descripcion) {
	
		setIdenficador(idenficador);
		setNombre(nombre);
		setDescripcion(descripcion);

	}

	public EstadoTipoRelacionInstitucionDomain() {
		
		setIdenficador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.getDefaultValue());
		setDescripcion(UtilText.EMPTY);// Quitar el ""
	}
	
	public static EstadoTipoRelacionInstitucionDomain crete() {
		return new EstadoTipoRelacionInstitucionDomain();
	}

	public final UUID getIdenficador() {
		return idenficador;
	}

	public final EstadoTipoRelacionInstitucionDomain setIdenficador(final UUID idenficador) {
		this.idenficador = UtilUUID.getDefault(idenficador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final EstadoTipoRelacionInstitucionDomain setNombre(final String nombre) {
		
		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final EstadoTipoRelacionInstitucionDomain setDescripcion(final String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}

	
	
	

}
