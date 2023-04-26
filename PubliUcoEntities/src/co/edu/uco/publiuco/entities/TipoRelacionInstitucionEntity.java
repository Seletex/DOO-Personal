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

	public TipoRelacionInstitucionEntity(UUID idenficador, String nombre, String descripcion) {

		setIdenficador(idenficador);
		setNombre(nombre);
		setDescripcion(descripcion);
		

	}

	public TipoRelacionInstitucionEntity(UUID idenficador, String nombre, String descripcion,
			EstadoTipoRelacionInstitucionEntity estado) {

		setIdenficador(idenficador);
		setNombre(nombre);
		setDescripcion(descripcion);
		setEstado(estado);

	}

	public TipoRelacionInstitucionEntity() {

		setIdenficador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.getDefaultValue());
		setDescripcion(UtilText.EMPTY);// Quitar el ""
	}

	public static TipoRelacionInstitucionEntity crete() {
		return new TipoRelacionInstitucionEntity();
	}

	public final UUID getIdenficador() {
		return idenficador;
	}

	public final TipoRelacionInstitucionEntity setIdenficador(final UUID idenficador) {
		this.idenficador = UtilUUID.getDefault(idenficador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final TipoRelacionInstitucionEntity setNombre(final String nombre) {

		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final TipoRelacionInstitucionEntity setDescripcion(final String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}

	public TipoRelacionInstitucionEntity getEstado() {
		return estado;
	}

	public TipoRelacionInstitucionEntity setEstado(EstadoTipoRelacionInstitucionEntity estado) {
		this.estado = UtilObject.getDefault(estado, EstadoTipoRelacionInstitucionEntity.crete());
		return this;
	}
}