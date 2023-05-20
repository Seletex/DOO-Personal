package co.edu.uco.publiuco.entities;

import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

public final class EstadoTipoRelacionInstitucionEntity {

	private static final EstadoTipoRelacionInstitucionEntity DEFAULT_OBJECT = new EstadoTipoRelacionInstitucionEntity();
	private UUID idenficador;
	private String nombre;
	private String descripcion;

	private EstadoTipoRelacionInstitucionEntity() {
		super();
		setIdenficador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.getDefaultValue());
		setDescripcion(UtilText.EMPTY);// Quitar el ""
	}

	public EstadoTipoRelacionInstitucionEntity(final UUID idenficador, final String nombre, final String descripcion) {
		super();
		setIdenficador(idenficador);
		setNombre(nombre);
		setDescripcion(descripcion);

	}

	public static final  EstadoTipoRelacionInstitucionEntity createWithIdentificador(final UUID idenficador) {
		return new EstadoTipoRelacionInstitucionEntity(idenficador, UtilText.getDefaultValue(),UtilText.EMPTY);
		
	}
		public static final  EstadoTipoRelacionInstitucionEntity createWithNombrer(final String nombre) {
			return new EstadoTipoRelacionInstitucionEntity(UtilUUID.DEFAULT_UUID,nombre,UtilText.EMPTY);
		}
			public static final  EstadoTipoRelacionInstitucionEntity createWithDescripcion(final String descripcion) {
				return new EstadoTipoRelacionInstitucionEntity(UtilUUID.DEFAULT_UUID, UtilText.EMPTY,descripcion);
	}

	public static EstadoTipoRelacionInstitucionEntity getDefaultObject() {
		return DEFAULT_OBJECT;
	}

	public static EstadoTipoRelacionInstitucionEntity create(final UUID idenficador, final String nombre,
			final String descripcion) {
		return new EstadoTipoRelacionInstitucionEntity(idenficador, nombre, descripcion);
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
