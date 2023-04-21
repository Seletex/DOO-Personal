package co.edu.uco.publiuco.dto;

import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

import static co.edu.uco.publiuco.crosscutting.utils.UtilText.getUtilText;


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
		setIdenficador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.getDefaultValue());
		setDescripcion(UtilText.EMPTY);// Quitar el ""
	}
	
	public static EstadoTipoRelacionInstitucionDTO crete() {
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

	@Override
	public String toString() {
		return "EstadoTipoRelacionInstitucionDTO [idenficador=" + idenficador + ",\\n nombre=" + nombre + ",\n descripcion="
				+ descripcion + "]";
	}
	
	public static void main(String[] args) {
		EstadoTipoRelacionInstitucionDTO objeto = new EstadoTipoRelacionInstitucionDTO();
		objeto.setIdenficador(UtilUUID.genereteNewUUID());
		objeto.setNombre("Docente");
		objeto.setDescripcion("Soy docente");
		
		System.out.println(objeto);
		
		EstadoTipoRelacionInstitucionDTO objetoDosDto =EstadoTipoRelacionInstitucionDTO.crete().setDescripcion("Soy Docente")
				.setIdenficador(UtilUUID.genereteNewUUID())
				.setNombre("Docente");
		
		System.out.println(objetoDosDto);
	}
	
	

}
