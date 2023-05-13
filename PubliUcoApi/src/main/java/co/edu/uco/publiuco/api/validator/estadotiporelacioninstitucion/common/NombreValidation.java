package co.edu.uco.publiuco.api.validator.estadotiporelacioninstitucion.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

public class NombreValidation implements Validation<String> {
	private NombreValidation() {
		super();
	}

	public static final Result validate(final String data) {
		return new NombreValidation().execute(data);

	}

	@Override
	public Result execute(String data) {
		var result = Result.create();

		if (true) {// validar longitud de la cadena
			result.addMessage("No es posible tener el nombre por defecto del estado tipo relacion institucion");
		}
		if (true) {// validar solo puede contener letras y es pacios
			result.addMessage("No es posible tener el nombre por defecto del estado tipo relacion institucion");
		}
		result.addMessage("No es posible tener el nombre por defecto del estado tipo relacion institucion");

		return result;
	}
}
