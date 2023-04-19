package co.edu.uco.publiuco.dto;

import java.util.UUID;

public final class EstadoTipoRelacionInstitucionDTO {

	private UUID idenficador;
	private String nombre;
	private String descripcion;
	private static final String EMPTY = "";
	
	
	public EstadoTipoRelacionInstitucionDTO(UUID idenficador, String nombre, String descripcion) {
		super();
		setIdenficador(idenficador);
		setNombre(nombre);
		setDescripcion(descripcion);
		
	}
	
	
	public EstadoTipoRelacionInstitucionDTO() {
		super();
		setIdenficador(idenficador);
		setNombre(EMPTY);
		setDescripcion(EMPTY);//Quitar el ""
	}


	public final UUID getIdenficador() {
		return idenficador;
	}
	public final  EstadoTipoRelacionInstitucionDTO setIdenficador(final UUID idenficador) {
		this.idenficador = idenficador;
		return this;
	}
	public final String getNombre() {
		return nombre;
	}
	public final EstadoTipoRelacionInstitucionDTO setNombre(final String nombre) {
		
		this.nombre = isNotNull(nombre);
		return this;
	}
	public final String getDescripcion() {
		return descripcion;
	}
	public final EstadoTipoRelacionInstitucionDTO setDescripcion(final String descripcion) {
		this.descripcion = isNotNull(descripcion);
		return this;
	}
	
	public String isNotNull(String palabra) {
		if(palabra.isEmpty()) {
			return "is null or empty";
		}else {
			return String.format("(/{0}/ is neither null nor empty", palabra != null);
		}
		
	}
	
}
