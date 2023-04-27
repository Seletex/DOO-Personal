package co.edu.uco.publiuco.dto;

import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

public class TipoRelacionInstitucionDTO {

	private UUID idenficador;
	private String nombre;
	private String descripcion;
	private EstadoTipoRelacionInstitucionDTO estado;

	public TipoRelacionInstitucionDTO(UUID idenficador, String nombre, String descripcion,
			EstadoTipoRelacionInstitucionDTO estado) {

		setIdenficador(idenficador);
		setNombre(nombre);
		setDescripcion(descripcion);
		setEstado(estado);

	}

	public TipoRelacionInstitucionDTO() {

		setIdenficador(UtilUUID.DEFAULT_UUID);
		setNombre(UtilText.getDefaultValue());
		setDescripcion(UtilText.EMPTY);// Quitar el ""
		setEstado(EstadoTipoRelacionInstitucionDTO.crete());
	}

	public static TipoRelacionInstitucionDTO crete() {
		return new TipoRelacionInstitucionDTO();
	}

	public final UUID getIdenficador() {
		return idenficador;
	}

	public final TipoRelacionInstitucionDTO setIdenficador(final UUID idenficador) {
		this.idenficador = UtilUUID.getDefault(idenficador);
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final TipoRelacionInstitucionDTO setNombre(final String nombre) {

		this.nombre = UtilText.getUtilText().applyTrim(nombre);
		return this;
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final TipoRelacionInstitucionDTO setDescripcion(final String descripcion) {
		this.descripcion = UtilText.getUtilText().applyTrim(descripcion);
		return this;
	}

	public final EstadoTipoRelacionInstitucionDTO getEstado() {
		return estado;
	}

	public final TipoRelacionInstitucionDTO setEstado(EstadoTipoRelacionInstitucionDTO estado) {
		this.estado = UtilObject.getDefault(estado, EstadoTipoRelacionInstitucionDTO.crete());
		return this;
	}

}
